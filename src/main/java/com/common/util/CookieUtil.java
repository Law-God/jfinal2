package com.common.util;

import com.jfinal.aop.Invocation;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.model.User;
import com.model.UserTokens;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zzk on 2018-01-18.
 */
public class CookieUtil {
    public static void addCookie(HttpServletResponse response,String key,String value,int expires,String path){
        path = StrKit.isBlank(path) ? "/" : path;
        Cookie cookie = new Cookie(key,value);
        cookie.setPath(path);
        cookie.setMaxAge(expires);
        response.addCookie(cookie);
    }

    public static void removeCookie(HttpServletRequest request,HttpServletResponse response,String key,String path){
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(int i = 0,len=cookies.length; i < len; ++i) {
                String sp = cookies[i].getName();
                if(sp.equals(key)) {
                    path = StrKit.isBlank(path) ? "/" : path;
                    Cookie cookie = new Cookie(cookies[i].getName(), (String)null);
                    cookie.setMaxAge(0);
                    cookie.setPath(path);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    public static void checkAutoLogin(HttpServletRequest request){
        if(request == null) return;

        Cookie loginAgentC = null;
        Cookie loginTokenC = null;

        javax.servlet.http.Cookie[] cookies = request.getCookies();
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

        if(loginAgentC != null  && loginTokenC != null){
            String loginAgent = loginAgentC.getValue();
            String loginToken = loginTokenC.getValue();
            String sql = Db.getSql("usertokens.selectUserTokenByAgentAndToken");
            UserTokens userTokens = UserTokens.dao.findFirst(sql,loginAgent,loginToken);
            if(!StrKit.isBlank(String.valueOf(userTokens.getUserId()))){
                sql = Db.getSql("user.selectUserById");
                User user = User.dao.findFirst(sql,String.valueOf(userTokens.getUserId()));
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
            }

        }
    }
}
