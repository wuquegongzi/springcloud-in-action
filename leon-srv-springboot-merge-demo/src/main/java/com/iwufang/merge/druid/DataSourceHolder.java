package com.iwufang.merge.druid;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.iwufang.merge.datasource
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2018/4/12 9:48
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
public class DataSourceHolder {

    /*
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> contextHolders = new  ThreadLocal<String>();

    /*
     * 管理所有的数据源id,用于数据源的判断
     */
    public static List<String> dataSourceIds = new ArrayList<String>();

    /**
     * @Title: setDateSoureType
     * @Description: 设置数据源的变量
     * @param dateSoure
     * @return void
     * @throws
     */
    public static void setDateSoure(String dateSoure){
        contextHolders.set(dateSoure);
    }

    /**
     * @Title: getDateSoureType
     * @Description: 获得数据源的变量
     * @return String
     * @throws
     */
    public static String getDateSoure(){
        return contextHolders.get();
    }

    /**
     * @Title: clearDateSoureType
     * @Description: 清空所有的数据源变量
     * @return void
     * @throws
     */
    public static void clearDateSoure(){
        contextHolders.remove();
    }

    /**
     * @Title: existDateSoure
     * @Description: 判断数据源是否已存在
     * @param dataSourceId
     * @return boolean
     * @throws
     */
    public static boolean existDateSoure(String dataSourceId ){
        return dataSourceIds.contains(dataSourceId);
    }
}
