/**
 * 
 */
package com.luoaijun.redis.handler;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luoaijun.redis.bean.User;
import com.luoaijun.utils.JedisPoolUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

/**
 * TODO
 * 
 * @author 罗爱军
 * @date 2018年4月13日
 * @email 3191287315@qq.com
 * @package Redis.com.luoaijun.redis.handler.SecKillHandler.java
 * @describe TODO:
 * @extends :
 */
@Controller
public class SecKillHandler {
	/**
	 * ab -c 100 -n 1000 http://192.168.113.24/
	 */
	// 存储商品剩余库存的key
	String qtKey ;
	// 存储秒杀成功用户的key
	String usrKey ;
	JedisPool jedisPool = JedisPoolUtil.getJedisInstance();
	Jedis jedis = jedisPool.getResource();
	
	@RequestMapping("doseckill")
	public void SecKill(User user) {
		String userid = new Random().nextInt(50000) + "";
		// 获取秒杀的产品id
		String prodid = user.getProdid();
		System.out.println("prodid:"+prodid);
		boolean if_success = seckillRedis(userid, prodid);
		// boolean if_success=SecKill_redis.doSecKill(userid,prodid);

	}
	public void initRedis(String uid, String prodid){
		 qtKey = "sk:" + prodid + ":qt";
		// 存储秒杀成功用户的key
		 usrKey = "sk:" + prodid + ":usr";
		 jedis.set(qtKey, "100");
	}
	public boolean seckillRedis(String uid, String prodid) {
		initRedis(uid, prodid);
		if (jedis.sismember(usrKey, uid)) {

			jedis.close();

			System.out.println(uid + "已经抢过了！");

			return false;

		}

		// 在操作之前加锁
		jedis.watch(qtKey);

		String str_qtkey = jedis.get(qtKey);
		
		
		if (str_qtkey == null) {

			jedis.close();

			System.out.println("商品未被初始化！");

			return false;
		} else {
			int int_qtkey = Integer.parseInt(str_qtkey);

			if (int_qtkey <= 0) {

				jedis.close();

				System.out.println("商品已经被抢光！");

				return false;
			}
		}

		// ------------可以被抢购-------------

		Transaction transaction = jedis.multi();

		transaction.decr(qtKey);

		transaction.sadd(usrKey, uid);

		List<Object> exec = transaction.exec();

		if (exec == null || exec.size() == 0) {
			System.out.println("抢购失败！");
			jedis.close();
			return false;
		}

		System.out.println(uid + "秒杀成功！");

		return true;

	}
}
