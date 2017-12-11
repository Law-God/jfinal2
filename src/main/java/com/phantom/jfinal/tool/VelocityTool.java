package com.phantom.jfinal.tool;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by zzk on 2017-11-29.
 */
public class VelocityTool {
    private static VelocityEngine getInstance(){
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        ve.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        ve.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        ve.init();
        return ve;
    }

    /**
     * 填充模板内容
     * @param templatePath
     * @param params
     * @return
     */
    public static String fillTemplateContent(String templatePath, Map<String,Object> params){
        VelocityEngine ve = getInstance();
        Template template = ve.getTemplate(templatePath);
        StringWriter sw = new StringWriter();
        template.merge(fillVelocityContext(params), sw);
        return sw.toString();
    }

    /**
     * 填充模板内容参数
     * @param params
     * @return
     */
    private static VelocityContext fillVelocityContext(Map<String,Object> params){
        VelocityContext ctx = new VelocityContext();
        if(params != null){
            for(String key : params.keySet()){
                ctx.put(key,params.get(key));
            }
        }
        return ctx;
    }

}
