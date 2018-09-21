package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DecimalFormat;
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

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.entity.CheLiang;
import com.entity.Customer;
import com.entity.JieSuanDan;
import com.entity.KaiPiao;
import com.entity.Users;
import com.entity.YingShouKuan;
import com.entity.YunDan;
import com.model.PageServer;
import com.model.YingShouKuanInKaiPiao;
import com.model.YingShouKuanModel;
import com.model.YingShouKuanModelAll;
import com.myutils.FontFormat;
import com.myutils.MyPoi;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianService;
import com.service.CheLiangService;
import com.service.CustomerService;
import com.service.FeiYongShouQuService;
import com.service.JieSuanDanService;
import com.service.KaiPiaoService;
import com.service.YingShouKuanService;
import com.service.YunDanService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *  营收款 控制层
 */
public class YingShouKuanController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public YingShouKuanController() {
		super();
	}
	
	private String dingdanhao;	//订单号
	private String chepaihao;	//车牌号
	private String huowumingcheng;	//货物名称
	
	private String 	daikongtong;	//带空桶
	private String yingshou;	//营收
	private Date 	daozhangshijian;	//到账时间
	private String  fapiaohao;	//发票号
	private Date	kaipiaoshijian;	//开票时间
	private String shuijin;	//税金
	private String guanlifei;	//管理费
	private String shifuyunfei;	//实付运费
	private Date	lingkuanshijian;	//领款时间
	private String  qianshou;	//签收
	
	private String  yingshoukuanzhuangtai;	//营收款状态
	
	private File myexcel;	//file对象
	private String myexcelFileName;	//FileName
	
	private File sonexcel;	//file对象
	private String sonexcelFileName;	//FileName
	
	private String jiesuanzhuangtai;	//结算状态
	private String kehudanwei;	//客户单位
	
	private String kaipiaoshenqing;	//开票申请
	private String fenguankaipiaoshenhe;	//分管开票审核
	private String zongjinglikaipiaoshenhe;	//总经理开票审核
	
	private String jiesuanshenqing;	//结算申请
	private String zongjinglijiesuanshenhe;	//总经理结算审核
	private String dongshizhangjiesuanshenhe;	//董事长结算审核
	
	private String zhenshichezhu;	//真实车主
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private CheLiangService cheLiangService;
	
	private YingShouKuanService yingShouKuanService;
	
	private YunDanService yunDanService;
	
	private CustomerService customerService;
	
	private KaiPiaoService kaiPiaoService;
	
	private FeiYongShouQuService feiYongShouQuService;
	
	private JieSuanDanService jieSuanDanService;
	
	private BaoXianService baoXianService ;
	
	
	
	
	
//	集合对象
	private static List<YingShouKuan> yingshoukuanlist;
	
	private static List<YingShouKuan> yingshoukuanlistall ;
	
	private static List<String> kehudanweilist;
	
	private static List<YingShouKuanInKaiPiao> yingshoukuaninkaipiaolist;
	
	private static List<YingShouKuanInKaiPiao> yingshoukuanindingdanhaolist ;
	
	
	private static List<YingShouKuan> kaipiaoshenqinglist; 
	
	private static List<YingShouKuan> fenguankaipiaoshenhelist;
	
	private static List<YingShouKuan> zongjinglikaipiaoshenhelist;
	
	private static List<YingShouKuan> kaipiaolist;
	
	
	private static List<YingShouKuan> jiesuanshenqinglist; 
	
	private static List<YingShouKuan> zongjinglijiesuanshenhelist ;
	
	private static List<YingShouKuan> dongshizhangjiesuanshenhelist;
	
	private static List<YingShouKuan> jiesuanlist;
	
//	单一对象
	private  YingShouKuan singleyingshoukuan;
	
	private static Customer singlecustomer;
	
	/**
	 *  跳转-营收款
	 */
	public String jumpYingShouKuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println(" 跳转-营收款 ");

//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	
	
	/**
	 *  营收款json
	 */
	public void yingShouKuanJson(){
		System.out.println(" 营收款json ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		//得到客户端传递的页码和每页记录数，并转换成int类型  
        String pageSize = request.getParameter("pageSize");  
        String pageNumber = request.getParameter("pageNumber");
		
//      得到业务对象
		
//		模糊查询
		List<YingShouKuan> yingshoukuanlist = yingShouKuanService.vagueSearchYingShouKuan(dingdanhao,yingshoukuanzhuangtai,jiesuanzhuangtai , kehudanwei , pageSize , pageNumber);
//		参数
		String yingshoukuanchepaihao = chepaihao;
		
		String yingshoukuanhuowumingcheng = huowumingcheng;
//		转换
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getYingShouKuanModelList(yingshoukuanlist ,  yingshoukuanchepaihao ,  yingshoukuanhuowumingcheng,  yunDanService ,  customerService);
		
		Long Total = yingShouKuanService.countSearchYingShouKuan(dingdanhao,yingshoukuanzhuangtai,jiesuanzhuangtai , kehudanwei , pageSize , pageNumber);
		
		PageServer ps = new PageServer();
		ps.setRows(yingshoukuanmodellist);
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
	 *  模糊查询
	 */
	public void vagueSearchYingShouKuan(){
        
		System.out.println(" 模糊查询 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
	}
	
	/**
	 *  跳转-添加营收款
	 */
	public String jumpAddYingShouKuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-添加营收款 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		
		String id[] = request.getParameterValues("toolbar1");
//		判断是否单选
		if(id == null || id.length<1 || id.length>1){
			request.setAttribute("yingshoukuanerr", "请选择单个进行操作");
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}
		
		
		
//		查询指定id的营收款
		 singleyingshoukuan = yingShouKuanService.queryYingShouKuanId(Integer.valueOf(id[0]));
		
		if("已开票".equals( singleyingshoukuan.getYingshoukuanzhuangtai() )){
			request.setAttribute("yingshoukuanerr", "已开过票,不能进行修改");
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}
		
		
//		查询指定订单号的运单对象
		YunDan yundan = yunDanService.queryYunDanDingDanHao(singleyingshoukuan.getDingdanhao());
		
//		计算营收 金额
		String shifadunweistr = yundan.getShifadunwei();
		String danjiastr =yundan.getBaochoujine();
//		这边要加判断 不然空指针异常
		if(shifadunweistr == null){
			shifadunweistr = "0";
		}
		if(danjiastr == null){
			danjiastr = "0" ;
		}
		
		Double shifadunwei = Double.valueOf(shifadunweistr);
		Double danjia = Double.valueOf(danjiastr);
//		保留小数点后两位
		Double value = shifadunwei * danjia;
		DecimalFormat df = new DecimalFormat("#.00");
		String yingshou =  df.format(value);
		
		singleyingshoukuan.setYingshou(yingshou);
		
		
		request.setAttribute("shifadunweistr", shifadunweistr);
		request.setAttribute("danjiastr", danjiastr);
		
		request.setAttribute("singleyingshoukuan", singleyingshoukuan);
		session.setAttribute("singleyingshoukuan", singleyingshoukuan);
		
		return "success";
	}
	
	/**
	 *  添加营收款
	 */
	public String addYingShouKuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 添加营收款 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		singleyingshoukuan = (YingShouKuan) session.getAttribute("singleyingshoukuan");
		
		Users users =(Users) session.getAttribute("users");
		
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		
		singleyingshoukuan.setYingShouKuan( daikongtong,  yingshou,
				 daozhangshijian,  fapiaohao,  kaipiaoshijian,
				 shuijin,  guanlifei,  shifuyunfei,
				 lingkuanshijian,  qianshou);
		
		
		singleyingshoukuan.setYingShouKuan(caozuoyuan, caozuoriqi);
		
		yingShouKuanService.updateYingShouKuan(singleyingshoukuan);
		
		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		session.removeAttribute("singleyingshoukuan");
		
		return "success";
	}
	
	/**
	 *  营收款详细
	 */
	public String yingShouKuanXiangXi(){
		System.out.println(" 营收款详细 ");

//		设置字符格式
		FontFormat.setFontFormat(response);		

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
	/**
	 *  跳转-开票 
	 */
	public String jumpYingShouKuanInKaiPiao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-开票 ");

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
//		营收款 业务对象
			
//		运单 业务对象
		
//		得到 CustomerService 对象
				
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1){
			kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
			request.setAttribute("kaipiaolist", kaipiaolist);
			
			request.setAttribute("yingshoukuanerr", "请选择");
			return "err";
		}
		
//		创建营收款集合对象
		 yingshoukuanlist = new ArrayList<YingShouKuan>();
//		创建客户单位集合对象
		 kehudanweilist = new ArrayList<String>();
		
//		判断是否可以开票
		for (int i = 0; i < id.length; i++) {
			
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId(Integer.valueOf(id[i]));
			if( !"未开票".equals(yingshoukuan.getYingshoukuanzhuangtai()) ){
				request.setAttribute("yingshoukuanerr", "请选择未开票");
				CheLiangController.sendCheLiang(cheLiangService);
				
				kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
				request.setAttribute("kaipiaolist", kaipiaolist);
				return "err";
			}
			if(yingshoukuan.getYingshou() == null){
				request.setAttribute("yingshoukuanerr", "请登记后在开票");
				CheLiangController.sendCheLiang(cheLiangService);
				
				kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
				request.setAttribute("kaipiaolist", kaipiaolist);
				return "err";
			}
			
//			查询指定订单号的运单对象
			YunDan yundan = yunDanService.queryYunDanDingDanHao(yingshoukuan.getDingdanhao());
			if(yundan == null || yundan.getKehudanwei() == null || "".equals(yundan.getKehudanwei())){
				request.setAttribute("yingshoukuanerr", "客户单位不能为空或没有对应的运单");
				CheLiangController.sendCheLiang(cheLiangService);
				
				kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
				request.setAttribute("kaipiaolist", kaipiaolist);
				return "err";
			}
			kehudanweilist.add(yundan.getKehudanwei());
			
//			添加营收款对象
			yingshoukuanlist.add(yingshoukuan);
		}
		
//		判断客户单位是否一致
		for (int i = 0; i < kehudanweilist.size()-1; i++) {
			
			for (int j = i+1; j < kehudanweilist.size(); j++) {
				String kehudanweiI = kehudanweilist.get(i);
				String kehudanweiJ = kehudanweilist.get(j);
				if(!kehudanweiI.equals(kehudanweiJ)){
					
					kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
					request.setAttribute("kaipiaolist", kaipiaolist);
					
					request.setAttribute("yingshoukuanerr", "客户单位不一致");
					return "err";
				}
			}
		}
		
//		查询指定客户单位的客户对象
		 singlecustomer = customerService.queryCustomerKeHuDanWei(kehudanweilist.get(0));

//		得到营收款 开票集合对象 TODO
		 yingshoukuaninkaipiaolist = YingShouKuanInKaiPiao.getYingShouKuanInKaiPiaoList(yingshoukuanlist);
//		复制一份
		 yingshoukuanindingdanhaolist = new ArrayList<YingShouKuanInKaiPiao>();
		for (int i = 0; i < yingshoukuaninkaipiaolist.size(); i++) {
			yingshoukuanindingdanhaolist.add( yingshoukuaninkaipiaolist.get(i) );
		}
		
		
		for (int i = 0; i < yingshoukuaninkaipiaolist.size()-1; i++) {
			
			for (int j = i+1; j < yingshoukuaninkaipiaolist.size(); j++) {
				
				YingShouKuanInKaiPiao inkaipiaoI = yingshoukuaninkaipiaolist.get(i);
				YingShouKuanInKaiPiao inkaipiaoJ = yingshoukuaninkaipiaolist.get(j);
				
				String chengyunrenI = inkaipiaoI.getChengyunren();
				String chengyunrenJ = inkaipiaoJ.getChengyunren();
//				判断承运人是否一致
				if(chengyunrenI.equals(chengyunrenJ)){
					
					Double myYingShou = inkaipiaoI.getYingshou() + inkaipiaoJ.getYingshou();
					myYingShou = StringTfmDouble( formatDoubleTwo(myYingShou) );
					inkaipiaoI.setKaipiaojine( myYingShou );
					
					Double myShuiJin = inkaipiaoI.getShuijin() + inkaipiaoJ.getShuijin();
					myShuiJin = StringTfmDouble( formatDoubleTwo(myShuiJin) );
					inkaipiaoI.setShuijin( myShuiJin );
					
					Double myGuanLiFei = inkaipiaoI.getGuanlifei() + inkaipiaoJ.getGuanlifei() ;
					myGuanLiFei = StringTfmDouble( formatDoubleTwo(myGuanLiFei) );
					inkaipiaoI.setGuanlifei( myGuanLiFei );
					
					Double myShiFuYunFei = inkaipiaoI.getShifuyunfei() + inkaipiaoJ.getShifuyunfei();
					myShiFuYunFei = StringTfmDouble( formatDoubleTwo(myShiFuYunFei) );
					inkaipiaoI.setShifuyunfei( myShiFuYunFei );
					
					Double myDaiDianFei = inkaipiaoI.getDaidianfei() + inkaipiaoJ.getDaidianfei();
					myDaiDianFei = StringTfmDouble( formatDoubleTwo(myDaiDianFei) );
					inkaipiaoI.setDaidianfei( myDaiDianFei );
					
					Double myShiShouYunFei = inkaipiaoI.getShishouyunfei() + inkaipiaoJ.getShishouyunfei();
					myShiShouYunFei = StringTfmDouble( formatDoubleTwo(myShiShouYunFei) );
					inkaipiaoI.setShishouyunfei( myShiShouYunFei );
					
					Double myZunCheFei = inkaipiaoI.getZuchefei() + inkaipiaoJ.getZuchefei();
					myZunCheFei = StringTfmDouble( formatDoubleTwo(myZunCheFei) );
					inkaipiaoI.setZuchefei( myZunCheFei );
					
					Double myYeWuFei = inkaipiaoI.getYewufei() + inkaipiaoJ.getYewufei();
					myYeWuFei = StringTfmDouble( formatDoubleTwo(myYeWuFei) );
					inkaipiaoI.setYewufei( myYeWuFei );
					
//					替换掉i的位置
					yingshoukuaninkaipiaolist.set(i, inkaipiaoI);
//					移除掉j的位置 
					yingshoukuaninkaipiaolist.remove(j);	
					
					j--;
					
				}
				
			}
			
		}
		
//		如果只有一个开票
		if(yingshoukuaninkaipiaolist.size() == 1){
			YingShouKuanInKaiPiao inkaipiaoI = yingshoukuaninkaipiaolist.get(0);
			
			Double myYingShou = inkaipiaoI.getYingshou() ;
			myYingShou = StringTfmDouble( formatDoubleTwo(myYingShou) );
			inkaipiaoI.setKaipiaojine( myYingShou );
			
			Double myShuiJin = inkaipiaoI.getShuijin() ;
			myShuiJin = StringTfmDouble( formatDoubleTwo(myShuiJin) );
			inkaipiaoI.setShuijin( myShuiJin );
			
			Double myGuanLiFei = inkaipiaoI.getGuanlifei()  ;
			myGuanLiFei = StringTfmDouble( formatDoubleTwo(myGuanLiFei) );
			inkaipiaoI.setGuanlifei( myGuanLiFei );
			
			Double myShiFuYunFei = inkaipiaoI.getShifuyunfei() ;
			myShiFuYunFei = StringTfmDouble( formatDoubleTwo(myShiFuYunFei) );
			inkaipiaoI.setShifuyunfei( myShiFuYunFei );
			
			Double myDaiDianFei = inkaipiaoI.getDaidianfei() ;
			myDaiDianFei = StringTfmDouble( formatDoubleTwo(myDaiDianFei) );
			inkaipiaoI.setDaidianfei( myDaiDianFei );
			
			Double myShiShouYunFei = inkaipiaoI.getShishouyunfei() ;
			myShiShouYunFei = StringTfmDouble( formatDoubleTwo(myShiShouYunFei) );
			inkaipiaoI.setShishouyunfei( myShiShouYunFei );
			
			Double myZunCheFei = inkaipiaoI.getZuchefei() ;
			myZunCheFei = StringTfmDouble( formatDoubleTwo(myZunCheFei) );
			inkaipiaoI.setZuchefei( myZunCheFei );
			
			Double myYeWuFei = inkaipiaoI.getYewufei() ;
			myYeWuFei = StringTfmDouble( formatDoubleTwo(myYeWuFei) );
			inkaipiaoI.setYewufei( myYeWuFei );
			
//			替换掉i的位置
			yingshoukuaninkaipiaolist.set(0, inkaipiaoI);
			
		}
		
		
//		合计
		Double sumkaipiaojine = 0.0;
		Double sumshuijin = 0.0;
		Double sumguanlifei = 0.0;
		Double sumshifuyunfei = 0.0;
		Double sumdaidianfei = 0.0;
		Double sumzuchefei = 0.0;
		Double sumyewufei = 0.0;
//		开始合计
		for (int i = 0; i < yingshoukuaninkaipiaolist.size(); i++) {
			YingShouKuanInKaiPiao yingShouKuanInKaiPiao  = yingshoukuaninkaipiaolist.get(i);
			
			sumkaipiaojine = sumkaipiaojine + yingShouKuanInKaiPiao.getKaipiaojine();			
			sumshuijin = sumshuijin + yingShouKuanInKaiPiao.getShuijin();
			sumguanlifei = sumguanlifei + yingShouKuanInKaiPiao.getGuanlifei();
			sumshifuyunfei = sumshifuyunfei + yingShouKuanInKaiPiao.getShifuyunfei();
			sumdaidianfei = sumdaidianfei + yingShouKuanInKaiPiao.getDaidianfei();
			sumzuchefei = sumzuchefei + yingShouKuanInKaiPiao.getZuchefei();
			sumyewufei = sumyewufei + yingShouKuanInKaiPiao.getYewufei();
			
		}
		
		sumkaipiaojine = StringTfmDouble( formatDoubleTwo( sumkaipiaojine ) );;			
		sumshuijin =  StringTfmDouble( formatDoubleTwo( sumshuijin ) );;	
		sumguanlifei =  StringTfmDouble( formatDoubleTwo( sumguanlifei ) );;	
		sumshifuyunfei =  StringTfmDouble( formatDoubleTwo( sumshifuyunfei ) );;	
		sumdaidianfei =  StringTfmDouble( formatDoubleTwo( sumdaidianfei ) );;	
		sumzuchefei =  StringTfmDouble( formatDoubleTwo( sumzuchefei ) );;	
		sumyewufei = StringTfmDouble( formatDoubleTwo( sumyewufei ) );;	
		
		request.setAttribute("sumkaipiaojine", sumkaipiaojine);
		request.setAttribute("sumshuijin", sumshuijin);
		request.setAttribute("sumguanlifei", sumguanlifei);
		request.setAttribute("sumshifuyunfei", sumshifuyunfei);
		request.setAttribute("sumdaidianfei", sumdaidianfei);
		request.setAttribute("sumzuchefei", sumzuchefei);
		request.setAttribute("sumyewufei", sumyewufei);
		
		
//		开票时间
		Date kaipiaoshijiandate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String kaipiaoshijian = sdf.format(kaipiaoshijiandate);
		
//		传递对象
		request.setAttribute("kaipiaoshijian",kaipiaoshijian );
		
		request.setAttribute("singlecustomer", singlecustomer);
		
		request.setAttribute("yingshoukuaninkaipiaolist", yingshoukuaninkaipiaolist);
		
		request.setAttribute("yingshoukuanindingdanhaolist", yingshoukuanindingdanhaolist);
		
		return "success";
	}
	
	/**
	 *  跳转-再次开票 
	 */
	public String jumpSuperYingShouKuanInKaiPiao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-再次开票 ");

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
//		营收款 业务对象
			
