package com.business.code;

import com.common.ReturnMsg;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * 
 * Controller
 */
@Before(CodeInterceptor.class)
public class CodeController extends Controller {
	
	static CodeService service = new CodeService();
	
	public void index() {
		setAttr("codePage", service.paginate(getParaToInt(0, 1), 10));
		render("code.html");
	}

	public void list() {
		int page = Integer.valueOf(getPara("page","1"));
		int limit = Integer.valueOf(getPara("limit","10"));
		renderJson(service.paginate(page, limit));
	}

	public void add() {
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(CodeValidator.class)
	public void save() {

		renderJson(new ReturnMsg(true,""));
	}
	
	public void edit() {

	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(CodeValidator.class)
	public void update() {

		renderJson(new ReturnMsg(true,""));
	}
	
	public void delete() {
		redirect("/blog");
	}
}


