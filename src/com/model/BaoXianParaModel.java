package com.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  保险模糊查询参数 模版
 */
public class BaoXianParaModel {
	/**
	 * 构造方法
	 */
	public BaoXianParaModel() {
		super();
	}



	public BaoXianParaModel(String chepaihao, String baodanhao,
			Date chaxunxiaoyudaoqiriqi, Date chaxundayudaoqiriqi) {
		super();
		this.chepaihao = chepaihao;
		this.baodanhao = baodanhao;
		this.chaxunxiaoyudaoqiriqi = chaxunxiaoyudaoqiriqi;
		this.chaxundayudaoqiriqi = chaxundayudaoqiriqi;
	}




	/**
	 * 属性
	 */
	private String chepaihao;
	private String baodanhao;
	private String baoxianzhuangtai;
	private Date   chaxunxiaoyudaoqiriqi;
	private Date   chaxundayudaoqiriqi;
	
	/**
	 *  get set
	 */
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getBaodanhao() {
		return baodanhao;
	}
	public void setBaodanhao(String baodanhao) {
		this.baodanhao = baodanhao;
	}
	public String getBaoxianzhuangtai() {
		return baoxianzhuangtai;
	}
	public void setBaoxianzhuangtai(String baoxianzhuangtai) {
		this.baoxianzhuangtai = baoxianzhuangtai;
	}

	public Date getChaxunxiaoyudaoqiriqi() {
		return chaxunxiaoyudaoqiriqi;
	}

	public void setChaxunxiaoyudaoqiriqi(Date chaxunxiaoyudaoqiriqi) {
		this.chaxunxiaoyudaoqiriqi = chaxunxiaoyudaoqiriqi;
	}

	public Date getChaxundayudaoqiriqi() {
		return chaxundayudaoqiriqi;
	}

	public void setChaxundayudaoqiriqi(Date chaxundayudaoqiriqi) {
		this.chaxundayudaoqiriqi = chaxundayudaoqiriqi;
	}

	
}
