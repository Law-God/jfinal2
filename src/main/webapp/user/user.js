layui.use(['form', 'layedit', 'laydate','upload','AjaxUtil'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,AjaxUtil = layui.AjaxUtil
    ,upload = layui.upload;
    var $= layui.jquery;
        //日期
        laydate.render({
            elem: '#birthday_date',
            type : "date",
            format : 'yyyy-MM-dd',
            trigger : 'click',
            done: function(value, date){
                setTimeout(function(){
                    layuiBlurCheck($('#birthday_date'),verify);
                },100)
            }
        });

        //创建一个编辑器
        var summaryEditor = layedit.build('summary_editor');
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#pictureBtn'
            ,url: '/user/upload'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#pictureImg').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.success > 0){
                    var obj = JSON.parse(res.msg);
                    $("#pictureBtn").closest(".layui-upload").find("#fileName").val(obj.fileName || "");
                    $("#pictureBtn").closest(".layui-upload").find("#originalFileName").val(obj.originalFileName || "");
                    $("#pictureBtn").closest(".layui-upload").find("#businessType").val(obj.businessType || "");
                    $("#pictureBtn").closest(".layui-upload").find("#contentType").val(obj.contentType || "");
                }else{
                    return layer.msg('上传失败');
                }
                console.log(res);
                //上传成功
            }
            ,error: function(){
                    //演示失败状态，并实现重传
                    var demoText = $('#pictureTip');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

    //自定义验证规则
    form.verify({
            usernameRegexp : function(value){
                var reg = new RegExp('^[\\S]{3}$');
                if(!reg.test(value)){
                    return '用户名不正确';
                }
            },
            ageInt3 : function(value){
                var regObj = getIntRegByLength(3);
                if(!!regObj.reg){
                    var reg = new RegExp(regObj.reg);
                    if(!reg.test(value)){
                        return '请输入'+regObj.msg;
                    }
                }else{
                    return '正则表达式为空';
                }
            },
            phoneRegexp : function(value){
                var reg = new RegExp('^13\\d{9}$');
                if(!reg.test(value)){
                    return '手机号格式错误';
                }
            },

                addressString255 : function(value){
                     if(value.length > 1000){
                        return '内容不能超过1000个字符';
                    }
                },
                summaryRegexp : function(value){
                    layedit.sync(summaryEditor);
                    var content = layedit.getContent(summaryEditor);
                    var reg = new RegExp('^[\\S]+$');
                    if(!reg.test(value)){
                        return '必填项不能为空';
                    }
                },
    });

    var  verify = form.config.verify;
    $("#username").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#age").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#phone").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#email").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#url").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#idcard").blur(function(){
        layuiBlurCheck($(this),verify);
    });

    $("#address").blur(function(){
        layuiBlurCheck($(this),verify,1);
    })
    $("iframe[textarea='summary_editor']").contents().find("body").blur(function(){
        layuiBlurCheck($("#summary_editor"),verify,1,$("#summary-tip"));
    });

    form.on('submit(form-user)', function (data) {
        var url = $('#form-user').attr('action');
        AjaxUtil.ajax({url : url,dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/user';
            }else if(response.errorType == 1){
                var msgList = response.msgList;
                for(var i= 0,len=msgList.length;i<len;i++){
                    if(!!msgList[i].value){
                        var businessType =  msgList[i].businessType;
                        if(businessType === 'text'){
                            layer.tips(msgList[i].value, $("#"+msgList[i].key), {tips: 1,time:3000,tipsMore :true});
                        }else if(businessType === 'edit'){
                            layer.tips(msgList[i].value, $("#"+msgList[i].key+"-tip"), {tips: 1,time:3000,tipsMore :true});
                        }else if(businessType === 'date'){
                            layer.tips(msgList[i].value, $("#"+msgList[i].key+"_date"), {tips: 1,time:3000,tipsMore :true});
                        }else{
                            layer.tips(msgList[i].value, $("#"+msgList[i].key), {tips: 1,time:3000,tipsMore :true});
                        }
                    }
                }
            }else{
                layer.alert(response.msg, {icon: 5});
            }
        },error : function(XHR,status,e){
                layer.alert('系统出错，请联系管理员。', {icon: 5});
        }});
        return false;
    });


});