package com.entity;

import java.util.Date;

/**
 *	结算单
 */
public class JieSuanDan {
	/**
	 * 构造方法
	 */
	public JieSuanDan() {
		super();
	}

	public JieSuanDan(String dingdanhao, String daikongtong, String yingshou,
			Date daozhangshijian, String fapiaohao, Date kaipiaoshijian,
			String shuijin, String guanlifei, String shifuyunfei,
			Date lingkuanshijian, String qianshou, String kehudanwei,
			Date yunshushijian, String chepaihao, String huowumingcheng,
			String shishoudunwei, String shifadunwei, String licheng,
			String baochouleixing, String baochoujine, String qidian,
			String zhongdian, String dianhua, String lianxiren,
			String yujidunwei, String anquanka, String daidianfei,
			String dizhi, String feiyongmiaoshu, String chezhuxingming) {
		super();
		this.dingdanhao = dingdanhao;
		this.daikongtong = daikongtong;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.qianshou = qianshou;
		this.kehudanwei = kehudanwei;
		this.yunshushijian = yunshushijian;
		this.chepaihao = chepaihao;
		this.huowumingcheng = huowumingcheng;
		this.shishoudunwei = shishoudunwei;
		this.shifadunwei = shifadunwei;
		this.licheng = licheng;
		this.baochouleixing = baochouleixing;
		this.baochoujine = baochoujine;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.dianhua = dianhua;
		this.lianxiren = lianxiren;
		this.yujidunwei = yujidunwei;
		this.anquanka = anquanka;
		this.daidianfei = daidianfei;
		this.dizhi = dizhi;
		this.feiyongmiaoshu = feiyongmiaoshu;
		this.chezhuxingming = chezhuxingming;
	}

	/**
	 * 属性
	 */
	private Integer  id ;	//id
	private String dingdanhao ;	//订单号
	private String daikongtong ;	//带空桶
	private String yingshou ;	//营收
	private Date  daozhangshijian ;	//到账时间		
	private String fapiaohao ;	//发票号
	private Date kaipiaoshijian ;	//开票时间
	private String shuijin ;	//税金
	private String guanlifei ;	//管理费
	private String shifuyunfei ;	//实付运费
	private Date lingkuanshijian ;	//领款时间
	private String qianshou ;	//签收
	private String kehudanwei ;	//客户单位
		
	private Date yunshushijian ;	//运输时间
	private String chepaihao ;	//车牌号
	private String huowumingcheng ;	//货物名称
	private String shishoudunwei ;	//实收吨位
	private String shifadunwei ;	//实发吨位
	private String licheng ;	//里程
	private String baochouleixing ;	//报酬类型
	private String baochoujine ;	//报酬金额
	private String qidian ;	//起点
	private String zhongdian ;	//终点
	private String dianhua ;	//电话
	private String lianxiren ;	//联系人
	private String yujidunwei ;	//预计吨位
	private String anquanka ;	//安全卡
	private String daidianfei ;	//代垫费
	private String dizhi ;	//地址
	private String feiyongmiaoshu ;	//费用描述
	
	private String chezhuxingming ;//车主姓名
	
	private String caozuoyuan;	//操作员
	private Date  caozuoriqi;	//操作日期

	/**
	 *  赋值方法
	 */
	public void setJieSuanDan(String dingdanhao, String daikongtong, String yingshou,
			Date daozhangshijian, String fapiaohao, Date kaipiaoshijian,
			String shuijin, String guanlifei, String shifuyunfei,
			Date lingkuanshijian, String qianshou, String kehudanwei,
			Date yunshushijian, String chepaihao, String huowumingcheng,
			String shishoudunwei, String shifadunwei, String licheng,
			String baochouleixing, String baochoujine, String qidian,
			String zhongdian, String dianhua, String lianxiren,
			String yujidunwei, String anquanka, String daidianfei,
			String dizhi, String feiyongmiaoshu, String chezhuxingming) {
		this.dingdanhao = dingdanhao;
		this.daikongtong = daikongtong;
		this.yingshou = yingshou;
		this.daozhangshijian = daozhangshijian;
		this.fapiaohao = fapiaohao;
		this.kaipiaoshijian = kaipiaoshijian;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.lingkuanshijian = lingkuanshijian;
		this.qianshou = qianshou;
		this.kehudanwei = kehudanwei;
		this.yunshushijian = yunshushijian;
		this.chepaihao = chepaihao;
		this.huowumingcheng = huowumingcheng;
		this.shishoudunwei = shishoudunwei;
		this.shifadunwei = shifadunwei;
		this.licheng = licheng;
		this.baochouleixing = baochouleixing;
		this.baochoujine = baochoujine;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.dianhua = dianhua;
		this.lianxiren = lianxiren;
		this.yujidunwei = yujidunwei;
		this.anquanka = anquanka;
		this.daidianfei = daidianfei;
		this.dizhi = dizhi;
		this.feiyongmiaoshu = feiyongmiaoshu;
		this.chezhuxingming = chezhuxingming;
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

	public String getDingdanhao() {
		return dingdanhao;
	}

	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}

