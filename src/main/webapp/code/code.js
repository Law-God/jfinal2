layui.use(['form', 'AjaxUtil'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,AjaxUtil = layui.AjaxUtil;;
    var $= layui.jquery;

    //监听select
    form.on('select(selectLayVerify)', function(data){
        var val = data.value;
        $("input[name='layVerify']").val(val);
        if(val == 'regexp'){
            $(this).closest(".layui-row").find($("div .size,div .scale")).css("display","none");
            $(this).closest(".layui-row").find($("div .regexp")).css("display","");
        }else if(val == 'string'){
            $(this).closest(".layui-row").find($("div .size")).css("display","");
            $(this).closest(".layui-row").find($("div .scale,div .regexp")).css("display","none");
        }else if(val == "number"){
            $(this).closest(".layui-row").find($("div .size,div .scale")).css("display","");
            $(this).closest(".layui-row").find($("div .regexp")).css("display","none");
        }else {
            $(this).closest(".layui-row").find($("div .size,div .scale,div .regexp")).css("display","none");
        }
    });


    //监听指定开关
    form.on('switch(switchTest)', function(data){
        //是否必填  0：否 1：是
        this.checked ? $(this).val(0) : $(this).val(1);
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