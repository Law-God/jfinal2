/**
 * Copyright (c) 2011-2017, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jfinal.plugin.activerecord.generator;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;
import javax.sql.DataSource;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.dialect.Dialect;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;

/**
 * MetaBuilder
 */
public class MetaBuilder {
	
	protected DataSource dataSource;
	protected Dialect dialect = new MysqlDialect();
	protected Set<String> excludedTables = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	
	protected Connection conn = null;
	protected DatabaseMetaData dbMeta = null;
	
	protected String[] removedTableNamePrefixes = null;
	
	protected TypeMapping typeMapping = new TypeMapping();
	
	public MetaBuilder(DataSource dataSource) {
		if (dataSource == null) {
			throw new IllegalArgumentException("dataSource can not be null.");
		}
		this.dataSource = dataSource;
	}
	
	public void setDialect(Dialect dialect) {
		if (dialect != null) {
			this.dialect = dialect;
		}
	}
	
	public void addExcludedTable(String... excludedTables) {
		if (excludedTables != null) {
			for (String table : excludedTables) {
				this.excludedTables.add(table);
			}
		}
	}
	
	/**
	 * 设置需要被移除的表名前缀，仅用于生成 modelName 与  baseModelName
	 * 例如表名  "osc_account"，移除前缀 "osc_" 后变为 "account"
	 */
	public void setRemovedTableNamePrefixes(String... removedTableNamePrefixes) {
		this.removedTableNamePrefixes = removedTableNamePrefixes;
	}
	
	public void setTypeMapping(TypeMapping typeMapping) {
		if (typeMapping != null) {
			this.typeMapping = typeMapping;
		}
	}
	
	public List<TableMeta> build() {
		System.out.println("Build TableMeta ...");
		try {
			conn = dataSource.getConnection();
			dbMeta = conn.getMetaData();
			
			List<TableMeta> ret = new ArrayList<TableMeta>();
			buildTableNames(ret);
			for (TableMeta tableMeta : ret) {
				buildPrimaryKey(tableMeta);
				buildColumnMetas(tableMeta);
				buildColumnCommentMetas(tableMeta);
			}
			return ret;
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (conn != null) {
				try {conn.close();} catch (SQLException e) {throw new RuntimeException(e);}
			}
		}
	}
	
	/**
	 * 通过继承并覆盖此方法，跳过一些不希望处理的 table，定制更加灵活的 table 过滤规则
	 * @return 返回 true 时将跳过当前 tableName 的处理
	 */
	protected boolean isSkipTable(String tableName) {
		return false;
	}
	
	/**
	 * 构造 modelName，mysql 的 tableName 建议使用小写字母，多单词表名使用下划线分隔，不建议使用驼峰命名
	 * oracle 之下的 tableName 建议使用下划线分隔多单词名，无论 mysql还是 oralce，tableName 都不建议使用驼峰命名
	 */
	protected String buildModelName(String tableName) {
		// 移除表名前缀仅用于生成 modelName、baseModelName，而 tableMeta.name 表名自身不能受影响
		if (removedTableNamePrefixes != null) {
			for (String prefix : removedTableNamePrefixes) {
				if (tableName.startsWith(prefix)) {
					tableName = tableName.replaceFirst(prefix, "");
					break;
				}
			}
		}
		
		// 将 oralce 大写的 tableName 转成小写，再生成 modelName
		if (dialect instanceof OracleDialect) {
			tableName = tableName.toLowerCase();
		}
		
		return StrKit.firstCharToUpperCase(StrKit.toCamelCase(tableName));
	}
	
	/**
	 * 使用 modelName 构建 baseModelName
	 */
	protected String buildBaseModelName(String modelName) {
		return "Base" + modelName;
	}
	
	/**
	 * 不同数据库 dbMeta.getTables(...) 的 schemaPattern 参数意义不同
	 * 1：oracle 数据库这个参数代表 dbMeta.getUserName()
	 * 2：postgresql 数据库中需要在 jdbcUrl中配置 schemaPatter，例如：
	 *   jdbc:postgresql://localhost:15432/djpt?currentSchema=public,sys,app
	 *   最后的参数就是搜索schema的顺序，DruidPlugin 下测试成功
	 * 3：开发者若在其它库中发现工作不正常，可通过继承 MetaBuilder并覆盖此方法来实现功能
	 */
	protected ResultSet getTablesResultSet() throws SQLException {
		String schemaPattern = dialect instanceof OracleDialect ? dbMeta.getUserName() : null;
		// return dbMeta.getTables(conn.getCatalog(), schemaPattern, null, new String[]{"TABLE", "VIEW"});
		return dbMeta.getTables(conn.getCatalog(), schemaPattern, null, new String[]{"TABLE"});	// 不支持 view 生成
	}
	
	protected void buildTableNames(List<TableMeta> ret) throws SQLException {
		ResultSet rs = getTablesResultSet();
		while (rs.next()) {
			String tableName = rs.getString("TABLE_NAME");
			if (excludedTables.contains(tableName)) {
				System.out.println("Skip table :" + tableName);
				continue ;
			}
			if (isSkipTable(tableName)) {
				System.out.println("Skip table :" + tableName);
				continue ;
			}
			
			TableMeta tableMeta = new TableMeta();
			tableMeta.databaseName = conn.getCatalog();//设置数据库名
			tableMeta.name = tableName;
			tableMeta.remarks = rs.getString("REMARKS");
			
			tableMeta.modelName = buildModelName(tableName);
			tableMeta.baseModelName = buildBaseModelName(tableMeta.modelName);
			ret.add(tableMeta);
		}
		rs.close();
	}
	
