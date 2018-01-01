package com.business.blog;

import com.model.Blog;
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
public class BlogValidator extends Validator {

    protected void validate(Controller controller) {
        validateString(0,"blog.title", 1,100,"titleMsg", "标题长度0~100个字符");

    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();

        Object contentMsg = controller.getAttr("contentMsg");
        if(contentMsg != null){
            flag = true;
            m.put("key","content");
            m.put("businessType","edit");
            m.put("value",contentMsg);
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