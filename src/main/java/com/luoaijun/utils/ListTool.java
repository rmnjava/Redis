package com.luoaijun.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List; 

/**
 * 
 * TODO list 工具类
 * 
 * @author 罗爱军
 * @date 2018年3月8日
 * @email 3191287315@qq.com
 * @package Coolibcom.luoaijun.tool.collectionListTool.java
 * @describe TODO:
 * @include :
 * @category :
 */
public class ListTool {

	/**
	 * @category 打印list类内容
	 * @param list
	 * @return iterator.next()
	 * @return null
	 */
	@SuppressWarnings("rawtypes")
	public static <T> Object getPrintLn(List<T> list) {
		Iterator iterator = list.iterator();
		StringBuilder builder = new StringBuilder();
		while (iterator.hasNext()) {
			builder.append(iterator.next() + "\n");
		}
		return builder.toString();
	}

	public static <T> void printLn(List<T> list) {
		Iterator iterator = list.iterator();
		StringBuilder builder = new StringBuilder();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