//		运单 业务对象
		
//		得到 CustomerService 对象
				
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1){
			kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
			request.setAttribute("kaipiaolist", kaipiaolist);
			
			request.setAttribute("yingshoukuanerr", "请选择");
			return "err";
		}
		
//		创建营收款集合对象
		 yingshoukuanlist = new ArrayList<YingShouKuan>();
//		创建客户单位集合对象
		 kehudanweilist = new ArrayList<String>();
		
//		判断是否可以开票
		for (int i = 0; i < id.length; i++) {
			
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId(Integer.valueOf(id[i]));
			
			if(yingshoukuan.getYingshou() == null){
				request.setAttribute("yingshoukuanerr", "请登记后在开票");
				CheLiangController.sendCheLiang(cheLiangService);
				
				kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
				request.setAttribute("kaipiaolist", kaipiaolist);
				return "err";
			}
			
//			查询指定订单号的运单对象
			YunDan yundan = yunDanService.queryYunDanDingDanHao(yingshoukuan.getDingdanhao());
			if(yundan == null || yundan.getKehudanwei() == null || "".equals(yundan.getKehudanwei())){
				request.setAttribute("yingshoukuanerr", "客户单位不能为空或没有对应的运单");
				CheLiangController.sendCheLiang(cheLiangService);
				
				kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
				request.setAttribute("kaipiaolist", kaipiaolist);
				return "err";
			}
			kehudanweilist.add(yundan.getKehudanwei());
			
//			添加营收款对象
			yingshoukuanlist.add(yingshoukuan);
		}
		
//		判断客户单位是否一致
		for (int i = 0; i < kehudanweilist.size()-1; i++) {
			
			for (int j = i+1; j < kehudanweilist.size(); j++) {
				String kehudanweiI = kehudanweilist.get(i);
				String kehudanweiJ = kehudanweilist.get(j);
				if(!kehudanweiI.equals(kehudanweiJ)){
					
					kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
					request.setAttribute("kaipiaolist", kaipiaolist);
					
					request.setAttribute("yingshoukuanerr", "客户单位不一致");
					return "err";
				}
			}
		}
		
//		查询指定客户单位的客户对象
		 singlecustomer = customerService.queryCustomerKeHuDanWei(kehudanweilist.get(0));

//		得到营收款 开票集合对象 TODO
		 yingshoukuaninkaipiaolist = YingShouKuanInKaiPiao.getYingShouKuanInKaiPiaoList(yingshoukuanlist);
//		复制一份
		 yingshoukuanindingdanhaolist = new ArrayList<YingShouKuanInKaiPiao>();
		for (int i = 0; i < yingshoukuaninkaipiaolist.size(); i++) {
			yingshoukuanindingdanhaolist.add( yingshoukuaninkaipiaolist.get(i) );
		}
		
		
		for (int i = 0; i < yingshoukuaninkaipiaolist.size()-1; i++) {
			
			for (int j = i+1; j < yingshoukuaninkaipiaolist.size(); j++) {
				
				YingShouKuanInKaiPiao inkaipiaoI = yingshoukuaninkaipiaolist.get(i);
				YingShouKuanInKaiPiao inkaipiaoJ = yingshoukuaninkaipiaolist.get(j);
				
				String chengyunrenI = inkaipiaoI.getChengyunren();
				String chengyunrenJ = inkaipiaoJ.getChengyunren();
//				判断承运人是否一致
				if(chengyunrenI.equals(chengyunrenJ)){
					
					Double myYingShou = inkaipiaoI.getYingshou() + inkaipiaoJ.getYingshou();
					myYingShou = StringTfmDouble( formatDoubleTwo(myYingShou) );
					inkaipiaoI.setKaipiaojine( myYingShou );
					
					Double myShuiJin = inkaipiaoI.getShuijin() + inkaipiaoJ.getShuijin();
					myShuiJin = StringTfmDouble( formatDoubleTwo(myShuiJin) );
					inkaipiaoI.setShuijin( myShuiJin );
					
					Double myGuanLiFei = inkaipiaoI.getGuanlifei() + inkaipiaoJ.getGuanlifei() ;
					myGuanLiFei = StringTfmDouble( formatDoubleTwo(myGuanLiFei) );
					inkaipiaoI.setGuanlifei( myGuanLiFei );
					
					Double myShiFuYunFei = inkaipiaoI.getShifuyunfei() + inkaipiaoJ.getShifuyunfei();
					myShiFuYunFei = StringTfmDouble( formatDoubleTwo(myShiFuYunFei) );
					inkaipiaoI.setShifuyunfei( myShiFuYunFei );
					
					Double myDaiDianFei = inkaipiaoI.getDaidianfei() + inkaipiaoJ.getDaidianfei();
					myDaiDianFei = StringTfmDouble( formatDoubleTwo(myDaiDianFei) );
					inkaipiaoI.setDaidianfei( myDaiDianFei );
					
					Double myShiShouYunFei = inkaipiaoI.getShishouyunfei() + inkaipiaoJ.getShishouyunfei();
					myShiShouYunFei = StringTfmDouble( formatDoubleTwo(myShiShouYunFei) );
					inkaipiaoI.setShishouyunfei( myShiShouYunFei );
					
					Double myZunCheFei = inkaipiaoI.getZuchefei() + inkaipiaoJ.getZuchefei();
					myZunCheFei = StringTfmDouble( formatDoubleTwo(myZunCheFei) );
					inkaipiaoI.setZuchefei( myZunCheFei );
					
					Double myYeWuFei = inkaipiaoI.getYewufei() + inkaipiaoJ.getYewufei();
					myYeWuFei = StringTfmDouble( formatDoubleTwo(myYeWuFei) );
					inkaipiaoI.setYewufei( myYeWuFei );
					
//					替换掉i的位置
					yingshoukuaninkaipiaolist.set(i, inkaipiaoI);
//					移除掉j的位置 
					yingshoukuaninkaipiaolist.remove(j);	
					
					j--;
					
				}
				
			}
			
		}
		
