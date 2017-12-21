package com.role;

import com.common.model.Role;
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
public class RoleValidator extends Validator {

    protected void validate(Controller controller) {
                                
                        validateString(true,"role.role_name", 1,50,"role_nameMsg", "角色名称");
                                        
                        validateString(true,"role.role_remrk", 1,100,"role_remrkMsg", "角色描述");
                

    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();
        Object role_nameMsg = controller.getAttr("role_nameMsg");
        if(role_nameMsg != null){
            flag = true;
            m.put("key","role_name");
            m.put("sqlType","string");
            m.put("value",role_nameMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object role_remrkMsg = controller.getAttr("role_remrkMsg");
        if(role_remrkMsg != null){
            flag = true;
            m.put("key","role_remrk");
            m.put("sqlType","string");
            m.put("value",role_remrkMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}