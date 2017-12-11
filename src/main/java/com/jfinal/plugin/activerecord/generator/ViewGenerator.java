package com.jfinal.plugin.activerecord.generator;

import com.jfinal.kit.PathKit;
import com.phantom.jfinal.tool.FreeMarkerTool;
import com.phantom.jfinal.tool.StringTemplateTool;
import com.phantom.jfinal.tool.VelocityTool;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * html代码生成
 * Created by zzk on 2017-11-23.
 */
public class ViewGenerator {
    //生成页面基本路径
    public static final String VIEW_BASE_PATH = "src/main/webapp";

    private TableMeta tableMeta;

    private String className;
    private String tableName;

    private Map param = new HashMap();

    public ViewGenerator(TableMeta tableMeta){
        this.tableMeta = tableMeta;
        this.className = tableMeta.name.substring(0, 1).toUpperCase() + tableMeta.name.substring(1);
        this.tableName = tableMeta.name;
        this.param.put("tableName",tableName);
        this.param.put("className",className);
        this.param.put("columns",tableMeta.getColumns());
        mkdirs();
    }

    private void mkdirs(){
        String mkdirs =  PathKit.getWebRootPath() + File.separator + VIEW_BASE_PATH +  File.separator + tableName;
        File dir = new File(mkdirs);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * form表单
     */
    public void formHtml(){
        String _formHtml = PathKit.getWebRootPath() + File.separator + VIEW_BASE_PATH +  File.separator + tableName + File.separator + "_form.html";
        FileWriter fw = null;
        try{
            fw = new FileWriter(_formHtml);
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
        String addHtml = PathKit.getWebRootPath() + File.separator + VIEW_BASE_PATH +  File.separator + tableName + File.separator + "add.html";
        FileWriter fw = null;
        try{
            fw = new FileWriter(addHtml);
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
        String editHtml = PathKit.getWebRootPath() + File.separator + VIEW_BASE_PATH +  File.separator + tableName + File.separator + "edit.html";
        FileWriter fw = null;
        try{
            fw = new FileWriter(editHtml);
            //fw.write(VelocityTool.fillTemplateContent("velocity/_edit.vm",this.param));
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
        String listHtml = PathKit.getWebRootPath() + File.separator + VIEW_BASE_PATH +  File.separator + tableName + File.separator + tableName + ".html";
        FileWriter fw = null;
        try{
            fw = new FileWriter(listHtml);
            fw.write(FreeMarkerTool.fillTemplateContent("_list.flt",this.param));
            fw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    };

    public void js(){
        String listHtml = PathKit.getWebRootPath() + File.separator + VIEW_BASE_PATH +  File.separator + tableName + File.separator + tableName + ".js";
        FileWriter fw = null;
        try{
            fw = new FileWriter(listHtml);
            fw.write(FreeMarkerTool.fillTemplateContent("js.flt",this.param));
            fw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void template(){
        this.formHtml();
        this.addHtml();
        this.editHtml();
        this.listHtml();
        this.js();
    }
}
