package com.model;

/**
 *  
 */
public class JsonModel {
	/**
	 * 构造方法
	 */
	public JsonModel() {
		super();
	}
	
	public JsonModel(String name, String judge) {
		super();
		this.name = name;
		this.judge = judge;
	}

	/**
	 * 属性
	 */
	private String name ;
	private String judge;
	
	/**
	 * get set  
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	
}
