/**
 * 
 */
package com.luoaijun.redis.handler;

/**
 * TODO
 * @author 罗爱军
 * @date 2018年4月13日
 * @email 3191287315@qq.com
 * @package Redis.com.luoaijun.redis.handler.VCode.java
 * @describe TODO:
 * @extends :
 */
public interface VCode {
	
    public static String PHONE_PREFIX = "pn:";  //验证码Key前缀
	
    public static String PHONE_SUFFIX = ":code";    //验证码key后缀 
    
    public static String COUNT_SUFFIX = ":count";    //计数器key后缀
    
    public static int CODE_LEN = 6;   //随机码长度
    
    public static int CODE_TIMEOUT = 120;//随机码有效时间

    public static int COUNT_TIMES_1DAY = 3;  //单日最多发送次数
    
    public static int SECONDS_PER_DAY = 60*60*24; //单日秒数
    
    public static String HOST = "192.168.162.128"; //主机地址
    
    public static int PORT = 6379; //端口号
}
