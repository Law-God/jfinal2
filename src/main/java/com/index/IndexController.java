package com.index;

import com.business.item.ItemService;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.model.Item;
import java.util.List;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * IndexController
 */
public class IndexController extends Controller {
	static ItemService itemService = new ItemService();
	public void index() {
		Page<Item> item = itemService.paginate(1,1000);
		setSessionAttr("itemList",item.getList());

		String bannerSql = Db.getSql("index.bannerList");
		List<Record> bannerList = Db.find(bannerSql);
		setAttr("bannerList",bannerList);

		render("index.html");
	}
}



