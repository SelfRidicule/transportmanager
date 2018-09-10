package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.GeRenGuanLi;
import com.entity.Users;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.GeRenGuanLiService;

/**
 *  个人管理 控制层
 */
public class GeRenGuanLiController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public GeRenGuanLiController() {
		super();
	}

//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	
	private GeRenGuanLiService geRenGuanLiService;
	
	
	/**
	 * 属性
	 */
	private String xincheruhu;	//新车入户
	private String zhengjianguanli;	//证件管理
	private String dangqianyundan;	//当前运单
	private String jiashiyuanshenhe;	//驾驶员审核
	private String baoxiantixing;	//保险提醒
	
	/**
	 *  修改个人管理
	 */
	public String updateGeRenGuanLi(){
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		GeRenGuanLi singlegerenguanli = (GeRenGuanLi) session.getAttribute("singlegerenguanli");
		
//		如果没有个人管理 那就创建新的对象
		if(singlegerenguanli == null){
			Users loginUser = (Users) session.getAttribute("users");
			
			singlegerenguanli = new GeRenGuanLi();
			singlegerenguanli.setId(loginUser.getUsersid());
			
			singlegerenguanli.setGeRenGuanLi( xincheruhu,  zhengjianguanli,
					 dangqianyundan,  jiashiyuanshenhe,  baoxiantixing);
			geRenGuanLiService.addGeRenGuanLi(singlegerenguanli);
		}else{
//			如果有就是修改
			singlegerenguanli.setGeRenGuanLi( xincheruhu,  zhengjianguanli,
					 dangqianyundan,  jiashiyuanshenhe,  baoxiantixing);
			geRenGuanLiService.updateGeRenGuanLi(singlegerenguanli);
		}
		
		session.setAttribute("singlegerenguanli", singlegerenguanli);
		
		return "success";
	}
	
	

	/**
	 *  get set
	 */
	public String getXincheruhu() {
		return xincheruhu;
	}

	public void setXincheruhu(String xincheruhu) {
		this.xincheruhu = xincheruhu;
	}

	public String getZhengjianguanli() {
		return zhengjianguanli;
	}

	public void setZhengjianguanli(String zhengjianguanli) {
		this.zhengjianguanli = zhengjianguanli;
	}

	public String getDangqianyundan() {
		return dangqianyundan;
	}

	public void setDangqianyundan(String dangqianyundan) {
		this.dangqianyundan = dangqianyundan;
	}

	public String getJiashiyuanshenhe() {
		return jiashiyuanshenhe;
	}

	public void setJiashiyuanshenhe(String jiashiyuanshenhe) {
		this.jiashiyuanshenhe = jiashiyuanshenhe;
	}

	public String getBaoxiantixing() {
		return baoxiantixing;
	}

	public void setBaoxiantixing(String baoxiantixing) {
		this.baoxiantixing = baoxiantixing;
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



	public GeRenGuanLiService getGeRenGuanLiService() {
		return geRenGuanLiService;
	}



	public void setGeRenGuanLiService(GeRenGuanLiService geRenGuanLiService) {
		this.geRenGuanLiService = geRenGuanLiService;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
