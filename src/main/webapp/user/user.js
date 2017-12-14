layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
    ,layer = layui.layer
    ,layedit = layui.layedit
    ,laydate = layui.laydate;
    var $= layui.jquery;

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
                        return '不能超过25个字符';
                    }
                },
                int3 : function(value){
                    var regObj = getIntRegByLength(3);
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
                    layedit.sync(summaryEditor);
                },
    });


    form.on('submit(form-user)', function (data) {
        if (!data.field['user.sex']){
            layer.tips('请选择性别', '#sex-tips',{
                tips: [1, '#000'],
                time: 4000
            });
            //layer.msg('请选择性别', {icon:5,shift:6});
            return false;
        }
        if (!data.field['user.summary']){
            layer.tips('请输入简介', '#longtext-div',{
                tips: [1, '#000'],
                time: 4000
            });
            //layer.msg('请选择性别', {icon:5,shift:6});
            return false;
        }
        return true;
    });


});