//		如果只有一个开票
		if(yingshoukuaninkaipiaolist.size() == 1){
			YingShouKuanInKaiPiao inkaipiaoI = yingshoukuaninkaipiaolist.get(0);
			
			Double myYingShou = inkaipiaoI.getYingshou() ;
			myYingShou = StringTfmDouble( formatDoubleTwo(myYingShou) );
			inkaipiaoI.setKaipiaojine( myYingShou );
			
			Double myShuiJin = inkaipiaoI.getShuijin() ;
			myShuiJin = StringTfmDouble( formatDoubleTwo(myShuiJin) );
			inkaipiaoI.setShuijin( myShuiJin );
			
			Double myGuanLiFei = inkaipiaoI.getGuanlifei()  ;
			myGuanLiFei = StringTfmDouble( formatDoubleTwo(myGuanLiFei) );
			inkaipiaoI.setGuanlifei( myGuanLiFei );
			
			Double myShiFuYunFei = inkaipiaoI.getShifuyunfei() ;
			myShiFuYunFei = StringTfmDouble( formatDoubleTwo(myShiFuYunFei) );
			inkaipiaoI.setShifuyunfei( myShiFuYunFei );
			
			Double myDaiDianFei = inkaipiaoI.getDaidianfei() ;
			myDaiDianFei = StringTfmDouble( formatDoubleTwo(myDaiDianFei) );
			inkaipiaoI.setDaidianfei( myDaiDianFei );
			
			Double myShiShouYunFei = inkaipiaoI.getShishouyunfei() ;
			myShiShouYunFei = StringTfmDouble( formatDoubleTwo(myShiShouYunFei) );
			inkaipiaoI.setShishouyunfei( myShiShouYunFei );
			
			Double myZunCheFei = inkaipiaoI.getZuchefei() ;
			myZunCheFei = StringTfmDouble( formatDoubleTwo(myZunCheFei) );
			inkaipiaoI.setZuchefei( myZunCheFei );
			
			Double myYeWuFei = inkaipiaoI.getYewufei() ;
			myYeWuFei = StringTfmDouble( formatDoubleTwo(myYeWuFei) );
			inkaipiaoI.setYewufei( myYeWuFei );
			
//			替换掉i的位置
			yingshoukuaninkaipiaolist.set(0, inkaipiaoI);
			
		}
		
//		合计
		Double sumkaipiaojine = 0.0;
		Double sumshuijin = 0.0;
		Double sumguanlifei = 0.0;
		Double sumshifuyunfei = 0.0;
		Double sumdaidianfei = 0.0;
		Double sumzuchefei = 0.0;
		Double sumyewufei = 0.0;
//		开始合计
		for (int i = 0; i < yingshoukuaninkaipiaolist.size(); i++) {
			YingShouKuanInKaiPiao yingShouKuanInKaiPiao  = yingshoukuaninkaipiaolist.get(i);
			
			sumkaipiaojine = sumkaipiaojine + yingShouKuanInKaiPiao.getKaipiaojine();			
			sumshuijin = sumshuijin + yingShouKuanInKaiPiao.getShuijin();
			sumguanlifei = sumguanlifei + yingShouKuanInKaiPiao.getGuanlifei();
			sumshifuyunfei = sumshifuyunfei + yingShouKuanInKaiPiao.getShifuyunfei();
			sumdaidianfei = sumdaidianfei + yingShouKuanInKaiPiao.getDaidianfei();
			sumzuchefei = sumzuchefei + yingShouKuanInKaiPiao.getZuchefei();
			sumyewufei = sumyewufei + yingShouKuanInKaiPiao.getYewufei();
			
		}
		
		sumkaipiaojine = StringTfmDouble( formatDoubleTwo( sumkaipiaojine ) );;			
		sumshuijin =  StringTfmDouble( formatDoubleTwo( sumshuijin ) );;	
		sumguanlifei =  StringTfmDouble( formatDoubleTwo( sumguanlifei ) );;	
		sumshifuyunfei =  StringTfmDouble( formatDoubleTwo( sumshifuyunfei ) );;	
		sumdaidianfei =  StringTfmDouble( formatDoubleTwo( sumdaidianfei ) );;	
		sumzuchefei =  StringTfmDouble( formatDoubleTwo( sumzuchefei ) );;	
		sumyewufei = StringTfmDouble( formatDoubleTwo( sumyewufei ) );;	
		
		request.setAttribute("sumkaipiaojine", sumkaipiaojine);
		request.setAttribute("sumshuijin", sumshuijin);
		request.setAttribute("sumguanlifei", sumguanlifei);
		request.setAttribute("sumshifuyunfei", sumshifuyunfei);
		request.setAttribute("sumdaidianfei", sumdaidianfei);
		request.setAttribute("sumzuchefei", sumzuchefei);
		request.setAttribute("sumyewufei", sumyewufei);
		
		
//		开票时间
		Date kaipiaoshijiandate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String kaipiaoshijian = sdf.format(kaipiaoshijiandate);
		
//		传递对象
		request.setAttribute("kaipiaoshijian",kaipiaoshijian );
		
		request.setAttribute("singlecustomer", singlecustomer);
		
		request.setAttribute("yingshoukuaninkaipiaolist", yingshoukuaninkaipiaolist);
		
		request.setAttribute("yingshoukuanindingdanhaolist", yingshoukuanindingdanhaolist);
		
		return "success";
	}
	
	/**
	 *  提交-开票
	 */
	public String submitYingShouKuanInkaiPiao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 提交-开票 ");
		
		CheLiangController.sendCheLiang(cheLiangService);
		
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		营收款 业务对象
			
//		开票 业务对象
		
//		运单业务对象
		
//		车辆业务对象
		
		
//		开票时间		
//		Date  kaipiaoshijian = new Date();

//		用户对象
		Users users = (Users) session.getAttribute("users");
//		操作员
		String caozuoyuan = users.getUsername();
//		操作日期
		Date   caozuoriqi = new Date();
		
//		客户单位
		String kehudanwei = singlecustomer.getKehudanwei();	
//		开票单位
		String kaipiaodanwei = singlecustomer.getKehudanwei();
//		发货单位
		String fahuodanwei = singlecustomer.getKehudanwei();
//		识别号
		String shibiehao = singlecustomer.getIdentifynumber();
//		地址
		String dizhi = singlecustomer.getContactaddress();
//		电话
		String dianhua = singlecustomer.getContactnumber();
//		开户行
		String kaihuhang = singlecustomer.getBankaccount();
//		帐号
		String zhanghao = singlecustomer.getAccount();
		
//		开票list集合
		List<KaiPiao> mykaipiaolist = new ArrayList<KaiPiao>();
		
		for (int i = 0; i < yingshoukuaninkaipiaolist.size(); i++) {
			YingShouKuanInKaiPiao yingshoukuaninkaipiao = yingshoukuaninkaipiaolist.get(i);
//			序号
			String xuhao =yingshoukuaninkaipiao.getXuhao();
//			车牌号
			String chepaihao = yingshoukuaninkaipiao.getChepaihao();
//			订单号
			String dingdanhao =yingshoukuaninkaipiao.getDingdanhao();
//			承运人
			String chengyunren = yingshoukuaninkaipiao.getChengyunren();
//			开票金额
			String kaipiaojine =String.valueOf( yingshoukuaninkaipiao.getKaipiaojine() ) ;
//			税金
			String shuijin = String.valueOf( yingshoukuaninkaipiao.getShuijin() );
//			管理费
			String guanlifei = String.valueOf( yingshoukuaninkaipiao.getGuanlifei() );
//			实付运费
			String shifuyunfei = String.valueOf( yingshoukuaninkaipiao.getShifuyunfei() );
//			代垫费
			String daidianfei = String.valueOf( yingshoukuaninkaipiao.getDaidianfei() );
//			备注 
			String beizhu = yingshoukuaninkaipiao.getBeizhu();
//			实收运费
			Double shishouyunfei = yingshoukuaninkaipiao.getShishouyunfei() ;
			String shishouyunfeiStr = String.valueOf(shishouyunfei);
//			租车费
			Double zuchefei = yingshoukuaninkaipiao.getZuchefei();
			String zuchefeiStr = String.valueOf(zuchefei);
//			业务费
			Double yewufei = yingshoukuaninkaipiao.getYewufei();
			String yewufeiStr = String.valueOf(yewufei);
			
//			---------------------------
//			运单对象
			YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
//			营收款对象
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
			
			CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
//			属地
			String shudi = "";
			if(cheliang != null){
				shudi = cheliang.getChezhuxingming();
			}
			
//			货物名称
			String huowumingcheng = yundan.getHuowumingcheng();
//			实收吨位
			String shishoudunwei = yundan.getShishoudunwei();
//			实发吨位
			String shifadunwei = yundan.getShifadunwei();
//			里程
			String licheng = yundan.getLicheng();
//			单价
			String danjia = yundan.getBaochoujine();
//			带空桶
			String daikongtong = yingshoukuan.getDaikongtong();
//			起点
			String qidian = yundan.getQidian();
//			终点
			String zhongdian = yundan.getZhongdian();
//			营收
			String yingshou = yingshoukuan.getYingshou();
//			到账时间
			Date daozhangshijian = yingshoukuan.getDaozhangshijian();
//			发票号
			String fapiaohao = yingshoukuan.getFapiaohao();
//			领款时间
			Date lingkuanshijian = yingshoukuan.getLingkuanshijian();
//			签收
			String qianshou = yingshoukuan.getQianshou();
			
//			开票时间
			Date kaipiaoshijian = yingshoukuan.getKaipiaoshijian();
			
//			创建开票对象 且 赋值
			KaiPiao kaipiao = new KaiPiao();
			kaipiao.setKaiPiao( dingdanhao,  chepaihao,
					 kehudanwei,  kaipiaoshijian,  kaipiaodanwei,
					 shibiehao,  dizhi,  dianhua,  kaihuhang,
					 zhanghao,  chengyunren,  kaipiaojine,
					 shuijin,  guanlifei,  shifuyunfei,
					 daidianfei,  beizhu,  caozuoyuan,  caozuoriqi );
			
			kaipiao.setKaiPiaoExcel( shudi,  fahuodanwei,  huowumingcheng,
					 shishoudunwei,  shifadunwei,  licheng,
					 danjia,  daikongtong,  qidian,  zhongdian,
					 yingshou,  daozhangshijian,  fapiaohao,
					 lingkuanshijian,  qianshou);
			
			kaipiao.setShishouyunfei(shishouyunfeiStr);
			
			kaipiao.setZuchefei(zuchefeiStr);
			kaipiao.setYewufei(yewufeiStr);
			
//			添加开票
			mykaipiaolist.add(kaipiao);
			
		}
		
//		向数据库添加开票
		heBingKaiPiao(mykaipiaolist);
		
//		修改对应订单号的营收款  开票状态
		for (int i = 0; i < yingshoukuanindingdanhaolist.size(); i++) {
			
			String dingdanhao = yingshoukuanindingdanhaolist.get(i).getDingdanhao();
			
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
			yingshoukuan.setYingshoukuanzhuangtai("已开票");
			yingshoukuan.setCaozuoyuan(caozuoyuan);
			yingshoukuan.setCaozuoriqi(caozuoriqi);
//			yingshoukuan.setKaipiaoshijian(kaipiaoshijian);
			yingShouKuanService.updateYingShouKuan(yingshoukuan);
			
		}
		
		
