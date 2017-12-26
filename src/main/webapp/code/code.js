layui.use(['form', 'layedit', 'laydate','AjaxUtil'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate
    ,AjaxUtil = layui.AjaxUtil;;
    var $= layui.jquery;


    //自定义验证规则
    form.verify({
                string100 : function(value){
                    if(value.length > 100){
                        return '不能超过100个字符';
                    }
                },


                text : function(value){
                    if(value.length <= 0){
                        return '请输入内容';
                    }else if(value.length > 1000){
                        return '内容不能超过1000个字符';
                    }
                },
    });

    var  verify = form.config.verify;
    $("#title").blur(function(){
        layuiBlurCheck($(this),verify);
    });

    $("#content").blur(function(){
        layuiBlurCheck($(this),verify,1);
    })

    //监听指定开关
    form.on('switch(switchTest)', function(data){
        //this.checked ? $("#isNullable").val(0) : $("#isNullable").val(1);
        this.checked ? this.value=0 : this.value=1;
        /*layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
            offset: '6px'
        });*/
    });

    form.on('submit(form-code)', function (data) {
        var tableMeta = {};
        tableMeta.name = $("#tableMetaName").val();
        tableMeta.primaryKey = $("#tableMetaPrimaryKey").val();
        var columns = [];
        $(".columns").each(function(){
            var column = {};
            $(this).find(".column").each(function(){
                var name = $(this).attr("name");
                var value = $(this).val();
                column[name] = value;
            })
            columns.push(column);
        })
        tableMeta.columnMetas = columns;
        var url = $('#form-code').attr('action');
        AjaxUtil.ajax({url : url,dataType : 'json',data:{"tableMeta":JSON.stringify(tableMeta)},success : function(response,status){
            if(response.success){
                //parent.layer.closeAll();
                parent.location.href = '/code';
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