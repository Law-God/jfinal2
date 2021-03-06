package com.business.test;

import com.common.ModelUtils;
import com.generator.upload.UploadService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.model.Test;
import com.common.ReturnMsg;
import org.springframework.util.StringUtils;
import com.model.Upload;
import java.util.List;

/**
 *
 * Controller
 */
@Before(TestInterceptor.class)
public class TestController extends Controller {
	
	static TestService service = new TestService();
	static UploadService uploadService = new UploadService();

	public void index() {
		setAttr("testPage", service.paginate(getParaToInt(0, 1), 10));
		render("test.html");
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
	@Before(TestValidator.class)
	public void save() {
		try{
			Test model = getModel(Test.class);
        	List<Upload> uploadList = ModelUtils.batchInjectModel(getRequest(),Upload.class,"upload");
            for(Upload upload : uploadList){
            	upload.save();
            	String businessField = upload.getBusinessField();
            	model.set(businessField.toString(),upload.getUploadid());
            }
            model.save();


		}catch (Exception e){
			e.printStackTrace();
			renderJson(new ReturnMsg(false,"系统出错，请联系管理员"));
			return;
		}
		renderJson(new ReturnMsg(true,""));
	}
	
	public void edit() {
		Test test = service.findById(getParaToInt());
			String uploadfileId = test.get("file");
			if(!StringUtils.isEmpty(uploadfileId)){
				Upload uploadfile = uploadService.findById(new Integer(uploadfileId ));
				setAttr("uploadFile", uploadfile);
			}
        setAttr("test", test);
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(TestValidator.class)
	public void update() {
		try{
				Test test = getModel(Test.class);
				if(StringUtils.isEmpty(test.get("file"))){
					Upload upload = getModel(Upload.class);
					upload.save();
					test.set("file",upload.getUploadid());
				}
				test.update();
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
}


