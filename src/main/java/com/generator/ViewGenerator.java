package com.generator;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.TableMeta;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * html代码生成
 * Created by zzk on 2017-11-23.
 */
public class ViewGenerator {
    //生成页面基本路径
    public static final String VIEW_BASE_PATH = PropKit.get("webpath");

    private String className;
    private String tableName;

    private Map param = new HashMap();

    public ViewGenerator(TableMeta tableMeta){
        this.className = tableMeta.name.substring(0, 1).toUpperCase() + tableMeta.name.substring(1);
        this.tableName = tableMeta.name;
        this.param.put("tableName",tableName);
        this.param.put("className",className);
        this.param.put("primaryKey",tableMeta.primaryKey);
        this.param.put("columns",tableMeta.getColumns());
        mkdirs();
    }

    private void mkdirs(){
        String mkdirs =  VIEW_BASE_PATH + tableName;
        File dir = new File(mkdirs);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * form表单
     */
    public void formHtml(){
        String _formHtml = VIEW_BASE_PATH +  tableName + File.separator + "_form.html";
        File file = new File(_formHtml);
        Writer fw = null;
        try{
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            //fw.write(VelocityTool.fillTemplateContent("velocity/_form.vm",this.param));
            fw.write(FreeMarkerTool.fillTemplateContent("_form.flt",this.param));
            fw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    };

    /**
     * 新增页面
     */
    public void addHtml(){
        String addHtml = VIEW_BASE_PATH + tableName + File.separator + "add.html";
        File file = new File(addHtml);
        Writer fw = null;
        try{
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            //fw.write(VelocityTool.fillTemplateContent("velocity/_add.vm",this.param));
            fw.write(FreeMarkerTool.fillTemplateContent("_add.flt",this.param));
            fw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    };

    /**
     * 修改页面
     */
    public void editHtml(){
        String editHtml = VIEW_BASE_PATH + tableName + File.separator + "edit.html";
        File file = new File(editHtml);
        Writer fw = null;
        try{
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            //fw.write(VelocityTool.fillTemplateContent("velocity/_add.vm",this.param));
            fw.write(FreeMarkerTool.fillTemplateContent("_edit.flt",this.param));
            fw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    };

    /**
     * 列表页面
     */
    public void listHtml(){
        String listHtml = VIEW_BASE_PATH + tableName + File.separator + tableName + ".html";
        File file = new File(listHtml);
        Writer fw = null;
        try{
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            //fw.write(VelocityTool.fillTemplateContent("velocity/_add.vm",this.param));
            fw.write(FreeMarkerTool.fillTemplateContent("_list.flt",this.param));
            fw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    };

    public void js(){
        String js =  VIEW_BASE_PATH +  tableName + File.separator + tableName + ".js";
        File file = new File(js);
        Writer fw = null;
        try{
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            //fw.write(VelocityTool.fillTemplateContent("velocity/_add.vm",this.param));
            fw.write(FreeMarkerTool.fillTemplateContent("_js.flt",this.param));
            fw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generate(){
        this.formHtml();
        this.addHtml();
        this.editHtml();
        this.listHtml();
        this.js();
    }
}