//		查询所有营收款
		kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
		request.setAttribute("kaipiaolist", kaipiaolist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  合并开票
	 */
	public void heBingKaiPiao(List<KaiPiao> kaipiaolist){
		if(kaipiaolist == null){
			return ;
		}
		
//		开票 业务对象
		
		
//		操作员
		String caozuoyuan = kaipiaolist.get(0).getCaozuoyuan();
//		操作日期
		Date   caozuoriqi = kaipiaolist.get(0).getCaozuoriqi();		
//		客户单位
		String kehudanwei = kaipiaolist.get(0).getKehudanwei();	
//		开票单位
		String kaipiaodanwei = kaipiaolist.get(0).getKaipiaodanwei();
//		发货单位
		String fahuodanwei = kaipiaolist.get(0).getFahuodanwei();
//		识别号
		String shibiehao = kaipiaolist.get(0).getShibiehao();
//		地址
		String dizhi = kaipiaolist.get(0).getDizhi();
//		电话
		String dianhua = kaipiaolist.get(0).getDianhua();
//		开户行
		String kaihuhang = kaipiaolist.get(0).getKaihuhang();
//		帐号
		String zhanghao = kaipiaolist.get(0).getZhanghao();
//		车牌号
		String chepaihao = kaipiaolist.get(0).getChepaihao();
//		订单号
		String dingdanhao = kaipiaolist.get(0).getDingdanhao();
//		属地
		String shudi = kaipiaolist.get(0).getShudi();
//		货物名称
		String huowumingcheng = kaipiaolist.get(0).getHuowumingcheng();
//		起点
		String qidian = kaipiaolist.get(0).getQidian();
//		终点
		String zhongdian = kaipiaolist.get(0).getZhongdian();
//		到账时间
		Date daozhangshijian = kaipiaolist.get(0).getDaozhangshijian();
//		发票号
		String fapiaohao = kaipiaolist.get(0).getFapiaohao();
//		领款时间
		Date lingkuanshijian = kaipiaolist.get(0).getLingkuanshijian();
//		签收
		String qianshou = kaipiaolist.get(0).getQianshou();
//		开票时间
		Date kaipiaoshijian = kaipiaolist.get(0).getKaipiaoshijian();
		
		
//		承运人
		String chengyunren = "";
//		备注 
		String beizhu = "";
//		开票金额
		String kaipiaojine = "";
//		税金
		String shuijin = "";
//		管理费
		String guanlifei = "";
//		实付运费
		String shifuyunfei = "";
//		代垫费
		String daidianfei = "";
//		实收运费
		String shishouyunfei = "";
//		租车费
		String zuchefei = "";
//		业务费
		String yewufei = "";
//		实收吨位
		String shishoudunwei = "";
//		实发吨位
		String shifadunwei = "";
//		里程
		String licheng = "";
//		单价
		String danjia = "";
//		带空桶
		String daikongtong = "";
//		营收
		String yingshou = "";

//		循环开始累加
		for (int i = 0; i < kaipiaolist.size(); i++) {
			KaiPiao kp = kaipiaolist.get(i);
			
			String fenge = "|";
			if( (i+1) == kaipiaolist.size() ){
				fenge = "";
			}
			
//			承运人
			chengyunren = chengyunren + kp.getChengyunren() + fenge;
//			备注 
			beizhu = beizhu + kp.getBeizhu() + fenge;
//			开票金额
			kaipiaojine = kaipiaojine + kp.getKaipiaojine() + fenge;
//			税金
			shuijin = shuijin + kp.getShuijin() + fenge;
//			管理费
			guanlifei = guanlifei + kp.getGuanlifei() + fenge;
//			实付运费
			shifuyunfei = shifuyunfei + kp.getShifuyunfei() + fenge;
//			代垫费
			daidianfei = daidianfei + kp.getDaidianfei() + fenge;
//			实收运费
			shishouyunfei = shishouyunfei + kp.getShishouyunfei() + fenge;
//			租车费
			zuchefei = zuchefei + kp.getZuchefei() + fenge;
//			业务费
			yewufei = yewufei + kp.getYewufei() + fenge;
//			实收吨位
			shishoudunwei = shishoudunwei + kp.getShishoudunwei() + fenge;
//			实发吨位
			shifadunwei = shifadunwei + kp.getShifadunwei() + fenge;
//			里程
			licheng = licheng + kp.getLicheng() + fenge;
//			单价
			danjia = danjia + kp.getDanjia() + fenge;
//			带空桶
			daikongtong = daikongtong + kp.getDaikongtong() + fenge;
//			营收
			yingshou = yingshou + kp.getYingshou() + fenge;
			
		}	
		
//		所有实付运费合计除以0.875
//		shifuyunfei = shifuyunfei / 0.875 ;
		
//		开票金额
		String kaipiaojineStr = kaipiaojine;
//		税金
		String shuijinStr = shuijin;
//		管理费
		String guanlifeiStr = guanlifei;
//		实付运费
		String shifuyunfeiStr = shifuyunfei;
//		代垫费
		String daidianfeiStr = daidianfei;
//		实收运费
		String shishouyunfeiStr = shishouyunfei;
//		租车费
		String zuchefeiStr = zuchefei;
//		业务费
		String yewufeiStr = yewufei;
//		实收吨位
		String shishoudunweiStr = shishoudunwei;
//		实发吨位
		String shifadunweiStr = shifadunwei;
//		里程
		String lichengStr = licheng;
//		单价
		String danjiaStr = danjia;
//		带空桶
		String daikongtongStr = daikongtong;
//		营收
		String yingshouStr = yingshou;
		
//		创建开票对象 且 赋值
		KaiPiao kaipiao = new KaiPiao();
		kaipiao.setKaiPiao( dingdanhao,  chepaihao,
				 kehudanwei,  kaipiaoshijian,  kaipiaodanwei,
				 shibiehao,  dizhi,  dianhua,  kaihuhang,
				 zhanghao,  chengyunren,  kaipiaojineStr,
				 shuijinStr,  guanlifeiStr,  shifuyunfeiStr,
				 daidianfeiStr,  beizhu,  caozuoyuan,  caozuoriqi );
		
		kaipiao.setKaiPiaoExcel( shudi,  fahuodanwei,  huowumingcheng,
				 shishoudunweiStr,  shifadunweiStr,  lichengStr,
				 danjiaStr,  daikongtongStr,  qidian,  zhongdian,
				 yingshouStr,  daozhangshijian,  fapiaohao,
				 lingkuanshijian,  qianshou);
		
		kaipiao.setShishouyunfei(shishouyunfeiStr);
		kaipiao.setZuchefei(zuchefeiStr);
		kaipiao.setYewufei(yewufeiStr);
		
		kaiPiaoService.addKaiPiao(kaipiao);
	}
	
	/**
	 *  String转换Double
	 */
	public Double StringTfmDouble(String str){
		//初始化值
		Double value = 0.0;
		
		try {
			value = Double.valueOf(str);
		} catch (Exception e) {
		}
		
		return value;
	}
	
	/**
	 *  format Double Two
	 */
	public String formatDoubleTwo(double value){
		String str = "";
		
		DecimalFormat  df  = new DecimalFormat("######0.00"); 
		try {
			str = df.format(value);
		} catch (Exception e) {
		}
		
		return str;
	}
	
	/**
	 *  导出 excel文件
	 * @throws Exception 
	 */
	public void exportExcelYingShouKuan() throws Exception{
		System.out.println(" 导出 excel文件 ");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-download");
//		设置下载的文件名称
		String filedisplay = "车辆营运调度台账-文档.xls";
		filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename="+ filedisplay);
		
//		-------------------------------------23
//		创建Excel对象
		HSSFWorkbook wb = new HSSFWorkbook(); 
		
//      第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
		HSSFSheet sheet =  wb.createSheet();
		
//		设置Excel单元格格式样式（居中，字体，边框等）对象
		HSSFCellStyle cellStyle = wb.createCellStyle();
//		设置字体
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 16);//设置字体大小
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
//		添加字体样式
		cellStyle.setFont(font);
//		设置居中
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中    
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中  

		
//		CellRangeAddress  对象的构造方法需要传入合并单元格的首行、最后一行、首列、最后一列。
		CellRangeAddress region=new CellRangeAddress(0, 0, 0, 23);
//		合并单元格所使用的方法：
		sheet.addMergedRegion(region);
//		设置标题
		Row titleRow = sheet.createRow(0);  //第一行
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("营运台账");
		titleCell.setCellStyle(cellStyle);
		
//		添加字体样式
		cellStyle.setFont(font);
		Row paraRow = sheet.createRow(1);  //第二行
//	  	初始化属性值和样式
		MyPoi.setParaCell(paraRow, wb);
		
//		开始填写数据

		MyPoi.setParaExcelValue(sheet,wb);
		
		
//		-------------------------------------
		
		try {
			OutputStream out = response.getOutputStream();
			wb.write(out);
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 *  导入excel
	 * @throws Exception 
	 */
	public String importExcelYingShouKuan() throws Exception{
		System.out.println("导入excel");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);	
//		加载applicationContext.xml文件
		
//		营收款 业务对象
			
//		运单业务对象
		
//		判断是否是excel文件
		int index = myexcelFileName.lastIndexOf(".");
		String excelStr = myexcelFileName.substring(index);
		if(excelStr == null || !".xls".equals(excelStr) && !".xlsx".equals(excelStr)){
			request.setAttribute("yingshoukuanerr", "请选择Excel文件");
			return "success";
		}

//		加载file文件
		FileInputStream fis = new FileInputStream(myexcel);
//		创建excel对象
		Workbook wb = null;
//		判断文件版本
		try { 
			wb = new HSSFWorkbook(fis); 
        } catch (Exception e) { 
        	fis = new FileInputStream(myexcel);
        	wb = new XSSFWorkbook(fis); 
        } 		
		
//		得到第一个sheet
		Sheet sheet = wb.getSheetAt(0);
//		得到总行数
		int rowNum = sheet.getLastRowNum(); 

//		正文内容应该从第三行开始,第一行为表头的标题,第二行是属性
		for (int i = 2; i <= rowNum; i++) {
//			得到一行的对象
			Row row = sheet.getRow(i);
//			订单号
			String dingdanhao = null;
			
			try {
				Cell dingdanhaoCell = row.getCell(0);
				dingdanhao = MyPoi.getMyCellFormula(dingdanhaoCell);				
			} catch (Exception e) {
				// TODO: handle exception
				continue;
			}
			
//			发票号
			Cell fapiaohaoCell = row.getCell(15);
			String fapiaohao = MyPoi.getMyCellFormula(fapiaohaoCell);
//			到账时间
			Cell daozhangshijianCell = row.getCell(14);
			Date daozhangshijian = MyPoi.getMyCellDate(daozhangshijianCell);
//			税金
			Cell shuijinCell = row.getCell(17);
			String shuijin = MyPoi.getMyCellFormula(shuijinCell);
//			开票时间
			Cell kaipiaoshijianCell = row.getCell(16);
			Date kaipiaoshijian = MyPoi.getMyCellDate(kaipiaoshijianCell);
//			管理费
			Cell guanlifeiCell = row.getCell(18);
			String guanlifei = MyPoi.getMyCellFormula(guanlifeiCell);
//			代垫费
			Cell daidianfeiCell = row.getCell(19);
			String daidianfei = MyPoi.getMyCellFormula(daidianfeiCell);
//			实付运费
			Cell shifuyunfeiCell = row.getCell(20);
			String shifuyunfei = MyPoi.getMyCellFormula(shifuyunfeiCell);
//			租车费
			Cell zuchefeiCell = row.getCell(23);
			String zuchefei = MyPoi.getMyCellFormula(zuchefeiCell);
//			业务费
			Cell yewufeiCell = row.getCell(24);
			String yewufei = MyPoi.getMyCellFormula(yewufeiCell);
//			备注
			Cell beizhuCell = row.getCell(25);
			String beizhu = MyPoi.getMyCellFormula(beizhuCell);
//			实收吨位
			Cell shishoudunweiCell = row.getCell(6);
			String shishoudunwei = MyPoi.getMyCellFormula(shishoudunweiCell);
//			实发吨位
			Cell shifadunweiCell = row.getCell(7);
			String shifadunwei = MyPoi.getMyCellFormula(shifadunweiCell);
//			里程
			Cell lichengCell = row.getCell(8);
			String licheng = MyPoi.getMyCellFormula(lichengCell);
//			单价
			Cell danjiaCell = row.getCell(9);
			String danjia = MyPoi.getMyCellFormula(danjiaCell);
//			营收
			Cell yingshouCell = row.getCell(13);
			String yingshou = MyPoi.getMyCellFormula(yingshouCell);
//			带空桶
			Cell daikongtongCell = row.getCell(10);
			String daikongtong = MyPoi.getMyCellFormula(daikongtongCell);
//			起点
			Cell qidianCell = row.getCell(11);
			String qidian = MyPoi.getMyCellFormula(qidianCell);
//			终点
			Cell zhongdianCell = row.getCell(12);
			String zhongdian = MyPoi.getMyCellFormula(zhongdianCell);
//			领款时间
			Cell lingkuanshijianCell = row.getCell(21);
			Date lingkuanshijian =  MyPoi.getMyCellDate(lingkuanshijianCell);
//			签收
			Cell qianshouCell = row.getCell(22);
			String qianshou = MyPoi.getMyCellFormula(qianshouCell);
			
//			判断订单号是否为null或空字符串
			if(dingdanhao!=null &&  !"".equals(dingdanhao)){
				YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
				if(yingshoukuan==null){
					continue;
				}
//				赋值
				yingshoukuan.setExcelYingShouKuan( dingdanhao,  daikongtong,  yingshou,
						 daozhangshijian,  fapiaohao,  kaipiaoshijian,
						 shuijin,  guanlifei,  shifuyunfei,
						 lingkuanshijian,  qianshou);
				yingshoukuan.setZuchefei(zuchefei);
				yingshoukuan.setYewufei(yewufei);
				yingshoukuan.setBeizhu(beizhu);
				
//				修改营收款
				yingShouKuanService.updateYingShouKuan(yingshoukuan);
				
//				得到指定订单号的运单
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				yundan.setShifadunwei(shifadunwei);
				yundan.setBaochoujine(danjia);
				yundan.setShishoudunwei(shishoudunwei);
				yundan.setLicheng(licheng);
				yundan.setQidian(qidian);
				yundan.setZhongdian(zhongdian);
				yundan.setDaidianfei(daidianfei);
//				修改运单
				yunDanService.updateYunDan(yundan);
			}
			
		}
		
		List<YingShouKuan> yingshoukuanlist = yingShouKuanService.queryYingShouKuanList();
		session.setAttribute("yingshoukuanlist", yingshoukuanlist);
		
		return "success";
	}
	
	/**
	 *  导入sonexcel
	 * @throws Exception 
	 */
	public String importSonExcelYingShouKuan() throws Exception{
		System.out.println("导入sonexcel");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);	
//		加载applicationContext.xml文件
		
//		营收款 业务对象
			
//		运单业务对象
		
//		判断是否是excel文件
		int index = sonexcelFileName.lastIndexOf(".");
		String excelStr = sonexcelFileName.substring(index);
		if(excelStr == null || !".xls".equals(excelStr) && !".xlsx".equals(excelStr)){
			request.setAttribute("yingshoukuanerr", "请选择Excel文件");
			return "success";
		}

//		加载file文件
		FileInputStream fis = new FileInputStream(sonexcel);
//		创建excel对象
		Workbook wb = null;
//		判断文件版本
		try { 
			wb = new HSSFWorkbook(fis); 
        } catch (Exception e) { 
        	fis = new FileInputStream(sonexcel);
        	wb = new XSSFWorkbook(fis); 
        } 		
		
//		得到第一个sheet
		Sheet sheet = wb.getSheetAt(0);
//		得到总行数
		int rowNum = sheet.getLastRowNum(); 

//		正文内容应该从第三行开始,第一行为表头的标题,第二行是属性
		for (int i = 2; i <= rowNum; i++) {
//			得到一行的对象
			Row row = sheet.getRow(i);
//			订单号
			Cell dingdanhaoCell = row.getCell(0);
			String dingdanhao = MyPoi.getMyCellFormula(dingdanhaoCell);
//			发票号
			Cell fapiaohaoCell = row.getCell(15);
			String fapiaohao = MyPoi.getMyCellFormula(fapiaohaoCell);
//			到账时间
			Cell daozhangshijianCell = row.getCell(14);
			Date daozhangshijian = MyPoi.getMyCellDate(daozhangshijianCell);
//			税金
			Cell shuijinCell = row.getCell(17);
			String shuijin = MyPoi.getMyCellFormula(shuijinCell);
//			开票时间
			Cell kaipiaoshijianCell = row.getCell(16);
			Date kaipiaoshijian = MyPoi.getMyCellDate(kaipiaoshijianCell);
//			管理费
			Cell guanlifeiCell = row.getCell(18);
			String guanlifei = MyPoi.getMyCellFormula(guanlifeiCell);
//			代垫费
			Cell daidianfeiCell = row.getCell(19);
			String daidianfei = MyPoi.getMyCellFormula(daidianfeiCell);
//			实付运费
			Cell shifuyunfeiCell = row.getCell(20);
			String shifuyunfei = MyPoi.getMyCellFormula(shifuyunfeiCell);
//			租车费
			Cell zuchefeiCell = row.getCell(23);
			String zuchefei = MyPoi.getMyCellFormula(zuchefeiCell);
//			业务费
			Cell yewufeiCell = row.getCell(24);
			String yewufei = MyPoi.getMyCellFormula(yewufeiCell);
//			备注
			Cell beizhuCell = row.getCell(25);
			String beizhu = MyPoi.getMyCellFormula(beizhuCell);
//			实收吨位
			Cell shishoudunweiCell = row.getCell(6);
			String shishoudunwei = MyPoi.getMyCellFormula(shishoudunweiCell);
//			实发吨位
			Cell shifadunweiCell = row.getCell(7);
			String shifadunwei = MyPoi.getMyCellFormula(shifadunweiCell);
//			里程
			Cell lichengCell = row.getCell(8);
			String licheng = MyPoi.getMyCellFormula(lichengCell);
//			单价
			Cell danjiaCell = row.getCell(9);
			String danjia = MyPoi.getMyCellFormula(danjiaCell);
//			营收
			Cell yingshouCell = row.getCell(13);
			String yingshou = MyPoi.getMyCellFormula(yingshouCell);
//			带空桶
			Cell daikongtongCell = row.getCell(10);
			String daikongtong = MyPoi.getMyCellFormula(daikongtongCell);
//			起点
			Cell qidianCell = row.getCell(11);
			String qidian = MyPoi.getMyCellFormula(qidianCell);
//			终点
			Cell zhongdianCell = row.getCell(12);
			String zhongdian = MyPoi.getMyCellFormula(zhongdianCell);
//			领款时间
			Cell lingkuanshijianCell = row.getCell(21);
			Date lingkuanshijian =  MyPoi.getMyCellDate(lingkuanshijianCell);
//			签收
			Cell qianshouCell = row.getCell(22);
			String qianshou = MyPoi.getMyCellFormula(qianshouCell);
			
//			判断订单号是否为null或空字符串
			if(dingdanhao!=null &&  !"".equals(dingdanhao)){
				YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
				if(yingshoukuan==null){
					continue;
				}
				
				Date kaipiaoshijianDate = yingshoukuan.getKaipiaoshijian();
				
				Date lingkuanshijianDate = yingshoukuan.getLingkuanshijian();
				
//				判断时间是否超出
				if(kaipiaoshijianDate != null && lingkuanshijianDate != null){
//					判断传递的日期加上月份 是否小于 当前日期 
					if(panduanDate(lingkuanshijianDate, 1)){
						continue;
					}
				}else{
					
					if(kaipiaoshijianDate != null){
//						判断传递的日期加上月份 是否小于 当前日期 
						if(panduanDate(kaipiaoshijianDate, 6)){
							continue;
						}
					}
					if(lingkuanshijianDate != null){
//						判断传递的日期加上月份 是否小于 当前日期 
						if(panduanDate(lingkuanshijianDate, 1)){
							continue;
						}
					}
					
				}
				
				
				
//				赋值
				yingshoukuan.setExcelYingShouKuan( dingdanhao,  daikongtong,  yingshou,
						 daozhangshijian,  fapiaohao,  yingshoukuan.getKaipiaoshijian(),
						 shuijin,  guanlifei,  shifuyunfei,
						 yingshoukuan.getLingkuanshijian(),  yingshoukuan.getQianshou());
				yingshoukuan.setZuchefei(zuchefei);
				yingshoukuan.setYewufei(yewufei);
				yingshoukuan.setBeizhu(beizhu);
				
//				修改营收款
				yingShouKuanService.updateYingShouKuan(yingshoukuan);
				
//				得到指定订单号的运单
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				yundan.setShifadunwei(shifadunwei);
				yundan.setBaochoujine(danjia);
				yundan.setShishoudunwei(shishoudunwei);
				yundan.setLicheng(licheng);
				yundan.setQidian(qidian);
				yundan.setZhongdian(zhongdian);
				yundan.setDaidianfei(daidianfei);
//				修改运单
				yunDanService.updateYunDan(yundan);
			}
			
		}
		
		List<YingShouKuan> yingshoukuanlist = yingShouKuanService.queryYingShouKuanList();
		session.setAttribute("yingshoukuanlist", yingshoukuanlist);
		
		return "success";
	}
	
	
	/**
	 *  判断日期
	 */
	public boolean panduanDate(Date date , int month){
		
		Calendar   calendar   =   Calendar.getInstance();    
		calendar.setTime(date);
		
		Date myDate = new Date();
		
		if(myDate.after( calendar.getTime() )){
			return true;
		}
		
		return false;
	}
	
	
	/**
	 *  跳转-营收款 全部
	 */
	public String jumpYingShouKuanAll(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		

		 yingshoukuanlistall = yingShouKuanService.queryYingShouKuanList();
		request.setAttribute("yingshoukuanlistall", yingshoukuanlistall);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	
	/**
	 *  营收款json 全部 
	 */
	public void yingShouKuanJsonAll(){

//		设置字符格式
		FontFormat.setFontFormat(response);		
	
		List<YingShouKuanModelAll> yingshoukuanmodelalllist = YingShouKuanModelAll.getYingShouKuanModelAllList(yingshoukuanlistall, yunDanService, cheLiangService , customerService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodelalllist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  模糊查询 全部
	 */
	public String vagueSearchYingShouKuanAll(){
		System.out.println(" 模糊查询 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		yingshoukuanlistall = yingShouKuanService.vagueSearchYingShouKuanAll(dingdanhao,yingshoukuanzhuangtai,jiesuanzhuangtai , kehudanwei);
		request.setAttribute("yingshoukuanlistall", yingshoukuanlistall);
		
		session.setAttribute("yingshoukuanchepaihaoall", chepaihao);
		session.setAttribute("yingshoukuanhuowumingchengall", huowumingcheng);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  ajax 修改营收款
	 */
	public void ajaxUpdateYingShouKuan(){
		System.out.println(" ajax 修改营收款 ");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
		
		
		String value = request.getParameter("value");
		String myId = request.getParameter("myId");
		String columnName = request.getParameter("columnName");
		
//		判断是否符合条件
			
		
//		得到运单业务对象
			
		
		YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId(Integer.valueOf(myId));
		
		
		if( "已结算".equals(yingshoukuan.getJiesuanzhuangtai()) ){
			return ;
		}
		if("yingshou".equals(columnName) && "已开票".equals(yingshoukuan.getYingshoukuanzhuangtai())){
			return ;
		}
		
		String dingdanhao = yingshoukuan.getDingdanhao();
		
		
		if( "daidianfei".equals(columnName)
			|| "shishoudunwei".equals(columnName)								
			|| "shifadunwei".equals(columnName)								
			|| "licheng".equals(columnName)								
			|| "qidian".equals(columnName)								
			|| "zhongdian".equals(columnName)){
			
			yunDanService.updateYunDanColumnNameValue(value, dingdanhao, columnName);
		}else{
			yingShouKuanService.updateYingShouKuanColumnNameValue(value, myId, columnName);
		}
		
		
		 yingshoukuanlistall = yingShouKuanService.queryYingShouKuanList();
		request.setAttribute("yingshoukuanlistall", yingshoukuanlistall);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("flag", "success");
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
	 *  提交结算单
	 */
	public String submitJieSuanDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 提交结算单 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
//		营收款 业务对象
			
//		费用收取 业务对象
		
//		运单 业务对象
		
//		车辆业务对象
					
		
		String id[] = request.getParameterValues("toolbar1");
//		判断是否选中
		if(id == null || id.length<1){
			request.setAttribute("yingshoukuanerr", "请选择");
			
			jiesuanlist   =  yingShouKuanService.queryYingShouKuanByConditionList("dongshizhangjiesuanshenhe", "审核通过");
			request.setAttribute("jiesuanlist", jiesuanlist);
				
			return "success";
		}
		
//		判断是否可以结算
		for (int i = 0; i < id.length; i++) {
			
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId(Integer.valueOf(id[i]));
			if( !"未结算".equals(yingshoukuan.getJiesuanzhuangtai()) ){
				request.setAttribute("yingshoukuanerr", "请选择未结算");
				
				jiesuanlist   =  yingShouKuanService.queryYingShouKuanByConditionList("dongshizhangjiesuanshenhe", "审核通过");
				request.setAttribute("jiesuanlist", jiesuanlist);
				
				return "success";
			}
		}
		
		
		
		Users users =  (Users) session.getAttribute("users");
		String caozuoyuan = users.getUsername();
		Date   caozuoriqi = new Date();
		
//		开始添加结算单
		for (int i = 0; i < id.length; i++) {
			
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId(Integer.valueOf(id[i]));
			
			String dingdanhao = yingshoukuan.getDingdanhao();	//订单号
			String daikongtong = yingshoukuan.getDaikongtong();	//带空桶
			String yingshou = yingshoukuan.getYingshou();	//营收
			Date  daozhangshijian = yingshoukuan.getDaozhangshijian();	//到账时间		
			String fapiaohao = yingshoukuan.getFapiaohao();	//发票号
			Date kaipiaoshijian = yingshoukuan.getKaipiaoshijian();	//开票时间
			String shuijin = yingshoukuan.getShuijin();	//税金
			String guanlifei = yingshoukuan.getGuanlifei();	//管理费
			String shifuyunfei = yingshoukuan.getShifuyunfei();	//实付运费
			Date lingkuanshijian = yingshoukuan.getLingkuanshijian();	//领款时间
			String qianshou = yingshoukuan.getQianshou();	//签收
			String kehudanwei = yingshoukuan.getKehudanwei();	//客户单位
			
			YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao); 
			
			Date yunshushijian = yundan.getYunshushijian();	//运输时间
			String chepaihao = yundan.getChepaihao();	//车牌号
			String huowumingcheng = yundan.getHuowumingcheng();	//货物名称
			String shishoudunwei = yundan.getShishoudunwei();	//实收吨位
			String shifadunwei = yundan.getShifadunwei();	//实发吨位
			String licheng = yundan.getLicheng();	//里程
			String baochouleixing = yundan.getBaochouleixing();	//报酬类型
			String baochoujine = yundan.getBaochoujine();	//报酬金额
			String qidian = yundan.getQidian();	//起点
			String zhongdian = yundan.getZhongdian();	//终点
			String dianhua = yundan.getDianhua();	//电话
			String lianxiren = yundan.getLianxiren();	//联系人
			String yujidunwei = yundan.getYujidunwei();	//预计吨位
			String anquanka = yundan.getAnquanka();	//安全卡
			String daidianfei = yundan.getDaidianfei();	//代垫费
			String dizhi = yundan.getDizhi();	//地址
			String feiyongmiaoshu = yundan.getFeiyongmiaoshu();	//费用描述
			
			CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);

			String chezhuxingming = "";	//车主姓名
			if(cheliang != null){
				chezhuxingming = cheliang.getChezhuxingming();
			}
			
//			添加结算单
			JieSuanDan jiesuandan = new JieSuanDan();
			jiesuandan.setJieSuanDan( dingdanhao,  daikongtong,  yingshou,
					 daozhangshijian,  fapiaohao,  kaipiaoshijian,
					 shuijin,  guanlifei,  shifuyunfei,
					 lingkuanshijian,  qianshou,  kehudanwei,
					 yunshushijian,  chepaihao,  huowumingcheng,
					 shishoudunwei,  shifadunwei,  licheng,
					 baochouleixing,  baochoujine,  qidian,
					 zhongdian,  dianhua,  lianxiren,
					 yujidunwei,  anquanka,  daidianfei,
					 dizhi,  feiyongmiaoshu,  chezhuxingming);
			jiesuandan.setCaozuoyuan(caozuoyuan);
			jiesuandan.setCaozuoriqi(caozuoriqi);
			
			jieSuanDanService.addJieSuanDan(jiesuandan);
			
//			修改营收款对象
			yingshoukuan.setJiesuanzhuangtai("已结算");
			yingShouKuanService.updateYingShouKuan(yingshoukuan);
			
//			同步费用收取
			if("已转账".equals( yingshoukuan.getZhuanzhangzhuangtai() )){
//				已转账的车主 用 zhenshichezhu
				FeiYongShouQuController.SynchronizationFeiYongShouQu( yingshoukuan.getZhenshichezhu() , feiYongShouQuService
																		,  cheLiangService , yingShouKuanService
																		,  yunDanService ,  baoXianService );
																
			}else{
//				没转账的车主 用 chezhuxingming
				FeiYongShouQuController.SynchronizationFeiYongShouQu( chezhuxingming , feiYongShouQuService
																	,  cheLiangService , yingShouKuanService
																	,  yunDanService ,  baoXianService );
			}
			
		}
		
		jiesuanlist   =  yingShouKuanService.queryYingShouKuanByConditionList("dongshizhangjiesuanshenhe", "审核通过");
		request.setAttribute("jiesuanlist", jiesuanlist);
		
		return "success";
	}
	
	/**
	 *  跳转-转账结算单
	 */
	public String jumpZhuanZhangJieSuanDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 跳转-转账结算单 ");
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
//		营收款 业务对象
			
		
		String id[] = request.getParameterValues("toolbar1");
//		判断是否选中
		if(id == null || id.length<1 || id.length>1){
			request.setAttribute("yingshoukuanerr", "请选择1个进行转账");
			
			CheLiangController.sendCheLiang(cheLiangService);
				
			return "err";
		}
		
//		判断是否可以结算
		for (int i = 0; i < id.length; i++) {
			
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId(Integer.valueOf(id[i]));
			if( !"未结算".equals(yingshoukuan.getJiesuanzhuangtai()) ){
				request.setAttribute("yingshoukuanerr", "请选择未结算");
				
				
				CheLiangController.sendCheLiang(cheLiangService);
				
				return "err";
			}
		}
		
		singleyingshoukuan = yingShouKuanService.queryYingShouKuanId(Integer.valueOf( id[0] ));
		request.setAttribute("singleyingshoukuan", singleyingshoukuan);
		session.setAttribute("singleyingshoukuan", singleyingshoukuan);
		
//		车辆业务对象
			
		List<CheLiang> chelianglist = cheLiangService.queryCheLiangList();
		
		request.setAttribute("chelianglist", chelianglist);
		
		return "success";
	}
	
	/**
	 *  转账结算单
	 */
	public String zhuanZhangJieSuanDan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 转账结算单 ");
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		
//		营收款 业务对象
		singleyingshoukuan = (YingShouKuan) session.getAttribute("singleyingshoukuan");	
		
		singleyingshoukuan.setZhenshichezhu(zhenshichezhu);
		singleyingshoukuan.setZhuanzhangzhuangtai("已转账");
		
//		修改
		yingShouKuanService.updateYingShouKuan(singleyingshoukuan);
		

		
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		session.removeAttribute("singleyingshoukuan");
		
		return "success";
	}
	
	
//	------------------------
//	开票申请
//	----------------------
	public String jumpKaiPiaoShenQing(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		kaipiaoshenqinglist = yingShouKuanService.queryYingShouKuanList();
		request.setAttribute("kaipiaoshenqinglist", kaipiaoshenqinglist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  模糊查询
	 */
	public String vagueSearchKaiPiaoShenQing(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 模糊查询 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		

		kaipiaoshenqinglist = yingShouKuanService.vagueSearchKaiPiaoShenQing(dingdanhao, kaipiaoshenqing, kehudanwei );
		
		if(huowumingcheng!=null && !"".equals(huowumingcheng)){
			for (int i = 0; i < kaipiaoshenqinglist.size(); i++) {
				
				YingShouKuan yingshoukuan =  kaipiaoshenqinglist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! huowumingcheng.equals( yundan.getHuowumingcheng() )){
					kaipiaoshenqinglist.remove(i);
					--i;
				}
				
			}
		}
		
		if(chepaihao!=null && !"".equals(chepaihao)){
			for (int i = 0; i < kaipiaoshenqinglist.size(); i++) {
				
				YingShouKuan yingshoukuan =  kaipiaoshenqinglist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! chepaihao.equals( yundan.getChepaihao() )){
					kaipiaoshenqinglist.remove(i);
					--i;
				}
				
			}
		}
		
		request.setAttribute("kaipiaoshenqinglist", kaipiaoshenqinglist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		
		return "success";
	}
	
	/**
	 *  开票申请json
	 */
	public void kaiPiaoShenQingJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		if(kaipiaoshenqinglist == null || kaipiaoshenqinglist.size()<1){
			return ;
		}
		
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getYingShouInKaiPiaoModelList(kaipiaoshenqinglist,  yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  jump update
	 */
	public String jumpUpdateKaiPiaoShenQing(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
        String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1){
			request.setAttribute("yingshoukuanerr", "请选择进行申请");
			return "success";
		}
		
			
		
		for (int i = 0; i < id.length; i++) {
			YingShouKuan  singlekaipiaoshenqing = yingShouKuanService.queryYingShouKuanId(Integer.valueOf(id[i]));
			
			Users loginUser = (Users) session.getAttribute("users");
			
			singlekaipiaoshenqing.setKaipiaoshenqing("已申请");
			singlekaipiaoshenqing.setKaipiaoshenqingren(loginUser.getUsername());
			yingShouKuanService.updateYingShouKuan(singlekaipiaoshenqing);
		}
		
		
		kaipiaoshenqinglist = yingShouKuanService.queryYingShouKuanList();
		request.setAttribute("kaipiaoshenqinglist", kaipiaoshenqinglist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 * detail
	 */
	public String kaiPiaoShenQingXiangXi(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
//	----------------------
//	开票审核(分管)
//	----------------------
	/**
	 *  jump 
	 */
	public String jumpFenGuanKaiPiaoShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		 fenguankaipiaoshenhelist =  yingShouKuanService.queryYingShouKuanByConditionList("kaipiaoshenqing", "已申请");
		
		 CheLiangController.sendCheLiang(cheLiangService);
		 
		return "success";
	}
	
	/**
	 *  vagueSearch
	 */
	public String vagueSearchFenGuanKaiPiaoShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		
		String conditionName[] = {"dingdanhao" , "fenguankaipiaoshenhe" , "kaipiaoshenqing" , "kehudanwei"} ;
		String conditionValue[] = {dingdanhao , fenguankaipiaoshenhe , "已申请" , kehudanwei} ;
		
		fenguankaipiaoshenhelist = yingShouKuanService.vagueSearchByCondition( conditionName , conditionValue);
		
		if(huowumingcheng!=null && !"".equals(huowumingcheng)){
			for (int i = 0; i < fenguankaipiaoshenhelist.size(); i++) {
				
				YingShouKuan yingshoukuan =  fenguankaipiaoshenhelist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! huowumingcheng.equals( yundan.getHuowumingcheng() )){
					fenguankaipiaoshenhelist.remove(i);
					--i;
				}
				
			}
		}
		
		if(chepaihao!=null && !"".equals(chepaihao)){
			for (int i = 0; i < fenguankaipiaoshenhelist.size(); i++) {
				
				YingShouKuan yingshoukuan =  fenguankaipiaoshenhelist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! chepaihao.equals( yundan.getChepaihao() )){
					fenguankaipiaoshenhelist.remove(i);
					--i;
				}
				
			}
		}
		
		request.setAttribute("fenguankaipiaoshenhelist", fenguankaipiaoshenhelist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  json 
	 */
	public void fenGuanKaiPiaoShenHeJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		if(fenguankaipiaoshenhelist == null || fenguankaipiaoshenhelist.size()<1){
			return ;
		}
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getMethodNameList(fenguankaipiaoshenhelist, "fenGuanKaiPiaoShenHeXiangXi",  yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 *  jump update
	 */
	public String jumpUpdateFenGuanKaiPiaoShenHe(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 || id.length>1){
			request.setAttribute("yingshoukuanerr", "请选择单个进行审核");
			
			CheLiangController.sendCheLiang(cheLiangService);
			
			return "err";
		}

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf(id[0]) );
		if(!"未审核".equals( singleyingshoukuan.getFenguankaipiaoshenhe() )){
			request.setAttribute("yingshoukuanerr", "请选择未审核");
			return "err";
		}
		
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(singleyingshoukuan.getDingdanhao());
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		session.setAttribute("singleyingshoukuan",singleyingshoukuan);
		
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		return "success";
	}
	
	/**
	 * update
	 */
	public String updateFenGuanKaiPiaoShenHe(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
        
        String flag = request.getParameter("flag");
        String id = request.getParameter("id");
		
        Users loginUser = (Users) session.getAttribute("users");
        String caozuoyuan = loginUser.getUsername();
        
        	
        YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id ) );
        
        if("审核通过".equals(flag)){
        
        	yingshoukuan.setFenguankaipiaoshenhe("审核通过");
        	yingshoukuan.setFenguankaipiaoshenheren(caozuoyuan);
        	
        }else if("未通过".equals(flag)){
        	yingshoukuan.setKaipiaoshenqing("未通过");
        }
        
        yingShouKuanService.updateYingShouKuan(yingshoukuan);
        
        fenguankaipiaoshenhelist =  yingShouKuanService.queryYingShouKuanByConditionList("kaipiaoshenqing", "已申请");
        
        CheLiangController.sendCheLiang(cheLiangService);
        
		return "success";
	}
	
	/**
	 * 开票审核 全部通过
	 */
	public String kaiPiaoShenHeYesAll(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }

        CheLiangController.sendCheLiang(cheLiangService);
		
        
        String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 ){
			request.setAttribute("yingshoukuanerr", "请选择进行审核");
			
			return "success";
		}

		 Users loginUser = (Users) session.getAttribute("users");
         String caozuoyuan = loginUser.getUsername();
		
			
        
        for (int i = 0; i < id.length; i++) {
			
            YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id[i] ) );
             
         	yingshoukuan.setFenguankaipiaoshenhe("审核通过");
         	yingshoukuan.setFenguankaipiaoshenheren(caozuoyuan);
         	
         	 yingShouKuanService.updateYingShouKuan(yingshoukuan);
		}
		
        fenguankaipiaoshenhelist =  yingShouKuanService.queryYingShouKuanByConditionList("kaipiaoshenqing", "已申请");
		
		return "success";
	}
	
	/**
	 * 开票审核 全部未通过
	 */
	public String kaiPiaoShenHeNoAll(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }

        CheLiangController.sendCheLiang(cheLiangService);
		
        
        String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 ){
			request.setAttribute("yingshoukuanerr", "请选择进行审核");
			
			return "success";
		}

		 Users loginUser = (Users) session.getAttribute("users");
         String caozuoyuan = loginUser.getUsername();
		
			
        
        for (int i = 0; i < id.length; i++) {
			
            YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id[i] ) );
             
            yingshoukuan.setKaipiaoshenqing("未通过");
         	yingshoukuan.setFenguankaipiaoshenheren(caozuoyuan);
         	
         	 yingShouKuanService.updateYingShouKuan(yingshoukuan);
		}
		
        fenguankaipiaoshenhelist =  yingShouKuanService.queryYingShouKuanByConditionList("kaipiaoshenqing", "已申请");
		
		return "success";
	}
	
	/**
	 * detail
	 */
	public String fenGuanKaiPiaoShenHeXiangXi(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		return "success";
	}
	
