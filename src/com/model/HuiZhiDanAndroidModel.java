package com.model;

/**
 *  回执单 模版类
 */
public class HuiZhiDanAndroidModel {
	/**
	 * 构造方法
	 */
	public HuiZhiDanAndroidModel() {
		super();
	}
	
	public HuiZhiDanAndroidModel(String dingdanhao, String shifadunwei,
			String shishoudunwei, String licheng, String daidianfei,
			String feiyongmiaoshu) {
		super();
		this.dingdanhao = dingdanhao;
		this.shifadunwei = shifadunwei;
		this.shishoudunwei = shishoudunwei;
		this.licheng = licheng;
		this.daidianfei = daidianfei;
		this.feiyongmiaoshu = feiyongmiaoshu;
	}

	/**
	 * 属性
	 */
	private String dingdanhao;	//订单号
	private String shifadunwei;	//实发吨位
	private String shishoudunwei;	//实收吨位
	private String licheng;	//里程
	private String daidianfei;	//代垫费
	private String feiyongmiaoshu;	//费用描述
	
	/**
	 *  赋值方法
	 */
	public void setHuiZhiDanAndroidModel(String dingdanhao, String shifadunwei,
			String shishoudunwei, String licheng, String daidianfei,
			String feiyongmiaoshu) {
		this.dingdanhao = dingdanhao;
		this.shifadunwei = shifadunwei;
		this.shishoudunwei = shishoudunwei;
		this.licheng = licheng;
		this.daidianfei = daidianfei;
		this.feiyongmiaoshu = feiyongmiaoshu;
	}
	
	/**
	 *  get set
	 */
	public String getDingdanhao() {
		return dingdanhao;
	}
	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
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
	
}
