package com.entity;

import java.util.Date;

/**
 *  营运证 实体类
 */
public class YingYunZheng {
	/**
	 * 构造方法
	 */
	public YingYunZheng() {
		super();
	}
	
	public YingYunZheng(String chepaihao, String bianhao,
			String banlizhuangtai, String caozuoyuan, Date caozuoriqi,
			String guantichanpin, String erweiyudengjia, String cheliangguan,
			String yayuncailiao, String chucijiance, String cheliangzhaopian,
			String ranshaoxiaohao, String chengyunren,
			String zhengchezhuangbei, String gangqiananquan, String anquanka,
			String yingyunzheng) {
		super();
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.banlizhuangtai = banlizhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.guantichanpin = guantichanpin;
		this.erweiyudengjia = erweiyudengjia;
		this.cheliangguan = cheliangguan;
		this.yayuncailiao = yayuncailiao;
		this.chucijiance = chucijiance;
		this.cheliangzhaopian = cheliangzhaopian;
		this.ranshaoxiaohao = ranshaoxiaohao;
		this.chengyunren = chengyunren;
		this.zhengchezhuangbei = zhengchezhuangbei;
		this.gangqiananquan = gangqiananquan;
		this.anquanka = anquanka;
		this.yingyunzheng = yingyunzheng;
	}

	public YingYunZheng(String guantichanpinshouji,
			String erweiyudengjiashouji, String cheliangguanshouji,
			String yayuncailiaoshouji, String chucijianceshouji,
			String cheliangzhaopianshouji, String ranshaoxiaohaoshouji,
			String chengyunrenshouji, String zhengchezhuangbeishouji,
			String gangqiananquanshouji, String anquankashouji,
			String yingyunzhengshouji) {
		super();
		this.guantichanpinshouji = guantichanpinshouji;
		this.erweiyudengjiashouji = erweiyudengjiashouji;
		this.cheliangguanshouji = cheliangguanshouji;
		this.yayuncailiaoshouji = yayuncailiaoshouji;
		this.chucijianceshouji = chucijianceshouji;
		this.cheliangzhaopianshouji = cheliangzhaopianshouji;
		this.ranshaoxiaohaoshouji = ranshaoxiaohaoshouji;
		this.chengyunrenshouji = chengyunrenshouji;
		this.zhengchezhuangbeishouji = zhengchezhuangbeishouji;
		this.gangqiananquanshouji = gangqiananquanshouji;
		this.anquankashouji = anquankashouji;
		this.yingyunzhengshouji = yingyunzhengshouji;
	}


