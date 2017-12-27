package com.generator.code;

import com.alibaba.fastjson.JSONObject;
import com.common.ReturnMsg;
import com.generator.ControllerGenerator;
import com.generator.DigesterTool;
import com.generator.Dom4jXML;
import com.generator.ViewGenerator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.generator.ColumnMeta;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import org.springframework.beans.BeanUtils;

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
		TableMeta target = DigesterTool.readXml(name);
		TableMeta source = DigesterTool.readXml(name+"_view");
		if(source != null){
			BeanUtils.copyProperties(source,target);
		}
		setAttr("tableMeta",target);
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(CodeValidator.class)
	public void update() {
		String tableMetaJsonStr = getPara("tableMeta");
		TableMeta tableMeta =  JSONObject.parseObject(tableMetaJsonStr,TableMeta.class);
		String tableMetaName = tableMeta.name;
		tableMeta.setName(tableMetaName);
		Dom4jXML.generate(tableMeta,"_view");

		//生成java代码
		String controllerPackageName = "com.business";
		String modelPackageName = "com.model";
		ControllerGenerator controllerGenerator = new ControllerGenerator(controllerPackageName,modelPackageName);
		controllerGenerator.generate(tableMeta);

		//生成html代码
		for(ColumnMeta columnMeta : tableMeta.columnMetas ){
			String name = columnMeta.name;
			String layVerify = columnMeta.getLayVerify();
			int size = columnMeta.size;
			switch (layVerify){
				case "string" :
					columnMeta.layVerifyValue = name + "String" + size;
					break;
				case "int" :
					columnMeta.layVerifyValue = name + "Int" + size;
					break;
				case "double":
					columnMeta.layVerifyValue = name + "Double" + size;
					break;
				case "regexp":
					columnMeta.layVerifyValue = name + "Regexp";
					break;
				case "edit":
					columnMeta.layVerifyValue = name + "Edit";
					break;
				default:
					break;
			}
		}
		ViewGenerator viewGenerator = new ViewGenerator(tableMeta);
		viewGenerator.generate();

	}
	
	public void delete() {
		redirect("/blog");
	}
}


