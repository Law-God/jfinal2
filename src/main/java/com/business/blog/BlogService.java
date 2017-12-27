package com.business.blog;

import com.model.Blog;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class BlogService {

private static final Blog dao = new Blog().dao();

	public Page<Blog> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from blog order by id desc");
    }

    public Blog findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}