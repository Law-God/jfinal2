package com.business.banner;

import com.model.Banner;
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
public class BannerValidator extends Validator {

    protected void validate(Controller controller) {
        validateString(1,"banner.title", 1,100,"titleMsg", "");
        validateInteger(1,"banner.order", 10,"orderMsg", "");
        validateRequireString(0,"banner.status","statusMsg", "是否可用");
    validateRequireString(0,"bannerpicIdValidator","picIdMsg", "");
    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();


        Object picIdMsg = controller.getAttr("picIdMsg");
        if(picIdMsg != null){
            flag = true;
            m.put("key","picId");
            m.put("businessType","picture");
            m.put("value",picIdMsg);
            errorMsg.add(m);
        }
        m = new HashMap();

        Object titleMsg = controller.getAttr("titleMsg");
            if(titleMsg != null){
                flag = true;
                m.put("key","title");
                m.put("businessType","string");
                m.put("value",titleMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object orderMsg = controller.getAttr("orderMsg");
            if(orderMsg != null){
                flag = true;
                m.put("key","order");
                m.put("businessType","int");
                m.put("value",orderMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object statusMsg = controller.getAttr("statusMsg");
            if(statusMsg != null){
                flag = true;
                m.put("key","status");
                m.put("businessType","radio");
                m.put("value",statusMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}