package com.action;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.struts2.ServletActionContext;

import com.entity.CheLiang;
import com.entity.FeiYongShouQu;
import com.entity.YingShouKuan;
import com.entity.YunDan;
import com.model.FeiYongShouQuModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianService;
import com.service.CheLiangService;
import com.service.FeiYongShouQuService;
import com.service.YingShouKuanService;
import com.service.YunDanService;

import net.sf.json.JSONArray;

/**
 * 费用收取 Controller
 */
public class FeiYongShouQuController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 构造方法
	 */
	public FeiYongShouQuController() {
		super();
	}

//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
	
	private FeiYongShouQuService feiYongShouQuService;
	
	
	
	/**
	 * property
	 */
	private String chelianghezuoren;	//车辆合作人
	private String gouchefei;	//购车费
	private String luntaifei;	//轮胎费
	private String weixiufei;	//维修费
	private String jiayoufei;	//加油费
	private String qitafeiyong;	//其他费用
	private String kaipiaoheji;	//开票合计
	private String bili;	//比例
	private String baoxianfei;	//保险费
	private String chezaihefuwufeiyong;	//车载和服务费用
	private String anquanxuexibaozhengjin;	//安全学习保证金
	private String guanlifeiyong;	//管理费用
	private String yujiaobaoxianfeiyong;	//预交保险费用
	private String jiashiyuanbaoxian;	//驾驶员保险
	private String heji;	//合计
	private String ziyouyewuheji;	//自有业务合计
	
	
//	单一
	private  FeiYongShouQu singlefeiyongshouqu;
	
