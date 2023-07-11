package com.iwufang.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @package: cn.com.gmmedicare.redis.model
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2017/12/5 12:47
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisBean implements Serializable {
    private String key;
    private Object value;
    private Long expireTime;
}
