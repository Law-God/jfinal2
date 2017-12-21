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


    //自定义验证规则
    form.verify({
            string20 : function(value){
                if(value.length > 20){
                    return '不能超过20个字符';
                }
            },
            char : function(){
                if(!$("#cardtype-radio-hidden").val()){
                    return '请选择证件类别';
                }
            },
            string10 : function(value){
                if(value.length > 10){
                    return '不能超过10个字符';
                }
            },

                text : function(value){
                    if(value.length <= 0){
                        return '请输入家庭地址';
                    }else if(value.length > 1000){
                        return '内容不能超过1000个字符';
                    }
                },
    });

    var  verify = form.config.verify;
    $("#username").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    form.on('radio(filter-radio-cardtype)', function(data){
        $("#cardtype-radio-hidden").val(data.value);
    });
    $("#cardno").blur(function(){
        layuiBlurCheck($(this),verify);
    });

    $("#address").blur(function(){
        layuiBlurCheck($(this),verify,1);
    })

    form.on('submit(form-register)', function (data) {
        var url = $('#form-register').attr('action');
        AjaxUtil.ajax({url : url,dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/register';
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