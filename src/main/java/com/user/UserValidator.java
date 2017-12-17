package com.user;

import com.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

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
        String actionKey = getActionKey();
        if (actionKey.equals("/user/save")){
            controller.render("add.html");
        }else if (actionKey.equals("/user/update")){
            controller.render("edit.html");
        }
    }
}