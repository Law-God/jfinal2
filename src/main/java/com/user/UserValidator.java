package com.user;

import com.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
*  Validator
*/
public class UserValidator extends Validator {

    protected void validate(Controller controller) {
        //validateRequiredString("user.${column.name}", "${column.name}Msg", "${column.remarks}");
        //validateRequiredString("user.${column.name}", "${column.name}Msg", "${column.remarks}");
        //validateRequiredString("user.${column.name}", "${column.name}Msg", "${column.remarks}");

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