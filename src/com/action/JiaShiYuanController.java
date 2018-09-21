package com.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.CongYeZiGe;
import com.entity.Dept;
import com.entity.JiaShiYuan;
import com.entity.Users;
import com.model.JiaShiYuanInModel;
import com.model.JiaShiYuanModel;
import com.model.JiaShiYuanNianShenModel;
import com.model.JiaShiYuanShenHeModel;
import com.model.PageServer;
import com.myjson.ZhengJianJson;
import com.myutils.FileManager;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CheLiangService;
import com.service.CongYeZiGeService;
import com.service.DeptService;
import com.service.JiaShiYuanService;
import com.service.UsersService;
import com.service.YunDanService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *  驾驶员控制层
 */
public class JiaShiYuanController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public JiaShiYuanController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
 	
	
	private CheLiangService cheLiangService;
	
	private JiaShiYuanService jiaShiYuanService;
	
	private DeptService deptService;
	
	private CongYeZiGeService congYeZiGeService;
	
	private YunDanService yunDanService;
	
	private UsersService usersService;
	
	
	
//	单一对象
	private  JiaShiYuan singlejiashiyuan;
//	集合对象
	private static List<JiaShiYuan> jiashiyuanshenhelist;
//	单一对象
	private  JiaShiYuan singlejiashiyuanshenhe;
//	集合对象
	private static List<JiaShiYuan> jiashiyuannianshenlist;
//	单一对象
	private  JiaShiYuan singlejiashiyuannianshen;
