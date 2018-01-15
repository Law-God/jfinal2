package com.business.book;

import com.model.Book;
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
public class BookValidator extends Validator {

    protected void validate(Controller controller) {
        validateString(0,"book.bookname", 1,100,"booknameMsg", "");
        validateString(1,"book.descript", 1,1000,"descriptMsg", "");
        validateString(0,"book.auth", 1,100,"authMsg", "");
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


        Object booknameMsg = controller.getAttr("booknameMsg");
            if(booknameMsg != null){
                flag = true;
                m.put("key","bookname");
                m.put("businessType","string");
                m.put("value",booknameMsg);
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
        Object authMsg = controller.getAttr("authMsg");
            if(authMsg != null){
                flag = true;
                m.put("key","auth");
                m.put("businessType","string");
                m.put("value",authMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}