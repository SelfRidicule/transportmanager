package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.Dept;
import com.entity.Users;
import com.service.DeptService;

/**
 * 
 */
public class UsersModel {
	/**
	 * 构造方法
	 */
	public UsersModel() {
		super();
	}

	public UsersModel(String usersid, String account, String password,
			String username, String sex, String email, String quanxianmingcheng,
			String deptname, String comment) {
		super();
		this.usersid = usersid;
		this.account = account;
		this.password = password;
		this.username = username;
		this.sex = sex;
		this.email = email;
		this.quanxianmingcheng = quanxianmingcheng;
		this.deptname = deptname;
		this.comment = comment;
	}

	/**
	 * 创建请求对象
	 */
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session = request.getSession();
	

	
	/**
	 * 属性
	 */
	private String usersid;
	private String account;
	private String password;
	private String username;
	private String sex;
	private String email;
	private String quanxianmingcheng;
	private String deptname;
	private String comment;
	
	/**
	 *  得到用户模版集合对象
	 */
	public static List<UsersModel> getUsersModelList(List<Users> userslist,DeptService deptService){

		
		List<UsersModel> usersmodellist = new ArrayList<UsersModel>();
		
		for (int i = 0; i < userslist.size(); i++) {
			Users users = userslist.get(i);
			
			String usersid = String.valueOf(users.getUsersid());
			String account = users.getAccount();
			String username = users.getUsername();
			String password = users.getPassword();
			String sex = users.getSex();
			String email = users.getEmail();
			String quanxianmingcheng = users.getQuanxianmingcheng();
			
			Integer deptid = users.getDeptid();
			Dept dept = deptService.getDeptId(deptid);
			String deptname = "";
			if(dept != null){
				deptname = dept.getDeptname();
			}
			
			String comment = users.getComment();
			
			UsersModel usersmodel = new UsersModel();
			usersmodel.setUsersModel( usersid,  account,  password,
					 username,  sex,  email,  quanxianmingcheng,
					 deptname,  comment);
			usersmodellist.add(usersmodel);
		}
		
		
		return usersmodellist;
	}
	
	
	/**
	 *  赋值方法
	 */
	public void setUsersModel(String usersid, String account, String password,
			String username, String sex, String email, String quanxianmingcheng,
			String deptname, String comment) {
		this.usersid = usersid;
		this.account = account;
		this.password = password;
		this.username = username;
		this.sex = sex;
		this.email = email;
		this.quanxianmingcheng = quanxianmingcheng;
		this.deptname = deptname;
		this.comment = comment;
	}
	
	/**
	 *  get set
	 */
	
	public String getAccount() {
		return account;
	}
	public String getUsersid() {
		return usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
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
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}

	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}
	
}
