package com.common;

import org.apache.log4j.Logger;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * phantom-util
 * com.phantom.util.constant.PatternConstant
 * 2016-07-28 20:26
 * 正则表达式常量
 */
public final class PatternConstant {
    private final Logger log = Logger.getLogger(PatternConstant.class);
    //日期，匹配平年、闰年
    public static final String PATTERN_DATE = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
    //时间
    public static final String PATTERN_TIME = "^(0\\d{1}|1\\d{1}|2[0-3]):([0-5]\\d{1}):([0-5]\\d{1})$";
    //日期+时间
    public static final String PATTERN_DATE_TIME = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)\\s(0\\d{1}|1\\d{1}|2[0-3]):([0-5]\\d{1}):([0-5]\\d{1})$";
    //中文
    public static final String CHINESE_REGEX_DEFAULT = "[\\u4E00-\\u9FA5]";
    //
    public static final String CHINESE_REGEX_EXTEND = "^[\\u4E00-\\u9FA5]{%s,%s}$";
    //电子邮箱
    public static final String EMAIL_REGEX = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
    //电话号码
    public static final String TELEPHONE_REGEX="^1[3|4|5|7|8]\\d{9}$";
    //ip地址
    public static final String IP_REGEX="^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";
    //qq
    public static final String QQ_REGEX="^[1-9]([0-9]{5,11})$";
    //双字节字符
    public static final String DOUBLE_BYTE_CHAR="[^\\x00-\\xff]";
    //数字
    public static final String NUMBER_REGEX = "\\d+";

    //url
    public static final String URL_REGEX = "(^#)|(^http(s*):\\/\\/[^\\s]+\\.[^\\s]+)";

    //url
    public static final String ID_CARD_REGEX = "(^\\d{15}$)|(^\\d{17}(x|X|\\d)$)";
}