	public String getDaikongtong() {
		return daikongtong;
	}

	public void setDaikongtong(String daikongtong) {
		this.daikongtong = daikongtong;
	}

	public String getYingshou() {
		return yingshou;
	}

	public void setYingshou(String yingshou) {
		this.yingshou = yingshou;
	}

	public Date getDaozhangshijian() {
		return daozhangshijian;
	}

	public void setDaozhangshijian(Date daozhangshijian) {
		this.daozhangshijian = daozhangshijian;
	}

	public String getFapiaohao() {
		return fapiaohao;
	}

	public void setFapiaohao(String fapiaohao) {
		this.fapiaohao = fapiaohao;
	}

	public Date getKaipiaoshijian() {
		return kaipiaoshijian;
	}

	public void setKaipiaoshijian(Date kaipiaoshijian) {
		this.kaipiaoshijian = kaipiaoshijian;
	}

	public String getShuijin() {
		return shuijin;
	}

	public void setShuijin(String shuijin) {
		this.shuijin = shuijin;
	}

	public String getGuanlifei() {
		return guanlifei;
	}

	public void setGuanlifei(String guanlifei) {
		this.guanlifei = guanlifei;
	}

	public String getShifuyunfei() {
		return shifuyunfei;
	}

	public void setShifuyunfei(String shifuyunfei) {
		this.shifuyunfei = shifuyunfei;
	}

	public Date getLingkuanshijian() {
		return lingkuanshijian;
	}

	public void setLingkuanshijian(Date lingkuanshijian) {
		this.lingkuanshijian = lingkuanshijian;
	}

	public String getQianshou() {
		return qianshou;
	}

	public void setQianshou(String qianshou) {
		this.qianshou = qianshou;
	}

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}

	public Date getYunshushijian() {
		return yunshushijian;
	}

	public void setYunshushijian(Date yunshushijian) {
		this.yunshushijian = yunshushijian;
	}

	public String getChepaihao() {
		return chepaihao;
	}

	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}

	public String getHuowumingcheng() {
		return huowumingcheng;
	}

	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}

	public String getShishoudunwei() {
		return shishoudunwei;
	}

	public void setShishoudunwei(String shishoudunwei) {
		this.shishoudunwei = shishoudunwei;
	}

	public String getShifadunwei() {
		return shifadunwei;
	}

	public void setShifadunwei(String shifadunwei) {
		this.shifadunwei = shifadunwei;
	}

	public String getLicheng() {
		return licheng;
	}

	public void setLicheng(String licheng) {
		this.licheng = licheng;
	}

	public String getBaochouleixing() {
		return baochouleixing;
	}

	public void setBaochouleixing(String baochouleixing) {
		this.baochouleixing = baochouleixing;
	}

	public String getBaochoujine() {
		return baochoujine;
	}

	public void setBaochoujine(String baochoujine) {
		this.baochoujine = baochoujine;
	}

	public String getQidian() {
		return qidian;
	}

	public void setQidian(String qidian) {
		this.qidian = qidian;
	}

	public String getZhongdian() {
		return zhongdian;
	}

	public void setZhongdian(String zhongdian) {
		this.zhongdian = zhongdian;
	}

	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getYujidunwei() {
		return yujidunwei;
	}

	public void setYujidunwei(String yujidunwei) {
		this.yujidunwei = yujidunwei;
	}

	public String getAnquanka() {
		return anquanka;
	}

	public void setAnquanka(String anquanka) {
		this.anquanka = anquanka;
	}

	public String getDaidianfei() {
		return daidianfei;
	}

	public void setDaidianfei(String daidianfei) {
		this.daidianfei = daidianfei;
	}

	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public String getFeiyongmiaoshu() {
		return feiyongmiaoshu;
	}

	public void setFeiyongmiaoshu(String feiyongmiaoshu) {
		this.feiyongmiaoshu = feiyongmiaoshu;
	}

	public String getChezhuxingming() {
		return chezhuxingming;
	}

	public void setChezhuxingming(String chezhuxingming) {
		this.chezhuxingming = chezhuxingming;
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
