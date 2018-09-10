package com.entity;

import java.util.Date;

/**
 *  责任人 实体类（责任人签字）
 */
public class ZeRenRen {
	/**
	 * 构造方法
	 */
	public ZeRenRen() {
		super();
	}

	public ZeRenRen(String bianhao, String chepaihao, String caozuoyuan,
			Date caozuoriqi, String banlizhuangtai, Date banliriqi,
			String zerenrenqianming, String zerenrenyijian) {
		super();
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
		this.zerenrenqianming = zerenrenqianming;
		this.zerenrenyijian = zerenrenyijian;
	}
	

	public ZeRenRen(String caozuoyuan, Date caozuoriqi,
			String zerenrenqianming, String zerenrenyijian) {
		super();
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.zerenrenqianming = zerenrenqianming;
		this.zerenrenyijian = zerenrenyijian;
	}
	

	public ZeRenRen(String bianhao, String chepaihao, String caozuoyuan,
			Date caozuoriqi, String banlizhuangtai, Date banliriqi) {
		super();
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
	}


	/**
	 * 属性
	 */
	private Integer id;
	private String  bianhao;
	private String  chepaihao;
	private String  caozuoyuan;
	private Date    caozuoriqi;
	private String  banlizhuangtai;
	private Date    banliriqi;
	private String  zerenrenqianming;
	private String  zerenrenyijian;
	
	/**
	 *  赋值方法
	 */
	public void setZeRenRen(String bianhao, String chepaihao, String caozuoyuan,
			Date caozuoriqi, String banlizhuangtai, Date banliriqi,
			String zerenrenqianming, String zerenrenyijian) {
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
		this.zerenrenqianming = zerenrenqianming;
		this.zerenrenyijian = zerenrenyijian;
	}
	
	public void setZeRenRenValue(String caozuoyuan, Date caozuoriqi,
			String zerenrenqianming, String zerenrenyijian) {
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.zerenrenqianming = zerenrenqianming;
		this.zerenrenyijian = zerenrenyijian;
	}
	
	public void setZeRenRenXiangGuanXinXi(String bianhao, String chepaihao, String caozuoyuan,
			Date caozuoriqi, String banlizhuangtai, Date banliriqi) {
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
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
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
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
	public String getBanlizhuangtai() {
		return banlizhuangtai;
	}
	public void setBanlizhuangtai(String banlizhuangtai) {
		this.banlizhuangtai = banlizhuangtai;
	}
	public Date getBanliriqi() {
		return banliriqi;
	}
	public void setBanliriqi(Date banliriqi) {
		this.banliriqi = banliriqi;
	}
	public String getZerenrenqianming() {
		return zerenrenqianming;
	}
	public void setZerenrenqianming(String zerenrenqianming) {
		this.zerenrenqianming = zerenrenqianming;
	}
	public String getZerenrenyijian() {
		return zerenrenyijian;
	}
	public void setZerenrenyijian(String zerenrenyijian) {
		this.zerenrenyijian = zerenrenyijian;
	}
	
}
