package com.user;

import com.common.model.User;
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
public class UserValidator extends Validator {

    protected void validate(Controller controller) {
                                
                        validateString(true,"user.name", 1,25,"nameMsg", "姓名");
                                        
                        validateInteger(true,"user.sex", 1,"sexMsg", "性别");
                                        
                        validateInteger(true,"user.age", 3,"ageMsg", "年龄");
                                        
                                        
                        validateDouble(true,"user.pay", 10,"payMsg", "薪资");
                
        
            validateText(true,"user.address", 21845,"addressMsg", "地址");
            
            validateBlob(true,"user.summary","summaryMsg", "简介");
    
    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();
        Object nameMsg = controller.getAttr("nameMsg");
        if(nameMsg != null){
            flag = true;
            m.put("key","name");
            m.put("sqlType","string");
            m.put("value",nameMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object sexMsg = controller.getAttr("sexMsg");
        if(sexMsg != null){
            flag = true;
            m.put("key","sex");
            m.put("sqlType","char");
            m.put("value",sexMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object ageMsg = controller.getAttr("ageMsg");
        if(ageMsg != null){
            flag = true;
            m.put("key","age");
            m.put("sqlType","int");
            m.put("value",ageMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object birthdayMsg = controller.getAttr("birthdayMsg");
        if(birthdayMsg != null){
            flag = true;
            m.put("key","birthday");
            m.put("sqlType","date");
            m.put("value",birthdayMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object payMsg = controller.getAttr("payMsg");
        if(payMsg != null){
            flag = true;
            m.put("key","pay");
            m.put("sqlType","double");
            m.put("value",payMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object addressMsg = controller.getAttr("addressMsg");
        if(addressMsg != null){
            flag = true;
            m.put("key","address");
            m.put("sqlType","text");
            m.put("value",addressMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object summaryMsg = controller.getAttr("summaryMsg");
        if(summaryMsg != null){
            flag = true;
            m.put("key","summary");
            m.put("sqlType","longtext");
            m.put("value",summaryMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}