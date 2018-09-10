package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.CaiLiaoZhengLi;
import com.entity.FeiYongJieSuan;
import com.entity.QuanXian;

/**
 *  费用结算 模版类
 */
public class FeiYongJieSuanModel {
	/**
	 * 构造方法
	 */
	public FeiYongJieSuanModel() {
		super();
	}

	public FeiYongJieSuanModel(String id, String bianhao, String chepaihao,
			String banliriqi, String caozuoyuan, String caozuo) {
		super();
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuo = caozuo;
	}

	/**
	 * 属性
	 */
	private String id ;
	private String bianhao;
	private String chepaihao;
	private String banliriqi;
	private String caozuoyuan;
	private String caozuo;
	
	/**
	 *  赋值方法
	 */
	public void setFeiYongJieSuanModel(String id, String bianhao, String chepaihao,
			String banliriqi, String caozuoyuan, String caozuo) {
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuo = caozuo;
	}
	
	/**
	 *  得到费用结算模版集合对象
	 */
	public static List<FeiYongJieSuanModel> getFeiYongJieSuanModelList( List<FeiYongJieSuan> feiyongjiesuanlist ){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("费用结算".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getWeihu()) ){
					flag=true;
					break;
				}
				
			}
		}
		
//		创建模版集合对象
		List<FeiYongJieSuanModel> feiYongJieSuanModelList = new ArrayList<FeiYongJieSuanModel>();
		
		for (int i = 0; i < feiyongjiesuanlist.size(); i++) {
			FeiYongJieSuan feiyongjiesuan = feiyongjiesuanlist.get(i);
			
			String id = String.valueOf(feiyongjiesuan.getId());
			String chepaihao = feiyongjiesuan.getChepaihao();
			
			String xiangxipath =request.getContextPath()+"/"+"xinCheXiangXi?chepaihao="+chepaihao;
			String bianhao = "<a href=\""+xiangxipath+"\" target=\"_blank\">"+feiyongjiesuan.getBianhao()+"</a>";
			
			String banliriqi = feiyongjiesuan.getBanliriqi().toString();
			String caozuoyuan = feiyongjiesuan.getCaozuoyuan();
			
			String caozuo =  feiyongjiesuan.getBanlizhuangtai();
			
			if(flag){
				if("未办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpAddFeiYongJieSuan?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
				if("已办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpUpdateFeiYongJieSuan?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
			}
			
			FeiYongJieSuanModel feiyongjiesuanmodel = new FeiYongJieSuanModel();
			feiyongjiesuanmodel.setFeiYongJieSuanModel(id, bianhao, chepaihao, banliriqi, caozuoyuan, caozuo);
			
			feiYongJieSuanModelList.add(feiyongjiesuanmodel);
		}
		
		return feiYongJieSuanModelList;
	}
	
	/**
	 *  get set
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getBanliriqi() {
		return banliriqi;
	}
	public void setBanliriqi(String banliriqi) {
		this.banliriqi = banliriqi;
	}
	public String getCaozuoyuan() {
		return caozuoyuan;
	}
	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}
	public String getCaozuo() {
		return caozuo;
	}
	public void setCaozuo(String caozuo) {
		this.caozuo = caozuo;
	}
	
}
