package com.business.log;

import com.model.Log;
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
public class LogValidator extends Validator {

    protected void validate(Controller controller) {
        validateInteger(1,"log.userid", 20,"useridMsg", "");
        validateString(1,"log.url", 1,200,"urlMsg", "");
        validateDate(1,"log.createTime", "createTimeMsg", "");

    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();

        Object errorStackMsg = controller.getAttr("errorStackMsg");
        if(errorStackMsg != null){
            flag = true;
            m.put("key","errorStack");
            m.put("businessType","edit");
            m.put("value",errorStackMsg);
            errorMsg.add(m);
        }
        m = new HashMap();


        Object useridMsg = controller.getAttr("useridMsg");
            if(useridMsg != null){
                flag = true;
                m.put("key","userid");
                m.put("businessType","int");
                m.put("value",useridMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object urlMsg = controller.getAttr("urlMsg");
            if(urlMsg != null){
                flag = true;
                m.put("key","url");
                m.put("businessType","string");
                m.put("value",urlMsg);
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