package com.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.CheLiang;
import com.entity.CheLiangGuanLi;
import com.entity.CheLiangGuanXi;
import com.entity.Users;
import com.model.CheLiangGuanXiModel;
import com.model.CheLiangGuanXiSearchModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CheLiangGuanLiService;
import com.service.CheLiangGuanXiService;
import com.service.CheLiangService;

import net.sf.json.JSONArray;

/**
 *  车辆关系控制层
 */
public class CheLiangGuanXiController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public CheLiangGuanXiController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private CheLiangGuanXiService cheLiangGuanXiService;
	
	private CheLiangGuanLiService cheLiangGuanLiService;
	
	private CheLiangService cheLiangService;
	
//	车辆关系集合对象
	private static List<CheLiangGuanXi> cheliangguanxilist;

//	单一对象
	private static CheLiangGuanXi singlecheliangguanxi;
	
	/**
	 * 属性
	 */
	private String qianyinche;	//牵引车
	private String guache;	//挂车
	private String beizhu;	//备注
	
	/**
	 *  跳转-车辆关系
	 */
	public String jumpCheLiangGuanXi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		
		
		cheliangguanxilist = cheLiangGuanXiService.queryCheLiangGuanXi();
		request.setAttribute("cheliangguanxilist", cheliangguanxilist);
		
		return "success";
	}
	
	/**
	 *  模糊查询
	 */
	public String vagueSearchCheLiangGuanXi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("模糊查询车辆关系");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		
		
		 cheliangguanxilist = cheLiangGuanXiService.vagueSearchCheLiangGuanXi(qianyinche, guache);
		request.setAttribute("cheliangguanxilist", cheliangguanxilist);
		
		CheLiangGuanXiSearchModel cheLiangGuanXiSearchModel = new CheLiangGuanXiSearchModel();
		cheLiangGuanXiSearchModel.setCheLiangGuanXiSearchModel(qianyinche, guache);
		request.setAttribute("cheLiangGuanXiSearchModel", cheLiangGuanXiSearchModel);
		
		return "success";
	}

	/**
	 *  车辆关系json
	 */
	public void cheLiangGuanXiJson(){
		System.out.println("车辆关系json");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		判断是否为空
		if(cheliangguanxilist == null || cheliangguanxilist.size()<1){
			return ;
		}
//		创建车辆关系模版集合对象
		List<CheLiangGuanXiModel> cheLiangGuanXiModelList = new ArrayList<CheLiangGuanXiModel>();
		
		for (int i = 0; i < cheliangguanxilist.size(); i++) {
			
			CheLiangGuanXi cheliangguanxi = cheliangguanxilist.get(i);
			
			String id = String.valueOf(cheliangguanxi.getId());
			
			String path =request.getContextPath()+"/"+"cheLiangGuanXiXiangXi?id="+id;
			String qianyinche = "<a href=\""+path+"\">"+cheliangguanxi.getQianyinche()+"</a>";
			
			String guache = cheliangguanxi.getGuache();
			String caozuoyuan = cheliangguanxi.getCaozuoyuan();
			Date  date = cheliangguanxi.getCaozuoriqi();
			String beizhu = cheliangguanxi.getBeizhu();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh mm ss");
			
			CheLiangGuanXiModel cheliangguanximodel = new CheLiangGuanXiModel();
			cheliangguanximodel.setCheLiangGuanXiModel(id, qianyinche, guache, caozuoyuan, sdf.format(date), beizhu);
			cheLiangGuanXiModelList.add(cheliangguanximodel);
		}
		
		JSONArray ja = JSONArray.fromObject(cheLiangGuanXiModelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}

	/**
	 *  车辆关系详细
	 */
	public String cheLiangGuanXiXiangXi(){
		System.out.println("车辆关系详细");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
			
		
		String id = request.getParameter("id");
		CheLiangGuanXi singlecheliangguanxi = cheLiangGuanXiService.queryCheLiangGuanXiId(Integer.valueOf(id));
		
		request.setAttribute("singlecheliangguanxi", singlecheliangguanxi);
		
		return "success";
	}
	
	/**
	 *  删除车辆关系
	 */
	public String deleteCheLiangGuanXi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("删除车辆关系");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		加载applicationContext.xml文件	
		
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1){
			return "success";
		}
		
		for (int i = 0; i < id.length; i++) {
			cheLiangGuanXiService.deleteCheLiangGuanXi(Integer.valueOf(id[i]));
		}
		
		cheliangguanxilist = cheLiangGuanXiService.queryCheLiangGuanXi();
		request.setAttribute("cheliangguanxilist", cheliangguanxilist);
		
		return "success";
	}
	
	
	/**
	 *  跳转-添加车辆
	 */
	public String jumpAddCheLiangGuanXi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加车辆");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		车辆关系对象
			
//		车辆对象
		
//		车辆管理对象
		
		
		List<CheLiangGuanLi> cheliangguanlilist = cheLiangGuanLiService.queryCheLiangGuanLiName("牵引车");
		if(cheliangguanlilist == null){
			return "success";
		}
		
		List<CheLiang> qianyinchelist = new ArrayList<CheLiang>();
		
		
		for (int i = 0; i < cheliangguanlilist.size(); i++) {
			
			Integer cheliangguanliID = cheliangguanlilist.get(i).getId();
			
			List<CheLiang> chelianglist  = cheLiangService.queryCheLiangCheXingId(cheliangguanliID);
			
			for (int j = 0; j < chelianglist.size(); j++) {
				qianyinchelist.add( chelianglist.get(j) );
			}
			
		}
		 
		List<CheLiangGuanXi> cheliangguanxilist = cheLiangGuanXiService.queryCheLiangGuanXi();
