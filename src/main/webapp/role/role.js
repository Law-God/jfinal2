layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate;



    //自定义验证规则
    form.verify({
                string50 : function(value){
                    if(value.length > 50){
                        return '不能超过50个字符';
                    }
                },
                string100 : function(value){
                    if(value.length > 100){
                        return '不能超过100个字符';
                    }
                },

    });


    form.on('submit(form-role)', function (data) {
        return true;
    });


});