package com.login;

import com.common.util.CookieUtil;
import com.common.util.DateUtil;
import com.common.util.MD5Util;
import com.common.ReturnMsg;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.model.User;
import com.model.UserTokens;
import com.route.AdminAuthInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * IndexController
 */
public class LoginController extends Controller {

	public void index() {
		User user = (User)getSession().getAttribute("user");
		if(user == null){
			render("login.html");
		}else{
			redirect("/code");
		}

	}

	public void submit(){
		String username = getPara("username");
		String password = getPara("password");
		String sql = Db.getSql("user.selectUserByUsernameAndPassword");
		User user = User.dao.findFirst(sql,username,password);
		if(user == null){
			renderJson(new ReturnMsg(false,"用户名或密码错误"));
		}else{//登录成功
			if(!isParaBlank("remember")){//自动登录
				int expires = 60*60*24*30;//30天
				//MD5
				String loginAgent = MD5Util.md5(DateUtil.nowDateTime() + UUID.randomUUID().toString());
				String loginToken = MD5Util.md5(username + loginAgent);
				//新增一条记录
				new UserTokens().set("userId",user.get("id"))
						.set("userAgent",loginAgent)
						.set("token",loginToken)
						.set("expires",expires)//30天
						.save();
				//新增cookie
				CookieUtil.addCookie(getResponse(),"loginAgent",loginAgent,expires,null);
				CookieUtil.addCookie(getResponse(),"loginToken",loginToken,expires,null);
			}
			getSession(true).setAttribute("user",user);
			renderJson(new ReturnMsg(true,"/code"));
		}
	}

	public void logout(){
		getSession().removeAttribute("user");
		getSession().invalidate();
		redirect("/");
	}



}



