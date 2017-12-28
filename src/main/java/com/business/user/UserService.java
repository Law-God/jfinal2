package com.business.user;

import com.model.User;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class UserService {

private static final User dao = new User().dao();

	public Page<User> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from user order by id desc");
    }

    public User findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}