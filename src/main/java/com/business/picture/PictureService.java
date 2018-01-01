package com.business.picture;

import com.model.Picture;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class PictureService {

private static final Picture dao = new Picture().dao();

	public Page<Picture> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from picture order by id desc");
    }

    public Picture findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}