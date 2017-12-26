package com.generator;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.ColumnMeta;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.model.Blog;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017-12-25.
 */
public class Dom4jXML extends XmlGenerator {

    public static void generate(TableMeta tableMeta){
        //用工厂类创建一个document实例
        Document doc = DocumentHelper.createDocument();
        String tableName = tableMeta.name;//表名
        Element rootEle = doc.addElement("tableMeta");//创建根元素
        rootEle.addComment("表" + tableName);//添加注释

        rootEle.addAttribute("name",tableName);//根元素属性name
        String primaryKey = tableMeta.primaryKey;
        rootEle.addAttribute("primaryKey",primaryKey);//根元素属性主键

        List<ColumnMeta> columnMetas = tableMeta.columnMetas;
        for(ColumnMeta columnMeta : columnMetas){
            Element columnMetaEle = rootEle.addElement("columnMeta");//emps根节点下创建一个emp节点

            Field[] fields = ColumnMeta.class.getDeclaredFields();
            try {
                for(int i = 0 ; i < fields.length; i++){
                    Field f = fields[i];
                    String fileName = f.getName();
                    Object val = null;//得到此属性的值
                    val = f.get(columnMeta);

                    Element ele = columnMetaEle.addElement(fileName);
                    ele.setText(val == null ? "" : val+"");
                }} catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //将document中的内容写入文件中
        try {
            String xmlPath = PropKit.get("xmlpath") + tableName + ".xml";
               /* File file = new File(xmlPath);
                if(!file.exists()){
                    file.createNewFile();
                }*/
            Writer out = new FileWriter(xmlPath);

            //Writer out = new FileWriter("d:\\phantom\\jfinal2\\src\\main\\java\\com\\generator\\xml\\"+tableName+".xml");
            //格式化输出,类型IE浏览一样
            OutputFormat format = OutputFormat.createPrettyPrint();
            //OutputFormat format = OutputFormat.createCompactFormat();
            format.setEncoding("UTF-8");
            //创建写出对象
            XMLWriter writer = new XMLWriter(out,format);
            writer.write(doc);
            writer.close();
            System.out.println("生成xml成功。");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("失败了。");

        }
    }

    public  void generate(List<TableMeta> tableMetas){
        for(TableMeta tableMeta : tableMetas) {
            generate(tableMeta);
        }
    }
}
