package com.generator;

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

/**
 * Created by Administrator on 2017-12-25.
 */
public class DigesterTool {
    public static void main(String[] args) {
        try {
            // 解析XML文件,并得到ROOT元素
            Digester digester = DigesterLoader.createDigester(new InputSource(new FileInputStream(new File("d:\\phantom\\jfinal2\\src\\main\\java\\com\\generator\\xml\\tablemeta-rule.xml"))));
            TableMeta library = (TableMeta) digester.parse(new File("d:\\phantom\\jfinal2\\src\\main\\java\\com\\generator\\xml\\blog.xml"));
            System.out.println(" 图书馆: " + library.name);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
