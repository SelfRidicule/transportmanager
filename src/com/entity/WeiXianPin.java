package com.entity;

/**
 *  危险品 实体类
 */
public class WeiXianPin {
	/**
	 * 构造方法
	 */
	public WeiXianPin() {
		super();
	}
	

	public WeiXianPin(String huowumingcheng, String anquanka,
			String anquankamingcheng, String caozuoyuan, String caozuoriqi) {
		super();
		this.huowumingcheng = huowumingcheng;
		this.anquanka = anquanka;
		this.anquankamingcheng = anquankamingcheng;
		this.caozuoyuan = caozuoyuan;
		this.caozuoriqi = caozuoriqi;
	}

	/**
	 * 属性
	 */
	private Integer id;	//id
	private String huowumingcheng;	//货物名称
	private String anquanka;	//安全卡
	private String anquankamingcheng;	//安全卡名称
	private String caozuoyuan;	//操作员
	private String caozuoriqi;	//操作日期
	
	/**
	 *  赋值方法
	 */
	public void setWeiXianPin(String huowumingcheng, String anquanka,
			String anquankamingcheng, String caozuoyuan, String caozuoriqi) {
		this.huowumingcheng = huowumingcheng;
		this.anquanka = anquanka;
		this.anquankamingcheng = anquankamingcheng;
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
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	public String getAnquanka() {
		return anquanka;
	}
	public void setAnquanka(String anquanka) {
		this.anquanka = anquanka;
	}
	public String getCaozuoyuan() {
		return caozuoyuan;
	}
	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}
	public String getCaozuoriqi() {
		return caozuoriqi;
	}
	public void setCaozuoriqi(String caozuoriqi) {
		this.caozuoriqi = caozuoriqi;
	}

	public String getAnquankamingcheng() {
		return anquankamingcheng;
	}

	public void setAnquankamingcheng(String anquankamingcheng) {
		this.anquankamingcheng = anquankamingcheng;
	}
	
	
}
