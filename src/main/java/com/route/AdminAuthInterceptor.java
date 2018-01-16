package com.route;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.model.Item;
import com.model.User;

import java.util.List;

/**
 * Created by zzk on 2018-01-15.
 */
public class AdminAuthInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        System.out.println("AdminAuthInterceptor");
        //inv.getController().renderError(404,"/404.html");
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
