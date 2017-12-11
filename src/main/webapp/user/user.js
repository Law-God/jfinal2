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

});