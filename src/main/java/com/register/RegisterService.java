package com.register;

import com.common.model.Register;
import com.jfinal.plugin.activerecord.LayUiPage;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class RegisterService {

private static final Register dao = new Register().dao();

	public Page<Register> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from register order by id desc");
    }

    public LayUiPage<Register> layUiPaginate(int pageNumber, int pageSize) {
        return new LayUiPage(paginate(pageNumber,pageSize));
    }

    public Register findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}