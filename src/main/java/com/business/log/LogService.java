package com.business.log;

import com.model.Log;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class LogService {

private static final Log dao = new Log().dao();

	public Page<Log> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from log order by id desc");
    }

    public Log findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}