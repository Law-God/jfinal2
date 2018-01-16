/**
 * Created by zzk on 2018-01-16.
 */
$(function(){
    $("#drag").drag({success:changeLoginBtnClass});

    $("#username").blur(function(){
        changeLoginBtnClass();
    });

    $("#loginBtn").click(function(){
        var username = $("#username").val();
        var password = $("#password").val();
        if(!!username && !!password && $("div.handler").hasClass("handler_ok_bg")){
            var data = {};
            data.username = username;
            data.password = hex_md5(password);
            $.ajax({url : "/login/submit",type:'POST',dataType : 'json',data:data,success : function(response,status){
                if(response.success){
                    window.location.href=response.msg;
                }else{
                    alert(response.msg)
                }
            },error : function(XHR,status,e){
                alert("系统出错")
            }})
        }
    });
});

function showValue(id,val){
    document.getElementById(id).value=val;
    $("#"+id).blur(); //实现原始输入框的onblur事件
    changeLoginBtnClass();
}

function changeLoginBtnClass(){
    var username = $("#username").val();
    var password = $("#password").val();
    if(!!username && !!password && $("div.handler").hasClass("handler_ok_bg")){
        $("#loginBtn").removeClass("am-disabled");
    }else{
        $("#loginBtn").addClass("am-disabled");
    }
}