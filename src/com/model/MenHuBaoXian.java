package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.BaoXian;
import com.entity.QuanXian;

/**
 *  保险-工作门户
 */
public class MenHuBaoXian {
	/**
	 * 构造方法
	 */
	public MenHuBaoXian() {
		super();
	}
	
	public MenHuBaoXian(String chepaihao, String baoxianleixing,
			String daoqiriqi) {
		super();
		this.chepaihao = chepaihao;
		this.baoxianleixing = baoxianleixing;
		this.daoqiriqi = daoqiriqi;
	}

	/**
	 * 属性
	 */
	private String chepaihao;
	private String baoxianleixing;
	private String daoqiriqi;
	
	/**
	 *  赋值方法
	 */
	public void setMenHuBaoXian(String chepaihao, String baoxianleixing,
			String daoqiriqi) {
		this.chepaihao = chepaihao;
		this.baoxianleixing = baoxianleixing;
		this.daoqiriqi = daoqiriqi;
	}
	
	/**
	 *  得到保险-工作门户集合对象
	 */
	public static List<MenHuBaoXian> getMenHuBaoXianList( List<BaoXian> baoxianmenhulist ){
		List<MenHuBaoXian> menhubaoxianlist = new ArrayList<MenHuBaoXian>();
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		boolean flag = false ;
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("保险管理".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getChakan()) ){
					flag=true;
					break;
				}
				
			}
		}
		
		if(!flag){
			return null;
		}
		
		int index =1;
		for (int i = 0; i < baoxianmenhulist.size(); i++) {
			if(index >5){
				break;
			}
			
			BaoXian baoxian = baoxianmenhulist.get(i);
			
			String chepaihao = baoxian.getChepaihao();
			if(flag){
				String path =request.getContextPath()+"/jumpBaoXian";
				chepaihao =  "<a href=\""+path+"\">"+ chepaihao +"</a>";
			}
			
			String baoxianleixing = "";
			if(baoxian.getBaoxianleixing() != null){
				baoxianleixing = baoxian.getBaoxianleixing();
			}
			
			String daoqiriqi = "";
			if(baoxian.getDaoqiriqi() != null){
				daoqiriqi = sdf.format( baoxian.getDaoqiriqi() );
			}
			
			MenHuBaoXian menhubaoxian = new MenHuBaoXian();
			menhubaoxian.setMenHuBaoXian(chepaihao, baoxianleixing, daoqiriqi);
			menhubaoxianlist.add(menhubaoxian);
			
			index++;
		}
		
		return menhubaoxianlist;
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
	public String getBaoxianleixing() {
		return baoxianleixing;
	}
	public void setBaoxianleixing(String baoxianleixing) {
		this.baoxianleixing = baoxianleixing;
	}
	public String getDaoqiriqi() {
		return daoqiriqi;
	}
	public void setDaoqiriqi(String daoqiriqi) {
		this.daoqiriqi = daoqiriqi;
	}
	
}
