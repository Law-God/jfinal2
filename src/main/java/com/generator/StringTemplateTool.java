package com.generator;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zzk on 2017-11-22.
 * 字符串模板工具
 *
 */
public class StringTemplateTool {
    /**
     * 根据键值对填充字符串，如("${name}",{name:"xiaoming"})
     * 输出：
     * @param content
     * @param map
     * @return
     */
    public static String renderString(String content, Map<String, String> map){
        Set<Map.Entry<String, String>> sets = map.entrySet();
        for(Map.Entry<String, String> entry : sets) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll(entry.getValue());
        }
        return content;
    }
}
