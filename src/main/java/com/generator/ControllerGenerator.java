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
        writeToFile(tableMeta);
    }

    public void generate(List<TableMeta> tableMetas) {
        for(TableMeta tableMeta : tableMetas){
            writeToFile(tableMeta);
        }
    }

    /**
     * _MappingKit.java 覆盖写入
     */
    protected void writeToFile(TableMeta tableMeta) {
        Writer fw = null;
        try {
            String className = tableMeta.name.substring(0, 1).toUpperCase() + tableMeta.name.substring(1);
            String tableName = tableMeta.name;

            File dir = new File(CONTROLLER_BASE_PATH + tableName);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String controller = CONTROLLER_BASE_PATH + tableName + File.separator + className + "Controller.java";
            File controllerFile = new File(controller);

            Map param = new HashMap();
            param.put("package",controllerPackageName+"."+ tableName);//包名
            param.put("modelPackageName",this.modelPackageName);
            param.put("tableName",tableName);
            param.put("className",className);
            param.put("columns",tableMeta.getColumns());
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(controllerFile), "UTF-8"));
            fw.write(FreeMarkerTool.fillTemplateContent("controller.flt",param));
            fw.flush();

            String interceptor = CONTROLLER_BASE_PATH + tableName + File.separator + className + "Interceptor.java";
            File interceptorFile = new File(interceptor);
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(interceptorFile), "UTF-8"));
            fw.write(FreeMarkerTool.fillTemplateContent("interceptor.flt",param));
            fw.flush();

            String service = CONTROLLER_BASE_PATH + tableName + File.separator + className + "Service.java";
            File serviceFile = new File(service);
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile), "UTF-8"));
            fw.write(FreeMarkerTool.fillTemplateContent("service.flt",param));
            fw.flush();

            param.put("columns",tableMeta.getColumns());
            String validator = CONTROLLER_BASE_PATH + tableName + File.separator + className + "Validator.java";
            File validatorFile = new File(validator);
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(validatorFile), "UTF-8"));
            fw.write(FreeMarkerTool.fillTemplateContent("validator.flt",param));
            fw.flush();
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
