package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.GeRenGuanLi;
import com.entity.QuanXian;
import com.entity.Users;
import com.model.UsersModel;
import com.model.UsersSearchModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DeptService;
import com.service.GeRenGuanLiService;
import com.service.QuanXianService;
import com.service.UsersService;

import net.sf.json.JSONArray;
/**
 *  用户 控制层
 */
public class UsersController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public UsersController() {
		super();
	}

	/**
	 * 请求对象
	 */
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	/**
	 * 查询的集合对象
	 */
	private static List<Users> userslist ;
	
	
	
	private  Users singleusers ;
	
	/**
	 * 属性
	 */
	private String account;
	private String username;
	private String password;
	private String sex;
	private String email;
	private String deptid;
	private String quanxianmingcheng;
	private String comment;
	
	
	private UsersService usersService;
	
	private DeptService deptService;
	
	private GeRenGuanLiService geRenGuanLiService;
	
	private QuanXianService quanXianService;
	
	/**
	 *  跳转-用户
	 */
	public String jumpUsers(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符串
		FontFormat.setFontFormat(response);
		
		
		DeptController.sendDeptList(deptService);
		 
		QuanXianController.sendQuanXianMingCheng(quanXianService);
		
		userslist = usersService.queryUsersAll();
		request.setAttribute("userslist", userslist);
		
		return "success";
	}
	
	/**
	 *  返回-用户
	 */
	public String returnUsers(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符串
		FontFormat.setFontFormat(response);

		
		DeptController.sendDeptList(deptService);
		 
		QuanXianController.sendQuanXianMingCheng(quanXianService);
		
		userslist = usersService.queryUsersAll();
		request.setAttribute("userslist", userslist);
		
		return "success";	
	}
	
	/**
	 *  模糊查询 用户
	 */
	public String usersVagueSearch(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符串
		FontFormat.setFontFormat(response);
		
		System.out.println("调用 模糊查询 vagueSearch()");
		
		account = request.getParameter("account");
		 username = request.getParameter("username");
		 password = request.getParameter("password");
		 sex = request.getParameter("sex");
		 email = request.getParameter("email");
		 deptid = request.getParameter("deptid");
		 quanxianmingcheng = request.getParameter("quanxianmingcheng");
		 comment = request.getParameter("comment");
		
		
		
		userslist = usersService.vagueUsers(deptid, account, email, quanxianmingcheng);
//		
//		创建用户查询条件模版类
		UsersSearchModel userssearchmodel = new UsersSearchModel(account, deptid, email, quanxianmingcheng);
		request.setAttribute("userssearchmodel", userssearchmodel);
		
		DeptController.sendDeptList(deptService);
		 
		QuanXianController.sendQuanXianMingCheng(quanXianService);
		
		return "success";
	
	}
	
	/**
	 *  以json格式传输用户
	 */
	public void usersJson() throws Exception{
		
		System.out.println("输出json");
		
		FontFormat.setFontFormat(response);
		
		if(userslist==null || userslist.size()<1 ){
//			userslist = us.queryUsersAll();
			return;
		}
		
		List<UsersModel> usersmodellist = UsersModel.getUsersModelList(userslist,deptService);
		
		JSONArray ja = JSONArray.fromObject(usersmodellist);
		PrintWriter pw = response.getWriter();
		pw.print(ja);
		pw.flush();
		pw.close();
		
	}

	/**
	 *  删除指定id的用户
	 */
	public String deleteUsers() throws Exception{
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("调用了deleteUsers");
		
		FontFormat.setFontFormat(response);
		
		String usersid[] =  request.getParameterValues("toolbar1");
		
		if(usersid==null || usersid.length<1){
			DeptController.sendDeptList(deptService);
			QuanXianController.sendQuanXianMingCheng(quanXianService);
			return "success"; 
		}
		
		

		
//		删除指定id的用户
		for (String id : usersid) {
			usersService.deleteUsers(Integer.valueOf(id));
			geRenGuanLiService.deleteGeRenGuanLiId(id);
		}
		
		userslist = usersService.queryUsersAll();
		
		DeptController.sendDeptList(deptService);
		 
		QuanXianController.sendQuanXianMingCheng(quanXianService);
		
		return "success";
	}

	public String jumpAddUsers(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符串
		FontFormat.setFontFormat(response);
	
		
		DeptController.sendDeptList(deptService);
		 
		QuanXianController.sendQuanXianMingCheng(quanXianService);
		
		userslist = usersService.queryUsersAll();
		request.setAttribute("userslist", userslist);
		
		return "success";
	}
	
	
	/**
	 *  添加用户
	 */
	public String addUsers(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);


		
		 account = request.getParameter("account");
		 username = request.getParameter("username");
		 password = request.getParameter("password");
		 sex = request.getParameter("sex");
		 email = request.getParameter("email");
		 deptid = request.getParameter("deptid");
		 quanxianmingcheng = request.getParameter("quanxianmingcheng");
		 comment = request.getParameter("comment");
		
		Users users = new Users(account, password, username, sex, email, quanxianmingcheng, comment, Integer.valueOf(deptid));		
		usersService.addUsers(users);
		
		Integer id = users.getUsersid();
