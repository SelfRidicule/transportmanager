package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.JiaShiYuan;
import com.entity.QuanXian;

/**
 *  驾驶员-工作门户
 */
public class MenHuJiaShiYuan {
	/**
	 * 构造方法
	 */
	public MenHuJiaShiYuan() {
		super();
	}
	
	public MenHuJiaShiYuan(String jiashiyuanxingming, String shenqingcheliang,
			String shenqingshijian) {
		super();
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.shenqingcheliang = shenqingcheliang;
		this.shenqingshijian = shenqingshijian;
	}

	/**
	 * 属性
	 */
	private String jiashiyuanxingming;
	private String shenqingcheliang;
	private String shenqingshijian;
	
	/**
	 *  赋值方法 
	 */
	public void setMenHuJiaShiYuan(String jiashiyuanxingming, String shenqingcheliang,
			String shenqingshijian) {
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.shenqingcheliang = shenqingcheliang;
		this.shenqingshijian = shenqingshijian;
	}
	
	/**
	 *  得到驾驶员-工作门户集合对象 
	 */
	public static List<MenHuJiaShiYuan> getMenHuJiaShiYuanList( List<JiaShiYuan> jiashiyuanmenhulist ){
		List<MenHuJiaShiYuan> menhujiashiyuanlist = new ArrayList<MenHuJiaShiYuan>();
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		boolean flag = false ;
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("驾驶员审核".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getChakan()) ){
					flag=true;
					break;
				}
				
			}
		}
		
		if(!flag){
			return null;
		}
		
		int index =1;
		for (int i = 0; i < jiashiyuanmenhulist.size(); i++) {
			if(index >5){
				break;
			}
			
			JiaShiYuan jiashiyuan = jiashiyuanmenhulist.get(i);
			
			String jiashiyuanxingming = jiashiyuan.getJiashiyuanxingming();
			
			String path =request.getContextPath()+"/jumpJiaShiYuanShenHe";
			jiashiyuanxingming =  "<a href=\""+path+"\">"+ jiashiyuanxingming +"</a>";
			
			
			String shenqingcheliang = "";
			if(jiashiyuan.getJiashicheliang() != null){
				shenqingcheliang = jiashiyuan.getJiashicheliang();
			}
			
			String shenqingshijian = "";
			if(jiashiyuan.getCaozuoriqi() != null){
				shenqingshijian = sdf.format( jiashiyuan.getCaozuoriqi() );
			}
			
			MenHuJiaShiYuan menhujiashiyuan = new MenHuJiaShiYuan();
			menhujiashiyuan.setMenHuJiaShiYuan(jiashiyuanxingming, shenqingcheliang, shenqingshijian);
			menhujiashiyuanlist.add(menhujiashiyuan);
			
			index++;
		}
		
		return menhujiashiyuanlist;
	}
	
	/**
	 *  get set
	 */
	public String getJiashiyuanxingming() {
		return jiashiyuanxingming;
	}
	public void setJiashiyuanxingming(String jiashiyuanxingming) {
		this.jiashiyuanxingming = jiashiyuanxingming;
	}
	public String getShenqingcheliang() {
		return shenqingcheliang;
	}
	public void setShenqingcheliang(String shenqingcheliang) {
		this.shenqingcheliang = shenqingcheliang;
	}
	public String getShenqingshijian() {
		return shenqingshijian;
	}
	public void setShenqingshijian(String shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	
}
