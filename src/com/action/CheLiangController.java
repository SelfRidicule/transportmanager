package com.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

import com.entity.BaoXian;
import com.entity.CheLiang;
import com.entity.CheLiangBeiFen;
import com.entity.CheLiangGuanLi;
import com.entity.CheLiangGuanXi;
import com.entity.JiaShiYuan;
import com.entity.NianShen;
import com.entity.Users;
import com.model.CheLiangJsonModel;
import com.model.CheLiangServer;
import com.myjson.ZhengJianJson;
import com.myutils.FileManager;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianService;
import com.service.CheLiangBeiFenService;
import com.service.CheLiangGuanLiService;
import com.service.CheLiangGuanXiService;
import com.service.CheLiangService;
import com.service.FeiYongShouQuService;
import com.service.JiaShiYuanService;
import com.service.NianShenService;
import com.service.UsersService;
import com.service.YingShouKuanService;
import com.service.YunDanService;
import com.service.ZhengJianService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 车辆控制层
 */
public class CheLiangController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 构造方法
	 */
	public CheLiangController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	
	
	private CheLiangService cheLiangService;
	
	private JiaShiYuanService jiaShiYuanService;
	
	private UsersService usersService;
	
	private CheLiangGuanLiService cheLiangGuanLiService;
	
	private CheLiangGuanXiService cheLiangGuanXiService;
	
	private CheLiangBeiFenService cheLiangBeiFenService;
	
	private BaoXianService baoXianService;
	
	private NianShenService nianShenService;
	
	private ZhengJianService zhengJianService;
	
	
	private FeiYongShouQuService feiYongShouQuService ;
	
	private YingShouKuanService yingShouKuanService ;
	
	private YunDanService yunDanService ; 
	
	
	
//	得到车辆对象
	private  CheLiang singlecheliang ;
//	车辆备份
	private  CheLiangBeiFen singlecheliangbeifen;
//	查询指定车牌号和保险类型的对象
	private  BaoXian singlejiaoqiangxian; 
	private  BaoXian singleshangyexian ;
	private  BaoXian singlechengyunrenzerenxian; 
	private  BaoXian singleguzhuzerenxian ;
	private  BaoXian singletuantiyiwaixian ;
	private  BaoXian singlechechuanxian ;
	
	/**
	 *  属性
	 */
	private String  chepaihao; //车牌号
	private String  chezhuxingming; //车主姓名
	private String  shoujihao ; //手机号
	private String 	jiayayuan1; //驾押员1
	private String 	jiayayuan2; //驾押员2
	private String  chexing ; //车型
	private String 	cheliangleixing ; //车辆类型
	private String  pingpaixinghao ; //品牌型号
	private String  shibiedaihao ;  //识别代号
	private String  fadongjihao ;  //发动机号
	private String  zongzhiliang ; //总质量  
	private String  zhengbeizhiliang ; //整备质量
	private String  hedingzhaizhiliang ; //核定载质量
	private String  zhunqianyingzongzhiliang ; //准牵引总质量
	private String  cheliangdaoluyunshuzhenghao; //车辆道路运输证号
	private Date    zhuceriqi ; //注册日期
	private Date    nianshenriqi ; //年审日期
	private Date    erjiweihuriqi ; //二级维护日期
	private Date    daoluyunshuzhengnianshenriqi; //道路运输证年审日期
	private String  yonghumiaoshu;   //用户描述
	private String  jingyingfanwei ;   //经营范围
	private String  zhuangtai;	//状态
	private Date 	guantijianceriqi;	//罐体检测日期
	private Date	dengjipingdingriqi;	//等级评定日期
	private String  chang;	//长
	private String  kuan;	//宽
	private String  gao;	//高
	
	private String shenfenzhenghao;	//身份证号
	private File   picture[];		//图片file类
	private String pictureFileName[];	//图片file名称
	private String pictureContentType[];	//图片file类型
	
	private String zhengshubianhao;	//证书编号
	private String cheshenyanse;	//车身颜色
	private String fadongjixinghao;	//发动机型号
	private String ranliaozhonglei;	//燃料种类
	private String pailiang;	//排量
	private String gonglv;	//功率
	private String changjiamingcheng;	//厂家名称
	private String lunjuqian;	//轮距前
	private String lunjuhou;	//轮距后
	private String luntaishu;	//轮胎数
	private String luntaiguige;	//轮胎规格
	private String gangbantanhuangpianshu;	//钢板弹簧片数
	private String zhouju;	//轴距
	private String zhoushu;	//轴数
	private String huoxiangchang;	//货箱长
	private String huoxiangkuan;	//货箱宽
	private String huoxianggao;		//货箱高
	private String cheliangfenzu;	//车辆分组
	
	private String gouchefei;	//够车费
	
//	交强险
	private String jiaoqiangxianbaodanhao;	//交强险保单号
	private String jiaoqiangxianfeiyong; //交强险费用
	private Date   jiaoqiangxiandaoqishijian; //交强险到期时间
	private String jiaoqiangxiangongsi;	//交强险公司
	
//	商业险
	private String shangyexianbaodanhao;	//商业险保单号
	private String shangyexianfeiyong;		//商业险保险费用
	private Date   shangyexiandaoqishijian;	//商业险保险到期时间
	private String shangyexiangongsi;	//商业险公司
	
//	承运人责任险
	private String chengyunrenbaodanhao;	//承运人保单号
	private String chengyunrenfeiyong;		//承运人保险费用
	private Date   chengyunrendaoqishijian;	//承运人保险到期时间
	private String chengyunrengongsi;	//承运人公司
	
//	雇主责任险
	private String guzhubaodanhao;	//雇主保单号
	private String guzhufeiyong;	//雇主保险费用
	private Date   guzhudaoqishijian;	//雇主保险到期时间
	private String guzhugongsi;	//雇主公司
	
//	团体意外险
	private String tuantixianbaodanhao;	//团体意外险保单号
	private String tuantixianfeiyong;	//团体意外险费用
	private Date   tuantixiandaoqishijian;	//团体意外险到期时间
	private String tuantigongsi;	//团体公司
	
