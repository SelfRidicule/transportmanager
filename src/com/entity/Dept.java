package com.entity;


/**
 *  部门类
 */
public class Dept {

	/**
	 * 构造方法
	 */
	public Dept() {
		super();
	}

	public Dept(String deptname, String leader, String comment) {
		super();
		this.deptname = deptname;
		this.leader = leader;
		this.comment = comment;
	}

	/**
	 * 属性
	 */
	private Integer deptid ;	//部门表id
	private String deptname ;	//部门名称
	private String leader ;		//部门领导
	private String comment;		//备注

	
	/**
	 * get set 
	 */
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
}
