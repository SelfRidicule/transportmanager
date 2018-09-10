package com.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.FenGuanLingDao;
import com.entity.JinDu;
import com.entity.Users;
import com.entity.ZeRenRen;
import com.model.ZeRenRenModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FenGuanLingDaoService;
import com.service.JinDuService;
import com.service.XinCheService;
import com.service.ZeRenRenService;

import net.sf.json.JSONArray;

/**
 *  责任人控制层
 */
public class ZeRenRenController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public ZeRenRenController() {
		super();
	}

//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private XinCheService xinCheService;
	
	private ZeRenRenService zeRenRenService;
	
	private JinDuService jinDuService;
	
	private FenGuanLingDaoService fenGuanLingDaoService;
	
	
	
//	集合对象
	private static List<ZeRenRen> zerenrenlist ;
//	单一对象
	private static ZeRenRen singlezerenren;
	
	/**
	 * 属性
	 */
	private String  bianhao;
	private String  chepaihao;
	private String  banlizhuangtai;
	private String  zerenrenqianming;
	private String  zerenrenyijian;
	
	/**
	 *  跳转-责任人
	 */
	public String jumpZeRenRen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-责任人");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		 zerenrenlist = zeRenRenService.queryZeRenRenWeiBanLi();
		request.setAttribute("zerenrenlist", zerenrenlist);
	
		XinCheController.sendXinChe(xinCheService);
	 
		return "success";
	}
	
	/**
	 *  模糊查询
	 */
	public String vagueSearchZeRenRen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		 zerenrenlist = zeRenRenService.vagueSearchZeRenRen(bianhao, chepaihao, banlizhuangtai);
		request.setAttribute("zerenrenlist", zerenrenlist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  责任人json
	 */
	public void zeRenRenJson(){
		System.out.println("责任人json");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(zerenrenlist == null ){
			return ;
		}
		
		List<ZeRenRenModel> zeRenRenModelList = ZeRenRenModel.getZeRenRenModelList(zerenrenlist);
		
		JSONArray ja = JSONArray.fromObject(zeRenRenModelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	
	/**
	 *  跳转-添加责任人
	 */
	public String jumpAddZeRenRen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-添加责任人");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		 singlezerenren = zeRenRenService.queryZeRenRenChePaiHao(chepaihao);
		request.setAttribute("singlezerenren", singlezerenren);
		
		return "success";
	}
	
	/**
	 *  添加责任人
	 */
	public String addZeRenRen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加责任人");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		
//		得到传递的对象
		Users users = (Users) session.getAttribute("users");
		
//		初始化
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		Date   banliriqi = new Date();
		String chepaihao = singlezerenren.getChepaihao();
		String bianhao = singlezerenren.getBianhao();
		
//		修改责任人
		singlezerenren.setZeRenRen(bianhao, chepaihao, caozuoyuan, caozuoriqi, 
							"已办理", banliriqi, zerenrenqianming, zerenrenyijian);
		zeRenRenService.updateZeRenRen(singlezerenren);
		
		
//		修改 进度
		JinDu jindu = jinDuService.queryJinDuInChePaiHao(chepaihao);
		jindu.setDangqianjindu("责任人签字");
		jinDuService.updateJinDu(jindu);
		
//		添加分管领导
		FenGuanLingDao fenguanlingdao = new FenGuanLingDao();
		fenguanlingdao.setFenGuanLingDaoXiangGuanXinXi( bianhao,  chepaihao,  caozuoyuan,
				 caozuoriqi,  "未办理",  banliriqi);
		fenGuanLingDaoService.addFenGuanLingDao(fenguanlingdao);
		
//		send
		zerenrenlist = zeRenRenService.queryZeRenRenWeiBanLi();
		request.setAttribute("zerenrenlist", zerenrenlist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  跳转-修改责任人
	 */
	public String jumpUpdateZeRenRen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改责任人");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
			
		singlezerenren = zeRenRenService.queryZeRenRenChePaiHao(chepaihao);
		request.setAttribute("singlezerenren", singlezerenren);
		
		return "success";
	}
	
	/**
	 *  修改责任人
	 */
	public String updateZeRenRen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改责任人");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		Users users = (Users) session.getAttribute("users");
//		初始化
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
//		赋值
		singlezerenren.setZeRenRenValue( caozuoyuan,  caozuoriqi, zerenrenqianming,  zerenrenyijian);
//		修改
		zeRenRenService.updateZeRenRen(singlezerenren);
		
//		send
		zerenrenlist = zeRenRenService.queryZeRenRenWeiBanLi();
		request.setAttribute("zerenrenlist", zerenrenlist);
		
		XinCheController.sendXinChe(xinCheService);
		
		return "success";
	}
	
	/**
	 *  get set
	 */
	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getChepaihao() {
		return chepaihao;
	}

	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}

	public String getBanlizhuangtai() {
		return banlizhuangtai;
	}

	public void setBanlizhuangtai(String banlizhuangtai) {
		this.banlizhuangtai = banlizhuangtai;
	}

	public String getZerenrenqianming() {
		return zerenrenqianming;
	}

	public void setZerenrenqianming(String zerenrenqianming) {
		this.zerenrenqianming = zerenrenqianming;
	}

	public String getZerenrenyijian() {
		return zerenrenyijian;
	}

	public void setZerenrenyijian(String zerenrenyijian) {
		this.zerenrenyijian = zerenrenyijian;
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

	public XinCheService getXinCheService() {
		return xinCheService;
	}

	public void setXinCheService(XinCheService xinCheService) {
		this.xinCheService = xinCheService;
	}

	public ZeRenRenService getZeRenRenService() {
		return zeRenRenService;
	}

	public void setZeRenRenService(ZeRenRenService zeRenRenService) {
		this.zeRenRenService = zeRenRenService;
	}

	public JinDuService getJinDuService() {
		return jinDuService;
	}

	public void setJinDuService(JinDuService jinDuService) {
		this.jinDuService = jinDuService;
	}

	public FenGuanLingDaoService getFenGuanLingDaoService() {
		return fenGuanLingDaoService;
	}

	public void setFenGuanLingDaoService(FenGuanLingDaoService fenGuanLingDaoService) {
		this.fenGuanLingDaoService = fenGuanLingDaoService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

