package com.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.BaoXian;
import com.entity.CheLiang;
import com.entity.Users;
import com.model.BaoXianParaModel;
import com.model.BaoXianSearchModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaoXianService;
import com.service.CheLiangGuanLiService;
import com.service.CheLiangService;
import com.service.FeiYongShouQuService;
import com.service.YingShouKuanService;
import com.service.YunDanService;

import net.sf.json.JSONArray;

/**
 * 	保险控制层
 */
public class BaoXianController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public BaoXianController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();
 
	
	private BaoXianService baoXianService;
	
	private CheLiangService cheLiangService;
	
	private CheLiangGuanLiService cheLiangGuanLiService;
		
	
	private FeiYongShouQuService feiYongShouQuService ;
	
	private YingShouKuanService yingShouKuanService ;
	
	private YunDanService yunDanService ; 
	
	
	
//	集合对象
	private static List<BaoXian> baoxianlist;
//	单一
	private  BaoXian singlebaoxianchuli;
//	单一
	private  BaoXian singlebaoxian;
	
	/**
	 * 属性
	 */
	private String chepaihao; 	//车牌号
	private String baodanhao;	//保单号
	private Date   chaxunxiaoyudaoqiriqi;	//查询小于到期日期
	private Date   chaxundayudaoqiriqi; 	//查询大于到期日期
	private String baoxianzhuangtai;		//保险状态

	private String baoxianleixing ; //保险类型
	private String baoxiangongsi ; //保险公司
	private Date   banliriqi ; //办理日期
	private Date   daoqiriqi ; //到期日期
	private String baoxianzhonglei; //保险种类
	private String toubaojine ; //投保金额
	private String lianxiren ; //联系人
	private String lianxidianhua;//联系电话
	private String baoxiandailigongsi; //保险代理公司
	private String baofei ; //保费
	
	/**
	 *  跳转-保险
	 */
	public String jumpBaoXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end

//		设置字符格式
		FontFormat.setFontFormat(response);		
