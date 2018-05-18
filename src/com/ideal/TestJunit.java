package com.ideal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

public class TestJunit {

	private static BufferedReader reader;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		String key = "谢成贵受理人联电";
//		int j = key.length();
//		for (int i = 7; i >= 2; i--) {
//			System.out.println(key.substring(0, i));
//		}
//		
//		String s = "sf9897&^%fdferf";
//		s = s.replaceAll("[^0-9a-zA-Z]","");
//		System.out.println(s);
//		
//		System.out.println("发射点发".replaceAll("[^(\\u4e00-\\u9fa5)]", ""));
		
//		String path = "F:\\WorkSpaces\\KeimonSpace\\20180423_complain_bigdata_province.csv.complain";
//		String charset = "GB2312";
//		int index = 1;
//		
//		String complain = null;
//		FileInputStream fileReader = new FileInputStream(path);
//		reader = new BufferedReader(new InputStreamReader(fileReader, charset));
//		while (StringUtils.isNotEmpty(complain = reader.readLine())) {
//			System.out.println(complain);
//		}
//		
		String complain="123sdfas打发第三方";
		int len = complain.length();
		if (len>10) {
			complain=complain.substring(0, 10);
			System.out.println(complain);
		} else {
			System.out.println(complain);
		}
		
		
	}
}
