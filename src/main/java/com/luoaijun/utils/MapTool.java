package com.luoaijun.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
 
 /**
  * 
  * TODO map 工具类
  * @author 罗爱军
  * @date 2018年3月8日
  * @email 3191287315@qq.com
  * @package Coolibcom.luoaijun.tool.collectionMapTool.java
  * @describe TODO:
  * @include :
  * @category :
  */
public class MapTool implements PrintInter {

	/**
	 * 
	 * @category 迭代遍历获取map中的字符串
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> Object print(T t) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		if (t instanceof Map) {

			HashMap map = (HashMap) t;
			Collection collection = map.keySet();

			Iterator<HashMap> iterator = collection.iterator();

			while (iterator.hasNext()) {
				builder.append(iterator.next());
			}
		}
		return builder.toString();
	}

	@Override
	public <T> Object println(T t) {
		return t;
		// TODO Auto-generated method stub

	}

	/**
	 * @category 获取一个properties对象
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static Properties getProperties(String str) throws IOException {
		Properties p = new Properties();
		p.load(new FileReader(str));
		return p;
	}

	 
	/**
	 * @category 验证登录
	 * @param pro
	 * @return
	 */
	public static boolean login(Properties pro) {
		String name = pro.getProperty("name");
		String psd = pro.getProperty("password");
		return name.equals(Print.newString()) && psd.equals(Print.newString());
	}





}
