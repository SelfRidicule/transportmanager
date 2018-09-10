package com.entity;

/**
 *  权限 实体类
 */
public class QuanXian {
	/**
	 * 构造方法
	 */
	public QuanXian() {
		super();
	}
	
	

	public QuanXian(String quanxianmingcheng, String quanxianbumen) {
		super();
		this.quanxianmingcheng = quanxianmingcheng;
		this.quanxianbumen = quanxianbumen;
	}



	public QuanXian(String quanxianmingcheng, String quanxianbumen,
			String xinzeng, String weihu, String chakan) {
		super();
		this.quanxianmingcheng = quanxianmingcheng;
		this.quanxianbumen = quanxianbumen;
		this.xinzeng = xinzeng;
		this.weihu = weihu;
		this.chakan = chakan;
	}

	public QuanXian(String xinzeng, String weihu, String chakan) {
		super();
		this.xinzeng = xinzeng;
		this.weihu = weihu;
		this.chakan = chakan;
	}

	/**
	 * 属性
	 */
	private Integer id ;	//id
	private String  quanxianmingcheng;	//权限名称
	private String  quanxianbumen;	//权限部门
	private String  xinzeng;	//新增
	private String  weihu;	//维护
	private String  chakan;	//查看
	private String  chakansuoyou;	//查看所有
	
	/**
	 *  赋值方法
	 */
	public void  setQuanXian(String quanxianmingcheng, String quanxianbumen,
			String xinzeng, String weihu, String chakan) {
		this.quanxianmingcheng = quanxianmingcheng;
		this.quanxianbumen = quanxianbumen;
		this.xinzeng = xinzeng;
		this.weihu = weihu;
		this.chakan = chakan;
	}
	
	public void setQuanXian(String xinzeng, String weihu, String chakan) {
		this.xinzeng = xinzeng;
		this.weihu = weihu;
		this.chakan = chakan;
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
	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}
	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}
	public String getQuanxianbumen() {
		return quanxianbumen;
	}
	public void setQuanxianbumen(String quanxianbumen) {
		this.quanxianbumen = quanxianbumen;
	}
	public String getXinzeng() {
		return xinzeng;
	}
	public void setXinzeng(String xinzeng) {
		this.xinzeng = xinzeng;
	}
	public String getWeihu() {
		return weihu;
	}
	public void setWeihu(String weihu) {
		this.weihu = weihu;
	}
	public String getChakan() {
		return chakan;
	}
	public void setChakan(String chakan) {
		this.chakan = chakan;
	}

	public String getChakansuoyou() {
		return chakansuoyou;
	}

	public void setChakansuoyou(String chakansuoyou) {
		this.chakansuoyou = chakansuoyou;
	}
	
}
