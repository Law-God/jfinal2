package com.business.article;

import com.model.Article;
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
public class ArticleValidator extends Validator {

    protected void validate(Controller controller) {
        validateString(0,"article.title", 1,255,"titleMsg", "");
        validateString(1,"article.descript", 1,255,"descriptMsg", "");
        validateRequireString(0,"article.status","statusMsg", "是否可用");
    validateRequireString(1,"articleattachmentValidator","attachmentMsg", "");
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

        Object attachmentMsg = controller.getAttr("attachmentMsg");
        if(attachmentMsg != null){
            flag = true;
            m.put("key","attachment");
            m.put("businessType","file");
            m.put("value",attachmentMsg);
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
        Object descriptMsg = controller.getAttr("descriptMsg");
            if(descriptMsg != null){
                flag = true;
                m.put("key","descript");
                m.put("businessType","string");
                m.put("value",descriptMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object statusMsg = controller.getAttr("statusMsg");
            if(statusMsg != null){
                flag = true;
                m.put("key","status");
                m.put("businessType","radio");
                m.put("value",statusMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}