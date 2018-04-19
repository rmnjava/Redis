package com.luoaijun.utils;

/**
 * 
 * TODO
 * @author 罗爱军
 * @date 2018年3月12日
 * @email 3191287315@qq.com
 * @package JDBCUtils-StudentInfoSystemcom.luoaijun.libraryMathString.java
 * @describe TODO:
 * @include :
 * @category :
 */
public class MathString {

	
	/**
	 * @category 随机生成指定长度内的字符串
	 */
	public static String randomString(int number) {
		String STR = "";
		char[] str = { 'a', 'A' };

		char[] strChar = new char[52];
		for (int i = 0; i < strChar.length; i++) {

			if (i > 25) {
				strChar[i] = str[0]++;

			} else if (i < 25 ) {
				strChar[i] = str[1]++;
			} 
		}
		for (int i = 0; i < number; i++) {
			int index = (int) (Math.random() *51 + 1);
			STR = STR + strChar[index];
		}
		return STR;
	}
}
