package com.action;

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

import org.apache.struts2.ServletActionContext;

import com.entity.CheLiang;
import com.entity.NianShen;
import com.model.NianShenModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CheLiangService;
import com.service.NianShenService;
import com.service.UsersService;

import net.sf.json.JSONArray;

/**
 *  年审控制层
 */
public class NianShenController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public NianShenController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	private CheLiangService cheLiangService;
	
	private NianShenService nianShenService;
	
	private UsersService usersService;
	
//	集合对象
	private static List<NianShen> nianshenlist;
//	单一
	private static NianShen singlenianshen;
	
	/**
	 * 属性
	 */
	private String chepaihao; 	//车牌号
	private String nianshenzhuangtai;	//年审状态
	private Date   chaxunxiaoyudaoqiriqi;	//查询小于到期日期
	private Date   chaxundayudaoqiriqi;	//查询大于到期日期
	
	private Date  nianshenriqi;	//年审日期
	private Date  daoqiriqi;	//到期日期
	
	/**
	 *  跳转-年审
	 */
	public String jumpNianShen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-年审");

//		设置字符格式
		FontFormat.setFontFormat(response);
	
		
		
		 nianshenlist = nianShenService.queryNianShen();
		request.setAttribute("nianshenlist", nianshenlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}

	/**
	 *  模糊查询
	 */
	public String vagueSearchNianShen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("年审模糊查询");
		
