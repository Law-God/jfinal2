package com.route;

import com.common.util.CookieUtil;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.model.Item;
import com.model.User;
import com.model.UserTokens;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * Created by zzk on 2018-01-15.
 */
public class AdminAuthInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        //未登录用户自动登录
        if(inv.getController().getSession(false) == null || inv.getController().getSession().getAttribute("user") == null){
            CookieUtil.checkAutoLogin(inv.getController().getRequest());
        }

        //inv.getController().renderError(404,"/404.html");
        //无论是否自动登录都放行
        User user = inv.getController().getSessionAttr("user");
        if(user == null){
            inv.getController().render("/login/login.html");
        }else{
            List<Item> itemList =  Item.dao.findByCache("itemCacheName","itemList","select * from item");
            inv.getController().getSession().setAttribute("itemList",itemList);
            inv.invoke();
        }

    }


}
