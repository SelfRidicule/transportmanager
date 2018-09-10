package com.myjson;

/**
 *  证件json
 */
public class ZhengJianJson {
	/**
	 * 构造方法
	 */
	public ZhengJianJson() {
		super();
	}

	public ZhengJianJson(String deletepicture, String fullpath) {
		super();
		this.deletepicture = deletepicture;
		this.fullpath = fullpath;
	}

	/**
	 * 属性
	 */
	private String deletepicture;
	private String fullpath;

	/**
	 *	证件赋值  
	 */
	public void setZhengJianJson(String deletepicture, String fullpath) {
		this.deletepicture = deletepicture;
		this.fullpath = fullpath;
	}
	
	/**
	 *  get set
	 */	

	public String getDeletepicture() {
		return deletepicture;
	}

	public void setDeletepicture(String deletepicture) {
		this.deletepicture = deletepicture;
	}

	public String getFullpath() {
		return fullpath;
	}

	public void setFullpath(String fullpath) {
		this.fullpath = fullpath;
	}
	
}
