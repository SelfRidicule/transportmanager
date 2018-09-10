/*package com.myutils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

*//**
 *  配置文件
 *//*
public class ConfigApplicationContext {
	*//**
	 * 构造方法
	 *//*
	public ConfigApplicationContext() {
		super();
	}

	*//**
	 * 属性
	 *//*
	private static ApplicationContext ac ;

	static{
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");	
	}
	
	*//**
	 *  得到配置文件对象
	 *//*
	public static ApplicationContext getApplicationContextObj(){
		if(ac == null){
			ac = new ClassPathXmlApplicationContext("applicationContext.xml");	
		}
		return ac;
	}
	
}
*/