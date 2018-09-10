package com.entity;

import java.util.Date;

/**
 * 驾驶员实体类
 */
public class JiaShiYuan {
	/**
	 * 构造方法
	 */
	public JiaShiYuan() {
		super();
	}

	
	public JiaShiYuan(String xingbie, String jiashizhengbianhao,
			Date congyezigeriqi, String fazhengjiguan,
			Date congyezigejixujiaoyushijianzhi) {
		super();
		this.xingbie = xingbie;
		this.jiashizhengbianhao = jiashizhengbianhao;
		this.congyezigeriqi = congyezigeriqi;
		this.fazhengjiguan = fazhengjiguan;
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
	}


	public JiaShiYuan(String jiashiyuanxingming, String jiashicheliang,
			String jiashiyuanleixing, String bumen, Date chushengriqi,
			String jiguan, String shenfenzhenghao, String dianhua,
			String dizhi, String zhunjiachexing, Date chucilingzhengriqi,
			Date jiashizhengnianshenriqi, String danganbianhao,
			String congyezigezhenghao, String congyezigeleibie,
			Date congyezigejixujiaoyushijian,
			Date congyezigechengxinkaoheshijian, Date zhengjianyouxiaoriqi,
			String beizhu, String jiashiyuantupian, String jiashizhengtupian,
			String congyezigezhengtupian, String shenfenzhengtupian,
			String caozuoyuan, Date caozuoriqi, String shenhezhuangtai) {
		super();
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.jiashicheliang = jiashicheliang;
		this.jiashiyuanleixing = jiashiyuanleixing;
		this.bumen = bumen;
		this.chushengriqi = chushengriqi;
		this.jiguan = jiguan;
		this.shenfenzhenghao = shenfenzhenghao;
		this.dianhua = dianhua;
		this.dizhi = dizhi;
		this.zhunjiachexing = zhunjiachexing;
		this.chucilingzhengriqi = chucilingzhengriqi;
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
		this.danganbianhao = danganbianhao;
		this.congyezigezhenghao = congyezigezhenghao;
		this.congyezigeleibie = congyezigeleibie;
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
		this.beizhu = beizhu;
		this.jiashiyuantupian = jiashiyuantupian;
		this.jiashizhengtupian = jiashizhengtupian;
		this.congyezigezhengtupian = congyezigezhengtupian;
		this.shenfenzhengtupian = shenfenzhengtupian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.shenhezhuangtai = shenhezhuangtai;
	}
	
	

	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String jiashiyuanxingming;	//驾驶员姓名	
	private String jiashicheliang;	//驾驶车辆
	private String jiashiyuanleixing;	//驾驶员类型
	private String bumen;	//部门
	private Date chushengriqi;	//出生日期
	private String jiguan;	//籍贯
	private String shenfenzhenghao;	//身份证号
	private String dianhua;	//电话
	private String dizhi;	//地址
	private String zhunjiachexing;	//准驾车型
	private Date chucilingzhengriqi;	//初次领证日期
	private Date jiashizhengnianshenriqi;	//驾驶证年审日期
	private String danganbianhao;	//档案编号
	private String congyezigezhenghao;	//从业资格证号
	private String congyezigeleibie;	//从业资格类别
	private Date congyezigejixujiaoyushijian;	//从业资格继续教育时间
	private Date congyezigechengxinkaoheshijian;	//从业资格诚信考核时间
	private Date zhengjianyouxiaoriqi;	//证件有效日期
	private String beizhu;	//备注
	private String jiashiyuantupian;	//驾驶员图片
	private String jiashizhengtupian;	//驾驶证图片
	private String congyezigezhengtupian;	//从业资格证图片
	private String shenfenzhengtupian;	//身份证图片
	private String caozuoyuan;	//操作员
	private Date caozuoriqi;	//操作日期
	private String shenhezhuangtai;	//审核状态
	private String mima;	//密码
	
	private String xingbie;	//性别;
	private String jiashizhengbianhao;	//驾驶证档案编号
	private Date   congyezigeriqi;	//从业资格证有效期至
	private String fazhengjiguan;	//发证机关
	private Date congyezigejixujiaoyushijianzhi;	//从业资格继续教育时间止
	
	
	/**
	 *  赋值方法 
	 */
	public void setJiaShiYuan(String jiashiyuanxingming, String jiashicheliang,
			String jiashiyuanleixing, String bumen, Date chushengriqi,
			String jiguan, String shenfenzhenghao, String dianhua,
			String dizhi, String zhunjiachexing, Date chucilingzhengriqi,
			Date jiashizhengnianshenriqi, String danganbianhao,
			String congyezigezhenghao, String congyezigeleibie,
			Date congyezigejixujiaoyushijian,
			Date congyezigechengxinkaoheshijian, Date zhengjianyouxiaoriqi,
			String beizhu, String jiashiyuantupian, String jiashizhengtupian,
			String congyezigezhengtupian, String shenfenzhengtupian,
			String caozuoyuan, Date caozuoriqi, String shenhezhuangtai) {
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.jiashicheliang = jiashicheliang;
		this.jiashiyuanleixing = jiashiyuanleixing;
		this.bumen = bumen;
		this.chushengriqi = chushengriqi;
		this.jiguan = jiguan;
		this.shenfenzhenghao = shenfenzhenghao;
		this.dianhua = dianhua;
		this.dizhi = dizhi;
		this.zhunjiachexing = zhunjiachexing;
		this.chucilingzhengriqi = chucilingzhengriqi;
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
		this.danganbianhao = danganbianhao;
		this.congyezigezhenghao = congyezigezhenghao;
		this.congyezigeleibie = congyezigeleibie;
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
		this.beizhu = beizhu;
		this.jiashiyuantupian = jiashiyuantupian;
		this.jiashizhengtupian = jiashizhengtupian;
		this.congyezigezhengtupian = congyezigezhengtupian;
		this.shenfenzhengtupian = shenfenzhengtupian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.shenhezhuangtai = shenhezhuangtai;
	}
	
