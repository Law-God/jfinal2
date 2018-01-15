package com.business.book;

import com.common.ModelUtils;
import com.generator.upload.UploadService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.model.Book;
import com.common.ReturnMsg;
import org.springframework.util.StringUtils;
import com.model.Upload;
import java.util.List;

/**
 *
 * Controller
 */
@Before(BookInterceptor.class)
public class BookController extends Controller {
	
	static BookService service = new BookService();
	static UploadService uploadService = new UploadService();

	public void index() {
		setAttr("bookPage", service.paginate(getParaToInt(0, 1), 10));
		render("book.html");
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
	@Before(BookValidator.class)
	public void save() {
		try{
        	getModel(Book.class).save();


		}catch (Exception e){
			e.printStackTrace();
			renderJson(new ReturnMsg(false,"系统出错，请联系管理员"));
			return;
		}
		renderJson(new ReturnMsg(true,""));
	}
	
	public void edit() {
		Book book = service.findById(getParaToInt());
        	setAttr("book", book);
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(BookValidator.class)
	public void update() {
		try{
            getModel(Book.class).update();
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


