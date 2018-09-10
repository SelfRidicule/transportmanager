package com.model;

/**
 *  车辆管理模版类
 */
public class CheLiangGuanLiModel {
	/**
	 * 构造方法
	 */
	public CheLiangGuanLiModel() {
		super();
	}

	public CheLiangGuanLiModel(String id, String type, String name) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
	}

	/**
	 * 属性
	 */
	private String id ;
	private String type;
	private String name;
	private String shijileixing;	//实际类型
	
	
	/**
	 *  赋值方法
	 */
	public void setCheLiangGuanLiModel(String id, String type, String name, String shijileixing) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.shijileixing = shijileixing;
	}
	
	/**
	 *  get set
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
