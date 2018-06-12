package com.iwufang.merge.aspect;

import com.iwufang.merge.annotation.DS;
import com.iwufang.merge.druid.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 设置数据源切面
 * @package: com.iwufang.merge.aspect
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2018/4/12 9:58
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    /**
     * 切换数据库
     * @param point
     * @param ds
     * @return
     * @throws Throwable
     */
    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, DS ds){

        String dsId = ds.name();
        if(!DataSourceHolder.existDateSoure(dsId)){
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", ds.name(), point.getSignature());
            return;
        }else{
            logger.debug("Use DataSource : {} > {}", ds.name(), point.getSignature());
            DataSourceHolder.setDateSoure(dsId);
        }
    }

    /**
     * @Title: destroyDataSource
     * @Description: 销毁数据源  在所有的方法执行执行完毕后
     * @param point
     * @param ds
     * @return void
     * @throws
     */
    @After("@annotation(ds)")
    public void destroyDataSource(JoinPoint point,DS ds){
        logger.debug("Revert DataSource : {} > {}", ds.name(), point.getSignature());
        DataSourceHolder.clearDateSoure();
    }
}
