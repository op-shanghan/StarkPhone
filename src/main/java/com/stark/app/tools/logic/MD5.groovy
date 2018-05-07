package com.stark.app.tools.logic


import java.security.MessageDigest

class MD5 {



    static String toMD5(String st){
        MessageDigest digest = MessageDigest.getInstance("md5")
        byte [] bs = digest.digest(st.getBytes())
        String hexString = ""
        bs.each {b->
            int temp = b & 255
            if(temp < 16 && temp >=0){
                hexString = hexString + "0" + Integer.toHexString(temp)
            }else {
                hexString = hexString + Integer.toHexString(temp)
            }
        }
        return hexString
    }

    static String toMD516(String st){
        return toMD5(st).substring(8,24)
    }

}
