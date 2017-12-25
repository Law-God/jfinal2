package com.generator;

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
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017-12-25.
 */
public class Dom4jXML extends XmlGenerator {

    public void generate(List<TableMeta> tableMetas){
        //用工厂类创建一个document实例
        Document doc = DocumentHelper.createDocument();
        for(TableMeta tableMeta : tableMetas){
            String tableName = tableMeta.name;//表名
            Element rootEle = doc.addElement("tableMeta");//创建根元素
            rootEle.addComment("表" + tableName);//添加注释

            rootEle.addAttribute("name",tableName);//根元素属性name
            String primaryKey = tableMeta.primaryKey;
            rootEle.addAttribute("primaryKey",primaryKey);//根元素属性主键

            List<ColumnMeta> columnMetas = tableMeta.columnMetas;

            for(ColumnMeta columnMeta : columnMetas){
                Element columnMetaEle = rootEle.addElement("columnMeta");//emps根节点下创建一个emp节点

                //emp节点下创建一个name节点
                Element nameEle = columnMetaEle.addElement("name");
                nameEle.setText(columnMeta.name== null ? "" : columnMeta.name);

                //再为name节点创建一个兄弟节点
                Element javaTypeEle = columnMetaEle.addElement("javaType");
                javaTypeEle.setText(columnMeta.javaType== null ? "" : columnMeta.javaType);

                //再为name节点创建一个兄弟节点
                Element attrNameEle = columnMetaEle.addElement("attrName");
                attrNameEle.setText(columnMeta.attrName== null ? "" : columnMeta.attrName);

                //再为name节点创建一个兄弟节点
                Element typeEle = columnMetaEle.addElement("type");
                typeEle.setText(columnMeta.type == null ? "" : columnMeta.type);

                //再为name节点创建一个兄弟节点
                Element isNullableEle = columnMetaEle.addElement("isNullable");
                isNullableEle.setText(columnMeta.isNullable== null ? "" : columnMeta.isNullable);

                //再为name节点创建一个兄弟节点
                Element isPrimaryKeyEle = columnMetaEle.addElement("isPrimaryKey");
                isPrimaryKeyEle.setText(columnMeta.isPrimaryKey== null ? "" : columnMeta.isPrimaryKey);

                //再为name节点创建一个兄弟节点
                Element defaultValueEle = columnMetaEle.addElement("defaultValue");
                defaultValueEle.setText(columnMeta.defaultValue == null ? "" : columnMeta.defaultValue);

                //再为name节点创建一个兄弟节点
                Element remarksEle = columnMetaEle.addElement("remarks");
                remarksEle.setText(columnMeta.remarks == null ? "" : columnMeta.remarks);

                //再为name节点创建一个兄弟节点
                Element sqlTypeEle = columnMetaEle.addElement("sqlType");
                sqlTypeEle.setText(columnMeta.sqlType == null ? "" : columnMeta.sqlType);

                //再为name节点创建一个兄弟节点
                Element sizeEle = columnMetaEle.addElement("size");
                sizeEle.setText(columnMeta.size+"");

                //再为name节点创建一个兄弟节点
                Element scaleEle = columnMetaEle.addElement("scale");
                scaleEle.setText(columnMeta.scale+"");

                //再为name节点创建一个兄弟节点
                Element layVerifyEle = columnMetaEle.addElement("layVerify");
                layVerifyEle.setText(columnMeta.layVerify+"");

            }

            //将document中的内容写入文件中
            try {
                InputStream inputStream =  Dom4jXML.class.getResourceAsStream("/");
                Writer out = new FileWriter(Dom4jXML.class.getClassLoader().getResource("com/generator/xml/blog.xml").getFile());

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
    }
}
