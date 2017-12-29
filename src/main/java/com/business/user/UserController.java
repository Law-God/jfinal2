package com.business.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.model.Upload;
import com.model.User;
import com.common.ReturnMsg;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * Controller
 */
@Before(UserInterceptor.class)
public class UserController extends Controller {
	
	static UserService service = new UserService();
	
	public void index() {
		setAttr("userPage", service.paginate(getParaToInt(0, 1), 10));
		render("user.html");
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
	@Before(UserValidator.class)
	public void save() {
		try{
			getModel(User.class).save();
		}catch (Exception e){
			e.printStackTrace();
			renderJson(new ReturnMsg(false,"系统出错，请联系管理员"));
			return;
		}
		renderJson(new ReturnMsg(true,""));
	}
	
	public void edit() {
		setAttr("user", service.findById(getParaToInt()));
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(UserValidator.class)
	public void update() {
		try{
			getModel(User.class).update();
		}catch (Exception e){
			e.printStackTrace();
			renderJson(new ReturnMsg(false,"系统出错，请联系管理员"));
			return;
		}
		renderJson(new ReturnMsg(true,""));
	}
	
	public void delete() {
		try{
			String idParam = getPara();
			if(!StringUtils.isEmpty(idParam)){
				String[] ids = idParam.split(",");
				for(String id : ids){
					service.deleteById(new Integer(id));
				}
				renderJson(new ReturnMsg(true,""));
			}
			renderJson(new ReturnMsg(false,"操作失败"));
		}catch (Exception e){
			e.printStackTrace();
			renderJson(new ReturnMsg(false,"系统出错，请联系管理员"));
			return;
		}
		renderJson(new ReturnMsg(true,""));
	}

	public void upload(){
		UploadFile uploadFile = getFile();
		Upload upload = new Upload();
		upload.setFileName(uploadFile.getFileName());
		upload.setBusinessType("user");
		upload.setContentType(uploadFile.getContentType());
		upload.setOriginalFileName(uploadFile.getOriginalFileName());
		renderJson(new ReturnMsg(true, JSONObject.toJSONString(upload)));
	}
}


