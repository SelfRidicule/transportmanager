package com.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.Users;
import com.entity.WeiXianPin;
import com.model.WeiXianPinModel;
import com.myutils.FileManager;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.WeiXianPinService;

import net.sf.json.JSONArray;

/**
 *  危险品控制层
 */
public class WeiXianPinController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public WeiXianPinController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private WeiXianPinService weiXianPinService;
	
	/**
	 * 属性
	 */
	private String huowumingcheng;	//货物名称
	
	private File   anquanka;	//安全卡
	private String anquankaFileName;//FileName

//	集合对象
	private static List<WeiXianPin> weixianpinlist ;
//	单一对象
	private static WeiXianPin singleweixianpin ;
	
	/**
	 *  发送-危险品
	 */
	public static void sendWeiXianPin(WeiXianPinService weiXianPinService){
		System.out.println(" 发送-危险品 ");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
		
		
		
//		查询所有危险品
		List<WeiXianPin> weixianpinlist = weiXianPinService.queryWeiXianPinList();
//		发送集合对象
		request.setAttribute("weixianpinlist", weixianpinlist);
	}
	
	/**
	 *  得到危险品货物名称
	 */
	public void getWeiXianPinHuoWuMingCheng(){
		System.out.println(" 发送-危险品 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		String anquankamingcheng = request.getParameter("anquankamingcheng");
		
		String huowumingcheng = weiXianPinService.queryWeiXianPinInHuoWuMingCheng(anquankamingcheng);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("huowumingcheng", huowumingcheng);
		
		List list = new ArrayList();
		list.add(map);
		
		JSONArray ja = JSONArray.fromObject(list);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  跳转-危险品
	 */
	public String jumpWeiXianPin(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 跳转-危险品 ");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
//		查询所有危险品
		 weixianpinlist = weiXianPinService.queryWeiXianPinList();
//		发送集合对象
		request.setAttribute("weixianpinlist", weixianpinlist);
		
		return "success";
	}

	/**
	 *  模糊查询
	 */
	public String vagueSearchWeiXianPin(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 模糊查询 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		weixianpinlist = weiXianPinService.vagueSearchWeiXianPin(huowumingcheng);
		request.setAttribute("weixianpinlist", weixianpinlist);
		
		return "success";
	}

	/**
	 *  危险品json
	 */
	public void weiXianPinJson(){
		System.out.println(" 危险品json ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(weixianpinlist==null || weixianpinlist.size()<1){
			return ;
		}
		
		List<WeiXianPinModel> weixianpinmodellist = WeiXianPinModel.getWeiXianPinModelList(weixianpinlist);
		
		JSONArray ja = JSONArray.fromObject(weixianpinmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  添加危险品
	 */
	public String addWeiXianPin(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 添加危险品 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsername();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String caozuoriqi =sdf.format(new Date());
		
//		得到存放图片指定路径
		String path = request.getRealPath("/uploads/weixianpin");
		Long  currentTime = System.currentTimeMillis();
		
		String anquankaPath = FileManager.singleUploadFile(this.anquanka, anquankaFileName, path, currentTime);
		String anquankamingcheng = anquankaFileName;
		if("#".equals(anquankaPath)){
			anquankamingcheng="";
		}
		
		WeiXianPin weixianpin = new WeiXianPin();
		weixianpin.setWeiXianPin( huowumingcheng,  anquankaPath,
				 anquankamingcheng,  caozuoyuan,  caozuoriqi);
		
		weiXianPinService.addWeiXianPin(weixianpin);
		
		 weixianpinlist = weiXianPinService.queryWeiXianPinList();
		request.setAttribute("weixianpinlist", weixianpinlist);
		
		return "success";
	}
	
	/**
	 *  删除危险品
	 */
	public String deleteWeiXianPin(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 删除危险品 ");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		String id[] =  request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1){
			return "success";
		}
		
		
		
		for (int i = 0; i < id.length; i++) {
			WeiXianPin weixianpin = weiXianPinService.queryWeiXianPinId(Integer.valueOf(id[i]));
			String anquanka = weixianpin.getAnquanka();
			FileManager.deleteFile(anquanka);
			weiXianPinService.deleteWeiXianPin(weixianpin);
		}
		
		 weixianpinlist = weiXianPinService.queryWeiXianPinList();
		request.setAttribute("weixianpinlist", weixianpinlist);
		
		return "success";
	}
	
	/**
	 *  跳转-修改危险品
	 */
	public String jumpUpdateWeiXianPin(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-修改危险品 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		String id = request.getParameter("id");
		
		 singleweixianpin = weiXianPinService.queryWeiXianPinId(Integer.valueOf(id));
		request.setAttribute("singleweixianpin", singleweixianpin);
		
		return "success";
	}
	
	/**
	 *  修改危险品
	 */
	public String updateWeiXianPin(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 修改危险品 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		Users users = (Users) session.getAttribute("users");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String caozuoriqi =sdf.format(new Date());
		
		singleweixianpin.setCaozuoyuan(users.getUsername());
		singleweixianpin.setCaozuoriqi(caozuoriqi);
		singleweixianpin.setHuowumingcheng(huowumingcheng);
		
		if(anquanka != null){
//			删除原来的文件
			FileManager.deleteFile(singleweixianpin.getAnquanka());
			
//			得到存放图片指定路径
			String path = request.getRealPath("/uploads/weixianpin");
			Long  currentTime = System.currentTimeMillis();
			
			String anquankaPath = FileManager.singleUploadFile(this.anquanka, anquankaFileName, path, currentTime);
			singleweixianpin.setAnquanka(anquankaPath);
			singleweixianpin.setAnquankamingcheng(anquankaFileName);
		}
		
		weiXianPinService.updateWeiXianPin(singleweixianpin);
		
		 weixianpinlist = weiXianPinService.queryWeiXianPinList();
		request.setAttribute("weixianpinlist", weixianpinlist);
		
		return "success";
	}
	
	/**
	 *  危险品详细
	 */
	public String weiXianPinXiangXi(){
		System.out.println(" 危险品详细 ");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		String id = request.getParameter("id");
		
		 singleweixianpin = weiXianPinService.queryWeiXianPinId(Integer.valueOf(id));
		
		String anquanka = singleweixianpin.getAnquanka();
		
		if(!"#".equals(anquanka)){
			int index = anquanka.indexOf("uploads");
			anquanka = anquanka.substring(index);
			anquanka = anquanka.replaceAll("\\\\", "/");
			singleweixianpin.setAnquanka(anquanka);
		}
		
		request.setAttribute("singleweixianpin", singleweixianpin);
		
		return "success";
	}
	
	/**
	 *  get set
	 */
	public String getHuowumingcheng() {
		return huowumingcheng;
	}

	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}

	public File getAnquanka() {
		return anquanka;
	}

	public void setAnquanka(File anquanka) {
		this.anquanka = anquanka;
	}

	public String getAnquankaFileName() {
		return anquankaFileName;
	}

	public void setAnquankaFileName(String anquankaFileName) {
		this.anquankaFileName = anquankaFileName;
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

	public WeiXianPinService getWeiXianPinService() {
		return weiXianPinService;
	}

	public void setWeiXianPinService(WeiXianPinService weiXianPinService) {
		this.weiXianPinService = weiXianPinService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
