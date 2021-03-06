/**
 * Copyright (c) 2011-2017, James Zhan 詹波 (jfinal@126.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jfinal.plugin.activerecord.generator;

import com.jfinal.kit.StrKit;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TableMeta
 */
public class TableMeta {
    public String databaseName;        //数据库名
    public String name;                    // 表名
    public String remarks;                // 表备注
    public String primaryKey;            // 主键，复合主键以逗号分隔
    public List<ColumnMeta> columnMetas = new ArrayList<ColumnMeta>();    // 字段 meta


    // ---------

    public String baseModelName;        // 生成的 base model 名
    public String baseModelContent;        // 生成的 base model 内容

    public String modelName;            // 生成的 model 名
    public String modelContent;            // 生成的 model 内容

    // ---------

    public int colNameMaxLen = "Field".length();            // 字段名最大宽度，用于辅助生成字典文件样式
    public int colTypeMaxLen = "Type".length();                // 字段类型最大宽度，用于辅助生成字典文件样式
    public int colDefaultValueMaxLen = "Default".length();    // 字段默认值最大宽度，用于辅助生成字典文件样式

    public Map<String, Object> getColumns() {
        List<Map<String, Object>> primaryColumns = new ArrayList<Map<String, Object>>(); //主键字段
        List<Map<String, Object>> commonColumns = new ArrayList<Map<String, Object>>();    //普通字段
        List<Map<String, Object>> bigColumns = new ArrayList<Map<String, Object>>();    //大文本字段
        List<Map<String, Object>> fileColumns = new ArrayList<Map<String, Object>>();    //文件字段
        try {
            for (ColumnMeta columnMeta : columnMetas) {
                Map<String, Object> column = new HashMap<String, Object>();
                Field[] fields = ColumnMeta.class.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    Field f = fields[i];
                    String fileName = f.getName();
                    Object val = null;//得到此属性的值
                    val = f.get(columnMeta);
                    column.put(fileName, val);
                }

                if ("true".equals(columnMeta.isPrimaryKey)) {
                    primaryColumns.add(column);
                    continue;
                }
                if ("text".equals(columnMeta.businessType) || "edit".equals(columnMeta.businessType)) {
                    bigColumns.add(column);
                }else if("picture".equals(columnMeta.businessType) || "file".equals(columnMeta.businessType)){
                    fileColumns.add(column);
                }else if("radio".equals(columnMeta.businessType)){
                    String other = columnMeta.getOther();
                    List<Map> list = new ArrayList<Map>();
                    if(!StrKit.isBlank(other)){
                        String[] otherStrs = other.split(";");
                        for(String str : otherStrs){
                            String[] keyValue = str.split(":");
                            String key = keyValue[0];
                            String value = keyValue[1];
                            Map m = new HashMap();
                            m.put("key",key);
                            m.put("value",value);
                            list.add(m);
                        }
                    }
                    columnMeta.setOtherList(list);
                    commonColumns.add(column);
                } else if("none".equals(columnMeta.businessType)){
                    //不展示字段
                }else {
                    commonColumns.add(column);
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("primaryColumns", primaryColumns);
        m.put("bigColumns", bigColumns);
        m.put("commonColumns", commonColumns);
        m.put("fileColumns",fileColumns);
        return m;
    }


    public void addColumnMeta(ColumnMeta columnMeta) {
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




