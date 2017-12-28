package com.common;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.validate.PatternUtil
 * 2016-08-03 9:46
 */
public final class PatternUtil {
    private final Logger log = Logger.getLogger(PatternUtil.class);

    /**
     * 全部匹配
     * @param string
     * @param regex
     * @return
     */
    public static boolean match(String string,String regex){
        return Pattern.compile(regex).matcher(string).matches();
    }

    /**
     * 部分匹配
     * @param string
     * @param regex
     * @return
     */
    public static boolean find(String string,String regex){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        return m.find() == true ? true : false;
    }
}
