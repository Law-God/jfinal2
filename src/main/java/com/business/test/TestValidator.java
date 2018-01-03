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
        validateString(1,"test.book", 1,100,"bookMsg", "");
        validateRegexp(1,"test.password", "passwordMsg", "密码格式错误","^[a-zA-Z\\d]{6}$");

    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();



        Object bookMsg = controller.getAttr("bookMsg");
            if(bookMsg != null){
                flag = true;
                m.put("key","book");
                m.put("businessType","string");
                m.put("value",bookMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object passwordMsg = controller.getAttr("passwordMsg");
            if(passwordMsg != null){
                flag = true;
                m.put("key","password");
                m.put("businessType","password");
                m.put("value",passwordMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}