//	年审状态
	private static String nianshenzhuangtaiValue ;
	
	
	/**
	 * 属性
	 */
	private String jiashiyuanxingming;	//驾驶员姓名	
	private String jiashicheliang;	//驾驶车辆
	private String jiashiyuanleixing;	//驾驶员类型
	private String bumen;	//部门
	private Date chushengriqi;	//出生日期
	private String jiguan;	//籍贯
	private String shenfenzhenghao;	//身份证号
	private String dianhua;	//电话
	private String dizhi;	//地址
	private String zhunjiachexing;	//准驾车型
	private Date chucilingzhengriqi;	//初次领证日期
	private Date jiashizhengnianshenriqi;	//驾驶证年审日期
	private String danganbianhao;	//档案编号
	private String congyezigezhenghao;	//从业资格证号
	private String congyezigeleibie;	//从业资格类别
	private Date congyezigejixujiaoyushijian;	//从业资格继续教育时间
	private Date congyezigechengxinkaoheshijian;	//从业资格诚信考核时间
	private Date zhengjianyouxiaoriqi;	//证件有效日期
	private String beizhu;	//备注
	private String shenhezhuangtai;	//审核状态
	private String mima;	//密码
	private String xingbie;	//性别;
	private String jiashizhengbianhao;	//驾驶证档案编号
	private Date   congyezigeriqi;	//从业资格证有效期至
	private String fazhengjiguan;	//发证机关
	private Date congyezigejixujiaoyushijianzhi;	//从业资格继续教育时间止

	private String cheliangzhuangtai;	//车辆状态
	
	private File jiashiyuantupian[];	//驾驶员图片
	private String jiashiyuantupianFileName[];	//驾驶员图片名称	
	
	private File jiashizhengtupian[];	//驾驶证图片
	private String jiashizhengtupianFileName[];	//驾驶证图片名称
	
	private File congyezigezhengtupian[];	//从业资格证图片
	private String congyezigezhengtupianFileName[];	//从业资格证图片名称
	
	private File shenfenzhengtupian[];	//身份证图片
	private String shenfenzhengtupianFileName[];	//身份证图片名称
	
	private  List<String> jiashiyuantupianlist = new ArrayList<String>();	//驾驶员图片路径集合
	private  List<String> jiashizhengtupianlist = new ArrayList<String>();	//驾驶证图片路径集合
	private  List<String> congyezigezhengtupianlist = new ArrayList<String>();	//从业资格证图片路径集合
	private  List<String> shenfenzhengtupianlist = new ArrayList<String>();	//身份证图片路径集合
	
	private  List<String> deletejiashiyuantupianlist = new ArrayList<String>();	//删除驾驶员图片路径集合
	private  List<String> deletejiashizhengtupianlist = new ArrayList<String>();	//删除驾驶证图片路径集合
	private  List<String> deletecongyezigezhengtupianlist = new ArrayList<String>();	//删除从业资格证图片路径集合
	private  List<String> deleteshenfenzhengtupianlist = new ArrayList<String>();	//删除身份证图片路径集合
	
	private Date xiaoyuriqi;
	private Date dayuriqi;
	private String nianshenzhuangtai;
	
	
	public void sessionRemovePicture() {
		
		session.removeAttribute("jiashiyuantupianlist");
		session.removeAttribute("jiashizhengtupianlist");
		session.removeAttribute("congyezigezhengtupianlist");
		session.removeAttribute("shenfenzhengtupianlist");
		
		session.removeAttribute("deletejiashiyuantupianlist");
		session.removeAttribute("deletejiashizhengtupianlist");
		session.removeAttribute("deletecongyezigezhengtupianlist");
		session.removeAttribute("deleteshenfenzhengtupianlist");
		  
	}
	
	public void sessionSetClearPicture() {
		
		if(jiashiyuantupianlist == null) {
			jiashiyuantupianlist = new ArrayList<String>();
		}
		jiashiyuantupianlist.clear();
		
		if(jiashizhengtupianlist == null) {
			jiashizhengtupianlist = new ArrayList<String>();
		}
		jiashizhengtupianlist.clear();
		
		if(congyezigezhengtupianlist == null) {
			congyezigezhengtupianlist = new ArrayList<String>();
		}
		congyezigezhengtupianlist.clear();
		
		if(shenfenzhengtupianlist == null) {
			shenfenzhengtupianlist = new ArrayList<String>();
		}
		shenfenzhengtupianlist.clear();
		
		 
		if(deletejiashiyuantupianlist == null) {
			deletejiashiyuantupianlist = new ArrayList<String>();
		}
		deletejiashiyuantupianlist.clear();
		 
		if(deletejiashizhengtupianlist == null) {
			deletejiashizhengtupianlist = new ArrayList<String>();
		}
		deletejiashizhengtupianlist.clear();
		
		if(deletecongyezigezhengtupianlist == null) {
			deletecongyezigezhengtupianlist = new ArrayList<String>();
		}
		deletecongyezigezhengtupianlist.clear();
		
		if(deleteshenfenzhengtupianlist == null) {
			deleteshenfenzhengtupianlist = new ArrayList<String>();
		}
		deleteshenfenzhengtupianlist.clear();
		  
		
		
		session.setAttribute("jiashiyuantupianlist", jiashiyuantupianlist);
		session.setAttribute("jiashizhengtupianlist", jiashizhengtupianlist);
		session.setAttribute("congyezigezhengtupianlist",congyezigezhengtupianlist );
		session.setAttribute("shenfenzhengtupianlist", shenfenzhengtupianlist);
		
		session.setAttribute("deletejiashiyuantupianlist",deletejiashiyuantupianlist );
		session.setAttribute("deletejiashizhengtupianlist", deletejiashizhengtupianlist);
		session.setAttribute("deletecongyezigezhengtupianlist", deletecongyezigezhengtupianlist);
		session.setAttribute("deleteshenfenzhengtupianlist", deleteshenfenzhengtupianlist);
		
		
	}
	
	public void sessionGetPicture() {
		jiashiyuantupianlist = (List<String>) session.getAttribute("jiashiyuantupianlist");
		jiashizhengtupianlist = (List<String>) session.getAttribute("jiashizhengtupianlist");
		congyezigezhengtupianlist = (List<String>) session.getAttribute("congyezigezhengtupianlist");
		shenfenzhengtupianlist = (List<String>) session.getAttribute("shenfenzhengtupianlist");
		
		deletejiashiyuantupianlist = (List<String>) session.getAttribute("deletejiashiyuantupianlist");
		deletejiashizhengtupianlist = (List<String>) session.getAttribute("deletejiashizhengtupianlist");
		deletecongyezigezhengtupianlist = (List<String>) session.getAttribute("deletecongyezigezhengtupianlist");
		deleteshenfenzhengtupianlist = (List<String>) session.getAttribute("deleteshenfenzhengtupianlist");
	}
	
	
	/**
	 *  移动端-注册时电话是否重复
	 */
	public void androidJiaShiYuanDianHua(){
		System.out.println("移动端-注册时电话是否重复");

//		设置字符格式
		FontFormat.setFontFormat(response);		
	
//		得到驾驶员业务对象
		
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.queryJiaShiYuanDianHua(dianhua);
		
		Map<String, String> map = new HashMap<String, String>();
		
//		如果没有查到证明没有注册
		if(jiashiyuanlist == null || jiashiyuanlist.size()<1){
//			如果是空返回flase
			map.put("flag", "flase");
			JSONObject jo = JSONObject.fromObject(map);
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}else{
//			如果不是空返回true
			map.put("flag", "true");
			JSONObject jo = JSONObject.fromObject(map);
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}
		
	}
	
	/**
	 *  移动端-驾驶员注册
	 */
	public void androidJiaShiYuanZhuCe(){
		System.out.println("移动端-驾驶员注册");

//		设置字符格式
		FontFormat.setFontFormat(response);		
	
//		得到驾驶员业务对象
		
		
		 HttpServletRequest request = ServletActionContext.getRequest();
		String jiashiyuanstr = request.getParameter("jiashiyuan");
		
		JSONObject jo =  new JSONObject().fromObject(jiashiyuanstr);
		JiaShiYuan jiashiyuan = (JiaShiYuan) JSONObject.toBean(jo,JiaShiYuan.class);
		
		jiashiyuan.setJiashicheliang("");
		jiashiyuan.setBumen("1");//不确定
		jiashiyuan.setJiashiyuanleixing("驾驶员");
		jiashiyuan.setDanganbianhao("");
		jiashiyuan.setCongyezigezhenghao("");
		jiashiyuan.setCongyezigeleibie("");
		jiashiyuan.setBeizhu("");
		jiashiyuan.setCaozuoyuan("驾驶员");
		jiashiyuan.setCaozuoriqi(new Date());
		jiashiyuan.setShenhezhuangtai("未审核");
		jiashiyuan.setMima("111111");
		
//		上传图片的地址
		String jiashiyuantupianpath = request.getRealPath("/uploads/jiashiyuan/"+jiashiyuan.getJiashiyuanxingming()+"/"+"jiashiyuantupian");
		String jiashizhengtupianpath = request.getRealPath("/uploads/jiashiyuan/"+jiashiyuan.getJiashiyuanxingming()+"/"+"jiashizhengtupian");
		String congyezigezhengtupianpath = request.getRealPath("/uploads/jiashiyuan/"+jiashiyuan.getJiashiyuanxingming()+"/"+"congyezigezhengtupian");
		String shenfenzhengtupianpath = request.getRealPath("/uploads/jiashiyuan/"+jiashiyuan.getJiashiyuanxingming()+"/"+"shenfenzhengtupian");
//		当前时间
		Long currentTime = System.currentTimeMillis();
//		上传图片并且返回图片路径
		jiashiyuantupianpath = FileManager.singleUploadFile(jiashiyuantupian[0], jiashiyuantupianFileName[0], jiashiyuantupianpath, currentTime);
		jiashizhengtupianpath = FileManager.singleUploadFile(jiashizhengtupian[0], jiashizhengtupianFileName[0], jiashizhengtupianpath, currentTime);
		congyezigezhengtupianpath = FileManager.singleUploadFile(congyezigezhengtupian[0], congyezigezhengtupianFileName[0], congyezigezhengtupianpath, currentTime);
		shenfenzhengtupianpath = FileManager.singleUploadFile(shenfenzhengtupian[0], shenfenzhengtupianFileName[0], shenfenzhengtupianpath, currentTime);
		
		jiashiyuan.setJiashiyuantupian(jiashiyuantupianpath);
		jiashiyuan.setJiashizhengtupian(jiashizhengtupianpath);
		jiashiyuan.setCongyezigezhengtupian(congyezigezhengtupianpath);
		jiashiyuan.setShenfenzhengtupian(shenfenzhengtupianpath);
		
		jiaShiYuanService.addJiaShiYuan(jiashiyuan);
		
		
		Map<String, String> mymap = new HashMap<String, String>();
		mymap.put("flag", "true");
		JSONObject flag = JSONObject.fromObject(mymap);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(flag);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  移动端-驾驶员删除（删除审核失败的状态）
	 */
	public void androidJiaShiYuanShanChu(){
		System.out.println("跳转-修改驾驶员审核");
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		JiaShiYuan jiashiyuan = jiaShiYuanService.queryJiaShiYuanDianHua(dianhua).get(0);
		
		if("审核失败".equals(jiashiyuan.getShenhezhuangtai())){
			String jiashiyuantupian = jiashiyuan.getJiashiyuantupian();
			String jiashizhengtupian = jiashiyuan.getJiashizhengtupian();
			String congyezigezhengtupian = jiashiyuan.getCongyezigezhengtupian();
			String shenfenzhengtupian = jiashiyuan.getShenfenzhengtupian();
			
			if(jiashiyuantupian != null && !"".equals(jiashiyuantupian)){
				String jiashiyuantupianArr[] = jiashiyuantupian.split(",");
				FileManager.deleteFileArr(jiashiyuantupianArr);
			}
			if(jiashizhengtupian != null && !"".equals(jiashizhengtupian)){
				String jiashizhengtupianArr[] = jiashizhengtupian.split(",");
				FileManager.deleteFileArr(jiashizhengtupianArr);
			}
			if(congyezigezhengtupian != null && !"".equals(congyezigezhengtupian)){
				String congyezigezhengtupianArr[] = congyezigezhengtupian.split(",");
				FileManager.deleteFileArr(congyezigezhengtupianArr);
			}
			if(shenfenzhengtupian != null && !"".equals(shenfenzhengtupian)){
				String shenfenzhengtupianArr[] = shenfenzhengtupian.split(",");
				FileManager.deleteFileArr(shenfenzhengtupianArr);
			}
			
			jiaShiYuanService.deleteJiaShiYuan(jiashiyuan.getId());
		}
		
	}
	
	/**
	 *  跳转-驾驶员 
	 */
	public String jumpJiaShiYuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  发送驾驶员集合
	 */
	public static void sendJiaShiYuan(JiaShiYuanService jiaShiYuanService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
//		得到驾驶员业务对象
		
		
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.queryJiaShiYuan();
		request.setAttribute("jiashiyuanlist", jiashiyuanlist);
		
	}
	
	/**
	 *  发送审核通过的驾驶员集合
	 */
	public static void sendJiaShiYuanShenHeTongGuo(JiaShiYuanService jiaShiYuanService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
//		得到驾驶员业务对象
		
		
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.queryJiaShiYuanShenHeTongGuo();
		request.setAttribute("jiashiyuanlist", jiashiyuanlist);
		
	}
	
	
	/**
	 * 移动端-驾驶员登录
	 */
	public void jiaShiYuanDengLu(){
		System.out.println("移动端-驾驶员登录");
//		设置字符格式
		FontFormat.setFontFormat(response);		
	
//		得到驾驶员业务对象
		
		List<JiaShiYuan> jiashiyuanlist  = jiaShiYuanService.jiaShiYuanDengLu(dianhua, mima);

		Map<String, Object> mymap = new HashMap<String, Object>();
		
		if(jiashiyuanlist != null && !"".equals(jiashiyuanlist)){
			mymap.put("flag", "登录成功");
			
			mymap.put("jiashiyuan",JiaShiYuanInModel.getJiaShiYuanInModel( jiashiyuanlist.get(0) ,deptService ) );
		}else{
			mymap.put("flag", "登录失败");
		}
		
		
		JSONArray ja = JSONArray.fromObject(mymap);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  移动端-驾驶员修改密码
	 */
	public void updateJiaShiYuanMiMa(){
		System.out.println("移动端-驾驶员修改密码");

//		设置字符格式
		FontFormat.setFontFormat(response);		

//		得到驾驶员业务对象
		
//		得到部门业务对象
					
		
		String data = request.getParameter("data");
		Map<String, String> mymap = new HashMap<String, String>();
		
		if("".equals(data) || data == null){
			mymap.put("flag", "false");
			JSONArray ja = JSONArray.fromObject(mymap);
			
			try {
				PrintWriter pw = response.getWriter();
				pw.print(ja);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
			return ;
		}
		
		
		JSONObject jsonObject = JSONObject.fromObject(data);
		JiaShiYuan jiashiyuan =  (JiaShiYuan) JSONObject.toBean(jsonObject, JiaShiYuan.class);
//		查询指定电话的驾驶员对象
		JiaShiYuan jiashiyuandianhua = jiaShiYuanService.queryJiaShiYuanDianHua(jiashiyuan.getDianhua()).get(0);
//		赋值id
		jiashiyuan.setId(jiashiyuandianhua.getId());
		
//		得到部门名称 并且 查询对应部门对象
		String bumenName = jiashiyuan.getBumen();
		Dept dept = deptService.queryDeptName(bumenName).get(0);

//		从新设置部门值
		jiashiyuan.setBumen(String.valueOf(dept.getDeptid()));
		
		jiaShiYuanService.updateJiaShiYuan(jiashiyuan);
		
		mymap.put("flag", "true");
		
		JSONArray ja = JSONArray.fromObject(mymap);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
		
	}
	
	/**
	 *  模糊查询 
	 */
	public void vagueSearchJiaShiYuan(){
        
		System.out.println("模糊查询驾驶员");

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		//得到客户端传递的页码和每页记录数，并转换成int类型  
        String pageSize = "10";
        String pageNumber = "1";
		
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.vagueSearchJiaShiYuan(jiashicheliang, jiashiyuanxingming, jiashiyuanleixing, zhunjiachexing, pageSize , pageNumber);
//		创建驾驶员模版集合对象
		List<JiaShiYuanModel> jiashiyuanmodellist = JiaShiYuanModel.getJiaShiYuanModelList(jiashiyuanlist,yunDanService);
		
		Long Total = jiaShiYuanService.jiaShiYuanSize( jiashicheliang,  jiashiyuanxingming,  jiashiyuanleixing,  zhunjiachexing);
		
		PageServer ps = new PageServer();
		ps.setRows(jiashiyuanmodellist);
		ps.setTotal(Total.intValue());
		
		JSONObject jo = JSONObject.fromObject(ps);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(jo);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  驾驶员json 
	 */
	public void jiaShiYuanJson(){
		System.out.println("驾驶员json");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		//得到客户端传递的页码和每页记录数，并转换成int类型  
        String pageSize = request.getParameter("pageSize");  
        String pageNumber = request.getParameter("pageNumber");
		
        
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.vagueSearchJiaShiYuan(jiashicheliang, jiashiyuanxingming, jiashiyuanleixing, zhunjiachexing, pageSize , pageNumber);
//		创建驾驶员模版集合对象
		List<JiaShiYuanModel> jiashiyuanmodellist = JiaShiYuanModel.getJiaShiYuanModelList(jiashiyuanlist,yunDanService);
		
		Long Total = jiaShiYuanService.jiaShiYuanSize( jiashicheliang,  jiashiyuanxingming,  jiashiyuanleixing,  zhunjiachexing);
		
		PageServer ps = new PageServer();
		ps.setRows(jiashiyuanmodellist);
		ps.setTotal(Total.intValue());
		
		JSONObject jo = JSONObject.fromObject(ps);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(jo);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  判断驾驶员电话是否重复
	 */
	public void jiaShiYuanExistDianHua(){
		System.out.println("判断驾驶员电话是否重复");

//		设置字符格式
		FontFormat.setFontFormat(response);	

//		得到驾驶员业务对象
		
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.queryJiaShiYuanDianHua(dianhua);
		
		List  list = new ArrayList();
		Map<String, String> map = new HashMap<String, String>();
		
//		如果没有查到证明没有注册
		if(jiashiyuanlist == null || jiashiyuanlist.size()<1){
//			如果是空返回err
			map.put("flag", "success");
			list.add(map);
			
			JSONArray jo = JSONArray.fromObject(list);
			
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}else{
//			如果不是空返回success
			map.put("flag", "err");
			list.add(map);
			
			JSONArray jo = JSONArray.fromObject(list);
			
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}
		
	}
	
	/**
	 *  判断驾驶员身份证是否重复
	 */
	public void jiaShiYuanExistShenFenZheng(){
		System.out.println("判断驾驶员身份证是否重复");

//		设置字符格式
		FontFormat.setFontFormat(response);	

//		得到驾驶员业务对象
		
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.queryJiaShiYuanShenFenZheng(shenfenzhenghao);
		
		List  list = new ArrayList();
		Map<String, String> map = new HashMap<String, String>();
		
//		如果没有查到证明没有注册
		if(jiashiyuanlist == null || jiashiyuanlist.size()<1){
			map.put("flag", "success");
			list.add(map);
			
			JSONArray jo = JSONArray.fromObject(list);
			
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}else{
			map.put("flag", "err");
			list.add(map);
			
			JSONArray jo = JSONArray.fromObject(list);
			
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}
		
	}
	
	/**
	 *  驾驶员详细
	 */
	public String jiaShiYuanXiangXi(){
		System.out.println("驾驶员详细");

//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		
		
		String id = request.getParameter("id");
		
		JiaShiYuan singlejiashiyuanshenhe = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(id));
		
		
		String jiashiyuantupian = singlejiashiyuanshenhe.getJiashiyuantupian();
		String jiashizhengtupian = singlejiashiyuanshenhe.getJiashizhengtupian();
		String congyezigezhengtupian =  singlejiashiyuanshenhe.getCongyezigezhengtupian();
		String shenfenzhengtupian = singlejiashiyuanshenhe.getShenfenzhengtupian();
		
		String jiashiyuantupianlist[] = null;
		String jiashizhengtupianlist[] = null;
		String congyezigezhengtupianlist[] = null;
		String shenfenzhengtupianlist[] = null;
		
		if(jiashiyuantupian != null){
			jiashiyuantupian = jiashiyuantupian.replaceAll("\\\\", "/");
			jiashiyuantupianlist = jiashiyuantupian.split(",");
			jiashiyuantupianlist = FontFormat.deleteIndexStr(jiashiyuantupianlist, "uploads");
			
		}
		
		if(jiashizhengtupian != null){
			jiashizhengtupian = jiashizhengtupian.replaceAll("\\\\", "/");
			jiashizhengtupianlist = jiashizhengtupian.split(",");
			jiashizhengtupianlist = FontFormat.deleteIndexStr(jiashizhengtupianlist, "uploads");
		}
		
		if(congyezigezhengtupian != null){
			congyezigezhengtupian = congyezigezhengtupian.replaceAll("\\\\", "/");
			congyezigezhengtupianlist = congyezigezhengtupian.split(",");
			congyezigezhengtupianlist = FontFormat.deleteIndexStr(congyezigezhengtupianlist, "uploads");
		}
	
		if(shenfenzhengtupian != null){
			shenfenzhengtupian = shenfenzhengtupian.replaceAll("\\\\", "/");
			shenfenzhengtupianlist = shenfenzhengtupian.split(",");
			shenfenzhengtupianlist = FontFormat.deleteIndexStr(shenfenzhengtupianlist, "uploads");
		}

		DeptController.sendDeptList(deptService);	
		session.setAttribute("singlejiashiyuanshenhe", singlejiashiyuanshenhe);
		
		request.setAttribute("jiashiyuantupianlist", jiashiyuantupianlist);
		request.setAttribute("jiashizhengtupianlist",jiashizhengtupianlist );
		request.setAttribute("congyezigezhengtupianlist", congyezigezhengtupianlist);
		request.setAttribute("shenfenzhengtupianlist", shenfenzhengtupianlist);
		
		return "success";
	}
	
	/**
	 *  删除驾驶员 
	 */
	public String deleteJiaShiYuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("删除驾驶员");

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1){
			CheLiangController.sendCheLiang(cheLiangService);
			return "success";
		}
		
		
		
		for (int i = 0; i < id.length; i++) {
			JiaShiYuan jiashiyuan = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(id[i]));
			String jiashiyuantupian = jiashiyuan.getJiashiyuantupian();
			String jiashizhengtupian = jiashiyuan.getJiashizhengtupian();
			String congyezigezhengtupian = jiashiyuan.getCongyezigezhengtupian();
			String shenfenzhengtupian = jiashiyuan.getShenfenzhengtupian();
			
			if(jiashiyuantupian != null && !"".equals(jiashiyuantupian)){
				String jiashiyuantupianArr[] = jiashiyuantupian.split(",");
				FileManager.deleteFileArr(jiashiyuantupianArr);
			}
			
			if(jiashizhengtupian != null && !"".equals(jiashizhengtupian)){
				String jiashizhengtupianArr[] = jiashizhengtupian.split(",");
				FileManager.deleteFileArr(jiashizhengtupianArr);
			}
			
			if(congyezigezhengtupian != null && !"".equals(congyezigezhengtupian)){
				String congyezigezhengtupianArr[] = congyezigezhengtupian.split(",");
				FileManager.deleteFileArr(congyezigezhengtupianArr);
			}
			
			if(shenfenzhengtupian != null && !"".equals(shenfenzhengtupian)){
				String shenfenzhengtupianArr[] = shenfenzhengtupian.split(",");
				FileManager.deleteFileArr(shenfenzhengtupianArr);
			}
			
			jiaShiYuanService.deleteJiaShiYuan(Integer.valueOf(id[i]));
		}
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  跳转-添加驾驶员
	 */
	public String jumpAddJiaShiYuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 跳转-添加驾驶员");
		
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		发送部门集合
		DeptController.sendDeptList(deptService);
//		发送车辆集合
		CheLiangController.sendCheLiang(cheLiangService);		
//		发送从业资格类别
		CongYeZiGeController.sendCongYeZiGe(congYeZiGeService);	
		
//		清空图片
		sessionSetClearPicture();
		
		return "success";
	}
	
	
	/**
	 *  添加驾驶员
	 */
	public String addJianShiYuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		得到驾驶员业务对象
//		得到图片
		sessionGetPicture();
		
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsersid().toString();
		Date caozuoriqi = new Date();
		
		
		StringBuffer jiashiyuantupianlujing = new StringBuffer("");
		for (int i = 0; i < jiashiyuantupianlist.size(); i++) {
			jiashiyuantupianlujing.append(jiashiyuantupianlist.get(i));
		}
		
		StringBuffer jiashizhengtupianlujing = new StringBuffer("");
		for (int i = 0; i < jiashizhengtupianlist.size(); i++) {
			jiashizhengtupianlujing.append(jiashizhengtupianlist.get(i));
		}
		
		StringBuffer congyezigezhengtupianlujing = new StringBuffer("");
		for (int i = 0; i < congyezigezhengtupianlist.size(); i++) {
			congyezigezhengtupianlujing.append(congyezigezhengtupianlist.get(i));
		}
		
		StringBuffer shenfenzhengtupianlujing = new StringBuffer("");
		for (int i = 0; i < shenfenzhengtupianlist.size(); i++) {
			shenfenzhengtupianlujing.append(shenfenzhengtupianlist.get(i));
		}
		
		JiaShiYuan jiashiyuan = new JiaShiYuan();
		jiashiyuan.setJiaShiYuan(jiashiyuanxingming, "", jiashiyuanleixing,
									bumen, chushengriqi, jiguan, 
									shenfenzhenghao, dianhua, dizhi, 
									zhunjiachexing, chucilingzhengriqi, jiashizhengnianshenriqi,
									danganbianhao, congyezigezhenghao, congyezigeleibie, 
									congyezigejixujiaoyushijian, congyezigechengxinkaoheshijian, zhengjianyouxiaoriqi,
									beizhu, jiashiyuantupianlujing.toString() , jiashizhengtupianlujing.toString() , 
									congyezigezhengtupianlujing.toString() , shenfenzhengtupianlujing.toString() , 
									caozuoyuan, caozuoriqi , "未审核");
		jiashiyuan.setMima(mima);
		
		jiashiyuan.setJiaShiYuan( xingbie,  jiashizhengbianhao,
				 congyezigeriqi,  fazhengjiguan,
				 congyezigejixujiaoyushijianzhi);
		
		jiaShiYuanService.addJiaShiYuan(jiashiyuan);
		
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
//		移除图片
		sessionRemovePicture();
		
		return "success";
	}
	
	/**
	 * 	驾驶员-驾驶员图片-上传文件 
	 */
	public void jiashiyuantupianFileUpLoad(){
		System.out.println("驾驶员-驾驶员图片-上传文件 ");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String tupianleixing = request.getParameter("tupianleixing");
		
		jiashiyuantupianlist = (List<String>) session.getAttribute("jiashiyuantupianlist");
		
//		得到存放图片指定路径,chepaihao是前端传递的参数
		String path = request.getRealPath("/uploads/jiashiyuan/"+jiashiyuanxingming+"/"+tupianleixing);
//		TODO
		try {
			for (int i = 0; i < jiashiyuantupian.length; i++) {
				
				String filename = System.currentTimeMillis() + jiashiyuantupianFileName[i];
				
				String tupianlujing =path+"\\"+filename+",";
				
				jiashiyuantupianlist.add(tupianlujing);
				
				session.setAttribute("jiashiyuantupianlist", jiashiyuantupianlist);
				
				FileUtils.copyFile( jiashiyuantupian[i], new File(path,filename) );
				
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
	 * 	驾驶员-驾驶证图片-上传文件 
	 */
	public void jiashizhengtupianFileUpLoad(){
		System.out.println("驾驶员-驾驶证图片-上传文件 ");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String tupianleixing = request.getParameter("tupianleixing");
		
		jiashizhengtupianlist = (List<String>) session.getAttribute("jiashizhengtupianlist");
		
//		得到存放图片指定路径,chepaihao是前端传递的参数
		String path = request.getRealPath("/uploads/jiashiyuan/"+jiashiyuanxingming+"/"+tupianleixing);
		
		try {
			for (int i = 0; i < jiashizhengtupian.length; i++) {
				
				String filename = System.currentTimeMillis() + jiashizhengtupianFileName[i];
				
				String tupianlujing =path+"\\"+filename+",";
				
				jiashizhengtupianlist.add(tupianlujing);
				
				session.setAttribute("jiashizhengtupianlist", jiashizhengtupianlist);
				
				FileUtils.copyFile( jiashizhengtupian[i], new File(path,filename) );
				
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
	 * 	驾驶员-从业资格证图片-上传文件 
	 */
	public void congyezigezhengtupianFileUpLoad(){
		System.out.println("驾驶员-从业资格证图片-上传文件 ");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String tupianleixing = request.getParameter("tupianleixing");
		
		congyezigezhengtupianlist = (List<String>) session.getAttribute("congyezigezhengtupianlist");
		
//		得到存放图片指定路径,chepaihao是前端传递的参数
		String path = request.getRealPath("/uploads/jiashiyuan/"+jiashiyuanxingming+"/"+tupianleixing);
		
		try {
			for (int i = 0; i < congyezigezhengtupian.length; i++) {
				
				String filename = System.currentTimeMillis() + congyezigezhengtupianFileName[i];
				
				String tupianlujing =path+"\\"+filename+",";
				
				congyezigezhengtupianlist.add(tupianlujing);
				
				session.setAttribute("congyezigezhengtupianlist", congyezigezhengtupianlist);
				
				FileUtils.copyFile( congyezigezhengtupian[i], new File(path,filename) );
				
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
	 * 	驾驶员-身份证图片-上传文件 
	 */
	public void shenfenzhengtupianFileUpLoad(){
		System.out.println("驾驶员-身份证图片-上传文件 ");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String tupianleixing = request.getParameter("tupianleixing");
		
		shenfenzhengtupianlist = (List<String>) session.getAttribute("shenfenzhengtupianlist");
		
//		得到存放图片指定路径,chepaihao是前端传递的参数
		String path = request.getRealPath("/uploads/jiashiyuan/"+jiashiyuanxingming+"/"+tupianleixing);
		
		try {
			for (int i = 0; i < shenfenzhengtupian.length; i++) {
				
				String filename = System.currentTimeMillis() + shenfenzhengtupianFileName[i];
				
				String tupianlujing =path+"\\"+filename+",";
				
				shenfenzhengtupianlist.add(tupianlujing);
				
				session.setAttribute("shenfenzhengtupianlist", shenfenzhengtupianlist);
				
				FileUtils.copyFile( shenfenzhengtupian[i], new File(path,filename) );
				
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
	 *  跳转-修改驾驶员
	 */
	public String jumpUpdateJiaShiYuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-修改驾驶员");

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1 || id.length>1){
//			发送车辆集合
			CheLiangController.sendCheLiang(cheLiangService);
			
			return "err";
		}
		
		
		
		 singlejiashiyuan = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(id[0]));
		 request.setAttribute("singlejiashiyuan",singlejiashiyuan);
		 session.setAttribute("singlejiashiyuan",singlejiashiyuan);
		
//		 清空图片
		 sessionSetClearPicture();
		 
//		发送从业资格
		
		List<CongYeZiGe> congyezigelist = congYeZiGeService.queryCongYeZiGeList();
		
		String congyezige = singlejiashiyuan.getCongyezigeleibie();
		String selectCongYeZiGeStr [] = null;
		
		if(congyezige != null && !"".equals(congyezige)){
			
			selectCongYeZiGeStr = congyezige.split(", ");
			
			for (int i = 0; i < congyezigelist.size(); i++) {
				
				for (int j = 0; j < selectCongYeZiGeStr.length; j++) {
					
					if(selectCongYeZiGeStr[j].equals( congyezigelist.get(i).getLeibiemingcheng() )){
						congyezigelist.remove(i);
						i--;
						break;
					}
				}
			}
		}
		
		
		
		request.setAttribute("congyezigelist", congyezigelist);
		request.setAttribute("selectCongYeZiGeStr", selectCongYeZiGeStr);
		
//		发送准驾车型
		List<String> zhunjialist = new ArrayList<String>();
		zhunjialist.add("A1");
		zhunjialist.add("A2");
		zhunjialist.add("A3");
		zhunjialist.add("B1");
		zhunjialist.add("B2");
		zhunjialist.add("C1");
		zhunjialist.add("C2");
		zhunjialist.add("D");
		zhunjialist.add("E");
			
		String selectZhunJia[] = null;
		
		String zhunjiaStr = singlejiashiyuan.getZhunjiachexing();
		
		if(zhunjiaStr != null && !"".equals(zhunjiaStr)){
			
			selectZhunJia = zhunjiaStr.split(", ");
			
			for (int i = 0; i < zhunjialist.size(); i++) {
				
				for (int j = 0; j < selectZhunJia.length; j++) {
					
					if(selectZhunJia[j].equals(zhunjialist.get(i))){
						zhunjialist.remove(i);
						i--;
						break;
					}
				}
			}
		}
		
		request.setAttribute("zhunjialist", zhunjialist);
		request.setAttribute("selectZhunJia", selectZhunJia);
		
//		发送部门集合
		DeptController.sendDeptList(deptService);
//		发送车辆集合
		CheLiangController.sendCheLiang(cheLiangService);
		

		
		return "success";
	}
	
	/**
	 *  提交-修改驾驶员 
	 */
	public String submitUpdateJianShiYuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("提交-修改驾驶员 ");

//		设置字符格式
		FontFormat.setFontFormat(response);			
		
//		得到图片
		sessionGetPicture();
		
		singlejiashiyuan = (JiaShiYuan) session.getAttribute("singlejiashiyuan");
		
		Users users = (Users) session.getAttribute("users");
		String caozuoyuan = users.getUsersid().toString();
		Date caozuoriqi = new Date();
		
		
		String jiashiyuantupian = singlejiashiyuan.getJiashiyuantupian();
		String jiashizhengtupian = singlejiashiyuan.getJiashizhengtupian();
		String congyezigezhengtupian = singlejiashiyuan.getCongyezigezhengtupian();
		String shenfenzhengtupian = singlejiashiyuan.getShenfenzhengtupian();
		
//		驾驶员图片添加删除操作
		String jiashiyuantupianArr[]  = jiashiyuantupian.split(",");
		String jiashiyuantupianStr = FileManager.deleteAndAddPicturePath(jiashiyuantupianArr, jiashiyuantupianlist, deletejiashiyuantupianlist);
		
		String jiashizhengtupianArr[] = jiashizhengtupian.split(",");
		String jiashizhengtupianStr = FileManager.deleteAndAddPicturePath(jiashizhengtupianArr, jiashizhengtupianlist, deletejiashizhengtupianlist);
		
		String congyezigezhengtupianArr[] = congyezigezhengtupian.split(",");
		String congyezigezhengtupianStr = FileManager.deleteAndAddPicturePath(congyezigezhengtupianArr, congyezigezhengtupianlist, deletecongyezigezhengtupianlist);
		
		String shenfenzhengtupianArr[] = shenfenzhengtupian.split(",");
		String shenfenzhengtupianStr = FileManager.deleteAndAddPicturePath(shenfenzhengtupianArr, shenfenzhengtupianlist, deleteshenfenzhengtupianlist);
		
		
		singlejiashiyuan.setJiaShiYuan(jiashiyuanxingming, jiashicheliang, jiashiyuanleixing,
				bumen, chushengriqi, jiguan, 
				shenfenzhenghao, dianhua, dizhi, 
				zhunjiachexing, chucilingzhengriqi, jiashizhengnianshenriqi,
				danganbianhao, congyezigezhenghao, congyezigeleibie, 
				congyezigejixujiaoyushijian, congyezigechengxinkaoheshijian, zhengjianyouxiaoriqi,
				beizhu, jiashiyuantupianStr , jiashizhengtupianStr , 
				congyezigezhengtupianStr , shenfenzhengtupianStr , 
				caozuoyuan, caozuoriqi , "未审核");
		singlejiashiyuan.setMima(mima);
		
		singlejiashiyuan.setJiaShiYuan( xingbie,  jiashizhengbianhao,
				 congyezigeriqi,  fazhengjiguan,
				 congyezigejixujiaoyushijianzhi);
		
		jiaShiYuanService.updateJiaShiYuan(singlejiashiyuan);
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
//		移除
		sessionRemovePicture();
		
		return "success";
	}
	
	/**
	 *  驾驶员图片Ajax
	 */
	public void jiashiyuantupianAjax(){
		System.out.println("驾驶员图片Ajax");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		singlejiashiyuan = (JiaShiYuan) session.getAttribute("singlejiashiyuan");
		
//		得到图片的全部路径
		String fujianstr = singlejiashiyuan.getJiashiyuantupian();
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
	 *  驾驶员图片删除
	 */
	public void jiashiyuantupianDeleteFile(){
		System.out.println(" 驾驶员图片删除");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		deletejiashiyuantupianlist = (List<String>) session.getAttribute("deletejiashiyuantupianlist");
		
//		得到传递的额外参数
		String fullpath = request.getParameter("fullpath");
//		 把删除的图片全路径添加到该集合对象
		deletejiashiyuantupianlist.add(fullpath);
		
		session.setAttribute("deletejiashiyuantupianlist", deletejiashiyuantupianlist);
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
	 *  驾驶证图片Ajax
	 */
	public void jiashizhengtupianAjax(){
		System.out.println("驾驶证图片Ajax");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		singlejiashiyuan = (JiaShiYuan) session.getAttribute("singlejiashiyuan");
		
//		得到图片的全部路径
		String fujianstr = singlejiashiyuan.getJiashizhengtupian();
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
	 *  驾驶证图片删除
	 */
	public void jiashizhengtupianDeleteFile(){
		System.out.println("驾驶证图片删除");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		deletejiashizhengtupianlist = (List<String>) session.getAttribute("deletejiashizhengtupianlist");
		
//		得到传递的额外参数
		String fullpath = request.getParameter("fullpath");
//		 把删除的图片全路径添加到该集合对象
		deletejiashizhengtupianlist.add(fullpath);
		
//		输出证件json模版对象
		
		session.setAttribute("deletejiashizhengtupianlist", deletejiashizhengtupianlist);
		
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
	 *  从业资格证图片Ajax
	 */
	public void congyezigezhengtupianAjax(){
		System.out.println("从业资格证图片Ajax");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		singlejiashiyuan =  (JiaShiYuan) session.getAttribute("singlejiashiyuan");
//		得到图片的全部路径
		String fujianstr = singlejiashiyuan.getCongyezigezhengtupian();
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
	 *  从业资格证图片删除
	 */
	public void congyezigezhengtupianDeleteFile(){
		System.out.println("从业资格证图片删除");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		deletecongyezigezhengtupianlist = (List<String>) session.getAttribute("deletecongyezigezhengtupianlist");
		
//		得到传递的额外参数
		String fullpath = request.getParameter("fullpath");
//		 把删除的图片全路径添加到该集合对象
		deletecongyezigezhengtupianlist.add(fullpath);
		
//		输出证件json模版对象
		session.setAttribute("deletecongyezigezhengtupianlist", deletecongyezigezhengtupianlist);
		
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
	 *  身份证图片Ajax
	 */
	public void shenfenzhengtupianAjax(){
		System.out.println("身份证图片Ajax");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		singlejiashiyuan = (JiaShiYuan) session.getAttribute("singlejiashiyuan");
		
//		得到图片的全部路径
		String fujianstr = singlejiashiyuan.getShenfenzhengtupian();
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
	 *  身份证图片删除
	 */
	public void shenfenzhengtupianDeleteFile(){
		System.out.println(" 身份证图片删除");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		deleteshenfenzhengtupianlist = (List<String>) session.getAttribute("deleteshenfenzhengtupianlist");
//		得到传递的额外参数
		String fullpath = request.getParameter("fullpath");
//		 把删除的图片全路径添加到该集合对象
		deleteshenfenzhengtupianlist.add(fullpath);
		
//		输出证件json模版对象
		session.setAttribute("deleteshenfenzhengtupianlist", deleteshenfenzhengtupianlist);
		
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
	
	
	
	
	
	public void exportJiaShiYuan(){

//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		
		
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.queryJiaShiYuan();
		
		if(jiashiyuanlist == null){
			return ;
		}
		
//		创建驾驶员模版集合对象
		List<JiaShiYuanModel> jiashiyuanmodellist = JiaShiYuanModel.getJiaShiYuanModelListExcel(jiashiyuanlist,yunDanService);
		
		JSONArray ja = JSONArray.fromObject(jiashiyuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
//	驾驶员审核 
	
	/**
	 *  跳转-驾驶员审核
	 */
	public String jumpJiaShiYuanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-驾驶员审核");

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		得到驾驶员业务对象
		
		
		jiashiyuanshenhelist = jiaShiYuanService.queryJiaShiYuan();
		request.setAttribute("jiashiyuanshenhelist", jiashiyuanshenhelist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		return "success";
	}
	
	
	/**
	 *  模糊查询驾驶员审核 
	 */
	public String vagueSearchJiaShiYuanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询驾驶员审核");

//		设置字符格式
		FontFormat.setFontFormat(response);			
		
		
		
		 jiashiyuanshenhelist = jiaShiYuanService.vagueSearchJiaShiYuanShenHe(jiashiyuanxingming, jiashicheliang, zhunjiachexing, shenhezhuangtai);
		request.setAttribute("jiashiyuanshenhelist", jiashiyuanshenhelist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	
	/**
	 *  驾驶员审核json 
	 */
	public void jiaShiYuanShenHeJson(){
		System.out.println("驾驶员审核json");

//		设置字符格式
		FontFormat.setFontFormat(response);	

//		判断是否为空
		if(jiashiyuanshenhelist == null){
			return ;
		}
		
//		得到驾驶员审核模版集合对象
		List<JiaShiYuanShenHeModel> jiashiyuanshenhemodellist = JiaShiYuanShenHeModel.getJiaShiYuanShenHeModelList(jiashiyuanshenhelist,request,usersService);
		
		JSONArray ja = JSONArray.fromObject(jiashiyuanshenhemodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	
	/**
	 *  驾驶员审核详细
	 */
	public String jiaShiYuanShenHeXiangXi(){
		System.out.println("驾驶员审核详细");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		String id = request.getParameter("id");
		
		 singlejiashiyuanshenhe = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(id));
		
		String jiashiyuantupian = singlejiashiyuanshenhe.getJiashiyuantupian();
		String jiashizhengtupian = singlejiashiyuanshenhe.getJiashizhengtupian();
		String congyezigezhengtupian =  singlejiashiyuanshenhe.getCongyezigezhengtupian();
		String shenfenzhengtupian = singlejiashiyuanshenhe.getShenfenzhengtupian();
		
		jiashiyuantupian = jiashiyuantupian.replaceAll("\\\\", "/");
		jiashizhengtupian = jiashizhengtupian.replaceAll("\\\\", "/");
		congyezigezhengtupian = congyezigezhengtupian.replaceAll("\\\\", "/");
		shenfenzhengtupian = shenfenzhengtupian.replaceAll("\\\\", "/");
		
		String jiashiyuantupianlist[] = jiashiyuantupian.split(",");
		jiashiyuantupianlist = FontFormat.deleteIndexStr(jiashiyuantupianlist, "uploads");
		
		String jiashizhengtupianlist[] = jiashizhengtupian.split(",");
		jiashizhengtupianlist = FontFormat.deleteIndexStr(jiashizhengtupianlist, "uploads");
		
		String congyezigezhengtupianlist[] = congyezigezhengtupian.split(",");
		congyezigezhengtupianlist = FontFormat.deleteIndexStr(congyezigezhengtupianlist, "uploads");
		
		String shenfenzhengtupianlist[] = shenfenzhengtupian.split(",");
		shenfenzhengtupianlist = FontFormat.deleteIndexStr(shenfenzhengtupianlist, "uploads");

		DeptController.sendDeptList(deptService);	
		request.setAttribute("singlejiashiyuanshenhe", singlejiashiyuanshenhe);
		
		request.setAttribute("jiashiyuantupianlist", jiashiyuantupianlist);
		request.setAttribute("jiashizhengtupianlist",jiashizhengtupianlist );
		request.setAttribute("congyezigezhengtupianlist", congyezigezhengtupianlist);
		request.setAttribute("shenfenzhengtupianlist", shenfenzhengtupianlist);
		
		return "success";
	}
	
	
	/**
	 *  跳转-修改驾驶员审核 
	 */
	public String jumpUpdateJiaShiYuanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-修改驾驶员审核");

//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1 || id.length>1){
			
			jiashiyuanshenhelist = jiaShiYuanService.queryJiaShiYuan();
			request.setAttribute("jiashiyuanshenhelist", jiashiyuanshenhelist);
			
			
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}
		
		
			
		 singlejiashiyuanshenhe = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(id[0]));
		 
		 
		
		String jiashiyuantupian = singlejiashiyuanshenhe.getJiashiyuantupian();
		String jiashizhengtupian = singlejiashiyuanshenhe.getJiashizhengtupian();
		String congyezigezhengtupian =  singlejiashiyuanshenhe.getCongyezigezhengtupian();
		String shenfenzhengtupian = singlejiashiyuanshenhe.getShenfenzhengtupian();
		
		jiashiyuantupian = jiashiyuantupian.replaceAll("\\\\", "/");
		jiashizhengtupian = jiashizhengtupian.replaceAll("\\\\", "/");
		congyezigezhengtupian = congyezigezhengtupian.replaceAll("\\\\", "/");
		shenfenzhengtupian = shenfenzhengtupian.replaceAll("\\\\", "/");
		
		String jiashiyuantupianlist[] = jiashiyuantupian.split(",");
		jiashiyuantupianlist = FontFormat.deleteIndexStr(jiashiyuantupianlist, "uploads");
		
		String jiashizhengtupianlist[] = jiashizhengtupian.split(",");
		jiashizhengtupianlist = FontFormat.deleteIndexStr(jiashizhengtupianlist, "uploads");
		
		String congyezigezhengtupianlist[] = congyezigezhengtupian.split(",");
		congyezigezhengtupianlist = FontFormat.deleteIndexStr(congyezigezhengtupianlist, "uploads");
		
		String shenfenzhengtupianlist[] = shenfenzhengtupian.split(",");
		shenfenzhengtupianlist = FontFormat.deleteIndexStr(shenfenzhengtupianlist, "uploads");

		DeptController.sendDeptList(deptService);	
		request.setAttribute("singlejiashiyuanshenhe", singlejiashiyuanshenhe);
		session.setAttribute("singlejiashiyuanshenhe", singlejiashiyuanshenhe);
		
		request.setAttribute("jiashiyuantupianlist", jiashiyuantupianlist);
		request.setAttribute("jiashizhengtupianlist",jiashizhengtupianlist );
		request.setAttribute("congyezigezhengtupianlist", congyezigezhengtupianlist);
		request.setAttribute("shenfenzhengtupianlist", shenfenzhengtupianlist);
		
		return "success";
	}
	
	
	/**
	 *  提交-修改驾驶员审核 
	 */
	public String submitUpdateJiaShiYuanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-修改驾驶员审核");

//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		
		singlejiashiyuanshenhe = (JiaShiYuan) session.getAttribute("singlejiashiyuanshenhe");
		
		Users users = (Users) session.getAttribute("users");		
		
		singlejiashiyuanshenhe.setShenhezhuangtai(shenhezhuangtai);
		singlejiashiyuanshenhe.setCaozuoyuan(users.getUsersid().toString());
		singlejiashiyuanshenhe.setCaozuoriqi(new Date());
		
		jiaShiYuanService.updateJiaShiYuan(singlejiashiyuanshenhe);
		
		jiashiyuanshenhelist = jiaShiYuanService.queryJiaShiYuan();
		request.setAttribute("jiashiyuanshenhelist", jiashiyuanshenhelist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		session.removeAttribute("singlejiashiyuanshenhe");
		
		return "success";
	}
	
	
	/**
	 * 导出驾驶员审核
	 */
	public void exportJiaShiYuanShenHe(){
//		设置字符格式
		FontFormat.setFontFormat(response);	

//		判断是否为空
		if(jiashiyuanshenhelist == null){
			return ;
		}
		
//		得到驾驶员审核模版集合对象
		List<JiaShiYuanShenHeModel> jiashiyuanshenhemodellist = JiaShiYuanShenHeModel.getJiaShiYuanShenHeModelListExcel(jiashiyuanshenhelist,request);
		
		JSONArray ja = JSONArray.fromObject(jiashiyuanshenhemodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	
//	驾驶员年审
	
	/**
	 * 跳转-驾驶员年审
	 */
	public String jumpJiaShiYuanNianShen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
//		得到传递的用户对象
		Users users = (Users) session.getAttribute("users");
//			判断是否为null
		if(users == null){
			return null;
		}
		
//		得到驾驶员业务对象
		
		
		jiashiyuannianshenlist  = jiaShiYuanService.queryCaoZuoYuan( users.getUsersid().toString() );
		request.setAttribute("jiashiyuannianshenlist", jiashiyuannianshenlist);
		
		return "success";
	}
	
	/**
	 * 驾驶员年审 json 
	 */
	public void JiaShiYuanNianShenJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
//		判断是否为空
		if(jiashiyuannianshenlist == null){
			return ;
		}
		
//		得到驾驶员审核模版集合对象
	    List<JiaShiYuanNianShenModel> list = JiaShiYuanNianShenModel.getJiaShiYuanNianShenModelList(jiashiyuannianshenlist , nianshenzhuangtaiValue);
		
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
	 *  模糊查询驾驶员年审
	 */
	public String vagueSearchJiaShiYuanNianShen(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
		
		
		jiashiyuannianshenlist = jiaShiYuanService.vagueSearchJiaShiYuanNianShen(jiashiyuanxingming, shenfenzhenghao, xiaoyuriqi, dayuriqi);
		
		nianshenzhuangtaiValue = nianshenzhuangtai;
		
		return "success";
	}
	
	
	/**
	 * 跳转-修改驾驶员年审
	 */
	public String jumpUpdateJiaShiYuanNianShen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-修改驾驶员审核");

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1 || id.length>1){
			jiashiyuannianshenlist  = jiaShiYuanService.queryJiaShiYuan();
			request.setAttribute("jiashiyuannianshenlist", jiashiyuannianshenlist);
			
			return "err";
		}
			
		singlejiashiyuannianshen = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(id[0]));
		request.setAttribute("singlejiashiyuannianshen", singlejiashiyuannianshen);
		session.setAttribute("singlejiashiyuannianshen", singlejiashiyuannianshen);
		 
		return "success";
	}
	
	
	/**
	 *  修改-驾驶员年审
	 */
	public String updateJiaShiYuanNianShen(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		singlejiashiyuannianshen = (JiaShiYuan) session.getAttribute("singlejiashiyuannianshen");
		
		Users users = (Users) session.getAttribute("users");	
		
		if(singlejiashiyuannianshen != null){
			singlejiashiyuannianshen.setJiashizhengnianshenriqi(jiashizhengnianshenriqi);
			singlejiashiyuannianshen.setZhengjianyouxiaoriqi(zhengjianyouxiaoriqi);
			singlejiashiyuannianshen.setCongyezigeriqi(congyezigeriqi);
			singlejiashiyuannianshen.setCongyezigejixujiaoyushijian(congyezigejixujiaoyushijian);
			singlejiashiyuannianshen.setCongyezigejixujiaoyushijianzhi(congyezigejixujiaoyushijianzhi);
			singlejiashiyuannianshen.setCongyezigechengxinkaoheshijian(congyezigechengxinkaoheshijian);
			
			singlejiashiyuannianshen.setCaozuoyuan( users.getUsersid().toString() );
			singlejiashiyuannianshen.setCaozuoriqi(new Date());
			
			jiaShiYuanService.updateJiaShiYuan(singlejiashiyuannianshen);
		}
		
		jiashiyuannianshenlist  = jiaShiYuanService.queryCaoZuoYuan(users.getUsersid().toString());
		request.setAttribute("jiashiyuannianshenlist", jiashiyuannianshenlist);
		
		return "success";
	}
	
	/**
	 * 驾驶员年审详细
	 */
	public String jiaShiYuanNianShenXiangXi(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
		
		String id = request.getParameter("id");
		
		singlejiashiyuannianshen = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(id));
		request.setAttribute("singlejiashiyuannianshen", singlejiashiyuannianshen);
		
		return "success";
	}
	
	/**
	 *  导出
	 */
	public void exportJiaShiYuanNianShen(){
//		设置字符格式
		FontFormat.setFontFormat(response);
		
//		判断是否为空
		if(jiashiyuannianshenlist == null){
			return ;
		}
		
//		得到驾驶员审核模版集合对象
	    List<JiaShiYuanNianShenModel> list = JiaShiYuanNianShenModel.exportJiaShiYuanNianShenModelList(jiashiyuannianshenlist , nianshenzhuangtaiValue);
		
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
	 *  get set
	 */
	public String getJiashiyuanxingming() {
		return jiashiyuanxingming;
	}
	public void setJiashiyuanxingming(String jiashiyuanxingming) {
		this.jiashiyuanxingming = jiashiyuanxingming;
	}
	public String getJiashicheliang() {
		return jiashicheliang;
	}
	public void setJiashicheliang(String jiashicheliang) {
		this.jiashicheliang = jiashicheliang;
	}
	public String getJiashiyuanleixing() {
		return jiashiyuanleixing;
	}
	public void setJiashiyuanleixing(String jiashiyuanleixing) {
		this.jiashiyuanleixing = jiashiyuanleixing;
	}
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public Date getChushengriqi() {
		return chushengriqi;
	}
	public void setChushengriqi(Date chushengriqi) {
		this.chushengriqi = chushengriqi;
	}
	public String getJiguan() {
		return jiguan;
	}
	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}
	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}
	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getZhunjiachexing() {
		return zhunjiachexing;
	}
	public void setZhunjiachexing(String zhunjiachexing) {
		this.zhunjiachexing = zhunjiachexing;
	}
	public Date getChucilingzhengriqi() {
		return chucilingzhengriqi;
	}
	public void setChucilingzhengriqi(Date chucilingzhengriqi) {
		this.chucilingzhengriqi = chucilingzhengriqi;
	}
	public Date getJiashizhengnianshenriqi() {
		return jiashizhengnianshenriqi;
	}
	public void setJiashizhengnianshenriqi(Date jiashizhengnianshenriqi) {
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
	}
	public String getDanganbianhao() {
		return danganbianhao;
	}
	public void setDanganbianhao(String danganbianhao) {
		this.danganbianhao = danganbianhao;
	}
	public String getCongyezigezhenghao() {
		return congyezigezhenghao;
	}
	public void setCongyezigezhenghao(String congyezigezhenghao) {
		this.congyezigezhenghao = congyezigezhenghao;
	}
	public String getCongyezigeleibie() {
		return congyezigeleibie;
	}
	public void setCongyezigeleibie(String congyezigeleibie) {
		this.congyezigeleibie = congyezigeleibie;
	}
	public Date getCongyezigejixujiaoyushijian() {
		return congyezigejixujiaoyushijian;
	}
	public void setCongyezigejixujiaoyushijian(Date congyezigejixujiaoyushijian) {
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
	}
	public Date getCongyezigechengxinkaoheshijian() {
		return congyezigechengxinkaoheshijian;
	}
	public void setCongyezigechengxinkaoheshijian(
			Date congyezigechengxinkaoheshijian) {
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
	}
	public Date getZhengjianyouxiaoriqi() {
		return zhengjianyouxiaoriqi;
	}
	public void setZhengjianyouxiaoriqi(Date zhengjianyouxiaoriqi) {
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getShenhezhuangtai() {
		return shenhezhuangtai;
	}
	public void setShenhezhuangtai(String shenhezhuangtai) {
		this.shenhezhuangtai = shenhezhuangtai;
	}
	public String getCheliangzhuangtai() {
		return cheliangzhuangtai;
	}
	public void setCheliangzhuangtai(String cheliangzhuangtai) {
		this.cheliangzhuangtai = cheliangzhuangtai;
	}

	public File[] getJiashiyuantupian() {
		return jiashiyuantupian;
	}

	public void setJiashiyuantupian(File[] jiashiyuantupian) {
		this.jiashiyuantupian = jiashiyuantupian;
	}

	public String[] getJiashiyuantupianFileName() {
		return jiashiyuantupianFileName;
	}

	public void setJiashiyuantupianFileName(String[] jiashiyuantupianFileName) {
		this.jiashiyuantupianFileName = jiashiyuantupianFileName;
	}

	public File[] getJiashizhengtupian() {
		return jiashizhengtupian;
	}

	public void setJiashizhengtupian(File[] jiashizhengtupian) {
		this.jiashizhengtupian = jiashizhengtupian;
	}

	public String[] getJiashizhengtupianFileName() {
		return jiashizhengtupianFileName;
	}

	public void setJiashizhengtupianFileName(String[] jiashizhengtupianFileName) {
		this.jiashizhengtupianFileName = jiashizhengtupianFileName;
	}

	public File[] getCongyezigezhengtupian() {
		return congyezigezhengtupian;
	}

	public void setCongyezigezhengtupian(File[] congyezigezhengtupian) {
		this.congyezigezhengtupian = congyezigezhengtupian;
	}

	public String[] getCongyezigezhengtupianFileName() {
		return congyezigezhengtupianFileName;
	}

	public void setCongyezigezhengtupianFileName(
			String[] congyezigezhengtupianFileName) {
		this.congyezigezhengtupianFileName = congyezigezhengtupianFileName;
	}

	public File[] getShenfenzhengtupian() {
		return shenfenzhengtupian;
	}

	public void setShenfenzhengtupian(File[] shenfenzhengtupian) {
		this.shenfenzhengtupian = shenfenzhengtupian;
	}

	public String[] getShenfenzhengtupianFileName() {
		return shenfenzhengtupianFileName;
	}

	public void setShenfenzhengtupianFileName(String[] shenfenzhengtupianFileName) {
		this.shenfenzhengtupianFileName = shenfenzhengtupianFileName;
	}

	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getJiashizhengbianhao() {
		return jiashizhengbianhao;
	}

	public void setJiashizhengbianhao(String jiashizhengbianhao) {
		this.jiashizhengbianhao = jiashizhengbianhao;
	}

	public Date getCongyezigeriqi() {
		return congyezigeriqi;
	}

	public void setCongyezigeriqi(Date congyezigeriqi) {
		this.congyezigeriqi = congyezigeriqi;
	}

	public String getFazhengjiguan() {
		return fazhengjiguan;
	}

	public void setFazhengjiguan(String fazhengjiguan) {
		this.fazhengjiguan = fazhengjiguan;
	}

	public Date getCongyezigejixujiaoyushijianzhi() {
		return congyezigejixujiaoyushijianzhi;
	}

	public void setCongyezigejixujiaoyushijianzhi(
			Date congyezigejixujiaoyushijianzhi) {
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
	}

	public Date getXiaoyuriqi() {
		return xiaoyuriqi;
	}

	public void setXiaoyuriqi(Date xiaoyuriqi) {
		this.xiaoyuriqi = xiaoyuriqi;
	}

	public Date getDayuriqi() {
		return dayuriqi;
	}

	public void setDayuriqi(Date dayuriqi) {
		this.dayuriqi = dayuriqi;
	}

	public String getNianshenzhuangtai() {
		return nianshenzhuangtai;
	}

	public void setNianshenzhuangtai(String nianshenzhuangtai) {
		this.nianshenzhuangtai = nianshenzhuangtai;
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

	public JiaShiYuanService getJiaShiYuanService() {
		return jiaShiYuanService;
	}

	public void setJiaShiYuanService(JiaShiYuanService jiaShiYuanService) {
		this.jiaShiYuanService = jiaShiYuanService;
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public CongYeZiGeService getCongYeZiGeService() {
		return congYeZiGeService;
	}

	public void setCongYeZiGeService(CongYeZiGeService congYeZiGeService) {
		this.congYeZiGeService = congYeZiGeService;
	}

	public YunDanService getYunDanService() {
		return yunDanService;
	}

	public void setYunDanService(YunDanService yunDanService) {
		this.yunDanService = yunDanService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	
	
}
