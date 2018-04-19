/**
 * 
 */
package com.luoaijun.redis.handler;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luoaijun.redis.bean.User;

import redis.clients.jedis.Jedis;

/**
 * TODO 手机验证码
 * 
 * @author 罗爱军
 * @date 2018年4月13日
 * @email 3191287315@qq.com
 * @package Redis.com.luoaijun.handler.RedisHandler.java
 * @describe TODO:
 * @extends :
 */

@Controller
public class RedisHandler {
	// 获取redis的连接，IP自行更换
	Jedis jedis = new Jedis("192.168.72.30", 6379);

	/**
	 * TODO 获取手机验证码
	 * 
	 * @param user
	 */
	@RequestMapping("CodeSenderServlet")
	public void CodeSenderServlet(User user) {
		// System.out.println("验证码");
		// 获取前台的手机号
		String phone_no = user.getphone_no();
		System.out.println(user);
		// 生成验证码
		String code = genCode(VCode.CODE_LEN);
		if (phone_no == null || phone_no.equals("")) {
			return;
		}
		// 生成计数器的key
		String key_count = phone_no + VCode.COUNT_SUFFIX;
		String count_db = jedis.get(key_count);
		if (count_db == null) {
			jedis.setex(key_count, VCode.SECONDS_PER_DAY, "1");
		} else {
			int count = Integer.parseInt(count_db);
			if (count >= 3) {
				System.out.println("此号码已超过次数");
				jedis.close();
				return;
			} else {
				jedis.incr(key_count);
			}
		}
		// ——----------生成验证码
		String key_phone = VCode.PHONE_PREFIX + phone_no + VCode.COUNT_SUFFIX;
		// 生成key
		jedis.setex(key_phone, VCode.CODE_TIMEOUT, code);
		// 模拟通过用户验证码
		System.out.println(key_phone + "====>" + code);
		jedis.close();

	}

	/**
	 * TODO 后台验证是否正确
	 * 
	 * @param user
	 */
	@RequestMapping("CodeVerifyServlet")
	public void CodeVerifyServlet(User user) {
		String phone_no = user.getphone_no();
		String code_front = user.getverify_code();

		// 手机验证码的key
		String key_phone = VCode.PHONE_PREFIX + phone_no + VCode.COUNT_SUFFIX;

		if (code_front.equals("") || phone_no.equals("") || code_front == null || phone_no == null) {
			return;
		}
		String code_db = jedis.get(key_phone);
		// 验证
		if (code_db.equals(code_front)) {
			System.out.println("验证成功！");
			jedis.close();
		} else {
			System.out.println("验证失败！");
		}
		return;
	}

	/**
	 * TODO 生成6位的随机码
	 * 
	 * @param len
	 * @return
	 */
	private String genCode(int len) {
		String code = "";
		for (int i = 0; i < len; i++) {
			int rand = new Random().nextInt(10);
			code += rand;
		}
		return code;
	}
}
