package com.entity;

/**
 * 费用收取
 */
public class FeiYongShouQu {
	/**
	 * 构造方法
	 */
	public FeiYongShouQu() {
		super();
	}

	public FeiYongShouQu(String gouchefei, String luntaifei, String weixiufei,
			String jiayoufei, String qitafeiyong, String kaipiaoheji,
			String bili, String baoxianfei, String chezaihefuwufeiyong,
			String anquanxuexibaozhengjin, String guanlifeiyong,
			String yujiaobaoxianfeiyong, String jiashiyuanbaoxian, String heji) {
		super();
		this.gouchefei = gouchefei;
		this.luntaifei = luntaifei;
		this.weixiufei = weixiufei;
		this.jiayoufei = jiayoufei;
		this.qitafeiyong = qitafeiyong;
		this.kaipiaoheji = kaipiaoheji;
		this.bili = bili;
		this.baoxianfei = baoxianfei;
		this.chezaihefuwufeiyong = chezaihefuwufeiyong;
		this.anquanxuexibaozhengjin = anquanxuexibaozhengjin;
		this.guanlifeiyong = guanlifeiyong;
		this.yujiaobaoxianfeiyong = yujiaobaoxianfeiyong;
		this.jiashiyuanbaoxian = jiashiyuanbaoxian;
		this.heji = heji;
	}

	/**
	 *  property
	 */
	private Integer id ;
	private String chelianghezuoren;	//车辆合作人
	private String gouchefei;	//购车费
	private String luntaifei;	//轮胎费
	private String weixiufei;	//维修费
	private String jiayoufei;	//加油费
	private String qitafeiyong;	//其他费用
	private String kaipiaoheji;	//开票合计
	private String bili;	//比例
	private String baoxianfei;	//保险费
	private String chezaihefuwufeiyong;	//车载和服务费用
	private String anquanxuexibaozhengjin;	//安全学习保证金
	private String guanlifeiyong;	//管理费用
	private String yujiaobaoxianfeiyong;	//预交保险费用
	private String jiashiyuanbaoxian;	//驾驶员保险
	private String heji;	//合计
	
	private String ziyouyewuheji;	//自有业务合计
	
	public void setValueFeiYongShouQu(String gouchefei, String luntaifei, String weixiufei,
			String jiayoufei, String qitafeiyong, String kaipiaoheji,
			String bili, String baoxianfei, String chezaihefuwufeiyong,
			String anquanxuexibaozhengjin, String guanlifeiyong,
			String yujiaobaoxianfeiyong, String jiashiyuanbaoxian, String heji) {
		
		this.gouchefei = gouchefei;
		this.luntaifei = luntaifei;
		this.weixiufei = weixiufei;
		this.jiayoufei = jiayoufei;
		this.qitafeiyong = qitafeiyong;
		this.kaipiaoheji = kaipiaoheji;
		this.bili = bili;
		this.baoxianfei = baoxianfei;
		this.chezaihefuwufeiyong = chezaihefuwufeiyong;
		this.anquanxuexibaozhengjin = anquanxuexibaozhengjin;
		this.guanlifeiyong = guanlifeiyong;
		this.yujiaobaoxianfeiyong = yujiaobaoxianfeiyong;
		this.jiashiyuanbaoxian = jiashiyuanbaoxian;
		this.heji = heji;
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
	public String getChelianghezuoren() {
		return chelianghezuoren;
	}
	public void setChelianghezuoren(String chelianghezuoren) {
		this.chelianghezuoren = chelianghezuoren;
	}
	public String getGouchefei() {
		return gouchefei;
	}
	public void setGouchefei(String gouchefei) {
		this.gouchefei = gouchefei;
	}
	public String getLuntaifei() {
		return luntaifei;
	}
	public void setLuntaifei(String luntaifei) {
		this.luntaifei = luntaifei;
	}
	public String getWeixiufei() {
		return weixiufei;
	}
	public void setWeixiufei(String weixiufei) {
		this.weixiufei = weixiufei;
	}
	public String getJiayoufei() {
		return jiayoufei;
	}
	public void setJiayoufei(String jiayoufei) {
		this.jiayoufei = jiayoufei;
	}
	public String getQitafeiyong() {
		return qitafeiyong;
	}
	public void setQitafeiyong(String qitafeiyong) {
		this.qitafeiyong = qitafeiyong;
	}
	public String getKaipiaoheji() {
		return kaipiaoheji;
	}
	public void setKaipiaoheji(String kaipiaoheji) {
		this.kaipiaoheji = kaipiaoheji;
	}
	public String getBili() {
		return bili;
	}
	public void setBili(String bili) {
		this.bili = bili;
	}
	public String getBaoxianfei() {
		return baoxianfei;
	}
	public void setBaoxianfei(String baoxianfei) {
		this.baoxianfei = baoxianfei;
	}
	public String getChezaihefuwufeiyong() {
		return chezaihefuwufeiyong;
	}
	public void setChezaihefuwufeiyong(String chezaihefuwufeiyong) {
		this.chezaihefuwufeiyong = chezaihefuwufeiyong;
	}
	public String getAnquanxuexibaozhengjin() {
		return anquanxuexibaozhengjin;
	}
	public void setAnquanxuexibaozhengjin(String anquanxuexibaozhengjin) {
		this.anquanxuexibaozhengjin = anquanxuexibaozhengjin;
	}
	public String getGuanlifeiyong() {
		return guanlifeiyong;
	}
	public void setGuanlifeiyong(String guanlifeiyong) {
		this.guanlifeiyong = guanlifeiyong;
	}
	public String getYujiaobaoxianfeiyong() {
		return yujiaobaoxianfeiyong;
	}
	public void setYujiaobaoxianfeiyong(String yujiaobaoxianfeiyong) {
		this.yujiaobaoxianfeiyong = yujiaobaoxianfeiyong;
	}
	public String getJiashiyuanbaoxian() {
		return jiashiyuanbaoxian;
	}
	public void setJiashiyuanbaoxian(String jiashiyuanbaoxian) {
		this.jiashiyuanbaoxian = jiashiyuanbaoxian;
	}
	public String getHeji() {
		return heji;
	}
	public void setHeji(String heji) {
		this.heji = heji;
	}

	public String getZiyouyewuheji() {
		return ziyouyewuheji;
	}

	public void setZiyouyewuheji(String ziyouyewuheji) {
		this.ziyouyewuheji = ziyouyewuheji;
	}
	
	
	
}