//	车船险
	private String chechuanxianbaodanhao;	//车船险保单号
	private String chechuanxianfeiyong;	//车船险费用
	private Date   chechuanxiandaoqishijian;	//车船险到期时间
	private String chechuanxiangongsi;	//车船险公司
	
	private  ArrayList<String> picturepathlist = new ArrayList<String>();	//添加图片集合对象
	private  ArrayList<String> deletezhengjianlist = new ArrayList<String>(); //删除图片集合对象
	
	
	/**
	 *  格式化驾驶员姓名 （把车辆里的驾驶员姓名 转换成 ）
	 */
	public void formatJiaShiYuanXingMing(){
//		设置字符格式
		FontFormat.setFontFormat(response);
		
			
//		得到驾驶员业务对象
		
		
		List<CheLiang> chelianglist =  cheLiangService.queryCheLiangList(); 
		
		for (int i = 0; i < chelianglist.size(); i++) {
			
			CheLiang cheliang =  chelianglist.get(i);
			
			String jiashiyuan1 =  cheliang.getJiayayuan1();
			String jiashiyuan2 =  cheliang.getJiayayuan2();

			if(jiashiyuan1 != null  && !"".equals(jiashiyuan1) ){
				try {
					
					JiaShiYuan jiashiyuan =  jiaShiYuanService.queryJiaShiYuanName(jiashiyuan1);
					
					cheliang.setJiayayuan1(jiashiyuan.getId().toString());
					
					cheLiangService.updateCheLiang(cheliang);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			if(jiashiyuan2 != null  && !"".equals(jiashiyuan2) ){
				try {
					
					JiaShiYuan jiashiyuan =  jiaShiYuanService.queryJiaShiYuanName(jiashiyuan2);
					
					cheliang.setJiayayuan2(jiashiyuan.getId().toString());
					
					cheLiangService.updateCheLiang(cheliang);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
		
	}
	
	/**
	 *  跳转-车辆
	 */
	public String jumpCheLiang(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-车辆");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
				
		
		
//		发送车辆管理集合对象
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
		
//		发送驾驶员集合对象
		JiaShiYuanController.sendJiaShiYuan(jiaShiYuanService);
		
//		发送用户集合对象
		UsersController.sendUsersByDeptName(usersService,"安全科");
		
		return "success";
	}
	
	
	/**
	 * 返回-车辆
	 */
	public String returnCheLiang(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("返回-车辆");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
//		发送车辆管理集合对象
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
		
//		发送驾驶员集合对象
		JiaShiYuanController.sendJiaShiYuan(jiaShiYuanService);
		
//		发送用户集合对象
		UsersController.sendUsersByDeptName(usersService,"安全科");
		
		return "success";
	}
	
	/**
	 *  验证车牌号
	 */
	public void verificationChePaiHao(){
//		设置字符格式
		FontFormat.setFontFormat(response);
		
			
		
		CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		
		Map map = new HashMap();
		
		if(cheliang != null){
			map.put("flag", "err");
		}else{
			map.put("flag", "success");
		}
		
		JSONArray ja = JSONArray.fromObject(map);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	
	/**
	 *  上传文件
	 */
	public void cheLiangUploadFile(){
		System.out.println("文件上传");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到存放图片指定路径,chepaihao是前端传递的参数
		String path = request.getRealPath("/uploads/cheliangtupian");
		try {
			for (int i = 0; i < picture.length; i++) {
				
				String filename = System.currentTimeMillis() + pictureFileName[i];
				
				String fujianpath =path+"\\"+filename+",";
				
				picturepathlist = (ArrayList<String>) session.getAttribute("picturepathlist");
				
				picturepathlist.add(fujianpath);
				
				session.setAttribute("picturepathlist", picturepathlist);
				
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
	 *  删除文件
	 */
	public void cheLiangDeleteFile(){
		System.out.println("删除文件");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
//		得到传递的额外参数
		String fullpath = request.getParameter("fullpath");
//		 把删除的图片全路径添加到该集合对象
		deletezhengjianlist = (ArrayList<String>) session.getAttribute("deletezhengjianlist");
		
		deletezhengjianlist.add(fullpath);
		
		session.setAttribute("deletezhengjianlist", deletezhengjianlist);
		
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
	 *  图片显示ajax
	 */
	public void cheLiangViewAjax(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

		singlecheliang = (CheLiang) session.getAttribute("singlecheliang");
		
//		得到图片的全部路径
		String fujianstr = singlecheliang.getShenfenzhengtupian();
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
	 *  备份图片显示ajax
	 */
	public void cheLiangCopyViewAjax(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

		singlecheliangbeifen = (CheLiangBeiFen) session.getAttribute("singlecheliangbeifen");
		
//		得到图片的全部路径
		if(singlecheliangbeifen==null){
			return ;
		}
		
		String fujianstr = singlecheliangbeifen.getShenfenzhengtupian();
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
	 * ajax添加 车辆类型
	 */
	public void addAjaxCheLiangLeiXing(){
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String data = request.getParameter("data");
		String type = request.getParameter("type");
		String shijileixing = request.getParameter("shijileixing");
		
		
		
//		添加车辆管理
		CheLiangGuanLi cheliangguanli = new CheLiangGuanLi();
		cheliangguanli.setCheLiangGuanLi(type, data);
		cheliangguanli.setShijileixing(shijileixing);
//		添加车辆管理并 返回id		
		Integer id = cheLiangGuanLiService.addCheLiangGuanLiReturnId(cheliangguanli);
		
//		发送车辆集合
		CheLiangGuanLi sendclgl = new CheLiangGuanLi();
		sendclgl.setCheLiangGuanLi(type, data);
		sendclgl.setId(id);
		
		List< CheLiangGuanLi > cheliangguanlilist = new ArrayList<CheLiangGuanLi>();
		cheliangguanlilist.add(sendclgl);
		
		JSONArray ja = JSONArray.fromObject(cheliangguanlilist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}

	/**
	 *  发送车辆集合
	 */
	public static void sendCheLiang(CheLiangService cheLiangService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
//		设置字符格式
		FontFormat.setFontFormat(response);
//		加载applicationContext.xml文件
			
		
				
		
		List<CheLiang> chelianglist = cheLiangService.queryCheLiangList();
		
		request.setAttribute("chelianglist", chelianglist);
	}
	
	/**
	 *  模糊查询
	 */
	public void vagueSearchCheLiang(){
		
		System.out.println("模糊查询车辆");

//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		//得到客户端传递的页码和每页记录数，并转换成int类型  
        String pageSize = "10";
        String pageNumber = "1";
		
		String mycaozuoyuan = request.getParameter("caozuoyuan");
		
//		业务对象
				
		
		List<CheLiang> chelianglist = cheLiangService.vagueSearchCheLiang(chepaihao, chexing, cheliangleixing, pingpaixinghao, zhuangtai, mycaozuoyuan ,  pageSize , pageNumber);
		

		
//		创建用户业务对象
			
		
//		得到驾驶员业务对象
		
		
//		创建车辆模版集合对象
		ArrayList<CheLiangJsonModel> cheliangjsonmodel = new ArrayList<CheLiangJsonModel>();
//		创建格式化日期对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < chelianglist.size(); i++) {
			
			CheLiang cheliang = chelianglist.get(i);
			String id = String.valueOf(cheliang.getId());
			
			String path =request.getContextPath()+"/"+"cheLiangXiangXi?id="+id;
			String chepaihao = "<a href=\""+path+"\">"+cheliang.getChepaihao()+"</a>";
			
			String jiayayuan = "";
			if( !"请选择".equals(cheliang.getJiayayuan1()) ){
				try {
					jiayayuan = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(cheliang.getJiayayuan1())).getJiashiyuanxingming();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if( !"请选择".equals(cheliang.getJiayayuan2()) ){
				try {
					jiayayuan = jiayayuan+","+jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(cheliang.getJiayayuan2())).getJiashiyuanxingming();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			String chexingid = cheliang.getChexing();
			String chexing="";
			try {
				if(chexingid!=null &&  !"".equals(chexingid)){
					chexing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(chexingid)).getName();
				}
			} catch (Exception e) {
			}
			
			
			String cheliangleixingid = cheliang.getCheliangleixing();
			String cheliangleixing="";
			try {
				if(cheliangleixingid!=null && !"".equals(cheliangleixingid)){
					cheliangleixing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliangleixingid)).getName();
				}
			} catch (Exception e) {
			}
			
			Date  date = cheliang.getZhuceriqi();
			
			String zhuceriqi="";
//			判断得到的日期是否为空
			if(date==null){
				zhuceriqi="";
			}else{
				zhuceriqi= sdf.format(date);
			}
			
			String zhuangtai = cheliang.getZhuangtai();
			String beizhu = cheliang.getYonghumiaoshu();
			
			String caozuoyuan = "";
			try {
				caozuoyuan = usersService.queryId( Integer.valueOf( cheliang.getCaozuoyuan() ) ).getUsername();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			 String  chezhuxingming = cheliang.getChezhuxingming();
			 String  shoujihao = cheliang.getShoujihao(); //手机号
			 String  pingpaixinghao = cheliang.getPingpaixinghao(); //品牌型号
			 try {
					if(pingpaixinghao!=null && !"".equals(pingpaixinghao)){
						pingpaixinghao = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(pingpaixinghao)).getName();
					}
			} catch (Exception e) {
			}
			 String  shibiedaihao = cheliang.getShibiedaihao();  //识别代号
			 String  fadongjihao  = cheliang.getFadongjihao();  //发动机号
			 String  zongzhiliang = cheliang.getZongzhiliang(); //总质量  
			 String  zhengbeizhiliang = cheliang.getZhengbeizhiliang(); //整备质量
			 String  hedingzhaizhiliang = cheliang.getHedingzhaizhiliang(); //核定载质量
			 String  zhunqianyingzongzhiliang = cheliang.getZhunqianyingzongzhiliang(); //准牵引总质量
			 
			 String  waikuochicun = cheliang.getWaikuochicun(); //外扩尺寸
			 if(waikuochicun != null){
				 String waikuoArr[] = waikuochicun.split("\\*");
				 waikuochicun = "";
				 for (int j = 0; j < waikuoArr.length; j++) {
					 if(j != waikuoArr.length-1){
						 if(!"".equals(waikuoArr[j])){
							 waikuochicun = waikuochicun + waikuoArr[j] + "*" ;
						 }
					 }else{
						 if(!"".equals(waikuoArr[j])){
							 waikuochicun = waikuochicun + waikuoArr[j] ;
						 }
					 }
				}
				 
			 }
			 
			 String  cheliangdaoluyunshuzhenghao = cheliang.getCheliangdaoluyunshuzhenghao(); //车辆道路运输证号
			 
			 String    nianshenriqi= "" ; //年审日期
			 if(cheliang.getNianshenriqi() != null){
				 nianshenriqi = sdf.format(cheliang.getNianshenriqi());
			 }
			 
			 String    erjiweihuriqi = ""; //二级维护日期
			 if(cheliang.getErjiweihuriqi() != null){
				 erjiweihuriqi = sdf.format(cheliang.getErjiweihuriqi());
			 }
			 
			 String    daoluyunshuzhengnianshenriqi = ""; //道路运输证年审日期
			 if(cheliang.getDaoluyunshuzhengnianshenriqi() != null){
				 daoluyunshuzhengnianshenriqi = sdf.format(cheliang.getDaoluyunshuzhengnianshenriqi());
			 }
			 
			 String  yonghumiaoshu = cheliang.getYonghumiaoshu();   //用户描述
			 
			 String  jingyingfanwei = cheliang.getJingyingfanwei();   //经营范围
			 if(jingyingfanwei != null && !"".equals(jingyingfanwei)){
				String arr[] = jingyingfanwei.split(", ");
				String jingyingfanweiStr="";
				for (int j = 0; j < arr.length; j++) {
					if(j == 0){
						try {
							jingyingfanweiStr = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(arr[j])).getName();
						} catch (Exception e) {
						}
					}else{
						try {
							jingyingfanweiStr = jingyingfanweiStr +","+ cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(arr[j])).getName();
						} catch (Exception e) {
						}
					}
					
				}
				jingyingfanwei = jingyingfanweiStr;
			}	
			 
			
			String  dengjipingdingriqi="";	//等级评定日期
			if(cheliang.getDengjipingdingriqi() != null){
				dengjipingdingriqi = sdf.format(cheliang.getDengjipingdingriqi());
			}
			
			String guantijianceriqi = "";	//罐体检测日期
			if(cheliang.getGuantijianceriqi() != null){
				guantijianceriqi = sdf.format(cheliang.getGuantijianceriqi());
			}
			
			 String shenfenzhenghao = cheliang.getShenfenzhenghao();	//身份证号
			 String zhengshubianhao = cheliang.getZhengshubianhao();	//证书编号
			 String cheshenyanse = cheliang.getCheshenyanse();	//车身颜色
			 String fadongjixinghao = cheliang.getFadongjixinghao();	//发动机型号
			 String ranliaozhonglei = cheliang.getRanliaozhonglei();	//燃料种类
			 String pailiang = cheliang.getPailiang();	//排量
			 String gonglv = cheliang.getGonglv();	//功率
			 String changjiamingcheng = cheliang.getChangjiamingcheng();	//厂家名称
			 
			 String lunjuqian = "";
			 if(cheliang.getLunjuqian() != null && !"".equals(cheliang.getLunjuqian())){
				 lunjuqian = cheliang.getLunjuqian();
			 }
			 String lunjuhou = "";
			 if(cheliang.getLunjuhou() != null && !"".equals(cheliang.getLunjuhou())){
				 lunjuhou = cheliang.getLunjuhou();
			 }
			 String lunju = "";
			 if(lunjuqian != null && !"".equals(lunjuqian)){
				 lunju = lunjuqian+"/" ;
			 }
			 if(lunjuhou != null && !"".equals(lunjuhou)){
				 lunju = lunju + lunjuhou;
			 }
			 
			 String luntaishu = cheliang.getLuntaishu();	//轮胎数
			 String luntaiguige = cheliang.getLuntaiguige();	//轮胎规格
			 String gangbantanhuangpianshu = cheliang.getGangbantanhuangpianshu();	//钢板弹簧片数
			 String zhouju = cheliang.getZhouju();	//轴距
			 String zhoushu = cheliang.getZhoushu();	//轴数
			 
			 String huoxiangchang = "";
			 if(cheliang.getHuoxiangchang() != null && !"".equals(cheliang.getHuoxiangchang())){
				 huoxiangchang = cheliang.getHuoxiangchang();
			 }
			 String huoxiangkuan = "";
			 if(cheliang.getHuoxiangkuan() != null && !"".equals(cheliang.getHuoxiangkuan())){
				 huoxiangkuan = cheliang.getHuoxiangkuan();
			 }
			 String huoxianggao = "";
			 if(cheliang.getHuoxianggao() != null && !"".equals(cheliang.getHuoxianggao())){
				 huoxianggao = cheliang.getHuoxianggao();
			 }
			 String huoxiang  = "";	//货箱
			 if(huoxiangchang != null && !"".equals(huoxiangchang)){
				 huoxiang = huoxiang + huoxiangchang+"/";
			 }
			 if(huoxiangkuan != null && !"".equals(huoxiangkuan)){
				 huoxiang = huoxiang + huoxiangkuan+"/";
			 }
			 if(huoxianggao != null && !"".equals(huoxianggao)){
				 huoxiang = huoxiang + huoxianggao;
			 }
			 
			 String cheliangfenzu = "";	//车辆分组
			 String cheliangfenzuId = cheliang.getCheliangfenzu();
			 try {
				 if(cheliangfenzuId!=null &&  !"".equals(cheliangfenzuId)){
					 cheliangfenzu = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliangfenzuId)).getName();
				 }
			} catch (Exception e) {
			}			
			 
			String gouchefei = cheliang.getGouchefei();  
			 
			CheLiangJsonModel cljm = new CheLiangJsonModel();
			
			cljm.setCheLiangJsonModel( id,  chepaihao,  jiayayuan,
					 chexing,  cheliangleixing,  zhuceriqi,
					 zhuangtai,  beizhu,  caozuoyuan,
					 chezhuxingming,  shoujihao,  pingpaixinghao,
					 shibiedaihao,  fadongjihao,  zongzhiliang,
					 zhengbeizhiliang,  hedingzhaizhiliang,
					 zhunqianyingzongzhiliang,  waikuochicun,
					 cheliangdaoluyunshuzhenghao,  nianshenriqi,
					 erjiweihuriqi,  daoluyunshuzhengnianshenriqi,
					 yonghumiaoshu,  jingyingfanwei,
					 dengjipingdingriqi,  guantijianceriqi);
			
			cljm.setCheLiangJsonModelValue( shenfenzhenghao,  zhengshubianhao,
					 cheshenyanse,  fadongjixinghao,
					 ranliaozhonglei,  pailiang,  gonglv,
					 changjiamingcheng,  lunju,  luntaishu,
					 luntaiguige,  gangbantanhuangpianshu,  zhouju,
					 zhoushu,  huoxiang,  cheliangfenzu);
			
			cljm.setGouchefei(gouchefei);
			
			cheliangjsonmodel.add(cljm);
			
		}
		
//		定义服务器端分页查询
		CheLiangServer cheLiangServer = new CheLiangServer();
		cheLiangServer.setRows(cheliangjsonmodel);
		
//		一共有多少条数据
		Long Total = cheLiangService.cheLiangSize(chepaihao, chexing, cheliangleixing, pingpaixinghao, zhuangtai, mycaozuoyuan);
		cheLiangServer.setTotal(Total.intValue());
		
		JSONObject jo = JSONObject.fromObject(cheLiangServer);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(jo);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  车辆json
	 */
	public void cheLiangJson(){
		System.out.println("车辆json");
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		//得到客户端传递的页码和每页记录数，并转换成int类型  
        String pageSize = request.getParameter("pageSize");  
        String pageNumber = request.getParameter("pageNumber");
		
		String mycaozuoyuan = request.getParameter("caozuoyuan");
		
		
//		业务对象
				
		
		List<CheLiang> chelianglist = cheLiangService.vagueSearchCheLiang(chepaihao, chexing, cheliangleixing, pingpaixinghao, zhuangtai, mycaozuoyuan ,  pageSize , pageNumber);
		

		
//		创建用户业务对象
			
		
//		得到驾驶员业务对象
		
		
//		创建车辆模版集合对象
		ArrayList<CheLiangJsonModel> cheliangjsonmodel = new ArrayList<CheLiangJsonModel>();
//		创建格式化日期对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < chelianglist.size(); i++) {
			
			CheLiang cheliang = chelianglist.get(i);
			String id = String.valueOf(cheliang.getId());
			
			String path =request.getContextPath()+"/"+"cheLiangXiangXi?id="+id;
			String chepaihao = "<a href=\""+path+"\">"+cheliang.getChepaihao()+"</a>";
			
			String jiayayuan = "";
			if( !"请选择".equals(cheliang.getJiayayuan1()) ){
				try {
					jiayayuan = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(cheliang.getJiayayuan1())).getJiashiyuanxingming();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if( !"请选择".equals(cheliang.getJiayayuan2()) ){
				try {
					jiayayuan = jiayayuan+","+jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(cheliang.getJiayayuan2())).getJiashiyuanxingming();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			String chexingid = cheliang.getChexing();
			String chexing="";
			try {
				if(chexingid!=null &&  !"".equals(chexingid)){
					chexing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(chexingid)).getName();
				}
			} catch (Exception e) {
			}
			
			
			String cheliangleixingid = cheliang.getCheliangleixing();
			String cheliangleixing="";
			try {
				if(cheliangleixingid!=null && !"".equals(cheliangleixingid)){
					cheliangleixing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliangleixingid)).getName();
				}
			} catch (Exception e) {
			}
			
			Date  date = cheliang.getZhuceriqi();
			
			String zhuceriqi="";
//			判断得到的日期是否为空
			if(date==null){
				zhuceriqi="";
			}else{
				zhuceriqi= sdf.format(date);
			}
			
			String zhuangtai = cheliang.getZhuangtai();
			String beizhu = cheliang.getYonghumiaoshu();
			
			String caozuoyuan = "";
			try {
				caozuoyuan = usersService.queryId( Integer.valueOf( cheliang.getCaozuoyuan() ) ).getUsername();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			 String  chezhuxingming = cheliang.getChezhuxingming();
			 String  shoujihao = cheliang.getShoujihao(); //手机号
			 String  pingpaixinghao = cheliang.getPingpaixinghao(); //品牌型号
			 try {
					if(pingpaixinghao!=null && !"".equals(pingpaixinghao)){
						pingpaixinghao = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(pingpaixinghao)).getName();
					}
			} catch (Exception e) {
			}
			 String  shibiedaihao = cheliang.getShibiedaihao();  //识别代号
			 String  fadongjihao  = cheliang.getFadongjihao();  //发动机号
			 String  zongzhiliang = cheliang.getZongzhiliang(); //总质量  
			 String  zhengbeizhiliang = cheliang.getZhengbeizhiliang(); //整备质量
			 String  hedingzhaizhiliang = cheliang.getHedingzhaizhiliang(); //核定载质量
			 String  zhunqianyingzongzhiliang = cheliang.getZhunqianyingzongzhiliang(); //准牵引总质量
			 
			 String  waikuochicun = cheliang.getWaikuochicun(); //外扩尺寸
			 if(waikuochicun != null){
				 String waikuoArr[] = waikuochicun.split("\\*");
				 waikuochicun = "";
				 for (int j = 0; j < waikuoArr.length; j++) {
					 if(j != waikuoArr.length-1){
						 if(!"".equals(waikuoArr[j])){
							 waikuochicun = waikuochicun + waikuoArr[j] + "*" ;
						 }
					 }else{
						 if(!"".equals(waikuoArr[j])){
							 waikuochicun = waikuochicun + waikuoArr[j] ;
						 }
					 }
				}
				 
			 }
			 
			 String  cheliangdaoluyunshuzhenghao = cheliang.getCheliangdaoluyunshuzhenghao(); //车辆道路运输证号
			 
			 String    nianshenriqi= "" ; //年审日期
			 if(cheliang.getNianshenriqi() != null){
				 nianshenriqi = sdf.format(cheliang.getNianshenriqi());
			 }
			 
			 String    erjiweihuriqi = ""; //二级维护日期
			 if(cheliang.getErjiweihuriqi() != null){
				 erjiweihuriqi = sdf.format(cheliang.getErjiweihuriqi());
			 }
			 
			 String    daoluyunshuzhengnianshenriqi = ""; //道路运输证年审日期
			 if(cheliang.getDaoluyunshuzhengnianshenriqi() != null){
				 daoluyunshuzhengnianshenriqi = sdf.format(cheliang.getDaoluyunshuzhengnianshenriqi());
			 }
			 
			 String  yonghumiaoshu = cheliang.getYonghumiaoshu();   //用户描述
			 
			 String  jingyingfanwei = cheliang.getJingyingfanwei();   //经营范围
			 if(jingyingfanwei != null && !"".equals(jingyingfanwei)){
				String arr[] = jingyingfanwei.split(", ");
				String jingyingfanweiStr="";
				for (int j = 0; j < arr.length; j++) {
					if(j == 0){
						try {
							jingyingfanweiStr = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(arr[j])).getName();
						} catch (Exception e) {
						}
					}else{
						try {
							jingyingfanweiStr = jingyingfanweiStr +","+ cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(arr[j])).getName();
						} catch (Exception e) {
						}
					}
					
				}
				jingyingfanwei = jingyingfanweiStr;
			}	
			 
			
			String  dengjipingdingriqi="";	//等级评定日期
			if(cheliang.getDengjipingdingriqi() != null){
				dengjipingdingriqi = sdf.format(cheliang.getDengjipingdingriqi());
			}
			
			String guantijianceriqi = "";	//罐体检测日期
			if(cheliang.getGuantijianceriqi() != null){
				guantijianceriqi = sdf.format(cheliang.getGuantijianceriqi());
			}
			
			 String shenfenzhenghao = cheliang.getShenfenzhenghao();	//身份证号
			 String zhengshubianhao = cheliang.getZhengshubianhao();	//证书编号
			 String cheshenyanse = cheliang.getCheshenyanse();	//车身颜色
			 String fadongjixinghao = cheliang.getFadongjixinghao();	//发动机型号
			 String ranliaozhonglei = cheliang.getRanliaozhonglei();	//燃料种类
			 String pailiang = cheliang.getPailiang();	//排量
			 String gonglv = cheliang.getGonglv();	//功率
			 String changjiamingcheng = cheliang.getChangjiamingcheng();	//厂家名称
			 
			 String lunjuqian = "";
			 if(cheliang.getLunjuqian() != null && !"".equals(cheliang.getLunjuqian())){
				 lunjuqian = cheliang.getLunjuqian();
			 }
			 String lunjuhou = "";
			 if(cheliang.getLunjuhou() != null && !"".equals(cheliang.getLunjuhou())){
				 lunjuhou = cheliang.getLunjuhou();
			 }
			 String lunju = "";
			 if(lunjuqian != null && !"".equals(lunjuqian)){
				 lunju = lunjuqian+"/" ;
			 }
			 if(lunjuhou != null && !"".equals(lunjuhou)){
				 lunju = lunju + lunjuhou;
			 }
			 
			 String luntaishu = cheliang.getLuntaishu();	//轮胎数
			 String luntaiguige = cheliang.getLuntaiguige();	//轮胎规格
			 String gangbantanhuangpianshu = cheliang.getGangbantanhuangpianshu();	//钢板弹簧片数
			 String zhouju = cheliang.getZhouju();	//轴距
			 String zhoushu = cheliang.getZhoushu();	//轴数
			 
			 String huoxiangchang = "";
			 if(cheliang.getHuoxiangchang() != null && !"".equals(cheliang.getHuoxiangchang())){
				 huoxiangchang = cheliang.getHuoxiangchang();
			 }
			 String huoxiangkuan = "";
			 if(cheliang.getHuoxiangkuan() != null && !"".equals(cheliang.getHuoxiangkuan())){
				 huoxiangkuan = cheliang.getHuoxiangkuan();
			 }
			 String huoxianggao = "";
			 if(cheliang.getHuoxianggao() != null && !"".equals(cheliang.getHuoxianggao())){
				 huoxianggao = cheliang.getHuoxianggao();
			 }
			 String huoxiang  = "";	//货箱
			 if(huoxiangchang != null && !"".equals(huoxiangchang)){
				 huoxiang = huoxiang + huoxiangchang+"/";
			 }
			 if(huoxiangkuan != null && !"".equals(huoxiangkuan)){
				 huoxiang = huoxiang + huoxiangkuan+"/";
			 }
			 if(huoxianggao != null && !"".equals(huoxianggao)){
				 huoxiang = huoxiang + huoxianggao;
			 }
			 
			 String cheliangfenzu = "";	//车辆分组
			 String cheliangfenzuId = cheliang.getCheliangfenzu();
			 try {
				 if(cheliangfenzuId!=null &&  !"".equals(cheliangfenzuId)){
					 cheliangfenzu = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliangfenzuId)).getName();
				 }
			} catch (Exception e) {
			}			
			 
			String gouchefei = cheliang.getGouchefei();  
			 
			CheLiangJsonModel cljm = new CheLiangJsonModel();
			
			cljm.setCheLiangJsonModel( id,  chepaihao,  jiayayuan,
					 chexing,  cheliangleixing,  zhuceriqi,
					 zhuangtai,  beizhu,  caozuoyuan,
					 chezhuxingming,  shoujihao,  pingpaixinghao,
					 shibiedaihao,  fadongjihao,  zongzhiliang,
					 zhengbeizhiliang,  hedingzhaizhiliang,
					 zhunqianyingzongzhiliang,  waikuochicun,
					 cheliangdaoluyunshuzhenghao,  nianshenriqi,
					 erjiweihuriqi,  daoluyunshuzhengnianshenriqi,
					 yonghumiaoshu,  jingyingfanwei,
					 dengjipingdingriqi,  guantijianceriqi);
			
			cljm.setCheLiangJsonModelValue( shenfenzhenghao,  zhengshubianhao,
					 cheshenyanse,  fadongjixinghao,
					 ranliaozhonglei,  pailiang,  gonglv,
					 changjiamingcheng,  lunju,  luntaishu,
					 luntaiguige,  gangbantanhuangpianshu,  zhouju,
					 zhoushu,  huoxiang,  cheliangfenzu);
			
			cljm.setGouchefei(gouchefei);
			
			cheliangjsonmodel.add(cljm);
			
		}
		
//		定义服务器端分页查询
		CheLiangServer cheLiangServer = new CheLiangServer();
		cheLiangServer.setRows(cheliangjsonmodel);
		
//		一共有多少条数据
		Long Total = cheLiangService.cheLiangSize(chepaihao, chexing, cheliangleixing, pingpaixinghao, zhuangtai, mycaozuoyuan);
		cheLiangServer.setTotal(Total.intValue());
		
		JSONObject jo = JSONObject.fromObject(cheLiangServer);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(jo);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  车辆详细
	 */
	public String cheLiangXiangXi(){
		System.out.println("车辆详细");
//		设置字符格式
		FontFormat.setFontFormat(response);	
//		车辆业务对象
				
//		车辆管理对象
		
		
		String id = request.getParameter("id");
		CheLiang singlecheliang = cheLiangService.queryIdCheLiang(Integer.valueOf(id));
		
		String chexingId = singlecheliang.getChexing();
		String cheliangleixingId = singlecheliang.getCheliangleixing();
		String pinpaixinghaoId = singlecheliang.getPingpaixinghao();
		String cheliangfenzuId = singlecheliang.getCheliangfenzu();
		
		String chexingvalue="";
		if(chexingId != null && !"".equals(chexingId)){
			try {
				chexingvalue = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(chexingId)).getName();
			} catch (Exception e) {
			}
		}
		
		String cheliangleixingvalue ="";
		if(cheliangleixingId != null && !"".equals(cheliangleixingId)){
			try {
				cheliangleixingvalue = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliangleixingId)).getName();
			} catch (Exception e) {
			}
		}
		
		String pinpaixinghaovalue="";
		if(pinpaixinghaoId != null && !"".equals(pinpaixinghaoId)){
			try {
				pinpaixinghaovalue = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(pinpaixinghaoId)).getName();
			} catch (Exception e) {
			}
		}
		
		String cheliangfenzu = "";
		if(cheliangfenzuId != null && !"".equals(cheliangfenzuId)){
			try {
				cheliangfenzu = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf( cheliangfenzuId )).getName();
			} catch (Exception e) {
			}
		}
		
		singlecheliang.setChexing(chexingvalue);
		singlecheliang.setCheliangleixing(cheliangleixingvalue);
		singlecheliang.setPingpaixinghao(pinpaixinghaovalue);
		singlecheliang.setCheliangfenzu(cheliangfenzu);
		
		/*String shenfenzhengtupian = singlecheliang.getShenfenzhengtupian();
		if(shenfenzhengtupian !=null && !"".equals(shenfenzhengtupian)){
			String str = shenfenzhengtupian.replaceAll("\\\\", "/");
			int index =str.indexOf("uploads");
			shenfenzhengtupian=str.substring(index);
			singlecheliang.setShenfenzhengtupian(shenfenzhengtupian);
		}*/		
		
		String waikuochicun = singlecheliang.getWaikuochicun();
		singlecheliang.setWaikuochicun("");
		if(waikuochicun != null){
			 String waikuoArr[] = waikuochicun.split("\\*");
			 waikuochicun = "";
			 for (int j = 0; j < waikuoArr.length; j++) {
				 if(j != waikuoArr.length-1){
					 if(!"".equals(waikuoArr[j]) && waikuoArr[j] != null){
						 waikuochicun = waikuochicun + waikuoArr[j] + "*" ;
					 }
				 }else{
					 if(!"".equals(waikuoArr[j]) && waikuoArr[j] != null){
						 waikuochicun = waikuochicun + waikuoArr[j] ;
					 }
				 }
			}
			
			 singlecheliang.setWaikuochicun(waikuochicun);
			
		}
		
		String jingyingfanwei = singlecheliang.getJingyingfanwei();
		if(jingyingfanwei != null && !"".equals(jingyingfanwei)){
			String arr[] = jingyingfanwei.split(", ");
			String jingyingfanweiStr="";
			for (int i = 0; i < arr.length; i++) {
				try {
					jingyingfanweiStr = jingyingfanweiStr +","+ cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(arr[i])).getName();
				} catch (Exception e) {
				}
			}
			request.setAttribute("jingyingfanweiStr", jingyingfanweiStr);
		}		
		
