package com.business.user;

import com.model.User;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class UserService {

private static final User dao = new User().dao();

	public Page<User> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select t1.*,t2.* ","from user t1 left join upload t2 on t1.picture = t2.uploadid order by t1.id desc");
    }

    public User findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}