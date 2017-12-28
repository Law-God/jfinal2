layui.use(['form', 'layedit', 'laydate','AjaxUtil'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,AjaxUtil = layui.AjaxUtil;;
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

    //自定义验证规则
    form.verify({
            usernameRegexp : function(value){
                var reg = new RegExp('/^[\S]{3}$/');
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
                var reg = new RegExp('^13\d{9}$');
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
                    var reg = new RegExp('/^[\S]+$/');
                    if(!reg.test(value)){
                        return '';
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
                        var sqlType =  msgList[i].sqlType;
                        if(sqlType === 'char'){
                            layer.tips(msgList[i].value, $("#"+msgList[i].key), {tips: 1,time:3000,tipsMore :true});
                        }else if(sqlType === 'longtext'){
                            layer.tips(msgList[i].value, $("#"+msgList[i].key+"-tip"), {tips: 1,time:3000,tipsMore :true});
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