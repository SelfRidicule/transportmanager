package com.entity;

import java.util.Date;

/**
 *  材料整理 实体类 ( 材料整理、档案建立 )
 */
public class CaiLiaoZhengLi {
	/**
	 * 构造方法
	 */
	public CaiLiaoZhengLi() {
		super();
	}
	
	public CaiLiaoZhengLi(String bianhao, String chepaihao, Date banliriqi,
			String caozuoyuan, Date caozuoriqi, String banlizhuangtai,
			String yicheyidang, String yirenyidang, String fapiaojiaojie,
			String fapiaojieshouren, String dianzilujieshouren,
			String hetongqianding) {
		super();
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.yicheyidang = yicheyidang;
		this.yirenyidang = yirenyidang;
		this.fapiaojiaojie = fapiaojiaojie;
		this.fapiaojieshouren = fapiaojieshouren;
		this.dianzilujieshouren = dianzilujieshouren;
		this.hetongqianding = hetongqianding;
	}
	
	public CaiLiaoZhengLi(String caozuoyuan, Date caozuoriqi,
			String yicheyidang, String yirenyidang, String fapiaojiaojie,
			String fapiaojieshouren, String dianzilujieshouren,
			String hetongqianding) {
		super();
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.yicheyidang = yicheyidang;
		this.yirenyidang = yirenyidang;
		this.fapiaojiaojie = fapiaojiaojie;
		this.fapiaojieshouren = fapiaojieshouren;
		this.dianzilujieshouren = dianzilujieshouren;
		this.hetongqianding = hetongqianding;
	}

	public CaiLiaoZhengLi(String bianhao, String chepaihao, Date banliriqi,
			String caozuoyuan, Date caozuoriqi, String banlizhuangtai) {
		super();
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
	}

	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String  bianhao;	//编号
	private String  chepaihao;	//车牌号
	private Date    banliriqi;	//办理日期
	private String  caozuoyuan;	//操作员
	private Date    caozuoriqi;	//操作日期
	private String  banlizhuangtai;	//办理状态
	private String  yicheyidang ;	//一车一档
	private String  yirenyidang;	//一人一档
	private String  fapiaojiaojie;	//发票交接	
	private String  fapiaojieshouren;	//发票接收人
	private String  dianzilujieshouren;	//电子路接受人
	private String  hetongqianding;	// 合同签订
	
	
	
	/**
	 *  赋值方法
	 */
	public void setCaiLiaoZhengLi(String bianhao, String chepaihao, Date banliriqi,
			String caozuoyuan, Date caozuoriqi, String banlizhuangtai,
			String yicheyidang, String yirenyidang, String fapiaojiaojie,
			String fapiaojieshouren, String dianzilujieshouren,
			String hetongqianding) {
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.yicheyidang = yicheyidang;
		this.yirenyidang = yirenyidang;
		this.fapiaojiaojie = fapiaojiaojie;
		this.fapiaojieshouren = fapiaojieshouren;
		this.dianzilujieshouren = dianzilujieshouren;
		this.hetongqianding = hetongqianding;
	}
	
	public void setCaiLiaoZhengLiValue(String caozuoyuan, Date caozuoriqi,
			String yicheyidang, String yirenyidang, String fapiaojiaojie,
			String fapiaojieshouren, String dianzilujieshouren,
			String hetongqianding) {
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.yicheyidang = yicheyidang;
		this.yirenyidang = yirenyidang;
		this.fapiaojiaojie = fapiaojiaojie;
		this.fapiaojieshouren = fapiaojieshouren;
		this.dianzilujieshouren = dianzilujieshouren;
		this.hetongqianding = hetongqianding;
	}
	
	public void setCaiLiaoZhengLiXiangGuanXinXi(String bianhao, String chepaihao, Date banliriqi,
			String caozuoyuan, Date caozuoriqi, String banlizhuangtai) {
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banlizhuangtai = banlizhuangtai;
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
	public Date getBanliriqi() {
		return banliriqi;
	}
	public void setBanliriqi(Date banliriqi) {
		this.banliriqi = banliriqi;
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
	public String getYicheyidang() {
		return yicheyidang;
	}
	public void setYicheyidang(String yicheyidang) {
		this.yicheyidang = yicheyidang;
	}
	public String getYirenyidang() {
		return yirenyidang;
	}
	public void setYirenyidang(String yirenyidang) {
		this.yirenyidang = yirenyidang;
	}
	public String getFapiaojiaojie() {
		return fapiaojiaojie;
	}
	public void setFapiaojiaojie(String fapiaojiaojie) {
		this.fapiaojiaojie = fapiaojiaojie;
	}
	public String getFapiaojieshouren() {
		return fapiaojieshouren;
	}
	public void setFapiaojieshouren(String fapiaojieshouren) {
		this.fapiaojieshouren = fapiaojieshouren;
	}
	public String getDianzilujieshouren() {
		return dianzilujieshouren;
	}
	public void setDianzilujieshouren(String dianzilujieshouren) {
		this.dianzilujieshouren = dianzilujieshouren;
	}
	public String getHetongqianding() {
		return hetongqianding;
	}
	public void setHetongqianding(String hetongqianding) {
		this.hetongqianding = hetongqianding;
	}
	
}
