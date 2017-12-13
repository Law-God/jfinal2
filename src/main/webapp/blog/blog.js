layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate;



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


    form.on('submit(form-blog)', function (data) {
        return true;
    });


});