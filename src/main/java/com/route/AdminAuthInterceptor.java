package com.route;

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
            checkAutoLogin(inv);
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

    private void checkAutoLogin(Invocation inv){
        Cookie loginAgentC = null;
        Cookie loginTokenC = null;

        javax.servlet.http.Cookie[] cookies = inv.getController().getRequest().getCookies();
        if(cookies != null){
            for(int i=0,len=cookies.length;i<len;i++){
                String name = cookies[i].getName();
                if("loginAgent".equals(name)){
                    loginAgentC = cookies[i];
                }else if("loginToken".equals(name)){
                    loginTokenC = cookies[i];
                }
            }
        }

        if(loginAgentC != null && loginTokenC != null){
            String loginAgent = loginAgentC.getValue();
            String loginToken = loginTokenC.getValue();
            String sql = Db.getSql("usertokens.selectUserTokenByAgentAndToken");
            UserTokens userTokens = UserTokens.dao.findFirst(sql,loginAgent,loginToken);
            if(!StrKit.isBlank(String.valueOf(userTokens.getUserId()))){
                sql = Db.getSql("user.selectUserById");
                User user = User.dao.findFirst(sql,String.valueOf(userTokens.getUserId()));
                if(user != null){
                    inv.getController().setSessionAttr("user",user);
                }
            }

        }
    }
}
