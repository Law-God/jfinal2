package com.business.book;

import com.model.Book;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class BookService {

private static final Book dao = new Book().dao();

	public Page<Book> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from book order by id desc");
    }

    public Book findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}