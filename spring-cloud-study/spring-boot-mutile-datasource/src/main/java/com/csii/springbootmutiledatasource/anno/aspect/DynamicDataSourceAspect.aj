package com.csii.springbootmutiledatasource.anno.aspect;

import com.csii.springbootmutiledatasource.anno.annotation.TargetDataSource;
import com.csii.springbootmutiledatasource.dybamicDataSource.DynamicDataSource;
import com.csii.springbootmutiledatasource.dybamicDataSource.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: ${todo}
 * @author cuitao
 * @date 2018/8/28 - 23:16 -- 星期二
 * @version V1.0
 */
@Order(-10)//保证该AOP在@Transactional之前执行
@Component
@Aspect
public aspect DynamicDataSourceAspect {
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource)throws Throwable{
        String dsId = targetDataSource.value();
        if(!DynamicDataSourceContextHolder.containsDataSource(dsId)){
            System.err.println("数据源[{}]不存在,使用默认数据源 ->{}"+targetDataSource.value()+joinPoint.getSignature());
        }else{
            System.err.println("使用数据源[{}]"+targetDataSource.value()+joinPoint.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(targetDataSource.value());
        }

    }
    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource){
        System.err.println("Revert DataSource:{} -> {}"+targetDataSource.value()+joinPoint.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceType();
    }

}
