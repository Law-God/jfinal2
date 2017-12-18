package com.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-12-18.
 */
public class ReturnMsg {
    public boolean success;
    public String msg;
    public int errorType;//错误类型  0:一般错误  1：验证错误
    public static final int ERROR_TYPE_1 = 1;
    List msgList = new ArrayList();

    public ReturnMsg(boolean success,String msg){
        this.success = success;
        this.msg = msg;
    }

    public ReturnMsg(boolean success,int errorType,List msgList){
        this.success = success;
        this.errorType = errorType;
        this.msgList = msgList;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public List getMsgList() {
        return msgList;
    }

    public void setMsgList(List msgList) {
        this.msgList = msgList;
    }
}
