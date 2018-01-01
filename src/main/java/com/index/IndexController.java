package com.index;

import com.business.item.ItemService;
import com.business.picture.PictureService;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.model.Item;
import com.model.Picture;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * IndexController
 */
public class IndexController extends Controller {
	static ItemService itemService = new ItemService();
	static PictureService pictureService = new PictureService();
	public void index() {
		Page<Item> item = itemService.paginate(1,1000);
		setSessionAttr("itemList",item.getList());

		Page<Picture> picture = pictureService.paginate(1,10);
		setSessionAttr("pictureList",picture.getList());
		render("index.html");
	}
}



