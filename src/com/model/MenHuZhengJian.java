package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.QuanXian;
import com.entity.ZhengJian;

/**
 *  工作门户-证件
 */
public class MenHuZhengJian {
	/**
	 * 构造方法
	 */
	public MenHuZhengJian() {
		super();
	}

	public MenHuZhengJian(String chepaihao, String zhengjianleixing,
			String daoqiriqi) {
		super();
		this.chepaihao = chepaihao;
		this.zhengjianleixing = zhengjianleixing;
		this.daoqiriqi = daoqiriqi;
	}

	/**
	 * 属性
	 */
	private String chepaihao;
	private String zhengjianleixing;
	private String daoqiriqi;
	
	/**
	 *  赋值方法
	 */
	public void setMenHuZhengJian(String chepaihao, String zhengjianleixing,
			String daoqiriqi) {
		this.chepaihao = chepaihao;
		this.zhengjianleixing = zhengjianleixing;
		this.daoqiriqi = daoqiriqi;
	}
	
	/**
	 *  得到工作门户-证件
	 */
	public static List<MenHuZhengJian> getMenHuZhengJianList( List<ZhengJian> zhengjianmenhulist ){
		List<MenHuZhengJian> menhuzhengjianlist = new ArrayList<MenHuZhengJian>();
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("证件管理".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getChakan()) ){
					flag=true;
					break;
				}
				
			}
		}
		
		if(!flag){
			return null;
		}
		
		int index =1;
		for (int i = 0; i < zhengjianmenhulist.size(); i++) {
			if(index >5){
				break;
			}
			
			ZhengJian zhengjian = zhengjianmenhulist.get(i);
			
			String chepaihao = zhengjian.getChepaihao();
			if(flag){
				String path =request.getContextPath()+"/jumpZhengJian";
				chepaihao =  "<a href=\""+path+"\">"+chepaihao+"</a>";
			}
			
			String zhengjianleixing = "";
			if(zhengjian.getZhengjianleixing()!=null){
				zhengjianleixing = zhengjian.getZhengjianleixing();
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String daoqiriqi = "";
			if(zhengjian.getDaoqiriqi()!=null){
				daoqiriqi = sdf.format(zhengjian.getDaoqiriqi());
			}
			
			MenHuZhengJian menhuzhengjian = new MenHuZhengJian();
			menhuzhengjian.setMenHuZhengJian(chepaihao, zhengjianleixing, daoqiriqi);
			
			menhuzhengjianlist.add(menhuzhengjian);
			index++;
		}
		
		
		return menhuzhengjianlist ;
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
	public String getZhengjianleixing() {
		return zhengjianleixing;
	}
	public void setZhengjianleixing(String zhengjianleixing) {
		this.zhengjianleixing = zhengjianleixing;
	}
	public String getDaoqiriqi() {
		return daoqiriqi;
	}
	public void setDaoqiriqi(String daoqiriqi) {
		this.daoqiriqi = daoqiriqi;
	}
	
}
