package com.entity;

import java.util.Date;

/**
 *  运单 实体类
 */
public class YunDan {
	/**
	 * 构造方法
	 */
	public YunDan() {
		super();
	}
	
	public YunDan(String dingdanhao, String chepaihao, String kehudanwei,
			String qidian, String zhongdian, String dizhi, String lianxiren,
			String baochouleixing, String baochoujine, String huowumingcheng,
			String yujidunwei, String anquanka, Date yunshushijian,
			String caozuoyuan, Date caozuoriqi, String yundanzhuangtai) {
		super();
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.kehudanwei = kehudanwei;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.dizhi = dizhi;
		this.lianxiren = lianxiren;
		this.baochouleixing = baochouleixing;
		this.baochoujine = baochoujine;
		this.huowumingcheng = huowumingcheng;
		this.yujidunwei = yujidunwei;
		this.anquanka = anquanka;
		this.yunshushijian = yunshushijian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.yundanzhuangtai = yundanzhuangtai;
	}

	
	public YunDan(String shifadunwei, String shishoudunwei, String licheng,
			String daidianfei, String feiyongmiaoshu) {
		super();
		this.shifadunwei = shifadunwei;
		this.shishoudunwei = shishoudunwei;
		this.licheng = licheng;
		this.daidianfei = daidianfei;
		this.feiyongmiaoshu = feiyongmiaoshu;
	}



	/**
	 * 属性
	 */
	private Integer id;	//id
	private String dingdanhao;	//订单号
	private String chepaihao;	//车牌号
	private String kehudanwei;	//客户单位
	private String qidian;	//起点	
	private String zhongdian;	//终点
	private String dizhi;	//地址
	private String lianxiren;	//联系人
	private String baochouleixing;	//报酬类型
	private String baochoujine;	//报酬金额
	private String shishouyunfei;	//实收运费
	private String huowumingcheng;	//货物名称
	private String yujidunwei;	//预计吨位
	private String anquanka;	//安全卡
	private Date yunshushijian;	//运输时间
	private String caozuoyuan;	//操作员
	private Date caozuoriqi;	//操作日期
	private String yundanzhuangtai;	//运单状态
	private String beizhu;	//备注
	private String dianhua;	//电话
	
	private String shifadunwei;	//实发吨位
	private String shishoudunwei;	//实收吨位
	private String licheng;	//里程
	private String daidianfei;	//代垫费
	private String feiyongmiaoshu;	//费用描述
		
	private String yundanbeizhu; //运单备注
	private String shishouleixing;	//实收类型
	
	/**
	 *  赋值
	 */
	public void setYunDan(String dingdanhao, String chepaihao, String kehudanwei,
			String qidian, String zhongdian, String dizhi, String lianxiren,
			String baochouleixing, String baochoujine, String huowumingcheng,
			String yujidunwei, String anquanka, Date yunshushijian,
			String caozuoyuan, Date caozuoriqi, String yundanzhuangtai) {
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.kehudanwei = kehudanwei;
		this.qidian = qidian;
		this.zhongdian = zhongdian;
		this.dizhi = dizhi;
		this.lianxiren = lianxiren;
		this.baochouleixing = baochouleixing;
		this.baochoujine = baochoujine;
		this.huowumingcheng = huowumingcheng;
		this.yujidunwei = yujidunwei;
		this.anquanka = anquanka;
		this.yunshushijian = yunshushijian;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
		this.yundanzhuangtai = yundanzhuangtai;
	}
	
	/**
	 *  赋值 回执单 
	 */
	public void setYunDanHuiZhiDan(String shifadunwei, String shishoudunwei, String licheng,
			String daidianfei, String feiyongmiaoshu) {
		this.shifadunwei = shifadunwei;
		this.shishoudunwei = shishoudunwei;
		this.licheng = licheng;
		this.daidianfei = daidianfei;
		this.feiyongmiaoshu = feiyongmiaoshu;
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
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getKehudanwei() {
		return kehudanwei;
	}
	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
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
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
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
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
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
	public Date getYunshushijian() {
		return yunshushijian;
	}
	public void setYunshushijian(Date yunshushijian) {
		this.yunshushijian = yunshushijian;
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
	public String getYundanzhuangtai() {
		return yundanzhuangtai;
	}
	public void setYundanzhuangtai(String yundanzhuangtai) {
		this.yundanzhuangtai = yundanzhuangtai;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getShifadunwei() {
		return shifadunwei;
	}

	public void setShifadunwei(String shifadunwei) {
		this.shifadunwei = shifadunwei;
	}

	public String getShishoudunwei() {
		return shishoudunwei;
	}

	public void setShishoudunwei(String shishoudunwei) {
		this.shishoudunwei = shishoudunwei;
	}

	public String getLicheng() {
		return licheng;
	}

	public void setLicheng(String licheng) {
		this.licheng = licheng;
	}

	public String getDaidianfei() {
		return daidianfei;
	}

	public void setDaidianfei(String daidianfei) {
		this.daidianfei = daidianfei;
	}

	public String getFeiyongmiaoshu() {
		return feiyongmiaoshu;
	}

	public void setFeiyongmiaoshu(String feiyongmiaoshu) {
		this.feiyongmiaoshu = feiyongmiaoshu;
	}

	public String getShishouyunfei() {
		return shishouyunfei;
	}

	public void setShishouyunfei(String shishouyunfei) {
		this.shishouyunfei = shishouyunfei;
	}

	public String getYundanbeizhu() {
		return yundanbeizhu;
	}

	public void setYundanbeizhu(String yundanbeizhu) {
		this.yundanbeizhu = yundanbeizhu;
	}

	public String getShishouleixing() {
		return shishouleixing;
	}

	public void setShishouleixing(String shishouleixing) {
		this.shishouleixing = shishouleixing;
	}

	
}

