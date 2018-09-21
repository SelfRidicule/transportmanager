package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.CongYeZiGe;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CongYeZiGeService;

import net.sf.json.JSONArray;

/**
 *  从业资格 控制层
 */
public class CongYeZiGeController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public CongYeZiGeController() {
		super();
	}

//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	
	
	
	private CongYeZiGeService congYeZiGeService;
	
	
	
	/**
	 * 属性
	 */
	private String leibiemingcheng;	//类别名称
	
//	集合对象
	private static  List<CongYeZiGe> congyezigelist;
//	单一对象
	private  CongYeZiGe singlecongyezige;
	
	/**
	 *  发送-从业资格
	 */
	public static void sendCongYeZiGe(CongYeZiGeService congYeZiGeService){
		
		System.out.println("跳转-从业资格");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
//		设置字符格式
		FontFormat.setFontFormat(response);
//		加载applicationContext.xml文件
			
		
		
		
		List<CongYeZiGe> congyezigelist = congYeZiGeService.queryCongYeZiGeList();
		request.setAttribute("congyezigelist", congyezigelist);
		
	}
	
	/**
	 *  跳转-从业资格   
	 */
	public String jumpCongYeZiGe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-从业资格");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		
		
		congyezigelist = congYeZiGeService.queryCongYeZiGeList();
		request.setAttribute("congyezigelist", congyezigelist);
		
		return "success";
	}
	
	/**
	 *  模糊查询从业资格
	 */
	public String vagueSearchCongYeZiGe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询从业资格");

//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
		
		congyezigelist = congYeZiGeService.vagueSearchCongYeZiGe(leibiemingcheng);
		request.setAttribute("congyezigelist", congyezigelist);
		
		return "success";
	}
	
	
	/**
	 *  json
	 */
	public void congYeZiGeJson(){
		System.out.println("json");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		if(congyezigelist == null || congyezigelist.size()<1){
			return ;
		}
		
		JSONArray ja = JSONArray.fromObject(congyezigelist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  跳转-添加
	 */
	public String jumpAddCongYeZiGe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		return "success";
	}
	
	/**
	 *  添加
	 */
	public String addCongYeZiGe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加");
//		得到请求对象 

//		设置字符格式
		FontFormat.setFontFormat(response);
	
//		对象
		
		
//		添加
		CongYeZiGe congyezige = new CongYeZiGe();
		congyezige.setLeibiemingcheng(leibiemingcheng);
		congYeZiGeService.addCongYeZiGe(congyezige);
		
//		发送
		 congyezigelist = congYeZiGeService.queryCongYeZiGeList();
		request.setAttribute("congyezigelist", congyezigelist);
		
		return "success";
	}
	
	/**
	 *  删除
	 */
	public String deleteCongYeZiGe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("删除");

//		设置字符格式
		FontFormat.setFontFormat(response);
	
//		得到传递参数
		String id[] = request.getParameterValues("id");
//		判断是否有参数
		if(id == null || id.length<1){
			return "success";
		}
		
//		对象
		
		
		for (int i = 0; i < id.length; i++) {
			congYeZiGeService.deleteCongYeZiGeId(id[i]);
		}
		
//		发送
		 congyezigelist = congYeZiGeService.queryCongYeZiGeList();
		request.setAttribute("congyezigelist", congyezigelist);
		
		return "success";
	}
	
	/**
	 *  跳转-修改
	 */
	public String jumpUpdateCongYeZiGe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改");

//		设置字符格式
		FontFormat.setFontFormat(response);

//		得到传递参数
		String id[] = request.getParameterValues("id");
//		判断是否有参数
		if(id == null || id.length<1 || id.length>1){
			return "err";
		}
		
//		对象
		
		 singlecongyezige = congYeZiGeService.queryCongYeZiGeId(Integer.valueOf(id[0]));
		
		request.setAttribute("singlecongyezige", singlecongyezige);
		
		session.setAttribute("singlecongyezige", singlecongyezige);
		
		return "success";
	}
	
	/**
	 *  修改
	 */
	public String updateCongYeZiGe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
//		对象
		
		singlecongyezige = (CongYeZiGe) session.getAttribute("singlecongyezige");
				
		singlecongyezige.setLeibiemingcheng(leibiemingcheng);
		congYeZiGeService.updateCongYeZiGe(singlecongyezige);
		
//		发送
		congyezigelist = congYeZiGeService.queryCongYeZiGeList();
		request.setAttribute("congyezigelist", congyezigelist);
		
		session.removeAttribute("singlecongyezige");
		
		return "success";
	}

	
	/**
	 *  get set
	 */
	public String getLeibiemingcheng() {
		return leibiemingcheng;
	}

	public void setLeibiemingcheng(String leibiemingcheng) {
		this.leibiemingcheng = leibiemingcheng;
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

	public CongYeZiGeService getCongYeZiGeService() {
		return congYeZiGeService;
	}

	public void setCongYeZiGeService(CongYeZiGeService congYeZiGeService) {
		this.congYeZiGeService = congYeZiGeService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
