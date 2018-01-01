package com.generator.upload;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.common.ReturnMsg;
import com.model.Upload;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.upload.UploadFile;

/**
 *
 * Controller
 */
@Before(UploadInterceptor.class)
public class UploadController extends Controller {
	static UploadService uploadService = new UploadService();

	public void upload(){
		String businessType = getPara("businessType");
		String businessField = getPara("businessField");
		UploadFile uploadFile = getFile();
		Upload upload = new Upload();
		upload.setFileName(uploadFile.getFileName());
		upload.setBusinessType(businessType);
		upload.setBusinessField(businessField);
		upload.setContentType(uploadFile.getContentType());
		upload.setOriginalFileName(uploadFile.getOriginalFileName());
		renderJson(new ReturnMsg(true, JSONObject.toJSONString(upload)));
	}

	public void download(){
		String uploadid = getPara();
		Upload upload = uploadService.findById(new Integer(uploadid));
		renderFile(upload.getFileName());
	}
}


