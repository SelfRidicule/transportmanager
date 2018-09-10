package com.action;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.KaiPiao;
import com.model.KaiPiaoModel;
import com.model.KaiPiaoXiangXiModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.KaiPiaoService;

import net.sf.json.JSONArray;

/**
 *  开票控制层
 */
public class KaiPiaoController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public KaiPiaoController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

	
	
	private KaiPiaoService kaiPiaoService;
	
	
	
	
	/**
	 * 属性
	 */
	private String kehudanwei;	//客户单位
	private String chengyunren;	//承运人
	private String huowumingcheng;	//货物名称
	private Date chaxunxiaoyulingkuanshijian;	//查询小于领款时间
	private Date chaxundayulingkuanshijian;	//查询大于领款时间
	
//	集合对象
	private static List<KaiPiao> kaipiaolist ;
//	单一对象
	private static KaiPiao singlekaipiao;
	
	/**
	 *  跳转-开票
	 */
	public String jumpKaiPiao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end

//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		
		
		 kaipiaolist = kaiPiaoService.queryKaiPiaoList();
		request.setAttribute("kaipiaolist", kaipiaolist);
		
		
		return "success";
	}
	
	/**
	 *  开票json
	 */
	public void kaiPiaoJson(){
		System.out.println(" 开票json ");
//		设置字符格式
		FontFormat.setFontFormat(response);		

//		判断是否为null
		if(kaipiaolist == null || kaipiaolist.size()<1){
			return ;
		}
		
		List<KaiPiaoModel> kaipiaomodellist = KaiPiaoModel.getKaiPiaoModelList(kaipiaolist);
		
		JSONArray ja = JSONArray.fromObject(kaipiaomodellist);
		
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
	public String vagueSearchKaiPiao(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("模糊查询");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
			
		
		 kaipiaolist = kaiPiaoService.vagueSearchKaiPiao(kehudanwei, chengyunren, huowumingcheng, chaxunxiaoyulingkuanshijian, chaxundayulingkuanshijian);
		request.setAttribute("kaipiaolist", kaipiaolist);
		
		return "success";
	}	
	
	/**
	 *  跳转-开票详细
	 */
	public String jumpKaiPiaoXiangXi(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-开票详细");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
			
		
		String id = request.getParameter("id");
		
		singlekaipiao = kaiPiaoService.queryKaiPiaoId(Integer.valueOf(id));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String kaipiaoshijian = "";

		if(singlekaipiao.getKaipiaoshijian() != null){
			kaipiaoshijian = sdf.format(singlekaipiao.getKaipiaoshijian());
		}
		
		request.setAttribute("kaipiaoshijian", kaipiaoshijian);
		request.setAttribute("singlekaipiao", singlekaipiao);
		
//		-----------------------------------
		
		Double sumkaipiaojine = 0.0;
		Double sumshuijin = 0.0;
		Double sumguanlifei = 0.0;
		Double sumshifuyunfei = 0.0;
		Double sumdaidianfei = 0.0;
		Double sumzuchefei = 0.0;
		Double sumyewufei = 0.0;
		
//		开始分割
		String chengyunrenArr[] = {};
		try {
			chengyunrenArr = singlekaipiao.getChengyunren().split("\\|");
		} catch (Exception e) {
		}
		
		String kaipiaojineArr[] = {};
		try {
			kaipiaojineArr = singlekaipiao.getKaipiaojine().split("\\|");
		} catch (Exception e) {
		}
		
		String shuijinArr[] = {};
		try {
			shuijinArr = singlekaipiao.getShuijin().split("\\|");
		} catch (Exception e) {
		}
		
		String guanlifeiArr[] = {};
		try {
			guanlifeiArr = singlekaipiao.getGuanlifei().split("\\|");
		} catch (Exception e) {
		}
		
		String shifuyunfeiArr[] = {};
		try {
			shifuyunfeiArr = singlekaipiao.getShifuyunfei().split("\\|");
		} catch (Exception e) {
		}
		
		String daidianfeiArr[] = {};
		try {
			daidianfeiArr = singlekaipiao.getDaidianfei().split("\\|");
		} catch (Exception e) {
		}
		
		String zuchefeiArr[] = {};
		try {
			zuchefeiArr = singlekaipiao.getZuchefei().split("\\|");
		} catch (Exception e) {
		}
		
		String yewufeiArr[] = {};
		try {
			yewufeiArr = singlekaipiao.getYewufei().split("\\|");
		} catch (Exception e) {
		}
		
		String beizhuArr[] = {};
		try {
			beizhuArr = singlekaipiao.getBeizhu().split("\\|");
		} catch (Exception e) {
		}
		
		
		List<KaiPiaoXiangXiModel> kaiPiaoXiangXiModelList = new ArrayList<KaiPiaoXiangXiModel>();
		
//		循环开始累加
		for (int i = 0; i < chengyunrenArr.length; i++) {
			
			String xuhao = (i+1)+"";
			
			String chengyunren = "";
			try {
				chengyunren = chengyunrenArr[i];
			} catch (Exception e) {
			}
			
			String kaipiaojine = "";
			try {
				kaipiaojine = kaipiaojineArr[i];
			} catch (Exception e) {
			}
			
			String shuijin = "";
			try {
				shuijin = shuijinArr[i];
			} catch (Exception e) {
			}
			
			String guanlifei = "";
			try {
				guanlifei = guanlifeiArr[i];
			} catch (Exception e) {
			}
			
			String shifuyunfei = "";
			try {
				shifuyunfei = shifuyunfeiArr[i];
			} catch (Exception e) {
			}
			
			String daidianfei = "";
			try {
				daidianfei = daidianfeiArr[i];
			} catch (Exception e) {
			}
			
			String zuchefei = "";
			try {
				zuchefei = zuchefeiArr[i];
			} catch (Exception e) {
			}
			
			String yewufei = "";
			try {
				yewufei = yewufeiArr[i];
			} catch (Exception e) {
			}
			
			String beizhu = "";
			try {
				beizhu = beizhuArr[i];
			} catch (Exception e) {
			}
			
			
			KaiPiaoXiangXiModel kaiPiaoXiangXiModel = new KaiPiaoXiangXiModel();
			kaiPiaoXiangXiModel.setValueKaiPiaoXiangXiModel( xuhao,  chengyunren,
															 kaipiaojine,  shuijin,  guanlifei,
															 shifuyunfei,  daidianfei,  zuchefei,
															 yewufei,  beizhu);
			
			kaiPiaoXiangXiModelList.add(kaiPiaoXiangXiModel);
			
			
//			开始合计
			 sumkaipiaojine = sumkaipiaojine + StringTfmDouble(kaipiaojine);
			 sumshuijin = sumshuijin + StringTfmDouble(shuijin);
			 sumguanlifei = sumguanlifei + StringTfmDouble(guanlifei);
			 sumshifuyunfei = sumshifuyunfei + StringTfmDouble(shifuyunfei);
			 sumdaidianfei = sumdaidianfei + StringTfmDouble(daidianfei);
			 sumzuchefei = sumzuchefei + StringTfmDouble(zuchefei);
			 sumyewufei = sumyewufei + StringTfmDouble(yewufei);
			
		}
		
//		所有实付运费合计除以0.875
		sumshifuyunfei = sumshifuyunfei / 0.875 ;
		
//		发送数据
		request.setAttribute( "sumkaipiaojine" , formatDoubleTwo(sumkaipiaojine) );
		request.setAttribute( "sumshuijin" , formatDoubleTwo(sumshuijin) );
		request.setAttribute( "sumguanlifei" , formatDoubleTwo(sumguanlifei) );
		request.setAttribute( "sumshifuyunfei" , formatDoubleTwo(sumshifuyunfei) );
		request.setAttribute( "sumdaidianfei" , formatDoubleTwo(sumdaidianfei) );
		request.setAttribute( "sumzuchefei" , formatDoubleTwo(sumzuchefei) );
		request.setAttribute( "sumyewufei" , formatDoubleTwo(sumyewufei) );
		  
		
		request.setAttribute("kaiPiaoXiangXiModelList", kaiPiaoXiangXiModelList);
		
		return "success";
	}
	
	/**
	 * 删除
	 */
	public String kaiPiaoDelete(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
		
		System.out.println("跳转-开票详细");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
//		得到保险id数组
		String id[] = request.getParameterValues("toolbar1");		
		if(id==null || id.length<1){
			return "success";
		}	
		
			
		
		for (int i = 0; i < id.length; i++) {
			
			KaiPiao kaipiao = new KaiPiao();
			
			kaipiao.setId(Integer.valueOf( id[i] ));
			
			try {
				kaiPiaoService.deleteKaiPiao(kaipiao);
			} catch (Exception e) {
			}
			
		}
		
		 kaipiaolist = kaiPiaoService.queryKaiPiaoList();
		request.setAttribute("kaipiaolist", kaipiaolist);
		
		return "success";
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
	 *  get set
	 */

	public String getHuowumingcheng() {
		return huowumingcheng;
	}

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}

	public String getChengyunren() {
		return chengyunren;
	}

	public void setChengyunren(String chengyunren) {
		this.chengyunren = chengyunren;
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

	public KaiPiaoService getKaiPiaoService() {
		return kaiPiaoService;
	}

	public void setKaiPiaoService(KaiPiaoService kaiPiaoService) {
		this.kaiPiaoService = kaiPiaoService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}

