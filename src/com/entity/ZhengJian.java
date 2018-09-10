package com.entity;

import java.util.Date;

/**
 * 证件实体类
 */
public class ZhengJian {
	/**
	 * 构造方法
	 */
	public ZhengJian() {
		super();
	}

	public ZhengJian(Integer id, String chepaihao, String zhengjianleixing,
			Date banliriqi, Date daoqiriqi, String zhengjianhaoma,
			String fujian, String caozuoyuan, Date caozuoriqi) {
		super();
		this.id = id;
		this.chepaihao = chepaihao;
		this.zhengjianleixing = zhengjianleixing;
		this.banliriqi = banliriqi;
		this.daoqiriqi = daoqiriqi;
		this.zhengjianhaoma = zhengjianhaoma;
		this.fujian = fujian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	/**
	 * 属性
	 */
	private Integer id;			//id
	private String  chepaihao;	//车牌号
	private String  zhengjianleixing;	//证件类型
	private Date  banliriqi;		//办理日期
	private Date  daoqiriqi;		//到期日期
	private String zhengjianhaoma;	//证件号码
	private String  fujian ;		//附件
	private String caozuoyuan;   	//操作员
	private Date   caozuoriqi;		//操作日期
	
	/**
	 *  赋值方法
	 */
	public void  setZhengJian( String chepaihao, String zhengjianleixing,
			Date banliriqi, Date daoqiriqi, String zhengjianhaoma,
			String fujian, String caozuoyuan, Date caozuoriqi) {
		this.chepaihao = chepaihao;
		this.zhengjianleixing = zhengjianleixing;
		this.banliriqi = banliriqi;
		this.daoqiriqi = daoqiriqi;
		this.zhengjianhaoma = zhengjianhaoma;
		this.fujian = fujian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
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
	public String getZhengjianleixing() {
		return zhengjianleixing;
	}
	public void setZhengjianleixing(String zhengjianleixing) {
		this.zhengjianleixing = zhengjianleixing;
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
	public String getZhengjianhaoma() {
		return zhengjianhaoma;
	}
	public void setZhengjianhaoma(String zhengjianhaoma) {
		this.zhengjianhaoma = zhengjianhaoma;
	}
	public String getFujian() {
		return fujian;
	}
	public void setFujian(String fujian) {
		this.fujian = fujian;
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
	
}
