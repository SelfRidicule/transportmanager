package com.model;

/**
 *  用户模糊查询条件保存 模型
 */
public class UsersSearchModel {
	/**
	 * 构造方法
	 */
	public UsersSearchModel() {
		super();
	}

	public UsersSearchModel(String account, String deptid, String email,
			String quanxianmingcheng) {
		super();
		this.account = account;
		this.deptid = deptid;
		this.email = email;
		this.quanxianmingcheng = quanxianmingcheng;
	}

	/**
	 * 属性
	 */
	private String account;
	private String deptid;
	private String email;
	private String quanxianmingcheng;
	
	/**
	 *  get set 
	 */
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}

	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}

	
}
