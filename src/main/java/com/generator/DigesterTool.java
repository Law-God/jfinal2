package com.generator;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.ColumnMeta;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Administrator on 2017-12-25.
 */
public class DigesterTool {

    public static TableMeta readXml(String xmlName){
        String digesterRulePath = PropKit.get("xmlpath") + "tablemeta-rule.xml";
        String xmlPath = PropKit.get("xmlpath") + xmlName + ".xml";
        try {
            // 解析XML文件,并得到ROOT元素
            Digester digester = DigesterLoader.createDigester(new InputSource(new FileInputStream(new File(digesterRulePath))));
            TableMeta tableMeta = (TableMeta) digester.parse(new File(xmlPath));
            return tableMeta;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void main(String[] args) {
        try {
            // 解析XML文件,并得到ROOT元素
            Digester digester = DigesterLoader.createDigester(new InputSource(new FileInputStream(new File("d:\\phantom\\jfinal2\\src\\main\\java\\com\\generator\\xml\\tablemeta-rule.xml"))));
            TableMeta tableMeta = (TableMeta) digester.parse(new File("d:\\phantom\\jfinal2\\src\\main\\java\\com\\generator\\xml\\blog.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
