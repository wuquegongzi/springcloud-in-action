package com.iwufang.cache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @package: com.iwufang.cache.model
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2017/12/5 14:20
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