package com.entity;

import java.util.Date;

/**
 *  投入审核 实体类
 */
public class TouRuShenHe {
	/**
	 * 构造方法
	 */
	public TouRuShenHe() {
		super();
	}
	

	public TouRuShenHe(String chepaihao, String bianhao, String shenhejiaodai,
			String zhongduanxinghao, Date shenpishijian, String banlizhuangtai,
			String caozuoyuan, Date caozuoriqi) {
		super();
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.shenhejiaodai = shenhejiaodai;
		this.zhongduanxinghao = zhongduanxinghao;
		this.shenpishijian = shenpishijian;
		this.banlizhuangtai = banlizhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	public TouRuShenHe(String shenhejiaodai, String zhongduanxinghao,
			Date shenpishijian, String caozuoyuan, Date caozuoriqi) {
		super();
		this.shenhejiaodai = shenhejiaodai;
		this.zhongduanxinghao = zhongduanxinghao;
		this.shenpishijian = shenpishijian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	
	public TouRuShenHe(String chepaihao, String bianhao, String banlizhuangtai,
			String caozuoyuan, Date caozuoriqi) {
		super();
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.banlizhuangtai = banlizhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String chepaihao;	//车牌号
	private String bianhao;	//编号
	private String  shenhejiaodai;	//审核交代
	private String  zhongduanxinghao;	//终端型号
	private Date    shenpishijian; 	//审批时间
	private String  zerenren;	//责任人
	private String  banlizhuangtai;	//办理状态
	private String  caozuoyuan;	//操作员
	private Date    caozuoriqi;	//操作日期
	
	/**
	 *  赋值方法
	 */
	public void setTouRuShenHe(String chepaihao, String bianhao, String shenhejiaodai,
			String zhongduanxinghao, Date shenpishijian, String banlizhuangtai,
			String caozuoyuan, Date caozuoriqi) {
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.shenhejiaodai = shenhejiaodai;
		this.zhongduanxinghao = zhongduanxinghao;
		this.shenpishijian = shenpishijian;
		this.banlizhuangtai = banlizhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}
	
	public void updateTouRuShenHe(String shenhejiaodai, String zhongduanxinghao,
			Date shenpishijian, String caozuoyuan, Date caozuoriqi) {
		this.shenhejiaodai = shenhejiaodai;
		this.zhongduanxinghao = zhongduanxinghao;
		this.shenpishijian = shenpishijian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}
	
	public void setTouRuShenHeXiangGuanXinXi(String chepaihao, String bianhao, String banlizhuangtai,
			String caozuoyuan, Date caozuoriqi ,Date shenpishijian) {
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.banlizhuangtai = banlizhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.shenpishijian = shenpishijian;
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
	public String getShenhejiaodai() {
		return shenhejiaodai;
	}
	public void setShenhejiaodai(String shenhejiaodai) {
		this.shenhejiaodai = shenhejiaodai;
	}
	public String getZhongduanxinghao() {
		return zhongduanxinghao;
	}
	public void setZhongduanxinghao(String zhongduanxinghao) {
		this.zhongduanxinghao = zhongduanxinghao;
	}
	public Date getShenpishijian() {
		return shenpishijian;
	}
	public void setShenpishijian(Date shenpishijian) {
		this.shenpishijian = shenpishijian;
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
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}


	public String getZerenren() {
		return zerenren;
	}


	public void setZerenren(String zerenren) {
		this.zerenren = zerenren;
	}
	
}