//	集合
	private static List<FeiYongShouQu> feiyongshouqulist;
	
	
	/**
	 *  jump 
	 */
	public String jumpFeiYongShouQu(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		
		
		 feiyongshouqulist = feiYongShouQuService.queryList();
		request.setAttribute("feiyongshouqulist", feiyongshouqulist);
		
		return "success";
	}
	
	/**
	 *  json
	 */
	public void feiYongShouQuJson(){
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		判断是否为null
		if(feiyongshouqulist == null || feiyongshouqulist.size()<1){
			return ;
		}
		
		List<FeiYongShouQuModel>  modelList = FeiYongShouQuModel.getFeiYongShouQuModelList(feiyongshouqulist);
		
		JSONArray ja = JSONArray.fromObject(modelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 * vague Search
	 */
	public String vagueSearchFeiYongShouQu(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		
		
		 feiyongshouqulist = feiYongShouQuService.vagueSearchFeiYongShouQu(chelianghezuoren);
		
		
		return "success";
	}

	/**
	 *  jump update
	 */
	public String jumpUpdateFeiYongShouQu(){
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
			request.setAttribute("yingshoukuanerr", "请选择单个进行修改");
			return "err";
		}
		
		
		
		 singlefeiyongshouqu = feiYongShouQuService.queryId(Integer.valueOf( id[0] ));
		 
		 String kaipiaoheji = singlefeiyongshouqu.getKaipiaoheji();
		 String ziyouyewuheji = singlefeiyongshouqu.getZiyouyewuheji();
		 
		 Double zongkaipiaoheji = StringTfmDouble(kaipiaoheji) + StringTfmDouble(ziyouyewuheji);
		 
		 request.setAttribute( "zongkaipiaoheji" , formatDoubleTwo(zongkaipiaoheji) );
		 
		request.setAttribute("singlefeiyongshouqu", singlefeiyongshouqu);
		
		session.setAttribute("singlefeiyongshouqu", singlefeiyongshouqu);
		
		return "success";
	}
	
	/**
	 *  update
	 */
	public String updateFeiYongShouQu(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
        singlefeiyongshouqu = (FeiYongShouQu) session.getAttribute("singlefeiyongshouqu");
        
        
        singlefeiyongshouqu.setValueFeiYongShouQu( gouchefei,  luntaifei,  weixiufei,
    			 jiayoufei,  qitafeiyong,  kaipiaoheji,
    			 bili,  baoxianfei,  chezaihefuwufeiyong,
    			 anquanxuexibaozhengjin,  guanlifeiyong,
    			 yujiaobaoxianfeiyong,  jiashiyuanbaoxian,  heji);
        
        singlefeiyongshouqu.setZiyouyewuheji(ziyouyewuheji);
        
//		修改
        feiYongShouQuService.updateFeiYongShouQu( singlefeiyongshouqu );
        
//      query
        feiyongshouqulist = feiYongShouQuService.queryList();
		request.setAttribute("feiyongshouqulist", feiyongshouqulist);
        
		return "success";
	}
	
	/**
	 *  delete
	 */
	public String deleteFeiYongShouQu(){
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
        
        
        String id[] = request.getParameterValues("toolbar1");
		
		if(id == null || id.length<1 ){
			request.setAttribute("yingshoukuanerr", "请选择进行删除");
		
			feiyongshouqulist = feiYongShouQuService.queryList();
			request.setAttribute("feiyongshouqulist", feiyongshouqulist);
			
			return "success";
		}
		
		for (int i = 0; i < id.length; i++) {
			feiYongShouQuService.deleteId(id[i]);
		}
		
		feiyongshouqulist = feiYongShouQuService.queryList();
		request.setAttribute("feiyongshouqulist", feiyongshouqulist);
		
		return "success";
	}
	
	/**
	 *  同步费用收取
	 */
	public static void SynchronizationFeiYongShouQu( String chelianghezuoren ,FeiYongShouQuService feiYongShouQuService
													, CheLiangService cheLiangService ,YingShouKuanService yingShouKuanService
													, YunDanService yunDanService , BaoXianService baoXianService
													
													){
//		判断车辆合作人数据是否正常
		if(chelianghezuoren == null || "".equals(chelianghezuoren)){
			return ;
		}
		
//		得到请求对象 
		 HttpServletResponse response = ServletActionContext.getResponse();
//		加载applicationContext.xml文件
		 
		
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
//		创建费用收取业务对象
		
//		创建车辆业务对象
			
//		创建营收款业务对象
		
//		得到运单业务对象
		
//		得到保险 业务对象
		
				
//		查询指定车辆合作人的集合对象
		List<FeiYongShouQu> feiyongshouqulist = feiYongShouQuService.queryCheLiangHeZuoRen(chelianghezuoren);
		
//		创建费用收取对象
		FeiYongShouQu feiyongshouqu  = null ;
		
		if( feiyongshouqulist!=null && feiyongshouqulist.size()>0 ){
			feiyongshouqu = feiyongshouqulist.get(0);
		}else{
			feiyongshouqu = new FeiYongShouQu();
		}
		
//		初始化参数
		Double gouchefei = 0.0;	//购车费
		Double luntaifei = 0.0;	//轮胎费
		Double weixiufei = 0.0;	//维修费
		Double jiayoufei = 0.0;	//加油费
		Double qitafeiyong = 0.0;	//其他费用
		Double kaipiaoheji = 0.0;	//开票合计
		Double bili = 0.0;	//比例
		Double baoxianfei = 0.0;	//保险费
		Double chezaihefuwufeiyong = 0.0;	//车载和服务费用
		Double anquanxuexibaozhengjin = 0.0;	//安全学习保证金
		Double guanlifeiyong = 0.0;	//管理费用
		Double yujiaobaoxianfeiyong = 0.0;	//预交保险费用
		Double jiashiyuanbaoxian = 0.0;	//驾驶员保险
		Double heji = 0.0;	//合计
		
//		初始化赋值
		 luntaifei = StringTfmDouble( feiyongshouqu.getLuntaifei() );	//轮胎费
		 weixiufei = StringTfmDouble( feiyongshouqu.getWeixiufei() );	//维修费
		 jiayoufei = StringTfmDouble( feiyongshouqu.getJiayoufei() );	//加油费
		 qitafeiyong = StringTfmDouble( feiyongshouqu.getQitafeiyong() );	//其他费用
		 chezaihefuwufeiyong = StringTfmDouble( feiyongshouqu.getChezaihefuwufeiyong() );	//车载和服务费用
		 anquanxuexibaozhengjin = StringTfmDouble( feiyongshouqu.getAnquanxuexibaozhengjin() );	//安全学习保证金
		 guanlifeiyong = StringTfmDouble( feiyongshouqu.getGuanlifeiyong() );	//管理费用
		 yujiaobaoxianfeiyong = StringTfmDouble( feiyongshouqu.getYujiaobaoxianfeiyong() );	//预交保险费用
		 jiashiyuanbaoxian = StringTfmDouble( feiyongshouqu.getJiashiyuanbaoxian() );	//驾驶员保险
		
		
//		查询指定车辆合作人的车辆
		List<CheLiang> chelianglist = cheLiangService.queryCheZhuXingMing(chelianghezuoren);
//		判断是否为null
		if(chelianglist != null && chelianglist.size()>0){
			
//			循环车辆
			for (int i = 0; i < chelianglist.size(); i++) {
//				车辆对象
				CheLiang cheliang = chelianglist.get(i);
//				添加购车费
				gouchefei = gouchefei + StringTfmDouble( cheliang.getGouchefei() );
				
//				车牌号
				String chepaihao = cheliang.getChepaihao();
//				运单状态 = 运单完成
				String yundanzhuangtai  = "运单完成";
//				查询指定车牌号和运单状态
				List<YunDan> yundanlist = yunDanService.queryChePaiHaoAndYunDanZhuangTai(chepaihao, yundanzhuangtai);
//				判断是否为null
				if(yundanlist != null && yundanlist.size()>0){
//					循环运单
					for (int j = 0; j < yundanlist.size(); j++) {
//						运单对象
						YunDan yundan = yundanlist.get(j);
//						订单号
						String dingdanhao = yundan.getDingdanhao();
//						添加数组条件
						String Conditions[] = {"jiesuanzhuangtai" , "dingdanhao" };
						String values[] = {"已结算" , dingdanhao};
//						查询指定数组条件 的 营收款 
						List<YingShouKuan> yingshoukuanlist = yingShouKuanService.queryYingShouKuanByConditionArrList(Conditions, values);
						
						if(yingshoukuanlist != null && yingshoukuanlist.size()>0){
//							循环营收款
							for (int k = 0; k < yingshoukuanlist.size(); k++) {
//								得到营收款对象
								YingShouKuan yingshoukuan =  yingshoukuanlist.get(k);
//								判断是否已转账
								if("已转账".equals( yingshoukuan.getZhuanzhangzhuangtai() )){
									continue;
								}
//								赋值开票合计
								kaipiaoheji = kaipiaoheji + StringTfmDouble( yingshoukuan.getShifuyunfei() ) ;
							}
						}
						
					}
				}
				

//				添加保险费
				baoxianfei = baoxianfei + StringTfmDouble( baoXianService.sumTouBaoJinE(chepaihao) );
				
			}
			
		}
		
//		-----开始合计转账的数据----
//		添加数组条件
		String Conditions[] = {"jiesuanzhuangtai","zhenshichezhu"};
		String values[] = {"已结算" , chelianghezuoren};
//		查询指定数组条件 的 营收款 
		List<YingShouKuan> yingshoukuanlist = yingShouKuanService.queryYingShouKuanByConditionArrList(Conditions, values);
		
		if(yingshoukuanlist != null && yingshoukuanlist.size()>0){
//			循环营收款
			for (int k = 0; k < yingshoukuanlist.size(); k++) {
//				得到营收款对象
				YingShouKuan yingshoukuan =  yingshoukuanlist.get(k);
//				赋值开票合计
				kaipiaoheji = kaipiaoheji + StringTfmDouble( yingshoukuan.getShifuyunfei() ) ;
			}
		}

		
//		开票合计 / 0.875
		kaipiaoheji = kaipiaoheji / 0.875;
		
//		比例=（够车费+轮胎费+维修费+加油费+其他费用）/ 开票合计      "要求显示为百分比，如29.92%"
		bili = (gouchefei+luntaifei+weixiufei+jiayoufei+qitafeiyong) / kaipiaoheji ;
//		如果返回结果是NaN 就等于0
		if(bili.isNaN()){
			bili = 0.0;
		}
		
//		合计  = 保险费+车载和服务费用+安全学习保证金+管理费用+预交保险费用+驾驶员保险
		heji = baoxianfei + chezaihefuwufeiyong + anquanxuexibaozhengjin + guanlifeiyong + yujiaobaoxianfeiyong + jiashiyuanbaoxian ;
		
		
//		赋值-------------
		
		feiyongshouqu.setGouchefei( formatDoubleTwo( gouchefei ) ) ;	//购车费
		feiyongshouqu.setLuntaifei( formatDoubleTwo( luntaifei ) ) ;	//轮胎费
		feiyongshouqu.setWeixiufei( formatDoubleTwo( weixiufei ) ) ;	//维修费
		feiyongshouqu.setJiayoufei( formatDoubleTwo( jiayoufei ) ) ;	//加油费
		feiyongshouqu.setQitafeiyong( formatDoubleTwo( qitafeiyong ) ) ;	//其他费用
		feiyongshouqu.setKaipiaoheji( formatDoubleTwo( kaipiaoheji ) ) ;	//开票合计
		feiyongshouqu.setBili( formatDoubleTwo( bili ) ) ;	//比例
		feiyongshouqu.setBaoxianfei( formatDoubleTwo( baoxianfei ) ) ;	//保险费
		feiyongshouqu.setChezaihefuwufeiyong( formatDoubleTwo( chezaihefuwufeiyong ) ) ;	//车载和服务费用
		feiyongshouqu.setAnquanxuexibaozhengjin( formatDoubleTwo( anquanxuexibaozhengjin ) ) ;	//安全学习保证金
		feiyongshouqu.setGuanlifeiyong( formatDoubleTwo( guanlifeiyong ) ) ;	//管理费用
		feiyongshouqu.setYujiaobaoxianfeiyong( formatDoubleTwo( yujiaobaoxianfeiyong ) ) ;	//预交保险费用
		feiyongshouqu.setJiashiyuanbaoxian( formatDoubleTwo( jiashiyuanbaoxian ) ) ;	//驾驶员保险
		feiyongshouqu.setHeji( formatDoubleTwo( heji ) ) ;	//合计
		
		feiyongshouqu.setChelianghezuoren(chelianghezuoren); //车辆合作人
		
//		添加费用收取
		feiYongShouQuService.saveAndUpdate(feiyongshouqu);
	}
	
	/**
	 *  String转换Double
	 */
	public static Double StringTfmDouble(String str){
		//初始化值
		Double value = 0.0;
		
		if(str == null){
			return value;
		}
		
		try {
			value = Double.valueOf(str);
		} catch (Exception e) {
		}
		
		return value;
	}
	
	/**
	 *  format Double Two
	 */
	public static String formatDoubleTwo(double value){
		String str = "";
		
		DecimalFormat  df  = new DecimalFormat("######0.00"); 
		try {
			str = df.format(value);
		} catch (Exception e) {
		}
		
		return str;
	}
	
	/**
	 *  get set
	 */
	public String getChelianghezuoren() {
		return chelianghezuoren;
	}

	public void setChelianghezuoren(String chelianghezuoren) {
		this.chelianghezuoren = chelianghezuoren;
	}

	public String getGouchefei() {
		return gouchefei;
	}

	public void setGouchefei(String gouchefei) {
		this.gouchefei = gouchefei;
	}

	public String getLuntaifei() {
		return luntaifei;
	}

	public void setLuntaifei(String luntaifei) {
		this.luntaifei = luntaifei;
	}

	public String getWeixiufei() {
		return weixiufei;
	}

	public void setWeixiufei(String weixiufei) {
		this.weixiufei = weixiufei;
	}

	public String getJiayoufei() {
		return jiayoufei;
	}

	public void setJiayoufei(String jiayoufei) {
		this.jiayoufei = jiayoufei;
	}

	public String getQitafeiyong() {
		return qitafeiyong;
	}

	public void setQitafeiyong(String qitafeiyong) {
		this.qitafeiyong = qitafeiyong;
	}

	public String getKaipiaoheji() {
		return kaipiaoheji;
	}

	public void setKaipiaoheji(String kaipiaoheji) {
		this.kaipiaoheji = kaipiaoheji;
	}

	public String getBili() {
		return bili;
	}

	public void setBili(String bili) {
		this.bili = bili;
	}

	public String getBaoxianfei() {
		return baoxianfei;
	}

	public void setBaoxianfei(String baoxianfei) {
		this.baoxianfei = baoxianfei;
	}

	public String getChezaihefuwufeiyong() {
		return chezaihefuwufeiyong;
	}

	public void setChezaihefuwufeiyong(String chezaihefuwufeiyong) {
		this.chezaihefuwufeiyong = chezaihefuwufeiyong;
	}

	public String getAnquanxuexibaozhengjin() {
		return anquanxuexibaozhengjin;
	}

	public void setAnquanxuexibaozhengjin(String anquanxuexibaozhengjin) {
		this.anquanxuexibaozhengjin = anquanxuexibaozhengjin;
	}

	public String getGuanlifeiyong() {
		return guanlifeiyong;
	}

	public void setGuanlifeiyong(String guanlifeiyong) {
		this.guanlifeiyong = guanlifeiyong;
	}

	public String getYujiaobaoxianfeiyong() {
		return yujiaobaoxianfeiyong;
	}

	public void setYujiaobaoxianfeiyong(String yujiaobaoxianfeiyong) {
		this.yujiaobaoxianfeiyong = yujiaobaoxianfeiyong;
	}

	public String getJiashiyuanbaoxian() {
		return jiashiyuanbaoxian;
	}

	public void setJiashiyuanbaoxian(String jiashiyuanbaoxian) {
		this.jiashiyuanbaoxian = jiashiyuanbaoxian;
	}

	public String getHeji() {
		return heji;
	}

	public void setHeji(String heji) {
		this.heji = heji;
	}

	public static List<FeiYongShouQu> getFeiyongshouqulist() {
		return feiyongshouqulist;
	}

	public static void setFeiyongshouqulist(List<FeiYongShouQu> feiyongshouqulist) {
		FeiYongShouQuController.feiyongshouqulist = feiyongshouqulist;
	}

	public String getZiyouyewuheji() {
		return ziyouyewuheji;
	}

	public void setZiyouyewuheji(String ziyouyewuheji) {
		this.ziyouyewuheji = ziyouyewuheji;
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

	public FeiYongShouQuService getFeiYongShouQuService() {
		return feiYongShouQuService;
	}

	public void setFeiYongShouQuService(FeiYongShouQuService feiYongShouQuService) {
		this.feiYongShouQuService = feiYongShouQuService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
