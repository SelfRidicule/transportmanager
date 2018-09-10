package com.entity;

/**
 *  从业资格 实体类
 */
public class CongYeZiGe {
	/**
	 * 构造方法
	 */
	public CongYeZiGe() {
		super();
	}

	/**
	 * 属性
	 */
	private Integer id ;	// id
	private String leibiemingcheng;	//类别名称
	
	/**
	 *  get set
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeibiemingcheng() {
		return leibiemingcheng;
	}
	public void setLeibiemingcheng(String leibiemingcheng) {
		this.leibiemingcheng = leibiemingcheng;
	}
	
	
}
