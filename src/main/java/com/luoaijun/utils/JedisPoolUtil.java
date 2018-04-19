/**
 * 
 */
package com.luoaijun.utils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * TODO
 * @author 罗爱军
 * @date 2018年4月16日
 * @email 3191287315@qq.com
 * @package Redis.com.luoaijun.utils.JRedisPoolTool.java
 * @describe TODO:
 * @extends :
 */
public class JedisPoolUtil {
	private static volatile JedisPool jedisPool  =  null;
	public static JedisPool getJedisInstance(){
		if (jedisPool==null) {
			JedisPoolConfig jedisPoolConfig =  new JedisPoolConfig();
			jedisPoolConfig.setMaxIdle(200);//最大连接数
			jedisPoolConfig.setMaxIdle(32);//最大存活数
			jedisPoolConfig.setMaxWaitMillis(1000*100);
			jedisPoolConfig.setBlockWhenExhausted(true);
			jedisPoolConfig.setTestOnBorrow(true);
			jedisPool = new JedisPool(jedisPoolConfig,"192.168.72.30",6379, 60000);
		}
		return jedisPool;
	}
	public static void release(JedisPool jedisPool, Jedis jedis) {
		if (null != jedis) {
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * 
	 */
	public JedisPoolUtil() {
		// TODO Auto-generated constructor stub
	}
}
