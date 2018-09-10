package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.GouZhiShui;
import com.entity.QuanXian;
import com.entity.YingYunZheng;

/**
 *  营运证
 */
public class YingYunZhengModel {
	/**
	 * 构造方法
	 */
	public YingYunZhengModel() {
		super();
	}
	
	public YingYunZhengModel(String id, String bianhao, String chepaihao,
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
	public void setYingYunZhengModel(String id, String bianhao, String chepaihao,
			String banliriqi, String caozuoyuan, String caozuo) {
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.banliriqi = banliriqi;
		this.caozuoyuan = caozuoyuan;
		this.caozuo = caozuo;
	}
	
	/**
	 *  得到营运证模版类集合对象
	 */
	public static List<YingYunZhengModel> getYingYunZhengModelList(List<YingYunZheng> yingyunzhenglist){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("运管业务".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getWeihu()) ){
					flag=true;
					break;
				}
				
			}
		}
		
//		创建营运证模版类集合对象
		List<YingYunZhengModel>  yingYunZhengModelList = new ArrayList<YingYunZhengModel>();
		
		for (int i = 0; i < yingyunzhenglist.size(); i++) {
			
			YingYunZheng yingyunzheng = yingyunzhenglist.get(i);
			
			String id = String.valueOf(yingyunzheng.getId());
			String chepaihao = yingyunzheng.getChepaihao();

			String xiangxipath =request.getContextPath()+"/"+"xinCheXiangXi?chepaihao="+chepaihao;
			String bianhao = "<a href=\""+xiangxipath+"\" target=\"_blank\">"+yingyunzheng.getBianhao()+"</a>";
			
			String banliriqi = yingyunzheng.getCaozuoriqi().toString();
			String caozuoyuan = yingyunzheng.getCaozuoyuan();
			
			String caozuo = yingyunzheng.getBanlizhuangtai();
			
			if(flag){
				if("未办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpAddYingYunZheng?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
				if("已办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpUpdateYingYunZheng?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
			}
			
			YingYunZhengModel yingyunzhengmodel = new YingYunZhengModel();
			yingyunzhengmodel.setYingYunZhengModel(id, bianhao, chepaihao,
												banliriqi, caozuoyuan, caozuo);
			
			yingYunZhengModelList.add(yingyunzhengmodel);
		}
		
		return yingYunZhengModelList;
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
