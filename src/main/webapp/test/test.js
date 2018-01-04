layui.use(['form', 'layedit', 'laydate','upload','AjaxUtil','MD5'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,AjaxUtil = layui.AjaxUtil
    ,upload = layui.upload
    ,MD5 = layui.MD5;

    var $= layui.jquery;

        //日期
        laydate.render({
            elem: '#createTime_date',
            type : "date",
            format : 'yyyy-MM-dd',
            trigger : 'click',
            done: function(value, date){
                setTimeout(function(){
                    layuiBlurCheck($('#createTime_date'),verify);
                },100)
            }
        });


        //普通图片上传
        var fileuploadInst = upload.render({
            elem: '#fileBtn'
            ,accept: 'file'
            ,url: '/upload/upload?businessType=test&businessField=file'
            ,size : 2048//上传大小2m
            ,done: function(res){
                //如果上传成功
                if(res.success){
                    var obj = JSON.parse(res.msg);
                    $("#fileBtn").closest(".layui-upload").find("#file").val("");//修改页面重新上传文件
                    $("#fileBtn").closest(".layui-upload").find("#fileValidator").val(obj.fileName || "");
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
            pictureString100 : function(value){
                if(value.length > 100){
                    return '、';
                }
            },

            uploadfile : function(){
                if($("#file").closest(".layui-upload").find("#file_fileName").val() == ""){
                    return '请上传文件';
                }
            },

    });

    var  verify = form.config.verify;
    $("#picture").blur(function(){
        layuiBlurCheck($(this),verify);
    });


    form.on('submit(form-test)', function (data) {
        var url = $('#form-test').attr('action');
        var pictureVal = $("#picture").val();
        if(!!pictureVal){
            data.field['test.picture'] = MD5.hex_md5(pictureVal);
        }
        AjaxUtil.ajax({url : url,type:'POST',dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/test';
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
                            layer.tips(msgList[i].value, $("#"+msgList[i].key+"_date"), {time:3000,tipsMore :true});
                        }else if(businessType === 'picture'){
                            layer.tips(msgList[i].value, $("#"+msgList[i].key+"Btn"), {time:3000,tipsMore :true});
                        }else{
                            layer.tips(msgList[i].value, $("#"+msgList[i].key), {time:3000,tipsMore :true});
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