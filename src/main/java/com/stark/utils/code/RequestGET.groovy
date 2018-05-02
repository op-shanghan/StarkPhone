package com.stark.utils.code

import javax.servlet.http.HttpServletRequest

class RequestGET {

    static String ip(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for")
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP")
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP")
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr()
        }
        return ip == "0:0:0:0:0:0:0:1"?"127.0.0.1":ip
    }



}