	public void setJiaShiYuan(String xingbie, String jiashizhengbianhao,
			Date congyezigeriqi, String fazhengjiguan,
			Date congyezigejixujiaoyushijianzhi) {
		this.xingbie = xingbie;
		this.jiashizhengbianhao = jiashizhengbianhao;
		this.congyezigeriqi = congyezigeriqi;
		this.fazhengjiguan = fazhengjiguan;
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
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
	public String getJiashiyuanxingming() {
		return jiashiyuanxingming;
	}
	public void setJiashiyuanxingming(String jiashiyuanxingming) {
		this.jiashiyuanxingming = jiashiyuanxingming;
	}
	public String getJiashicheliang() {
		return jiashicheliang;
	}
	public void setJiashicheliang(String jiashicheliang) {
		this.jiashicheliang = jiashicheliang;
	}
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public Date getChushengriqi() {
		return chushengriqi;
	}
	public void setChushengriqi(Date chushengriqi) {
		this.chushengriqi = chushengriqi;
	}
	public String getJiguan() {
		return jiguan;
	}
	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}
	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}
	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getZhunjiachexing() {
		return zhunjiachexing;
	}
	public void setZhunjiachexing(String zhunjiachexing) {
		this.zhunjiachexing = zhunjiachexing;
	}
	public Date getChucilingzhengriqi() {
		return chucilingzhengriqi;
	}
	public void setChucilingzhengriqi(Date chucilingzhengriqi) {
		this.chucilingzhengriqi = chucilingzhengriqi;
	}
	public Date getJiashizhengnianshenriqi() {
		return jiashizhengnianshenriqi;
	}
	public void setJiashizhengnianshenriqi(Date jiashizhengnianshenriqi) {
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
	}
	public String getDanganbianhao() {
		return danganbianhao;
	}
	public void setDanganbianhao(String danganbianhao) {
		this.danganbianhao = danganbianhao;
	}
	public String getCongyezigezhenghao() {
		return congyezigezhenghao;
	}
	public void setCongyezigezhenghao(String congyezigezhenghao) {
		this.congyezigezhenghao = congyezigezhenghao;
	}
	public String getCongyezigeleibie() {
		return congyezigeleibie;
	}
	public void setCongyezigeleibie(String congyezigeleibie) {
		this.congyezigeleibie = congyezigeleibie;
	}
	public Date getCongyezigejixujiaoyushijian() {
		return congyezigejixujiaoyushijian;
	}
	public void setCongyezigejixujiaoyushijian(Date congyezigejixujiaoyushijian) {
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
	}
	public Date getCongyezigechengxinkaoheshijian() {
		return congyezigechengxinkaoheshijian;
	}
	public void setCongyezigechengxinkaoheshijian(
			Date congyezigechengxinkaoheshijian) {
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
	}
	public Date getZhengjianyouxiaoriqi() {
		return zhengjianyouxiaoriqi;
	}
	public void setZhengjianyouxiaoriqi(Date zhengjianyouxiaoriqi) {
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getJiashiyuantupian() {
		return jiashiyuantupian;
	}
	public void setJiashiyuantupian(String jiashiyuantupian) {
		this.jiashiyuantupian = jiashiyuantupian;
	}
	public String getJiashizhengtupian() {
		return jiashizhengtupian;
	}
	public void setJiashizhengtupian(String jiashizhengtupian) {
		this.jiashizhengtupian = jiashizhengtupian;
	}
	public String getCongyezigezhengtupian() {
		return congyezigezhengtupian;
	}
	public void setCongyezigezhengtupian(String congyezigezhengtupian) {
		this.congyezigezhengtupian = congyezigezhengtupian;
	}
	public String getShenfenzhengtupian() {
		return shenfenzhengtupian;
	}
	public void setShenfenzhengtupian(String shenfenzhengtupian) {
		this.shenfenzhengtupian = shenfenzhengtupian;
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
	public String getShenhezhuangtai() {
		return shenhezhuangtai;
	}
	public void setShenhezhuangtai(String shenhezhuangtai) {
		this.shenhezhuangtai = shenhezhuangtai;
	}
	public String getJiashiyuanleixing() {
		return jiashiyuanleixing;
	}
	public void setJiashiyuanleixing(String jiashiyuanleixing) {
		this.jiashiyuanleixing = jiashiyuanleixing;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getJiashizhengbianhao() {
		return jiashizhengbianhao;
	}

	public void setJiashizhengbianhao(String jiashizhengbianhao) {
		this.jiashizhengbianhao = jiashizhengbianhao;
	}

	public Date getCongyezigeriqi() {
		return congyezigeriqi;
	}

	public void setCongyezigeriqi(Date congyezigeriqi) {
		this.congyezigeriqi = congyezigeriqi;
	}

	public String getFazhengjiguan() {
		return fazhengjiguan;
	}

	public void setFazhengjiguan(String fazhengjiguan) {
		this.fazhengjiguan = fazhengjiguan;
	}

	public Date getCongyezigejixujiaoyushijianzhi() {
		return congyezigejixujiaoyushijianzhi;
	}

	public void setCongyezigejixujiaoyushijianzhi(
			Date congyezigejixujiaoyushijianzhi) {
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
	}
	
}