	public YingYunZheng(String chepaihao, String bianhao,
			String banlizhuangtai, String caozuoyuan, Date caozuoriqi) {
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
	private Integer id;	//id
	private String  chepaihao;	//车牌号
	private String  bianhao;	//编号
	private String  banlizhuangtai;	//办理状态
	private String  caozuoyuan;	//操作员
	private Date    caozuoriqi;	//操作日期
	
	private String  guantichanpin;	//罐体产品质量说明书
	private String	erweiyudengjia;	//二维与等评
	private String  cheliangguan;	//车辆罐检查报告
	private String	yayuncailiao;	//押运人员材料、劳动合同
	private String  chucijiance;	//初次检测设施设备配备情况查验登记表
	private String  cheliangzhaopian;	//车辆照片
	private String  ranshaoxiaohao;	//燃料消耗达标车型核查表
	private String  chengyunren;	//承运人责任险保单
	private String  zhengchezhuangbei;	//整车装备外观检视及人工测量记录表
	private String  gangqiananquan;	//岗前安全教育培训考核
	private String  anquanka;	//安全卡
	private String  yingyunzheng;	//车辆营运证
	
	private String  guantichanpinshouji;	//罐体产品质量说明书收集
	private String	erweiyudengjiashouji;	//二维与等评收集
	private String  cheliangguanshouji;	//车辆罐检查报告收集
	private String	yayuncailiaoshouji;	//押运人员材料、劳动合同收集
	private String  chucijianceshouji;	//初次检测设施设备配备情况查验登记表收集
	private String  cheliangzhaopianshouji;	//车辆照片收集
	private String  ranshaoxiaohaoshouji;	//燃料消耗达标车型核查表收集
	private String  chengyunrenshouji;	//承运人责任险保单收集
	private String  zhengchezhuangbeishouji;	//整车装备外观检视及人工测量记录表收集
	private String  gangqiananquanshouji;	//岗前安全教育培训考核收集
	private String  anquankashouji;	//安全卡收集
	private String  yingyunzhengshouji;	//车辆营运证收集
	
	private String  zerenren;	//责任人
	
	/**
	 *  赋值方法
	 */
	public void setYingYunZheng(String chepaihao, String bianhao,
			String banlizhuangtai, String caozuoyuan, Date caozuoriqi,
			String guantichanpin, String erweiyudengjia, String cheliangguan,
			String yayuncailiao, String chucijiance, String cheliangzhaopian,
			String ranshaoxiaohao, String chengyunren,
			String zhengchezhuangbei, String gangqiananquan, String anquanka,
			String yingyunzheng) {
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
		this.banlizhuangtai = banlizhuangtai;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.guantichanpin = guantichanpin;
		this.erweiyudengjia = erweiyudengjia;
		this.cheliangguan = cheliangguan;
		this.yayuncailiao = yayuncailiao;
		this.chucijiance = chucijiance;
		this.cheliangzhaopian = cheliangzhaopian;
		this.ranshaoxiaohao = ranshaoxiaohao;
		this.chengyunren = chengyunren;
		this.zhengchezhuangbei = zhengchezhuangbei;
		this.gangqiananquan = gangqiananquan;
		this.anquanka = anquanka;
		this.yingyunzheng = yingyunzheng;
	}

	public void setYingYunZhengShouJi(String guantichanpinshouji,
			String erweiyudengjiashouji, String cheliangguanshouji,
			String yayuncailiaoshouji, String chucijianceshouji,
			String cheliangzhaopianshouji, String ranshaoxiaohaoshouji,
			String chengyunrenshouji, String zhengchezhuangbeishouji,
			String gangqiananquanshouji, String anquankashouji,
			String yingyunzhengshouji) {
		this.guantichanpinshouji = guantichanpinshouji;
		this.erweiyudengjiashouji = erweiyudengjiashouji;
		this.cheliangguanshouji = cheliangguanshouji;
		this.yayuncailiaoshouji = yayuncailiaoshouji;
		this.chucijianceshouji = chucijianceshouji;
		this.cheliangzhaopianshouji = cheliangzhaopianshouji;
		this.ranshaoxiaohaoshouji = ranshaoxiaohaoshouji;
		this.chengyunrenshouji = chengyunrenshouji;
		this.zhengchezhuangbeishouji = zhengchezhuangbeishouji;
		this.gangqiananquanshouji = gangqiananquanshouji;
		this.anquankashouji = anquankashouji;
		this.yingyunzhengshouji = yingyunzhengshouji;
	}
	
	public void setYingYunZhengXiangGuanXinXi(String chepaihao, String bianhao,
			String banlizhuangtai, String caozuoyuan, Date caozuoriqi) {
		this.chepaihao = chepaihao;
		this.bianhao = bianhao;
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
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getGuantichanpin() {
		return guantichanpin;
	}
	public void setGuantichanpin(String guantichanpin) {
		this.guantichanpin = guantichanpin;
	}
	public String getErweiyudengjia() {
		return erweiyudengjia;
	}
	public void setErweiyudengjia(String erweiyudengjia) {
		this.erweiyudengjia = erweiyudengjia;
	}
	public String getCheliangguan() {
		return cheliangguan;
	}
	public void setCheliangguan(String cheliangguan) {
		this.cheliangguan = cheliangguan;
	}
	public String getYayuncailiao() {
		return yayuncailiao;
	}
	public void setYayuncailiao(String yayuncailiao) {
		this.yayuncailiao = yayuncailiao;
	}
	public String getChucijiance() {
		return chucijiance;
	}
	public void setChucijiance(String chucijiance) {
		this.chucijiance = chucijiance;
	}
	public String getCheliangzhaopian() {
		return cheliangzhaopian;
	}
	public void setCheliangzhaopian(String cheliangzhaopian) {
		this.cheliangzhaopian = cheliangzhaopian;
	}
	public String getRanshaoxiaohao() {
		return ranshaoxiaohao;
	}
	public void setRanshaoxiaohao(String ranshaoxiaohao) {
		this.ranshaoxiaohao = ranshaoxiaohao;
	}
	public String getChengyunren() {
		return chengyunren;
	}
	public void setChengyunren(String chengyunren) {
		this.chengyunren = chengyunren;
	}
	public String getZhengchezhuangbei() {
		return zhengchezhuangbei;
	}
	public void setZhengchezhuangbei(String zhengchezhuangbei) {
		this.zhengchezhuangbei = zhengchezhuangbei;
	}
	public String getGangqiananquan() {
		return gangqiananquan;
	}
	public void setGangqiananquan(String gangqiananquan) {
		this.gangqiananquan = gangqiananquan;
	}
	public String getAnquanka() {
		return anquanka;
	}
	public void setAnquanka(String anquanka) {
		this.anquanka = anquanka;
	}
	public String getYingyunzheng() {
		return yingyunzheng;
	}
	public void setYingyunzheng(String yingyunzheng) {
		this.yingyunzheng = yingyunzheng;
	}

	public String getGuantichanpinshouji() {
		return guantichanpinshouji;
	}

	public void setGuantichanpinshouji(String guantichanpinshouji) {
		this.guantichanpinshouji = guantichanpinshouji;
	}

	public String getErweiyudengjiashouji() {
		return erweiyudengjiashouji;
	}

	public void setErweiyudengjiashouji(String erweiyudengjiashouji) {
		this.erweiyudengjiashouji = erweiyudengjiashouji;
	}

	public String getCheliangguanshouji() {
		return cheliangguanshouji;
	}

	public void setCheliangguanshouji(String cheliangguanshouji) {
		this.cheliangguanshouji = cheliangguanshouji;
	}

	public String getYayuncailiaoshouji() {
		return yayuncailiaoshouji;
	}

	public void setYayuncailiaoshouji(String yayuncailiaoshouji) {
		this.yayuncailiaoshouji = yayuncailiaoshouji;
	}

	public String getChucijianceshouji() {
		return chucijianceshouji;
	}

	public void setChucijianceshouji(String chucijianceshouji) {
		this.chucijianceshouji = chucijianceshouji;
	}

	public String getCheliangzhaopianshouji() {
		return cheliangzhaopianshouji;
	}

	public void setCheliangzhaopianshouji(String cheliangzhaopianshouji) {
		this.cheliangzhaopianshouji = cheliangzhaopianshouji;
	}

	public String getRanshaoxiaohaoshouji() {
		return ranshaoxiaohaoshouji;
	}

	public void setRanshaoxiaohaoshouji(String ranshaoxiaohaoshouji) {
		this.ranshaoxiaohaoshouji = ranshaoxiaohaoshouji;
	}

	public String getChengyunrenshouji() {
		return chengyunrenshouji;
	}

	public void setChengyunrenshouji(String chengyunrenshouji) {
		this.chengyunrenshouji = chengyunrenshouji;
	}

	public String getZhengchezhuangbeishouji() {
		return zhengchezhuangbeishouji;
	}

	public void setZhengchezhuangbeishouji(String zhengchezhuangbeishouji) {
		this.zhengchezhuangbeishouji = zhengchezhuangbeishouji;
	}

	public String getGangqiananquanshouji() {
		return gangqiananquanshouji;
	}

	public void setGangqiananquanshouji(String gangqiananquanshouji) {
		this.gangqiananquanshouji = gangqiananquanshouji;
	}

	public String getAnquankashouji() {
		return anquankashouji;
	}

	public void setAnquankashouji(String anquankashouji) {
		this.anquankashouji = anquankashouji;
	}

	public String getYingyunzhengshouji() {
		return yingyunzhengshouji;
	}

	public void setYingyunzhengshouji(String yingyunzhengshouji) {
		this.yingyunzhengshouji = yingyunzhengshouji;
	}

	public String getZerenren() {
		return zerenren;
	}

	public void setZerenren(String zerenren) {
		this.zerenren = zerenren;
	}
	
}