//		创建用户业务对象
		
		
		String caozuoyuan = "" ;
		
		try {
			caozuoyuan = usersService.queryId( Integer.valueOf(singlecheliang.getCaozuoyuan()) ).getUsername();
		} catch (Exception e) {
		}
		singlecheliang.setCaozuoyuan(caozuoyuan);
		
		
		request.setAttribute("singlecheliang", singlecheliang);
		
//		-------------------------------------
//		关联车辆
		
		
		String chexing = "";
		try {
			chexing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(chexingId)).getShijileixing();
		} catch (Exception e) {
		}
		
//		如果车型是牵引车
		if("牵引车".equals(chexing)){
			CheLiangGuanXi cheliangguanxi =  cheLiangGuanXiService.queryCheLiangGuanXiInQianYinChe(singlecheliang.getChepaihao());
//			判断是否有关联
			if(cheliangguanxi == null){
				return "success";
			}
//			得到挂车字符串通过逗号进行分割
			String guaCheStr = cheliangguanxi.getGuache();
			String guaCheArr[] = guaCheStr.split(",");
			
			List<CheLiang> guanlianchelianglist = new ArrayList<CheLiang>();
			for (int i = 0; i < guaCheArr.length; i++) {
				CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(guaCheArr[i]);
				guanlianchelianglist.add(cheliang);
			}
			request.setAttribute("guanlianchelianglist", guanlianchelianglist);
		}
		
//		如果车型是挂车
		if("挂车".equals(chexing)){
//			先查询所有车辆关系
			List<CheLiangGuanXi> cheliangguanxilist = cheLiangGuanXiService.queryCheLiangGuanXi();
			for (int i = 0; i < cheliangguanxilist.size(); i++) {
				CheLiangGuanXi cheliangguanxi = cheliangguanxilist.get(i);
				String guaCheStr = cheliangguanxi.getGuache();
//				判断是否包含挂车 车牌号
				if( guaCheStr.contains(singlecheliang.getChepaihao()) ){

					String qianyincheChePaiHao = cheliangguanxi.getQianyinche();
					CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(qianyincheChePaiHao);
					
					List<CheLiang> guanlianchelianglist = new ArrayList<CheLiang>();
					guanlianchelianglist.add(cheliang);
					
					request.setAttribute("guanlianchelianglist", guanlianchelianglist);
					break;
				}
			}
			
		}
		
//		得到图片路径
		String fujianstr = singlecheliang.getShenfenzhengtupian();
		
		if(fujianstr != null){
//			创建图片集合对象
			List<String> picturelist = new ArrayList<String>();
			
			String fujiansplit[] = fujianstr.split(",");
			
			String formatPathStr[] = FileManager.formatArrStr(fujiansplit, "uploads");
			
			if(formatPathStr != null){
				for (int i = 0; i < formatPathStr.length; i++) {
					picturelist.add(formatPathStr[i]);
				}
			}
			
			request.setAttribute("picturelist", picturelist);
		}

