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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TableMeta
 */
public class TableMeta {
	public String databaseName;		//数据库名
	public String name;					// 表名
	public String remarks;				// 表备注
	public String primaryKey;			// 主键，复合主键以逗号分隔
	public List<ColumnMeta> columnMetas = new ArrayList<ColumnMeta>();	// 字段 meta


	// ---------
	
	public String baseModelName;		// 生成的 base model 名
	public String baseModelContent;		// 生成的 base model 内容
	
	public String modelName;			// 生成的 model 名
	public String modelContent;			// 生成的 model 内容
	
	// ---------
	
	public int colNameMaxLen = "Field".length();			// 字段名最大宽度，用于辅助生成字典文件样式
	public int colTypeMaxLen = "Type".length();				// 字段类型最大宽度，用于辅助生成字典文件样式
	public int colDefaultValueMaxLen = "Default".length();	// 字段默认值最大宽度，用于辅助生成字典文件样式

	public Map<String,Object> getColumns(){
		List<Map<String,Object>> primaryColumns = new ArrayList<Map<String,Object>>(); //主键字段
		List<Map<String,Object>> commonColumns = new ArrayList<Map<String,Object>>();	//普通字段
		List<Map<String,Object>> bigColumns = new ArrayList<Map<String,Object>>();	//大文本字段

		for(ColumnMeta columnMeta : columnMetas){
			Map<String,Object> column = new HashMap<String, Object>();
			column.put("name",columnMeta.name);
			column.put("remarks",columnMeta.remarks);
			column.put("isPrimaryKey",columnMeta.isPrimaryKey);
			column.put("defaultValue",columnMeta.defaultValue);
			column.put("type",columnMeta.type);
			column.put("attrName",columnMeta.attrName);
			column.put("isNullable",columnMeta.isNullable);
			column.put("sqlType",columnMeta.sqlType);
			column.put("layVerify",columnMeta.layVerify);
			column.put("size",columnMeta.size);
			column.put("scale",columnMeta.scale);
			if("true".equals(columnMeta.isPrimaryKey)){
				primaryColumns.add(column);
				continue;
			}
			if("text".equals(columnMeta.sqlType) || "longtext".equals(columnMeta.sqlType)|| "blob".equals(columnMeta.sqlType)){
				bigColumns.add(column);
			}else{
				commonColumns.add(column);
			}

		}
		Map<String,Object> m = new HashMap<String, Object>();
		m.put("primaryColumns",primaryColumns);
		m.put("bigColumns",bigColumns);
		m.put("commonColumns",commonColumns);
		return m;
	}


	public void addColumnMeta(ColumnMeta columnMeta){
		columnMetas.add(columnMeta);
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<ColumnMeta> getColumnMetas() {
		return columnMetas;
	}

	public void setColumnMetas(List<ColumnMeta> columnMetas) {
		this.columnMetas = columnMetas;
	}

	public String getBaseModelName() {
		return baseModelName;
	}

	public void setBaseModelName(String baseModelName) {
		this.baseModelName = baseModelName;
	}

	public String getBaseModelContent() {
		return baseModelContent;
	}

	public void setBaseModelContent(String baseModelContent) {
		this.baseModelContent = baseModelContent;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelContent() {
		return modelContent;
	}

	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}

	public int getColNameMaxLen() {
		return colNameMaxLen;
	}

	public void setColNameMaxLen(int colNameMaxLen) {
		this.colNameMaxLen = colNameMaxLen;
	}

	public int getColTypeMaxLen() {
		return colTypeMaxLen;
	}

	public void setColTypeMaxLen(int colTypeMaxLen) {
		this.colTypeMaxLen = colTypeMaxLen;
	}

	public int getColDefaultValueMaxLen() {
		return colDefaultValueMaxLen;
	}

	public void setColDefaultValueMaxLen(int colDefaultValueMaxLen) {
		this.colDefaultValueMaxLen = colDefaultValueMaxLen;
	}
}