//		添加对应用户的个人管理
		GeRenGuanLi gerenguanli = new GeRenGuanLi();
		gerenguanli.setGeRenGuanLi("1", "1", "1", "1", "1");
		gerenguanli.setId(id);
		geRenGuanLiService.addGeRenGuanLi(gerenguanli);
		
		userslist = usersService.queryUsersAll();
		
		DeptController.sendDeptList(deptService);
		 
		QuanXianController.sendQuanXianMingCheng(quanXianService);
		
		return "success";
	}
	
	/**
	 *  登录用户
	 */
	public String login(){
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		account = request.getParameter("account");
		 username = request.getParameter("username");
		 password = request.getParameter("password");
		 sex = request.getParameter("sex");
		 email = request.getParameter("email");
		 deptid = request.getParameter("deptid");
		 quanxianmingcheng = request.getParameter("quanxianmingcheng");
		 comment = request.getParameter("comment");
		

		
		Integer index = usersService.loginUsers(account, password);
		if(index>0){
			request.setAttribute("loginstate", "");
			
			Users users = usersService.getSingleUsers(account, password);
			
//			GeRenGuanLi singlegerenguanli = grgls.queryGeRenGuanLiId(users.getUsersid()); 
			
//			查询对应用户的权限
			String quanxianmingcheng = users.getQuanxianmingcheng();
			List<QuanXian> usersquanxianlist = quanXianService.queryQuanXianMingChengList(quanxianmingcheng);
			
			session.setAttribute("users", users);
			session.setAttribute("usersquanxianlist", usersquanxianlist);
			
//			session.setAttribute("singlegerenguanli", singlegerenguanli);
			
			return "success";
		}else{
			request.setAttribute("loginstate", "用户名或密码错误");
			return "err";
		}
		
	}
	
	/**
	 *  修改用户
	 */
	public String updateUsers(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("调用了updaeUsers");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到用户id
		String usersid[] =  request.getParameterValues("toolbar1");
//		判断修改用户是否正确
		if(usersid==null || usersid.length<1 || usersid.length>1){
			DeptController.sendDeptList(deptService);
			QuanXianController.sendQuanXianMingCheng(quanXianService);
			return "err"; 
		}

		
		Integer id = Integer.valueOf(usersid[0]);
//		得到指定id的用户对象
		singleusers = usersService.getSingleUsers(id);
		request.setAttribute("singleusers", singleusers);
		
		session.setAttribute("singleusers", singleusers);
		
		DeptController.sendDeptList(deptService);
		 
		QuanXianController.sendQuanXianMingCheng(quanXianService);
		
		return "success";
	}
	
	/**
	 *  提交修改后的用户
	 */
	public String submitUpdateUsers(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("调用了submitUpdaeUsers");
//		设置字符格式
		FontFormat.setFontFormat(response);

		singleusers = (Users) session.getAttribute("singleusers");
		
		 account = request.getParameter("account");
		 username = request.getParameter("username");
		 password = request.getParameter("password");
		 sex = request.getParameter("sex");
		 email = request.getParameter("email");
		 deptid = request.getParameter("deptid");
		 quanxianmingcheng = request.getParameter("quanxianmingcheng");
		 comment = request.getParameter("comment");
		
		Users users = singleusers;
		
		users.setAccount(account);
		users.setUsername(username);
		users.setPassword(password);
		users.setSex(sex);
		users.setEmail(email);
		users.setDeptid(Integer.valueOf(deptid));
		users.setQuanxianmingcheng(quanxianmingcheng);
		users.setComment(comment);
		
		usersService.updateUsers(users);
		
		userslist = usersService.queryUsersAll();
		
		DeptController.sendDeptList(deptService);
		 
		QuanXianController.sendQuanXianMingCheng(quanXianService);
		
		session.removeAttribute("singleusers");
		
		return "success";
	}
	
	/**
	 *  修改密码
	 */
	public String updatePassword(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		account = request.getParameter("account");
		 username = request.getParameter("username");
		 password = request.getParameter("password");
		 sex = request.getParameter("sex");
		 email = request.getParameter("email");
		 deptid = request.getParameter("deptid");
		 quanxianmingcheng = request.getParameter("quanxianmingcheng");
		 comment = request.getParameter("comment");
		

		
		Users users = (Users) session.getAttribute("users");
		users.setPassword(password);
		
		usersService.updateUsers(users);
		
		return "success";
	}
	
	/**
	 * 判断是否登录用户
	 */
	public static boolean existLoginUser(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		Users loginUser = (Users) session.getAttribute("users");
		if(loginUser==null || "".equals(loginUser)){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * send userslist
	 */
	public static void sendUsers(UsersService usersService) {
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		List<Users> userslist = usersService.queryUsersAll();
		request.setAttribute("userslist", userslist);
		
	}
	
	/**
	 * send userslist
	 */
	public static void sendUsersByDeptName(UsersService usersService ,String deptName) {
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		List<Users> userslist = usersService.queryUsersInDeptName(deptName);
		request.setAttribute("userslist", userslist);
		
	}
	
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public GeRenGuanLiService getGeRenGuanLiService() {
		return geRenGuanLiService;
	}

	public void setGeRenGuanLiService(GeRenGuanLiService geRenGuanLiService) {
		this.geRenGuanLiService = geRenGuanLiService;
	}

	public QuanXianService getQuanXianService() {
		return quanXianService;
	}

	public void setQuanXianService(QuanXianService quanXianService) {
		this.quanXianService = quanXianService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	
	
	
}
