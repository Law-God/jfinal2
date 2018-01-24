package com.business.article;

import com.model.Article;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class ArticleService {

private static final Article dao = new Article().dao();

	public Page<Article> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from article order by id desc");
    }

    public Article findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}