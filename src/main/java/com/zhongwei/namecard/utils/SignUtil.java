package com.zhongwei.namecard.utils;

import javax.servlet.http.HttpServletRequest;

import jodd.http.HttpRequest;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class SignUtil {

	private static String token = "weixin";

    /**
     * 获取acassToken校验
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        boolean result = false;

        // 对token、timestamp和nonce按字典序排序
        String[] array = new String[]{token, timestamp, nonce};
        Arrays.sort(array);

        // 将三个参数字符拼接成一个字符串
        String str = array[0].concat(array[1]).concat(array[2]);

        String sha1Str = null;
        try {
            // 对拼接后的字符串进行sha1加密
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(str.getBytes());
            sha1Str = byte2str(digest);
        }
        catch(Exception e) {
        }

        if(sha1Str != null &&  sha1Str.equals(signature)) {
            result = true;
        }

        return result;
    }

    /*
     * 将字节数组转换成字符串
     */
    public static String byte2str(byte[] array) {
        StringBuffer hexstr = new StringBuffer();
        String shaHex="";
        for(int i = 0; i < array.length; i++) {
            shaHex = Integer.toHexString(array[i] & 0xFF);
            if(shaHex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(shaHex);
        }
        return hexstr.toString();
    }

    /**
     * 获取acaccessToken
     * @param grant_type
     * @param appid
     * @param secret
     * @return
     */
    public static String getAcaccessToken(String grant_type,String appid,String secret){

        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type="+grant_type+"&appid="+appid+"&secret="+secret;
//        String Str = HttpRequest.httpRequestGet(url);
        String Str = "";
        return Str;
    }

    /**
     * 创建随机字符串
     * @return
     */
    public static String createNonceStr() {
        return UUID.randomUUID().toString().substring(0, 20);
    }

    /**
     * 获取时间戳
     * @return
     */
    public static String getCurrTime(){

        long times = new Date().getTime();
        return times+"";
    }

    /**
     * 随机数
     * @param length
     * @return
     */
    public static String buildRandom(int length){
        long times = new Date().getTime();
        int randomNum = (int)((Math.random()*9+1)*(10*length));

        return randomNum+""+times;
    }

    /**
     * 获取用户IP
     * @param request
     * @return
     */
    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        String ipListStr = request.getHeader("x-forwarded-for");
        if(!(ipListStr.indexOf(",")<0)){
            String [] list = ipListStr.split(",");
            return list[0];                                 //当服务部署使用代理，其获取到的IP地址将会是多个，取第一个
        }else {
            return ipListStr ;
        }

    }
}
