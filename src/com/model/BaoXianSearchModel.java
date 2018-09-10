package com.model;

/**
 * 保险 json 数据模版
 */
public class BaoXianSearchModel {
	/**
	 * 构造方法
	 */
	public BaoXianSearchModel() {
		super();
	}

	/**
	 * 属性
	 */
	private String id ;
	private String chepaihao ;
	private String baoxianzhuangtai;
	private String baodanhao ;
	private String chezhuxingming ;
	private String chexing ;
	private String leixing ;
	private String toubaojine ;
	private String daoqiriqi ;
	private String baoxiangongsi;
	private String baoxianjine ;
	private String banliriqi;
	private String dailigongsi;
	
	public  void  BaoXianSearchValue(String id, String chepaihao,
			String baoxianzhuangtai, String baodanhao, String chezhuxingming,
			String chexing, String leixing, String toubaojine, String daoqiriqi,String baoxiangongsi,String baoxianjine ,String banliriqi , String dailigongsi) {
		this.id = id;
		this.chepaihao = chepaihao;
		this.baoxianzhuangtai = baoxianzhuangtai;
		this.baodanhao = baodanhao;
		this.chezhuxingming = chezhuxingming;
		this.chexing = chexing;
		this.leixing = leixing;
		this.toubaojine = toubaojine;
		this.daoqiriqi = daoqiriqi;
		this.baoxiangongsi = baoxiangongsi ;
		this.baoxianjine = baoxianjine;
		this.banliriqi = banliriqi;
		this.dailigongsi = dailigongsi ;
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
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getBaoxianzhuangtai() {
		return baoxianzhuangtai;
	}
	public void setBaoxianzhuangtai(String baoxianzhuangtai) {
		this.baoxianzhuangtai = baoxianzhuangtai;
	}
	public String getBaodanhao() {
		return baodanhao;
	}
	public void setBaodanhao(String baodanhao) {
		this.baodanhao = baodanhao;
	}
	public String getChezhuxingming() {
		return chezhuxingming;
	}
	public void setChezhuxingming(String chezhuxingming) {
		this.chezhuxingming = chezhuxingming;
	}
	public String getChexing() {
		return chexing;
	}
	public void setChexing(String chexing) {
		this.chexing = chexing;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public String getToubaojine() {
		return toubaojine;
	}
	public void setToubaojine(String toubaojine) {
		this.toubaojine = toubaojine;
	}
	public String getDaoqiriqi() {
		return daoqiriqi;
	}
	public void setDaoqiriqi(String daoqiriqi) {
		this.daoqiriqi = daoqiriqi;
	}


	public String getBaoxiangongsi() {
		return baoxiangongsi;
	}


	public void setBaoxiangongsi(String baoxiangongsi) {
		this.baoxiangongsi = baoxiangongsi;
	}


	public String getBaoxianjine() {
		return baoxianjine;
	}


	public void setBaoxianjine(String baoxianjine) {
		this.baoxianjine = baoxianjine;
	}


	public String getBanliriqi() {
		return banliriqi;
	}


	public void setBanliriqi(String banliriqi) {
		this.banliriqi = banliriqi;
	}


	public String getDailigongsi() {
		return dailigongsi;
	}


	public void setDailigongsi(String dailigongsi) {
		this.dailigongsi = dailigongsi;
	}
	
}
