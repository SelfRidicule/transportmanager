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
import com.entity.ZeRenRen;

/**
 *  责任人 模版类
 */
public class ZeRenRenModel {
	/**
	 * 构造方法
	 */
	public ZeRenRenModel() {
		super();
	}

	public ZeRenRenModel(String id, String bianhao, String chepaihao,
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
	 *  得到责任人模版集合
	 */
	public static List<ZeRenRenModel> getZeRenRenModelList( List<ZeRenRen> zerenrenlist ){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("责任人签字".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getWeihu()) ){
					flag=true;
					break;
				}
				
			}
		}
		
		List<ZeRenRenModel> zeRenRenModelList = new ArrayList<ZeRenRenModel>();
		
		for (int i = 0; i < zerenrenlist.size(); i++) {
			ZeRenRen zerenren = zerenrenlist.get(i);
			
			String id = String.valueOf(zerenren.getId());
			String chepaihao = zerenren.getChepaihao();
			
			String xiangxipath =request.getContextPath()+"/"+"xinCheXiangXi?chepaihao="+chepaihao;
			String bianhao = "<a href=\""+xiangxipath+"\" target=\"_blank\">"+zerenren.getBianhao()+"</a>";
			
			String banliriqi = zerenren.getBanliriqi().toString();
			String caozuoyuan = zerenren.getCaozuoyuan();
			
			String caozuo =  zerenren.getBanlizhuangtai();
			
			if(flag){
				if("未办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpAddZeRenRen?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
				if("已办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpUpdateZeRenRen?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
			}
			
			ZeRenRenModel zerenrenmodel = new ZeRenRenModel();
			zerenrenmodel.setZeRenRenModel(id, bianhao, chepaihao, banliriqi, caozuoyuan, caozuo);
			
			zeRenRenModelList.add(zerenrenmodel);
			
		}
		
		return zeRenRenModelList;
	}
	
	/**
	 *  赋值方法
	 */
	public void setZeRenRenModel(String id, String bianhao, String chepaihao,
			String banliriqi, String caozuoyuan, String caozuo) {
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
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
