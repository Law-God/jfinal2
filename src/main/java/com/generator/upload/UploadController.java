package com.generator.upload;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.common.ReturnMsg;
import com.model.Upload;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.upload.UploadFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
		UploadFile file = getFile();
		Upload upload = new Upload();
		upload.setFileName(file.getFileName());
		upload.setBusinessType(businessType);
		upload.setBusinessField(businessField);
		upload.setContentType(file.getContentType());
		upload.setOriginalFileName(file.getOriginalFileName());
		renderJson(new ReturnMsg(true, JSONObject.toJSONString(upload)));
	}

	public void download(){
		String uploadid = getPara();
		Upload upload = uploadService.findById(new Integer(uploadid));
		renderFile(upload.getFileName());
	}

	/**
	 * layui edit上传图片接口
	 */
	public void editUpload(){
		UploadFile file = getFile();
		Map map = new HashMap();
		map.put("code",0);
		map.put("msg","");
		Map data = new HashMap();
		data.put("src","/upload/editDownload?fileName=" + file.getFileName());
		data.put("title",file.getOriginalFileName());
		map.put("data",data);
		renderJson(map);
	}

	/**
	 * layui edit上传图片接口
	 */
	public void editDownload(){
		String fileName = getPara("fileName");
		renderFile(fileName);
	}

}


