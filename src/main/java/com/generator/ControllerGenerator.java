package com.generator;

import com.jfinal.kit.LogKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.ModelGenerator;
import com.jfinal.plugin.activerecord.generator.TableMeta;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzk on 2017-11-20.
 */
public class ControllerGenerator {
    //生成页面基本路径
    public static final String CONTROLLER_BASE_PATH = PropKit.get("controllerpath");
    protected String controllerPackageName;
    protected String modelPackageName;

    public ControllerGenerator(String controllerPackageName,String modelPackageName){
        this.controllerPackageName = controllerPackageName;
        this.modelPackageName = modelPackageName;
    }

    public void generate(TableMeta tableMeta) {
        String className = tableMeta.name.substring(0, 1).toUpperCase() + tableMeta.name.substring(1);
        String tableName = tableMeta.name;
        File dir = new File(CONTROLLER_BASE_PATH + tableName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Map param = new HashMap();
        param.put("package",controllerPackageName+"."+ tableName);//包名
        param.put("modelPackageName",this.modelPackageName);
        param.put("tableName",tableName);
        param.put("className",className);
        param.put("columns",tableMeta.getColumns());
        writeControllerToFile(param);
        writeInterceptorToFile(param);
        writeServiceToFile(param);
        writeValidatorToFile(param);
    }

    public void generate(List<TableMeta> tableMetas) {
        for(TableMeta tableMeta : tableMetas){
           generate(tableMeta);
        }
    }

    protected void writeControllerToFile(Map m){
        String controller = CONTROLLER_BASE_PATH + m.get("tableName") + File.separator + m.get("className") + "Controller.java";
        File controllerFile = new File(controller);
        Writer fw = null;
        try {
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(controllerFile), "UTF-8"));
            fw.write(FreeMarkerTool.fillTemplateContent("controller.flt",m));
            fw.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    protected void writeInterceptorToFile(Map m){
        String interceptor = CONTROLLER_BASE_PATH + m.get("tableName") + File.separator + m.get("className") + "Interceptor.java";
        File interceptorFile = new File(interceptor);
        Writer fw = null;
        try {
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(interceptorFile), "UTF-8"));
            fw.write(FreeMarkerTool.fillTemplateContent("interceptor.flt",m));
            fw.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void writeServiceToFile(Map m){
        String service = CONTROLLER_BASE_PATH + m.get("tableName") + File.separator + m.get("className") + "Service.java";
        File serviceFile = new File(service);
        Writer fw = null;
        try {
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile), "UTF-8"));
            fw.write(FreeMarkerTool.fillTemplateContent("service.flt",m));
            fw.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void writeValidatorToFile(Map m){
        String validator = CONTROLLER_BASE_PATH + m.get("tableName") + File.separator + m.get("className") + "Validator.java";
        File validatorFile = new File(validator);
        Writer fw = null;
        try {
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(validatorFile), "UTF-8"));
            fw.write(FreeMarkerTool.fillTemplateContent("validator.flt",m));
            fw.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
