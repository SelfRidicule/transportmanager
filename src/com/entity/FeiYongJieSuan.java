package com.entity;

import java.util.Date;

/**
 *  费用结算 实体类
 */
public class FeiYongJieSuan {
	/**
	 * 构造方法
	 */
	public FeiYongJieSuan() {
		super();
	}
	
	public FeiYongJieSuan(String bianhao, String chepaihao, Date banliriqi,
			String banlizhuangtai, String caozuoyuan, Date caozuoriqi) {
		super();
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	public FeiYongJieSuan(Integer jiaoqiangxian, Date jiaoqiangxianshijian,
			Integer shangyexian, Date shangyexianshijian,
			Integer guzhuhuotuanti, Date guzhuhuotuantishijian,
			Integer chengyunren, Date chengyunrenshijian, Integer shiyongshui,
			Date shiyongshuishijian, Integer gouzhishui,
			Date gouzhishuishijian, Integer zhongduananzhuang,
			Date zhongduananzhuangshijian, Integer anquanxuexi,
			Date anquanxuexishijian, Integer guanlifeiyong,
			Date guanlifeiyongshijian, Integer yujiaobaoxian,
			Date yujiaobaoxianshijian, Integer jiashiyuan,
			Date jiashiyuanshijian, Integer heji, String shoukuanren,
			String beizhu) {
		super();
		this.jiaoqiangxian = jiaoqiangxian;
		this.jiaoqiangxianshijian = jiaoqiangxianshijian;
		this.shangyexian = shangyexian;
		this.shangyexianshijian = shangyexianshijian;
		this.guzhuhuotuanti = guzhuhuotuanti;
		this.guzhuhuotuantishijian = guzhuhuotuantishijian;
		this.chengyunren = chengyunren;
		this.chengyunrenshijian = chengyunrenshijian;
		this.shiyongshui = shiyongshui;
		this.shiyongshuishijian = shiyongshuishijian;
		this.gouzhishui = gouzhishui;
		this.gouzhishuishijian = gouzhishuishijian;
		this.zhongduananzhuang = zhongduananzhuang;
		this.zhongduananzhuangshijian = zhongduananzhuangshijian;
		this.anquanxuexi = anquanxuexi;
		this.anquanxuexishijian = anquanxuexishijian;
		this.guanlifeiyong = guanlifeiyong;
		this.guanlifeiyongshijian = guanlifeiyongshijian;
		this.yujiaobaoxian = yujiaobaoxian;
		this.yujiaobaoxianshijian = yujiaobaoxianshijian;
		this.jiashiyuan = jiashiyuan;
		this.jiashiyuanshijian = jiashiyuanshijian;
		this.heji = heji;
		this.shoukuanren = shoukuanren;
		this.beizhu = beizhu;
	}
	

	/**
	 * 属性
	 */
	private Integer id ;
	private String  bianhao;
	private String  chepaihao;
	private Date    banliriqi;
	private String  banlizhuangtai;
	private String  caozuoyuan;
	private Date    caozuoriqi ;
	
	private Integer jiaoqiangxian;	//交强险
	private Date    jiaoqiangxianshijian;	//交强险时间
	private Integer shangyexian;	//	商业险
	private Date    shangyexianshijian;	//商业险时间
	private Integer guzhuhuotuanti;	//雇主或团体
	private Date    guzhuhuotuantishijian;	//雇主或团体时间
	private Integer chengyunren; 	//承运人
	private Date    chengyunrenshijian;	//承运人时间
	private Integer shiyongshui; 	//使用税
	private Date    shiyongshuishijian;	//使用税时间
	private Integer gouzhishui; 	//购置税
	private Date    gouzhishuishijian;	//购置税时间
	private Integer zhongduananzhuang; 	//终端安装
	private Date    zhongduananzhuangshijian;//终端安装时间
	private Integer anquanxuexi; 	//安全学习
	private Date    anquanxuexishijian;	//安全学习时间
	private Integer guanlifeiyong; 	//管理费用
	private Date    guanlifeiyongshijian;	//管理费用时间
	private Integer yujiaobaoxian;	//预交保险
	private Date    yujiaobaoxianshijian;	//预交保险时间
	private Integer jiashiyuan;	//驾驶员
	private Date    jiashiyuanshijian;	//驾驶员时间
	private Integer heji;	//合计
	private String  shoukuanren;	//收款人
	private String  beizhu;	//备注
	
	public void setFeiYongJieSuanCaoZuo(String bianhao, String chepaihao, Date banliriqi,
			String banlizhuangtai, String caozuoyuan, Date caozuoriqi) {
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.banlizhuangtai = banlizhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	public void setFeiYongJieSuanFuZhi(Integer jiaoqiangxian, Date jiaoqiangxianshijian,
			Integer shangyexian, Date shangyexianshijian,
			Integer guzhuhuotuanti, Date guzhuhuotuantishijian,
			Integer chengyunren, Date chengyunrenshijian, Integer shiyongshui,
			Date shiyongshuishijian, Integer gouzhishui,
			Date gouzhishuishijian, Integer zhongduananzhuang,
			Date zhongduananzhuangshijian, Integer anquanxuexi,
			Date anquanxuexishijian, Integer guanlifeiyong,
			Date guanlifeiyongshijian, Integer yujiaobaoxian,
			Date yujiaobaoxianshijian, Integer jiashiyuan,
			Date jiashiyuanshijian, Integer heji, String shoukuanren,
			String beizhu) {
		this.jiaoqiangxian = jiaoqiangxian;
		this.jiaoqiangxianshijian = jiaoqiangxianshijian;
		this.shangyexian = shangyexian;
		this.shangyexianshijian = shangyexianshijian;
		this.guzhuhuotuanti = guzhuhuotuanti;
		this.guzhuhuotuantishijian = guzhuhuotuantishijian;
		this.chengyunren = chengyunren;
		this.chengyunrenshijian = chengyunrenshijian;
		this.shiyongshui = shiyongshui;
		this.shiyongshuishijian = shiyongshuishijian;
		this.gouzhishui = gouzhishui;
		this.gouzhishuishijian = gouzhishuishijian;
		this.zhongduananzhuang = zhongduananzhuang;
		this.zhongduananzhuangshijian = zhongduananzhuangshijian;
		this.anquanxuexi = anquanxuexi;
		this.anquanxuexishijian = anquanxuexishijian;
		this.guanlifeiyong = guanlifeiyong;
		this.guanlifeiyongshijian = guanlifeiyongshijian;
		this.yujiaobaoxian = yujiaobaoxian;
		this.yujiaobaoxianshijian = yujiaobaoxianshijian;
		this.jiashiyuan = jiashiyuan;
		this.jiashiyuanshijian = jiashiyuanshijian;
		this.heji = heji;
		this.shoukuanren = shoukuanren;
		this.beizhu = beizhu;
	}
	
	public void setFeiYongJieSuanXiangGuanXinXi(String bianhao, String chepaihao, Date banliriqi,
			String banlizhuangtai, String caozuoyuan, Date caozuoriqi) {
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.banlizhuangtai = banlizhuangtai;
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
	public Date getBanliriqi() {
		return banliriqi;
	}
	public void setBanliriqi(Date banliriqi) {
		this.banliriqi = banliriqi;
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
	public Integer getJiaoqiangxian() {
		return jiaoqiangxian;
	}
	public void setJiaoqiangxian(Integer jiaoqiangxian) {
		this.jiaoqiangxian = jiaoqiangxian;
	}
	public Date getJiaoqiangxianshijian() {
		return jiaoqiangxianshijian;
	}
	public void setJiaoqiangxianshijian(Date jiaoqiangxianshijian) {
		this.jiaoqiangxianshijian = jiaoqiangxianshijian;
	}
	public Integer getShangyexian() {
		return shangyexian;
	}
	public void setShangyexian(Integer shangyexian) {
		this.shangyexian = shangyexian;
	}
	public Date getShangyexianshijian() {
		return shangyexianshijian;
	}
	public void setShangyexianshijian(Date shangyexianshijian) {
		this.shangyexianshijian = shangyexianshijian;
	}
	public Integer getGuzhuhuotuanti() {
		return guzhuhuotuanti;
	}
	public void setGuzhuhuotuanti(Integer guzhuhuotuanti) {
		this.guzhuhuotuanti = guzhuhuotuanti;
	}
	public Date getGuzhuhuotuantishijian() {
		return guzhuhuotuantishijian;
	}
	public void setGuzhuhuotuantishijian(Date guzhuhuotuantishijian) {
		this.guzhuhuotuantishijian = guzhuhuotuantishijian;
	}
	public Integer getChengyunren() {
		return chengyunren;
	}
	public void setChengyunren(Integer chengyunren) {
		this.chengyunren = chengyunren;
	}
	public Date getChengyunrenshijian() {
		return chengyunrenshijian;
	}
	public void setChengyunrenshijian(Date chengyunrenshijian) {
		this.chengyunrenshijian = chengyunrenshijian;
	}
	public Integer getShiyongshui() {
		return shiyongshui;
	}
	public void setShiyongshui(Integer shiyongshui) {
		this.shiyongshui = shiyongshui;
	}
	public Date getShiyongshuishijian() {
		return shiyongshuishijian;
	}
	public void setShiyongshuishijian(Date shiyongshuishijian) {
		this.shiyongshuishijian = shiyongshuishijian;
	}
	public Integer getGouzhishui() {
		return gouzhishui;
	}
	public void setGouzhishui(Integer gouzhishui) {
		this.gouzhishui = gouzhishui;
	}
	public Date getGouzhishuishijian() {
		return gouzhishuishijian;
	}
	public void setGouzhishuishijian(Date gouzhishuishijian) {
		this.gouzhishuishijian = gouzhishuishijian;
	}
	public Integer getZhongduananzhuang() {
		return zhongduananzhuang;
	}
	public void setZhongduananzhuang(Integer zhongduananzhuang) {
		this.zhongduananzhuang = zhongduananzhuang;
	}
	public Date getZhongduananzhuangshijian() {
		return zhongduananzhuangshijian;
	}
	public void setZhongduananzhuangshijian(Date zhongduananzhuangshijian) {
		this.zhongduananzhuangshijian = zhongduananzhuangshijian;
	}
	public Integer getAnquanxuexi() {
		return anquanxuexi;
	}
	public void setAnquanxuexi(Integer anquanxuexi) {
		this.anquanxuexi = anquanxuexi;
	}
	public Date getAnquanxuexishijian() {
		return anquanxuexishijian;
	}
	public void setAnquanxuexishijian(Date anquanxuexishijian) {
		this.anquanxuexishijian = anquanxuexishijian;
	}
	public Integer getGuanlifeiyong() {
		return guanlifeiyong;
	}
	public void setGuanlifeiyong(Integer guanlifeiyong) {
		this.guanlifeiyong = guanlifeiyong;
	}
	public Date getGuanlifeiyongshijian() {
		return guanlifeiyongshijian;
	}
	public void setGuanlifeiyongshijian(Date guanlifeiyongshijian) {
		this.guanlifeiyongshijian = guanlifeiyongshijian;
	}
	public Integer getYujiaobaoxian() {
		return yujiaobaoxian;
	}
	public void setYujiaobaoxian(Integer yujiaobaoxian) {
		this.yujiaobaoxian = yujiaobaoxian;
	}
	public Date getYujiaobaoxianshijian() {
		return yujiaobaoxianshijian;
	}
	public void setYujiaobaoxianshijian(Date yujiaobaoxianshijian) {
		this.yujiaobaoxianshijian = yujiaobaoxianshijian;
	}
	public Integer getJiashiyuan() {
		return jiashiyuan;
	}
	public void setJiashiyuan(Integer jiashiyuan) {
		this.jiashiyuan = jiashiyuan;
	}
	public Date getJiashiyuanshijian() {
		return jiashiyuanshijian;
	}
	public void setJiashiyuanshijian(Date jiashiyuanshijian) {
		this.jiashiyuanshijian = jiashiyuanshijian;
	}
	public Integer getHeji() {
		return heji;
	}
	public void setHeji(Integer heji) {
		this.heji = heji;
	}
	public String getShoukuanren() {
		return shoukuanren;
	}
	public void setShoukuanren(String shoukuanren) {
		this.shoukuanren = shoukuanren;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
}

