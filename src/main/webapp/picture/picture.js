layui.use(['form', 'layedit', 'laydate','upload','AjaxUtil','MD5'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,AjaxUtil = layui.AjaxUtil
    ,upload = layui.upload
    ,MD5 = layui.MD5;

    var $= layui.jquery;



        //普通图片上传
        var pictureIduploadInst = upload.render({
            elem: '#pictureIdBtn'
            ,accept: 'images'
            ,url: '/upload/upload?businessType=picture&businessField=pictureId'
            ,size : 2048//上传大小2m
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#pictureIdImg').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传成功
                if(res.success){
                    var obj = JSON.parse(res.msg);
                    $("#pictureIdBtn").closest(".layui-upload").find("#pictureId").val("");//修改页面重新上传文件
                    $("#pictureIdBtn").closest(".layui-upload").find("#pictureIdValidator").val(obj.fileName || "");
                    $("#pictureIdBtn").closest(".layui-upload").find("#pictureId_fileName").val(obj.fileName || "");
                    $("#pictureIdBtn").closest(".layui-upload").find("#pictureId_originalFileName").val(obj.originalFileName || "");
                    $("#pictureIdBtn").closest(".layui-upload").find("#pictureId_businessType").val(obj.businessType || "");
                    $("#pictureIdBtn").closest(".layui-upload").find("#pictureId_businessField").val(obj.businessField || "");
                    $("#pictureIdBtn").closest(".layui-upload").find("#pictureId_contentType").val(obj.contentType || "");
                }else{
                    return layer.msg('上传失败');
                }
            }
            ,error: function(){
                    //演示失败状态，并实现重传
                    var demoText = $('#pictureIdTip');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function(){
                    pictureIduploadInst.upload();
                });
            }
        });

    //自定义验证规则
    form.verify({
            titleString100 : function(value){
                if(value == "") return false;
                if(value.length > 100){
                    return '不能超过100个字符';
                }
            },


    });

    var  verify = form.config.verify;
    $("#title").blur(function(){
        layuiBlurCheck($(this),verify);
    });


    form.on('submit(form-picture)', function (data) {
        var url = $('#form-picture').attr('action');
        AjaxUtil.ajax({url : url,type:'POST',dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/picture';
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