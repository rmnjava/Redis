package com.luoaijun.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class IOFuction {
	private List<File> listFile;

	/**
	 * @category ����һ���ļ�
	 * @param name
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static File createFile(File name, String str) throws IOException {
		File file = new File(str);
		if (!file.exists()) {
			file.createNewFile();
		}
		return file;
	}

	/**
	 * @category ��ȡ�ļ��е�һ���ַ�
	 * @param file
	 * @param index
	 * @return
	 */
	public static char readAChar(File file,int index) {
		int len;
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			len = reader.read();
			while (len != -1) {
				return (char) (reader.read());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return 0;

	}

	/**
	 * @category �ݹ��ӡ�ļ���Ŀ¼��
	 * @param file
	 */
	public static void list(File file) {
		File[] files = file.listFiles();

		for (File sub : files) {
			System.out.println(sub.getName());
			if (sub.isDirectory()) {
				list(sub);
			}
		}
	}

	/**
	 * @category �ݹ��ӡ��str��׺���ļ���Ŀ¼��
	 * @param file
	 * @param str
	 */
	public static void list(File file, String str) {
		File[] files = file.listFiles();

		for (File sub : files) {
			if (sub.getName().endsWith(str)) {
				System.out.println(sub.getName());
				continue;
			}
			if (sub.isDirectory()) {
				list(sub);
			}
		}
	}

}
