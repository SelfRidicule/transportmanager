package com.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  保险类
 */
public class BaoXian {
	/**
	 * 构造方法
	 */
	public BaoXian() {
		super();
	}

	public BaoXian(String chepaihao, String baoxianleixing,
			String baoxiangongsi, Date banliriqi, Date daoqiriqi,
			String baodanhao, String baoxianzhonglei, String toubaojine,
			String lianxiren, String lianxidianhua, String baoxiandailigongsi,
			String baofei) {
		super();
		this.chepaihao = chepaihao;
		this.baoxianleixing = baoxianleixing;
		this.baoxiangongsi = baoxiangongsi;
		
		
		this.banliriqi = banliriqi;
		this.daoqiriqi = daoqiriqi;
		this.baodanhao = baodanhao;
		this.baoxianzhonglei = baoxianzhonglei;
		this.toubaojine = toubaojine;
		this.lianxiren = lianxiren;
		this.lianxidianhua = lianxidianhua;
		this.baoxiandailigongsi = baoxiandailigongsi;
		this.baofei = baofei;
	}



	/**
	 * 属性
	 */
	private Integer id ; //保险id
	private String chepaihao ; //车牌号
	private String baoxianleixing ; //保险类型
	private String baoxiangongsi ; //保险公司
	private Date   banliriqi ; //办理日期
	private Date   daoqiriqi ; //到期日期
	private String baodanhao; //保单号
	private String baoxianzhonglei; //保险种类
	private String toubaojine ; //投保金额
	private String lianxiren ; //联系人
	private String lianxidianhua;//联系电话
	private String baoxiandailigongsi; //保险代理公司
	private String baofei ; //保费
	
	/**
	 *  赋值方法
	 */
	public void setBaoXianValue(String chepaihao, String baoxianleixing,
			String baoxiangongsi, Date banliriqi, Date daoqiriqi,
			String baodanhao, String baoxianzhonglei, String toubaojine,
			String lianxiren, String lianxidianhua, String baoxiandailigongsi,
			String baofei) {
		this.chepaihao = chepaihao;
		this.baoxianleixing = baoxianleixing;
		this.baoxiangongsi = baoxiangongsi;
		this.banliriqi = banliriqi;
		this.daoqiriqi = daoqiriqi;
		this.baodanhao = baodanhao;
		this.baoxianzhonglei = baoxianzhonglei;
		this.toubaojine = toubaojine;
		this.lianxiren = lianxiren;
		this.lianxidianhua = lianxidianhua;
		this.baoxiandailigongsi = baoxiandailigongsi;
		this.baofei = baofei;
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
	public String getBaoxianleixing() {
		return baoxianleixing;
	}
	public void setBaoxianleixing(String baoxianleixing) {
		this.baoxianleixing = baoxianleixing;
	}
	public String getBaoxiangongsi() {
		return baoxiangongsi;
	}
	public void setBaoxiangongsi(String baoxiangongsi) {
		this.baoxiangongsi = baoxiangongsi;
	}
	public Date getBanliriqi() {
		return banliriqi;
	}
	public void setBanliriqi(Date banliriqi) {
		this.banliriqi = banliriqi;
	}
	public Date getDaoqiriqi() {
		return daoqiriqi;
	}
	public void setDaoqiriqi(Date daoqiriqi) {
		this.daoqiriqi = daoqiriqi;
	}
	public String getBaodanhao() {
		return baodanhao;
	}
	public void setBaodanhao(String baodanhao) {
		this.baodanhao = baodanhao;
	}
	public String getBaoxianzhonglei() {
		return baoxianzhonglei;
	}
	public void setBaoxianzhonglei(String baoxianzhonglei) {
		this.baoxianzhonglei = baoxianzhonglei;
	}
	public String getToubaojine() {
		return toubaojine;
	}
	public void setToubaojine(String toubaojine) {
		this.toubaojine = toubaojine;
	}
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	public String getBaoxiandailigongsi() {
		return baoxiandailigongsi;
	}
	public void setBaoxiandailigongsi(String baoxiandailigongsi) {
		this.baoxiandailigongsi = baoxiandailigongsi;
	}
	public String getBaofei() {
		return baofei;
	}
	public void setBaofei(String baofei) {
		this.baofei = baofei;
	}
	
}