//		设置字符格式
		FontFormat.setFontFormat(response);
	
		
		
		 nianshenlist = nianShenService.vagueSearchNianShen(chepaihao, chaxunxiaoyudaoqiriqi, chaxundayudaoqiriqi);
		request.setAttribute("nianshenlist", nianshenlist);
		session.setAttribute("nianshenzhuangtai", nianshenzhuangtai);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	/**
	 *  年审json
	 */
	public void nianShenJson(){
		System.out.println("年审json");
		
//		设置字符格式
		FontFormat.setFontFormat(response);
		
				
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
//		创建年审模版集合对象
		List<NianShenModel> nianShenModelList = new ArrayList<NianShenModel>();
//		创建用户业务对象
		
		
		
		for (int i = 0; i < nianshenlist.size(); i++) {
			NianShen nianshen = nianshenlist.get(i);
			
			Integer id = nianshen.getId();
			
			
			String path =request.getContextPath()+"/"+"nianShenXiangXi?id="+id;
			String  chepaihao = "<a href=\""+path+"\">"+nianshen.getChepaihao()+"</a>";
			
			String  nianshenzhuangtai= "";
			String chezhuxingming = nianshen.getChezhuxingming();
			String shoujihao = nianshen.getShoujihao();
			
			int value = 0;
			
			String dengjiriqi = "";	//等级日期 
			if(nianshen.getDengjidaoqiriqi() != null){
				 dengjiriqi = sdf.format( nianshen.getDengjidaoqiriqi() );
			 }
			
			CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(nianshen.getChepaihao());
			if(cheliang != null){
				try {
					cal.setTime( cheliang.getZhuceriqi() );
					cal.add(Calendar.YEAR, 5);
					
					//大于5年 ， 4个月一次  ， 并且把 二级维护的日期  给 等级评定
					if(new Date().after(cal.getTime())){
						nianshen.setDengjidaoqiriqi(nianshen.getErjidaoqiriqi());
						
						nianShenService.updateNianShen(nianshen);
						
						Map<String, String> dengjidaoqiriqiMap = panDuanDengJiRiQi(nianshen.getDengjidaoqiriqi(), 4);
						if(dengjidaoqiriqiMap!=null){
							String zhuangtai = dengjidaoqiriqiMap.get("nianshenzhuangtai");
							int index =  Integer.valueOf(dengjidaoqiriqiMap.get("value"));
							
							dengjiriqi = panduanZhuangTai(dengjiriqi, zhuangtai);
							if(index>value){
								value = index;
								nianshenzhuangtai = zhuangtai;
							}
						}
						
						
					//小于5年 ， 1年一次
					}else{
						Map<String, String> dengjidaoqiriqiMap = panDuanDengJiRiQi(nianshen.getDengjidaoqiriqi(), 12);
						if(dengjidaoqiriqiMap!=null){
							String zhuangtai = dengjidaoqiriqiMap.get("nianshenzhuangtai");
							int index =  Integer.valueOf(dengjidaoqiriqiMap.get("value"));
							
							dengjiriqi = panduanZhuangTai(dengjiriqi, zhuangtai);
							if(index>value){
								value = index;
								nianshenzhuangtai = zhuangtai;
							}
						}
					}
				} catch (Exception e) {
				}
			}
			
			
			String nianshenriqi = "";
			if(nianshen.getNianshenriqi() != null){
				nianshenriqi = sdf.format(nianshen.getNianshenriqi());
			}
			
			String daoqiriqi = "";
			if(nianshen.getDaoqiriqi() != null){
				daoqiriqi = sdf.format( nianshen.getDaoqiriqi() );
			}

			String caozuoyuan = "";
			try {
				caozuoyuan = usersService.queryId( Integer.valueOf(nianshen.getCaozuoyuan()) ).getUsername();
			} catch (Exception e) {
			}
			
			
			String caozuoriqi = "";
			if(nianshen.getCaozuoriqi() != null){
				caozuoriqi = sdf.format( nianshen.getCaozuoriqi() );
			}
			 
			 String daoluriqi = "";	//道路日期
			 String erjiriqi = "";	//二级日期
			 
			 
				 
			 if(nianshen.getDaoludaoqiriqi() != null){
				 daoluriqi = sdf.format( nianshen.getDaoludaoqiriqi() );
			 }
			 
			 if(nianshen.getErjidaoqiriqi() != null){
				 erjiriqi = sdf.format( nianshen.getErjidaoqiriqi() );
			 }
			 
				 
			 
			 String guantidaoqiriqi = "";
			if(  nianshen.getGuantidaoqiriqi() != null){
				guantidaoqiriqi = sdf.format( nianshen.getGuantidaoqiriqi() );
			}
			
			//-------------------------
			//判断日期是否过期 判断大小
			//-------------------------
			
			Map<String, String> daoqiriqiMap = panDuanRiQi(nianshen.getDaoqiriqi());
			if(daoqiriqiMap!=null){
				String zhuangtai = daoqiriqiMap.get("nianshenzhuangtai");
				int index =  Integer.valueOf(daoqiriqiMap.get("value"));
				
				daoqiriqi = panduanZhuangTai(daoqiriqi , zhuangtai);
				if(index>value){
					value = index;
					nianshenzhuangtai = zhuangtai;
				}
			}
			
			Map<String, String> daoludaoqiriqiMap = panDuanRiQi(nianshen.getDaoludaoqiriqi());
			if(daoludaoqiriqiMap!=null){
				String zhuangtai = daoludaoqiriqiMap.get("nianshenzhuangtai");
				int index =  Integer.valueOf(daoludaoqiriqiMap.get("value"));
				
				daoluriqi = panduanZhuangTai(daoluriqi , zhuangtai);
				if(index>value){
					value = index;
					nianshenzhuangtai = zhuangtai;
				}
			}
			
			Map<String, String> erjidaoqiriqiMap = panDuanRiQi(nianshen.getErjidaoqiriqi());
			if(erjidaoqiriqiMap!=null){
				String zhuangtai = erjidaoqiriqiMap.get("nianshenzhuangtai");
				int index =  Integer.valueOf(erjidaoqiriqiMap.get("value"));
				
				erjiriqi = panduanZhuangTai(erjiriqi, zhuangtai);
				if(index>value){
					value = index;
					nianshenzhuangtai = zhuangtai;
				}
			}
			
			
			Map<String, String> guantidaoqiriqiMap = panDuanRiQi(nianshen.getGuantidaoqiriqi());
			if(guantidaoqiriqiMap!=null){
				String zhuangtai = guantidaoqiriqiMap.get("nianshenzhuangtai");
				int index =  Integer.valueOf(guantidaoqiriqiMap.get("value"));
				
				guantidaoqiriqi = panduanZhuangTai(guantidaoqiriqi, zhuangtai);
				if(index>value){
					value = index;
					nianshenzhuangtai = zhuangtai;
				}
			}
			
			
			//-------------------------
			 
			 NianShenModel nianshenmodel = new NianShenModel();
			 nianshenmodel.setNianShenModel(id, chepaihao, nianshenzhuangtai, 
					 						chezhuxingming, shoujihao, nianshenriqi, 
					 						daoqiriqi, caozuoyuan, caozuoriqi,daoluriqi,  erjiriqi,  dengjiriqi);
			 
			 nianshenmodel.setGuantidaoqiriqi(guantidaoqiriqi);
			 
			 nianShenModelList.add(nianshenmodel);
		}
		
		String nianshenzhuangtai = (String) session.getAttribute("nianshenzhuangtai");
		if(nianshenzhuangtai==null || "".equals(nianshenzhuangtai)){
		}else{
			
			for (int i = 0; i < nianShenModelList.size() ; i++) {
				NianShenModel nianshenmodel = nianShenModelList.get(i);
				String value = nianshenmodel.getNianshenzhuangtai();
				if(! value.equals(nianshenzhuangtai)){
					nianShenModelList.remove(nianshenmodel);
					--i;
				}
			}
			
		}
		
		JSONArray ja = JSONArray.fromObject(nianShenModelList);
		
		try {
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
		}
		
	}
	
	public Map<String, String> panDuanRiQi(Date date){
		Calendar cal = Calendar.getInstance();
		Calendar cal7 = Calendar.getInstance();
		
		Map<String, String> map = null;
		
		if(date != null){
			Date currentdate = new Date();
			 
			 
			 cal.setTime(currentdate);
			 cal.add(Calendar.DATE, 30);
			 Date addDate30 = cal.getTime();
			 
			
			 cal7.setTime(currentdate);
			 cal7.add(Calendar.DATE, 7);
			 Date addDate7 = cal7.getTime();
			 
			 if( ( addDate30.after(date) || addDate30.getTime() == date.getTime() ) && ( date.after(addDate7) || date.getTime()==addDate7.getTime() ) ){
				 map = new HashMap<String, String>();
				 map.put("nianshenzhuangtai", "预警");
				 map.put("value", "2");
			 }else if( ( addDate7.after(date) || addDate7.getTime()==date.getTime() ) && ( date.after(currentdate) || date.getTime()==currentdate.getTime() ) ){
				 map = new HashMap<String, String>();
				 map.put("nianshenzhuangtai", "报警");
				 map.put("value", "3");
			 }else if(currentdate.after(date)){
				 map = new HashMap<String, String>();
				 map.put("nianshenzhuangtai", "过期");
				 map.put("value", "4");
			 }else{
				 map = new HashMap<String, String>();
				 map.put("nianshenzhuangtai", "正常");
				 map.put("value", "1");
			 }
		}
		
		return map;
	}
	
	public Map<String, String> panDuanDengJiRiQi(Date date, int month){
		Calendar cal = Calendar.getInstance();
		
		Map<String, String> map = null;
		
		if(date != null){
			 Date currentdate = new Date();
			 
			 cal.setTime(currentdate);
			 cal.add(Calendar.MONTH, month);
			 Date addDate = cal.getTime();
			 
			 if( ( date.after(addDate)  )){
				 map = new HashMap<String, String>();
				 map.put("nianshenzhuangtai", "正常");
				 map.put("value", "1");
			 }else if( currentdate.after(date) ){
				 map = new HashMap<String, String>();
				 map.put("nianshenzhuangtai", "过期");
				 map.put("value", "4");
			 }else{
				 map = new HashMap<String, String>();
				 map.put("nianshenzhuangtai", "预警");
				 map.put("value", "2");
			 }
		}
		
		return map;
	}
	
	public String panduanZhuangTai(String riqi , String zhuangtai){
		
		 if("预警".equals(zhuangtai)){
			 riqi = "<span style=\" color:black \">" + riqi + "</span>";
		 }else if("报警".equals(zhuangtai)){
			 riqi = "<span style=\" color:brown \">" + riqi + "</span>";
		 }else if("过期".equals(zhuangtai)){
			 riqi = "<span style=\" color: red \">" + riqi + "</span>";
		 }
		
		return riqi;
	}
	
	/**
	 *  return 门户-年审
	 */
	public List<NianShenModel> returnMenHuNianShen(List<NianShen> nianshenlist){
		System.out.println("年审json");
		
//		设置字符格式
		FontFormat.setFontFormat(response);
		
				
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
//		创建年审模版集合对象
		List<NianShenModel> nianShenModelList = new ArrayList<NianShenModel>();
//		创建用户业务对象
		
		
		
		for (int i = 0; i < nianshenlist.size(); i++) {
			
			NianShen nianshen = nianshenlist.get(i);
			
			Integer id = nianshen.getId();
			
			
			String path =request.getContextPath()+"/jumpNianShen" ;
			String  chepaihao = "<a href=\""+path+"\">"+nianshen.getChepaihao()+"</a>";
			
			String  nianshenzhuangtai= "";
			String chezhuxingming = nianshen.getChezhuxingming();
			String shoujihao = nianshen.getShoujihao();
			
			int value = 0;
			
			String dengjiriqi = "";	//等级日期 
			if(nianshen.getDengjidaoqiriqi() != null){
				 dengjiriqi = sdf.format( nianshen.getDengjidaoqiriqi() );
			 }
			
			CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(nianshen.getChepaihao());
			if(cheliang != null){
				try {
					cal.setTime( cheliang.getZhuceriqi() );
					cal.add(Calendar.YEAR, 5);
					
					//大于5年 ， 4个月一次  ， 并且把 二级维护的日期  给 等级评定
					if(new Date().after(cal.getTime())){
						nianshen.setDengjidaoqiriqi(nianshen.getErjidaoqiriqi());
						
						nianShenService.updateNianShen(nianshen);
						
						Map<String, String> dengjidaoqiriqiMap = panDuanDengJiRiQi(nianshen.getDengjidaoqiriqi(), 4);
						if(dengjidaoqiriqiMap!=null){
							String zhuangtai = dengjidaoqiriqiMap.get("nianshenzhuangtai");
							int index =  Integer.valueOf(dengjidaoqiriqiMap.get("value"));
							
							dengjiriqi = panduanZhuangTai(dengjiriqi, zhuangtai);
							if(index>value){
								value = index;
								nianshenzhuangtai = zhuangtai;
							}
						}
						
						
					//小于5年 ， 1年一次
					}else{
						Map<String, String> dengjidaoqiriqiMap = panDuanDengJiRiQi(nianshen.getDengjidaoqiriqi(), 12);
						if(dengjidaoqiriqiMap!=null){
							String zhuangtai = dengjidaoqiriqiMap.get("nianshenzhuangtai");
							int index =  Integer.valueOf(dengjidaoqiriqiMap.get("value"));
							
							dengjiriqi = panduanZhuangTai(dengjiriqi, zhuangtai);
							if(index>value){
								value = index;
								nianshenzhuangtai = zhuangtai;
							}
						}
					}
				} catch (Exception e) {
				}
			}
			
			
			String nianshenriqi = "";
			if(nianshen.getNianshenriqi() != null){
				nianshenriqi = sdf.format(nianshen.getNianshenriqi());
			}
			
			String daoqiriqi = "";
			if(nianshen.getDaoqiriqi() != null){
				daoqiriqi = sdf.format( nianshen.getDaoqiriqi() );
			}

			String caozuoyuan = "";
			try {
				caozuoyuan = usersService.queryId( Integer.valueOf(nianshen.getCaozuoyuan()) ).getUsername();
			} catch (Exception e) {
			}
			
			
			String caozuoriqi = "";
			if(nianshen.getCaozuoriqi() != null){
				caozuoriqi = sdf.format( nianshen.getCaozuoriqi() );
			}
			 
			 String daoluriqi = "";	//道路日期
			 String erjiriqi = "";	//二级日期
			 
			 
				 
			 if(nianshen.getDaoludaoqiriqi() != null){
				 daoluriqi = sdf.format( nianshen.getDaoludaoqiriqi() );
			 }
			 
			 if(nianshen.getErjidaoqiriqi() != null){
				 erjiriqi = sdf.format( nianshen.getErjidaoqiriqi() );
			 }
			 
				 
			 
			 String guantidaoqiriqi = "";
			if(  nianshen.getGuantidaoqiriqi() != null){
				guantidaoqiriqi = sdf.format( nianshen.getGuantidaoqiriqi() );
			}
			
			//-------------------------
			//判断日期是否过期 判断大小
			//-------------------------
			
			Map<String, String> daoqiriqiMap = panDuanRiQi(nianshen.getDaoqiriqi());
			if(daoqiriqiMap!=null){
				String zhuangtai = daoqiriqiMap.get("nianshenzhuangtai");
				int index =  Integer.valueOf(daoqiriqiMap.get("value"));
				
				daoqiriqi = panduanZhuangTai(daoqiriqi , zhuangtai);
				if(index>value){
					value = index;
					nianshenzhuangtai = zhuangtai;
				}
			}
			
			Map<String, String> daoludaoqiriqiMap = panDuanRiQi(nianshen.getDaoludaoqiriqi());
			if(daoludaoqiriqiMap!=null){
				String zhuangtai = daoludaoqiriqiMap.get("nianshenzhuangtai");
				int index =  Integer.valueOf(daoludaoqiriqiMap.get("value"));
				
				daoluriqi = panduanZhuangTai(daoluriqi , zhuangtai);
				if(index>value){
					value = index;
					nianshenzhuangtai = zhuangtai;
				}
			}
			
			Map<String, String> erjidaoqiriqiMap = panDuanRiQi(nianshen.getErjidaoqiriqi());
			if(erjidaoqiriqiMap!=null){
				String zhuangtai = erjidaoqiriqiMap.get("nianshenzhuangtai");
				int index =  Integer.valueOf(erjidaoqiriqiMap.get("value"));
				
				erjiriqi = panduanZhuangTai(erjiriqi, zhuangtai);
				if(index>value){
					value = index;
					nianshenzhuangtai = zhuangtai;
				}
			}
			
			
			Map<String, String> guantidaoqiriqiMap = panDuanRiQi(nianshen.getGuantidaoqiriqi());
			if(guantidaoqiriqiMap!=null){
				String zhuangtai = guantidaoqiriqiMap.get("nianshenzhuangtai");
				int index =  Integer.valueOf(guantidaoqiriqiMap.get("value"));
				
				guantidaoqiriqi = panduanZhuangTai(guantidaoqiriqi, zhuangtai);
				if(index>value){
					value = index;
					nianshenzhuangtai = zhuangtai;
				}
			}
			
			
			//-------------------------
			 
			 NianShenModel nianshenmodel = new NianShenModel();
			 nianshenmodel.setNianShenModel(id, chepaihao, nianshenzhuangtai, 
					 						chezhuxingming, shoujihao, nianshenriqi, 
					 						daoqiriqi, caozuoyuan, caozuoriqi,daoluriqi,  erjiriqi,  dengjiriqi);
			 
			 nianshenmodel.setGuantidaoqiriqi(guantidaoqiriqi);
			 
			 nianShenModelList.add(nianshenmodel);
		}
		
		String nianshenzhuangtai = "正常";
			
		for (int i = 0; i < nianShenModelList.size() ; i++) {
			NianShenModel nianshenmodel = nianShenModelList.get(i);
			String value = nianshenmodel.getNianshenzhuangtai();
			if( value.equals(nianshenzhuangtai)){
				nianShenModelList.remove(nianshenmodel);
				--i;
			}
		}
		
		if(nianShenModelList.size()>5){
			for (int i = 5; i < nianShenModelList.size(); i++) {
				nianShenModelList.remove(i);
				--i;
			}
		}
		
		
		return nianShenModelList;
	}
	
	
	/**
	 *  年审详细
	 */
	public String nianShenXiangXi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("年审详细");
