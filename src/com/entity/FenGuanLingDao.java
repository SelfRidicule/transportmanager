package com.entity;

import java.util.Date;

/**
 *  分管领导 实体类（分管领导意见）
 */
public class FenGuanLingDao {
	/**
	 * 构造方法
	 */
	public FenGuanLingDao() {
		super();
	}

	public FenGuanLingDao(String bianhao, String chepaihao, String caozuoyuan,
			Date caozuoriqi, String banlizhuangtai, Date banliriqi,
			String fenguanlingdaoyijian) {
		super();
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
		this.fenguanlingdaoyijian = fenguanlingdaoyijian;
	}
	

	public FenGuanLingDao(String caozuoyuan, Date caozuoriqi,
			String fenguanlingdaoyijian) {
		super();
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.fenguanlingdaoyijian = fenguanlingdaoyijian;
	}

	public FenGuanLingDao(String bianhao, String chepaihao, String caozuoyuan,
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
	private Integer id ;
	private String bianhao;
	private String chepaihao;
	private String caozuoyuan;
	private Date   caozuoriqi;
	private String banlizhuangtai;
	private Date   banliriqi;
	private String fenguanlingdaoyijian;
	
	/**
	 *  赋值方法  
	 */
	public void setFenGuanLingDao(String bianhao, String chepaihao, String caozuoyuan,
			Date caozuoriqi, String banlizhuangtai, Date banliriqi,
			String fenguanlingdaoyijian) {
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
		this.fenguanlingdaoyijian = fenguanlingdaoyijian;
	}
	
	public void setFenGuanLingDaoValue(String caozuoyuan, Date caozuoriqi,
			String fenguanlingdaoyijian) {
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.fenguanlingdaoyijian = fenguanlingdaoyijian;
	}
	
	public void setFenGuanLingDaoXiangGuanXinXi(String bianhao, String chepaihao, String caozuoyuan,
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
	public String getFenguanlingdaoyijian() {
		return fenguanlingdaoyijian;
	}
	public void setFenguanlingdaoyijian(String fenguanlingdaoyijian) {
		this.fenguanlingdaoyijian = fenguanlingdaoyijian;
	}
	
}
