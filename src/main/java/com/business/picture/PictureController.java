package com.business.picture;

import com.common.ModelUtils;
import com.generator.upload.UploadService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.model.Picture;
import com.common.ReturnMsg;
import org.springframework.util.StringUtils;
import com.model.Upload;
import java.util.List;

/**
 *
 * Controller
 */
@Before(PictureInterceptor.class)
public class PictureController extends Controller {
	
	static PictureService service = new PictureService();
	static UploadService uploadService = new UploadService();

	public void index() {
		setAttr("picturePage", service.paginate(getParaToInt(0, 1), 10));
		render("picture.html");
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
	@Before(PictureValidator.class)
	public void save() {
		try{
			Picture model = getModel(Picture.class);
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
		Picture picture = service.findById(getParaToInt());
			String uploadpictureIdId = picture.get("pictureId");
			if(!StringUtils.isEmpty(uploadpictureIdId)){
				Upload uploadpictureId = uploadService.findById(new Integer(uploadpictureIdId ));
				setAttr("uploadPicture", uploadpictureId);
			}
        setAttr("picture", picture);
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(PictureValidator.class)
	public void update() {
		try{
				Picture picture = getModel(Picture.class);
				if(StringUtils.isEmpty(picture.get("pictureId"))){
					Upload upload = getModel(Upload.class);
					upload.save();
					picture.set("pictureId",upload.getUploadid());
				}
				picture.update();
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


