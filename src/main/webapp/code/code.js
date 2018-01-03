layui.use(['form', 'AjaxUtil'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,AjaxUtil = layui.AjaxUtil;;
    var $= layui.jquery;

    //监听select
    form.on('select(select-business-type)', function(data){
        var val = data.value;
        //$(this).closest(".layui-row").find($("input[name='layVerify']")).val(val);
        businessTypeController($(this),val);
    });

    //监听select
    form.on('select(selectLayVerify)', function(data){
        var val = data.value;
        //$(this).closest(".layui-row").find($("input[name='layVerify']")).val(val);
        layVerifyController($(this),val);
    });

    $(function(){
        $("select[lay-filter='select-business-type']").each(function(){
            var val = $(this).val();
            businessTypeController($(this),val);
        })

        $("select[lay-filter='selectLayVerify']").each(function(){
            var val = $(this).val();
            layVerifyController($(this),val);
        })

    });

    /**
     * 根据业务类型显示控件
     * @param _$select
     * @param val
     */
    function businessTypeController(_$select,val){
        var _$layui_row = _$select.closest(".layui-row");
        _$layui_row.find(".layui-col-xs").css("display","none");
        _$select.closest(".layui-col-xs").css("display","");

        if(val == "none") return;

        //基本显示控件
        _$layui_row.find(".show-name, .required").css("display","");

        //控件是否显示默认文字
        if(val == 'string' || val == 'password' || val == 'text' || val == 'int' || val == 'double' || val == 'date'){
            _$layui_row.find(".text-tip").css("display","");
        }

        //控件是否显示校验规则,除了图片、文件、单选外显示校验规则
        if(!(val == 'picture' || val == 'file' || val == 'radio')){
            _$layui_row.find(".lay-verify").css("display","");
        }
    }


    /**
     * 根据选择校验规则控制显示控件
     * @param _$select
     * @param val
     */
    function layVerifyController(_$select,val){
        var _$layui_row = _$select.closest(".layui-row");
        _$layui_row.find("[class*='lay-verify']").css("display","none");
        _$select.closest(".layui-col-xs").css("display","");
        if(val == 'string' || val == 'password'){
            _$layui_row.find(".lay-verify-size,lay-verify-regexp,.lay-verify-error-tip").css("display","");
        }else if(val == 'phone' || val == 'email' || val == 'url' || val == 'identity' || val == 'date'){
            _$layui_row.find(".lay-verify-error-tip").css("display","");
        }else if(val == 'int'){
            _$layui_row.find(".lay-verify-size, .lay-verify-error-tip").css("display","");
        }else if(val == 'double'){
            _$layui_row.find(".lay-verify-size,.lay-verify-scale, .lay-verify-error-tip").css("display","");
        }else if(val == 'radio') {
            _$layui_row.find("lay-verify-radio-value, .lay-verify-error-tip").css("display","");
        }else if(val == 'regexp'){
            _$layui_row.find(".lay-verify-regexp,.lay-verify-error-tip").css("display","");
        }
    }

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
        AjaxUtil.ajax({url : url,type : 'POST',dataType : 'json',data:{"tableMeta":JSON.stringify(tableMeta)},success : function(response,status){
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