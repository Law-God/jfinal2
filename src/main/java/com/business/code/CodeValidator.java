package com.business.code;

import com.common.ReturnMsg;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*  Validator
*/
public class CodeValidator extends Validator {

    protected void validate(Controller controller) {
                                
                        validateString(true,"blog.title", 1,100,"titleMsg", "标题");
                
        
            validateText(true,"blog.content", 21845,"contentMsg", "内容");
    
    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();
        Object titleMsg = controller.getAttr("titleMsg");
        if(titleMsg != null){
            flag = true;
            m.put("key","title");
            m.put("sqlType","string");
            m.put("value",titleMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object contentMsg = controller.getAttr("contentMsg");
        if(contentMsg != null){
            flag = true;
            m.put("key","content");
            m.put("sqlType","text");
            m.put("value",contentMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag, ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}