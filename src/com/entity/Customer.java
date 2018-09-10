package com.entity;

/**
 *  客户类 
 */
public class Customer {
	/**
	 * 构造方法
	 */
	public Customer() {
		super();
	}

	public Customer(String customername, String shortname,
			String identifynumber, String bankaccount, String account,
			String contactperson, String contactnumber, String phonenumber,
			String contactaddress, String comment) {
		super();
		this.customername = customername;
		this.shortname = shortname;
		this.identifynumber = identifynumber;
		this.bankaccount = bankaccount;
		this.account = account;
		this.contactperson = contactperson;
		this.contactnumber = contactnumber;
		this.phonenumber = phonenumber;
		this.contactaddress = contactaddress;
		this.comment = comment;
	}

	/**
	 * 属性
	 */
	private Integer customerid ; 	//客户id
	private String  customername;	//客户名称
	private String  shortname ;  	//客户简称 
	private String  identifynumber; //识别号
	private String  bankaccount ; 	//开户行
	private String  account  ;		//帐号
	private String  contactperson ; //联系人
	private String  contactnumber ;	//联系电话
	private String  phonenumber ; 	//手机号码
	private String  contactaddress; //联系地址
	private String  comment ;		//客户备注	
	private String  kehudanwei;		//客户单位
	
	/** 
	 *  向客户对象传参
	 */
	public void setCustomer(String customername, String shortname,
			String identifynumber, String bankaccount, String account,
			String contactperson, String contactnumber, String phonenumber,
			String contactaddress, String comment) {
		this.customername = customername;
		this.shortname = shortname;
		this.identifynumber = identifynumber;
		this.bankaccount = bankaccount;
		this.account = account;
		this.contactperson = contactperson;
		this.contactnumber = contactnumber;
		this.phonenumber = phonenumber;
		this.contactaddress = contactaddress;
		this.comment = comment;
	}	
	
	/**
	 *  get set
	 */
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getContactaddress() {
		return contactaddress;
	}
	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}
	
}
