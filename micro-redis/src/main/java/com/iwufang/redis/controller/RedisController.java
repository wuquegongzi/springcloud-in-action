package com.iwufang.redis.controller;

import com.iwufang.redis.model.RedisBean;
import com.iwufang.redis.model.RequestJsonData;
import com.iwufang.redis.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @package: com.iwufang.redis.controller
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2017/11/30 19:52
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 批量删除
     * @param requestJsonData
     */
    @RequestMapping(value = "/bathRemove", method = RequestMethod.POST)
    public void bathRemove(@RequestBody RequestJsonData requestJsonData){

        List list = requestJsonData.getRedisBeanList();
        String[] keys =new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            RedisBean redisBean =(RedisBean)list.get(i);
            keys[i]=redisBean.getKey();
        }
        redisUtils.remove(keys);
    }

    /**
     * 根据通配符删除所有key
     * @param redisBean
     */
    @RequestMapping(value = "/removePattern", method = RequestMethod.POST)
    public void removePattern(@RequestBody RedisBean redisBean){
        redisUtils.remove(redisBean.getKey());
    }

    /**
     * 单个删除
     * @param redisBean
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public void remove(@RequestBody RedisBean redisBean){
        redisUtils.remove(redisBean.getKey());
    }

    /**
     * 获取
     * @param redisBean
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Object get(@RequestBody RedisBean redisBean){
        return redisUtils.get(redisBean.getKey());
    }

    /**
     * 存入缓存
     * @param redisBean
     * @return
     */
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public boolean set(@RequestBody RedisBean redisBean){

        boolean result = false;
        if(StringUtils.isEmpty(redisBean.getKey())){
            return result;
        }

        if(redisBean.getExpireTime()<1){
            result = redisUtils.set(redisBean.getKey(),redisBean.getValue());
        }else{
            result = redisUtils.set(redisBean.getKey(),redisBean.getValue(),redisBean.getExpireTime()+(long)(Math.random()*10*1000));
        }
        return result;
    }
}
