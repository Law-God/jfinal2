package com.login;

import com.business.user.UserService;
import com.common.ReturnMsg;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
		}else{
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



