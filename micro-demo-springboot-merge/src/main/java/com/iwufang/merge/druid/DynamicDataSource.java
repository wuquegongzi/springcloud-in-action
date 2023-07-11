package com.iwufang.merge.druid;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 * @package: com.iwufang.merge.datasource
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2018/4/12 9:47
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 获得数据源
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDateSoure();
    }
}