//	----------------------
//	开票审核(总经理)
//	----------------------
	/**
	 *  jump 
	 */
	public String jumpZongJingLiKaiPiaoShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		zongjinglikaipiaoshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionList("fenguankaipiaoshenhe", "审核通过");
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  vagueSearch
	 */
	public String vagueSearchZongJingLiKaiPiaoShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		
		String conditionName[] = {"dingdanhao" , "zongjinglikaipiaoshenhe" , "fenguankaipiaoshenhe" , "kehudanwei"} ;
		String conditionValue[] = {dingdanhao, zongjinglikaipiaoshenhe ,  "审核通过" , kehudanwei} ;
		
		zongjinglikaipiaoshenhelist = yingShouKuanService.vagueSearchByCondition( conditionName , conditionValue);
		
		if(huowumingcheng!=null && !"".equals(huowumingcheng)){
			for (int i = 0; i < zongjinglikaipiaoshenhelist.size(); i++) {
				
				YingShouKuan yingshoukuan =  zongjinglikaipiaoshenhelist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! huowumingcheng.equals( yundan.getHuowumingcheng() )){
					zongjinglikaipiaoshenhelist.remove(i);
					--i;
				}
				
			}
		}
		
		if(chepaihao!=null && !"".equals(chepaihao)){
			for (int i = 0; i < zongjinglikaipiaoshenhelist.size(); i++) {
				
				YingShouKuan yingshoukuan =  zongjinglikaipiaoshenhelist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! chepaihao.equals( yundan.getChepaihao() )){
					zongjinglikaipiaoshenhelist.remove(i);
					--i;
				}
				
			}
		}
		
		
		request.setAttribute("zongjinglikaipiaoshenhelist", zongjinglikaipiaoshenhelist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  json
	 */
	public void zongJingLiKaiPiaoShenHeJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		if(zongjinglikaipiaoshenhelist == null || zongjinglikaipiaoshenhelist.size()<1){
			return ;
		}
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getMethodNameList(zongjinglikaipiaoshenhelist, "zongJingLiKaiPiaoShenHeXiangXi",  yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 *  jump update
	 */
	public String jumpUpdateZongJingLiKaiPiaoShenHe(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 || id.length>1){
			request.setAttribute("yingshoukuanerr", "请选择单个进行审核");
			
			CheLiangController.sendCheLiang(cheLiangService);
			
			return "err";
		}

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf(id[0]) );
		if(!"未审核".equals( singleyingshoukuan.getZongjinglikaipiaoshenhe() )){
			request.setAttribute("yingshoukuanerr", "请选择未审核");
			
			CheLiangController.sendCheLiang(cheLiangService);
			
			return "err";
		}
		
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(singleyingshoukuan.getDingdanhao());
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		return "success";
	}
	
	/**
	 *  update
	 */
	public String updateZongJingLiKaiPiaoShenHe(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
        
        String flag = request.getParameter("flag");
        String id = request.getParameter("id");
		
        Users loginUser = (Users) session.getAttribute("users");
        String caozuoyuan = loginUser.getUsername();
        
        	
        YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id ) );
        
        if("审核通过".equals(flag)){
        
        	yingshoukuan.setZongjinglikaipiaoshenhe("审核通过");
        	yingshoukuan.setZongjinglikaipiaoshenheren(caozuoyuan);
        	
        }else if("未通过".equals(flag)){
        	yingshoukuan.setKaipiaoshenqing("未通过");
        	yingshoukuan.setFenguankaipiaoshenhe("未审核");
        }
        
        yingShouKuanService.updateYingShouKuan(yingshoukuan);
        
        zongjinglikaipiaoshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionList("fenguankaipiaoshenhe", "审核通过");
		
        CheLiangController.sendCheLiang(cheLiangService);
        
		return "success";
	}
	
	/**
	 * 开票总经理 全部通过
	 */
	public String kaiPiaoShenHeZongJingLiYesAll(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
        
        CheLiangController.sendCheLiang(cheLiangService);
        
        String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1){
			request.setAttribute("yingshoukuanerr", "请选择进行审核");
			
			return "success";
		}

			
		
		Users loginUser = (Users) session.getAttribute("users");
        String caozuoyuan = loginUser.getUsername();
        
		for (int i = 0; i < id.length; i++) {
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id[i] ) );
			
			yingshoukuan.setZongjinglikaipiaoshenhe("审核通过");
			yingshoukuan.setZongjinglikaipiaoshenheren(caozuoyuan);
			
			yingShouKuanService.updateYingShouKuan(yingshoukuan);
		}
		
		zongjinglikaipiaoshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionList("fenguankaipiaoshenhe", "审核通过");
	        
		return "success";
	}
	
	
	/**
	 * 开票总经理 全部未通过
	 */
	public String kaiPiaoShenHeZongJingLiNoAll(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
        
        CheLiangController.sendCheLiang(cheLiangService);
        
        String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1){
			request.setAttribute("yingshoukuanerr", "请选择进行审核");
			
			return "success";
		}

			
		
		Users loginUser = (Users) session.getAttribute("users");
        String caozuoyuan = loginUser.getUsername();
        
		for (int i = 0; i < id.length; i++) {
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id[i] ) );
			
			yingshoukuan.setKaipiaoshenqing("未通过");
        	yingshoukuan.setFenguankaipiaoshenhe("未审核");
        	yingshoukuan.setZongjinglikaipiaoshenhe("未审核");
			
			yingShouKuanService.updateYingShouKuan(yingshoukuan);
		}
		
		zongjinglikaipiaoshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionList("fenguankaipiaoshenhe", "审核通过");
	        
		return "success";
	}
	
	
	/**
	 * detail
	 */
	public String zongJingLiKaiPiaoShenHeXiangXi(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
	
//	----------------------
//	开票
//	----------------------
	/**
	 *  jump
	 */
	public String jumpYingShouKuanKaiPiao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		 kaipiaolist   =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglikaipiaoshenhe", "审核通过");
		request.setAttribute("kaipiaolist", kaipiaolist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 * vague search
	 */
	public String vagueSearchYingShouKuanKaiPiao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 模糊查询 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		kaipiaolist = yingShouKuanService.vagueSearchYingShouKuanCondition(dingdanhao,yingshoukuanzhuangtai,jiesuanzhuangtai , kehudanwei , "zongjinglikaipiaoshenhe" ,"审核通过");
		request.setAttribute("kaipiaolist", kaipiaolist);
		
		session.setAttribute("yingshoukuanchepaihao", chepaihao);
		
		session.setAttribute("yingshoukuanhuowumingcheng", huowumingcheng);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	
	/**
	 *  json
	 */
	public void yingShouKuanKaiPiaoJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(kaipiaolist == null || kaipiaolist.size()<1){
			return ;
		}
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getYingShouKuanModeMethodlList(kaipiaolist, "yingShouKuanKaiPiaoXiangXi",  yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 * detail
	 */
	public String yingShouKuanKaiPiaoXiangXi(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
	
//	----------------------
//	结算申请
//	----------------------
	
//	----------------------
//	结算申请
//	----------------------
	
	public String jumpJieSuanShenQing(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		jiesuanshenqinglist = yingShouKuanService.queryYingShouKuanList();
		request.setAttribute("jiesuanshenqinglist", jiesuanshenqinglist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	public String vagueSearchJieSuanShenQing(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		

		jiesuanshenqinglist = yingShouKuanService.vagueSearchJieSuanShenQing( dingdanhao, jiesuanshenqing ,  kehudanwei);
		
		if(huowumingcheng!=null && !"".equals(huowumingcheng)){
			for (int i = 0; i < jiesuanshenqinglist.size(); i++) {
				
				YingShouKuan yingshoukuan =  jiesuanshenqinglist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! huowumingcheng.equals( yundan.getHuowumingcheng() )){
					jiesuanshenqinglist.remove(i);
					--i;
				}
				
			}
		}
		
		if(chepaihao!=null && !"".equals(chepaihao)){
			for (int i = 0; i < jiesuanshenqinglist.size(); i++) {
				
				YingShouKuan yingshoukuan =  jiesuanshenqinglist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! chepaihao.equals( yundan.getChepaihao() )){
					jiesuanshenqinglist.remove(i);
					--i;
				}
				
			}
		}
		
		
		request.setAttribute("jiesuanshenqinglist", jiesuanshenqinglist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	public void jieSuanShenQingJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		if(jiesuanshenqinglist == null || jiesuanshenqinglist.size()<1){
			return ;
		}
		
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getMethodNameList(jiesuanshenqinglist, "jieSuanShenQingXiangXi" ,  yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	/**
	 *  jump update
	 */
	public String jumpUpdateJieSuanShenQing(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
        String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 ){
			request.setAttribute("yingshoukuanerr", "请选择进行申请");
			
			CheLiangController.sendCheLiang(cheLiangService);
			
			return "success";
		}
		
			
		
		for (int i = 0; i < id.length; i++) {
			YingShouKuan  singlekaipiaoshenqing = yingShouKuanService.queryYingShouKuanId(Integer.valueOf(id[i]));
			
			Users loginUser = (Users) session.getAttribute("users");
			
			singlekaipiaoshenqing.setJiesuanshenqing("已申请");
			singlekaipiaoshenqing.setJiesuanshenqingren(loginUser.getUsername());
			yingShouKuanService.updateYingShouKuan(singlekaipiaoshenqing);
		}
		
		
		jiesuanshenqinglist = yingShouKuanService.queryYingShouKuanList();
		request.setAttribute("jiesuanshenqinglist", jiesuanshenqinglist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	public String jieSuanShenQingXiangXi(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
//	----------------------
//	结算审核(总经理)
//	----------------------
	
	
//	----------------------
//	结算审核(总经理)
//	----------------------
	/**
	 *  jump
	 */
	public String jumpZongJingLiJieSuanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		zongjinglijiesuanshenhelist =  yingShouKuanService.queryYingShouKuanByConditionList("jiesuanshenqing", "已申请");
		request.setAttribute("zongjinglijiesuanshenhelist", zongjinglijiesuanshenhelist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  vagueSearch
	 */
	public String vagueSearchZongJingLiJieSuanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		
		String conditionName[] = {"dingdanhao" , "zongjinglijiesuanshenhe" , "jiesuanshenqing" , "kehudanwei"};
		String conditionValue[] = {dingdanhao, zongjinglijiesuanshenhe , "已申请" , kehudanwei};
		
		zongjinglijiesuanshenhelist = yingShouKuanService.vagueSearchByCondition( conditionName , conditionValue);
		
		if(huowumingcheng!=null && !"".equals(huowumingcheng)){
			for (int i = 0; i < zongjinglijiesuanshenhelist.size(); i++) {
				
				YingShouKuan yingshoukuan =  zongjinglijiesuanshenhelist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! huowumingcheng.equals( yundan.getHuowumingcheng() )){
					zongjinglijiesuanshenhelist.remove(i);
					--i;
				}
				
			}
		}
		
		if(chepaihao!=null && !"".equals(chepaihao)){
			for (int i = 0; i < zongjinglijiesuanshenhelist.size(); i++) {
				
				YingShouKuan yingshoukuan =  zongjinglijiesuanshenhelist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! chepaihao.equals( yundan.getChepaihao() )){
					zongjinglijiesuanshenhelist.remove(i);
					--i;
				}
				
			}
		}
		
		request.setAttribute("zongjinglijiesuanshenhelist", zongjinglijiesuanshenhelist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  json
	 */
	public void zongJingLiJieSuanShenHeJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		if(zongjinglijiesuanshenhelist == null || zongjinglijiesuanshenhelist.size()<1){
			return ;
		}
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getMethodNameList(zongjinglijiesuanshenhelist, "zongJingLiJieSuanShenHeXiangXi",  yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	
	/**
	 *  jump update
	 */
	public String jumpUpdateZongJingLiJieSuanShenHe(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
        CheLiangController.sendCheLiang(cheLiangService);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 || id.length>1){
			request.setAttribute("yingshoukuanerr", "请选择单个进行审核");
			return "err";
		}

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf(id[0]) );
		if(!"未审核".equals( singleyingshoukuan.getZongjinglijiesuanshenhe() )){
			request.setAttribute("yingshoukuanerr", "请选择未审核");
			return "err";
		}
		
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(singleyingshoukuan.getDingdanhao());
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		return "success";
	}
	
	/**
	 * update
	 */
	public String updateZongJingLiJieSuanShenHe(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
        
        String flag = request.getParameter("flag");
        String id = request.getParameter("id");
		
        Users loginUser = (Users) session.getAttribute("users");
        String caozuoyuan = loginUser.getUsername();
        
        	
        YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id ) );
        
        if("审核通过".equals(flag)){
        
        	yingshoukuan.setZongjinglijiesuanshenhe("审核通过");
        	yingshoukuan.setZongjinglijiesuanshenheren( caozuoyuan );
        	
        }else if("未通过".equals(flag)){
        	yingshoukuan.setJiesuanshenqing("未通过");
        }
        
        yingShouKuanService.updateYingShouKuan(yingshoukuan);
        
        zongjinglijiesuanshenhelist =  yingShouKuanService.queryYingShouKuanByConditionList("jiesuanshenqing", "已申请");
		request.setAttribute("zongjinglijiesuanshenhelist", zongjinglijiesuanshenhelist);
        
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 * 结算审核总经理 全部通过
	 */
	public String jieSuanShenHeZongJingLiYesAll(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
        CheLiangController.sendCheLiang(cheLiangService);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 ){
			request.setAttribute("yingshoukuanerr", "请选择进行审核");
			return "success";
		}

		Users loginUser = (Users) session.getAttribute("users");
		String caozuoyuan = loginUser.getUsername();
		
			

		
		for (int i = 0; i < id.length; i++) {
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id[i] ) );
			
			yingshoukuan.setZongjinglijiesuanshenhe("审核通过");
			yingshoukuan.setZongjinglijiesuanshenheren( caozuoyuan );
			
			yingShouKuanService.updateYingShouKuan(yingshoukuan);
		}
		
		
		zongjinglijiesuanshenhelist =  yingShouKuanService.queryYingShouKuanByConditionList("jiesuanshenqing", "已申请");
		request.setAttribute("zongjinglijiesuanshenhelist", zongjinglijiesuanshenhelist);
		
		return "success";
	}
	
	/**
	 * 结算审核总经理 全部未通过
	 */
	public String jieSuanShenHeZongJingLiNoAll(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
        CheLiangController.sendCheLiang(cheLiangService);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 ){
			request.setAttribute("yingshoukuanerr", "请选择进行审核");
			return "success";
		}

		Users loginUser = (Users) session.getAttribute("users");
		String caozuoyuan = loginUser.getUsername();
		
			

		
		for (int i = 0; i < id.length; i++) {
			YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id[i] ) );
			
			yingshoukuan.setJiesuanshenqing("未通过");
			
			yingShouKuanService.updateYingShouKuan(yingshoukuan);
		}
		
		
		zongjinglijiesuanshenhelist =  yingShouKuanService.queryYingShouKuanByConditionList("jiesuanshenqing", "已申请");
		request.setAttribute("zongjinglijiesuanshenhelist", zongjinglijiesuanshenhelist);
		
		return "success";
	}
	
	/**
	 *  detail
	 */
	public String zongJingLiJieSuanShenHeXiangXi(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
//	----------------------
//	结算审核(董事长)
//	----------------------
	
	
//	----------------------
//	结算审核(董事长)
//	----------------------
	/**
	 *  jump 
	 */
	public String jumpDongShiZhangJieSuanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		dongshizhangjiesuanshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglijiesuanshenhe", "审核通过");
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  vagueSearch
	 */
	public String vagueSearchDongShiZhangJieSuanShenHe(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		
		String conditionName[] = {"dingdanhao" , "dongshizhangjiesuanshenhe", "zongjinglijiesuanshenhe" , "kehudanwei"};
		String conditionValue[] = {dingdanhao, dongshizhangjiesuanshenhe , "审核通过" , kehudanwei};
		
		dongshizhangjiesuanshenhelist = yingShouKuanService.vagueSearchByCondition( conditionName , conditionValue);
		
		if(huowumingcheng!=null && !"".equals(huowumingcheng)){
			for (int i = 0; i < dongshizhangjiesuanshenhelist.size(); i++) {
				
				YingShouKuan yingshoukuan =  dongshizhangjiesuanshenhelist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! huowumingcheng.equals( yundan.getHuowumingcheng() )){
					dongshizhangjiesuanshenhelist.remove(i);
					--i;
				}
				
			}
		}
		
		if(chepaihao!=null && !"".equals(chepaihao)){
			for (int i = 0; i < dongshizhangjiesuanshenhelist.size(); i++) {
				
				YingShouKuan yingshoukuan =  dongshizhangjiesuanshenhelist.get(i);
				String dingdanhao =  yingshoukuan.getDingdanhao();
				
				
				YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
				
				if(yundan == null){
					continue;
				}
				
				if(! chepaihao.equals( yundan.getChepaihao() )){
					dongshizhangjiesuanshenhelist.remove(i);
					--i;
				}
				
			}
		}
		
		request.setAttribute("dongshizhangjiesuanshenhelist", dongshizhangjiesuanshenhelist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  json
	 */
	public void dongShiZhangJieSuanShenHeJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		if(dongshizhangjiesuanshenhelist == null || dongshizhangjiesuanshenhelist.size()<1){
			return ;
		}
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getMethodNameList(dongshizhangjiesuanshenhelist, "dongShiZhangJieSuanShenHeXiangXi",  yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 *  jump update
	 */
	public String jumpUpdateDongShiZhangJieSuanShenHe(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
        CheLiangController.sendCheLiang(cheLiangService);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 || id.length>1){
			request.setAttribute("yingshoukuanerr", "请选择单个进行审核");
			return "err";
		}

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf(id[0]) );
		if(!"未审核".equals( singleyingshoukuan.getDongshizhangjiesuanshenhe() )){
			request.setAttribute("yingshoukuanerr", "请选择未审核");
			return "err";
		}
		
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(singleyingshoukuan.getDingdanhao());
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
	/**
	 *  update
	 */
	public String updateDongShiZhangJieSuanShenHe(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
        
        String flag = request.getParameter("flag");
        String id = request.getParameter("id");
		
        Users loginUser = (Users) session.getAttribute("users");
        String caozuoyuan = loginUser.getUsername();
        
        	
        YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id ) );
        
        if("审核通过".equals(flag)){
        
        	yingshoukuan.setDongshizhangjiesuanshenhe("审核通过");
        	yingshoukuan.setDongshizhangjiesuanshenheren(caozuoyuan);
        	yingshoukuan.setLingkuanshijian(new Date());
        	
        }else if("未通过".equals(flag)){
        	yingshoukuan.setZongjinglijiesuanshenhe("未审核");
        	yingshoukuan.setJiesuanshenqing("未通过");
        }
        
        yingShouKuanService.updateYingShouKuan(yingshoukuan);
        
		dongshizhangjiesuanshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglijiesuanshenhe", "审核通过");
        request.setAttribute("dongshizhangjiesuanshenhelist", dongshizhangjiesuanshenhelist);
		
        CheLiangController.sendCheLiang(cheLiangService);
        
		return "success";
	}
	
	/**
	 * 结算审核董事长 全部通过
	 */
	public String jieSuanShenHeDongShiZhangYesAll(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
        CheLiangController.sendCheLiang(cheLiangService);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 ){
			request.setAttribute("yingshoukuanerr", "请选择进行审核");
			return "success";
		}

			
		
		Users loginUser = (Users) session.getAttribute("users");
        String caozuoyuan = loginUser.getUsername();
	    
        for (int i = 0; i < id.length; i++) {
        	YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id[i] ) );
             
         	yingshoukuan.setDongshizhangjiesuanshenhe("审核通过");
         	yingshoukuan.setDongshizhangjiesuanshenheren(caozuoyuan);
         	yingshoukuan.setLingkuanshijian(new Date());
         	
         	yingShouKuanService.updateYingShouKuan(yingshoukuan);
		}
        
		dongshizhangjiesuanshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglijiesuanshenhe", "审核通过");
        request.setAttribute("dongshizhangjiesuanshenhelist", dongshizhangjiesuanshenhelist);
		
		return "success";
	}
	
	/**
	 * 结算审核董事长 全部未通过
	 */
	public String jieSuanShenHeDongShiZhangNoAll(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
        CheLiangController.sendCheLiang(cheLiangService);
		
		String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 ){
			request.setAttribute("yingshoukuanerr", "请选择进行审核");
			return "success";
		}

			
		
		Users loginUser = (Users) session.getAttribute("users");
        String caozuoyuan = loginUser.getUsername();
	    
        for (int i = 0; i < id.length; i++) {
        	YingShouKuan yingshoukuan = yingShouKuanService.queryYingShouKuanId( Integer.valueOf( id[i] ) );
             
        	yingshoukuan.setDongshizhangjiesuanshenhe("未审核");
        	yingshoukuan.setZongjinglijiesuanshenhe("未审核");
        	yingshoukuan.setJiesuanshenqing("未通过");
         	
         	yingShouKuanService.updateYingShouKuan(yingshoukuan);
		}
        
		dongshizhangjiesuanshenhelist  =  yingShouKuanService.queryYingShouKuanByConditionList("zongjinglijiesuanshenhe", "审核通过");
        request.setAttribute("dongshizhangjiesuanshenhelist", dongshizhangjiesuanshenhelist);
		
		return "success";
	}
	
	/**
	 * detail
	 */
	public String dongShiZhangJieSuanShenHeXiangXi(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		
		return "success";
	}
	
	
