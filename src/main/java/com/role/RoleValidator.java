package com.role;

import com.common.model.Role;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
*  Validator
*/
public class RoleValidator extends Validator {

    protected void validate(Controller controller) {
        
        validateString(true,"role.role_name", 1,50,"role_nameMsg", "角色名称");
        
        validateString(true,"role.role_remrk", 1,100,"role_remrkMsg", "角色描述");


    }

    protected void handleError(Controller controller) {
        controller.keepModel(Role.class);
        String actionKey = getActionKey();
        if (actionKey.equals("/role/save")){
            controller.render("add.html");
        }else if (actionKey.equals("/role/update")){
            controller.render("edit.html");
        }
    }
}