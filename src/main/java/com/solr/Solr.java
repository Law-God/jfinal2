package com.solr;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by Administrator on 2018-01-09.
 */
public class Solr {
    private static final String SOLR_URL = PropKit.use("dataSource.txt").get("solrUrl");

    private HttpSolrClient httpSolrClient = null;

    public Solr(){
        if(StrKit.isBlank(Solr.SOLR_URL))
            throw new IllegalArgumentException("solrUrl未配置");
        httpSolrClient = new HttpSolrClient.Builder(Solr.SOLR_URL)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }

    public void add(Object obj) throws IOException, SolrServerException {
        //1、创建doc
        SolrInputDocument doc = new SolrInputDocument();
        //2、添加内容
        //String uuid = UUID.randomUUID().toString();
        //doc.addField("id","role:"+1);
        //doc.addField("name","角色表");

        //3、添加到client
        UpdateResponse response = httpSolrClient.addBean(obj);
        System.out.println(response.getElapsedTime());
        //4、索引文档必须commit
        httpSolrClient.commit();
    }

    public void query() throws IOException, SolrServerException {
        //1、封装查询参数
        SolrQuery solrQuery = new SolrQuery("id:role*");
        //2、添加需要回显内容
        solrQuery.addField("id");
        solrQuery.addField("name");
        solrQuery.setRows(10);//设置每页显示条数
        //3、执行查询返回QueryResponse
        QueryResponse response = httpSolrClient.query(solrQuery);
        //4、获取doc文档
        SolrDocumentList documentList = response.getResults();
        System.out.println("共有" + documentList.getNumFound() + "条记录");
        for(SolrDocument document : documentList){
            System.out.println("id:"+document.get("id"));
            System.out.println("name:" + document.get("name"));
        }
        //5、关闭
        httpSolrClient.close();
    }

    public static void main(String[] args){
        Solr solr = SolrFactory.createSolr();
        try {
            //solr.add();
            solr.query();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }
}
