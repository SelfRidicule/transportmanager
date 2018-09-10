package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.Dept;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DeptService;
import com.service.UsersService;

import net.sf.json.JSONArray;

/**
 * 部门 控制层
 */
public class DeptController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public DeptController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

//	部门集合对象
	private static  List<Dept> deptlist;
//	单一对象
	private static Dept singledept;
	/**
	 * 属性
	 */
	private String deptname;
	private String leader;
	private String comment;
	
	
	private DeptService deptService;
	
	private UsersService usersService;
	
	/**
	 *  跳转-部门
	 */
	public String jumpDept(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		
			
		
		deptlist = deptService.queryDept();
		
		return "success";
	}
	
	/**
	 *  发送部门集合
	 */
	public static void sendDeptList(DeptService deptService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
//		设置字符格式
		FontFormat.setFontFormat(response);
	
		
		List<Dept> deptlist = deptService.queryDept();
		request.setAttribute("deptlist", deptlist);
	}
	
	/**
	 *  模糊查询部门
	 */
	public String vagueSearchDept(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("dept 模糊查询");
//		设置字符格式
		FontFormat.setFontFormat(response);
	
	
//		调用模糊查询方法		
		 deptlist = deptService.vagueSearchDept(deptname);
		
		request.setAttribute("searchdeptname", deptname);
		return "success";
	}

	/**
	 *  部门 json
	 */
	public void deptJson(){
		System.out.println("dept json");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		if(deptlist==null || deptlist.size()<1){
			return ;
		}else{
			JSONArray ja = JSONArray.fromObject(deptlist);
			System.out.println(ja);
			try {
				PrintWriter pw = response.getWriter();
				pw.print(ja);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 *  删除指定id部门
	 */
	public String deleteDept(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("删除指定id部门");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到部门id
		String deptid[] = request.getParameterValues("toolbar1");
		
		if(deptid==null || deptid.length<1 ){
			return "success";
		}
		

		
		for (int i = 0; i < deptid.length; i++) {
			if(usersService.existUsers(Integer.valueOf(deptid[i]))){
				deptService.deleteDept(Integer.valueOf(deptid[i]));
			}else{
				request.setAttribute("existuser","不可删除(该部门有关联的用户)");
				return "success";
			}
		} 
		
		
		deptlist = deptService.queryDept();
		
		return "success";
	}
	
	/**
	 *  添加部门
	 */
	public String addDept(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加部门");
//		设置字符格式
		FontFormat.setFontFormat(response);
	
//		创建部门对象
		Dept dept = new Dept(deptname, leader, comment);
//		向数据库添加部门对象
		deptService.addDept(dept);
//		得到部门业务对象
		
		deptlist = deptService.queryDept();
		
		return "success";
	}
	
	/**
	 *  修改部门
	 */
	public String updateDept(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改部门");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		String deptid[] = request.getParameterValues("toolbar1");
		
		if(deptid==null || deptid.length>1 || deptid.length<1 ){
			return "err";
		}else{
	
			  singledept = deptService.getDeptId(Integer.valueOf(deptid[0]));
			
			request.setAttribute("singledept", singledept);
			return "success";
		}
		
	}
	
	/**
	 *  提交修改部门
	 */
	public String submitUpdateDept(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("提交修改部门");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		

		
		Dept dept = singledept;
		dept.setDeptname(deptname);
		dept.setLeader(leader);
		dept.setComment(comment);
		
		deptService.updateDept(dept);
		
		deptlist = deptService.queryDept();
		
		return "success";
	}
	
	/**
	 *  get set
	 */
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

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
