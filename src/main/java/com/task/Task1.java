package com.task;

import com.business.test.TestService;
import com.business.user.UserService;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.model.Test;
import com.model.User;
import com.solr.Solr;
import com.solr.SolrFactory;
import org.apache.solr.client.solrj.SolrServerException;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018-01-09.
 */
public class Task1 implements Runnable {
    static TestService service = new TestService();
    @Override
    public void run() {
        Solr solr = SolrFactory.createSolr();
        System.out.println("solr:" + solr);
        try {
            Page<Test> page = service.paginate(1,1000);
            List<Test> list = page.getList();
            for(Test user : list){
                solr.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }
}
