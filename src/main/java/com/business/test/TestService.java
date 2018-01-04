package com.business.test;

import com.model.Test;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class TestService {

private static final Test dao = new Test().dao();

	public Page<Test> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from test order by testId desc");
    }

    public Test findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}