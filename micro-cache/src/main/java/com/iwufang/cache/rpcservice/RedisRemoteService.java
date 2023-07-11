package com.iwufang.cache.rpcservice;

import com.iwufang.cache.model.CacheResultStatusCodeEnum;
import com.iwufang.cache.model.RedisBean;
import cn.com.gmmedicare.common.model.ResultMsg;
import cn.com.gmmedicare.common.model.ResultStatusCodeEnum;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 一级流程管控 服务 调用
 * @package: com.iwufang.cache.rpcservice
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2017/11/2 14:38
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@Service
public class RedisRemoteService {

    private static Logger logger =  LoggerFactory.getLogger(RedisRemoteService.class);


    @Autowired
    RestTemplate restTemplate;
    private final RedisRemoteService redisRemoteService = this;

    /**
     * set
     * @param clientId
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    @HystrixCommand(fallbackMethod = "setError")
    public ResultMsg set(String clientId, String key, Object value, long expireTime){

        RedisBean redisBean = new RedisBean(key,value,expireTime);

        String restURI ="http://LEON-SRV-REDIS-"+clientId+"/redis/set";

        boolean result = restTemplate.postForObject(restURI,
                redisBean, Boolean.class);

        ResultMsg resultMsg = new ResultMsg(ResultStatusCodeEnum.OK.getErrcode(),
                ResultStatusCodeEnum.OK.getErrmsg(),
                key);

        if(!result){
            resultMsg = new ResultMsg(CacheResultStatusCodeEnum.SET_REDIS_FAIL.getErrcode(),
                    CacheResultStatusCodeEnum.SET_REDIS_FAIL.getErrmsg(),
                    key);
        }
        return resultMsg;
    }


    /**
     * get
     * @param clientId
     * @param key
     * @return
     */
    @HystrixCommand(fallbackMethod = "getError")
    public ResultMsg get(String clientId, String key) {
        RedisBean redisBean = new RedisBean();

        redisBean.setKey(key);

        String restURI ="http://LEON-SRV-REDIS-"+clientId+"/redis/get";

        Object result = restTemplate.postForObject(restURI,
                redisBean, Object.class);

        ResultMsg resultMsg = new ResultMsg(ResultStatusCodeEnum.OK.getErrcode(),
                ResultStatusCodeEnum.OK.getErrmsg(),
                result);

        return resultMsg;

    }

    /**
     * remove
     * @param clientId
     * @param key
     * @return
     */
    @HystrixCommand(fallbackMethod = "removeError")
    public ResultMsg remove(String clientId, String key) {
        RedisBean redisBean = new RedisBean();
        redisBean.setKey(key);
        String restURI ="http://LEON-SRV-REDIS-"+clientId+"/redis/remove";

        Object result = restTemplate.postForObject(restURI,
                redisBean, Object.class);

        ResultMsg resultMsg =  resultMsg = new ResultMsg(ResultStatusCodeEnum.OK.getErrcode(),
                ResultStatusCodeEnum.OK.getErrmsg(),
                result);

        return resultMsg;
    }


    /**
     * 断路器
     * @return
     */
    public ResultMsg setError(String clientId, String key, Object value, long expireTime){
        ResultMsg resultMsg = new ResultMsg(ResultStatusCodeEnum.SYSTEM_ERR.getErrcode(),ResultStatusCodeEnum.SYSTEM_ERR.getErrmsg(),key);
        return resultMsg;
    }

    public ResultMsg getError(String clientId, String key) {
        ResultMsg resultMsg = new ResultMsg(ResultStatusCodeEnum.SYSTEM_ERR.getErrcode(),ResultStatusCodeEnum.SYSTEM_ERR.getErrmsg(),key);
        return resultMsg;
    }

    public ResultMsg removeError(String clientId, String key) {
        ResultMsg resultMsg = new ResultMsg(ResultStatusCodeEnum.SYSTEM_ERR.getErrcode(),ResultStatusCodeEnum.SYSTEM_ERR.getErrmsg(),key);
        return resultMsg;
    }
}
