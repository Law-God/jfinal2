package com.generator.upload;

import com.jfinal.plugin.activerecord.Page;
import com.model.Upload;

/**
* Service
*/
public class UploadService {

private static final Upload dao = new Upload().dao();
    public Page<Upload> paginate(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "select *", "from upload order by uploadid desc");
    }

    public Upload findById(int id) {
        return dao.findById(id);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }
}