package com.entity;

/**
 *  车辆管理实体类
 */
public class CheLiangGuanLi {
	/**
	 * 构造方法
	 */
	public CheLiangGuanLi() {
		super();
	}

	public CheLiangGuanLi(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}

	/**
	 * 属性
	 */
	private Integer id ;  //id
	private String  type;	//类型
	private String	name ;	//名称
	private String shijileixing;	//实际类型
	
	
	/**
	 *  赋值方法 
	 */
	public void setCheLiangGuanLi(String type, String name) {
		this.type = type;
		this.name = name;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getShijileixing() {
		return shijileixing;
	}

	public void setShijileixing(String shijileixing) {
		this.shijileixing = shijileixing;
	}
	
}
