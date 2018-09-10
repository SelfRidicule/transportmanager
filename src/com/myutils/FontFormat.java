package com.myutils;

import javax.servlet.http.HttpServletResponse;

/**
 *  设置字符格式
 */
public class FontFormat {
	/**
	 * 构造方法
	 */
	public FontFormat() {
		super();
	}

	/**
	 *  设置字体格式
	 */
	public static void setFontFormat(HttpServletResponse response){
//		设置字符格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	}
	
	/**
	 *  拆分字符串
	 */
	public static String[] splitStringArray(String str,String splitSymbol){
		String strArray[] = str.split(splitSymbol);
		return strArray;
	}
	
	/**
	 *  删除指定的字符串
	 */
	public static String[] deleteIndexStr(String string[],String startStr ){
		
		if(string == null || "".equals(string[0])){
			return null;
		}
		
		for (int i = 0; i < string.length; i++) {
			String str = string[i];
			int index =str.indexOf(startStr);
			string[i]=str.substring(index);
		}
		
		return string;
	}
	
}
