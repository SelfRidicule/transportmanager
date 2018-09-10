package com.entity;

import java.util.Date;

/**
 *  车辆关系
 */
public class CheLiangGuanXi {
	/**
	 * 构造方法
	 */
	public CheLiangGuanXi() {
		super();
	}

	public CheLiangGuanXi(String qianyinche, String guache, String caozuoyuan,
			Date caozuoriqi, String beizhu) {
		super();
		this.qianyinche = qianyinche;
		this.guache = guache;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.beizhu = beizhu;
	}

	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String  qianyinche;	//牵引车
	private String  guache;	//挂车
	private String  caozuoyuan;	//操作员
	private Date    caozuoriqi;	//操作日起
	private String  beizhu;	//备注
	
	/**
	 *  赋值方法
	 */
	public void setCheLiangGuanXi(String qianyinche, String guache, String caozuoyuan,
			Date caozuoriqi, String beizhu) {
		this.qianyinche = qianyinche;
		this.guache = guache;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.beizhu = beizhu;
	}
	
	/**
	 * get set 
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getCaozuoriqi() {
		return caozuoriqi;
	}

	public void setCaozuoriqi(Date caozuoriqi) {
		this.caozuoriqi = caozuoriqi;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
}
