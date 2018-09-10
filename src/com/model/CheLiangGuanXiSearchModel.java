package com.model;

/**
 *  车辆关系查询模版
 */
public class CheLiangGuanXiSearchModel {
	/**
	 * 构造方法
	 */
	public CheLiangGuanXiSearchModel() {
		super();
	}

	public CheLiangGuanXiSearchModel(String qianyinche, String guache) {
		super();
		this.qianyinche = qianyinche;
		this.guache = guache;
	}

	/**
	 * 属性
	 */
	private String qianyinche;	//牵引车
	private String guache;	//挂车
	
	/**
	 *  赋值方法 
	 */
	public void setCheLiangGuanXiSearchModel(String qianyinche, String guache) {
		this.qianyinche = qianyinche;
		this.guache = guache;
	}
	
	/**
	 *  get set
	 */
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
	
}