//		设置字符格式
		FontFormat.setFontFormat(response);
	
		
		
		String id = request.getParameter("id");
		
		 singlenianshen = nianShenService.queryNianShenId(Integer.valueOf(id));
		request.setAttribute("singlenianshen", singlenianshen);
		
		return "success";
	}
	
	/**
	 *  跳转-修改年审
	 */
	public String jumpUpdateNianShen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改年审");
		
//		设置字符格式
		FontFormat.setFontFormat(response);
		
//		判断是否选中	
		String id[] = request.getParameterValues("toolbar1");
		if(id==null || id.length>1 || id.length<1){
			CheLiangController.sendCheLiang(cheLiangService);
			return "err";
		}
			
		
		
		singlenianshen = nianShenService.queryNianShenId(Integer.valueOf(id[0]));
		request.setAttribute("singlenianshen", singlenianshen);
		
		return "success";
	}
	
	/**
	 *  提交-修改年审
	 */
	public String submitUpdateNianShen(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("跳转-修改年审");

//		设置字符格式
		FontFormat.setFontFormat(response);
	
		
		
		singlenianshen.setNianshenriqi(nianshenriqi);
		singlenianshen.setDaoqiriqi(daoqiriqi);
//		修改年审对象
		nianShenService.updateNianShen(singlenianshen);
		
//		得到车牌号
		String chepaihao = singlenianshen.getChepaihao();
				
//		得到对应车牌号的车辆
		CheLiang cheliang = cheLiangService.queryChePaiHaoCheLiang(chepaihao);
		cheliang.setNianshenriqi(nianshenriqi);
		cheLiangService.updateCheLiang(cheliang);
		
		 nianshenlist = nianShenService.queryNianShen();
		request.setAttribute("nianshenlist", nianshenlist);
		
		CheLiangController.sendCheLiang(cheLiangService);
		
		return "success";
	}
	
	
	public void exportNianShen(){
//		设置字符格式
		FontFormat.setFontFormat(response);
		
				
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
//		创建年审模版集合对象
		List<NianShenModel> nianShenModelList = new ArrayList<NianShenModel>();
		
		Calendar cal = Calendar.getInstance();
		Calendar cal7 = Calendar.getInstance();
		Calendar calAdd = Calendar.getInstance();
		
		for (int i = 0; i < nianshenlist.size(); i++) {
			NianShen nianshen = nianshenlist.get(i);
			
			Integer id = nianshen.getId();
			
			String  chepaihao = nianshen.getChepaihao();
			
			String  nianshenzhuangtai= "";
			String chezhuxingming = nianshen.getChezhuxingming();
			String shoujihao = nianshen.getShoujihao();
			
			String nianshenriqi = "";
			if(nianshen.getNianshenriqi() != null){
				nianshenriqi = sdf.format(nianshen.getNianshenriqi());
			}
			
			String daoqiriqi = "";
			if(nianshen.getDaoqiriqi() != null){
				daoqiriqi = sdf.format( nianshen.getDaoqiriqi() );
			}

			String caozuoyuan = nianshen.getCaozuoyuan();
			String caozuoriqi = "";
			if(nianshen.getCaozuoriqi() != null){
				caozuoriqi = sdf.format( nianshen.getCaozuoriqi() );
			}
			
			Date date = nianshen.getDaoqiriqi();
			if(date != null){
				Date currentdate = new Date();
				 
				 
				 cal.setTime(currentdate);
				 cal.add(Calendar.DATE, 30);
				 Date addDate = cal.getTime();
				 
				
				 cal7.setTime(currentdate);
				 cal7.add(Calendar.DATE, 7);
				 Date addDate7 = cal7.getTime();
				 
				 if(addDate.after(date) && date.after(addDate7)){
					 nianshenzhuangtai="预警";
				 }else if(addDate7.after(date) && date.after(currentdate)){
					 nianshenzhuangtai="报警";
				 }else if(currentdate.after(date)){
					 nianshenzhuangtai="过期";
				 }else{
					 nianshenzhuangtai="正常";
				 }
			}
			 
			 String daoluriqi = "";	//道路日期
			 String erjiriqi = "";	//二级日期
			 String dengjiriqi = "";	//等级日期 
			 
				 
			 if(nianshen.getDaoludaoqiriqi() != null){
				 daoluriqi = sdf.format( nianshen.getDaoludaoqiriqi() );
			 }
			 
			 if(nianshen.getErjidaoqiriqi() != null){
				 erjiriqi = sdf.format( nianshen.getErjidaoqiriqi() );
			 }
			 
			 if(nianshen.getDengjidaoqiriqi() != null){
				 dengjiriqi = sdf.format( nianshen.getDengjidaoqiriqi() );
			 }
				 
			 
			 String guantidaoqiriqi = "";
			if(  nianshen.getGuantidaoqiriqi() != null){
				guantidaoqiriqi = sdf.format( nianshen.getGuantidaoqiriqi() );
			}
			 
			 
			 NianShenModel nianshenmodel = new NianShenModel();
			 nianshenmodel.setNianShenModel(id, chepaihao, nianshenzhuangtai, 
					 						chezhuxingming, shoujihao, nianshenriqi, 
					 						daoqiriqi, caozuoyuan, caozuoriqi,daoluriqi,  erjiriqi,  dengjiriqi);
			 
			 nianshenmodel.setGuantidaoqiriqi(guantidaoqiriqi);
			 
			 nianShenModelList.add(nianshenmodel);
		}
		
		String nianshenzhuangtai = (String) session.getAttribute("nianshenzhuangtai");
		if(nianshenzhuangtai==null || "".equals(nianshenzhuangtai)){
		}else{
			
			for (int i = 0; i < nianShenModelList.size() ; i++) {
				NianShenModel nianshenmodel = nianShenModelList.get(i);
				String value = nianshenmodel.getNianshenzhuangtai();
				if(! value.equals(nianshenzhuangtai)){
					nianShenModelList.remove(nianshenmodel);
					--i;
				}
			}
			
		}
		
		JSONArray ja = JSONArray.fromObject(nianShenModelList);
		
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

	public String getNianshenzhuangtai() {
		return nianshenzhuangtai;
	}

	public void setNianshenzhuangtai(String nianshenzhuangtai) {
		this.nianshenzhuangtai = nianshenzhuangtai;
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

	public Date getNianshenriqi() {
		return nianshenriqi;
	}

	public void setNianshenriqi(Date nianshenriqi) {
		this.nianshenriqi = nianshenriqi;
	}

	public Date getDaoqiriqi() {
		return daoqiriqi;
	}

	public void setDaoqiriqi(Date daoqiriqi) {
		this.daoqiriqi = daoqiriqi;
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

	public NianShenService getNianShenService() {
		return nianShenService;
	}

	public void setNianShenService(NianShenService nianShenService) {
		this.nianShenService = nianShenService;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
