package com.model;

import java.util.Date;

/**
 *  证件json 数据模版
 */
public class ZhengJianJsonModel {
	/**
	 * 构造方法
	 */
	public ZhengJianJsonModel() {
		super();
	}
	
	public ZhengJianJsonModel(String id, String zhengjianhaoma,
			String zhengjianzhuangtai, String chepaihao, String chezhuxingming,
			String shoujihao, String zhengjianleixing, String daoqiriqi,
			String caozuoyuan) {
		super();
		this.id = id;
		this.zhengjianhaoma = zhengjianhaoma;
		this.zhengjianzhuangtai = zhengjianzhuangtai;
		this.chepaihao = chepaihao;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.zhengjianleixing = zhengjianleixing;
		this.daoqiriqi = daoqiriqi;
		this.caozuoyuan = caozuoyuan;
	}

	/**
	 * 属性
	 */
	private String id ; //id
	private String zhengjianhaoma;	//证件号码
	private String zhengjianzhuangtai;	//证件状态
	private String chepaihao;	//车牌号
	private String chezhuxingming;	//车主姓名
	private String shoujihao;	//手机号
	private String zhengjianleixing;	//证件类型
	private String  daoqiriqi;	//到期日期
	private String caozuoyuan;	//操作员
	
	/**
	 *  赋值方法
	 */
	public void setZhengJianJsonModel(String id, String zhengjianhaoma,
			String zhengjianzhuangtai, String chepaihao, String chezhuxingming,
			String shoujihao, String zhengjianleixing, String daoqiriqi,
			String caozuoyuan) {
		this.id = id;
		this.zhengjianhaoma = zhengjianhaoma;
		this.zhengjianzhuangtai = zhengjianzhuangtai;
		this.chepaihao = chepaihao;
		this.chezhuxingming = chezhuxingming;
		this.shoujihao = shoujihao;
		this.zhengjianleixing = zhengjianleixing;
		this.daoqiriqi = daoqiriqi;
		this.caozuoyuan = caozuoyuan;
	}
	/**
	 *   get set
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
	public String getZhengjianzhuangtai() {
		return zhengjianzhuangtai;
	}
	public void setZhengjianzhuangtai(String zhengjianzhuangtai) {
		this.zhengjianzhuangtai = zhengjianzhuangtai;
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
	public String getZhengjianleixing() {
		return zhengjianleixing;
	}
	public void setZhengjianleixing(String zhengjianleixing) {
		this.zhengjianleixing = zhengjianleixing;
	}
	public String getZhengjianhaoma() {
		return zhengjianhaoma;
	}
	public void setZhengjianhaoma(String zhengjianhaoma) {
		this.zhengjianhaoma = zhengjianhaoma;
	}
	public String getCaozuoyuan() {
		return caozuoyuan;
	}
	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}

	public String getDaoqiriqi() {
		return daoqiriqi;
	}

	public void setDaoqiriqi(String daoqiriqi) {
		this.daoqiriqi = daoqiriqi;
	}
	
}
