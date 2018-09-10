package com.entity;

import java.util.Date;

/**
 *  购置税 实体类 （2、材料收集，购置税办理，临牌办理，车辆行驶证办理）
 */
public class GouZhiShui {
	/**
	 * 构造方法
	 */
	public GouZhiShui() {
		super();
	}

	public GouZhiShui(String chepaihao, String bianhao, String caozuoyuan,
			Date caozuoriqi, Date banliriqi, String banlizhuangtai,
			String yizhixing, String hegezheng, String silianfapiao,
			String jiaoqiangxian, String linshipaizheng,
			String zhongduanxinghao, String gouzhishui, String xingshizheng,
			String dengjizheng, String anjiazheng, String pentubiaozhi) {
		super();
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banliriqi = banliriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.yizhixing = yizhixing;
		this.hegezheng = hegezheng;
		this.silianfapiao = silianfapiao;
		this.jiaoqiangxian = jiaoqiangxian;
		this.linshipaizheng = linshipaizheng;
		this.zhongduanxinghao = zhongduanxinghao;
		this.gouzhishui = gouzhishui;
		this.xingshizheng = xingshizheng;
		this.dengjizheng = dengjizheng;
		this.anjiazheng = anjiazheng;
		this.pentubiaozhi = pentubiaozhi;
	}
	
	public GouZhiShui(String yizhixingshouji, String hegezhengshouji,
			String silianfapiaoshouji, String jiaoqiangxianshouji,
			String linshipaizhengshouji, String zhongduanxinghaoshouji,
			String gouzhishuishouji, String xingshizhengshouji,
			String dengjizhengshouji, String anjiazhengshouji,
			String pentubiaozhishouji) {
		super();
		this.yizhixingshouji = yizhixingshouji;
		this.hegezhengshouji = hegezhengshouji;
		this.silianfapiaoshouji = silianfapiaoshouji;
		this.jiaoqiangxianshouji = jiaoqiangxianshouji;
		this.linshipaizhengshouji = linshipaizhengshouji;
		this.zhongduanxinghaoshouji = zhongduanxinghaoshouji;
		this.gouzhishuishouji = gouzhishuishouji;
		this.xingshizhengshouji = xingshizhengshouji;
		this.dengjizhengshouji = dengjizhengshouji;
		this.anjiazhengshouji = anjiazhengshouji;
		this.pentubiaozhishouji = pentubiaozhishouji;
	}

	public GouZhiShui(String chepaihao, String bianhao, String caozuoyuan,
			Date caozuoriqi, Date banliriqi) {
		super();
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banliriqi = banliriqi;
	}

	/**
	 * 属性
	 */
	private Integer id;	//id
	private String  chepaihao;	//车牌号
	private String  bianhao;	//编号
	private String  caozuoyuan;	//操作员
	private Date    caozuoriqi;	//操作日期
	private Date    banliriqi; 	//办理日期
	private String  banlizhuangtai;	//办理状态
	private String  yizhixing;	//一致性
	private String  hegezheng;	//合格证
	private String  silianfapiao;	//四联发票
	private String  jiaoqiangxian;	//交强险
	private String  linshipaizheng;	//临时牌证
	private String  zhongduanxinghao;	//终端型号
	private String  gouzhishui;	//购置税
	private String  xingshizheng;	//行驶证
	private String  dengjizheng;	//登记证
	private String  anjiazheng;	//安驾证
	private String  pentubiaozhi;	//喷图标志
	private String  zerenren;	//责任人
	
	private String yizhixingshouji;	//一致性收集
	private String hegezhengshouji;	//合格证收集
	private String silianfapiaoshouji;	//四联发票收集
	private String jiaoqiangxianshouji;	//交强险收集
	private String linshipaizhengshouji;	//	临时牌证收集
	private String zhongduanxinghaoshouji;	//终端型号收集
	private String gouzhishuishouji;	//购置税收集
	private String xingshizhengshouji;	//行驶证收集
	private String dengjizhengshouji;	//登记证收集
	private String anjiazhengshouji;	//安驾证收集
	private String pentubiaozhishouji;	//喷图标志收集
	
	/**
	 *  赋值方法
	 */
	public void setGouZhiShui(String chepaihao, String bianhao, String caozuoyuan,
			Date caozuoriqi, Date banliriqi, String banlizhuangtai,
			String yizhixing, String hegezheng, String silianfapiao,
			String jiaoqiangxian, String linshipaizheng,
			String zhongduanxinghao, String gouzhishui, String xingshizheng,
			String dengjizheng, String anjiazheng, String pentubiaozhi) {
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banliriqi = banliriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.yizhixing = yizhixing;
		this.hegezheng = hegezheng;
		this.silianfapiao = silianfapiao;
		this.jiaoqiangxian = jiaoqiangxian;
		this.linshipaizheng = linshipaizheng;
		this.zhongduanxinghao = zhongduanxinghao;
		this.gouzhishui = gouzhishui;
		this.xingshizheng = xingshizheng;
		this.dengjizheng = dengjizheng;
		this.anjiazheng = anjiazheng;
		this.pentubiaozhi = pentubiaozhi;
	}
	
	public void setGouZhiShuiShouJi(String yizhixingshouji, String hegezhengshouji,
			String silianfapiaoshouji, String jiaoqiangxianshouji,
			String linshipaizhengshouji, String zhongduanxinghaoshouji,
			String gouzhishuishouji, String xingshizhengshouji,
			String dengjizhengshouji, String anjiazhengshouji,
			String pentubiaozhishouji) {
		this.yizhixingshouji = yizhixingshouji;
		this.hegezhengshouji = hegezhengshouji;
		this.silianfapiaoshouji = silianfapiaoshouji;
		this.jiaoqiangxianshouji = jiaoqiangxianshouji;
		this.linshipaizhengshouji = linshipaizhengshouji;
		this.zhongduanxinghaoshouji = zhongduanxinghaoshouji;
		this.gouzhishuishouji = gouzhishuishouji;
		this.xingshizhengshouji = xingshizhengshouji;
		this.dengjizhengshouji = dengjizhengshouji;
		this.anjiazhengshouji = anjiazhengshouji;
		this.pentubiaozhishouji = pentubiaozhishouji;
	}
	
