package com.entity;

/**
 *  用户类
 */
public class Users {
	/**
	 * 构造方法
	 */
	public Users() {
		super();
	}
	
	public Users(String account, String password, String username, String sex,
			String email, String quanxianmingcheng, String comment, Integer deptid) {
		super();
		this.account = account;
		this.password = password;
		this.username = username;
		this.sex = sex;
		this.email = email;
		this.quanxianmingcheng = quanxianmingcheng;
		this.comment = comment;
		this.deptid = deptid;
	}

	/**
	 * 属性
	 */
	private Integer usersid; 	//用户id
	private String account;     //帐号
	private String password;	//密码
	private String username;	//用户名
	private String sex ;		//性别
	private String email ;		//邮箱
	private String quanxianmingcheng;//权限名称	
	private String 	comment	 ;	//备注信息
	private Integer	deptid ;	//部门id
	
	
	/**
	 *  get set
	 */
	public Integer getUsersid() {
		return usersid;
	}
	public void setUsersid(Integer usersid) {
		this.usersid = usersid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}

	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}
	
	
}