//		车辆表作为外层
		for (int i = 0; i < cheliangguanxilist.size(); i++) {
//			挂车作为内层
			for (int j = 0; j < qianyinchelist.size(); j++) {
				
				String qianyinchepaihao = qianyinchelist.get(j).getChepaihao();
				String qianyincheguanxi = cheliangguanxilist.get(i).getQianyinche();
				
				if(qianyinchepaihao.equals(qianyincheguanxi)){
					qianyinchelist.remove(j);	
					break;
				}
				
			}
			
		}
		
		request.setAttribute("qianyinchelist", qianyinchelist);
		
		
		List<CheLiangGuanLi>  guacheguanlilist = cheLiangGuanLiService.queryCheLiangGuanLiName("挂车");
		if(guacheguanlilist == null){
			return "success";
		}
		
		List<CheLiang> guachelist = new ArrayList<CheLiang>();
		
		for (int i = 0; i < guacheguanlilist.size(); i++) {
			List<CheLiang> chelianglist = cheLiangService.queryCheLiangCheXingId(guacheguanlilist.get(i).getId());
			
			for (int j = 0; j < chelianglist.size(); j++) {
				guachelist.add(chelianglist.get(j));
			}
			
		}
		
		request.setAttribute("guachelist", guachelist);
		
		return "success";
	}
	
	/**
	 *  添加车辆
	 */
	public String addCheLiangGuanXi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加车辆");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		车辆关系对象
			
//		得到用户对象
		Users users = (Users) session.getAttribute("users");
		
		CheLiangGuanXi cheliangguanxi = new CheLiangGuanXi();
		cheliangguanxi.setCheLiangGuanXi(qianyinche, guache, users.getUsername(), new Date(), beizhu);
		
		cheLiangGuanXiService.addCheLiangGuanXi(cheliangguanxi);
		
		
		cheliangguanxilist = cheLiangGuanXiService.queryCheLiangGuanXi();
		request.setAttribute("cheliangguanxilist", cheliangguanxilist);
		
		return "success";
	}
	
	/**
	 *  跳转-修改车辆关系
	 */
	public String jumpUpdateCheLiangGuanXi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改车辆关系");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1 || id.length>1){
			return "err";
		}
				
//		车辆关系对象
		
//		车辆管理对象
		
//		车辆对象
		
		
		
		 singlecheliangguanxi = cheLiangGuanXiService.queryCheLiangGuanXiId(Integer.valueOf(id[0]));
		session.setAttribute("singlecheliangguanxi", singlecheliangguanxi);
		
		List<CheLiang> guachelist = new ArrayList<CheLiang>();
		
		List<CheLiangGuanLi>  guacheguanlilist = cheLiangGuanLiService.queryCheLiangGuanLiName("挂车");
		
		for (int i = 0; i < guacheguanlilist.size(); i++) {
			List<CheLiang> chelianglist = cheLiangService.queryCheLiangCheXingId(guacheguanlilist.get(i).getId());
			
			for (int j = 0; j < chelianglist.size(); j++) {
				guachelist.add(chelianglist.get(j));
			}
			
		}
		
		String guachestr =singlecheliangguanxi.getGuache();
		String guachearr[] = guachestr.split(",");
		
		for (int i = 0; i < guachearr.length; i++) {
			
			for (int j = 0; j < guachelist.size(); j++) {
				
				CheLiang cheliang = guachelist.get(j);
				if(cheliang.getChepaihao().equals(guachearr[i])){
					guachelist.remove(j);
					break;
				}
				
			}
			
		}
		
		session.setAttribute("guachelist", guachelist);
		request.setAttribute("guachearr", guachearr);
		return "success";
	}
	
	/**
	 *  提交修改车辆关系
	 */
	public String submitUpdateCheLiangGuanXi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改车辆关系");
//		设置字符格式
		FontFormat.setFontFormat(response);	
//		车辆关系对象
			
//		得到用户对象
		Users users = (Users) session.getAttribute("users");		
		
		singlecheliangguanxi.setCheLiangGuanXi(qianyinche, guache, users.getUsername(), new Date(), beizhu);
		
		cheLiangGuanXiService.updateCheLiangGuanXi(singlecheliangguanxi);
		
		cheliangguanxilist = cheLiangGuanXiService.queryCheLiangGuanXi();
		request.setAttribute("cheliangguanxilist", cheliangguanxilist);
		
		return "success";
		
	}
	
	/**
	 *  get set
	 */
	public String getQianyinche() {
		return qianyinche;
	}
	public void setQianyinche(String qianyinche) {
		this.qianyinche = qianyinche;
	}
	public String getGuache() {
		return guache;
	}
	public void setGuache(String guache) {
		this.guache = guache;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
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

	public CheLiangGuanXiService getCheLiangGuanXiService() {
		return cheLiangGuanXiService;
	}

	public void setCheLiangGuanXiService(CheLiangGuanXiService cheLiangGuanXiService) {
		this.cheLiangGuanXiService = cheLiangGuanXiService;
	}

	public CheLiangGuanLiService getCheLiangGuanLiService() {
		return cheLiangGuanLiService;
	}

	public void setCheLiangGuanLiService(CheLiangGuanLiService cheLiangGuanLiService) {
		this.cheLiangGuanLiService = cheLiangGuanLiService;
	}

	public CheLiangService getCheLiangService() {
		return cheLiangService;
	}

	public void setCheLiangService(CheLiangService cheLiangService) {
		this.cheLiangService = cheLiangService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
