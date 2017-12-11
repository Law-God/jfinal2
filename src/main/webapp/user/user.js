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

    form.on('submit(form-user)', function (data) {
        if (!data.field['user.sex']){
            layer.msg('请选择性别', {icon:5,shift:6});
            return false;
        }
        return true;
    });
});