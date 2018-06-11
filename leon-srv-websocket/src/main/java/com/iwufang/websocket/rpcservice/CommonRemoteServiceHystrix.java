package com.iwufang.websocket.rpcservice;

import cn.com.gmmedicare.common.model.ResultMsg;
import cn.com.gmmedicare.common.model.ResultStatusCodeEnum;
import cn.com.gmmedicare.common.utils.GsonUtils;
import org.springframework.stereotype.Service;

/**
 * 熔断器
 * @package: cn.com.gmmedicare.datasyn.service
 * @author: 陈明磊<minglei.chen@gm-medicare.com>
 * @date: 2017/11/2 20:05
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@Service
public class CommonRemoteServiceHystrix implements CacheRemoteService{
    
    @Override
    public String set(String clientId, String key, String value, long exprieTime) {
        ResultMsg resultMsg = new ResultMsg(ResultStatusCodeEnum.MESSAGE_SEND_ERR.getErrcode(),
                ResultStatusCodeEnum.MESSAGE_SEND_ERR.getErrmsg(), key);

        return GsonUtils.GsonString(resultMsg);
    }

    @Override
    public String get(String clientId, String key) {
        ResultMsg resultMsg = new ResultMsg(ResultStatusCodeEnum.MESSAGE_SEND_ERR.getErrcode(),
                ResultStatusCodeEnum.MESSAGE_SEND_ERR.getErrmsg(), key);

        return GsonUtils.GsonString(resultMsg);
    }

    @Override
    public String remove(String clientId, String key) {
        ResultMsg resultMsg = new ResultMsg(ResultStatusCodeEnum.MESSAGE_SEND_ERR.getErrcode(),
                ResultStatusCodeEnum.MESSAGE_SEND_ERR.getErrmsg(), key);
        return GsonUtils.GsonString(resultMsg);
    }
}
