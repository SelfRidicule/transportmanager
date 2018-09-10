package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.FeiYongJieSuan;
import com.entity.FenGuanLingDao;
import com.entity.QuanXian;
import com.entity.ZeRenRen;

/**
 *   分管领导 模版类
 */
public class FenGuanLingDaoModel {
	/**
	 * 构造方法
	 */
	public FenGuanLingDaoModel() {
		super();
	}

	public FenGuanLingDaoModel(String id, String bianhao, String chepaihao,
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
	public void setFenGuanLingDaoModel(String id, String bianhao, String chepaihao,
			String banliriqi, String caozuoyuan, String caozuo) {
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuo = caozuo;
	}
	
	/**
	 *  得到分管领导模版集合
	 */
	public static List<FenGuanLingDaoModel> getFenGuanLingDaoModelList( List<FenGuanLingDao> fenguanlingdaolist ){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("分管领导意见".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getWeihu()) ){
					flag=true;
					break;
				}
				
			}
		}
		
		List<FenGuanLingDaoModel> fenGuanLingDaoModelList = new ArrayList<FenGuanLingDaoModel>();
		
		for (int i = 0; i < fenguanlingdaolist.size(); i++) {
			
			FenGuanLingDao fenguanlingdao = fenguanlingdaolist.get(i);
			
			String id = String.valueOf(fenguanlingdao.getId());
			String chepaihao = fenguanlingdao.getChepaihao();
			
			String xiangxipath =request.getContextPath()+"/"+"xinCheXiangXi?chepaihao="+chepaihao;
			String bianhao = "<a href=\""+xiangxipath+"\" target=\"_blank\">"+fenguanlingdao.getBianhao()+"</a>";
			
			String banliriqi = "";
			if(fenguanlingdao.getBanliriqi() != null){
				banliriqi = sdf.format( fenguanlingdao.getBanliriqi() );
			}
			
			String caozuoyuan = fenguanlingdao.getCaozuoyuan();
			
			String caozuo =  fenguanlingdao.getBanlizhuangtai();
			
			if(flag){
				if("未办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpAddFenGuanLingDao?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
					chepaihao = "";
				}
				if("已办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpUpdateFenGuanLingDao?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
			}
			
			FenGuanLingDaoModel fenguanlingdaomodel = new FenGuanLingDaoModel();
			fenguanlingdaomodel.setFenGuanLingDaoModel(id, bianhao, chepaihao, banliriqi, caozuoyuan, caozuo);
			
			fenGuanLingDaoModelList.add(fenguanlingdaomodel);
		}
		
		return fenGuanLingDaoModelList;
	}
	
	/**
	 *  得到门户分管领导模版集合
	 */
	public static List<FenGuanLingDaoModel> getMenHuFenGuanLingDaoModelList( List<FenGuanLingDao> fenguanlingdaolist ){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<FenGuanLingDaoModel> fenGuanLingDaoModelList = new ArrayList<FenGuanLingDaoModel>();
		
		for (int i = 0; i < fenguanlingdaolist.size(); i++) {
			
			FenGuanLingDao fenguanlingdao = fenguanlingdaolist.get(i);
			
			String id = String.valueOf(fenguanlingdao.getId());
			String chepaihao = fenguanlingdao.getChepaihao();
			
			String xiangxipath =request.getContextPath()+"/jumpFenGuanLingDao" ;
			String bianhao = "<a href=\""+xiangxipath+"\" >"+fenguanlingdao.getBianhao()+"</a>";
			
			String banliriqi = "";
			if(fenguanlingdao.getBanliriqi() != null){
				banliriqi = sdf.format( fenguanlingdao.getBanliriqi() );
			}
			
			String caozuoyuan = fenguanlingdao.getCaozuoyuan();
			
			String caozuo =  fenguanlingdao.getBanlizhuangtai();
			
			
			FenGuanLingDaoModel fenguanlingdaomodel = new FenGuanLingDaoModel();
			fenguanlingdaomodel.setFenGuanLingDaoModel(id, bianhao, chepaihao, banliriqi, caozuoyuan, caozuo);
			
			fenGuanLingDaoModelList.add(fenguanlingdaomodel);
		}
		
		return fenGuanLingDaoModelList;
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
