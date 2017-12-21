package com.register;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.common.model.Register;
import com.common.ReturnMsg;

/**
 * 
 * Controller
 */
@Before(RegisterInterceptor.class)
public class RegisterController extends Controller {
	
	static RegisterService service = new RegisterService();
	
	public void index() {
		setAttr("registerPage", service.paginate(getParaToInt(0, 1), 10));
		render("register.html");
	}

	public void list() {
		int page = Integer.valueOf(getPara("page","1"));
		int limit = Integer.valueOf(getPara("limit","10"));
		renderJson(service.layUiPaginate(page, limit));
	}

	public void add() {
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(RegisterValidator.class)
	public void save() {
		try{
			getModel(Register.class).save();
		}catch (Exception e){
			e.printStackTrace();
			renderJson(new ReturnMsg(false,"系统出错，请联系管理员"));
			return;
		}
		renderJson(new ReturnMsg(true,""));
	}
	
	public void edit() {
		setAttr("register", service.findById(getParaToInt()));
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(RegisterValidator.class)
	public void update() {
		try{
			getModel(Register.class).update();
		}catch (Exception e){
			e.printStackTrace();
			renderJson(new ReturnMsg(false,"系统出错，请联系管理员"));
			return;
		}
		renderJson(new ReturnMsg(true,""));
	}
	
	public void delete() {
		service.deleteById(getParaToInt());
		redirect("/register");
	}
}


