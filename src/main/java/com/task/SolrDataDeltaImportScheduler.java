package com.task;

import com.solr.SolrFactory;

import java.io.IOException;

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
