package com.role;

import com.common.model.Role;
import com.jfinal.plugin.activerecord.LayUiPage;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class RoleService {

private static final Role dao = new Role().dao();

	public Page<Role> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from role order by id asc");
    }

    public LayUiPage<Role> layUiPaginate(int pageNumber, int pageSize) {
        return new LayUiPage(paginate(pageNumber,pageSize));
    }

    public Role findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}