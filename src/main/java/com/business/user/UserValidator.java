package com.business.user;

import com.model.User;
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
public class UserValidator extends Validator {

    protected void validate(Controller controller) {
        validateRegexp(0,"user.username", "usernameMsg", "用户名不正确","^[\\S]{3}$");
        validateInteger(0,"user.age", 3,"ageMsg", "年龄");
        validateDate(0,"user.birthday", "birthdayMsg", "日期格式错误");
        validateRegexp(0,"user.phone", "phoneMsg", "手机号格式错误","^13\\d{9}$");
        validateEmail(0,"user.email", "emailMsg", "邮箱格式错误");
        validateUrl(0,"user.url", "urlMsg", "链接格式错误");
        validateIdentity(0,"user.idcard", "idcardMsg", "身份证号码错误");

        validateText(0,"user.summary", 0,"summaryMsg", "简介");
    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();

        Object addressMsg = controller.getAttr("addressMsg");
        if(addressMsg != null){
            flag = true;
            m.put("key","address");
            m.put("sqlType","string");
            m.put("value",addressMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object summaryMsg = controller.getAttr("summaryMsg");
        if(summaryMsg != null){
            flag = true;
            m.put("key","summary");
            m.put("sqlType","text");
            m.put("value",summaryMsg);
            errorMsg.add(m);
        }
        m = new HashMap();

        Object usernameMsg = controller.getAttr("usernameMsg");
            if(usernameMsg != null){
                flag = true;
                m.put("key","username");
                m.put("sqlType","string");
                m.put("value",usernameMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object ageMsg = controller.getAttr("ageMsg");
            if(ageMsg != null){
                flag = true;
                m.put("key","age");
                m.put("sqlType","int");
                m.put("value",ageMsg);
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
        Object phoneMsg = controller.getAttr("phoneMsg");
            if(phoneMsg != null){
                flag = true;
                m.put("key","phone");
                m.put("sqlType","string");
                m.put("value",phoneMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object emailMsg = controller.getAttr("emailMsg");
            if(emailMsg != null){
                flag = true;
                m.put("key","email");
                m.put("sqlType","string");
                m.put("value",emailMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object urlMsg = controller.getAttr("urlMsg");
            if(urlMsg != null){
                flag = true;
                m.put("key","url");
                m.put("sqlType","string");
                m.put("value",urlMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object idcardMsg = controller.getAttr("idcardMsg");
            if(idcardMsg != null){
                flag = true;
                m.put("key","idcard");
                m.put("sqlType","string");
                m.put("value",idcardMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}