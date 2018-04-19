package com.luoaijun.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 罗爱军
 * @date 2018.1.20
 * @function 算法优化
 * @category 动态数组内存 2.IO异常处理
 */
public class Print {
	final static String CLASS_NAME = "java.lang.String";
	static Scanner scanner = new Scanner(System.in);

	/**
	 * @function 键盘读取数字并处理非数字异常
	 * @return int
	 */
	public static int newInt() {
		String string = scanner.next();
		int i = 0;
		try {
			i = Integer.parseInt(string);
			return i;
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("请输入数字：");
			return -1;
		}

	} 
	/**
	 * @function 键盘读取数字并处理非数字异常
	 * @return double
	 */
	public static double newDouble() {
		String string = scanner.next();
		double i = 0;
		while (true) {
			try {
				i = Double.parseDouble(string);
				return i;

			} catch (RuntimeException e) {
				// TODO: handle exception
				System.out.println("请输入数字：");

				return -1;

			}
		}

	}

	/**
	 * @function 键盘读取数字并处理非数字异常
	 * @return long
	 */
	public static long newLong() {
		String string = scanner.next();
		long i = 0;
		try {
			i = Long.parseLong(string);
			return i;
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("请输入数字：");
			return -1;
		}

	}

	/**
	 * @function 键盘读取数字并处理非数字异常
	 * @return Float
	 */
	public static float newFloat() {
		float i = 0;
		String string = scanner.next();
		try {
			i = Float.parseFloat(string);
			return i;
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("请输入数字：");
			return -1;
		}
	}
	/**
	 * @function 读取string
	 */
	public static String newString(){
		return scanner.next();
	}
	/**
	 * @category 通过转换流 获取输入的字符串
	 * @throws IOException  
	 */
	public static String newStringIuputStream() throws IOException{
		BufferedReader bufferedReader  =  new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  builder = new StringBuilder() ;
		builder.append(bufferedReader.readLine());
		bufferedReader.close();
		return builder.toString(); 
	}
	/**
	 * @category 通过转换流获取输入的字符
	 * @return
	 * @throws IOException
	 */
	public static char newCharInputStream() throws IOException{
		return Print.newStringIuputStream().charAt(0);
	}
	/**
	 * @category 读取字符
	 * @return
	 */
	public static char newChar() {
		// TODO Auto-generated method stub
		return scanner.next().charAt(0);
	}
	/**
	 * 
	 * @return boolean
	 */
	public static boolean newBoolean(){
		return scanner.nextBoolean();
	} 
	/**
	 * @category 根据 T 来获取输入
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T newT(T t) {
		List<T> list = new ArrayList<>();
		if (t instanceof String) {
			list.add((T) Print.newString());
			return (T) list.get(0);
		} else if (t instanceof Integer) {
			list.add((T) ((Integer) Print.newInt()));
			return (T) list.get(0);
		} else if (t instanceof Character) {
			list.add((T) (Character) (Print.newChar()));
			return (T) list.get(0);
		}else if (t instanceof Boolean) {
			list.add((T) (Boolean) (Print.newBoolean()));
			return (T) list.get(0);
		}
		return null;
	}
	
	
}
