package com.iwufang.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.*;
import java.util.Enumeration;

/**
 * 共用 系统工具类
 * @package: com.iwufang.common.utils
 * @author: leon<swchenminglei@163.com>
 * @date: 2017/11/8 17:27
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
public class CommonUtils {

    /**
     * 获取客户端真实ip
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request)
    {
        return request.getRemoteAddr();
    }


    /**
     * 获取当前复杂网络ip
     * @param request
     * @return
     */
    public static String getComplexIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 获取复杂网络环境下的本地Ip地址
     * @return
     */
    public static String getLocalHostLANAddress(){
            try {
                InetAddress candidateAddress = null;
                // 遍历所有的网络接口
                for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                    NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                    // 在所有的接口下再遍历IP
                    for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                        InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                        if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                            if (inetAddr.isSiteLocalAddress()) {
                                // 如果是site-local地址，就是它了
                                return inetAddr.getHostAddress();
                            } else if (candidateAddress == null) {
                                // site-local类型的地址未被发现，先记录候选地址
                                candidateAddress = inetAddr;
                            }
                        }
                    }
                }
                if (candidateAddress != null) {
                    return candidateAddress.getHostAddress();
                }
                // 如果没有发现 non-loopback地址.只能用最次选的方案
                InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
                return jdkSuppliedAddress.getHostAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }

    /**
     * 获取网站网址
     *
     * @param request
     * @return
     */
    public static String getWebsite(HttpServletRequest request)
    {
        int port = request.getServerPort();
        String basePath = request.getScheme() + "://" + request.getServerName();
        if (port == 80) {
            return basePath;
        }
        return basePath + ":" + port;
    }

    /**
     * 获取网站根路径
     *
     * @param request
     * @return
     */
    public static String getRoot(HttpServletRequest request)
    {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + path + "/";
        return basePath;
    }

    /**
     * 获取请求参数,转义html等特殊字符
     *
     */
    public static String getParameterIgnoreHtml(HttpServletRequest request,
                                                String key)
    {
        String s = request.getParameter(key);
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        else {
            return replaceHtml(s);
        }
    }

    /**
     * 获取请求参数,清空空格,引号等字符
     *
     */
    public static String getParameterIgnoreBlank(HttpServletRequest request,
                                                 String key)
    {
        String s = request.getParameter(key);
        if (s == null) {
            return null;
        }
        else {
            return replaceBlank(s);
        }
    }

    /**
     * 将字符串中的空格等字符清空
     *
     */
    public static String replaceBlank(String str)
    {
        if(str==null) {return "";}
        return str.replaceAll("[\\s|	｜　|'|\"]", "");
    }

    /**
     * 将字符串中的html字符转义
     */
    public static String replaceHtml(String str)
    {
        if(str==null){
            return "";
        }

        return str.replaceAll("&", "&amp").replaceAll("<", "&lt;").replaceAll(
                ">", "&gt;").replaceAll("\"", "&quot;").replaceAll(">", "&gt;")
                .replaceAll(">", "&gt;");
    }


    public static void main(String[] args) {

        System.out.println(CommonUtils.getLocalHostLANAddress());
    }
}
