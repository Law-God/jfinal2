package com.task;

import com.business.test.TestService;
import com.business.user.UserService;
import com.common.HttpRequestUtil;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.model.Test;
import com.model.User;
import com.solr.Solr;
import com.solr.SolrFactory;
import org.apache.http.client.HttpClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.List;

/**
 * solr 增量创建索引
 * Created by zzk on 2018-01-09.
 */
public class SolrDataDeltaImportScheduler implements Runnable {
    @Override
    public void run() {
        try {
            SolrFactory.createSolr().buildIndex(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
