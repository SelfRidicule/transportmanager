package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.CheLiang;
import com.entity.JiaShiYuan;
import com.entity.Users;
import com.entity.WeiXianPin;
import com.entity.YingShouKuan;
import com.entity.YunDan;
import com.model.HuiZhiDanAndroidModel;
import com.model.PageServer;
import com.model.YunDanModel;
import com.model.YunDanModelAndroid;
import com.model.YunDanShenHeModel;
import com.myutils.FileManager;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianService;
import com.service.CheLiangService;
import com.service.CustomerService;
import com.service.FeiYongShouQuService;
import com.service.JiaShiYuanService;
import com.service.UsersService;
import com.service.WeiXianPinService;
import com.service.YingShouKuanService;
import com.service.YunDanService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *  运单控制层
 */
public class YunDanController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public YunDanController() {
		super();
	}

//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
 
	
	private CheLiangService cheLiangService;
	
	private CustomerService customerService;
	
	private YunDanService yunDanService;
	
	private YingShouKuanService yingShouKuanService;
	
	private WeiXianPinService weiXianPinService;
	
	private UsersService usersService;
	
	private JiaShiYuanService jiaShiYuanService;
	
	
	private FeiYongShouQuService feiYongShouQuService ;
		
	private BaoXianService baoXianService;
	
	
//	单一对象
	private  YunDan singleyundan;
	
