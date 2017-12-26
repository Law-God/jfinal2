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
        ResultSet rs = null;
        DataSource dataSource = _JFinalDemoGenerator.getDataSource();
        List<TableMeta> ret = new ArrayList<TableMeta>();
        try {
            conn = dataSource.getConnection();
            dbMeta = conn.getMetaData();
            conn = dataSource.getConnection();
            rs = dbMeta.getTables(conn.getCatalog(), null, null, new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                TableMeta tableMeta = new TableMeta();
                tableMeta.databaseName = conn.getCatalog();//设置数据库名
                tableMeta.name = tableName;
                tableMeta.remarks = rs.getString("REMARKS");
                ret.add(tableMeta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        Page page = new Page(listPage(ret,pageNumber,pageSize),pageNumber,pageSize,(ret.size()+pageSize-1)/pageSize,ret.size());
        return page;
    }

    /**
     *
     * @param list 要取子集的集合
     * @param pageNo 第几页
     * @param pageSize 每页显示条数
     * @return Object
     */
    public static List listPage(List list,int pageNo,int pageSize ){
        if(list == null)
            return null;

        int size = list.size();
        if(size == 0)
            return list;

        pageNo = pageNo < 1 ? 1 : pageNo;
        pageSize = pageSize < 0 ? 0 : pageSize;

        int fromIndex = (pageNo-1) * pageSize;
        int toIndex = pageNo * pageSize;
        toIndex = toIndex > size ? size : toIndex;
        return list.subList(fromIndex,toIndex);
    }

}