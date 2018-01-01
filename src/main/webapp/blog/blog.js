layui.use(['form', 'layedit', 'laydate','upload','AjaxUtil'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,AjaxUtil = layui.AjaxUtil
    ,upload = layui.upload;
    var $= layui.jquery;

        //创建一个编辑器
        var contentEditor = layedit.build('content_editor');




    //自定义验证规则
    form.verify({
            titleString100 : function(value){
                if(value.length > 100){
                        return '标题长度0~100个字符';
                }
            },


                contentRegexp : function(value){
                    layedit.sync(contentEditor);
                    var content = layedit.getContent(contentEditor);
                    if(content.length <= 0){
                        //return '';
                        return '必填项不能为空';
                    }
                },
    });

    var  verify = form.config.verify;
    $("#title").blur(function(){
        layuiBlurCheck($(this),verify);
    });

    $("iframe[textarea='content_editor']").contents().find("body").blur(function(){
        layuiBlurCheck($("#content_editor"),verify,1,$("#content-tip"));
    });

    form.on('submit(form-blog)', function (data) {
        var url = $('#form-blog').attr('action');
        AjaxUtil.ajax({url : url,dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/blog';
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