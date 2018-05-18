package com.ideal.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;


public class ComplainUtil {
	private static List<String> complainList = null;

	public static List<String> getComplainList(String path,String charset,int index) {
		FileInputStream fileReader = null;
		BufferedReader reader = null;
		int i=0;
		try {
			complainList = new ArrayList<String>();
			String complain = null;
			fileReader = new FileInputStream(path);
			reader = new BufferedReader(new InputStreamReader(fileReader, charset));
			while (StringUtils.isNotEmpty(complain = reader.readLine())) {
				if (i<index) {
					i++;
					continue;
				}
				complainList.add(complain);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return complainList;
	}
	
	public static String getComplainReplace(String complainStr) {
		String[] se = new String[] { "_", "\"", "(", ")", "（", "）", "/",
				"null", "、", "“", "”", "-", ">", "|", "�", "&nbsp"};
		for (String s : se) {
			complainStr = complainStr.replace(s, "");
		}

		String[] sa = new String[] { ":", ";", "，", "。", ",", "：", "；", "!",
				"！", "【", "】", "[", "]" };
		for (String s : sa) {
			complainStr = complainStr.replace(s, "	");
		}
		 
		return complainStr.replaceAll("[^(\\u4e00-\\u9fa5)]","");
	}
	
}
