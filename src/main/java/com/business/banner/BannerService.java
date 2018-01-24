package com.business.banner;

import com.model.Banner;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class BannerService {

private static final Banner dao = new Banner().dao();

	public Page<Banner> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from banner order by id desc");
    }

    public Banner findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}