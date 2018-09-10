package com.entity;

import java.util.Date;

/**
 *  新车实体类
 */
public class XinChe {
	/**
	 * 构造方法
	 */
	public XinChe() {
		super();
	}

	public XinChe(String lianxiren, String lianxidianhua, String bianhao,
			String chepaihao, String chexing, String caozuoyuan,
			Date caozuoriqi, String banlizhuangtai, String yunshuleibie,
			Date shijian) {
		super();
		this.lianxiren = lianxiren;
		this.lianxidianhua = lianxidianhua;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.chexing = chexing;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.yunshuleibie = yunshuleibie;
		this.shijian = shijian;
	}

	public XinChe(String lianxiren, String lianxidianhua, String bianhao,
			String chepaihao, String chexing, String caozuoyuan,
			Date caozuoriqi, String yunshuleibie, String zerenren) {
		super();
		this.lianxiren = lianxiren;
		this.lianxidianhua = lianxidianhua;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.chexing = chexing;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.yunshuleibie = yunshuleibie;
		this.zerenren = zerenren;
	}

	/**
	 * 属性
	 */
	private Integer id;	//id
	private String lianxiren;	//联系人
	private String lianxidianhua;	//联系电话
	private String bianhao;	//编号
	private String chepaihao;	//车牌号
	private String chexing;		//车型
	private String caozuoyuan;	//操作员
	private Date   caozuoriqi;	//操作日期
	private String banlizhuangtai; //办理状态
	private String yunshuleibie;	//运输类别
	private Date   shijian;	//时间
	private String zerenren;	//责任人
	
	private String cheliangleixing;	//
	private String pingpaixinghao;	//
	
	/**
	 *  赋值方法 
	 */
	public void setXinChe(String lianxiren, String lianxidianhua, String bianhao,
			String chepaihao, String chexing, String caozuoyuan,
			Date caozuoriqi, String banlizhuangtai, String yunshuleibie,
			Date shijian,String zerenren) {
		this.lianxiren = lianxiren;
		this.lianxidianhua = lianxidianhua;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.chexing = chexing;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.yunshuleibie = yunshuleibie;
		this.shijian = shijian;
		this.zerenren=zerenren;
	}
	
	public void setXinCheValue(String lianxiren, String lianxidianhua, String bianhao,
			String chepaihao, String chexing, String caozuoyuan,
			Date caozuoriqi, String yunshuleibie, String zerenren,Date shijian) {
		this.lianxiren = lianxiren;
		this.lianxidianhua = lianxidianhua;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.chexing = chexing;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.yunshuleibie = yunshuleibie;
		this.zerenren = zerenren;
		this.shijian = shijian;
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
	public String getChexing() {
		return chexing;
	}
	public void setChexing(String chexing) {
		this.chexing = chexing;
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
	public String getYunshuleibie() {
		return yunshuleibie;
	}
	public void setYunshuleibie(String yunshuleibie) {
		this.yunshuleibie = yunshuleibie;
	}
	public Date getShijian() {
		return shijian;
	}
	public void setShijian(Date shijian) {
		this.shijian = shijian;
	}

	public String getZerenren() {
		return zerenren;
	}

	public void setZerenren(String zerenren) {
		this.zerenren = zerenren;
	}

	public String getCheliangleixing() {
		return cheliangleixing;
	}

	public void setCheliangleixing(String cheliangleixing) {
		this.cheliangleixing = cheliangleixing;
	}

	public String getPingpaixinghao() {
		return pingpaixinghao;
	}

	public void setPingpaixinghao(String pingpaixinghao) {
		this.pingpaixinghao = pingpaixinghao;
	}

	
}
