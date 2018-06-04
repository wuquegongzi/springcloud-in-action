package com.iwufang.other.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.iwufang.common.utils.CommonUtils;

/**
 * logback 日志 ip转换辅助
 * @package: com.iwufang.other.logback
 * @author: leon<swchenminglei@163.com>
 * @date: 2017/11/8 17:05
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
public class IpConvert extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {

        return CommonUtils.getLocalHostLANAddress();
    }
}
