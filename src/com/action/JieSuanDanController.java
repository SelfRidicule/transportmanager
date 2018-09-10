package com.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.JieSuanDan;
import com.model.JieSuanDanModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.JieSuanDanService;

import net.sf.json.JSONArray;

/**
 * 	结算单 控制层
 */
public class JieSuanDanController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public JieSuanDanController() {
		super();
	}

//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private JieSuanDanService jieSuanDanService;
	
	
	
	/**
	 * 属性
	 */
	private String dingdanhao;	//订单号
	private String chezhuxingming;	//车主姓名
	private String huowumingcheng;	//货物名称
	private Date   chaxunxiaoyulingkuanshijian;	//小于领款时间
	private Date   chaxundayulingkuanshijian;	//大于领款时间
	private String kehudanwei;	//客户单位
	
//	集合对象
	private static List<JieSuanDan> jiesuandanlist ;
	
	/**
	 * 	跳转-结算单
	 */
	public String jumpJieSuanDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-结算单");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		jiesuandanlist = jieSuanDanService.queryJieSuanDanListOrderById();
		request.setAttribute("jiesuandanlist", jiesuandanlist);
		
		return "success";
	}
	
	/**
	 * 	模糊查询
	 */
	public String vagueSearchJieSuanDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("模糊查询");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		 jiesuandanlist = jieSuanDanService.vagueSearchJieSuanDan(dingdanhao, chezhuxingming, huowumingcheng, chaxunxiaoyulingkuanshijian, chaxundayulingkuanshijian, kehudanwei);
		request.setAttribute("jiesuandanlist", jiesuandanlist);
		
		return "success";
	}
	
	
	/**
	 * 	结算单json
	 */
	public void jieSuanDanJson(){
		System.out.println("结算单json");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if( jiesuandanlist == null || jiesuandanlist.size()<1 ){
			return ;
		}
		
		List<JieSuanDanModel> jiesuandanmodellist = JieSuanDanModel.getJieSuanDanModelList(jiesuandanlist);
		
		JSONArray ja = JSONArray.fromObject(jiesuandanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
		
	}
	
	/**
	 *  跳转-结算单详细
	 */
	public String jumpJieSuanDanXiangXi(){
		System.out.println("跳转-结算单详细");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		String id = request.getParameter("id");

		
		JieSuanDan singlejiesuandan =  jieSuanDanService.queryJieSuanDanId(Integer.valueOf(id));
		
		request.setAttribute("singlejiesuandan", singlejiesuandan);
		
		return "success";
	}
	
	
	/**
	 * 	添加结算单
	 */
	public String addJieSuanDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加结算单");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		return "success";
	}
	
	/**
	 * 	跳转-修改
	 */
	public String jumpUpdateJieSuanDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		return "success";
	}
	
	
	/**
	 * 	提交-修改
	 */
	public String submitUpdateJieSuanDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("提交-修改");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		return "success";
	}
	
	/**
	 * 	删除
	 */
	public String deleteJieSuanDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("删除");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		return "success";
	}

	/**
	 * 	get set
	 */
	public String getDingdanhao() {
		return dingdanhao;
	}

	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}

	public String getChezhuxingming() {
		return chezhuxingming;
	}

	public void setChezhuxingming(String chezhuxingming) {
		this.chezhuxingming = chezhuxingming;
	}

	public String getHuowumingcheng() {
		return huowumingcheng;
	}

	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}

	public Date getChaxunxiaoyulingkuanshijian() {
		return chaxunxiaoyulingkuanshijian;
	}

	public void setChaxunxiaoyulingkuanshijian(Date chaxunxiaoyulingkuanshijian) {
		this.chaxunxiaoyulingkuanshijian = chaxunxiaoyulingkuanshijian;
	}

	public Date getChaxundayulingkuanshijian() {
		return chaxundayulingkuanshijian;
	}

	public void setChaxundayulingkuanshijian(Date chaxundayulingkuanshijian) {
		this.chaxundayulingkuanshijian = chaxundayulingkuanshijian;
	}

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
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

	public JieSuanDanService getJieSuanDanService() {
		return jieSuanDanService;
	}

	public void setJieSuanDanService(JieSuanDanService jieSuanDanService) {
		this.jieSuanDanService = jieSuanDanService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