//		得到保险 业务对象
						
		
		baoxianlist = baoXianService.queryBaoxianList();
		request.setAttribute("baoxianlist", baoxianlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	
	/**
	 *  模糊查询保险
	 */
	public String vagueSearchBaoXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("模糊查询保险");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到保险业务对象
		
		
		baoxianlist = baoXianService.vagueSearchBaoXian(chepaihao, baodanhao, chaxunxiaoyudaoqiriqi, chaxundayudaoqiriqi,baoxianleixing);
		request.setAttribute("baoxianlist", baoxianlist);
		session.setAttribute("baoxianzhuangtai", baoxianzhuangtai);
		
		request.setAttribute("baoxianparamodel", new BaoXianParaModel(chepaihao, baodanhao, chaxunxiaoyudaoqiriqi, chaxundayudaoqiriqi));
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success" ;
	}
	
	/**
	 * 升序
	 */
	public String baoXianShengXu(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到保险业务对象
		
		
		baoxianlist = baoXianService.baoXianShengXu(chepaihao, baodanhao, chaxunxiaoyudaoqiriqi, chaxundayudaoqiriqi,baoxianleixing);
		request.setAttribute("baoxianlist", baoxianlist);
		session.setAttribute("baoxianzhuangtai", baoxianzhuangtai);
		
		request.setAttribute("baoxianparamodel", new BaoXianParaModel(chepaihao, baodanhao, chaxunxiaoyudaoqiriqi, chaxundayudaoqiriqi));
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success" ;
	}
	
	/**
	 *  保险json
	 */
	public void baoxianJson(){
		System.out.println("保险 json");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		
		
		
		
//		得到保险集合
		if(baoxianlist==null || baoxianlist.size()<1){
			return ;
		}
		List<BaoXianSearchModel> baoxianjsonlist = new ArrayList<BaoXianSearchModel>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < baoxianlist.size(); i++) {
			BaoXian baoxian = baoxianlist.get(i);
			CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(baoxian.getChepaihao());
			BaoXianSearchModel bxsm = new BaoXianSearchModel();
			
			 Integer id	= baoxian.getId();
			 String chepaihao = baoxian.getChepaihao();
			 
			 String path =request.getContextPath()+"/"+"baoXianXiangXi?id="+id;
			 String baodanhao ="<a href=\""+path+"\">"+baoxian.getBaodanhao()+"</a>";
			 
			 String chezhuxingming = "";
			 String chexing = "";
			 String leixing = "";
			 String toubaojine = "";
			 
			 if(cheliang != null){
				  chezhuxingming = cheliang.getChezhuxingming();
				  
				  if(cheliang.getChexing() != null && !"".equals(cheliang.getChexing())){
					  chexing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliang.getChexing())).getName(); 
				  }
				  
				  leixing = baoxian.getBaoxianleixing();
				  toubaojine = baoxian.getToubaojine();
				  /*if(toubaojine != null ){
					  toubaojine = toubaojine.replaceAll(",", "");
				  }*/
			 }
			
			 
			 String daoqiriqi = "";
			 Date mydaoqiriqi = baoxian.getDaoqiriqi();
			 if(mydaoqiriqi!=null){
				 daoqiriqi=sdf.format(mydaoqiriqi);
			 }
			 
			 String baoxianzhuangtai ="";
			 
			 Date date = baoxian.getDaoqiriqi();
			 if(date!=null){
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
					 baoxianzhuangtai="预警";
					 daoqiriqi = "<span style=\" color:black \">" + daoqiriqi + "</span>";
				 }else if(addDate7.after(date) && date.after(currentdate)){
					 baoxianzhuangtai="报警";
					 daoqiriqi = "<span style=\" color:brown \">" + daoqiriqi + "</span>";
				 }else if(currentdate.after(date)){
					 daoqiriqi = "<span style=\" color: red \">" + daoqiriqi + "</span>";
					 baoxianzhuangtai="过期";
				 }else{
					 baoxianzhuangtai="正常";
				 }
			 }
			
			 String baoxiangongsi  = baoxian.getBaoxiangongsi();
			
			 String baoxianjine = baoxian.getBaoxianzhonglei();
			 
			 String banliriqi = "";
			 try {
				 banliriqi = sdf.format(baoxian.getBanliriqi());
			} catch (Exception e) {
			}
		
			 String dailigongsi = baoxian.getBaoxiandailigongsi();
			 
			 bxsm.BaoXianSearchValue(String.valueOf(id), chepaihao, baoxianzhuangtai, 
					 				baodanhao, chezhuxingming, chexing, leixing, toubaojine, 
					 				daoqiriqi,baoxiangongsi, baoxianjine , banliriqi ,  dailigongsi);
			 baoxianjsonlist.add(bxsm);
		}
		
		String baoxianzhuangtai = (String) session.getAttribute("baoxianzhuangtai");
		if(baoxianzhuangtai==null || "".equals(baoxianzhuangtai)){
		}else{
			for (int i = 0; i <baoxianjsonlist.size(); i++) {
				BaoXianSearchModel bxsm = baoxianjsonlist.get(i);
				String value = bxsm.getBaoxianzhuangtai() ;
				if(!value.equals(baoxianzhuangtai)){
					baoxianjsonlist.remove(bxsm);
					--i;
				}
			}
		}
		
		JSONArray ja = JSONArray.fromObject(baoxianjsonlist);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}

	}
	
	/**
	 *  return 门户-保险json
	 */
	public List<BaoXianSearchModel> returnMenHubaoxianJson(List<BaoXian> baoxianlist){
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		
		
		
		
//		得到保险集合
		if(baoxianlist==null || baoxianlist.size()<1){
			return null;
		}
		List<BaoXianSearchModel> baoxianjsonlist = new ArrayList<BaoXianSearchModel>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < baoxianlist.size(); i++) {
			BaoXian baoxian = baoxianlist.get(i);
			CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(baoxian.getChepaihao());
			BaoXianSearchModel bxsm = new BaoXianSearchModel();
			
			 Integer id	= baoxian.getId();
			 String chepaihao = baoxian.getChepaihao();
			 
			 String path =request.getContextPath()+"/jumpBaoXian" ;
			 String baodanhao ="<a href=\""+path+"\">"+baoxian.getBaodanhao()+"</a>";
			 
			 String chezhuxingming = "";
			 String chexing = "";
			 String leixing = "";
			 String toubaojine = "";
			 
			 if(cheliang != null){
				  chezhuxingming = cheliang.getChezhuxingming();
				  
				  if(cheliang.getChexing() != null && !"".equals(cheliang.getChexing())){
					  chexing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliang.getChexing())).getName(); 
				  }
				  
				  leixing = baoxian.getBaoxianleixing();
				  toubaojine = baoxian.getToubaojine();
				  /*if(toubaojine != null ){
					  toubaojine = toubaojine.replaceAll(",", "");
				  }*/
			 }
			
			 
			 String daoqiriqi = "";
			 Date mydaoqiriqi = baoxian.getDaoqiriqi();
			 if(mydaoqiriqi!=null){
				 daoqiriqi=sdf.format(mydaoqiriqi);
			 }
			 
			 String baoxianzhuangtai ="";
			 
			 Date date = baoxian.getDaoqiriqi();
			 if(date!=null){
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
					 baoxianzhuangtai="预警";
//					 daoqiriqi = "<span style=\" color:black \">" + daoqiriqi + "</span>";
				 }else if(addDate7.after(date) && date.after(currentdate)){
					 baoxianzhuangtai="报警";
//					 daoqiriqi = "<span style=\" color:brown \">" + daoqiriqi + "</span>";
				 }else if(currentdate.after(date)){
					 baoxianzhuangtai="过期";
//					 daoqiriqi = "<span style=\" color: red \">" + daoqiriqi + "</span>";
				 }else{
					 baoxianzhuangtai="正常";
				 }
			 }
			
			 String baoxiangongsi  = baoxian.getBaoxiangongsi();
			
			 String baoxianjine = baoxian.getBaoxianzhonglei();
			 
			 String banliriqi = "";
			 try {
				 banliriqi = sdf.format(baoxian.getBanliriqi());
			} catch (Exception e) {
			}
		
			 String dailigongsi = baoxian.getBaoxiandailigongsi();
			 
			 bxsm.BaoXianSearchValue(String.valueOf(id), chepaihao, baoxianzhuangtai, 
					 				baodanhao, chezhuxingming, chexing, leixing, toubaojine, 
					 				daoqiriqi,baoxiangongsi, baoxianjine , banliriqi ,  dailigongsi);
			 baoxianjsonlist.add(bxsm);
		}
		
		for (int i = 0; i <baoxianjsonlist.size(); i++) {
			BaoXianSearchModel bxsm = baoxianjsonlist.get(i);
			String value = bxsm.getBaoxianzhuangtai() ;
			if("正常".equals(value)){
				baoxianjsonlist.remove(bxsm);
				--i;
			}
		}
		
		if(baoxianjsonlist.size()>5){
			for (int i = 5; i <baoxianjsonlist.size(); i++) {
				baoxianjsonlist.remove(i);
				--i;
			}
		}

		return baoxianjsonlist;
	}
	
	/**
	 *  保险详细
	 */
	public String baoXianXiangXi(){
		System.out.println("保险详细");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		String id = request.getParameter("id");
  		BaoXian singlebaoxian = baoXianService.getSingleBaoXian(Integer.valueOf(id));
		
		request.setAttribute("singlebaoxian", singlebaoxian);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  删除保险
	 */
	public String deleteBaoXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		start-------判断是否登录用户
		Users loginUser = (Users) session.getAttribute("users");
		if(loginUser==null || "".equals(loginUser)){
			return "returnLogin";
		}
//		------------end
		
		System.out.println("删除保险");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到保险id数组
		String id[] = request.getParameterValues("toolbar1");		
		if(id==null || id.length<1){
			CheLiangController.sendCheLiang(cheLiangService);
			return "success";
		}		
//		得到保险 业务对象
		
//		车辆业务对象
		
		
//		通过循环语句删除对应id数据
		for (int i = 0; i < id.length; i++) {
			BaoXian baoxian = baoXianService.queryId(Integer.valueOf( id[i] ));
			
			CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(baoxian.getChepaihao());
			if(cheliang != null){
//				同步费用收取
				FeiYongShouQuController.SynchronizationFeiYongShouQu( cheliang.getChezhuxingming() , feiYongShouQuService
																		,  cheLiangService , yingShouKuanService
																		,  yunDanService ,  baoXianService
																		);
			}
			
//			删除指定id保险
			baoXianService.deleteBaoXianId(Integer.valueOf( id[i] ));
		}
		
		 baoxianlist = baoXianService.queryBaoxianList();
		request.setAttribute("baoxianlist", baoxianlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}

	
	/**
	 * 跳转-添加保险
	 */
	public String jumpAddBaoXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-添加保险");
//		设置字符格式
		FontFormat.setFontFormat(response);	
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  添加保险
	 */
	public String addBaoXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("添加保险");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到保险 业务对象
				
		
		BaoXian baoxian = new BaoXian(chepaihao, baoxianleixing, baoxiangongsi, 
										banliriqi, daoqiriqi, baodanhao, baoxianzhonglei, 
										toubaojine, lianxiren, lianxidianhua, baoxiandailigongsi, baofei);
		baoXianService.addBaoXian(baoxian);

//		车辆业务对象
		
		CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		if(cheliang != null){
//			同步费用收取
			FeiYongShouQuController.SynchronizationFeiYongShouQu( cheliang.getChezhuxingming() , feiYongShouQuService
																,  cheLiangService , yingShouKuanService
																,  yunDanService ,  baoXianService
																);
		}
		
		baoxianlist = baoXianService.queryBaoxianList();
		request.setAttribute("baoxianlist", baoxianlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  修改保险到期处理
	 */
	public String updateBaoXianChuLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
//		start-------判断是否登录用户
		Users loginUser = (Users) session.getAttribute("users");
		if(loginUser==null || "".equals(loginUser)){
			return "returnLogin";
		}
//		------------end
		
		System.out.println("修改保险到期处理");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到保险id
		String id[] = request.getParameterValues("toolbar1");		
		if(id==null || id.length>1){
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}			
//		得到保险 业务对象
					
		
		singlebaoxianchuli = baoXianService.getSingleBaoXian(Integer.valueOf(id[0]));
		
		session.setAttribute("singlebaoxianchuli", singlebaoxianchuli);
		request.setAttribute("singlebaoxianchuli", singlebaoxianchuli);
		
		return "success";
	}
	
	/**
	 *  提交修改保险到期处理
	 */
	public String submitUpdateBaoXianChuLi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("提交修改保险到期处理");
//		设置字符格式
		FontFormat.setFontFormat(response);				
//		得到保险 业务对象
					
		singlebaoxianchuli = (BaoXian) session.getAttribute("singlebaoxianchuli");
		
		BaoXian baoxian = singlebaoxianchuli ;
		baoxian.setBaodanhao(baodanhao);
		baoxian.setBanliriqi(banliriqi);
		baoxian.setDaoqiriqi(daoqiriqi);
		baoxian.setBaoxiangongsi(baoxiangongsi);
		baoxian.setBaoxianzhonglei(baoxianzhonglei);
		baoxian.setToubaojine(toubaojine);
		baoxian.setLianxiren(lianxiren);
		baoxian.setLianxidianhua(lianxidianhua);
		
		baoXianService.updateBaoXian(baoxian);
		
		baoxianlist = baoXianService.queryBaoxianList();
		request.setAttribute("baoxianlist", baoxianlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		session.removeAttribute("singlebaoxianchuli");
		
		return "success";
	}
	
	/**
	 *  修改保险
	 */
	public String updateBaoXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("修改保险");
//		设置字符格式
		FontFormat.setFontFormat(response);			
//		得到保险id
		String id[] = request.getParameterValues("toolbar1");		
		if(id==null || id.length>1 || id.length<1){
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}				
//		得到保险 业务对象
			
		
		 singlebaoxian = baoXianService.getSingleBaoXian(Integer.valueOf(id[0]));
		 
		 session.setAttribute("singlebaoxian", singlebaoxian);
		request.setAttribute("singlebaoxian", singlebaoxian);
		
		return "success";		
	}

	/**
	 *  提交修改保险
	 */
	public String submitUpdateBaoXian(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("提交修改保险");
//		设置字符格式
		FontFormat.setFontFormat(response);					
//		得到保险 业务对象
		singlebaoxian = (BaoXian) session.getAttribute("singlebaoxian");
		
		BaoXian baoxian = singlebaoxian;
		
		baoxian.setBaoXianValue(chepaihao, baoxianleixing, baoxiangongsi,
								banliriqi, daoqiriqi, baodanhao, baoxianzhonglei, 
								toubaojine, lianxiren, lianxidianhua, baoxiandailigongsi, baofei);
		
		baoXianService.updateBaoXian(baoxian);
		
//		车辆业务对象
		
		CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		if(cheliang != null){
//			同步费用收取
			FeiYongShouQuController.SynchronizationFeiYongShouQu( cheliang.getChezhuxingming() , feiYongShouQuService
																,  cheLiangService , yingShouKuanService
																,  yunDanService ,  baoXianService
																);
		}
		
		baoxianlist = baoXianService.queryBaoxianList();
		request.setAttribute("baoxianlist", baoxianlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		session.removeAttribute("singlebaoxian");
		
		return "success";
	}
	
	
	public void exportBaoXian(){
//		设置字符格式
		FontFormat.setFontFormat(response);
		
		
		
		
		
//		得到保险集合
		if(baoxianlist==null || baoxianlist.size()<1){
			return ;
		}
		List<BaoXianSearchModel> baoxianjsonlist = new ArrayList<BaoXianSearchModel>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < baoxianlist.size(); i++) {
			BaoXian baoxian = baoxianlist.get(i);
			CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(baoxian.getChepaihao());
			BaoXianSearchModel bxsm = new BaoXianSearchModel();
			
			 Integer id	= baoxian.getId();
			 String chepaihao = baoxian.getChepaihao();
			 
			 String baodanhao =baoxian.getBaodanhao();
			 
			 String chezhuxingming = "";
			 String chexing = "";
			 String leixing = "";
			 String toubaojine = "";
			 
			 if(cheliang != null){
				  chezhuxingming = cheliang.getChezhuxingming();
				  
				  if(cheliang.getChexing() != null && !"".equals(cheliang.getChexing())){
					  chexing = cheLiangGuanLiService.queryCheLiangGuanLiId(Integer.valueOf(cheliang.getChexing())).getName(); 
				  }
				  
				  leixing = baoxian.getBaoxianleixing();
				  toubaojine = baoxian.getToubaojine();
				  /*if(toubaojine != null ){
					  toubaojine = toubaojine.replaceAll(",", "");
				  }*/
			 }
			
			 
			 String daoqiriqi = "";
			 Date mydaoqiriqi = baoxian.getDaoqiriqi();
			 if(mydaoqiriqi!=null){
				 daoqiriqi=sdf.format(mydaoqiriqi);
			 }
			 
			 String baoxianzhuangtai ="";
			 
			 Date date = baoxian.getDaoqiriqi();
			 if(date!=null){
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
					 baoxianzhuangtai="预警";
				 }else if(addDate7.after(date) && date.after(currentdate)){
					 baoxianzhuangtai="报警";
				 }else if(currentdate.after(date)){
					 baoxianzhuangtai="过期";
				 }else{
					 baoxianzhuangtai="正常";
				 }
			 }
			
			 String baoxiangongsi  = baoxian.getBaoxiangongsi();
			
			 String baoxianjine = baoxian.getBaoxianzhonglei();
			 String banliriqi = "";
			 if(baoxian.getBanliriqi() != null){
				 banliriqi = sdf.format(baoxian.getBanliriqi());
			 }
			 String dailigongsi = baoxian.getBaoxiandailigongsi();
			 
			 bxsm.BaoXianSearchValue(String.valueOf(id), chepaihao, baoxianzhuangtai, 
					 				baodanhao, chezhuxingming, chexing, leixing, toubaojine, 
					 				daoqiriqi,baoxiangongsi, baoxianjine , banliriqi ,  dailigongsi);
			 baoxianjsonlist.add(bxsm);
		}
		
		String baoxianzhuangtai = (String) session.getAttribute("baoxianzhuangtai");
		if(baoxianzhuangtai==null || "".equals(baoxianzhuangtai)){
		}else{
			for (int i = 0; i <baoxianjsonlist.size(); i++) {
				BaoXianSearchModel bxsm = baoxianjsonlist.get(i);
				String value = bxsm.getBaoxianzhuangtai() ;
				if(!value.equals(baoxianzhuangtai)){
					baoxianjsonlist.remove(bxsm);
					--i;
				}
			}
		}
		
		JSONArray ja = JSONArray.fromObject(baoxianjsonlist);
		
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
	public String getChepaihao() {
		return chepaihao;
	}

	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}

	public String getBaodanhao() {
		return baodanhao;
	}

	public void setBaodanhao(String baodanhao) {
		this.baodanhao = baodanhao;
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

	public String getBaoxianzhuangtai() {
		return baoxianzhuangtai;
	}

	public void setBaoxianzhuangtai(String baoxianzhuangtai) {
		this.baoxianzhuangtai = baoxianzhuangtai;
	}

	public String getBaoxianleixing() {
		return baoxianleixing;
	}

	public void setBaoxianleixing(String baoxianleixing) {
		this.baoxianleixing = baoxianleixing;
	}

	public String getBaoxiangongsi() {
		return baoxiangongsi;
	}

	public void setBaoxiangongsi(String baoxiangongsi) {
		this.baoxiangongsi = baoxiangongsi;
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

	public String getBaoxianzhonglei() {
		return baoxianzhonglei;
	}

	public void setBaoxianzhonglei(String baoxianzhonglei) {
		this.baoxianzhonglei = baoxianzhonglei;
	}

	public String getToubaojine() {
		return toubaojine;
	}

	public void setToubaojine(String toubaojine) {
		this.toubaojine = toubaojine;
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getLianxidianhua() {
		return lianxidianhua;
	}

	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}

	public String getBaoxiandailigongsi() {
		return baoxiandailigongsi;
	}

	public void setBaoxiandailigongsi(String baoxiandailigongsi) {
		this.baoxiandailigongsi = baoxiandailigongsi;
	}

	public String getBaofei() {
		return baofei;
	}

	public void setBaofei(String baofei) {
		this.baofei = baofei;
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


	public BaoXianService getBaoXianService() {
		return baoXianService;
	}


	public void setBaoXianService(BaoXianService baoXianService) {
		this.baoXianService = baoXianService;
	}


	public CheLiangService getCheLiangService() {
		return cheLiangService;
	}


	public void setCheLiangService(CheLiangService cheLiangService) {
		this.cheLiangService = cheLiangService;
	}


	public CheLiangGuanLiService getCheLiangGuanLiService() {
		return cheLiangGuanLiService;
	}


	public void setCheLiangGuanLiService(CheLiangGuanLiService cheLiangGuanLiService) {
		this.cheLiangGuanLiService = cheLiangGuanLiService;
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
