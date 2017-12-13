package com.role;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.common.model.Role;

/**
 * 
 * Controller
 */
@Before(RoleInterceptor.class)
public class RoleController extends Controller {
	
	static RoleService service = new RoleService();
	
	public void index() {
		setAttr("rolePage", service.paginate(getParaToInt(0, 1), 10));
		render("role.html");
	}

	public void list() {
		int page = Integer.valueOf(getPara("page","1"));
		int limit = Integer.valueOf(getPara("limit","10"));
		renderJson(service.layUiPaginate(getParaToInt(page, 1), limit));
	}

	public void add() {
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(RoleValidator.class)
	public void save() {
		getModel(Role.class).save();
		redirect("/role");
	}
	
	public void edit() {
		setAttr("role", service.findById(getParaToInt()));
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(RoleValidator.class)
	public void update() {
		getModel(Role.class).update();
		redirect("/role");
	}
	
	public void delete() {
		service.deleteById(getParaToInt());
		redirect("/role");
	}
}


