package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.GouZhiShui;
import com.entity.QuanXian;
import com.entity.TouRuShenHe;

/**
 *  购置税模版类
 */
public class GouZhiShuiModel {
	/**
	 * 构造方法
	 */
	public GouZhiShuiModel() {
		super();
	}

	public GouZhiShuiModel(String id, String bianhao, String chepaihao,
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
	 *  得到购置税模版类集合
	 */
	public static List<GouZhiShuiModel> getGouZhiShuiModelList(List<GouZhiShui> gouzhishuilist){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("车管业务".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getWeihu()) ){
					flag=true;
					break;
				}
				
			}
		}
		
//		创建购置税模版类集合对象
		List<GouZhiShuiModel> gouZhiShuiModelList = new ArrayList<GouZhiShuiModel>();
		
		for (int i = 0; i < gouzhishuilist.size(); i++) {
			
			GouZhiShui gouzhishui = gouzhishuilist.get(i);
			
			String id = String.valueOf(gouzhishui.getId());
			String chepaihao = gouzhishui.getChepaihao();
			
			String xiangxipath =request.getContextPath()+"/"+"xinCheXiangXi?chepaihao="+chepaihao;
			String bianhao = "<a href=\""+xiangxipath+"\" target=\"_blank\">"+gouzhishui.getBianhao()+"</a>";
			
			String banliriqi = gouzhishui.getCaozuoriqi().toString();
			String caozuoyuan = gouzhishui.getCaozuoyuan();
			
			String caozuo = gouzhishui.getBanlizhuangtai();
			
			if(flag){
				if("未办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpAddGouZhiShui?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
				if("已办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpUpdateGouZhiShui?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
			}
			
			GouZhiShuiModel gouzhishuimodel = new GouZhiShuiModel();
			gouzhishuimodel.setGouZhiShuiModel(id, bianhao, chepaihao,
											banliriqi, caozuoyuan, caozuo);
			
			gouZhiShuiModelList.add(gouzhishuimodel);
		}
		
		return gouZhiShuiModelList;
	}
	
	/**
	 *  赋值方法 
	 */
	public void setGouZhiShuiModel(String id, String bianhao, String chepaihao,
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

	public String getBanliriqi() {
		return banliriqi;
	}

	public void setBanliriqi(String banliriqi) {
		this.banliriqi = banliriqi;
	}
	
}