	public void setGouZhiShuiXiangGuanXinXi(String chepaihao, String bianhao, String caozuoyuan,
			Date caozuoriqi, Date banliriqi, String banlizhuangtai) {
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.banliriqi = banliriqi;
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
	public Date getBanliriqi() {
		return banliriqi;
	}
	public void setBanliriqi(Date banliriqi) {
		this.banliriqi = banliriqi;
	}
	public String getYizhixing() {
		return yizhixing;
	}
	public void setYizhixing(String yizhixing) {
		this.yizhixing = yizhixing;
	}
	public String getHegezheng() {
		return hegezheng;
	}
	public void setHegezheng(String hegezheng) {
		this.hegezheng = hegezheng;
	}
	public String getSilianfapiao() {
		return silianfapiao;
	}
	public void setSilianfapiao(String silianfapiao) {
		this.silianfapiao = silianfapiao;
	}
	public String getJiaoqiangxian() {
		return jiaoqiangxian;
	}
	public void setJiaoqiangxian(String jiaoqiangxian) {
		this.jiaoqiangxian = jiaoqiangxian;
	}
	public String getLinshipaizheng() {
		return linshipaizheng;
	}
	public void setLinshipaizheng(String linshipaizheng) {
		this.linshipaizheng = linshipaizheng;
	}
	public String getZhongduanxinghao() {
		return zhongduanxinghao;
	}
	public void setZhongduanxinghao(String zhongduanxinghao) {
		this.zhongduanxinghao = zhongduanxinghao;
	}
	public String getGouzhishui() {
		return gouzhishui;
	}
	public void setGouzhishui(String gouzhishui) {
		this.gouzhishui = gouzhishui;
	}
	public String getXingshizheng() {
		return xingshizheng;
	}
	public void setXingshizheng(String xingshizheng) {
		this.xingshizheng = xingshizheng;
	}
	public String getDengjizheng() {
		return dengjizheng;
	}
	public void setDengjizheng(String dengjizheng) {
		this.dengjizheng = dengjizheng;
	}
	public String getAnjiazheng() {
		return anjiazheng;
	}
	public void setAnjiazheng(String anjiazheng) {
		this.anjiazheng = anjiazheng;
	}
	public String getPentubiaozhi() {
		return pentubiaozhi;
	}
	public void setPentubiaozhi(String pentubiaozhi) {
		this.pentubiaozhi = pentubiaozhi;
	}

	public String getBanlizhuangtai() {
		return banlizhuangtai;
	}

	public void setBanlizhuangtai(String banlizhuangtai) {
		this.banlizhuangtai = banlizhuangtai;
	}

	public String getYizhixingshouji() {
		return yizhixingshouji;
	}

	public void setYizhixingshouji(String yizhixingshouji) {
		this.yizhixingshouji = yizhixingshouji;
	}

	public String getHegezhengshouji() {
		return hegezhengshouji;
	}

	public void setHegezhengshouji(String hegezhengshouji) {
		this.hegezhengshouji = hegezhengshouji;
	}

	public String getSilianfapiaoshouji() {
		return silianfapiaoshouji;
	}

	public void setSilianfapiaoshouji(String silianfapiaoshouji) {
		this.silianfapiaoshouji = silianfapiaoshouji;
	}

	public String getJiaoqiangxianshouji() {
		return jiaoqiangxianshouji;
	}

	public void setJiaoqiangxianshouji(String jiaoqiangxianshouji) {
		this.jiaoqiangxianshouji = jiaoqiangxianshouji;
	}

	public String getLinshipaizhengshouji() {
		return linshipaizhengshouji;
	}

	public void setLinshipaizhengshouji(String linshipaizhengshouji) {
		this.linshipaizhengshouji = linshipaizhengshouji;
	}

	public String getZhongduanxinghaoshouji() {
		return zhongduanxinghaoshouji;
	}

	public void setZhongduanxinghaoshouji(String zhongduanxinghaoshouji) {
		this.zhongduanxinghaoshouji = zhongduanxinghaoshouji;
	}

	public String getGouzhishuishouji() {
		return gouzhishuishouji;
	}

	public void setGouzhishuishouji(String gouzhishuishouji) {
		this.gouzhishuishouji = gouzhishuishouji;
	}

	public String getXingshizhengshouji() {
		return xingshizhengshouji;
	}

	public void setXingshizhengshouji(String xingshizhengshouji) {
		this.xingshizhengshouji = xingshizhengshouji;
	}

	public String getDengjizhengshouji() {
		return dengjizhengshouji;
	}

	public void setDengjizhengshouji(String dengjizhengshouji) {
		this.dengjizhengshouji = dengjizhengshouji;
	}

	public String getAnjiazhengshouji() {
		return anjiazhengshouji;
	}

	public void setAnjiazhengshouji(String anjiazhengshouji) {
		this.anjiazhengshouji = anjiazhengshouji;
	}

	public String getPentubiaozhishouji() {
		return pentubiaozhishouji;
	}

	public void setPentubiaozhishouji(String pentubiaozhishouji) {
		this.pentubiaozhishouji = pentubiaozhishouji;
	}

	public String getZerenren() {
		return zerenren;
	}

	public void setZerenren(String zerenren) {
		this.zerenren = zerenren;
	}
	
}
