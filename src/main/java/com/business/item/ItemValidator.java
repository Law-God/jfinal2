package com.business.item;

import com.model.Item;
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
public class ItemValidator extends Validator {

    protected void validate(Controller controller) {
        validateString(0,"item.itemCode", 1,6,"itemCodeMsg", "");
        validateString(0,"item.itemSup", 1,6,"itemSupMsg", "");
        validateString(0,"item.itemName", 1,100,"itemNameMsg", "");
        validateString(0,"item.itemUrl", 1,100,"itemUrlMsg", "");
        validateDate(0,"item.createDate", "createDateMsg", "");
        validateRequireString(1,"item.enable","enableMsg", "是否可用");
        validateString(0,"item.itemSub", 1,6,"itemSubMsg", "");
    }

    protected void handleError(Controller controller) {
        boolean flag = false;
        List errorMsg = new ArrayList();

        Map m = new HashMap();



        Object itemCodeMsg = controller.getAttr("itemCodeMsg");
            if(itemCodeMsg != null){
                flag = true;
                m.put("key","itemCode");
                m.put("businessType","string");
                m.put("value",itemCodeMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object itemSupMsg = controller.getAttr("itemSupMsg");
            if(itemSupMsg != null){
                flag = true;
                m.put("key","itemSup");
                m.put("businessType","string");
                m.put("value",itemSupMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object itemNameMsg = controller.getAttr("itemNameMsg");
            if(itemNameMsg != null){
                flag = true;
                m.put("key","itemName");
                m.put("businessType","string");
                m.put("value",itemNameMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object itemUrlMsg = controller.getAttr("itemUrlMsg");
            if(itemUrlMsg != null){
                flag = true;
                m.put("key","itemUrl");
                m.put("businessType","string");
                m.put("value",itemUrlMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object createDateMsg = controller.getAttr("createDateMsg");
            if(createDateMsg != null){
                flag = true;
                m.put("key","createDate");
                m.put("businessType","date");
                m.put("value",createDateMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object enableMsg = controller.getAttr("enableMsg");
            if(enableMsg != null){
                flag = true;
                m.put("key","enable");
                m.put("businessType","radio");
                m.put("value",enableMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        Object itemSubMsg = controller.getAttr("itemSubMsg");
            if(itemSubMsg != null){
                flag = true;
                m.put("key","itemSub");
                m.put("businessType","string");
                m.put("value",itemSubMsg);
                errorMsg.add(m);
            }
        m = new HashMap();
        if(flag){
            controller.renderJson(new ReturnMsg(!flag,ReturnMsg.ERROR_TYPE_1,errorMsg));
        }
    }
}