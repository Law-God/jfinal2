layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#birthday_date'
        });

        //创建一个编辑器
        var summaryEditor = layedit.build('summary_editor');

    //自定义验证规则
    form.verify({
                string25 : function(value){
                    if(value.length > 25){
                        return '姓名最多25个字符';
                    }
                },
                int3 : function(value){
                    var regObj = getRegByIntLength(3);
                    //var reg = new RegExp('[1-9]d{0,2}|0');
                    var reg = /^(0|[1-9][0-9]{0,2})$/;
                    if(!reg.test(value)){
                        return '请输入'+regObj.msg;
                    }

                },
    });


    form.on('submit(form-user)', function (data) {
        if (!data.field['user.sex']){
            layer.msg('请选择性别', {icon:5,shift:6});
            return false;
        }
        return true;
    });


});