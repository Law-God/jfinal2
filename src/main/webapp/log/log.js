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

        //创建一个编辑器
        var errorStackEditor = layedit.build('errorStack_editor');




    //自定义验证规则
    form.verify({
            useridInt20 : function(value){
                if(value == "") return false;
                var regObj = getIntRegByLength(20);
                if(!!regObj.reg){
                    var reg = new RegExp(regObj.reg);
                    if(!reg.test(value)){
                        return '请输入'+regObj.msg;
                    }
                }else{
                    return '正则表达式为空';
                }
            },
            urlString200 : function(value){
                if(value.length > 200){
                        return '不能超过200个字符';
                }
            },


    });

    var  verify = form.config.verify;
    $("#userid").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#url").blur(function(){
        layuiBlurCheck($(this),verify);
    });

    $("iframe[textarea='errorStack_editor']").contents().find("body").blur(function(){
        layuiBlurCheck($("#errorStack_editor"),verify,1,$("#errorStack-tip"));
    });

    form.on('submit(form-log)', function (data) {
        var url = $('#form-log').attr('action');
        AjaxUtil.ajax({url : url,type:'POST',dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/log';
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