//	----------------------
//	结算
//	----------------------
	
	/**
	 * jump
	 */
	public String jumpYingShouKuanJieSuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);		

		
		
		 jiesuanlist   =  yingShouKuanService.queryYingShouKuanByConditionList("dongshizhangjiesuanshenhe", "审核通过");
		request.setAttribute("jiesuanlist", jiesuanlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  vague Search
	 */
	public String vagueSearchYingShouKuanJieSuan(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println(" 模糊查询 ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

		

		jiesuanlist = yingShouKuanService.vagueSearchYingShouKuanCondition(dingdanhao,yingshoukuanzhuangtai,jiesuanzhuangtai , kehudanwei , "dongshizhangjiesuanshenhe" , "审核通过");
		request.setAttribute("jiesuanlist", jiesuanlist);
		
		session.setAttribute("yingshoukuanchepaihao", chepaihao);
		
		session.setAttribute("yingshoukuanhuowumingcheng", huowumingcheng);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 * json
	 */
	public void yingShouKuanJieSuanJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(jiesuanlist == null || jiesuanlist.size()<1){
			return ;
		}
		
		List<YingShouKuanModel> yingshoukuanmodellist = YingShouKuanModel.getYingShouKuanModeMethodlList(jiesuanlist, "yingShouKuanJieSuanXiangXi",  yunDanService);
		
		JSONArray ja = JSONArray.fromObject(yingshoukuanmodellist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 * detail
	 */
	public String yingShouKuanJieSuanXiangXi(){
//		设置字符格式
		FontFormat.setFontFormat(response);		

			
		
		
//		查询指定订单号的营收款
		YingShouKuan singleyingshoukuan = yingShouKuanService.queryYingShouKuanDingDanHao(dingdanhao);
//		查询指定订单号的运单
		YunDan singleyundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
		
		CheLiang singlecheliang = null;
		
//		得到车牌号
		if(singleyundan != null){
			String chepaihao = singleyundan.getChepaihao();
			 singlecheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		}
		
//		传递参数
		request.setAttribute("singleyingshoukuan",singleyingshoukuan);
		request.setAttribute("singleyundan", singleyundan);
		request.setAttribute("singlecheliang", singlecheliang);
		
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

	public String getHuowumingcheng() {
		return huowumingcheng;
	}

	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}

	public String getDaikongtong() {
		return daikongtong;
	}

	public void setDaikongtong(String daikongtong) {
		this.daikongtong = daikongtong;
	}

	public String getYingshou() {
		return yingshou;
	}

	public void setYingshou(String yingshou) {
		this.yingshou = yingshou;
	}

	public Date getDaozhangshijian() {
		return daozhangshijian;
	}

	public void setDaozhangshijian(Date daozhangshijian) {
		this.daozhangshijian = daozhangshijian;
	}

	public String getFapiaohao() {
		return fapiaohao;
	}

	public void setFapiaohao(String fapiaohao) {
		this.fapiaohao = fapiaohao;
	}

	public Date getKaipiaoshijian() {
		return kaipiaoshijian;
	}

	public void setKaipiaoshijian(Date kaipiaoshijian) {
		this.kaipiaoshijian = kaipiaoshijian;
	}

	public String getShuijin() {
		return shuijin;
	}

	public void setShuijin(String shuijin) {
		this.shuijin = shuijin;
	}

	public String getGuanlifei() {
		return guanlifei;
	}

	public void setGuanlifei(String guanlifei) {
		this.guanlifei = guanlifei;
	}

	public String getShifuyunfei() {
		return shifuyunfei;
	}

	public void setShifuyunfei(String shifuyunfei) {
		this.shifuyunfei = shifuyunfei;
	}

	public Date getLingkuanshijian() {
		return lingkuanshijian;
	}

	public void setLingkuanshijian(Date lingkuanshijian) {
		this.lingkuanshijian = lingkuanshijian;
	}

	public String getQianshou() {
		return qianshou;
	}

	public void setQianshou(String qianshou) {
		this.qianshou = qianshou;
	}

	public String getYingshoukuanzhuangtai() {
		return yingshoukuanzhuangtai;
	}

	public void setYingshoukuanzhuangtai(String yingshoukuanzhuangtai) {
		this.yingshoukuanzhuangtai = yingshoukuanzhuangtai;
	}

	public File getMyexcel() {
		return myexcel;
	}

	public void setMyexcel(File myexcel) {
		this.myexcel = myexcel;
	}

	public String getMyexcelFileName() {
		return myexcelFileName;
	}

	public void setMyexcelFileName(String myexcelFileName) {
		this.myexcelFileName = myexcelFileName;
	}

	public String getJiesuanzhuangtai() {
		return jiesuanzhuangtai;
	}

	public void setJiesuanzhuangtai(String jiesuanzhuangtai) {
		this.jiesuanzhuangtai = jiesuanzhuangtai;
	}

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}



	public String getKaipiaoshenqing() {
		return kaipiaoshenqing;
	}



	public void setKaipiaoshenqing(String kaipiaoshenqing) {
		this.kaipiaoshenqing = kaipiaoshenqing;
	}



	public String getJiesuanshenqing() {
		return jiesuanshenqing;
	}



	public void setJiesuanshenqing(String jiesuanshenqing) {
		this.jiesuanshenqing = jiesuanshenqing;
	}



	public String getFenguankaipiaoshenhe() {
		return fenguankaipiaoshenhe;
	}



	public void setFenguankaipiaoshenhe(String fenguankaipiaoshenhe) {
		this.fenguankaipiaoshenhe = fenguankaipiaoshenhe;
	}



	public String getZongjinglijiesuanshenhe() {
		return zongjinglijiesuanshenhe;
	}



	public void setZongjinglijiesuanshenhe(String zongjinglijiesuanshenhe) {
		this.zongjinglijiesuanshenhe = zongjinglijiesuanshenhe;
	}



	public String getZongjinglikaipiaoshenhe() {
		return zongjinglikaipiaoshenhe;
	}



	public void setZongjinglikaipiaoshenhe(String zongjinglikaipiaoshenhe) {
		this.zongjinglikaipiaoshenhe = zongjinglikaipiaoshenhe;
	}



	public String getDongshizhangjiesuanshenhe() {
		return dongshizhangjiesuanshenhe;
	}



	public void setDongshizhangjiesuanshenhe(String dongshizhangjiesuanshenhe) {
		this.dongshizhangjiesuanshenhe = dongshizhangjiesuanshenhe;
	}



	public File getSonexcel() {
		return sonexcel;
	}



	public void setSonexcel(File sonexcel) {
		this.sonexcel = sonexcel;
	}



	public String getSonexcelFileName() {
		return sonexcelFileName;
	}



	public void setSonexcelFileName(String sonexcelFileName) {
		this.sonexcelFileName = sonexcelFileName;
	}



	public String getZhenshichezhu() {
		return zhenshichezhu;
	}



	public void setZhenshichezhu(String zhenshichezhu) {
		this.zhenshichezhu = zhenshichezhu;
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



	public CustomerService getCustomerService() {
		return customerService;
	}



	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}



	public KaiPiaoService getKaiPiaoService() {
		return kaiPiaoService;
	}



	public void setKaiPiaoService(KaiPiaoService kaiPiaoService) {
		this.kaiPiaoService = kaiPiaoService;
	}



	public FeiYongShouQuService getFeiYongShouQuService() {
		return feiYongShouQuService;
	}



	public void setFeiYongShouQuService(FeiYongShouQuService feiYongShouQuService) {
		this.feiYongShouQuService = feiYongShouQuService;
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



	public BaoXianService getBaoXianService() {
		return baoXianService;
	}



	public void setBaoXianService(BaoXianService baoXianService) {
		this.baoXianService = baoXianService;
	}
	
	
	
}
