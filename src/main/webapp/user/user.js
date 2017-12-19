layui.use(['form', 'layedit', 'laydate','AjaxUtil'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,AjaxUtil = layui.AjaxUtil;
    var $= layui.jquery;
        //日期
        laydate.render({
            elem: '#birthday_date',
            type : "datetime",
            format : 'yyyy-MM-dd HH:mm:ss',
            trigger : 'click',
            done: function(value, date){
               setTimeout(function(){
                   layuiBlurCheck($("#birthday_date"),verify);
               },100)

            }
        });

        //创建一个编辑器
        var summaryEditor = layedit.build('summary_editor');

    //自定义验证规则
    form.verify({
                string127 : function(value){
                    if(value.length > 127){
                        return '不能超过127个字符';
                    }
                },

                char : function(){
                    if(!$("#sex-radio-hidden").val()){
                        return '请选择性别';
                    }
                },

                int11 : function(value){
                    var regObj = getIntRegByLength(11);
                    if(!!regObj.reg){
                        var reg = new RegExp(regObj.reg);
                        if(!reg.test(value)){
                            return '请输入'+regObj.msg;
                        }
                    }else{
                        return '正则表达式为空';
                    }
                },


                double10 : function(value){
                    var regObj = getDoubleRegByLength(10);
                    if(!!regObj.reg){
                        var reg = new RegExp(regObj.reg);
                        if(!reg.test(value)){
                            return '请输入'+regObj.msg;
                        }
                    }else{
                        return '正则表达式为空';
                    }
                },


                text : function(value){
                    if(value.length <= 0){
                        return '请输入地址';
                    }else if(value.length > 1000){
                        return '内容不能超过1000个字符';
                    }
                },
                longtext : function(value){
                    //layedit.sync(summaryEditor);
                    var content = layedit.getContent(summaryEditor);
                    if(content.length <= 0){
                        return '请输入简介';
                    }
                },
    });

    form.on('radio(filter-radio-sex)', function(data){
        $("#sex-radio-hidden").val(data.value);
    });

    var  verify = form.config.verify;

    $("#name").blur(function(){
        layuiBlurCheck($(this),verify);
    });

    $("#age").blur(function(){
        layuiBlurCheck($(this),verify);
    });



    $("#address").blur(function(){
        layuiBlurCheck($(this),verify,1);
    })

    $("#pay").blur(function(){
        layuiBlurCheck($(this),verify);
    });

    $("iframe[textarea='summary_editor']").contents().find("body").blur(function(){
        layuiBlurCheck($("#summary_editor"),verify,1,$("#summary-tip"));
    });



    form.on('submit(form-user)', function (data) {
        AjaxUtil.ajax({url : '/user/save',dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                layui.close(layeruseradd);
            }else if(response.errorType == 1){
                var msgList = response.msgList;
                for(var i= 0,len=msgList.length;i<len;i++){
                    console.log(msgList[i].key + "  " + msgList[i].value + " " + (!!msgList[i].value));
                }
                layer.tips("错误", $("#userPay"), {tips: 1,time:5000,tipsMore :true});
            }else{
                layer.alert(response.msg, {icon: 5});
            }
        },error : function(XHR,status,e){
            layer.alert('系统出错，请联系管理员。', {icon: 5});
        }});

        //$.ajax({url : '/user/save',dataType : 'json',data:data.field,success : function(response,status){
        //    if(response.success){
        //        layui.close(layeruseradd);
        //    }else{
        //        layer.alert(response.msg, {icon: 5});
        //    }
        //},error : function(XHR,status,e){
        //    layer.alert('系统出错，请联系管理员。', {icon: 5});
        //}})

        return false;
    });


});