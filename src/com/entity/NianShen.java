package com.entity;

import java.util.Date;

/**
 *  年审类
 */
public class NianShen {
	/**
	 * 构造方法
	 */
	public NianShen() {
		super();
	}

	public NianShen(String chepaihao, String chezhuxingming, String shoujihao,
			Date nianshenriqi, Date daoqiriqi, String caozuoyuan,
			Date caozuoriqi) {
		super();
		this.chepaihao = chepaihao;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.nianshenriqi = nianshenriqi;
		this.daoqiriqi = daoqiriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	
	public NianShen(Date guantidaoqiriqi, Date daoludaoqiriqi,
			Date erjidaoqiriqi, Date dengjidaoqiriqi) {
		super();
		this.guantidaoqiriqi = guantidaoqiriqi;
		this.daoludaoqiriqi = daoludaoqiriqi;
		this.erjidaoqiriqi = erjidaoqiriqi;
		this.dengjidaoqiriqi = dengjidaoqiriqi;
	}

	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String chepaihao;	//车牌号
	private String chezhuxingming;	//车主姓名
	private String shoujihao;	//手机号
	private Date nianshenriqi;	//年审日期
	private Date daoqiriqi;	//到期日期
	private String caozuoyuan;//操作员
	private Date caozuoriqi;	//操作日期
	
	private Date guantidaoqiriqi;	//罐体到期日期
	private Date daoludaoqiriqi;	//道路到期日期
	private Date erjidaoqiriqi;		//二级到期日期
	private Date dengjidaoqiriqi;	//等级到期日期
	
	/**
	 *  赋值方法
	 */
	public void  setNianShen(String chepaihao, String chezhuxingming, String shoujihao,
			Date nianshenriqi, Date daoqiriqi, String caozuoyuan,
			Date caozuoriqi) {
		this.chepaihao = chepaihao;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.nianshenriqi = nianshenriqi;
		this.daoqiriqi = daoqiriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}
	
	public void  setNianShenDate(Date guantidaoqiriqi, Date daoludaoqiriqi,
			Date erjidaoqiriqi, Date dengjidaoqiriqi) {
		this.guantidaoqiriqi = guantidaoqiriqi;
		this.daoludaoqiriqi = daoludaoqiriqi;
		this.erjidaoqiriqi = erjidaoqiriqi;
		this.dengjidaoqiriqi = dengjidaoqiriqi;
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
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getChezhuxingming() {
		return chezhuxingming;
	}
	public void setChezhuxingming(String chezhuxingming) {
		this.chezhuxingming = chezhuxingming;
	}
	public String getShoujihao() {
		return shoujihao;
	}
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	public Date getNianshenriqi() {
		return nianshenriqi;
	}
	public void setNianshenriqi(Date nianshenriqi) {
		this.nianshenriqi = nianshenriqi;
	}
	public Date getDaoqiriqi() {
		return daoqiriqi;
	}
	public void setDaoqiriqi(Date daoqiriqi) {
		this.daoqiriqi = daoqiriqi;
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

	public Date getGuantidaoqiriqi() {
		return guantidaoqiriqi;
	}

	public void setGuantidaoqiriqi(Date guantidaoqiriqi) {
		this.guantidaoqiriqi = guantidaoqiriqi;
	}

	public Date getDaoludaoqiriqi() {
		return daoludaoqiriqi;
	}

	public void setDaoludaoqiriqi(Date daoludaoqiriqi) {
		this.daoludaoqiriqi = daoludaoqiriqi;
	}

	public Date getErjidaoqiriqi() {
		return erjidaoqiriqi;
	}

	public void setErjidaoqiriqi(Date erjidaoqiriqi) {
		this.erjidaoqiriqi = erjidaoqiriqi;
	}

	public Date getDengjidaoqiriqi() {
		return dengjidaoqiriqi;
	}

	public void setDengjidaoqiriqi(Date dengjidaoqiriqi) {
		this.dengjidaoqiriqi = dengjidaoqiriqi;
	}
	
}
