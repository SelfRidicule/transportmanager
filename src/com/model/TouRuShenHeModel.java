package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.QuanXian;
import com.entity.TouRuShenHe;
import com.entity.XinChe;

/**
 *  投入审核模版类
 */
public class TouRuShenHeModel {
	/**
	 * 构造方法
	 */
	public TouRuShenHeModel() {
		super();
	}

	public TouRuShenHeModel(String id, String bianhao, String chepaihao,
			String zhuceriqi, String caozuoyuan, String caozuo) {
		super();
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.zhuceriqi = zhuceriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuo = caozuo;
	}

	/**
	 * 属性
	 */
	private String id ;
	private String bianhao;
	private String chepaihao;
	private String zhuceriqi;
	private String caozuoyuan;
	private String caozuo;
	
	/**
	 *  得到投入审核模版类集合
	 */
	public static List<TouRuShenHeModel> getTouRuShenHeModelList(List<TouRuShenHe> tourushenhelist){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("投入审核和申请".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getWeihu()) ){
					flag=true;
					break;
				}
				
			}
		}
		
		List<TouRuShenHeModel> touRuShenHeModelList = new ArrayList<TouRuShenHeModel>();
		
		for (int i = 0; i < tourushenhelist.size(); i++) {
			TouRuShenHeModel tourushenhemodel = new TouRuShenHeModel();
			
			TouRuShenHe touruhenhe = tourushenhelist.get(i);
			
			String id = String.valueOf(touruhenhe.getId());
			String chepaihao = touruhenhe.getChepaihao();

			String xiangxipath =request.getContextPath()+"/"+"xinCheXiangXi?chepaihao="+chepaihao;
			String bianhao = "<a href=\""+xiangxipath+"\" target=\"_blank\">"+touruhenhe.getBianhao()+"</a>";
			
			String zhuceriqi = touruhenhe.getShenpishijian().toString();
			String caozuoyuan = touruhenhe.getCaozuoyuan();
			
			String caozuo = touruhenhe.getBanlizhuangtai();
			
			if(flag){
				if("未办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpAddTouRuShenHe?chepaihao="+chepaihao;
					caozuo = "<a href=\""+path+"\">"+caozuo+"</a>";
				}
				if("已办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpUpdateTouRuShenHe?chepaihao="+chepaihao;
					caozuo = "<a href=\""+path+"\">"+caozuo+"</a>";
				}
			}
			
			tourushenhemodel.setTouRuShenHeModel(id, bianhao, chepaihao, zhuceriqi, caozuoyuan, caozuo);
			touRuShenHeModelList.add(tourushenhemodel);
		}
		
		return touRuShenHeModelList;
	}
	
	/**
	 *  得到门户投入审核模版类集合
	 */
	public static List<TouRuShenHeModel> getMenHuTouRuShenHeModelList(List<TouRuShenHe> tourushenhelist){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		
		List<TouRuShenHeModel> touRuShenHeModelList = new ArrayList<TouRuShenHeModel>();
		
		int index = 1;
		
		for (int i = 0; i < tourushenhelist.size(); i++) {
			if(index>5){
				break;
			}
			index++;
			
			TouRuShenHeModel tourushenhemodel = new TouRuShenHeModel();
			
			TouRuShenHe touruhenhe = tourushenhelist.get(i);
			
			String id = String.valueOf(touruhenhe.getId());
			String chepaihao = touruhenhe.getChepaihao();

			String xiangxipath =request.getContextPath()+"/jumpTouRuShenHe" ;
			String bianhao = "<a href=\""+xiangxipath+"\" >"+touruhenhe.getBianhao()+"</a>";
			
			String zhuceriqi = touruhenhe.getShenpishijian().toString();
			String caozuoyuan = touruhenhe.getCaozuoyuan();
			
			String caozuo = touruhenhe.getBanlizhuangtai();
			
			
			tourushenhemodel.setTouRuShenHeModel(id, bianhao, chepaihao, zhuceriqi, caozuoyuan, caozuo);
			touRuShenHeModelList.add(tourushenhemodel);
		}
		
		return touRuShenHeModelList;
	}
	
	/**
	 *  赋值方法
	 */
	public void setTouRuShenHeModel(String id, String bianhao, String chepaihao,
			String zhuceriqi, String caozuoyuan, String caozuo) {
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.zhuceriqi = zhuceriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuo = caozuo;
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
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getZhuceriqi() {
		return zhuceriqi;
	}
	public void setZhuceriqi(String zhuceriqi) {
		this.zhuceriqi = zhuceriqi;
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

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	
}
