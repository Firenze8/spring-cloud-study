package com.csii.springbootmutiledatasource.dybamicDataSource;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/28 - 23:26 -- 星期二
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar,EnvironmentAware{
    //默认使用的数据库源
   private static final Object DATASOURCE_TYPE_DEFAULT="com.zaxxer.hikari.HikariDataSource";
   private ConversionService conversionService = new DefaultConversionService();
   private PropertyValues dataSourcePropertyValues;

   private DataSource defaultDataSource;
   private Map<String,DataSource> customDataSources = Collections.emptyMap();

    @Override
    public void setEnvironment(Environment environment) {
        initDefaultDataSource(environment);
        initCustomDataSources(environment);
    }

    private void initDefaultDataSource(Environment environment) {
    //读取数据源配置
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment,"spring.datasource,");
        Map<String,Object> dsMap = Collections.EMPTY_MAP;
        dsMap.put("type",propertyResolver.getProperty("type"));
        dsMap.put("driverClassName",propertyResolver.getProperty("driverClassName"));
        dsMap.put("url",propertyResolver.getProperty("url"));
        dsMap.put("username",propertyResolver.getProperty("username"));
        dsMap.put("password",propertyResolver.getProperty("password"));
        defaultDataSource = buildDataSource(dsMap);
        dataBinder(defaultDataSource,environment);
    }

    private void dataBinder(DataSource defaultDataSource, Environment environment) {

    }

    private DataSource buildDataSource(Map<String, Object> dsMap) {
        Object type = dsMap.get("type");
        if (type == null) {
            type = DATASOURCE_TYPE_DEFAULT;
        }
        Class<? extends DataSource> dataSoureType;
        try {
            dataSoureType = (Class<? extends DataSource>) Class.forName((String) type);
            String driverClassName = dsMap.get("driverClassName").toString();
            String url = dsMap.get("url").toString();
            String username= dsMap.get("username").toString();
            String password = dsMap.get("password").toString();
            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(username).password(password).type(dataSoureType);
            return factory.build();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initCustomDataSources(Environment environment) {
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment,"custom.datasource.");
        String dsPrefixs = propertyResolver.getProperty("names");
        for (String dsPrefix:dsPrefixs.split(",")) {
            Map<String,Object> dsMap = propertyResolver.getSubProperties(dsPrefix+".");
            DataSource ds = buildDataSource(dsMap);
            customDataSources.put(dsPrefix,ds);
            dataBinder(ds,environment);
        }
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

    }
}
