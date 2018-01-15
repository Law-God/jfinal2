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
import java.util.List;
import java.util.Map;
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
        SolrQuery solrQuery = new SolrQuery("bookname:爬虫开发 OR content:火狐浏览器" );
        solrQuery.setHighlight(true);
        solrQuery.setHighlightSimplePre("<font style=\"color:red\">");
        solrQuery.setHighlightSimplePost("</font>");
        solrQuery.addHighlightField("bookname");
        //solrQuery.add("df","username");
        //2、添加需要回显内容
        solrQuery.addField("id");
        solrQuery.addField("bookname");
        solrQuery.setRows(10000);//设置每页显示条数
        //3、执行查询返回QueryResponse
        QueryResponse response = httpSolrClient.query(solrQuery);
        System.out.println("查询消耗时间：" +response.getQTime());
        // Map K id V Map
        // Map K 域名 V List
        // List list.get(0)
        Map<String, Map<String, List<String>>> highlighting=  response.getHighlighting();

        //4、获取doc文档
        SolrDocumentList documentList = response.getResults();
        System.out.println("共有" + documentList.getNumFound() + "条记录");
        /*for(SolrDocument document : documentList){
            System.out.println("id:"+document.get("id"));
            System.out.println("bookname:" + document.get("bookname"));
            Map<String, List<String>> map = highlighting.get((String) document.get("id"));
            List<String> list = map.get("bookname");
            if(list != null && list.size() > 0){
                System.out.println(list.get(0));
            }
        }*/
        //5、关闭
        httpSolrClient.close();

    }

    /**
     * 增量/全量建立索引 。
     *
     * @param delta false，增量建立索引；true，重建所有索引
     * @throws IOException
     */
    public  void buildIndex(boolean delta) throws IOException {
        SolrQuery query = new SolrQuery();
        // 指定RequestHandler，默认使用/select
        query.setRequestHandler("/dataimport");

        String command = delta ? "full-import" : "delta-import";
        boolean clean = delta ? true : false;
        String optimize = delta ? "true" : "false";

        query.setParam("command", command)
                .setParam("clean", clean)
                .setParam("commit", "true")
//               .setParam("entity", "")
                .setParam("optimize", optimize);
        try {
            httpSolrClient.query(query);
            httpSolrClient.commit();
            System.out.println(" ///////////"+command);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
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
       /* try {
            solr.buildIndex(false);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
