package com.business.user;

import com.common.ModelUtils;
import com.generator.upload.UploadService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.model.User;
import com.common.ReturnMsg;
import org.springframework.util.StringUtils;
import com.model.Upload;
import java.util.List;

/**
 *
 * Controller
 */
@Before(UserInterceptor.class)
public class UserController extends Controller {
	
	static UserService service = new UserService();
	static UploadService uploadService = new UploadService();

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
        	User model = getModel(User.class);
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
		User user = service.findById(getParaToInt());
			String uploadpictureId = user.get("picture");
			if(!StringUtils.isEmpty(uploadpictureId)){
				Upload uploadpicture = uploadService.findById(new Integer(uploadpictureId ));
				setAttr("uploadPicture", uploadpicture);
			}
			String uploadfileId = user.get("file");
			if(!StringUtils.isEmpty(uploadfileId)){
				Upload uploadfile = uploadService.findById(new Integer(uploadfileId ));
				setAttr("uploadFile", uploadfile);
			}
        setAttr("user", user);
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(UserValidator.class)
	public void update() {
		try{
				User user = getModel(User.class);
				if(StringUtils.isEmpty(user.get("picture"))){
					Upload upload = getModel(Upload.class);
					upload.save();
					user.set("picture",upload.getUploadid());
				}
				if(StringUtils.isEmpty(user.get("file"))){
					Upload upload = getModel(Upload.class);
					upload.save();
					user.set("file",upload.getUploadid());
				}
				user.update();
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


