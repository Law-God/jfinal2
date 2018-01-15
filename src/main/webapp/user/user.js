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
        layedit.set({
            uploadImage: {
                url: '/upload/editUpload' //接口url
                ,type: 'POST' //默认post
            }
        });
        var summaryEditor = layedit.build('summary_editor');

        //普通图片上传
        var pictureuploadInst = upload.render({
            elem: '#pictureBtn'
            ,accept: 'images'
            ,url: '/upload/upload?businessType=user&businessField=picture'
            ,size : 2048//上传大小2m
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#pictureImg').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传成功
                if(res.success){
                    var obj = JSON.parse(res.msg);
                    $("#pictureBtn").closest(".layui-upload").find("#picture").val("");//修改页面重新上传文件
                    $("#pictureBtn").closest(".layui-upload").find("#picture_fileName").val(obj.fileName || "");
                    $("#pictureBtn").closest(".layui-upload").find("#picture_originalFileName").val(obj.originalFileName || "");
                    $("#pictureBtn").closest(".layui-upload").find("#picture_businessType").val(obj.businessType || "");
                    $("#pictureBtn").closest(".layui-upload").find("#picture_businessField").val(obj.businessField || "");
                    $("#pictureBtn").closest(".layui-upload").find("#picture_contentType").val(obj.contentType || "");
                }else{
                    return layer.msg('上传失败');
                }
            }
            ,error: function(){
                    //演示失败状态，并实现重传
                    var demoText = $('#pictureTip');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function(){
                    pictureuploadInst.upload();
                });
            }
        });
        //普通图片上传
        var fileuploadInst = upload.render({
            elem: '#fileBtn'
            ,accept: 'file'
            ,url: '/upload/upload?businessType=user&businessField=file'
            ,size : 2048//上传大小2m
            ,done: function(res){
                //如果上传成功
                if(res.success){
                    var obj = JSON.parse(res.msg);
                    $("#fileBtn").closest(".layui-upload").find("#file").val("");//修改页面重新上传文件
                    $("#fileBtn").closest(".layui-upload").find("#file_fileName").val(obj.fileName || "");
                    $("#fileBtn").closest(".layui-upload").find("#file_originalFileName").val(obj.originalFileName || "");
                    $("#fileBtn").closest(".layui-upload").find("#file_businessType").val(obj.businessType || "");
                    $("#fileBtn").closest(".layui-upload").find("#file_businessField").val(obj.businessField || "");
                    $("#fileBtn").closest(".layui-upload").find("#file_contentType").val(obj.contentType || "");
                    var demoText = $('#fileTip');
                    demoText.html('<span>上传成功</span>'+obj.originalFileName);
                }else{
                    return layer.msg('上传失败');
                }
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#fileTip');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    fileuploadInst.upload();
                });
            }
        });



    //自定义验证规则
    form.verify({
            usernameRegexp : function(value){
                if(value == "") return false;
            },
            ageInt3 : function(value){
                if(value == "") return false;
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
                if(value == "") return false;
            },
            sexRadio : function(){
                if(!$("#sex-radio-hidden").val()){
                    return '请选择';
                }
            },

                uploadpicture : function(){
                    if($("#picture").closest(".layui-upload").find("#fileName").val() == ""){
                        return "请上传图片";
                    }
                },
                uploadfile : function(){
                    if($("#file").closest(".layui-upload").find("#fileName").val() == ""){
                        return "请上传图片";
                    }
                },

                addressString255 : function(value){
                },
                summaryRegexp : function(value){
                    layedit.sync(summaryEditor);
                    var content = layedit.getContent(summaryEditor);
                    var reg = new RegExp('[\\S]+');
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
    form.on('radio(filter-radio-sex)', function(data){
        $("#sex-radio-hidden").val(data.value);
    });

    $("#address").blur(function(){
        layuiBlurCheck($(this),verify,1);
    })
    $("iframe[textarea='summary_editor']").contents().find("body").blur(function(){
        layuiBlurCheck($("#summary_editor"),verify,1,$("#summary-tip"));
    });

    form.on('submit(form-user)', function (data) {
        var url = $('#form-user').attr('action');
        AjaxUtil.ajax({url : url,type:'POST',dataType : 'json',data:data.field,success : function(response,status){
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
                        }else if(businessType === 'picture'){
                            layer.tips(msgList[i].value, $("#"+msgList[i].key+"Btn"), {tips: 2,time:3000,tipsMore :true});
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