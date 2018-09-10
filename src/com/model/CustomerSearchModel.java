package com.model;

/**
 * 客户查询 模版类
 */
public class CustomerSearchModel {
	/**
	 * 构造方法
	 */
	public CustomerSearchModel() {
		super();
	}
	
	public CustomerSearchModel(String shortname, String contactperson,
			String contactaddress) {
		super();
		this.shortname = shortname;
		this.contactperson = contactperson;
		this.contactaddress = contactaddress;
	}

	/**
	 * 属性
	 */
	private String shortname;
	private String contactperson;
	private String contactaddress;
	
	/**
	 *  get set
	 */
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getContactaddress() {
		return contactaddress;
	}
	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}
	
}
