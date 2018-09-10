package com.model;

import java.util.Date;

/**
 *  证件模糊查询模版
 */
public class ZhengJianSearchModel {
	/**
	 * 构造方法
	 */
	public ZhengJianSearchModel() {
		super();
	}
	
	public ZhengJianSearchModel(String chepaihao, String zhengjianleixing,
			String zhengjianzhuangtai, Date chaxunxiaoyudaoqiriqi,
			Date chaxundayudaoqiriqi, String caozuoyuan) {
		super();
		this.chepaihao = chepaihao;
		this.zhengjianleixing = zhengjianleixing;
		this.zhengjianzhuangtai = zhengjianzhuangtai;
		this.chaxunxiaoyudaoqiriqi = chaxunxiaoyudaoqiriqi;
		this.chaxundayudaoqiriqi = chaxundayudaoqiriqi;
		this.caozuoyuan = caozuoyuan;
	}

	/**
	 * 属性
	 */
	private String chepaihao;	//车牌号
	private String zhengjianleixing ;	//证件类型
	private String zhengjianzhuangtai;	//证件状态
	private Date   chaxunxiaoyudaoqiriqi ; //查询小于到期日期
	private Date   chaxundayudaoqiriqi;	//查询大于到期日期
	private String caozuoyuan;	//操作员
	
	/**
	 *  赋值方法
	 */
	public void setZhengJianSearchModel(String chepaihao, String zhengjianleixing,
			String zhengjianzhuangtai, Date chaxunxiaoyudaoqiriqi,
			Date chaxundayudaoqiriqi, String caozuoyuan) {
		this.chepaihao = chepaihao;
		this.zhengjianleixing = zhengjianleixing;
		this.zhengjianzhuangtai = zhengjianzhuangtai;
		this.chaxunxiaoyudaoqiriqi = chaxunxiaoyudaoqiriqi;
		this.chaxundayudaoqiriqi = chaxundayudaoqiriqi;
		this.caozuoyuan = caozuoyuan;
	}
	
	/**
	 *  get set
	 */
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getZhengjianleixing() {
		return zhengjianleixing;
	}
	public void setZhengjianleixing(String zhengjianleixing) {
		this.zhengjianleixing = zhengjianleixing;
	}
	public String getZhengjianzhuangtai() {
		return zhengjianzhuangtai;
	}
	public void setZhengjianzhuangtai(String zhengjianzhuangtai) {
		this.zhengjianzhuangtai = zhengjianzhuangtai;
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
	public String getCaozuoyuan() {
		return caozuoyuan;
	}
	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}
	
}