//	集合对象
//	单一对象
	private  YunDan singleyundanshenhe;
	
	/**
	 * 属性
	 */
	private String dingdanhao;	//订单号
	private String chepaihao;	//车牌号
	private String kehudanwei;	//客户单位
	private String qidian;	//起点	
	private String zhongdian;	//终点
	private String dizhi;	//地址
	private String lianxiren;	//联系人
	private String baochouleixing;	//报酬类型
	private String baochoujine;	//报酬金额
	private String huowumingcheng;	//货物名称
	private String yujidunwei;	//预计吨位
	private String anquanka;	//安全卡
	private Date yunshushijian;	//运输时间
	private String yundanzhuangtai;	//运单状态
	private String beizhu;	//备注
	private String dianhua;	//电话
	private String shishouyunfei;	//实收运费
	
	private String yundanbeizhu;	//运单备注
	private String shishouleixing;	//实收类型
	
	/**
	 *  移动端-查询待接单的运单
	 * @throws Exception 
	 */
	public void androidYunDan() throws Exception{
		System.out.println("移动端-查询待接单的运单");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
//		得到运单业务对象
					
		
//		得到移动端传递的驾驶车辆（车牌号）
		String jiashicheliang = request.getParameter("jiashicheliang"); 
		
		List<YunDan> yundanlist = yunDanService.queryYunDanChePaiHaoAndDaiJieDan(jiashicheliang, "待接单");
//		如果是null
		if(yundanlist == null || "".equals(yundanlist)){
			try {
				PrintWriter pw = response.getWriter();
				pw.print("{}");
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}else{
//			得到运单对象
			YunDan yundan = yundanlist.get(0);
			
			YunDanModelAndroid yunDanModelAndroid = YunDanModelAndroid.getYunDanModelAndroid(yundan , weiXianPinService);
			
			Map<String, YunDanModelAndroid> map = new HashMap<String, YunDanModelAndroid>();
			
			map.put("yundan", yunDanModelAndroid);
			
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
	 *  移动端-查询已接单的运单
	 * @throws Exception 
	 */
	public void androidYunDanYiJieDan() throws Exception{
		System.out.println("移动端-查询已接单的运单");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
//		得到运单业务对象
					
		
//		得到移动端传递的驾驶车辆（车牌号）
		String jiashicheliang = request.getParameter("jiashicheliang"); 
		
		List<YunDan> yundanlist = yunDanService.queryYunDanChePaiHaoAndDaiJieDan(jiashicheliang, "已接单");
//		如果是null
		if(yundanlist == null || "".equals(yundanlist)){
			try {
				PrintWriter pw = response.getWriter();
				pw.print("{}");
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}else{
//			得到运单对象
			YunDan yundan = yundanlist.get(0);
			
			YunDanModelAndroid yunDanModelAndroid = YunDanModelAndroid.getYunDanModelAndroid(yundan,  weiXianPinService);
			
			Map<String, YunDanModelAndroid> map = new HashMap<String, YunDanModelAndroid>();
			
			map.put("yundan", yunDanModelAndroid);
			
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
	 *   移动端-是否接单
	 */
	public void yunDanJieShou(){
		System.out.println(" 移动端-是否接单");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
//		得到运单业务对象
					
		YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);

		Map<String, String> map = new HashMap<String, String>();
//		判断得到的运单是否为null
		if(yundan == null){
//			如果是空返回false
			map.put("flag", "false");
			JSONObject jo = JSONObject.fromObject(map);
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
			
			return ;
		}
		
//		如果运单状态为true
		if("true".equals(yundanzhuangtai)){
			yundan.setYundanzhuangtai("已接单");
		}
//		如果运单状态为false
		if("false".equals(yundanzhuangtai)){
			yundan.setYundanzhuangtai("拒接接单");
		}
//		修改运单状态
		yunDanService.updateYunDan(yundan);
		
//		返回true
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
	
	/**
	 *   移动端-运输中 （不用）
	 */
	/*public void androidYunShuZhong(){
		System.out.println(" 移动端-运输中");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
//		得到运单业务对象
					
		YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);

		Map<String, String> map = new HashMap<String, String>();
//		判断得到的运单是否为null
		if(yundan == null){
//			如果是空返回false
			map.put("flag", "false");
			JSONObject jo = JSONObject.fromObject(map);
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
			
			return ;
		}
		
//		修改运单
		yundan.setYundanzhuangtai(yundanzhuangtai);
		yunDanService.updateYunDan(yundan);
		
//		返回true
		map.put("flag", "true");
		
		JSONObject jo = JSONObject.fromObject(map);
		try {
			PrintWriter pw = response.getWriter();
			pw.print(jo);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}*/
	
	/**
	 *   移动端-运输结束
	 */
	public void androidYunShuJieShu(){
		System.out.println(" 移动端-运输结束");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
			
//		得到运单业务对象
					
		YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);

		Map<String, String> map = new HashMap<String, String>();
//		判断得到的运单是否为null
		if(yundan == null){
//			如果是空返回false
			map.put("flag", "false");
			JSONObject jo = JSONObject.fromObject(map);
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
			
			return ;
		}
		
//		修改运单
		yundan.setYundanzhuangtai(yundanzhuangtai);
		yunDanService.updateYunDan(yundan);
		
//		返回true
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
	
	/**
	 *  移动端-查询运输结束的运单
	 * @throws Exception 
	 */
	public void androidQueryYunShuJieShu() throws Exception{
		System.out.println("移动端-查询运输结束的运单");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
//		得到运单业务对象
					
		
//		得到移动端传递的驾驶车辆（车牌号）
		String jiashicheliang = request.getParameter("jiashicheliang"); 
		
		List<YunDan> yundanlist = yunDanService.queryYunDanChePaiHaoAndDaiJieDan(jiashicheliang, "运输结束");
//		如果是null
		if(yundanlist == null || "".equals(yundanlist)){
			try {
				PrintWriter pw = response.getWriter();
				pw.print("{}");
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}else{
//			得到运单对象
			YunDan yundan = yundanlist.get(0);
			
			YunDanModelAndroid yunDanModelAndroid = YunDanModelAndroid.getYunDanModelAndroid(yundan,  weiXianPinService);
			
			Map<String, YunDanModelAndroid> map = new HashMap<String, YunDanModelAndroid>();
			
			map.put("yundan", yunDanModelAndroid);
			
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
	 *  移动端-运单完成（且添加回执单的信息）
	 */
	public void androidYunDanWanCheng(){
		
		System.out.println(" 移动端-运单完成");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
			
//		得到运单业务对象
			
		
//		把json数据转换成对象
		String huizhidan = request.getParameter("huizhidan");
		System.out.println(huizhidan);
		JSONObject job = JSONObject.fromObject(huizhidan);
		HuiZhiDanAndroidModel huizhidanmodel = (HuiZhiDanAndroidModel) JSONObject.toBean(job,HuiZhiDanAndroidModel.class);
		
//		查询指定订单号的运单
		YunDan yundan = yunDanService.queryYunDanDingDanHao(huizhidanmodel.getDingdanhao());

		Map<String, String> map = new HashMap<String, String>();
//		判断得到的运单是否为null
		if(yundan == null){
//			如果是空返回false
			map.put("flag", "false");
			JSONObject jo = JSONObject.fromObject(map);
			try {
				PrintWriter pw = response.getWriter();
				pw.print(jo);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
			
			return ;
		}
		
		String shifadunwei=huizhidanmodel.getShifadunwei();
		String shishoudunwei=huizhidanmodel.getShishoudunwei();
		String licheng= huizhidanmodel.getLicheng();
		String daidianfei= huizhidanmodel.getDaidianfei();
		String feiyongmiaoshu = huizhidanmodel.getFeiyongmiaoshu();
//		修改运单
		yundan.setYunDanHuiZhiDan(shifadunwei, shishoudunwei, licheng, daidianfei, feiyongmiaoshu);
		yundan.setYundanzhuangtai("运单完成");
		yunDanService.updateYunDan(yundan);
		
//		添加营收款
		
		YingShouKuan yingshoukuan = new YingShouKuan();
		String dingdanhao = yundan.getDingdanhao();
		String shishouyunfei = yundan.getShishouyunfei();
		
		String yingshoukuanzhuangtai = "未开票";
		yingshoukuan.setYingShouKuan( dingdanhao,  "",  "",
				null,  "", null,
				 "",  "",  "",
				null,  "",
				 yingshoukuanzhuangtai,  "", null );
		
		String shishouleixing = yundan.getShishouleixing();
		if( "元每车".equals(shishouleixing) ){
			yingshoukuan.setYingshou(shishouyunfei);
			yingshoukuan.setDanjia("0");
		}else{
			yingshoukuan.setYingshou("0");
			yingshoukuan.setDanjia(shishouyunfei);
		}
		
		
		yingshoukuan.setKaipiaoshenqing("未申请");
		yingshoukuan.setFenguankaipiaoshenhe("未审核");
		yingshoukuan.setZongjinglikaipiaoshenhe("未审核");
		
		yingshoukuan.setJiesuanshenqing("未申请");
		yingshoukuan.setZongjinglijiesuanshenhe("未审核");
		yingshoukuan.setDongshizhangjiesuanshenhe("未审核");
		
		
		yingshoukuan.setJiesuanzhuangtai("未结算");
		yingshoukuan.setKehudanwei(yundan.getKehudanwei());
		
		yingShouKuanService.addYingShouKuan(yingshoukuan);
		
		
//		返回true
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
	
	/**
	 *  移动端-运单历史
	 */
	public void androidYunDanLiShi(){
		System.out.println("移动端-运单历史");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
//		得到运单业务对象
					
		
//		得到移动端传递的驾驶车辆（车牌号）
		String jiashicheliang = request.getParameter("jiashicheliang"); 
		
		List<YunDan> yundanlist = yunDanService.queryYunDanChePaiHaoAndDaiJieDan(jiashicheliang, "运单完成");
//		如果是null
		if(yundanlist == null || "".equals(yundanlist)){
			try {
				PrintWriter pw = response.getWriter();
				pw.print("{}");
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}else{
			
			List<YunDanModelAndroid> yunDanModelAndroidList = YunDanModelAndroid.getYunDanModelListAndroid(yundanlist);
			
			JSONArray ja = JSONArray.fromObject(yunDanModelAndroidList);
			try {
				PrintWriter pw = response.getWriter();
				pw.print(ja);
				pw.flush();
				pw.close();
			} catch (Exception e) {
			}
		}
		
	}
	
	
	/**
	 *  判断是否存在相同的订单号
	 */
	public void existYunDanDingDaoHao(){
		System.out.println("是否存在相同的订单号");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
//		得到运单业务对象
					
		
		int value = yunDanService.queryYunDanDingDanHaoShuLiang(dingdanhao);
		
		List  list = new ArrayList();
		Map<String, String> map = new HashMap<String, String>();
		
//		如果没有查到
		if(value<1){
//			如果小于1返回success
			map.put("flag", "success");
			list.add(map);
		}else{
//			如果大于或等于1返回err
			map.put("flag", "err");
			list.add(map);
		}
		
//		添加list对象
		JSONArray jo = JSONArray.fromObject(list);
//		输出
		try {
			PrintWriter pw = response.getWriter();
			pw.print(jo);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  跳转-运单
	 */
	public String jumpYunDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-运单");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		得到运单业务对象
					
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsersid().toString();
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}

	/**
	 *  模糊查询
	 */
	public void vagueSearchYunDan(){
		
		System.out.println("模糊查询运单");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到运单业务对象
					
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsersid().toString();
		
		//得到客户端传递的页码和每页记录数，并转换成int类型  
        String pageSize = "10";
        String pageNumber = "1";
		
		List<YunDan> yundanlist = yunDanService.vagueSearchYunDan(caozuoyuan,dingdanhao, yundanzhuangtai, chepaihao, qidian, zhongdian, huowumingcheng,  pageSize , pageNumber);
		
//		转换
		List<YunDanModel> yundanmodellist = YunDanModel.getYunDanModel(yundanlist, request);
		
		//查询数量
		Long Total = yunDanService.countSearchYunDan(caozuoyuan,dingdanhao, yundanzhuangtai, chepaihao, qidian, zhongdian, huowumingcheng,  pageSize , pageNumber);
		
		PageServer ps = new PageServer();
		ps.setRows(yundanmodellist);
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
	 *  运单json
	 */
	public void yunDanJson(){
		System.out.println("运单json");
		
//		设置字符格式
		FontFormat.setFontFormat(response);	
//		得到运单业务对象
					
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsersid().toString();
		
		//得到客户端传递的页码和每页记录数，并转换成int类型  
		String pageSize = request.getParameter("pageSize");  
        String pageNumber = request.getParameter("pageNumber");
		
		List<YunDan> yundanlist = yunDanService.vagueSearchYunDan(caozuoyuan,dingdanhao, yundanzhuangtai, chepaihao, qidian, zhongdian, huowumingcheng,  pageSize , pageNumber);
		
//		转换
		List<YunDanModel> yundanmodellist = YunDanModel.getYunDanModel(yundanlist, request);
		
		//查询数量
		Long Total = yunDanService.countSearchYunDan(caozuoyuan,dingdanhao, yundanzhuangtai, chepaihao, qidian, zhongdian, huowumingcheng,  pageSize , pageNumber);
		
		PageServer ps = new PageServer();
		ps.setRows(yundanmodellist);
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
	 *  运单详细
	 */
	public String yunDanXiangXi(){
		System.out.println("运单详细");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到运单业务对象
		
		
		
		String id = request.getParameter("id");
		YunDan singleyundan = yunDanService.queryYunDanId(Integer.valueOf(id));
		
		String anquankamingcheng = singleyundan.getAnquanka();
		WeiXianPin singleweixianpin = weiXianPinService.queryWeiXianPinInAnQuanKaMingCheng(anquankamingcheng);
		
		if(singleweixianpin != null){
			String anquanka = singleweixianpin.getAnquanka();
			anquanka = FileManager.formatFilePath(anquanka);
			singleweixianpin.setAnquanka(anquanka);
		}
		
		
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singleweixianpin", singleweixianpin);
		
		return "success";
	}
	
	/**
	 *  跳转-添加运单
	 */
	public String jumpAddYunDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		CustomerController.sendCustomer(customerService);
		
		WeiXianPinController.sendWeiXianPin(weiXianPinService);
		
		return "success";
	}
	
	
	/**
	 *  添加运单
	 */
	public String addYunDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到运单业务对象
			
//		得到用户对象
		Users users =  (Users) session.getAttribute("users");
		
//		判断车牌号的值是否为null
		if("未分配".equals(chepaihao)){
			chepaihao="";
			yundanzhuangtai="未分配";
		}else{
			yundanzhuangtai="已分配";
		}
		
		String caozuoyuan = users.getUsersid().toString();
		Date caozuoriqi = new Date();
		
		YunDan yundan = new YunDan();
		yundan.setYunDan( dingdanhao,  chepaihao,  kehudanwei,
				 qidian,  zhongdian,  dizhi, lianxiren,
				 baochouleixing, baochoujine,  huowumingcheng,
				 yujidunwei,  anquanka,  yunshushijian,
				 caozuoyuan,  caozuoriqi,  yundanzhuangtai);
		
		yundan.setDianhua(dianhua);
		
		yundan.setBeizhu("");
		
		yundan.setShishouyunfei(shishouyunfei);
		
		yundan.setYundanbeizhu(yundanbeizhu);
		
		yundan.setShishouleixing(shishouleixing);
		
		yunDanService.addYunDan(yundan);
		
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	
	/**
	 *  删除运单
	 */
	public String deleteYunDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("删除运单");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1){
			CheLiangController.sendCheLiang(cheLiangService);
			return "success";
		}	
		
		
		
			
		
		for (int i = 0; i < id.length; i++) {
//			查找指定id运单
			YunDan yundan = yunDanService.queryYunDanId( Integer.valueOf(id[i]) );
//			 得到运单号
			String dingdanhao = yundan.getDingdanhao();
//			查询指定订单号的营收款
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//			如果没有对应订单号的营收款 就把运单直接删除 
			if(yingshoukuan==null){
				yunDanService.deleteYunDan(Integer.valueOf(id[i]));
			}
//			如果营收款不是null
			if(yingshoukuan != null){
//				得到结算状态
				String jiesuanzhuangtai = yingshoukuan.getJiesuanzhuangtai();
//				如果没有结算,就把 运单 和 营收款 一并删除
				if(!"已结算".equals(jiesuanzhuangtai)){
					yunDanService.deleteYunDan(Integer.valueOf(id[i]));
					yingShouKuanService.deleteYingShouKuanId( yingshoukuan.getId() );
				}
			}
			
//			得到车牌号
			String chepaihao = yundan.getChepaihao();
//			查询指定车牌号的车辆
			CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
//			车辆不等于null
			if(cheliang != null){
//				同步车主姓名数据
				String chezhuxingming =  cheliang.getChezhuxingming();
				FeiYongShouQuController.SynchronizationFeiYongShouQu(chezhuxingming, feiYongShouQuService
						,  cheLiangService , yingShouKuanService
						,  yunDanService ,  baoXianService );
			}
		}
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  跳转-运单调度
	 */
	public String jumpYunDanDiaoDu(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-运单调度");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到保险id
		String id[] = request.getParameterValues("toolbar1");		
		if(id==null || id.length>1 || id.length<1){
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}	
				
//		得到运单业务对象
			
		
		 singleyundan = yunDanService.queryYunDanId(Integer.valueOf(id[0]));
		
		request.setAttribute("singleyundan", singleyundan);
		
		session.setAttribute("singleyundan", singleyundan);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  提交运单调度
	 */
	public String submitYunDanDiaoDu(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 提交运单调度");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到运单业务对象
			
		Users users = (Users) session.getAttribute("users");
		
		singleyundan = (YunDan) session.getAttribute("singleyundan");
		
//		判断车牌号的值是否为null
		if("未分配".equals(chepaihao)){
			chepaihao="";
			yundanzhuangtai="未分配";
		}else{
			yundanzhuangtai="已分配";
		}
		
		singleyundan.setYunDan(dingdanhao,  chepaihao,  kehudanwei,
				 qidian,  zhongdian,  dizhi, lianxiren,
				 baochouleixing, baochoujine,  huowumingcheng,
				 yujidunwei,  anquanka,  yunshushijian,
				 singleyundan.getCaozuoyuan(),  new Date(),  yundanzhuangtai);
		
		singleyundan.setDianhua(dianhua);
		
		singleyundan.setShishouyunfei(shishouyunfei);
		
		singleyundan.setYundanbeizhu(yundanbeizhu);
		
		singleyundan.setShishouleixing(shishouleixing);
		
		yunDanService.updateYunDan(singleyundan);
		

		
		String caozuoyuan = users.getUsername();
		
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		session.removeAttribute("singleyundan");
		
		return "success";
	}
	
	/**
	 *  跳转-修改运单
	 */
	public String jumpUpdateYunDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-修改运单");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到保险id
		String id[] = request.getParameterValues("toolbar1");		
		if(id==null || id.length>1 || id.length<1){
			request.setAttribute("yundanerr", "请选择一个运单进行修改");
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}	
	
//		得到运单业务对象
			
		
		 singleyundan = yunDanService.queryYunDanId(Integer.valueOf(id[0]));
		
		request.setAttribute("singleyundan", singleyundan);
		
		session.setAttribute("singleyundan", singleyundan);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		CustomerController.sendCustomer(customerService);
		
		WeiXianPinController.sendWeiXianPin(weiXianPinService);
		
		return "success";
	}
	
	/**
	 *  提交-修改运单
	 */
	public String submitUpdateYunDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("提交-修改运单");
//		设置字符格式
		FontFormat.setFontFormat(response);				
//		得到运单业务对象
			
//		得到用户对象
		Users users =  (Users) session.getAttribute("users");
		
		singleyundan = (YunDan) session.getAttribute("singleyundan");
		
//		先把自身运单状态得到
		yundanzhuangtai = singleyundan.getYundanzhuangtai();
		
//		判断车牌号的值是否为null
		if("未分配".equals(chepaihao) && "未分配".equals(singleyundan.getYundanzhuangtai()) ){
			yundanzhuangtai="未分配";
		}else if( !"未分配".equals(chepaihao) && "未分配".equals(singleyundan.getYundanzhuangtai())  ){
			yundanzhuangtai="已分配";
		}
//		判断是否选中车牌号
		if( "未分配".equals(chepaihao) ){
			chepaihao = "";
		}
		
		Date caozuoriqi = new Date();
		
		singleyundan.setYunDan(dingdanhao,  chepaihao,  kehudanwei,
				 qidian,  zhongdian,  dizhi, lianxiren,
				 baochouleixing, baochoujine,  huowumingcheng,
				 yujidunwei,  anquanka,  yunshushijian,
				 singleyundan.getCaozuoyuan(),  caozuoriqi,  yundanzhuangtai);
		singleyundan.setDianhua(dianhua);
		
		singleyundan.setShishouyunfei(shishouyunfei);
		
		singleyundan.setYundanbeizhu(yundanbeizhu);
		
		singleyundan.setShishouleixing(shishouleixing);
		
		yunDanService.updateYunDan(singleyundan);
		
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		session.removeAttribute("singleyundan");
		
		return "success";
	}
	
	/**
	 *  再次提交-修改运单状态
	 */
	public String againSubmit(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("再次提交-修改运单状态");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		String id[] = request.getParameterValues("toolbar1");
		if(id == null || id.length<1 ||id.length>1){
			request.setAttribute("yundanerr", "请选择一个运单进行申请");
			CheLiangController.sendCheLiang(cheLiangService);
			return "success";
		}
				
//		得到运单业务对象
				
		Users users = (Users) session.getAttribute("users");
		
	 	YunDan yundan = yunDanService.queryYunDanId(Integer.valueOf(id[0]));
//		判断运单状态是否符合
	 	String yundanzhuangtai = yundan.getYundanzhuangtai();
		if( !"未分配".equals(yundanzhuangtai) && !"已分配".equals(yundanzhuangtai) && !"未通过".equals(yundanzhuangtai) ){
			request.setAttribute("yundanerr", "运单已经进行不可修改");
			return "success";
		}
	 	
	 	yundan.setYundanzhuangtai("审批中");
	 	yundan.setCaozuoriqi(new Date());
	 	yunDanService.updateYunDan(yundan);
		
	 	 
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  跳转-运单调换
	 */
	public String jumpYunDanDiaoHuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-运单调换 ");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到保险id
		String id[] = request.getParameterValues("toolbar1");		
		if(id==null || id.length>1 || id.length<1){
			request.setAttribute("yundanerr", "请选择一个运单进行调换");
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}	
	
//		得到运单业务对象
			
		
		 singleyundan = yunDanService.queryYunDanId(Integer.valueOf(id[0]));
		 
		 String yundanzhuangtai = singleyundan.getYundanzhuangtai();
		if("运输结束".equals(yundanzhuangtai) || "运单完成".equals(yundanzhuangtai)){
			request.setAttribute("yundanerr", "请选择未完成和未结束的运单");
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}
		 
		request.setAttribute("singleyundan", singleyundan);
		session.setAttribute("singleyundan", singleyundan);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		CustomerController.sendCustomer(customerService);
		
		WeiXianPinController.sendWeiXianPin(weiXianPinService);
		
		return "success";
	}
	
	/**
	 *  提交-运单调换
	 */
	public String yunDanDiaoHuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("提交-修改运单");
//		设置字符格式
		FontFormat.setFontFormat(response);				
//		得到运单业务对象
			
//		得到用户对象
		Users users =  (Users) session.getAttribute("users");
		
		singleyundan = (YunDan) session.getAttribute("singleyundan");
		
//		先把自身运单状态得到
		yundanzhuangtai = singleyundan.getYundanzhuangtai();
		
//		判断车牌号的值是否为null
		if("未分配".equals(chepaihao)){
			yundanzhuangtai="未分配";
		}else if( !"未分配".equals(chepaihao)){
			yundanzhuangtai="已分配";
		}
//		判断是否选中车牌号
		if( "未分配".equals(chepaihao) ){
			chepaihao = "";
		}
		
		Date caozuoriqi = new Date();
		
		singleyundan.setYunDan(dingdanhao,  chepaihao,  kehudanwei,
				 qidian,  zhongdian,  dizhi, lianxiren,
				 baochouleixing, baochoujine,  huowumingcheng,
				 yujidunwei,  anquanka,  yunshushijian,
				 singleyundan.getCaozuoyuan(),  caozuoriqi,  yundanzhuangtai);
		singleyundan.setDianhua(dianhua);
		
		singleyundan.setShishouyunfei(shishouyunfei);
		
		singleyundan.setYundanbeizhu(yundanbeizhu);
		
		singleyundan.setShishouleixing(shishouleixing);
		
		yunDanService.updateYunDan(singleyundan);
		
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		session.removeAttribute("singleyundan");
		
		return "success";
	}
	
	/**
	 *  ajax-安全卡  没用
	 */
	/*public void ajaxAnQuanKa(){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
		
		
		
		String anquankamingcheng = request.getParameter("anquanka");
		WeiXianPin weixianpin = weiXianPinService.queryWeiXianPinInAnQuanKaMingCheng(anquankamingcheng);
		
		JSONArray ja = JSONArray.fromObject(weixianpin);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}*/
	
//	运单审核
	
	/**
	 *  跳转-运单审核
	 */
	public String jumpYunDanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-运单审核");
//		设置字符格式
		FontFormat.setFontFormat(response);				
//		得到运单业务对象
			
		Users users = (Users) session.getAttribute("users");
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  模糊查询运单审核
	 */
	public void vagueSearchYunDanShenHe(){
		System.out.println("模糊查询运单审核");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到运单业务对象
					
		Users users = (Users) session.getAttribute("users");
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
	}	
	
	/**
	 *  运单审核json
	 */
	public void YunDanShenHeJson(){
		System.out.println("运单审核json");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		得到运单业务对象
					
		Users users = (Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsersid().toString();
		
		//得到客户端传递的页码和每页记录数，并转换成int类型  
		String pageSize = request.getParameter("pageSize");  
        String pageNumber = request.getParameter("pageNumber");
		
		List<YunDan> yundanshenhelist = yunDanService.vagueSearchYunDan(caozuoyuan,dingdanhao, yundanzhuangtai, chepaihao, qidian, zhongdian, huowumingcheng,  pageSize , pageNumber);
		
//		转换
		List<YunDanShenHeModel> yunDanShenHeModelList =  YunDanShenHeModel.getYunDanShenHeModelList(yundanshenhelist);
		
		//查询数量
		Long Total = yunDanService.countSearchYunDan(caozuoyuan,dingdanhao, yundanzhuangtai, chepaihao, qidian, zhongdian, huowumingcheng,  pageSize , pageNumber);
		
		PageServer ps = new PageServer();
		ps.setRows(yunDanShenHeModelList);
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
	 *  运单审核详细
	 */
	public String yunDanShenHeXiangXi(){
		System.out.println("运单审核详细");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到保险id
		String id = request.getParameter("id");	
//		得到运单业务对象
			
//		得到驾驶员业务对象
		
//		创建用户业务对象
			

		 singleyundanshenhe = yunDanService.queryYunDanId(Integer.valueOf(id));
		
		String chepaihao = singleyundanshenhe.getChepaihao();
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.queryJiaShiYuanChePaiHao(chepaihao);
		
		String jiashiyuanxingming = "";
		for (int i = 0; i < jiashiyuanlist.size(); i++) {
			jiashiyuanxingming=jiashiyuanxingming+jiashiyuanlist.get(i).getJiashiyuanxingming()+",";
		}
		
		String caozuoyuanId = singleyundanshenhe.getCaozuoyuan();
		try {
			Users user = usersService.queryId( Integer.valueOf(caozuoyuanId) );
			String caoZuoYuanName = user.getUsername(); 
			
			request.setAttribute("caoZuoYuanName", caoZuoYuanName);
		} catch (Exception e) {
		}
		
		
		request.setAttribute("singleyundanshenhe", singleyundanshenhe);
		request.setAttribute("jiashiyuanxingming", jiashiyuanxingming);
		
		return "success";
	}
	
	/**
	 *  修改运单审核
	 */
	public String updateYunDanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改运单审核");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到保险id
		String id[] = request.getParameterValues("toolbar1");		
		if(id==null || id.length>1 || id.length<1){
			request.setAttribute("yundanshenheerr", "请选择一个进行审核");
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}	
				
//		得到运单业务对象
			
//		得到驾驶员业务对象
		
		
		 singleyundanshenhe = yunDanService.queryYunDanId(Integer.valueOf(id[0]));
//		判断运单状态是否符合
		String yundanzhuangtai = singleyundanshenhe.getYundanzhuangtai();
		if( !"审批中".equals(yundanzhuangtai) ){
			request.setAttribute("yundanshenheerr", "请选择审批中的运单");
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}
		
		String chepaihao = singleyundanshenhe.getChepaihao();
		List<JiaShiYuan> jiashiyuanlist = jiaShiYuanService.queryJiaShiYuanChePaiHao(chepaihao);
		
		String jiashiyuanxingming = "";
		for (int i = 0; i < jiashiyuanlist.size(); i++) {
			jiashiyuanxingming=jiashiyuanxingming+jiashiyuanlist.get(i).getJiashiyuanxingming()+",";
		}
		
		
		request.setAttribute("singleyundanshenhe", singleyundanshenhe);
		session.setAttribute("singleyundanshenhe", singleyundanshenhe);
		
		request.setAttribute("jiashiyuanxingming", jiashiyuanxingming);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  提交-修改运单审核
	 */
	public String submitUpdateYunDanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("提交-修改运单审核");
//		设置字符格式
		FontFormat.setFontFormat(response);				
//		得到运单业务对象
		
		singleyundanshenhe = (YunDan) session.getAttribute("singleyundanshenhe");

		Users users = (Users) session.getAttribute("users");
		
		singleyundanshenhe.setBeizhu(beizhu);
		singleyundanshenhe.setYundanzhuangtai(yundanzhuangtai);
		singleyundanshenhe.setCaozuoriqi(new Date());
		
		yunDanService.updateYunDan(singleyundanshenhe);
		
		String caozuoyuan = users.getUsersid().toString();
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		session.removeAttribute("singleyundanshenhe");
		
		return "success";
	}
	
	/**
	 *  get set
	 */
	public String getDingdanhao() {
		return dingdanhao;
	}


	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}


	public String getChepaihao() {
		return chepaihao;
	}


	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}


	public String getKehudanwei() {
		return kehudanwei;
	}


	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}


	public String getQidian() {
		return qidian;
	}


	public void setQidian(String qidian) {
		this.qidian = qidian;
	}


	public String getZhongdian() {
		return zhongdian;
	}


	public void setZhongdian(String zhongdian) {
		this.zhongdian = zhongdian;
	}


	public String getDizhi() {
		return dizhi;
	}


	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}


	public String getLianxiren() {
		return lianxiren;
	}


	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}


	public String getBaochouleixing() {
		return baochouleixing;
	}


	public void setBaochouleixing(String baochouleixing) {
		this.baochouleixing = baochouleixing;
	}


	public String getBaochoujine() {
		return baochoujine;
	}


	public void setBaochoujine(String baochoujine) {
		this.baochoujine = baochoujine;
	}


	public String getHuowumingcheng() {
		return huowumingcheng;
	}


	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}


	public String getYujidunwei() {
		return yujidunwei;
	}


	public void setYujidunwei(String yujidunwei) {
		this.yujidunwei = yujidunwei;
	}


	public String getAnquanka() {
		return anquanka;
	}


	public void setAnquanka(String anquanka) {
		this.anquanka = anquanka;
	}


	public Date getYunshushijian() {
		return yunshushijian;
	}


	public void setYunshushijian(Date yunshushijian) {
		this.yunshushijian = yunshushijian;
	}


	public String getYundanzhuangtai() {
		return yundanzhuangtai;
	}


	public void setYundanzhuangtai(String yundanzhuangtai) {
		this.yundanzhuangtai = yundanzhuangtai;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}


	public String getDianhua() {
		return dianhua;
	}


	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	

	public String getShishouyunfei() {
		return shishouyunfei;
	}
	

	public void setShishouyunfei(String shishouyunfei) {
		this.shishouyunfei = shishouyunfei;
	}

	public String getYundanbeizhu() {
		return yundanbeizhu;
	}

	public void setYundanbeizhu(String yundanbeizhu) {
		this.yundanbeizhu = yundanbeizhu;
	}

	public String getShishouleixing() {
		return shishouleixing;
	}

	public void setShishouleixing(String shishouleixing) {
		this.shishouleixing = shishouleixing;
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

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public YunDanService getYunDanService() {
		return yunDanService;
	}

	public void setYunDanService(YunDanService yunDanService) {
		this.yunDanService = yunDanService;
	}

	public YingShouKuanService getYingShouKuanService() {
		return yingShouKuanService;
	}

	public void setYingShouKuanService(YingShouKuanService yingShouKuanService) {
		this.yingShouKuanService = yingShouKuanService;
	}

	public WeiXianPinService getWeiXianPinService() {
		return weiXianPinService;
	}

	public void setWeiXianPinService(WeiXianPinService weiXianPinService) {
		this.weiXianPinService = weiXianPinService;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public JiaShiYuanService getJiaShiYuanService() {
		return jiaShiYuanService;
	}

	public void setJiaShiYuanService(JiaShiYuanService jiaShiYuanService) {
		this.jiaShiYuanService = jiaShiYuanService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FeiYongShouQuService getFeiYongShouQuService() {
		return feiYongShouQuService;
	}

	public void setFeiYongShouQuService(FeiYongShouQuService feiYongShouQuService) {
		this.feiYongShouQuService = feiYongShouQuService;
	}

	public BaoXianService getBaoXianService() {
		return baoXianService;
	}

	public void setBaoXianService(BaoXianService baoXianService) {
		this.baoXianService = baoXianService;
	}

	
	
	
}

