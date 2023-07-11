package com.iwufang.merge.annotation;

import java.lang.annotation.*;

/**
 * 动态数据源注解
 * @package: com.iwufang.merge.annotation
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2018/4/12 9:55
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface DS{

    String name() default "test1";
}
