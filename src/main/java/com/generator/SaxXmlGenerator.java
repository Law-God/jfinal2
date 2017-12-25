package com.generator;

import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/12/24.
 */
public class SaxXmlGenerator extends XmlGenerator{

    public void generate(List<TableMeta> tableMetas){
        SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();
            Transformer transformer = transformerHandler.getTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "4");//设置缩进
            for(TableMeta tableMeta : tableMetas){
                String tableName = tableMeta.name;
                String  primaryKey =tableMeta.primaryKey;
                File file=new File("d:\\phantom\\jfinal2\\src\\main\\java\\com\\generator\\xml\\"+tableName+".xml");
                if(!file.exists()){
                    file.createNewFile();
                }
                Result result = new StreamResult(new FileOutputStream(file));
                transformerHandler.setResult(result);

                transformerHandler.startDocument();
                AttributesImpl attr = new AttributesImpl();

                attr.addAttribute("", "", "primaryKey", "", primaryKey);
                transformerHandler.startElement("","",tableName,attr);
                attr.clear();

                transformerHandler.startElement("","",primaryKey,attr);
                transformerHandler.characters(primaryKey.toCharArray(),0,primaryKey.length());
                transformerHandler.endElement("", "", primaryKey);
                attr.clear();

                transformerHandler.endElement("", "", tableName);

                transformerHandler.endDocument();

            }






        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
