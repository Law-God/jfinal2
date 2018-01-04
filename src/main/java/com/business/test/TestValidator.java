package com.business.test;

import com.model.Test;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.common.ReturnMsg;

/**
*  Validator
*/
public class TestValidator extends Validator {

    protected void validate(Controller controller) {
        validateRequireString(0,"test.picture","pictureMsg", "密码");
        validateDate(0,"test.createTime", "createTimeMsg", "");
    validateRequireString(0,"testfileValidator","fileMsg", "请上传文件");
    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();


        Object fileMsg = controller.getAttr("fileMsg");
        if(fileMsg != null){
            flag = true;
            m.put("key","file");
            m.put("businessType","file");
            m.put("value",fileMsg);
            errorMsg.add(m);
        }
        m = new HashMap();

        Object pictureMsg = controller.getAttr("pictureMsg");
            if(pictureMsg != null){
                flag = true;
                m.put("key","picture");
                m.put("businessType","password");
                m.put("value",pictureMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object createTimeMsg = controller.getAttr("createTimeMsg");
            if(createTimeMsg != null){
                flag = true;
                m.put("key","createTime");
                m.put("businessType","date");
                m.put("value",createTimeMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}