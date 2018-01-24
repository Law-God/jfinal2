package com.business.banner;

import com.common.ModelUtils;
import com.generator.upload.UploadService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.model.Banner;
import com.common.ReturnMsg;
import org.springframework.util.StringUtils;
import com.model.Upload;
import java.util.List;

/**
 *
 * Controller
 */
@Before(BannerInterceptor.class)
public class BannerController extends Controller {
	
	static BannerService service = new BannerService();
	static UploadService uploadService = new UploadService();

	public void index() {
		setAttr("bannerPage", service.paginate(getParaToInt(0, 1), 10));
		render("banner.html");
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
	@Before(BannerValidator.class)
	public void save() {
		try{
			Banner model = getModel(Banner.class);
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
		Banner banner = service.findById(getParaToInt());
			String uploadpicIdId = banner.get("picId");
			if(!StringUtils.isEmpty(uploadpicIdId)){
				Upload uploadpicId = uploadService.findById(new Integer(uploadpicIdId ));
				setAttr("uploadPicture", uploadpicId);
			}
        setAttr("banner", banner);
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(BannerValidator.class)
	public void update() {
		try{
				Banner banner = getModel(Banner.class);
				if(StringUtils.isEmpty(banner.get("picId"))){
					Upload upload = getModel(Upload.class);
					upload.save();
					banner.set("picId",upload.getUploadid());
				}
				banner.update();
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


