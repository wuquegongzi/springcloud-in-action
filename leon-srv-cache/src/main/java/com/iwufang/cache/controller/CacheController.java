package com.iwufang.cache.controller;

import com.iwufang.cache.rpcservice.RedisRemoteService;
import cn.com.gmmedicare.common.model.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @package: com.iwufang.cache.controller
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2017/11/30 20:09
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    RedisRemoteService redisRemoteService;


    /**
     *
     * @param clientId
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public ResultMsg set(@RequestParam(value = "clientId", required = false) String clientId,
                         @RequestParam(value = "key", required = true) String key,
                         @RequestParam(value = "value", required = true) Object value,
                         @RequestParam(value = "expireTime", defaultValue ="0") long expireTime ){


        return redisRemoteService.set(clientId,key,value,expireTime);
    }

    @RequestMapping(value = "/get")
    public ResultMsg get(@RequestParam(value = "clientId", required = true) String clientId,
                      @RequestParam(value = "key", required = true) String key){
        return redisRemoteService.get(clientId,key);
    }

    @RequestMapping(value = "/remove")
    public ResultMsg remove(@RequestParam(value = "clientId", required = true) String clientId,
                            @RequestParam(value = "key", required = true) String key){
        return redisRemoteService.remove(clientId,key);
    }
}
