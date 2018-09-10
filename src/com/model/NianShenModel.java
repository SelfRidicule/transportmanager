package com.model;

import java.util.Date;

/**
 *  年审模版
 */
public class NianShenModel {
	/**
	 * 构造方法
	 */
	public NianShenModel() {
		super();
	}

	public NianShenModel(Integer id, String chepaihao,
			String nianshenzhuangtai, String chezhuxingming, String shoujihao,
			String nianshenriqi, String daoqiriqi, String caozuoyuan,
			String caozuoriqi) {
		super();
		this.id = id;
		this.chepaihao = chepaihao;
		this.nianshenzhuangtai = nianshenzhuangtai;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.nianshenriqi = nianshenriqi;
		this.daoqiriqi = daoqiriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String chepaihao;	//车牌号
	private String nianshenzhuangtai;	//年审状态
	private String chezhuxingming;	//车主姓名
	private String shoujihao;	//手机号
	private String nianshenriqi;	//年审日期
	private String daoqiriqi;	//到期日期
	private String caozuoyuan;	//操作员
	private String caozuoriqi;	//操作日起
	private String daoluriqi;	//道路日期
	private String erjiriqi ;	//二级日期
	private String dengjiriqi;	//等级日期
	private String guantidaoqiriqi;	//罐体到期日期
	
	/**
	 *  赋值方法
	 */
	public void setNianShenModel(Integer id, String chepaihao,
			String nianshenzhuangtai, String chezhuxingming, String shoujihao,
			String nianshenriqi, String daoqiriqi, String caozuoyuan,
			String caozuoriqi ,String daoluriqi, String erjiriqi, String dengjiriqi) {
		this.id = id;
		this.chepaihao = chepaihao;
		this.nianshenzhuangtai = nianshenzhuangtai;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.nianshenriqi = nianshenriqi;
		this.daoqiriqi = daoqiriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.daoluriqi = daoluriqi;
		this.erjiriqi = erjiriqi ;
		this.dengjiriqi = dengjiriqi;
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
	public String getNianshenzhuangtai() {
		return nianshenzhuangtai;
	}
	public void setNianshenzhuangtai(String nianshenzhuangtai) {
		this.nianshenzhuangtai = nianshenzhuangtai;
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
	public String getNianshenriqi() {
		return nianshenriqi;
	}
	public void setNianshenriqi(String nianshenriqi) {
		this.nianshenriqi = nianshenriqi;
	}
	public String getDaoqiriqi() {
		return daoqiriqi;
	}
	public void setDaoqiriqi(String daoqiriqi) {
		this.daoqiriqi = daoqiriqi;
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

	public String getDaoluriqi() {
		return daoluriqi;
	}

	public void setDaoluriqi(String daoluriqi) {
		this.daoluriqi = daoluriqi;
	}

	public String getErjiriqi() {
		return erjiriqi;
	}

	public void setErjiriqi(String erjiriqi) {
		this.erjiriqi = erjiriqi;
	}

	public String getDengjiriqi() {
		return dengjiriqi;
	}

	public void setDengjiriqi(String dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}

	public String getGuantidaoqiriqi() {
		return guantidaoqiriqi;
	}

	public void setGuantidaoqiriqi(String guantidaoqiriqi) {
		this.guantidaoqiriqi = guantidaoqiriqi;
	}
	
}
