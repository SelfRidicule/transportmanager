package com.entity;

/**
 *  个人管理 实体类
 */
public class GeRenGuanLi {
	/**
	 * 构造方法
	 */
	public GeRenGuanLi() {
		super();
	}
	
	public GeRenGuanLi(String xincheruhu, String zhengjianguanli,
			String dangqianyundan, String jiashiyuanshenhe, String baoxiantixing) {
		super();
		this.xincheruhu = xincheruhu;
		this.zhengjianguanli = zhengjianguanli;
		this.dangqianyundan = dangqianyundan;
		this.jiashiyuanshenhe = jiashiyuanshenhe;
		this.baoxiantixing = baoxiantixing;
	}

	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String xincheruhu;	//新车入户
	private String zhengjianguanli;	//证件管理
	private String dangqianyundan;	//当前运单
	private String jiashiyuanshenhe;	//驾驶员审核
	private String baoxiantixing;	//保险提醒
	
	/**
	 *  赋值方法
	 */
	public void setGeRenGuanLi(String xincheruhu, String zhengjianguanli,
			String dangqianyundan, String jiashiyuanshenhe, String baoxiantixing) {
		this.xincheruhu = xincheruhu;
		this.zhengjianguanli = zhengjianguanli;
		this.dangqianyundan = dangqianyundan;
		this.jiashiyuanshenhe = jiashiyuanshenhe;
		this.baoxiantixing = baoxiantixing;
	}
	
	/**
	 *  get set
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getXincheruhu() {
		return xincheruhu;
	}
	public void setXincheruhu(String xincheruhu) {
		this.xincheruhu = xincheruhu;
	}
	public String getZhengjianguanli() {
		return zhengjianguanli;
	}
	public void setZhengjianguanli(String zhengjianguanli) {
		this.zhengjianguanli = zhengjianguanli;
	}
	public String getDangqianyundan() {
		return dangqianyundan;
	}
	public void setDangqianyundan(String dangqianyundan) {
		this.dangqianyundan = dangqianyundan;
	}
	public String getJiashiyuanshenhe() {
		return jiashiyuanshenhe;
	}
	public void setJiashiyuanshenhe(String jiashiyuanshenhe) {
		this.jiashiyuanshenhe = jiashiyuanshenhe;
	}
	public String getBaoxiantixing() {
		return baoxiantixing;
	}
	public void setBaoxiantixing(String baoxiantixing) {
		this.baoxiantixing = baoxiantixing;
	}
	
}

