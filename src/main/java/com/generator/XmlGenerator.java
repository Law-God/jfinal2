package com.generator;

import com.jfinal.plugin.activerecord.generator.TableMeta;

import java.util.List;

/**
 * Created by Administrator on 2017-12-25.
 */
public abstract class XmlGenerator {

    public abstract void generate(List<TableMeta> tableMetas);

}
