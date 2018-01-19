package com.login;

import com.common.util.CookieUtil;
import com.common.util.DateUtil;
import com.common.util.MD5Util;
import com.common.ReturnMsg;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.model.User;
import com.model.UserTokens;
import java.util.UUID;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * IndexController
 */
public class LoginController extends Controller {
	private static final Log log = Log.getLog(LoginController.class);

	public void index() {
		User user = (User)getSession().getAttribute("user");
		if(user == null){
			createRandomCode();//随机验证码
			setAttr("autoLogin",hasTokenCookie());
			render("login.html");
		}else{
			redirect("/code");
		}
	}

	public void submit(){
		String username = getPara("username");
		String password = getPara("password");
		String sessionCode = getSessionAttr("code");
		String code = getPara("code");
		if(sessionCode != null && !sessionCode.equals(code)){
			log.error("非法登录,sessionCode=" + sessionCode + "；code=" + code);
			renderJson(new ReturnMsg(false,"非法登录"));
			return;
		}else if(StrKit.isBlank(username) || StrKit.isBlank(password)){
			renderJson(new ReturnMsg(false,"用户名或密码不能为空"));
			return;
		}
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
				CookieUtil.addCookie(getResponse(),"username",user.getUsername(),expires,null);
				CookieUtil.addCookie(getResponse(),"loginAgent",loginAgent,expires,null);
				CookieUtil.addCookie(getResponse(),"loginToken",loginToken,expires,null);
			}
			getSession().setAttribute("user",user);
			renderJson(new ReturnMsg(true,"/code"));
		}
	}

	public void logout(){
		CookieUtil.removeCookie(getRequest(),getResponse(),"loginToken",null);
		CookieUtil.removeCookie(getRequest(),getResponse(),"loginAgent",null);
		CookieUtil.removeCookie(getRequest(),getResponse(),"username",null);
		getSession().removeAttribute("user");
		getSession().invalidate();
		redirect("/");
	}

	/**
	 * 自动登录
	 */
	public void auto(){
		CookieUtil.checkAutoLogin(getRequest());
		User user = (User)getSession().getAttribute("user");
		if(user == null){//自动登录失败
			renderJson(new ReturnMsg(false,"自动登录失败"));
		}else{
			renderJson(new ReturnMsg(true,"/code"));
		}
	}

	/**
	 * 生成随机验证码
	 * 存放session中
	 */
	private void createRandomCode(){
		setSessionAttr("code",UUID.randomUUID().toString());//随机验证码
	}

	private boolean hasTokenCookie(){
		javax.servlet.http.Cookie[] cookies = getRequest().getCookies();
		if(cookies != null){
			for(int i=0,len=cookies.length;i<len;i++){
				String name = cookies[i].getName();
				if("loginToken".equals(name) ){
					return true;
				}
			}
		}
		return false;
	}

}



