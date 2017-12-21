package com.register;

import com.common.model.Register;
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
public class RegisterValidator extends Validator {

    protected void validate(Controller controller) {
                                
                        validateString(true,"register.username", 1,20,"usernameMsg", "用户名");
                                        
                                        
                        validateInteger(true,"register.cardtype", 1,"cardtypeMsg", "证件类别");
                                        
                        validateString(false,"register.cardno", 1,10,"cardnoMsg", "证件编号");
                
        
            validateText(true,"register.address", 21845,"addressMsg", "家庭地址");
    
    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();
        Object usernameMsg = controller.getAttr("usernameMsg");
        if(usernameMsg != null){
            flag = true;
            m.put("key","username");
            m.put("sqlType","string");
            m.put("value",usernameMsg);
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
        Object cardtypeMsg = controller.getAttr("cardtypeMsg");
        if(cardtypeMsg != null){
            flag = true;
            m.put("key","cardtype");
            m.put("sqlType","char");
            m.put("value",cardtypeMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object cardnoMsg = controller.getAttr("cardnoMsg");
        if(cardnoMsg != null){
            flag = true;
            m.put("key","cardno");
            m.put("sqlType","string");
            m.put("value",cardnoMsg);
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
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}