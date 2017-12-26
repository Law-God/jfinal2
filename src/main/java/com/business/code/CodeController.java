package com.business.code;

import com.alibaba.fastjson.JSONObject;
import com.common.ReturnMsg;
import com.generator.DigesterTool;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.generator.TableMeta;

import java.util.ArrayList;
import java.util.List;

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
		TableMeta tableMeta = getModel(TableMeta.class);
		renderJson(new ReturnMsg(true,""));
	}
	
	public void edit() {
		String name = getPara("name");
		TableMeta tableMeta = DigesterTool.readXml(name);
		setAttr("tableMeta",tableMeta);
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(CodeValidator.class)
	public void update() {
		String tableMetaJsonStr = getPara("tableMeta");
		TableMeta TableMeta =  JSONObject.parseObject(tableMetaJsonStr,TableMeta.class);
	}
	
	public void delete() {
		redirect("/blog");
	}
}


