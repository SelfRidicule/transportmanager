package com.entity;

import java.util.Date;

/**
 *  保险出单 实体类 (保险出单、材料扫描、电子档案建立、劳动防护用品配备)
 */
public class BaoXianChuDan {
	/**
	 * 构造方法
	 */
	public BaoXianChuDan() {
		super();
	}

	public BaoXianChuDan(String bianhao, String chepaihao,
			String banlizhuangtai, Date banliriqi, String caozuoyuan,
			Date caozuoriqi, String shangyexian, String guzhuzeren,
			String tuantixian) {
		super();
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.shangyexian = shangyexian;
		this.guzhuzeren = guzhuzeren;
		this.tuantixian = tuantixian;
	}
	
	public BaoXianChuDan(String shangyexianshouji, String guzhuzerenshouji,
			String tuantixianshouji) {
		super();
		this.shangyexianshouji = shangyexianshouji;
		this.guzhuzerenshouji = guzhuzerenshouji;
		this.tuantixianshouji = tuantixianshouji;
	}
	
	public BaoXianChuDan(String bianhao, String chepaihao,
			String banlizhuangtai, Date banliriqi, String caozuoyuan,
			Date caozuoriqi) {
		super();
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}


	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String bianhao;	//编号
	private String chepaihao;	//车牌号
	private String banlizhuangtai;	//办理状态
	private Date   banliriqi;	//办理日期
	private String caozuoyuan;	//	操作员
	private Date   caozuoriqi;	//操作日期
	private String shangyexian;	//商业险
	private String guzhuzeren;	//雇主责任
	private String tuantixian;	//团体险
	
	private String shangyexianshouji;	//商业险收集
	private String guzhuzerenshouji;	//雇主责任收集
	private String tuantixianshouji;	//团体险收集
	
	/**
	 *  赋值方法
	 */
	public void setBaoXianChuDan(String bianhao, String chepaihao,
			String banlizhuangtai, Date banliriqi, String caozuoyuan,
			Date caozuoriqi, String shangyexian, String guzhuzeren,
			String tuantixian) {
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.shangyexian = shangyexian;
		this.guzhuzeren = guzhuzeren;
		this.tuantixian = tuantixian;
	}
	
	public void setBaoXianChuDanShouJi(String shangyexianshouji, String guzhuzerenshouji,
			String tuantixianshouji) {
		this.shangyexianshouji = shangyexianshouji;
		this.guzhuzerenshouji = guzhuzerenshouji;
		this.tuantixianshouji = tuantixianshouji;
	}
	
	public void setBaoXianChuDanXiangGuanXinXi(String bianhao, String chepaihao,
			String banlizhuangtai, Date banliriqi, String caozuoyuan,
			Date caozuoriqi) {
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banlizhuangtai = banlizhuangtai;
		this.banliriqi = banliriqi;
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
	public String getBanlizhuangtai() {
		return banlizhuangtai;
	}
	public void setBanlizhuangtai(String banlizhuangtai) {
		this.banlizhuangtai = banlizhuangtai;
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
	public String getShangyexian() {
		return shangyexian;
	}
	public void setShangyexian(String shangyexian) {
		this.shangyexian = shangyexian;
	}
	public String getGuzhuzeren() {
		return guzhuzeren;
	}
	public void setGuzhuzeren(String guzhuzeren) {
		this.guzhuzeren = guzhuzeren;
	}
	public String getTuantixian() {
		return tuantixian;
	}
	public void setTuantixian(String tuantixian) {
		this.tuantixian = tuantixian;
	}

	public Date getBanliriqi() {
		return banliriqi;
	}

	public void setBanliriqi(Date banliriqi) {
		this.banliriqi = banliriqi;
	}

	public String getShangyexianshouji() {
		return shangyexianshouji;
	}

	public void setShangyexianshouji(String shangyexianshouji) {
		this.shangyexianshouji = shangyexianshouji;
	}

	public String getGuzhuzerenshouji() {
		return guzhuzerenshouji;
	}

	public void setGuzhuzerenshouji(String guzhuzerenshouji) {
		this.guzhuzerenshouji = guzhuzerenshouji;
	}

	public String getTuantixianshouji() {
		return tuantixianshouji;
	}

	public void setTuantixianshouji(String tuantixianshouji) {
		this.tuantixianshouji = tuantixianshouji;
	}
	
}
