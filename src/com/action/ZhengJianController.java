package com.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.CheLiang;
import com.entity.Users;
import com.entity.ZhengJian;
import com.model.ZhengJianJsonModel;
import com.model.ZhengJianSearchModel;
import com.myjson.ZhengJianJson;
import com.myutils.FileManager;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CheLiangService;
import com.service.ZhengJianService;

import net.sf.json.JSONArray;

/**
 *  证件控制层
 */
public class ZhengJianController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public ZhengJianController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	
	
	private CheLiangService cheLiangService;
	
	private ZhengJianService zhengJianService;
	
//	集合对象
	private static List<ZhengJian> zhengjianlist;
//	单一
	private static ZhengJian singlezhengjian;
	
	/**
	 * 属性
	 */
	private File   picture[];		//图片file类
	private String pictureFileName[];	//图片file名称
	private String pictureContentType[];	//图片file类型
	
	
	private String chepaihao;	//车牌号
	private String zhengjianleixing;	//证件类型
	private Date   banliriqi;	//办理日期
	private Date   daoqiriqi;	//到期日期
	private String zhengjianhaoma;	//证件号码
	
	private String zhengjianzhuangtai; //证件状态
	private Date   chaxunxiaoyudaoqiriqi ; //查询小于到期日期
	private Date   chaxundayudaoqiriqi;	//查询大于到期日期
	private String caozuoyuan ; 	//操作员
	
	private static ArrayList<String> picturepathlist = new ArrayList<String>();	//添加图片集合对象
	private static ArrayList<String> deletezhengjianlist = new ArrayList<String>(); //删除图片集合对象
	
	/**
	 *  跳转-证件页面
	 */
	public String jumpZhengJian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);
		
					
		
		zhengjianlist = zhengJianService.queryZhengJianList();
		request.setAttribute("zhengjianlist", zhengjianlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  模糊查询证件
	 */
	public String vagueSearchZhengJian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询证件");
//		设置字符格式
		FontFormat.setFontFormat(response);		
						
		
		 zhengjianlist = zhengJianService.vagueSearchZhengJian(chepaihao, zhengjianleixing, caozuoyuan, chaxunxiaoyudaoqiriqi, chaxundayudaoqiriqi);
		
		request.setAttribute("zhengjianlist", zhengjianlist);
		
		session.setAttribute("zhengjianzhuangtai", zhengjianzhuangtai);
		
		ZhengJianSearchModel zhengjiansearchmodel = new ZhengJianSearchModel(chepaihao, zhengjianleixing, zhengjianzhuangtai, chaxunxiaoyudaoqiriqi, chaxundayudaoqiriqi, caozuoyuan);
		request.setAttribute("zhengjiansearchmodel", zhengjiansearchmodel);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  证件json
	 */
	public void zhengJianJson(){
		System.out.println("证件json");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		判断证件集合是否为空
		if(zhengjianlist == null || "".equals(zhengjianlist)){
			return ;
		}
		
		
//		创建证件json模版集合对象
		List<ZhengJianJsonModel> zhengjianjsonmodellist = new ArrayList<ZhengJianJsonModel>();
		
		for (int i = 0; i < zhengjianlist.size(); i++) {
//			创建证件json模版对象
			ZhengJianJsonModel  zhengjianjsonmodel = new ZhengJianJsonModel();
//			通过循环得到证件对象
			 ZhengJian zhengjian = zhengjianlist.get(i);
			 String chepaihao = zhengjian.getChepaihao();		//车牌号
//			 得到车辆对象
			 CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
			 
			 String id =  String.valueOf(zhengjian.getId());	//id
			 
			 String path =request.getContextPath()+"/"+"zhengJianXiangXi?id="+id;
			 String zhengjianhaoma = "<a href=\""+path+"\">"+zhengjian.getZhengjianhaoma()+"</a>";	//证件号码
			 
			 String chezhuxingming = cheliang.getChezhuxingming();	//车主姓名
			 String shoujihao = cheliang.getShoujihao();	//手机号
			 String zhengjianleixing = zhengjian.getZhengjianleixing();	//证件类型
			 String daoqiriqi = zhengjian.getDaoqiriqi().toString();	//到期日期
			 String caozuoyuan = zhengjian.getCaozuoyuan();	//操作员
			 String zhengjianzhuangtai ="";		//证件状态
			 
			 Date date = zhengjian.getDaoqiriqi();
			 Date currentdate = new Date();
			 
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(currentdate);
			 cal.add(Calendar.DATE, 30);
			 Date addDate = cal.getTime();
			 
			 Calendar cal7 = Calendar.getInstance();
			 cal7.setTime(currentdate);
			 cal7.add(Calendar.DATE, 7);
			 Date addDate7 = cal7.getTime();
			 
			 if(addDate.after(date) && date.after(addDate7)){
				 zhengjianzhuangtai="预警";
			 }else if(addDate7.after(date) && date.after(currentdate)){
				 zhengjianzhuangtai="报警";
			 }else if(currentdate.after(date)){
				 zhengjianzhuangtai="过期";
			 }else{
				 zhengjianzhuangtai="正常";
			 }
			 
			 zhengjianjsonmodel.setZhengJianJsonModel(id, zhengjianhaoma, zhengjianzhuangtai,
					 								chepaihao, chezhuxingming, shoujihao, 
					 								zhengjianleixing, daoqiriqi, caozuoyuan);
			 
			 zhengjianjsonmodellist.add(zhengjianjsonmodel);
		}
		
		String zhengjianzhuangtai = (String) session.getAttribute("zhengjianzhuangtai");
		if(zhengjianzhuangtai==null || "".equals(zhengjianzhuangtai)){
		}else{
			
			for (int j = 0; j < zhengjianjsonmodellist.size(); j++) {
				ZhengJianJsonModel zhengjianjsonmodel = zhengjianjsonmodellist.get(j); //证件json模版
				String value = zhengjianjsonmodel.getZhengjianzhuangtai();
				if( !zhengjianzhuangtai.equals(value)){
					zhengjianjsonmodellist.remove(zhengjianjsonmodel);
					--j;
				}
			}
			
		}

//		输出证件json模版集合对象
		JSONArray ja = JSONArray.fromObject(zhengjianjsonmodellist);
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}

	/**
	 *  证件详细
	 */
	public String zhengJianXiangXi(){
		System.out.println("证件详细");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
			
		
		String id = request.getParameter("id");
		
		ZhengJian singlezhengjian = zhengJianService.queryIdZhengJian(Integer.valueOf(id));
		request.setAttribute("singlezhengjian", singlezhengjian);
		
//		得到附件路径
		String fujianstr = singlezhengjian.getFujian();
//		创建图片集合对象
		List<String> picturelist = new ArrayList<String>();
		
		String fujiansplit[] = fujianstr.split(",");
		
		String formatPathStr[] = FileManager.formatArrStr(fujiansplit, "uploads");
		
		if(formatPathStr != null){
			for (int i = 0; i < formatPathStr.length; i++) {
				picturelist.add(formatPathStr[i]);
			}
		}
		
		request.setAttribute("picturelist", picturelist);
		
		return "success";
	}
	
	/**
	 *  证件---上传文件
	 */
	public void zhengJianUploadFile(){
		System.out.println("文件上传");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到存放图片指定路径,chepaihao是前端传递的参数
		String path = request.getRealPath("/uploads/zhengjiantupian/"+chepaihao);
		try {
			for (int i = 0; i < picture.length; i++) {
				
				String filename = System.currentTimeMillis() + pictureFileName[i];
				
				String fujianpath =path+"\\"+filename+",";
				
				picturepathlist.add(fujianpath);
				
				FileUtils.copyFile( picture[i], new File(path,filename) );
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		输出证件json模版对象
		Map<String, String> map = new HashMap<String, String>();
		map.put("value", "success");
		JSONArray ja = JSONArray.fromObject(map);
		try {
			PrintWriter pw = response.getWriter();
//			必须要输出json格式数据不然图片上传后前台依旧错误
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  证件---删除文件
	 */
	public void zhengJianDeleteFile(){
		System.out.println("删除文件");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
//		得到传递的额外参数
		String fullpath = request.getParameter("fullpath");
//		 把删除的图片全路径添加到该集合对象
		deletezhengjianlist.add(fullpath);
		
//		输出证件json模版对象		
		Map<String, String> map = new HashMap<String, String>();
		map.put("value", "success");
		JSONArray ja = JSONArray.fromObject(map);
		try {
			PrintWriter pw = response.getWriter();
//			必须要输出json格式数据不然图片上传后前台依旧错误
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  证件ajax
	 */
	public void zhengJianAjax(){
		System.out.println("证件ajax");
//		设置字符格式
		FontFormat.setFontFormat(response);		

//		得到图片的全部路径
		String fujianstr = singlezhengjian.getFujian();
		String chepaihao = singlezhengjian.getChepaihao();
//		创建证件json集合对象
		List<ZhengJianJson> zhengjianjsonlist = new ArrayList<ZhengJianJson>();
//		判断得到的图片路径是否为空
		if(fujianstr==null || "".equals(fujianstr)){
			return ;
		}else{
//			通过逗号拆分图片
			String fujiansplit[] = fujianstr.split(",");
			for (int i = 0; i < fujiansplit.length; i++) {
				String fjs = fujiansplit[i];
//				把\全部替换成/
				String picpath =fjs.replaceAll("\\\\", "/");
				
				int index = picpath.indexOf("uploads");
				String clippath = picpath.substring(index);
				zhengjianjsonlist.add(new ZhengJianJson(clippath, fjs));
			}
		}
		
		JSONArray ja = JSONArray.fromObject(zhengjianjsonlist);
		try {
			PrintWriter pw = response.getWriter();
//			必须要输出json格式数据不然图片上传后前台依旧错误
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  跳转-添加证件
	 */
	public String jumpAddZhengJian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		CheLiangController.sendCheLiang(cheLiangService);
		picturepathlist.clear();	//清空图片路径 
		deletezhengjianlist.clear(); //清空删除图片路径
		return "success";
	}
	
	/**
	 *  添加证件
	 */
	public String addZhengJian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加证件");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
				
		
		Integer index = zhengJianService.existZhengJianLeiXing(chepaihao, zhengjianleixing);
		if(index>0){
			picturepathlist.clear();
			request.setAttribute("existzhengjianleixing", "存在相同的证件类型");
			return "err";
		}
		
		ZhengJian zhengjian = new ZhengJian();
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsername();

		StringBuffer fujian = new StringBuffer();
		for (int i = 0; i < picturepathlist.size(); i++) {
			fujian.append(picturepathlist.get(i));
		}
		
		zhengjian.setZhengJian(chepaihao, zhengjianleixing, banliriqi, daoqiriqi, zhengjianhaoma, fujian.toString(), caozuoyuan, new Date());
		
		zhengJianService.addZhengJian(zhengjian);
		
		picturepathlist.clear();
		
		zhengjianlist = zhengJianService.queryZhengJianList();
		request.setAttribute("zhengjianlist", zhengjianlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  删除证件
	 */
	public String deleteZhengJian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("删除证件");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到要删除的id数组		
		String id[] = request.getParameterValues("toolbar1");
//		判断是否选中
		if(id == null || id.length<1){
			CheLiangController.sendCheLiang(cheLiangService);
			return "success";
		}
		
						

		for (int i = 0; i < id.length; i++) {
			ZhengJian zhengjian = zhengJianService.queryIdZhengJian(Integer.valueOf(id[i]));
			String fujianstr = zhengjian.getFujian();
			if(fujianstr==null || "".equals(fujianstr)){
				continue;
			}else{
//				删除指定路径的文件
				String fujiansplit[] = fujianstr.split(",");
				for (int j = 0; j < fujiansplit.length; j++) {
					String filepath =fujiansplit[j];
					File file = new File(filepath);
					if(file.isFile() && file.exists()){
						file.delete();
					}
				}
			}
			
		}

		for (int i = 0; i < id.length; i++) {
			zhengJianService.deleteZhengJian(Integer.valueOf(id[i]));
		}
		
		 zhengjianlist = zhengJianService.queryZhengJianList();
		request.setAttribute("zhengjianlist", zhengjianlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
 	/**
 	 *  修改证件
 	 */
 	public String updateZhengJian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改证件");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到要删除的id数组		
		String id[] = request.getParameterValues("toolbar1");
//		判断是否选中和多选
		if(id == null || id.length<1 || id.length>1){
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}
			
					
 		
		 singlezhengjian = zhengJianService.queryIdZhengJian(Integer.valueOf(id[0]));
		 
		request.setAttribute("singlezhengjian", singlezhengjian);
		
		CheLiangController.sendCheLiang(cheLiangService);

		picturepathlist.clear();
		deletezhengjianlist.clear();
		
 		return "success";
 	}
	
 	/**
 	 *  提交修改证件
 	 */
 	public String submitUpdateZhengJian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("提交修改证件");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		ZhengJian zhengjian = singlezhengjian ;
		Users users = (Users) session.getAttribute("users");
		
//		得到附件
		String fujianstr = zhengjian.getFujian();
//		拆分附件
		String fujianarr[] = fujianstr.split(",");
//		设置删除相同的文件路径
		for (int i = 0; i < fujianarr.length; i++) {
			
			for (int j = 0; j < deletezhengjianlist.size(); j++) {
				if(fujianarr[i].equals(deletezhengjianlist.get(j))){
					fujianarr[i]="isnull";
				}
			}
			
		}
//		删除文件
		for (int i = 0; i < deletezhengjianlist.size(); i++) {
			FileManager.deleteFile(deletezhengjianlist.get(i));
		}

//		创建新的附件对象,往里添加路径
		String addfujianpath="";
		for (int i = 0; i < fujianarr.length; i++) {
			if("isnull".equals(fujianarr[i]) || "".equals(fujianarr[i]) || fujianarr[i]==null){
				continue;
			}
//			注意最后要添加逗号
			addfujianpath=addfujianpath+fujianarr[i]+",";
		}
		
		for (int i = 0; i < picturepathlist.size(); i++) {
//			因为该集合里已经添加逗号所以不用添加
			addfujianpath=addfujianpath+picturepathlist.get(i);
		}
		
//		加载applicationContext.xml文件
					
			
//		修改证件里的值
		zhengjian.setBanliriqi(banliriqi);
		zhengjian.setDaoqiriqi(daoqiriqi);
		zhengjian.setZhengjianhaoma(zhengjianhaoma);
		zhengjian.setCaozuoyuan(users.getUsername());
		zhengjian.setCaozuoriqi(new Date());
		zhengjian.setFujian(addfujianpath);
		
		zhengJianService.updateZhengJian(zhengjian);
		
		zhengjianlist = zhengJianService.queryZhengJianList();
		request.setAttribute("zhengjianlist", zhengjianlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
 		return "success";
 	}
 	
	/**
	 *  get set
	 */
	public File[] getPicture() {
		return picture;
	}

	public void setPicture(File[] picture) {
		this.picture = picture;
	}

	public String[] getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String[] pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public String[] getPictureContentType() {
		return pictureContentType;
	}

	public void setPictureContentType(String[] pictureContentType) {
		this.pictureContentType = pictureContentType;
	}

	public String getChepaihao() {
		return chepaihao;
	}

	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}

	public String getZhengjianleixing() {
		return zhengjianleixing;
	}

	public void setZhengjianleixing(String zhengjianleixing) {
		this.zhengjianleixing = zhengjianleixing;
	}

	public Date getBanliriqi() {
		return banliriqi;
	}

	public void setBanliriqi(Date banliriqi) {
		this.banliriqi = banliriqi;
	}

	public Date getDaoqiriqi() {
		return daoqiriqi;
	}

	public void setDaoqiriqi(Date daoqiriqi) {
		this.daoqiriqi = daoqiriqi;
	}

	public String getZhengjianhaoma() {
		return zhengjianhaoma;
	}

	public void setZhengjianhaoma(String zhengjianhaoma) {
		this.zhengjianhaoma = zhengjianhaoma;
	}

	public String getZhengjianzhuangtai() {
		return zhengjianzhuangtai;
	}

	public void setZhengjianzhuangtai(String zhengjianzhuangtai) {
		this.zhengjianzhuangtai = zhengjianzhuangtai;
	}

	public Date getChaxunxiaoyudaoqiriqi() {
		return chaxunxiaoyudaoqiriqi;
	}

	public void setChaxunxiaoyudaoqiriqi(Date chaxunxiaoyudaoqiriqi) {
		this.chaxunxiaoyudaoqiriqi = chaxunxiaoyudaoqiriqi;
	}

	public Date getChaxundayudaoqiriqi() {
		return chaxundayudaoqiriqi;
	}

	public void setChaxundayudaoqiriqi(Date chaxundayudaoqiriqi) {
		this.chaxundayudaoqiriqi = chaxundayudaoqiriqi;
	}

	public String getCaozuoyuan() {
		return caozuoyuan;
	}

	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}

	public static ArrayList<String> getPicturepathlist() {
		return picturepathlist;
	}

	public static void setPicturepathlist(ArrayList<String> picturepathlist) {
		ZhengJianController.picturepathlist = picturepathlist;
	}

	public static ArrayList<String> getDeletezhengjianlist() {
		return deletezhengjianlist;
	}

	public static void setDeletezhengjianlist(ArrayList<String> deletezhengjianlist) {
		ZhengJianController.deletezhengjianlist = deletezhengjianlist;
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

	public CheLiangService getCheLiangService() {
		return cheLiangService;
	}

	public void setCheLiangService(CheLiangService cheLiangService) {
		this.cheLiangService = cheLiangService;
	}

	public ZhengJianService getZhengJianService() {
		return zhengJianService;
	}

	public void setZhengJianService(ZhengJianService zhengJianService) {
		this.zhengJianService = zhengJianService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
