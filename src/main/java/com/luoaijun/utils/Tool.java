package com.luoaijun.utils;

import java.util.Timer;
import java.util.TimerTask;

public class Tool {
	/**
	 * @category 数组清零操作
	 */
	public static int[] clear(int[] temp) {
		int count = 0;
		int[] index = new int[temp.length];
		int[] NoTemp = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				index[count++] = i;// 获取temp中值不为0的数据的下标

			}
		}
		int[] arrayName = new int[count];// 初始化一个大小为count的数组
		int i = 0;
		if (count != 0) {
			try {
				for (i = 0; i < arrayName.length; i++) {
					arrayName[i] = temp[index[i]];
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				System.out.println("index 溢出:第" + i + "个位置");
				e.printStackTrace();
			}
			return arrayName;
		} else {
			return NoTemp;
		}

	}

	/**
	 * @category 数组清零操作
	 */
	public static String[] clearString(String[] temp) {

		int count = 0;
		int[] index = new int[temp.length];
		String[] NoTemp = new String[temp.length];

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				index[count++] = i;// 获取temp中值不为0的数据的下标
			}
		}
		String[] arrayName = new String[count];
		int i = 0;
		if (count != 0) {

			try {
				for (i = 0; i < arrayName.length; i++) {
					arrayName[i] = temp[index[i]];
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				System.out.println("String 溢出:第" + i + "个位置");
				e.printStackTrace();
			}
			return arrayName;
		} else {
			return NoTemp;
		}
	}

	/**
	 * @category 延时函数 毫秒
	 * @param number
	 */
	public static void delayWith(int number, final String str) {
		
		try {
			Thread.currentThread().sleep(number);
			System.out.print(str);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @category 延时函数 秒
	 * @param number
	 */
	public static void delay(int number) {
		try {
			for (int i = 0; i < number; i++) {
				Thread.currentThread().sleep(1000);
				System.out.print(".");
			}
			System.out.println();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @category 延时函数 毫秒
	 * @param number
	 */
	public static void delayM(int number) {
		try {
				Thread.currentThread().sleep(number);
		
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
