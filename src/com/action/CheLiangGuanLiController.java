package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.CheLiangGuanLi;
import com.model.CheLiangGuanLiModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CheLiangGuanLiService;

import net.sf.json.JSONArray;

/**
 *  车辆管理控制层
 */
public class CheLiangGuanLiController  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public CheLiangGuanLiController() {
		super();
	}

//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private CheLiangGuanLiService cheLiangGuanLiService;
	
	/**
	 * 属性
	 */
	private String type;	//类型
	private String name;	//名称
	private String shijileixing;	//实际类型
	
//	集合对象
	private static List<CheLiangGuanLi> cheliangguanlilist;
//	单一对象
	private  CheLiangGuanLi singlecheliangguanli;
	
	/**
	 *  发送车辆管理集合
	 */
	public static void sendCheLiangGuanLi(CheLiangGuanLiService cheLiangGuanLiService){
		System.out.println("发送车辆管理集合");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
//		设置字符格式
		FontFormat.setFontFormat(response);
//		加载applicationContext.xml文件
				
		
		
		List<CheLiangGuanLi> cheliangguanlilist = cheLiangGuanLiService.queryCheLiangGuanLi();
		request.setAttribute("cheliangguanlilist", cheliangguanlilist);
	}
	
	/**
	 *  跳转-车辆管理页面
	 */
	public String jumpCheLiangGuanLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end

//		设置字符格式
		FontFormat.setFontFormat(response);
	
		
		
		 cheliangguanlilist = cheLiangGuanLiService.queryCheLiangGuanLi();
		
		request.setAttribute("cheliangguanlilist", cheliangguanlilist);
		
		return "success";
	}
	
	/**
	 *  模糊查询车辆管理
	 */
	public String vagueSearchCheLiangGuanLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询车辆管理");

//		设置字符格式
		FontFormat.setFontFormat(response);
	
			
		
		cheliangguanlilist = cheLiangGuanLiService.vagueSearchCheLiangGuanLi(type, name);
		
		request.setAttribute("cheliangguanlilist", cheliangguanlilist);
		
		return "success";
	}
	
	/**
	 *  车辆管理json
	 */
	public void CheLiangGuanLiJson(){
		System.out.println("车辆管理json");
//		设置字符格式
		FontFormat.setFontFormat(response);

//		判断是否为空
		if(cheliangguanlilist==null){
			return;
		}
//		创建车辆管理模版对象
		List<CheLiangGuanLiModel> clglmlist = new ArrayList<CheLiangGuanLiModel>();
		
		for (int i = 0; i < cheliangguanlilist.size(); i++) {
			CheLiangGuanLi clgl = cheliangguanlilist.get(i);
			String id = String.valueOf(clgl.getId());
			String type = "";
			
			String mytype = clgl.getType();
			if("1".equals(mytype)){
				type="车辆类型";
			}else if("2".equals(mytype)){
				type="车辆品牌";
			}else if("3".equals(mytype)){
				type="车辆型号";
			}else if("5".equals(mytype)){
				type="车辆分组";
			}else if("6".equals(mytype)){
				type="经营范围";
			}
			
			String name = clgl.getName();
			String shijileixing = clgl.getShijileixing();
			
			CheLiangGuanLiModel clglm = new CheLiangGuanLiModel();
			clglm.setCheLiangGuanLiModel(id, type, name, shijileixing);
			clglmlist.add(clglm);
		}
		
		JSONArray ja = JSONArray.fromObject(clglmlist);
				
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	
	/**
	 *  跳转-添加车辆管理页面 
	 */
	public String jumpAddCheLianGuanLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转到添加车辆管理页面");
		return "success";
	}
	
	/**
	 *  添加车辆管理
	 */
	public String addCheLianGuanLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加车辆管理");

//		设置字符格式
		FontFormat.setFontFormat(response);
	
				
		
		CheLiangGuanLi cheliangguanli = new CheLiangGuanLi();
		cheliangguanli.setCheLiangGuanLi(type, name);
		cheliangguanli.setShijileixing(shijileixing);
		cheLiangGuanLiService.addCheLiangGuanLi(cheliangguanli);
		
		 cheliangguanlilist = cheLiangGuanLiService.queryCheLiangGuanLi();
		request.setAttribute("cheliangguanlilist", cheliangguanlilist);
		
		return "success";
	}

	/**
	 *  删除车辆管理
	 */
	public String deleteCheLiangGuanLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加车辆管理");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String id[] = request.getParameterValues("id");
		
		if(id==null || id.length<1 ){
			return "err";
		}
		
			
		
		for (int i = 0; i < id.length; i++) {
			cheLiangGuanLiService.deleteCheLiangGuanLi(Integer.valueOf(id[i]));
		}
		
		 cheliangguanlilist = cheLiangGuanLiService.queryCheLiangGuanLi();
		request.setAttribute("cheliangguanlilist", cheliangguanlilist);
		
		return "success";
	}
	
	/**
	 *  跳转-修改车辆管理
	 */
	public String jumpUpdateCheLiangGuanLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改车辆管理");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String id[] = request.getParameterValues("id");
		
		if(id==null || id.length<1 || id.length>1){
			return "err";
		}
			
			
		
		 singlecheliangguanli = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(id[0]));
		request.setAttribute("singlecheliangguanli", singlecheliangguanli);
		session.setAttribute("singlecheliangguanli", singlecheliangguanli);
		
		return "success";
	}
	
	/**
	 *  提交修改车辆管理
	 */
	public String submitUpdateCheLiangGuanLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("提交修改车辆管理");

//		设置字符格式
		FontFormat.setFontFormat(response);
				
		singlecheliangguanli = (CheLiangGuanLi) session.getAttribute("singlecheliangguanli");	
		
		singlecheliangguanli.setName(name);
		singlecheliangguanli.setShijileixing(shijileixing);
		
		cheLiangGuanLiService.updateCheLiangGuanLi(singlecheliangguanli);
		
		 cheliangguanlilist = cheLiangGuanLiService.queryCheLiangGuanLi();
		request.setAttribute("cheliangguanlilist", cheliangguanlilist);
		
		return "success";
	}
	
	/**
	 * get set 
	 */
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

	public CheLiangGuanLiService getCheLiangGuanLiService() {
		return cheLiangGuanLiService;
	}

	public void setCheLiangGuanLiService(CheLiangGuanLiService cheLiangGuanLiService) {
		this.cheLiangGuanLiService = cheLiangGuanLiService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
