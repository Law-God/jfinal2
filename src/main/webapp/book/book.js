layui.use(['form', 'layedit', 'laydate','upload','AjaxUtil','MD5'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,AjaxUtil = layui.AjaxUtil
    ,upload = layui.upload
    ,MD5 = layui.MD5;

    var $= layui.jquery;


        //创建一个编辑器
        var contentEditor = layedit.build('content_editor');


    //自定义验证规则
    form.verify({
            booknameString100 : function(value){
                if(value.length > 100){
                    return '不能超过100个字符';
                }
            },
            descriptString1000 : function(value){
                if(value == "") return false;
                if(value.length > 1,000){
                    return '不能超过1,000个字符';
                }
            },
            authString100 : function(value){
                if(value.length > 100){
                    return '不能超过100个字符';
                }
            },


    });

    var  verify = form.config.verify;
    $("#bookname").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#descript").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#auth").blur(function(){
        layuiBlurCheck($(this),verify);
    });

    $("iframe[textarea='content_editor']").contents().find("body").blur(function(){
        layuiBlurCheck($("#content_editor"),verify,1,$("#content-tip"));
    });

    form.on('submit(form-book)', function (data) {
        var url = $('#form-book').attr('action');
        AjaxUtil.ajax({url : url,type:'POST',dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/book';
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