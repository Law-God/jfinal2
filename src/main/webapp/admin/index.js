layui.use('element', function(){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

    //监听导航点击
    element.on('nav(left-nav)', function(elem){
        //layer.msg(elem.text());
    });
    var $ = layui.jquery;
    var currUrl = $("#url").val();
    $("a[href='"+currUrl+"']").parent().addClass("layui-this");

    $("#logout").click(function(){
        layer.confirm('您确认注销？', {
            btn: ['确定','取消'] //按钮
        }, function(){
           window.location.href= "/login/logout";
        });
    })

});