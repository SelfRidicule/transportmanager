package com.model;

import java.util.Date;

/**
 *  车辆关系模版
 */
public class CheLiangGuanXiModel {
	/**
	 * 构造方法
	 */
	public CheLiangGuanXiModel() {
		super();
	}

	public CheLiangGuanXiModel(String id, String qianyinche, String guache,
			String caozuoyuan, String caozuoriqi, String beizhu) {
		super();
		this.id = id;
		this.qianyinche = qianyinche;
		this.guache = guache;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.beizhu = beizhu;
	}

	/**
	 * 属性
	 */
	private String id;	//id
	private String qianyinche;	//牵引车
	private String guache;	//挂车
	private String caozuoyuan;	//操作员
	private String caozuoriqi;	//操作日期
	private String beizhu;	//备注
	
	/**
	 *  赋值方法
	 */
	public void setCheLiangGuanXiModel(String id, String qianyinche, String guache,
			String caozuoyuan, String caozuoriqi, String beizhu) {
		this.id = id;
		this.qianyinche = qianyinche;
		this.guache = guache;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.beizhu = beizhu;
	}
	
	/**
	 *  get set
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQianyinche() {
		return qianyinche;
	}
	public void setQianyinche(String qianyinche) {
		this.qianyinche = qianyinche;
	}
	public String getGuache() {
		return guache;
	}
	public void setGuache(String guache) {
		this.guache = guache;
	}
	public String getCaozuoyuan() {
		return caozuoyuan;
	}
	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}
	public String getCaozuoriqi() {
		return caozuoriqi;
	}
	public void setCaozuoriqi(String caozuoriqi) {
		this.caozuoriqi = caozuoriqi;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
}
