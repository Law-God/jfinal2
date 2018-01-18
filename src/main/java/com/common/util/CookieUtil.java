package com.common.util;

import com.jfinal.kit.StrKit;

import javax.servlet.http.Cookie;
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
}
