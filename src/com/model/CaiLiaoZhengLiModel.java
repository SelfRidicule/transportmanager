package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.BaoXianChuDan;
import com.entity.CaiLiaoZhengLi;
import com.entity.QuanXian;

/**
 *  材料整理 模版类
 */
public class CaiLiaoZhengLiModel {
	/**
	 * 构造方法
	 */
	public CaiLiaoZhengLiModel() {
		super();
	}

	public CaiLiaoZhengLiModel(String id, String bianhao, String chepaihao,
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
	public void setCaiLiaoZhengLiModel(String id, String bianhao, String chepaihao,
			String banliriqi, String caozuoyuan, String caozuo) {
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuo = caozuo;
	}
	
	/**
	 *  得到材料整理模版类集合
	 */
	public static List<CaiLiaoZhengLiModel> getCaiLiaoZhengLiModelList(List<CaiLiaoZhengLi> cailiaozhenglilist  ){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("材料整理档案建立".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getWeihu()) ){
					flag=true;
					break;
				}
				
			}
		}
//		
		List<CaiLiaoZhengLiModel> cailiaozhenglimodellist = new ArrayList<CaiLiaoZhengLiModel>();
		
		for (int i = 0; i < cailiaozhenglilist.size(); i++) {
			CaiLiaoZhengLi cailiaozhengli =  cailiaozhenglilist.get(i);
			
			String id = String.valueOf(cailiaozhengli.getId());
			String chepaihao = cailiaozhengli.getChepaihao();

			String xiangxipath =request.getContextPath()+"/"+"xinCheXiangXi?chepaihao="+chepaihao;
			String bianhao = "<a href=\""+xiangxipath+"\" target=\"_blank\">"+cailiaozhengli.getBianhao()+"</a>";
			
			String banliriqi = cailiaozhengli.getBanliriqi().toString();
			String caozuoyuan = cailiaozhengli.getCaozuoyuan();
			
			String caozuo =  cailiaozhengli.getBanlizhuangtai();
			
			if(flag){
				if("未办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpAddCaiLiaoZhengLi?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
				if("已办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpUpdateCaiLiaoZhengLi?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
			}
			
			CaiLiaoZhengLiModel cailiaozhenglimodel = new CaiLiaoZhengLiModel();
			cailiaozhenglimodel.setCaiLiaoZhengLiModel(id, bianhao, chepaihao, 
												banliriqi, caozuoyuan, caozuo);
			
			cailiaozhenglimodellist.add(cailiaozhenglimodel);
		}
		
		
		
		return cailiaozhenglimodellist;
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