	protected void buildPrimaryKey(TableMeta tableMeta) throws SQLException {
		ResultSet rs = dbMeta.getPrimaryKeys(conn.getCatalog(), null, tableMeta.name);
		
		String primaryKey = "";
		int index = 0;
		while (rs.next()) {
			if (index++ > 0) {
				primaryKey += ",";
			}
			primaryKey += rs.getString("COLUMN_NAME");
		}
		if (StrKit.isBlank(primaryKey)) {
			throw new RuntimeException("primaryKey of table \"" + tableMeta.name + "\" required by active record pattern");
		}
		tableMeta.primaryKey = primaryKey;
		rs.close();
	}
	
	/**
	 * 文档参考：
	 * http://dev.mysql.com/doc/connector-j/en/connector-j-reference-type-conversions.html
	 * 
	 * JDBC 与时间有关类型转换规则，mysql 类型到 java 类型如下对应关系：
	 * DATE				java.sql.Date
	 * DATETIME			java.sql.Timestamp
	 * TIMESTAMP[(M)]	java.sql.Timestamp
	 * TIME				java.sql.Time
	 * 
	 * 对数据库的 DATE、DATETIME、TIMESTAMP、TIME 四种类型注入 new java.util.Date()对象保存到库以后可以达到“秒精度”
	 * 为了便捷性，getter、setter 方法中对上述四种字段类型采用 java.util.Date，可通过定制 TypeMapping 改变此映射规则
	 */
	protected void buildColumnMetas(TableMeta tableMeta) throws SQLException {
		String sql = dialect.forTableBuilderDoBuild(tableMeta.name);
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();

		for (int i=1; i<=rsmd.getColumnCount(); i++) {
			ColumnMeta cm = new ColumnMeta();
			cm.name = rsmd.getColumnName(i);
			String primaryKey = tableMeta.primaryKey;
			if(primaryKey != null && primaryKey.equals(cm.name)){
				cm.isPrimaryKey = "true";
			}else{
				cm.isPrimaryKey = "false";
			}
			String colClassName = rsmd.getColumnClassName(i);
			String typeStr = typeMapping.getType(colClassName);
			if (typeStr != null) {
				cm.javaType = typeStr;
			}else {
				int type = rsmd.getColumnType(i);
				if (type == Types.BINARY || type == Types.VARBINARY || type == Types.BLOB) {
					cm.javaType = "byte[]";
				}
				else if (type == Types.CLOB || type == Types.NCLOB) {
					cm.javaType = "java.lang.String";
				}
				else {
					cm.javaType = "java.lang.String";
				}
			}

			//字段长度
			int size = rsmd.getColumnDisplaySize(i);
			cm.size = size;

			//对应sql.Types类型
			int sqlType = rsmd.getColumnType(i);
			String sqlTypeStr = SqlTypeMapping.getSqlType(sqlType);
			cm.sqlType = sqlTypeStr ;

			//是否为空
			int nullable = rsmd.isNullable(i);//0 不允许空  1 允许为空
			if(nullable == 0)
				cm.isNullable = "0";
			else
				cm.isNullable = "1";

			// 构造字段对应的属性名 attrName
			cm.attrName = buildAttrName(cm.name);

			int scale = rsmd.getScale(i);
			cm.scale = scale;

			tableMeta.columnMetas.add(cm);
		}
		rs.close();
		stm.close();
	}

	/**
	 * 表字段注解
	 * select column_name,column_comment from INFORMATION_SCHEMA.Columns where table_name='表名' and table_schema='数据库名'
	 */
	protected void buildColumnCommentMetas(TableMeta tableMeta) throws SQLException {
		String sql = "select column_name,column_comment from INFORMATION_SCHEMA.Columns where table_name='"+tableMeta.name+"' and table_schema='"+ tableMeta.databaseName +"'" ;
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns=rsmd.getColumnCount();
		List<Map> columnsList = new ArrayList<Map>();//存放
		//显示表格内容
		while(rs.next())
		{
			Map column = new HashMap();
			for(int i=1;i<=columns;i++)
			{
				if(i == 1){
					column.put("columnName",rs.getString(i));
				}else if(i == 2) {
					column.put("columnValue", rs.getString(i));
				}
			}
			columnsList.add(column);
		}
		rs.close();
		stm.close();
		for(ColumnMeta columnMeta : tableMeta.columnMetas){
			String columnName = columnMeta.name;
			for(Map column : columnsList){
				if(columnName != null && columnName.equals(column.get("columnName"))){
					columnMeta.remarks = column.get("columnValue") == null ? "" : String.valueOf(column.get("columnValue"));
				}
			}
		}

		//text blob 放置最后
		/*List<ColumnMeta> columnMetas = tableMeta.columnMetas;
		int len = columnMetas.size();
		int minIndex;
		ColumnMeta temp;
		for (int i = 0; i < len - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < len; j++) {
				ColumnMeta columnMetaTemp = columnMetas.get(j);
				String sqlType = columnMetaTemp.sqlType;
				if(!"text".equals(sqlType) && !"blob".equals(sqlType)){
					minIndex = j;
					break;
				}
			}
			temp = columnMetas.get(i);
			columnMetas.set(i,columnMetas.get(minIndex));
			columnMetas.set(minIndex,temp);
		}*/

	}


	/**
	 * 构造 colName 所对应的 attrName，mysql 数据库建议使用小写字段名或者驼峰字段名
	 * Oralce 反射将得到大写字段名，所以不建议使用驼峰命名，建议使用下划线分隔单词命名法
	 */
	protected String buildAttrName(String colName) {
		if (dialect instanceof OracleDialect) {
			colName = colName.toLowerCase();
		}
		return StrKit.toCamelCase(colName);
	}
}







