package com.luoaijun.utils;

import java.util.Iterator;
import java.util.Set;
 

/**
 * 
 * TODO set工具类
 * 
 * @author 罗爱军
 * @date 2018年3月8日
 * @email 3191287315@qq.com
 * @package Coolibcom.luoaijun.tool.collectionSetTool.java
 * @describe TODO:
 * @include :
 * @category :
 */
public class SetTool implements PrintInter {

	@Override
	public <T> Object print(T t) {
		StringBuilder stringBuilder = null;
		if (t instanceof Set) {
			Set set = (Set) t;
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				stringBuilder.append(iterator.next());
			}
		}
		return stringBuilder;
		// TODO Auto-generated method stub
	}

	@Override
	public <Set> Object println(Set t) {
		return t;
		// TODO Auto-generated method stub

	}

}
