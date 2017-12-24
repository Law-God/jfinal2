package com.generator;

import com.jfinal.plugin.activerecord.generator.TableMeta;

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
public class SaxXmlGenirator {
    public void generate(List<TableMeta> tableMetas){
        SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();
            Transformer transformer = transformerHandler.getTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            File file=new File("J:\\phantom\\jfinal2\\src\\main\\java\\com\\generator\\xml\\test.xml");
            if(!file.exists()){
                file.createNewFile();
            }

            Result result = new StreamResult(new FileOutputStream(file));
            transformerHandler.setResult(result);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
