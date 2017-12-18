package com.user;

import com.common.ReturnMsg;
import com.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.validate.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*  Validator
*/
public class UserValidator extends Validator {


    protected void validate(Controller controller) {
        
        validateString(true,"user.name", 1,127,"nameMsg", "姓名");


        validateInteger(true,"user.age", 11,"ageMsg", "年龄");

        validateDouble(true,"user.pay", 10,"payMsg", "薪资");


        validateText(true,"user.address", 21845,"addressMsg", "地址");

        validateBlob(true,"user.summary","summaryMsg", "简介");


    
    }

    protected void handleError(Controller controller) {
        controller.keepModel(User.class);
        /*String actionKey = getActionKey();
        if (actionKey.equals("/user/save")){
            controller.render("add.html");
        }else if (actionKey.equals("/user/update")){
            controller.render("edit.html");
        }*/
        boolean flag = false;
        List errorMsg = new ArrayList();
        Map m1 = new HashMap();
        Object nameMsg = controller.getAttr("nameMsg");
        if(nameMsg == null){
            flag = true;
        }
        m1.put("key","nameMsg");
        m1.put("sqlType","nameMsg");
        m1.put("value",nameMsg);
        errorMsg.add(m1);

        Map m2 = new HashMap();
        Object ageMsg = controller.getAttr("ageMsg");
        if(nameMsg == null){
            flag = true;
        }
        m2.put("key","ageMsg");
        m2.put("value",ageMsg);
        m2.put("sqlType","nameMsg");
        errorMsg.add(m2);

        Map m3 = new HashMap();
        Object payMsg = controller.getAttr("payMsg");
        if(payMsg == null){
            flag = true;
        }
        m3.put("key","payMsg");
        m3.put("value",payMsg);
        m3.put("sqlType","nameMsg");
        errorMsg.add(m3);

        Map m4 = new HashMap();
        Object addressMsg = controller.getAttr("addressMsg");
        if(addressMsg == null){
            flag = true;
        }
        m4.put("key","addressMsg");
        m4.put("value",addressMsg);
        m4.put("sqlType","nameMsg");
        errorMsg.add(m4);

        Map m5 = new HashMap();
        Object summaryMsg = controller.getAttr("summaryMsg");
        if(summaryMsg == null){
            flag = true;
        }
        m5.put("key","summaryMsg");
        m5.put("value",summaryMsg);
        m5.put("sqlType","nameMsg");
        errorMsg.add(m5);

        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}