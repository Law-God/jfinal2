layui.use(['form', 'layedit', 'laydate','upload','AjaxUtil','MD5'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,AjaxUtil = layui.AjaxUtil
    ,upload = layui.upload
    ,MD5 = layui.MD5;

    var $= layui.jquery;


        layedit.set({
            uploadImage: {
                url: '/upload/editUpload' //接口url
                ,type: 'POST' //默认post
            }
        });
        //创建一个编辑器
        var contentEditor = layedit.build('content_editor');

        //普通图片上传
        var attachmentuploadInst = upload.render({
            elem: '#attachmentBtn'
            ,accept: 'file'
            ,url: '/upload/upload?businessType=article&businessField=attachment'
            ,size : 2048//上传大小2m
            ,done: function(res){
                //如果上传成功
                if(res.success){
                    var obj = JSON.parse(res.msg);
                    $("#attachmentBtn").closest(".layui-upload").find("#attachment").val("");//修改页面重新上传文件
                    $("#attachmentBtn").closest(".layui-upload").find("#attachmentValidator").val(obj.fileName || "");
                    $("#attachmentBtn").closest(".layui-upload").find("#attachment_fileName").val(obj.fileName || "");
                    $("#attachmentBtn").closest(".layui-upload").find("#attachment_originalFileName").val(obj.originalFileName || "");
                    $("#attachmentBtn").closest(".layui-upload").find("#attachment_businessType").val(obj.businessType || "");
                    $("#attachmentBtn").closest(".layui-upload").find("#attachment_businessField").val(obj.businessField || "");
                    $("#attachmentBtn").closest(".layui-upload").find("#attachment_contentType").val(obj.contentType || "");
                    var demoText = $('#attachmentTip');
                    demoText.html('<span>上传成功</span>'+obj.originalFileName);
                }else{
                    return layer.msg('上传失败');
                }
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#attachmentTip');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    attachmentuploadInst.upload();
                });
            }
        });

    //自定义验证规则
    form.verify({
            titleString255 : function(value){
                if(value.length > 255){
                    return '不能超过255个字符';
                }
            },
            descriptString255 : function(value){
                if(value == "") return false;
                if(value.length > 255){
                    return '不能超过255个字符';
                }
            },
            statusRadio : function(){
                if(!$("#status-radio-hidden").val()){
                    return '请选择是否可用';
                }
            },


    });

    var  verify = form.config.verify;
    $("#title").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#descript").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    form.on('radio(filter-radio-status)', function(data){
        $("#status-radio-hidden").val(data.value);
    });

    $("iframe[textarea='content_editor']").contents().find("body").blur(function(){
        layuiBlurCheck($("#content_editor"),verify,1,$("#content-tip"));
    });

    form.on('submit(form-article)', function (data) {
        var url = $('#form-article').attr('action');
        AjaxUtil.ajax({url : url,type:'POST',dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/article';
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