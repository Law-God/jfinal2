package com.business.article;

import com.common.ModelUtils;
import com.generator.upload.UploadService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.model.Article;
import com.common.ReturnMsg;
import org.springframework.util.StringUtils;
import com.model.Upload;
import java.util.List;

/**
 *
 * Controller
 */
@Before(ArticleInterceptor.class)
public class ArticleController extends Controller {
	
	static ArticleService service = new ArticleService();
	static UploadService uploadService = new UploadService();

	public void index() {
		setAttr("articlePage", service.paginate(getParaToInt(0, 1), 10));
		render("article.html");
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
	@Before(ArticleValidator.class)
	public void save() {
		try{
			Article model = getModel(Article.class);
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
		Article article = service.findById(getParaToInt());
			String uploadattachmentId = article.get("attachment");
			if(!StringUtils.isEmpty(uploadattachmentId)){
				Upload uploadattachment = uploadService.findById(new Integer(uploadattachmentId ));
				setAttr("uploadFile", uploadattachment);
			}
        setAttr("article", article);
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(ArticleValidator.class)
	public void update() {
		try{
				Article article = getModel(Article.class);
				if(StringUtils.isEmpty(article.get("attachment"))){
					Upload upload = getModel(Upload.class);
					upload.save();
					article.set("attachment",upload.getUploadid());
				}
				article.update();
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


