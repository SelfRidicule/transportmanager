package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.BaoXianChuDan;
import com.entity.QuanXian;
import com.entity.YingYunZheng;

/**
 *  保险出单模版类 
 */
public class BaoXianChuDanModel {
	/**
	 * 构造方法
	 */
	public BaoXianChuDanModel() {
		super();
	}

	public BaoXianChuDanModel(String id, String bianhao, String chepaihao,
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
	
	public static List<BaoXianChuDanModel> getBaoXianChuDanModel(List<BaoXianChuDan> baoxianchudanlist){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("保险出单".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getWeihu()) ){
					flag=true;
					break;
				}
				
			}
		}
		
//		创建保险出单模版集合对象
		List<BaoXianChuDanModel> baoxianchudanmodellist = new ArrayList<BaoXianChuDanModel>();
		
		for (int i = 0; i < baoxianchudanlist.size(); i++) {
			BaoXianChuDan baoxianchudan = baoxianchudanlist.get(i);
			
			String id = String.valueOf(baoxianchudan.getId());
			String chepaihao = baoxianchudan.getChepaihao();
			
			String xiangxipath =request.getContextPath()+"/"+"xinCheXiangXi?chepaihao="+chepaihao;
			String bianhao = "<a href=\""+xiangxipath+"\" target=\"_blank\">"+baoxianchudan.getBianhao()+"</a>";
			
			String banliriqi = baoxianchudan.getCaozuoriqi().toString();
			String caozuoyuan = baoxianchudan.getCaozuoyuan();
			String caozuo = baoxianchudan.getBanlizhuangtai();
			
			if(flag){
				if("未办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpAddBaoXianChuDan?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
				if("已办理".equals(caozuo)){
					String path =request.getContextPath()+"/"+"jumpUpdateBaoXianChuDan?chepaihao="+chepaihao;
					caozuo =  "<a href=\""+path+"\">"+caozuo+"</a>";
				}
			}
			
			BaoXianChuDanModel baoxianchudanmodel = new BaoXianChuDanModel();
			baoxianchudanmodel.setBaoXianChuDanModel(id, bianhao, chepaihao,
												banliriqi, caozuoyuan, caozuo);
			
			baoxianchudanmodellist.add(baoxianchudanmodel);
		}
		
		return baoxianchudanmodellist;
	}
	
	
	/**
	 *  赋值方法
	 */
	public void setBaoXianChuDanModel(String id, String bianhao, String chepaihao,
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
