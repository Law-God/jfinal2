package com.business.picture;

import com.model.Picture;
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
public class PictureValidator extends Validator {

    protected void validate(Controller controller) {
        validateString(1,"picture.title", 1,100,"titleMsg", "");
    validateRequireString(1,"picturepictureIdValidator","pictureIdMsg", "");
    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();


        Object pictureIdMsg = controller.getAttr("pictureIdMsg");
        if(pictureIdMsg != null){
            flag = true;
            m.put("key","pictureId");
            m.put("businessType","picture");
            m.put("value",pictureIdMsg);
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
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}