package com.iwufang.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @package: com.iwufang.redis.model
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2017/12/5 13:04
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestJsonData implements Serializable {

    private List<RedisBean> redisBeanList;
}
