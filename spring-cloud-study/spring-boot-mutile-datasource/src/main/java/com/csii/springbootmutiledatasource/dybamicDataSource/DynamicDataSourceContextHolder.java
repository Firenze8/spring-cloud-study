package com.csii.springbootmutiledatasource.dybamicDataSource;

import java.util.Collections;
import java.util.List;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/28 - 23:05 -- 星期二
 */
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static List<String> dataSourceIds = Collections.emptyList();
    public static void setDataSourceType(String dataSourceType){
        contextHolder.set(dataSourceType);
    }
    public static String getDataSourceType(){
        return contextHolder.get();
    }
    public static void clearDataSourceType(){
        contextHolder.remove();
    }
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }

}
