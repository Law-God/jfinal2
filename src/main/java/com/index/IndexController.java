package com.index;

import com.business.item.ItemService;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.model.Banner;
import com.model.Item;
import java.util.List;

/**
 * 首页
 * IndexController
 */
public class IndexController extends Controller {
	static ItemService itemService = new ItemService();
	public void index() {
		String bannerSql = Db.getSql("index.bannerList");
		List<Banner> bannerList = Banner.dao.find(bannerSql);
		setAttr("bannerList",bannerList);

		render("/index/index.html");
	}
}



