package com.jfinal.plugin.activerecord.generator;

import com.jfinal.kit.LogKit;
import com.phantom.jfinal.tool.StringTemplateTool;
import com.phantom.jfinal.tool.VelocityTool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zzk on 2017-11-20.
 */
public class ControllerGenerator {
    protected String controllerOutputDir;
    protected String controllerPackageName;
    public ModelGenerator modelGenerator;

    public ControllerGenerator(String controllerPackageName,String controllerOutputDir){
        this.controllerPackageName = controllerPackageName;
        this.controllerOutputDir = controllerOutputDir;
    }

    public void generate(List<TableMeta> tableMetas) {
        System.out.println("Generate controllerOutputDir file ...");
        System.out.println("controllerOutputDir Output Dir: " + controllerOutputDir);
        System.out.println("modelPackageName : " + modelGenerator.modelPackageName);
        for(TableMeta tableMeta : tableMetas){
            writeToFile(tableMeta);
        }
    }

    /**
     * _MappingKit.java 覆盖写入
     */
    protected void writeToFile(TableMeta tableMeta) {
        FileWriter fw = null;
        try {
            String className = tableMeta.name.substring(0, 1).toUpperCase() + tableMeta.name.substring(1);
            String tableName = tableMeta.name;

            File dir = new File(controllerOutputDir + File.separator + tableName);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String controller = controllerOutputDir + File.separator + tableName + File.separator + className + "Controller.java";
            fw = new FileWriter(controller);

            Map param = new HashMap();
            param.put("package",controllerPackageName+"."+ tableName);//包名
            param.put("modelPackageName",modelGenerator.modelPackageName);
            param.put("tableName",tableName);
            param.put("className",className);
            param.put("columns",tableMeta.getColumns());
            fw.write(VelocityTool.fillTemplateContent("velocity/controller.vm",param));
            fw.flush();

            String interceptor = controllerOutputDir + File.separator + tableName + File.separator + className + "Interceptor.java";
            fw = new FileWriter(interceptor);
            fw.write(VelocityTool.fillTemplateContent("velocity/interceptor.vm",param));
            fw.flush();

            String service = controllerOutputDir + File.separator + tableName + File.separator + className + "Service.java";
            fw = new FileWriter(service);
            fw.write(VelocityTool.fillTemplateContent("velocity/service.vm",param));
            fw.flush();

            param.put("columns",tableMeta.getColumns());
            String validator = controllerOutputDir + File.separator + tableName + File.separator + className + "Validator.java";
            fw = new FileWriter(validator);
            fw.write(VelocityTool.fillTemplateContent("velocity/validator.vm",param));
            fw.flush();

            ViewGenerator viewGenerator = new ViewGenerator(tableMeta);
            viewGenerator.template();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (fw != null) {
                try {fw.close();} catch (IOException e) {
                    LogKit.error(e.getMessage(), e);}
            }
        }
    }


}