//		得到驾驶员业务对象
		
		
		String jiashiyuan1 = singlecheliang.getJiayayuan1();
		String jiashiyuan2 = singlecheliang.getJiayayuan2();
		
		if(jiashiyuan1 != null && !"".equals(jiashiyuan1)){
			try {
				JiaShiYuan jiashiyuan = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(jiashiyuan1));
				request.setAttribute("jiashiyuan1", jiashiyuan.getJiashiyuanxingming());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(jiashiyuan2 != null && !"".equals(jiashiyuan2)){
			try {
				JiaShiYuan jiashiyuan = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(jiashiyuan2));
				request.setAttribute("jiashiyuan2", jiashiyuan.getJiashiyuanxingming());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return "success";
	}
	
	/**
	 *  跳转-添加车辆
	 */
	public String jumpAddCheLiang(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-添加车辆");
		
//		车辆暂存
		
		
//		得到用户对象
		Users users = (Users) session.getAttribute("users");
		String caozuoyuan = users.getUsersid().toString();
		
		 singlecheliangbeifen = cheLiangBeiFenService.queryCaoZuoYuan(caozuoyuan);
		 if(singlecheliangbeifen != null){
//				发送 长 宽 高
				String waikuochicun = singlecheliangbeifen.getWaikuochicun();
				if(waikuochicun != null && !"".equals(waikuochicun)){
					String waikuoStr[] = waikuochicun.split("/");
					if(waikuoStr.length == 3){
						String chang = waikuoStr[0];
						String kuan = waikuoStr[1];
						String gao = waikuoStr[2];
						
						request.setAttribute("chang", chang);
						request.setAttribute("kuan", kuan);
						request.setAttribute("gao", gao);
					}
				}
		 }
		 
		session.setAttribute("singlecheliangbeifen", singlecheliangbeifen);
		request.setAttribute("singlecheliangbeifen", singlecheliangbeifen);
		
		
		List<CheLiangGuanLi> jingyinglist = cheLiangGuanLiService.queryCheLiangGuanLiType("6");
		
		List<CheLiangGuanLi> selectjingyinglist = new ArrayList<CheLiangGuanLi>();
		
		
		if(singlecheliangbeifen != null){
			String jingyingfanwei = singlecheliangbeifen.getJingyingfanwei();
			if(jingyingfanwei != null && !"".equals(jingyingfanwei)){
				String selectJingYing [] = null;
				selectJingYing = jingyingfanwei.split(", ");
				
				for (int i = 0; i < jingyinglist.size(); i++) {
					
					for (int j = 0; j < selectJingYing.length; j++) {
						
						String ids = jingyinglist.get(i).getId().toString();
						
						if(selectJingYing[j].equals( ids )){
							selectjingyinglist.add( jingyinglist.get(i) );
							
							jingyinglist.remove(i);
							i--;
								
							break;
						}
					}
				}
			}
		}
		
		request.setAttribute("jingyinglist", jingyinglist);
		request.setAttribute("selectjingyinglist", selectjingyinglist);
		
		picturepathlist = (ArrayList<String>) session.getAttribute("picturepathlist");
		if(picturepathlist == null) {
			picturepathlist = new ArrayList<String>();
		}
		picturepathlist.clear();	//清空图片路径 
		session.setAttribute("picturepathlist", picturepathlist);
		
		deletezhengjianlist = (ArrayList<String>) session.getAttribute("deletezhengjianlist");
		if(deletezhengjianlist == null) {
			deletezhengjianlist = new ArrayList<String>();
		}
		deletezhengjianlist.clear(); //清空删除图片路径
		session.setAttribute("deletezhengjianlist", deletezhengjianlist);
		
//		发送车辆管理集合对象
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
//		发送审核通过的驾驶员
		JiaShiYuanController.sendJiaShiYuanShenHeTongGuo(jiaShiYuanService);
		
		return "success";
	}
	
	/**
	 *  添加车辆
	 */
	public String addCheLiang(){
		System.out.println("添加车辆");
//		设置字符格式
		FontFormat.setFontFormat(response);	
//		得到车辆业务对象
		
//		车辆暂存
		
//		得到用户对象
		Users users = (Users) session.getAttribute("users");
		if(users == null){
			return "success";
		}
		String caozuoyuan = users.getUsersid().toString();
		Date   caozuoriqi = new Date();
//		删除备份
		cheLiangBeiFenService.deleteCaoZuoYuan(users.getUsersid().toString());
		
//		创建车辆对象
		CheLiang cheliang = new CheLiang();
		
		String waikuochicun = chang+ "*" + kuan + "*" + gao;
		
//		得到附件
		String fujianstr = "";
		
		singlecheliangbeifen = (CheLiangBeiFen) session.getAttribute("singlecheliangbeifen");
		
		if(singlecheliangbeifen!=null){
			fujianstr = singlecheliangbeifen.getShenfenzhengtupian();
			if(fujianstr == null){
				fujianstr = "";
			}
		}

		deletezhengjianlist = (ArrayList<String>) session.getAttribute("deletezhengjianlist");
		
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
		
		picturepathlist = (ArrayList<String>) session.getAttribute("picturepathlist");
		
		for (int i = 0; i < picturepathlist.size(); i++) {
//			因为该集合里已经添加逗号所以不用添加
			addfujianpath=addfujianpath+picturepathlist.get(i);
		}
		
			
		
//		向车辆对象赋值		
		cheliang.setCheLiang(chepaihao, chezhuxingming, shoujihao, 
							jiayayuan1, jiayayuan2, chexing, 
							cheliangleixing, pingpaixinghao, shibiedaihao, 
							fadongjihao, zongzhiliang, zhengbeizhiliang, 
							hedingzhaizhiliang, zhunqianyingzongzhiliang, waikuochicun, 
							cheliangdaoluyunshuzhenghao, zhuceriqi, nianshenriqi, erjiweihuriqi, 
							daoluyunshuzhengnianshenriqi, yonghumiaoshu, jingyingfanwei,
							caozuoyuan, caozuoriqi,zhuangtai);
		
		cheliang.setDengjipingdingriqi(dengjipingdingriqi);
		cheliang.setGuantijianceriqi(guantijianceriqi);
		
		cheliang.setCheLiangTwo( shenfenzhenghao,  addfujianpath,
				 zhengshubianhao,  cheshenyanse,
				 fadongjixinghao,  ranliaozhonglei,  pailiang,
				 gonglv,  changjiamingcheng,  lunjuqian,
				 lunjuhou,  luntaishu,  luntaiguige,
				 gangbantanhuangpianshu,  zhouju,  zhoushu,
				 huoxiangchang,  huoxiangkuan,  huoxianggao,
				 cheliangfenzu);
		
		cheliang.setGouchefei(gouchefei);
		
//		添加车辆对象
		cheLiangService.addCheLiang(cheliang);
		
//		创建保险业务对象
		
		
//		判断是否创建保险业务对象
		if( !"".equals(jiaoqiangxianbaodanhao) || jiaoqiangxiandaoqishijian!=null || !"".equals(jiaoqiangxianfeiyong) ){
			
			if(jiaoqiangxianbaodanhao==null){
				jiaoqiangxianbaodanhao="";
			}
			
			if(jiaoqiangxianfeiyong==null){
				jiaoqiangxianfeiyong="";
			}
			
//			创建交强险对象
			BaoXian jiaoqiangxian = new BaoXian();
			jiaoqiangxian.setBaoXianValue(chepaihao, "交强险", jiaoqiangxiangongsi,
					null, jiaoqiangxiandaoqishijian, jiaoqiangxianbaodanhao, 
					"", jiaoqiangxianfeiyong, "", 
					"", "", "");
			
			baoXianService.addBaoXian(jiaoqiangxian);
		}
		
//		判断是否创建商业险对象
		if(shangyexiandaoqishijian!=null || !"".equals(shangyexianbaodanhao) || !"".equals(shangyexianfeiyong) ){
			
			if(shangyexianbaodanhao == null){
				shangyexianbaodanhao="";
			}
			
			if(shangyexianfeiyong == null){
				shangyexianfeiyong="";
			}
			
//			创建商业险对象
			BaoXian shangyexian = new BaoXian();
			shangyexian.setBaoXianValue(chepaihao, "商业险", shangyexiangongsi,
											null, shangyexiandaoqishijian, shangyexianbaodanhao,
											"", shangyexianfeiyong, "", 
											"", "", "");
			baoXianService.addBaoXian(shangyexian);
		}
		
//		判断是否创建承运人责任险对象
		if(chengyunrendaoqishijian!=null || !"".equals(chengyunrenbaodanhao) || !"".equals(chengyunrenfeiyong) ){
			
			if(chengyunrenbaodanhao==null){
				chengyunrenbaodanhao="";
			}
			
			if(chengyunrenfeiyong==null){
				chengyunrenfeiyong="";
			}
			
//			创建承运人责任险
			BaoXian chengyunrenzerenxian = new BaoXian();
			chengyunrenzerenxian.setBaoXianValue(chepaihao, "承运人责任险", chengyunrengongsi,
													null, chengyunrendaoqishijian, chengyunrenbaodanhao,
													"", chengyunrenfeiyong, "",
													"", "", "");
			baoXianService.addBaoXian(chengyunrenzerenxian);
		}

//		判断是否创建雇主责任险对象
		if(guzhudaoqishijian!=null || !"".equals(guzhubaodanhao) || !"".equals(guzhufeiyong) ){
			
			if(guzhubaodanhao==null){
				guzhubaodanhao="";
			}
			if(guzhufeiyong==null){
				guzhufeiyong="";
			}
			
//			创建雇主责任险
			BaoXian guzhuzerenxian = new BaoXian();
			guzhuzerenxian.setBaoXianValue(chepaihao, "雇主责任险", guzhugongsi, 
											null, guzhudaoqishijian, guzhubaodanhao, 
											"", guzhufeiyong, "", 
											"", "", "");
			
			baoXianService.addBaoXian(guzhuzerenxian);
		}

		if(tuantixiandaoqishijian!=null || !"".equals(tuantixianbaodanhao) || !"".equals(tuantixianfeiyong) ){
			
			if(tuantixianbaodanhao==null){
				tuantixianbaodanhao="";
			}
			if(tuantixianfeiyong==null){
				tuantixianfeiyong="";
			}
			
//			团体意外险
			BaoXian tuantiyiwaixian = new BaoXian();
			tuantiyiwaixian.setBaoXianValue(chepaihao, "团体意外险", tuantigongsi,
											null, tuantixiandaoqishijian, tuantixianbaodanhao,
											"", tuantixianfeiyong, "",
											"", "", "");
			baoXianService.addBaoXian(tuantiyiwaixian);
		}

		
//		车船险
		if(chechuanxiandaoqishijian!=null || !"".equals(chechuanxianbaodanhao) || !"".equals(chechuanxianfeiyong) ){
			
			if(chechuanxianbaodanhao==null){
				chechuanxianbaodanhao="";
			}
			if(chechuanxianfeiyong==null){
				chechuanxianfeiyong="";
			}
			
			BaoXian chechuanxian = new BaoXian();
			chechuanxian.setBaoXianValue(chepaihao, "车船险", chechuanxiangongsi,
											null, chechuanxiandaoqishijian, chechuanxianbaodanhao,
											"", chechuanxianfeiyong, "",
											"", "", "");
			baoXianService.addBaoXian(chechuanxian);
		}
		
		
		
		
//		添加年审
		if(nianshenriqi!=null || guantijianceriqi != null || daoluyunshuzhengnianshenriqi != null || erjiweihuriqi != null || dengjipingdingriqi!= null){
			
			
			NianShen nianshen = new NianShen();
			
			Calendar calendar = Calendar.getInstance();
			
			Date nianshendaoqiriqi = null;
			if(nianshenriqi != null){
				calendar.setTime(nianshenriqi);
				calendar.add(Calendar.YEAR, 1);
				nianshendaoqiriqi = calendar.getTime();
			}
			
			
			nianshen.setNianShen(chepaihao, chezhuxingming, shoujihao,
								nianshenriqi, nianshendaoqiriqi, caozuoyuan, caozuoriqi);
			
			
			if(daoluyunshuzhengnianshenriqi != null){
				 calendar.setTime(daoluyunshuzhengnianshenriqi); 
				 calendar.add(Calendar.YEAR, 1);
				 Date daoludaoqiriqi = calendar.getTime();
				 nianshen.setDaoludaoqiriqi(daoludaoqiriqi);
			}
			
			if(erjiweihuriqi != null){
				 calendar.setTime(erjiweihuriqi); 
				 calendar.add(Calendar.MONTH, 4);
				 Date erjidaoqiriqi = calendar.getTime();
				 nianshen.setErjidaoqiriqi(erjidaoqiriqi);
			}
			
			if(dengjipingdingriqi != null){
				calendar.setTime(dengjipingdingriqi); 
				calendar.add(Calendar.YEAR, 1);
				Date dengjidaoqiriqi = calendar.getTime();
				nianshen.setDengjidaoqiriqi(dengjidaoqiriqi);
			}
			
			if(guantijianceriqi != null){
			    calendar.setTime(guantijianceriqi); 
			    calendar.add(Calendar.YEAR, 1);
			    Date guantidaoqiriqi = calendar.getTime();
			    
			    nianshen.setGuantidaoqiriqi(guantidaoqiriqi);
			}	
			
			nianShenService.addNianShen(nianshen);
			
		}
		

//		同步驾驶员
		
		
		if(jiayayuan1!=null &&  !"".equals(jiayayuan1) && !"请选择".equals(jiayayuan1) ){
			try {
				JiaShiYuan jiashiyuan1 = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(jiayayuan1));
				jiashiyuan1.setJiashicheliang(chepaihao);
				jiaShiYuanService.updateJiaShiYuan(jiashiyuan1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(jiayayuan2!=null &&  !"".equals(jiayayuan2) && !"请选择".equals(jiayayuan2) ){
			try {
				JiaShiYuan jiashiyuan2 = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(jiayayuan2));
				jiashiyuan2.setJiashicheliang(chepaihao);
				jiaShiYuanService.updateJiaShiYuan(jiashiyuan2);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
//		费用收取 同步
		FeiYongShouQuController.SynchronizationFeiYongShouQu(chezhuxingming, feiYongShouQuService
															,  cheLiangService , yingShouKuanService
															,  yunDanService ,  baoXianService
															);
		
//				
		
//		发送车辆管理集合对象
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
		
//		发送驾驶员集合对象
		JiaShiYuanController.sendJiaShiYuan(jiaShiYuanService);
		
//		发送用户集合对象
		UsersController.sendUsers(usersService);
		
		picturepathlist.clear();  
		deletezhengjianlist.clear();
		session.setAttribute("picturepathlist",picturepathlist );
		session.setAttribute("deletezhengjianlist", deletezhengjianlist);
		  
		return "success";
	}
	
	/**
	 * 暂存 车辆备份
	 */
	public String zanCunCheLiangBeiFen(){
		System.out.println("暂存 车辆备份");
//		设置字符格式
		FontFormat.setFontFormat(response);	
//		车辆暂存
		
		picturepathlist = (ArrayList<String>) session.getAttribute("picturepathlist");  
		deletezhengjianlist = (ArrayList<String>) session.getAttribute("deletezhengjianlist");  
		
//		得到用户对象
		Users users = (Users) session.getAttribute("users");
		String caozuoyuan = users.getUsersid().toString();
		Date   caozuoriqi = new Date();
		
		String waikuochicun = chang+ "/" + kuan + "/" + gao;
		
		CheLiangBeiFen cheliangbeifen = cheLiangBeiFenService.queryCaoZuoYuan(caozuoyuan);
		
		if(cheliangbeifen == null){
			cheliangbeifen = new CheLiangBeiFen();
		}
		
//		得到附件
		String fujianstr = "";
		fujianstr = cheliangbeifen.getShenfenzhengtupian();
		if(fujianstr == null){
			fujianstr = "";
		}

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

		
		
//		向车辆对象赋值		
		cheliangbeifen.setCheLiang(chepaihao, chezhuxingming, shoujihao, 
							jiayayuan1, jiayayuan2, chexing, 
							cheliangleixing, pingpaixinghao, shibiedaihao, 
							fadongjihao, zongzhiliang, zhengbeizhiliang, 
							hedingzhaizhiliang, zhunqianyingzongzhiliang, waikuochicun, 
							cheliangdaoluyunshuzhenghao, zhuceriqi, nianshenriqi, erjiweihuriqi, 
							daoluyunshuzhengnianshenriqi, yonghumiaoshu, jingyingfanwei,
							caozuoyuan, caozuoriqi,zhuangtai);
		
		cheliangbeifen.setDengjipingdingriqi(dengjipingdingriqi);
		cheliangbeifen.setGuantijianceriqi(guantijianceriqi);
		
		cheliangbeifen.setCheLiangTwo( shenfenzhenghao,  addfujianpath,
				 zhengshubianhao,  cheshenyanse,
				 fadongjixinghao,  ranliaozhonglei,  pailiang,
				 gonglv,  changjiamingcheng,  lunjuqian,
				 lunjuhou,  luntaishu,  luntaiguige,
				 gangbantanhuangpianshu,  zhouju,  zhoushu,
				 huoxiangchang,  huoxiangkuan,  huoxianggao,
				 cheliangfenzu);
		
		cheliangbeifen.setCheLiangBaoXian( jiaoqiangxianbaodanhao,
				 jiaoqiangxianfeiyong,  jiaoqiangxiandaoqishijian,
				 jiaoqiangxiangongsi,  shangyexianbaodanhao,
				 shangyexianfeiyong,  shangyexiandaoqishijian,
				 shangyexiangongsi,  chengyunrenbaodanhao,
				 chengyunrenfeiyong,  chengyunrendaoqishijian,
				 chengyunrengongsi,  guzhubaodanhao,
				 guzhufeiyong,  guzhudaoqishijian,  guzhugongsi,
				 tuantixianbaodanhao,  tuantixianfeiyong,  tuantixiandaoqishijian,
				 tuantigongsi,  chechuanxianbaodanhao,
				 chechuanxianfeiyong,  chechuanxiandaoqishijian,
				 chechuanxiangongsi);
		
		cheliangbeifen.setGouchefei(gouchefei);
		
		cheLiangBeiFenService.saveAndUpdate(cheliangbeifen);
		
		picturepathlist.clear();  
		deletezhengjianlist.clear();
		session.setAttribute("picturepathlist",picturepathlist );
		session.setAttribute("deletezhengjianlist", deletezhengjianlist);
		
		return "success";
	}
	
	
	/**
	 *  删除车辆 
	 */
	public String deleteCheLiang(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("删除车辆");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1){
//			发送车辆管理集合对象
			CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
			return "err";
		}
		
		
						
			
				
		
		
		
		for (int i = 0; i < id.length; i++) {
			
			CheLiang cheliang = cheLiangService.queryIdCheLiang(Integer.valueOf(id[i]));
			String chepaihao = cheliang.getChepaihao();
			String jiayayuan1 = cheliang.getJiayayuan1();
			String jiayayuan2 = cheliang.getJiayayuan2();
			
//			删除指定车牌号的保险
			baoXianService.deleteBaoXianChePaiHao(chepaihao);
//			删除指定车牌号的证件
			zhengJianService.deleteZhengJianExistChePaiHao(chepaihao);
//			删除指定车牌号的车辆关系
			cheLiangGuanXiService.deleteChePaiHao(chepaihao);
//			删除指定车牌号的年审
			nianShenService.deleteChePaihao(chepaihao);
			
			String path = request.getRealPath("/");
			File file = new File(path+"\\uploads\\zhengjiantupian\\"+chepaihao);
			
			if(file.isDirectory()){
				File[] files = file.listFiles();
				for(int j=0; j<files.length; j++){
					files[j].delete();
				}
			}
			
//			对驾驶员对象 去除车牌号
//			同步驾驶员
			
			
			if(jiayayuan1!=null &&  !"".equals(jiayayuan1) && !"请选择".equals(jiayayuan1) ){
				JiaShiYuan jiashiyuan1 = jiaShiYuanService.queryJiaShiYuanName(jiayayuan1);
				if(jiashiyuan1!=null){
					jiashiyuan1.setJiashicheliang("");
					jiaShiYuanService.updateJiaShiYuan(jiashiyuan1);					
				}
			}
			
			if(jiayayuan2!=null &&  !"".equals(jiayayuan2) && !"请选择".equals(jiayayuan2) ){
				JiaShiYuan jiashiyuan2 = jiaShiYuanService.queryJiaShiYuanName(jiayayuan2);
				if(jiashiyuan2!=null){
					jiashiyuan2.setJiashicheliang("");
					jiaShiYuanService.updateJiaShiYuan(jiashiyuan2);					
				}
			}
			
//			费用收取 同步
			FeiYongShouQuController.SynchronizationFeiYongShouQu(cheliang.getChezhuxingming(), feiYongShouQuService
																,  cheLiangService , yingShouKuanService
																,  yunDanService ,  baoXianService
																);
			
//			删除车辆
			cheLiangService.deleteCheLiang(Integer.valueOf(id[i]));
		}
		
		
		
//		发送车辆管理集合对象
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
		
//		发送驾驶员集合对象
		JiaShiYuanController.sendJiaShiYuan(jiaShiYuanService);
		
		return "success";
	}
	
	/**
	 *  修改车辆 
	 */
	public String updateCheLiang(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("修改车辆");

//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length>1 || id.length<1){
//			发送车辆管理集合对象
			CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
			return "err";
		}
	
//		得到车辆业务对象
								
//		得到保险业务对象
		
//		得到车辆对象
		 singlecheliang = cheLiangService.queryIdCheLiang(Integer.valueOf(id[0]));
//		得到车牌号
		String chepaihao = singlecheliang.getChepaihao();
		
//		查询指定车牌号和保险类型的对象
		 singlejiaoqiangxian = baoXianService.queryBaoDanHao(chepaihao, "交强险");
		 singleshangyexian = baoXianService.queryBaoDanHao(chepaihao, "商业险");
		 singlechengyunrenzerenxian = baoXianService.queryBaoDanHao(chepaihao, "承运人责任险");
		 singleguzhuzerenxian = baoXianService.queryBaoDanHao(chepaihao, "雇主责任险");
		 singletuantiyiwaixian = baoXianService.queryBaoDanHao(chepaihao, "团体意外险");
		 singlechechuanxian = baoXianService.queryBaoDanHao(chepaihao, "车船险");
		
//		判断该对象是否为空
//		如果对象为空创建对象并且赋值
		if(singlejiaoqiangxian == null){
			singlejiaoqiangxian = new BaoXian();
			singlejiaoqiangxian.setChepaihao(chepaihao);
			singlejiaoqiangxian.setBaoxianleixing("交强险");
		}
		
		if(singleshangyexian == null){
			singleshangyexian = new BaoXian();
			singleshangyexian.setChepaihao(chepaihao);
			singleshangyexian.setBaoxianleixing("商业险");
		}
		
		if(singlechengyunrenzerenxian == null){
			singlechengyunrenzerenxian = new BaoXian();
			singlechengyunrenzerenxian.setChepaihao(chepaihao);
			singlechengyunrenzerenxian.setBaoxianleixing("承运人责任险");
		}
		
		if(singleguzhuzerenxian == null){
			singleguzhuzerenxian = new BaoXian();
			singleguzhuzerenxian.setChepaihao(chepaihao);
			singleguzhuzerenxian.setBaoxianleixing("雇主责任险");
		}
		
		if(singletuantiyiwaixian == null){
			singletuantiyiwaixian = new BaoXian();
			singletuantiyiwaixian.setChepaihao(chepaihao);
			singletuantiyiwaixian.setBaoxianleixing("团体意外险");
		}
		
		if(singlechechuanxian == null){
			singlechechuanxian = new BaoXian();
			singlechechuanxian.setChepaihao(chepaihao);
			singlechechuanxian.setBaoxianleixing("车船险");
		}
		
		
		
//		发送 长 宽 高
		String waikuochicun = singlecheliang.getWaikuochicun();
		if(waikuochicun != null && !"".equals(waikuochicun)){
			String waikuoStr[] = waikuochicun.split("\\*");
			if(waikuoStr.length == 3){
				String chang = waikuoStr[0];
				String kuan = waikuoStr[1];
				String gao = waikuoStr[2];
				
				request.setAttribute("chang", chang);
				request.setAttribute("kuan", kuan);
				request.setAttribute("gao", gao);
			}
		}
		
		
		
		List<CheLiangGuanLi> jingyinglist = cheLiangGuanLiService.queryCheLiangGuanLiType("6");
		
		List<CheLiangGuanLi> selectjingyinglist = new ArrayList<CheLiangGuanLi>();
		
		
		if(singlecheliang != null){
			String jingyingfanwei = singlecheliang.getJingyingfanwei();
			if(jingyingfanwei != null && !"".equals(jingyingfanwei)){
				String selectJingYing [] = null;
				selectJingYing = jingyingfanwei.split(", ");
				
				for (int i = 0; i < jingyinglist.size(); i++) {
					
					for (int j = 0; j < selectJingYing.length; j++) {
						
						String ids = jingyinglist.get(i).getId().toString();
						
						if(selectJingYing[j].equals( ids )){
							selectjingyinglist.add( jingyinglist.get(i) );
							
							jingyinglist.remove(i);
							i--;
								
							break;
						}
					}
				}
			}
		}
		
		request.setAttribute("jingyinglist", jingyinglist);
		request.setAttribute("selectjingyinglist", selectjingyinglist);
		
		
		request.setAttribute("singlecheliang", singlecheliang);
		
		request.setAttribute("singlejiaoqiangxian", singlejiaoqiangxian);
		request.setAttribute("singleshangyexian", singleshangyexian);
		request.setAttribute("singlechengyunrenzerenxian", singlechengyunrenzerenxian);
		request.setAttribute("singleguzhuzerenxian", singleguzhuzerenxian);
		request.setAttribute("singletuantiyiwaixian", singletuantiyiwaixian);
		request.setAttribute("singlechechuanxian", singlechechuanxian);
		
		
		session.setAttribute("singlecheliang", singlecheliang);
		
		session.setAttribute("singlejiaoqiangxian", singlejiaoqiangxian);
		session.setAttribute("singleshangyexian", singleshangyexian);
		session.setAttribute("singlechengyunrenzerenxian", singlechengyunrenzerenxian);
		session.setAttribute("singleguzhuzerenxian", singleguzhuzerenxian);
		session.setAttribute("singletuantiyiwaixian", singletuantiyiwaixian);
		session.setAttribute("singlechechuanxian", singlechechuanxian);
		
//		发送审核通过的驾驶员
		JiaShiYuanController.sendJiaShiYuanShenHeTongGuo(jiaShiYuanService);
//		发送车辆管理集合对象
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
		
		
		picturepathlist = (ArrayList<String>) session.getAttribute("picturepathlist");
		deletezhengjianlist = (ArrayList<String>) session.getAttribute("deletezhengjianlist");
		
		if(picturepathlist == null) {
			picturepathlist = new ArrayList<String>();
		}
		if(deletezhengjianlist == null) {
			deletezhengjianlist = new ArrayList<String>();
		}
		picturepathlist.clear();	//清空图片路径 
		deletezhengjianlist.clear(); //清空删除图片路径
		
		session.setAttribute("picturepathlist", picturepathlist);
		session.setAttribute("deletezhengjianlist", deletezhengjianlist);
		
		return "success";
	}
	
	/**
	 *  提交修改车辆
	 */
	public String submitUpdateCheLiang(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("提交修改车辆");
//		设置字符格式
		FontFormat.setFontFormat(response);	
//		得到车辆业务对象
								
//		得到保险业务对象
		
//		得到年审业务对象
		
		  singlejiaoqiangxian = (BaoXian) session.getAttribute("singlejiaoqiangxian");
		  singleshangyexian = (BaoXian) session.getAttribute("singleshangyexian");
		  singlechengyunrenzerenxian = (BaoXian) session.getAttribute("singlechengyunrenzerenxian");
		 singleguzhuzerenxian = (BaoXian) session.getAttribute("singleguzhuzerenxian");
		  singletuantiyiwaixian = (BaoXian) session.getAttribute("singletuantiyiwaixian");
		  singlechechuanxian = (BaoXian) session.getAttribute("singlechechuanxian");
		
		
		Users users =  (Users) session.getAttribute("users");
		
		singlecheliang = (CheLiang) session.getAttribute("singlecheliang");
		
//		判断是否有驾驶员 
		String jiashiyuan1xm =singlecheliang.getJiayayuan1();
		String jiashiyuan2xm =singlecheliang.getJiayayuan2();
		
		if(jiashiyuan1xm!=null &&  !"".equals(jiashiyuan1xm) && !"请选择".equals(jiashiyuan1xm) ){
			try {
				JiaShiYuan jiashiyuan1 = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(singlecheliang.getJiayayuan1()));
				jiashiyuan1.setJiashicheliang("");
				jiaShiYuanService.updateJiaShiYuan(jiashiyuan1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(jiashiyuan2xm!=null &&  !"".equals(jiashiyuan2xm) && !"请选择".equals(jiashiyuan2xm) ){
			try {
				JiaShiYuan jiashiyuan2 = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(singlecheliang.getJiayayuan2()));
				jiashiyuan2.setJiashicheliang("");
				jiaShiYuanService.updateJiaShiYuan(jiashiyuan2);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
//		同步驾驶员
		if(jiayayuan1!=null &&  !"".equals(jiayayuan1) && !"请选择".equals(jiayayuan1) ){
			try {
				JiaShiYuan singlejiashiyuan1 = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(jiayayuan1));
				singlejiashiyuan1.setJiashicheliang(chepaihao);
				jiaShiYuanService.updateJiaShiYuan(singlejiashiyuan1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(jiayayuan2!=null &&  !"".equals(jiayayuan2) && !"请选择".equals(jiayayuan2) ){
			try {
				JiaShiYuan singlejiashiyuan2 = jiaShiYuanService.queryJiaShiYuanId(Integer.valueOf(jiayayuan2));
				singlejiashiyuan2.setJiashicheliang(chepaihao);
				jiaShiYuanService.updateJiaShiYuan(singlejiashiyuan2);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
//		修改年审
		if(nianshenriqi!=null || guantijianceriqi != null || daoluyunshuzhengnianshenriqi != null || erjiweihuriqi != null || dengjipingdingriqi!= null){
			NianShen nianshen = nianShenService.queryNianShenChePaiHao(singlecheliang.getChepaihao());
			if(nianshen == null){
				nianshen = new NianShen();
			}
			
			String caozuoyuan = users.getUsersid().toString();
			Date caozuoriqi = new Date();
			
			Calendar calendar = Calendar.getInstance();
			
			Date nianshendaoqiriqi = null;
			if(nianshenriqi != null){
				calendar.setTime(nianshenriqi);
				calendar.add(Calendar.YEAR, 1);
				nianshendaoqiriqi = calendar.getTime();
			}
			
			
			nianshen.setNianShen(chepaihao, chezhuxingming, shoujihao,
								nianshenriqi, nianshendaoqiriqi, caozuoyuan, caozuoriqi);
			
			
			if(daoluyunshuzhengnianshenriqi != null){
				 calendar.setTime(daoluyunshuzhengnianshenriqi); 
				 calendar.add(Calendar.YEAR, 1);
				 Date daoludaoqiriqi = calendar.getTime();
				 nianshen.setDaoludaoqiriqi(daoludaoqiriqi);
			}
			
			if(erjiweihuriqi != null){
				 calendar.setTime(erjiweihuriqi); 
				 calendar.add(Calendar.MONTH, 4);
				 Date erjidaoqiriqi = calendar.getTime();
				 nianshen.setErjidaoqiriqi(erjidaoqiriqi);
			}
			
			if(dengjipingdingriqi != null){
				calendar.setTime(dengjipingdingriqi); 
				calendar.add(Calendar.YEAR, 1);
				Date dengjidaoqiriqi = calendar.getTime();
				nianshen.setDengjidaoqiriqi(dengjidaoqiriqi);
			}
			
			if(guantijianceriqi != null){
			    calendar.setTime(guantijianceriqi); 
			    calendar.add(Calendar.YEAR, 1);
			    Date guantidaoqiriqi = calendar.getTime();
			    
			    nianshen.setGuantidaoqiriqi(guantidaoqiriqi);
			}	
			
			nianShenService.saveAndUpdate(nianshen);
		}
		
		
		
		String waikuochicun = chang+ "*" + kuan + "*" + gao;
		
//		得到附件
		String fujianstr = "";
		fujianstr = singlecheliang.getShenfenzhengtupian();
		if(fujianstr == null){
			fujianstr = "";
		}

		deletezhengjianlist = (ArrayList<String>) session.getAttribute("deletezhengjianlist");
		
		picturepathlist = (ArrayList<String>) session.getAttribute("picturepathlist");
		
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
		
		String caozuoyuan = users.getUsersid().toString();				
		
		singlecheliang.setCheLiang(chepaihao, chezhuxingming, shoujihao,
				jiayayuan1, jiayayuan2, chexing, 
				cheliangleixing, pingpaixinghao, shibiedaihao, 
				fadongjihao, zongzhiliang, zhengbeizhiliang, 
				hedingzhaizhiliang, zhunqianyingzongzhiliang, waikuochicun, 
				cheliangdaoluyunshuzhenghao, zhuceriqi, nianshenriqi, 
				erjiweihuriqi, daoluyunshuzhengnianshenriqi, yonghumiaoshu, 
				jingyingfanwei, caozuoyuan, new Date(), zhuangtai);
		
		singlecheliang.setDengjipingdingriqi(dengjipingdingriqi);
		singlecheliang.setGuantijianceriqi(guantijianceriqi);

		singlecheliang.setCheLiangTwo( shenfenzhenghao,  addfujianpath,
				 zhengshubianhao,  cheshenyanse,
				 fadongjixinghao,  ranliaozhonglei,  pailiang,
				 gonglv,  changjiamingcheng,  lunjuqian,
				 lunjuhou,  luntaishu,  luntaiguige,
				 gangbantanhuangpianshu,  zhouju,  zhoushu,
				 huoxiangchang,  huoxiangkuan,  huoxianggao,
				 cheliangfenzu);
		
		singlecheliang.setGouchefei(gouchefei);
		
		cheLiangService.updateCheLiang(singlecheliang);
		
		
		if("".equals(jiaoqiangxianbaodanhao) && "".equals(jiaoqiangxianfeiyong) && jiaoqiangxiandaoqishijian==null && singlejiaoqiangxian.getId()==null){
		}else{
			
			if(jiaoqiangxianbaodanhao==null){
				jiaoqiangxianbaodanhao="";
			}
			if(jiaoqiangxianfeiyong==null){
				jiaoqiangxianfeiyong="";
			}
			
			singlejiaoqiangxian.setBaodanhao(jiaoqiangxianbaodanhao);
			singlejiaoqiangxian.setToubaojine(jiaoqiangxianfeiyong);
			singlejiaoqiangxian.setDaoqiriqi(jiaoqiangxiandaoqishijian);
			singlejiaoqiangxian.setBaoxiangongsi(jiaoqiangxiangongsi);
			
			baoXianService.saveAndUpdateBaoXian(singlejiaoqiangxian);
		}
		
		
		if("".equals(shangyexianbaodanhao) && "".equals(shangyexianfeiyong) & shangyexiandaoqishijian==null && singleshangyexian.getId()==null){
		}else{
			
			if(shangyexianbaodanhao==null){
				shangyexianbaodanhao="";
			}
			if(shangyexianfeiyong==null){
				shangyexianfeiyong="";
			}
			
			singleshangyexian.setBaodanhao(shangyexianbaodanhao);
			singleshangyexian.setToubaojine(shangyexianfeiyong);
			singleshangyexian.setDaoqiriqi(shangyexiandaoqishijian);
			singleshangyexian.setBaoxiangongsi(shangyexiangongsi);
			
			baoXianService.saveAndUpdateBaoXian(singleshangyexian);
		}
		
		
		
		if("".equals(chengyunrenbaodanhao) && "".equals(chengyunrenfeiyong) && chengyunrendaoqishijian==null && singlechengyunrenzerenxian.getId()==null){
		}else{
			
			if(chengyunrenbaodanhao==null){
				chengyunrenbaodanhao="";
			}
			if(chengyunrenfeiyong==null){
				chengyunrenfeiyong="";
			}
			
			singlechengyunrenzerenxian.setBaodanhao(chengyunrenbaodanhao);
			singlechengyunrenzerenxian.setToubaojine(chengyunrenfeiyong);
			singlechengyunrenzerenxian.setDaoqiriqi(chengyunrendaoqishijian);
			singlechengyunrenzerenxian.setBaoxiangongsi(chengyunrengongsi);
			
			baoXianService.saveAndUpdateBaoXian(singlechengyunrenzerenxian);
		}
		
		
		
		
		if("".equals(guzhubaodanhao) && "".equals(guzhufeiyong) && guzhudaoqishijian==null && singleguzhuzerenxian.getId()==null){
		}else{
			
			if(guzhubaodanhao==null){
				guzhubaodanhao="";
			}
			if(guzhufeiyong==null){
				guzhufeiyong="";
			}
			
			singleguzhuzerenxian.setBaodanhao(guzhubaodanhao);
			singleguzhuzerenxian.setToubaojine(guzhufeiyong);
			singleguzhuzerenxian.setDaoqiriqi(guzhudaoqishijian);
			singleguzhuzerenxian.setBaoxiangongsi(guzhugongsi);
			
			baoXianService.saveAndUpdateBaoXian(singleguzhuzerenxian);
		}
		
		
		if("".equals(tuantixianbaodanhao) && "".equals(tuantixianfeiyong) && tuantixiandaoqishijian==null && singletuantiyiwaixian.getId()==null){
		}else{
			
			if(tuantixianbaodanhao==null){
				tuantixianbaodanhao="";
			}
			if(tuantixianfeiyong==null){
				tuantixianfeiyong="";
			}
			
			singletuantiyiwaixian.setBaodanhao(tuantixianbaodanhao);
			singletuantiyiwaixian.setToubaojine(tuantixianfeiyong);
			singletuantiyiwaixian.setDaoqiriqi(tuantixiandaoqishijian);
			singletuantiyiwaixian.setBaoxiangongsi(tuantigongsi);
			
			baoXianService.saveAndUpdateBaoXian(singletuantiyiwaixian);
		}
		
//		车船险
		if(chechuanxiandaoqishijian!=null || !"".equals(chechuanxianbaodanhao) || !"".equals(chechuanxianfeiyong) ){
			
			if(chechuanxianbaodanhao==null){
				chechuanxianbaodanhao="";
			}
			if(chechuanxianfeiyong==null){
				chechuanxianfeiyong="";
			}
			
			singlechechuanxian.setBaodanhao(chechuanxianbaodanhao);
			singlechechuanxian.setToubaojine(chechuanxianfeiyong);
			singlechechuanxian.setDaoqiriqi(chechuanxiandaoqishijian);
			singlechechuanxian.setBaoxiangongsi(chechuanxiangongsi);
			
			baoXianService.saveAndUpdateBaoXian(singlechechuanxian);
			
		}
		
		
//		费用收取 同步
		FeiYongShouQuController.SynchronizationFeiYongShouQu(chezhuxingming , feiYongShouQuService
															,  cheLiangService , yingShouKuanService
															,  yunDanService ,  baoXianService
															);
		
		
//		发送车辆管理集合对象
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
			
//		发送驾驶员集合对象
		JiaShiYuanController.sendJiaShiYuan(jiaShiYuanService);
		
		return "success";
	}
	
	/**
	 *  违规登记
	 */
	public String weiguidengji(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("违规登记");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1 || id.length>1){
//			发送车辆管理集合对象
			CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
			return "err";
		}			
					
		
		singlecheliang = cheLiangService.queryIdCheLiang(Integer.valueOf(id[0]));
		
		session.setAttribute("singlecheliang", singlecheliang);
		
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
	/**
	 *  提交违规登记
	 */
	public String submitweiguidengji(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("提交违规登记");
//		设置字符格式
		FontFormat.setFontFormat(response);
			
		singlecheliang = (CheLiang) session.getAttribute("singlecheliang");
		
		CheLiang cheliang = singlecheliang;
		Users users = (Users) session.getAttribute("users");
		
		cheliang.setZhuangtai("禁用");
		cheliang.setYonghumiaoshu(yonghumiaoshu);
		cheliang.setCaozuoyuan(users.getUsername());
		cheliang.setCaozuoriqi(new Date());
		
		cheLiangService.updateCheLiang(cheliang);
		
		
//		发送车辆管理集合对象
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
		
//		发送驾驶员集合对象
		JiaShiYuanController.sendJiaShiYuan(jiaShiYuanService);
		
//		发送用户集合对象
		UsersController.sendUsers(usersService);
		
		return "success";
	}
	
	/**
	 *  违规撤销
	 */
	public String weiguichexiao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("违规撤销");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id==null || id.length<1 || id.length>1){
//			发送车辆管理集合对象
			CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
			return "err";
		}			
					
		
		 singlecheliang = cheLiangService.queryIdCheLiang(Integer.valueOf(id[0]));
		
		 session.setAttribute("singlecheliang", singlecheliang);
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
	/**
	 *  提交违规撤销
	 */
	public String submitweiguichexiao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("提交违规撤销");
//		设置字符格式
		FontFormat.setFontFormat(response);
			
		singlecheliang = (CheLiang) session.getAttribute("singlecheliang");			
		
		CheLiang cheliang = singlecheliang;
		Users users = (Users) session.getAttribute("users");
		
		cheliang.setZhuangtai("可用");
		cheliang.setYonghumiaoshu(yonghumiaoshu);
		cheliang.setCaozuoyuan(users.getUsername());
		cheliang.setCaozuoriqi(new Date());
		
		
		cheLiangService.updateCheLiang(cheliang);
		
		
//		发送车辆管理集合对象
		CheLiangGuanLiController.sendCheLiangGuanLi(cheLiangGuanLiService);
		
//		发送驾驶员集合对象
		JiaShiYuanController.sendJiaShiYuan(jiaShiYuanService);
		
//		发送用户集合对象
		UsersController.sendUsers(usersService);
		
		return "success";
	}
	
//	导出excel
	public void exportCheLiang(){
		
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
			
		
		List<CheLiang> chelianglist = cheLiangService.queryCheLiangList();
		
//		判断车辆是否为空
		if(chelianglist==null || chelianglist.size()<1){
			return ;
		}
		
		
		
//		创建车辆模版集合对象
		ArrayList<CheLiangJsonModel> cheliangjsonmodel = new ArrayList<CheLiangJsonModel>();
//		创建格式化日期对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < chelianglist.size(); i++) {
			
			CheLiang cheliang = chelianglist.get(i);
			String id = String.valueOf(cheliang.getId());
			
			String chepaihao = cheliang.getChepaihao();
			
			String jiayayuan = "";
			if( !"请选择".equals(cheliang.getJiayayuan1()) ){
				jiayayuan = cheliang.getJiayayuan1();
			}
			if( !"请选择".equals(cheliang.getJiayayuan2()) ){
				jiayayuan = jiayayuan+","+cheliang.getJiayayuan2();
			}
			
			String chexingid = cheliang.getChexing();
			String chexing="";
			try {
				if(chexingid!=null &&  !"".equals(chexingid)){
					chexing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(chexingid)).getName();
				}
			} catch (Exception e) {
			}
			
			
			String cheliangleixingid = cheliang.getCheliangleixing();
			String cheliangleixing="";
			try {
				if(cheliangleixingid!=null && !"".equals(cheliangleixingid)){
					cheliangleixing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliangleixingid)).getName();
				}
			} catch (Exception e) {
			}
			
			Date  date = cheliang.getZhuceriqi();
			
			String zhuceriqi="";
//			判断得到的日期是否为空
			if(date==null){
				zhuceriqi="";
			}else{
				zhuceriqi= sdf.format(date);
			}
			
			String zhuangtai = cheliang.getZhuangtai();
			String beizhu = cheliang.getYonghumiaoshu();
			String caozuoyuan = cheliang.getCaozuoyuan();
			
			
			
			 String  chezhuxingming = cheliang.getChezhuxingming();
			 String  shoujihao = cheliang.getShoujihao(); //手机号
			 String  pingpaixinghao = cheliang.getPingpaixinghao(); //品牌型号
			 try {
					if(pingpaixinghao!=null && !"".equals(pingpaixinghao)){
						pingpaixinghao = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(pingpaixinghao)).getName();
					}
			} catch (Exception e) {
			}
			 String  shibiedaihao = cheliang.getShibiedaihao();  //识别代号
			 String  fadongjihao  = cheliang.getFadongjihao();  //发动机号
			 String  zongzhiliang = cheliang.getZongzhiliang(); //总质量  
			 String  zhengbeizhiliang = cheliang.getZhengbeizhiliang(); //整备质量
			 String  hedingzhaizhiliang = cheliang.getHedingzhaizhiliang(); //核定载质量
			 String  zhunqianyingzongzhiliang = cheliang.getZhunqianyingzongzhiliang(); //准牵引总质量
			 
			 String  waikuochicun = cheliang.getWaikuochicun(); //外扩尺寸
			 if(waikuochicun != null){
				 String waikuoArr[] = waikuochicun.split("\\*");
				 waikuochicun = "";
				 for (int j = 0; j < waikuoArr.length; j++) {
					 if(j != waikuoArr.length-1){
						 if(!"".equals(waikuoArr[j])){
							 waikuochicun = waikuochicun + waikuoArr[j] + "*" ;
						 }
					 }else{
						 if(!"".equals(waikuoArr[j])){
							 waikuochicun = waikuochicun + waikuoArr[j] ;
						 }
					 }
				}
				 
			 }
			 
			 String  cheliangdaoluyunshuzhenghao = cheliang.getCheliangdaoluyunshuzhenghao(); //车辆道路运输证号
			 
			 String    nianshenriqi= "" ; //年审日期
			 if(cheliang.getNianshenriqi() != null){
				 nianshenriqi = sdf.format(cheliang.getNianshenriqi());
			 }
			 
			 String    erjiweihuriqi = ""; //二级维护日期
			 if(cheliang.getErjiweihuriqi() != null){
				 erjiweihuriqi = sdf.format(cheliang.getErjiweihuriqi());
			 }
			 
			 String    daoluyunshuzhengnianshenriqi = ""; //道路运输证年审日期
			 if(cheliang.getDaoluyunshuzhengnianshenriqi() != null){
				 daoluyunshuzhengnianshenriqi = sdf.format(cheliang.getDaoluyunshuzhengnianshenriqi());
			 }
			 
			 String  yonghumiaoshu = cheliang.getYonghumiaoshu();   //用户描述
			 String  jingyingfanweiStr = cheliang.getJingyingfanwei();   //经营范围
			 
			 String jingyingfanwei = "";
			 
			 if(jingyingfanweiStr != null && !"".equals(jingyingfanweiStr)){
				 try {
				
					String jingyingfanweiStrArr[] = jingyingfanweiStr.split(", ");
					for (int j = 0; j < jingyingfanweiStrArr.length; j++) {
							if(j == 0){
								jingyingfanwei = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(jingyingfanweiStrArr[j])).getName();
							}else{
								jingyingfanwei = jingyingfanwei + " , " + cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(jingyingfanweiStrArr[j])).getName();
							}
					}
					
				} catch (Exception e) {
						// TODO: handle exception
				}
			 }
			 
			
			String  dengjipingdingriqi="";	//等级评定日期
			if(cheliang.getDengjipingdingriqi() != null){
				dengjipingdingriqi = sdf.format(cheliang.getDengjipingdingriqi());
			}
			
			String guantijianceriqi = "";	//罐体检测日期
			if(cheliang.getGuantijianceriqi() != null){
				guantijianceriqi = sdf.format(cheliang.getGuantijianceriqi());
			}
			
			 String shenfenzhenghao = cheliang.getShenfenzhenghao();	//身份证号
			 String zhengshubianhao = cheliang.getZhengshubianhao();	//证书编号
			 String cheshenyanse = cheliang.getCheshenyanse();	//车身颜色
			 String fadongjixinghao = cheliang.getFadongjixinghao();	//发动机型号
			 String ranliaozhonglei = cheliang.getRanliaozhonglei();	//燃料种类
			 String pailiang = cheliang.getPailiang();	//排量
			 String gonglv = cheliang.getGonglv();	//功率
			 String changjiamingcheng = cheliang.getChangjiamingcheng();	//厂家名称
			 
			 String lunjuqian = "";
			 if(cheliang.getLunjuqian() != null && !"".equals(cheliang.getLunjuqian())){
				 lunjuqian = cheliang.getLunjuqian();
			 }
			 String lunjuhou = "";
			 if(cheliang.getLunjuhou() != null && !"".equals(cheliang.getLunjuhou())){
				 lunjuhou = cheliang.getLunjuhou();
			 }
			 String lunju = "";
			 if(lunjuqian != null && !"".equals(lunjuqian)){
				 lunju = lunjuqian+"/" ;
			 }
			 if(lunjuhou != null && !"".equals(lunjuhou)){
				 lunju = lunju + lunjuhou;
			 }
			 
			 String luntaishu = cheliang.getLuntaishu();	//轮胎数
			 String luntaiguige = cheliang.getLuntaiguige();	//轮胎规格
			 String gangbantanhuangpianshu = cheliang.getGangbantanhuangpianshu();	//钢板弹簧片数
			 String zhouju = cheliang.getZhouju();	//轴距
			 String zhoushu = cheliang.getZhoushu();	//轴数
			 
			 String huoxiangchang = "";
			 if(cheliang.getHuoxiangchang() != null && !"".equals(cheliang.getHuoxiangchang())){
				 huoxiangchang = cheliang.getHuoxiangchang();
			 }
			 String huoxiangkuan = "";
			 if(cheliang.getHuoxiangkuan() != null && !"".equals(cheliang.getHuoxiangkuan())){
				 huoxiangkuan = cheliang.getHuoxiangkuan();
			 }
			 String huoxianggao = "";
			 if(cheliang.getHuoxianggao() != null && !"".equals(cheliang.getHuoxianggao())){
				 huoxianggao = cheliang.getHuoxianggao();
			 }
			 String huoxiang  = "";	//货箱
			 if(huoxiangchang != null && !"".equals(huoxiangchang)){
				 huoxiang = huoxiang + huoxiangchang+"/";
			 }
			 if(huoxiangkuan != null && !"".equals(huoxiangkuan)){
				 huoxiang = huoxiang + huoxiangkuan+"/";
			 }
			 if(huoxianggao != null && !"".equals(huoxianggao)){
				 huoxiang = huoxiang + huoxianggao;
			 }
			 
			 String cheliangfenzu = "";	//车辆分组
			 String cheliangfenzuId = cheliang.getCheliangfenzu();
			 try {
				 if(cheliangfenzuId!=null &&  !"".equals(cheliangfenzuId)){
					 cheliangfenzu = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliangfenzuId)).getName();
				 }
			} catch (Exception e) {
			}			
			 
			CheLiangJsonModel cljm = new CheLiangJsonModel();
			
			cljm.setCheLiangJsonModel( id,  chepaihao,  jiayayuan,
					 chexing,  cheliangleixing,  zhuceriqi,
					 zhuangtai,  beizhu,  caozuoyuan,
					 chezhuxingming,  shoujihao,  pingpaixinghao,
					 shibiedaihao,  fadongjihao,  zongzhiliang,
					 zhengbeizhiliang,  hedingzhaizhiliang,
					 zhunqianyingzongzhiliang,  waikuochicun,
					 cheliangdaoluyunshuzhenghao,  nianshenriqi,
					 erjiweihuriqi,  daoluyunshuzhengnianshenriqi,
					 yonghumiaoshu,  jingyingfanwei,
					 dengjipingdingriqi,  guantijianceriqi);
			
			cljm.setCheLiangJsonModelValue( shenfenzhenghao,  zhengshubianhao,
					 cheshenyanse,  fadongjixinghao,
					 ranliaozhonglei,  pailiang,  gonglv,
					 changjiamingcheng,  lunju,  luntaishu,
					 luntaiguige,  gangbantanhuangpianshu,  zhouju,
					 zhoushu,  huoxiang,  cheliangfenzu);
			
			cheliangjsonmodel.add(cljm);
			
		}
		
		JSONArray ja = JSONArray.fromObject(cheliangjsonmodel);
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	
//	新车管理 -----------------------
	
	/**
	 *  跳转-新车管理
	 */
	public String jumpXinCheGuanLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		发送车辆
		sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  模糊查询新车管理
	 */
	public String vagueSearchXinCheGuanLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("模糊查询新车管理");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
				
		Users users = (Users) session.getAttribute("users");
		
		List<CheLiang> chelianglist = cheLiangService.vagueSearchXinCheGuanLi(chepaihao, users.getUsername());
		
		request.setAttribute("chelianglist", chelianglist);
		
		return "success";
	}
	
	
	
	/**
	 *  get set
	 */
	public String getChepaihao() {
		return chepaihao;
	}

	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}

	public String getChezhuxingming() {
		return chezhuxingming;
	}

	public void setChezhuxingming(String chezhuxingming) {
		this.chezhuxingming = chezhuxingming;
	}

	public String getShoujihao() {
		return shoujihao;
	}

	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}

	public String getJiayayuan1() {
		return jiayayuan1;
	}

	public void setJiayayuan1(String jiayayuan1) {
		this.jiayayuan1 = jiayayuan1;
	}

	public String getJiayayuan2() {
		return jiayayuan2;
	}

	public void setJiayayuan2(String jiayayuan2) {
		this.jiayayuan2 = jiayayuan2;
	}

	public String getChexing() {
		return chexing;
	}

	public void setChexing(String chexing) {
		this.chexing = chexing;
	}

	public String getCheliangleixing() {
		return cheliangleixing;
	}

	public void setCheliangleixing(String cheliangleixing) {
		this.cheliangleixing = cheliangleixing;
	}

	public String getPingpaixinghao() {
		return pingpaixinghao;
	}

	public void setPingpaixinghao(String pingpaixinghao) {
		this.pingpaixinghao = pingpaixinghao;
	}

	public String getShibiedaihao() {
		return shibiedaihao;
	}

	public void setShibiedaihao(String shibiedaihao) {
		this.shibiedaihao = shibiedaihao;
	}

	public String getFadongjihao() {
		return fadongjihao;
	}

	public void setFadongjihao(String fadongjihao) {
		this.fadongjihao = fadongjihao;
	}

	public String getZongzhiliang() {
		return zongzhiliang;
	}

	public void setZongzhiliang(String zongzhiliang) {
		this.zongzhiliang = zongzhiliang;
	}

	public String getZhengbeizhiliang() {
		return zhengbeizhiliang;
	}

	public void setZhengbeizhiliang(String zhengbeizhiliang) {
		this.zhengbeizhiliang = zhengbeizhiliang;
	}

	public String getHedingzhaizhiliang() {
		return hedingzhaizhiliang;
	}

	public void setHedingzhaizhiliang(String hedingzhaizhiliang) {
		this.hedingzhaizhiliang = hedingzhaizhiliang;
	}

	public String getZhunqianyingzongzhiliang() {
		return zhunqianyingzongzhiliang;
	}

	public void setZhunqianyingzongzhiliang(String zhunqianyingzongzhiliang) {
		this.zhunqianyingzongzhiliang = zhunqianyingzongzhiliang;
	}


	public String getCheliangdaoluyunshuzhenghao() {
		return cheliangdaoluyunshuzhenghao;
	}

	public void setCheliangdaoluyunshuzhenghao(String cheliangdaoluyunshuzhenghao) {
		this.cheliangdaoluyunshuzhenghao = cheliangdaoluyunshuzhenghao;
	}

	public Date getZhuceriqi() {
		return zhuceriqi;
	}

	public void setZhuceriqi(Date zhuceriqi) {
		this.zhuceriqi = zhuceriqi;
	}

	public Date getNianshenriqi() {
		return nianshenriqi;
	}

	public void setNianshenriqi(Date nianshenriqi) {
		this.nianshenriqi = nianshenriqi;
	}

	public Date getErjiweihuriqi() {
		return erjiweihuriqi;
	}

	public void setErjiweihuriqi(Date erjiweihuriqi) {
		this.erjiweihuriqi = erjiweihuriqi;
	}

	public Date getDaoluyunshuzhengnianshenriqi() {
		return daoluyunshuzhengnianshenriqi;
	}

	public void setDaoluyunshuzhengnianshenriqi(Date daoluyunshuzhengnianshenriqi) {
		this.daoluyunshuzhengnianshenriqi = daoluyunshuzhengnianshenriqi;
	}

	public String getYonghumiaoshu() {
		return yonghumiaoshu;
	}

	public void setYonghumiaoshu(String yonghumiaoshu) {
		this.yonghumiaoshu = yonghumiaoshu;
	}

	public String getJingyingfanwei() {
		return jingyingfanwei;
	}

	public void setJingyingfanwei(String jingyingfanwei) {
		this.jingyingfanwei = jingyingfanwei;
	}

	public String getJiaoqiangxianbaodanhao() {
		return jiaoqiangxianbaodanhao;
	}

	public void setJiaoqiangxianbaodanhao(String jiaoqiangxianbaodanhao) {
		this.jiaoqiangxianbaodanhao = jiaoqiangxianbaodanhao;
	}

	public String getJiaoqiangxianfeiyong() {
		return jiaoqiangxianfeiyong;
	}

	public void setJiaoqiangxianfeiyong(String jiaoqiangxianfeiyong) {
		this.jiaoqiangxianfeiyong = jiaoqiangxianfeiyong;
	}

	public Date getJiaoqiangxiandaoqishijian() {
		return jiaoqiangxiandaoqishijian;
	}

	public void setJiaoqiangxiandaoqishijian(Date jiaoqiangxiandaoqishijian) {
		this.jiaoqiangxiandaoqishijian = jiaoqiangxiandaoqishijian;
	}

	public String getShangyexianbaodanhao() {
		return shangyexianbaodanhao;
	}

	public void setShangyexianbaodanhao(String shangyexianbaodanhao) {
		this.shangyexianbaodanhao = shangyexianbaodanhao;
	}

	public String getShangyexianfeiyong() {
		return shangyexianfeiyong;
	}

	public void setShangyexianfeiyong(String shangyexianfeiyong) {
		this.shangyexianfeiyong = shangyexianfeiyong;
	}

	public Date getShangyexiandaoqishijian() {
		return shangyexiandaoqishijian;
	}

	public void setShangyexiandaoqishijian(Date shangyexiandaoqishijian) {
		this.shangyexiandaoqishijian = shangyexiandaoqishijian;
	}

	public String getChengyunrenbaodanhao() {
		return chengyunrenbaodanhao;
	}

	public void setChengyunrenbaodanhao(String chengyunrenbaodanhao) {
		this.chengyunrenbaodanhao = chengyunrenbaodanhao;
	}

	public String getChengyunrenfeiyong() {
		return chengyunrenfeiyong;
	}

	public void setChengyunrenfeiyong(String chengyunrenfeiyong) {
		this.chengyunrenfeiyong = chengyunrenfeiyong;
	}

	public Date getChengyunrendaoqishijian() {
		return chengyunrendaoqishijian;
	}

	public void setChengyunrendaoqishijian(Date chengyunrendaoqishijian) {
		this.chengyunrendaoqishijian = chengyunrendaoqishijian;
	}

	public String getGuzhubaodanhao() {
		return guzhubaodanhao;
	}

	public void setGuzhubaodanhao(String guzhubaodanhao) {
		this.guzhubaodanhao = guzhubaodanhao;
	}

	public String getGuzhufeiyong() {
		return guzhufeiyong;
	}

	public void setGuzhufeiyong(String guzhufeiyong) {
		this.guzhufeiyong = guzhufeiyong;
	}

	public Date getGuzhudaoqishijian() {
		return guzhudaoqishijian;
	}

	public void setGuzhudaoqishijian(Date guzhudaoqishijian) {
		this.guzhudaoqishijian = guzhudaoqishijian;
	}

	public String getTuantixianbaodanhao() {
		return tuantixianbaodanhao;
	}

	public void setTuantixianbaodanhao(String tuantixianbaodanhao) {
		this.tuantixianbaodanhao = tuantixianbaodanhao;
	}

	public String getTuantixianfeiyong() {
		return tuantixianfeiyong;
	}

	public void setTuantixianfeiyong(String tuantixianfeiyong) {
		this.tuantixianfeiyong = tuantixianfeiyong;
	}

	public Date getTuantixiandaoqishijian() {
		return tuantixiandaoqishijian;
	}

	public void setTuantixiandaoqishijian(Date tuantixiandaoqishijian) {
		this.tuantixiandaoqishijian = tuantixiandaoqishijian;
	}

	public String getZhuangtai() {
		return zhuangtai;
	}
	
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}


	public Date getGuantijianceriqi() {
		return guantijianceriqi;
	}


	public void setGuantijianceriqi(Date guantijianceriqi) {
		this.guantijianceriqi = guantijianceriqi;
	}


	public Date getDengjipingdingriqi() {
		return dengjipingdingriqi;
	}


	public void setDengjipingdingriqi(Date dengjipingdingriqi) {
		this.dengjipingdingriqi = dengjipingdingriqi;
	}


	public String getChang() {
		return chang;
	}


	public void setChang(String chang) {
		this.chang = chang;
	}


	public String getKuan() {
		return kuan;
	}


	public void setKuan(String kuan) {
		this.kuan = kuan;
	}


	public String getGao() {
		return gao;
	}


	public void setGao(String gao) {
		this.gao = gao;
	}


	public String getJiaoqiangxiangongsi() {
		return jiaoqiangxiangongsi;
	}


	public void setJiaoqiangxiangongsi(String jiaoqiangxiangongsi) {
		this.jiaoqiangxiangongsi = jiaoqiangxiangongsi;
	}


	public String getShangyexiangongsi() {
		return shangyexiangongsi;
	}


	public void setShangyexiangongsi(String shangyexiangongsi) {
		this.shangyexiangongsi = shangyexiangongsi;
	}


	public String getChengyunrengongsi() {
		return chengyunrengongsi;
	}


	public void setChengyunrengongsi(String chengyunrengongsi) {
		this.chengyunrengongsi = chengyunrengongsi;
	}


	public String getGuzhugongsi() {
		return guzhugongsi;
	}


	public void setGuzhugongsi(String guzhugongsi) {
		this.guzhugongsi = guzhugongsi;
	}


	public String getTuantigongsi() {
		return tuantigongsi;
	}


	public void setTuantigongsi(String tuantigongsi) {
		this.tuantigongsi = tuantigongsi;
	}


	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}


	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}


	public String getZhengshubianhao() {
		return zhengshubianhao;
	}


	public void setZhengshubianhao(String zhengshubianhao) {
		this.zhengshubianhao = zhengshubianhao;
	}


	public String getCheshenyanse() {
		return cheshenyanse;
	}


	public void setCheshenyanse(String cheshenyanse) {
		this.cheshenyanse = cheshenyanse;
	}


	public String getFadongjixinghao() {
		return fadongjixinghao;
	}


	public void setFadongjixinghao(String fadongjixinghao) {
		this.fadongjixinghao = fadongjixinghao;
	}


	public String getRanliaozhonglei() {
		return ranliaozhonglei;
	}


	public void setRanliaozhonglei(String ranliaozhonglei) {
		this.ranliaozhonglei = ranliaozhonglei;
	}


	public String getPailiang() {
		return pailiang;
	}


	public void setPailiang(String pailiang) {
		this.pailiang = pailiang;
	}


	public String getGonglv() {
		return gonglv;
	}


	public void setGonglv(String gonglv) {
		this.gonglv = gonglv;
	}


	public String getChangjiamingcheng() {
		return changjiamingcheng;
	}


	public void setChangjiamingcheng(String changjiamingcheng) {
		this.changjiamingcheng = changjiamingcheng;
	}


	public String getLunjuqian() {
		return lunjuqian;
	}


	public void setLunjuqian(String lunjuqian) {
		this.lunjuqian = lunjuqian;
	}


	public String getLunjuhou() {
		return lunjuhou;
	}


	public void setLunjuhou(String lunjuhou) {
		this.lunjuhou = lunjuhou;
	}


	public String getLuntaishu() {
		return luntaishu;
	}


	public void setLuntaishu(String luntaishu) {
		this.luntaishu = luntaishu;
	}


	public String getLuntaiguige() {
		return luntaiguige;
	}


	public void setLuntaiguige(String luntaiguige) {
		this.luntaiguige = luntaiguige;
	}


	public String getGangbantanhuangpianshu() {
		return gangbantanhuangpianshu;
	}


	public void setGangbantanhuangpianshu(String gangbantanhuangpianshu) {
		this.gangbantanhuangpianshu = gangbantanhuangpianshu;
	}


	public String getZhouju() {
		return zhouju;
	}


	public void setZhouju(String zhouju) {
		this.zhouju = zhouju;
	}


	public String getHuoxiangchang() {
		return huoxiangchang;
	}


	public void setHuoxiangchang(String huoxiangchang) {
		this.huoxiangchang = huoxiangchang;
	}


	public String getHuoxiangkuan() {
		return huoxiangkuan;
	}


	public void setHuoxiangkuan(String huoxiangkuan) {
		this.huoxiangkuan = huoxiangkuan;
	}


	public String getHuoxianggao() {
		return huoxianggao;
	}


	public void setHuoxianggao(String huoxianggao) {
		this.huoxianggao = huoxianggao;
	}


	public String getCheliangfenzu() {
		return cheliangfenzu;
	}


	public void setCheliangfenzu(String cheliangfenzu) {
		this.cheliangfenzu = cheliangfenzu;
	}


	public String getChechuanxianbaodanhao() {
		return chechuanxianbaodanhao;
	}


	public void setChechuanxianbaodanhao(String chechuanxianbaodanhao) {
		this.chechuanxianbaodanhao = chechuanxianbaodanhao;
	}


	public String getChechuanxianfeiyong() {
		return chechuanxianfeiyong;
	}


	public void setChechuanxianfeiyong(String chechuanxianfeiyong) {
		this.chechuanxianfeiyong = chechuanxianfeiyong;
	}


	public Date getChechuanxiandaoqishijian() {
		return chechuanxiandaoqishijian;
	}


	public void setChechuanxiandaoqishijian(Date chechuanxiandaoqishijian) {
		this.chechuanxiandaoqishijian = chechuanxiandaoqishijian;
	}


	public String getChechuanxiangongsi() {
		return chechuanxiangongsi;
	}


	public void setChechuanxiangongsi(String chechuanxiangongsi) {
		this.chechuanxiangongsi = chechuanxiangongsi;
	}


	public String getZhoushu() {
		return zhoushu;
	}


	public void setZhoushu(String zhoushu) {
		this.zhoushu = zhoushu;
	}


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


	public String getGouchefei() {
		return gouchefei;
	}


	public void setGouchefei(String gouchefei) {
		this.gouchefei = gouchefei;
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

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public CheLiangGuanLiService getCheLiangGuanLiService() {
		return cheLiangGuanLiService;
	}

	public void setCheLiangGuanLiService(CheLiangGuanLiService cheLiangGuanLiService) {
		this.cheLiangGuanLiService = cheLiangGuanLiService;
	}

	public CheLiangGuanXiService getCheLiangGuanXiService() {
		return cheLiangGuanXiService;
	}

	public void setCheLiangGuanXiService(CheLiangGuanXiService cheLiangGuanXiService) {
		this.cheLiangGuanXiService = cheLiangGuanXiService;
	}

	public CheLiangBeiFenService getCheLiangBeiFenService() {
		return cheLiangBeiFenService;
	}

	public void setCheLiangBeiFenService(CheLiangBeiFenService cheLiangBeiFenService) {
		this.cheLiangBeiFenService = cheLiangBeiFenService;
	}

	public BaoXianService getBaoXianService() {
		return baoXianService;
	}

	public void setBaoXianService(BaoXianService baoXianService) {
		this.baoXianService = baoXianService;
	}

	public NianShenService getNianShenService() {
		return nianShenService;
	}

	public void setNianShenService(NianShenService nianShenService) {
		this.nianShenService = nianShenService;
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

	public FeiYongShouQuService getFeiYongShouQuService() {
		return feiYongShouQuService;
	}

	public void setFeiYongShouQuService(FeiYongShouQuService feiYongShouQuService) {
		this.feiYongShouQuService = feiYongShouQuService;
	}

	public YingShouKuanService getYingShouKuanService() {
		return yingShouKuanService;
	}

	public void setYingShouKuanService(YingShouKuanService yingShouKuanService) {
		this.yingShouKuanService = yingShouKuanService;
	}

	public YunDanService getYunDanService() {
		return yunDanService;
	}

	public void setYunDanService(YunDanService yunDanService) {
		this.yunDanService = yunDanService;
	}


	
	


	
}
