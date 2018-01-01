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
        validateRegexp(1,"user.username", "usernameMsg", "用户名不正确","^[\\S]{3}$");
        validateInteger(1,"user.age", 3,"ageMsg", "");
        validateDate(1,"user.birthday", "birthdayMsg", "日期格式错误");
        validateRegexp(1,"user.phone", "phoneMsg", "手机号格式错误","^13\\d{9}$");
        validateEmail(1,"user.email", "emailMsg", "邮箱格式错误");
        validateUrl(1,"user.url", "urlMsg", "链接格式错误");
        validateIdentity(1,"user.idcard", "idcardMsg", "身份证号码错误");
        validateRequireString(1,"upload.fileName","sexMsg", "性别");
    //validateRequireString(0,"upload.fileName","pictureMsg", "头像");

        validateText(1,"user.address", 0,"addressMsg", "地址");
    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();

        Object addressMsg = controller.getAttr("addressMsg");
        if(addressMsg != null){
            flag = true;
            m.put("key","address");
            m.put("businessType","text");
            m.put("value",addressMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object summaryMsg = controller.getAttr("summaryMsg");
        if(summaryMsg != null){
            flag = true;
            m.put("key","summary");
            m.put("businessType","edit");
            m.put("value",summaryMsg);
            errorMsg.add(m);
        }
        m = new HashMap();

        Object pictureMsg = controller.getAttr("pictureMsg");
        if(pictureMsg != null){
            flag = true;
            m.put("key","picture");
            m.put("businessType","picture");
            m.put("value",pictureMsg);
            errorMsg.add(m);
        }
        m = new HashMap();
        Object fileMsg = controller.getAttr("fileMsg");
        if(fileMsg != null){
            flag = true;
            m.put("key","file");
            m.put("businessType","file");
            m.put("value",fileMsg);
            errorMsg.add(m);
        }
        m = new HashMap();

        Object usernameMsg = controller.getAttr("usernameMsg");
            if(usernameMsg != null){
                flag = true;
                m.put("key","username");
                m.put("businessType","string");
                m.put("value",usernameMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object ageMsg = controller.getAttr("ageMsg");
            if(ageMsg != null){
                flag = true;
                m.put("key","age");
                m.put("businessType","int");
                m.put("value",ageMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object birthdayMsg = controller.getAttr("birthdayMsg");
            if(birthdayMsg != null){
                flag = true;
                m.put("key","birthday");
                m.put("businessType","date");
                m.put("value",birthdayMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object phoneMsg = controller.getAttr("phoneMsg");
            if(phoneMsg != null){
                flag = true;
                m.put("key","phone");
                m.put("businessType","string");
                m.put("value",phoneMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object emailMsg = controller.getAttr("emailMsg");
            if(emailMsg != null){
                flag = true;
                m.put("key","email");
                m.put("businessType","string");
                m.put("value",emailMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object urlMsg = controller.getAttr("urlMsg");
            if(urlMsg != null){
                flag = true;
                m.put("key","url");
                m.put("businessType","string");
                m.put("value",urlMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object idcardMsg = controller.getAttr("idcardMsg");
            if(idcardMsg != null){
                flag = true;
                m.put("key","idcard");
                m.put("businessType","string");
                m.put("value",idcardMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object sexMsg = controller.getAttr("sexMsg");
            if(sexMsg != null){
                flag = true;
                m.put("key","sex");
                m.put("businessType","radio");
                m.put("value",sexMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}