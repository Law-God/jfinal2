package com.index.article;

import com.business.item.ItemService;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.model.Article;
import com.model.Banner;

import java.util.List;

/**
 * 首页文章列表
 * ArticleController
 */
public class ArticleController extends Controller {
	public void index() {
		String sql = Db.getSql("index.articleList");
		List<Article> items = Article.dao.find(sql);
		setAttr("items",items);
		render("/index/article/index.html");
	}

	public void detail() {
		String sql = Db.getSql("index.articleDetail");
		Article item = Article.dao.findFirst(sql,getPara());
		setAttr("item",item);
		render("/index/article/detail.html");
	}
}



