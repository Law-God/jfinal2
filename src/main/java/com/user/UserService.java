package com.user;

import com.common.model.User;
import com.jfinal.plugin.activerecord.LayUiPage;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class UserService {

private static final User dao = new User().dao();

	public Page<User> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from user order by id asc");
    }

    public LayUiPage<User> layUiPaginate(int pageNumber, int pageSize) {
        return new LayUiPage(paginate(pageNumber,pageSize));
    }

    public User findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}