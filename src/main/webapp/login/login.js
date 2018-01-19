/**
 * Created by zzk on 2018-01-16.
 */
$(function(){
    var loginToken = $.cookie("loginToken");
    if(!!loginToken){//显示自动登录界面
        loginHidden(true);
        $("#username").val($.cookie("username"));
    }

    $("#drag").drag({success:changeLoginBtnClass});

    $("#username").blur(function(){
        changeLoginBtnClass();
    });

    $("#loginBtn").click(function(){
        if($(this).attr("auto") == "false"){
            var username = $("#username").val();
            var password = $("#password").val();
            var code = $("#code").val();
            var remember = $("#remember:checked").val();
            if(!!username && !!password && $("div.handler").hasClass("handler_ok_bg")){
                var data = {};
                data.username = username;
                data.password = hex_md5(password);
                data.remember = remember;
                data.code = code;
                $.ajax({url : "/login/submit",type:'POST',dataType : 'json',data:data,success : function(response,status){
                    if(response.success){
                        window.location.href=response.msg;
                    }else{
                        AMUI.dialog.alert({
                            title: '错误提示',
                            content: response.msg
                        });

                        window.drag_reset();
                        $("#loginBtn").trigger("blur");
                    }
                },error : function(XHR,status,e){
                    AMUI.dialog.alert({
                        title: '错误提示',
                        content: '系统出错'
                    });
                }})
            }
        }else{
            $.ajax({url : "/login/auto",type:'POST',dataType : 'json',success : function(response,status){
                if(response.success){
                    window.location.href=response.msg;
                }else{
                    AMUI.dialog.alert({
                        title: '错误提示',
                        content: response.msg
                    });
                    loginHidden(false);
                }
            },error : function(XHR,status,e){
                AMUI.dialog.alert({
                    title: '错误提示',
                    content: '系统出错'
                });
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

function loginHidden(auto){
    if(auto){
        $("#loginBtn").removeClass("am-disabled").text("自动登录").attr("auto","true");
        $(".auto-login").css("display","block");
        $(".login").css("display","none");
    }else{
        $("#loginBtn").addClass("am-disabled").text("登录").attr("auto","false");
        $(".auto-login").css("display","none");
        $(".login").css("display","block");
    }
}
