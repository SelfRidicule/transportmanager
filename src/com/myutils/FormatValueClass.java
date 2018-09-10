package com.myutils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  格式化值
 */
public class FormatValueClass {
	/**
	 * 构造方法
	 */
	public FormatValueClass() {
		super();
	}

	/**
	 *  得到格式化后的值
	 */
	public static String getFormatValueClass(Object obj){
		String str = "";
//		判断是否为null
		if(obj == null){
			return str;
		}
//		得到传递对象的Class对象
		Class objClass = obj.getClass();
//		判断是否是日期
		if(objClass == Date.class){
			Date date = (Date) obj;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			str = sdf.format(date);
			return str;
		}
//		判断是否是日期
		if(objClass == java.sql.Date.class){
			Date date = (Date) obj;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			str = sdf.format(date);
			return str;
		}
//		判断是否是日期
		if(objClass == java.sql.Timestamp.class){
			Date date = (Date) obj;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			str = sdf.format(date);
			return str;
		}
		
//		判断是否是Integer
		if(objClass == Integer.class){
			str = String.valueOf(obj);
			return str;
		}
//		判断是否是String
		if(objClass == String.class){
			str = obj.toString();
			return str;
		}
		
		return str;
	}
	
}
