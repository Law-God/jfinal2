package com.business.code;

import com.generator._JFinalDemoGenerator;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.generator.TableMeta;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* Service
*/
public class CodeService {


	public Page paginate(int pageNumber, int pageSize) {
        Connection conn = null;
        DatabaseMetaData dbMeta = null;
        DataSource dataSource = _JFinalDemoGenerator.getDataSource();
        List<TableMeta> ret = new ArrayList<TableMeta>();
        try {
            conn = dataSource.getConnection();
            dbMeta = conn.getMetaData();
            conn = dataSource.getConnection();
            ResultSet rs = dbMeta.getTables(conn.getCatalog(), null, null, new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                TableMeta tableMeta = new TableMeta();
                tableMeta.databaseName = conn.getCatalog();//设置数据库名
                tableMeta.name = tableName;
                tableMeta.remarks = rs.getString("REMARKS");
                ret.add(tableMeta);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}