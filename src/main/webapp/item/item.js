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
            elem: '#createDate_date',
            type : "date",
            format : 'yyyy-MM-dd',
            trigger : 'click',
            done: function(value, date){
                setTimeout(function(){
                    layuiBlurCheck($('#createDate_date'),verify);
                },100)
            }
        });



    //自定义验证规则
    form.verify({
            itemCodeString6 : function(value){
                if(value.length > 6){
                    return '不能超过6个字符';
                }
            },
            itemSupString6 : function(value){
                if(value.length > 6){
                    return '不能超过6个字符';
                }
            },
            itemNameString100 : function(value){
                if(value.length > 100){
                    return '不能超过100个字符';
                }
            },
            itemUrlString100 : function(value){
                if(value.length > 100){
                    return '不能超过100个字符';
                }
            },
            enableRadio : function(){
                if($("#enable-radio-hidden").val() == "") return false;
                if(!$("#enable-radio-hidden").val()){
                    return '请选择是否可用';
                }
            },
            itemSubString6 : function(value){
                if(value.length > 6){
                    return '不能超过6个字符';
                }
            },


    });

    var  verify = form.config.verify;
    $("#itemCode").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#itemSup").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#itemName").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    $("#itemUrl").blur(function(){
        layuiBlurCheck($(this),verify);
    });
    form.on('radio(filter-radio-enable)', function(data){
        $("#enable-radio-hidden").val(data.value);
    });
    $("#itemSub").blur(function(){
        layuiBlurCheck($(this),verify);
    });


    form.on('submit(form-item)', function (data) {
        var url = $('#form-item').attr('action');
        AjaxUtil.ajax({url : url,type:'POST',dataType : 'json',data:data.field,success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/item';
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