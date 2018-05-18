package com.ideal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ideal.util.ComplainUtil;

public class ComplainTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		String path = args[0];
//		String charset = args[1];
//		int index = Integer.parseInt(args[2]);
		String path = "F:\\WorkSpaces\\KeimonSpace\\all.csv";
		String charset = "GB2312";
		int index = 1;
		List<String> complainList = ComplainUtil.getComplainList(path, charset,index);
		String[] str = null;
		// 第一次循环，获取完整对话
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String complainStr : complainList) {
			complainStr = ComplainUtil.getComplainReplace(complainStr);
			str = complainStr.split("	");
			for (String complain : str) {
				int len = complain.length();
				if (len>10) {
					complain=complain.substring(0, 10);
				}
				ComplainTest.actionMap(complain, map);
			}
		}
		// 解析完整对话
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		;
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int j = key.length();
			for (int i = j; i >= 2; i--) {
				ComplainTest.actionMap(key.substring(0, i), map2);
			}
		}
		
		File file = new File(path + ".complain");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		for (Entry<String, Integer> entry : map2.entrySet()) {
//			if(entry.getValue()>100) {
				String complain = entry.getKey() + "|" + entry.getValue() + "\n";
				byte[] contentInBytes = complain.getBytes();
				fop.write(contentInBytes);
//			}
		}
		fop.flush();
		fop.close();
		System.out.println("Done");
	}

	public static void actionMap(String complain, Map<String, Integer> map) {
		if (!complain.equals("") && complain.length() >= 2) {
			if (map.containsKey(complain)) {
				map.put(complain, (map.get(complain)).intValue() + 1);
			} else {
				map.put(complain, 1);
			}
		}
	}
}
