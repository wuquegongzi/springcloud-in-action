package com.iwufang.websocket.rpcservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@FeignClient(name = "GM-SRV-CACHE",
        fallback = CommonRemoteServiceHystrix.class,
        configuration = CommonRemoteServiceAuthConfig.class)
public interface CacheRemoteService {

    /**
     * 存入缓存
     * @param clientId
     * @param key
     * @param value
     * @param exprieTime
     * @return
     */
    @RequestMapping(value = "/cache/set",method = RequestMethod.POST)
    public String set(@RequestParam("clientId") String clientId,
                      @RequestParam("key") String key,
                      @RequestParam("value") String value,
                      @RequestParam("exprieTime") long exprieTime);


    /**
     * 获取
     * @param clientId
     * @param key
     * @return
     */
    @RequestMapping(value = "/cache/get",method = RequestMethod.POST)
    public String get(@RequestParam("clientId") String clientId,
                      @RequestParam("key") String key);

    /**
     * 单个删除
     * @param clientId
     * @param key
     * @return
     */
    @RequestMapping(value = "/cache/remove",method = RequestMethod.POST)
    public String remove(@RequestParam("clientId") String clientId,
                         @RequestParam("key") String key);

}
