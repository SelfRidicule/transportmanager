package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.BaoXian;
import com.entity.NianShen;
import com.entity.QuanXian;

/**
 *  门户-年审
 */
public class MenHuNianShen {
	/**
	 * 构造方法
	 */
	public MenHuNianShen() {
		super();
	}
	
	/**
	 *  property
	 */
	private String chepaihao;	//车牌号
	private String chezhuxingming;	//车主姓名
	private String nianshenriqi;	//年审日期
	private String shoujihao;	//手机号
	
	/**
	 *  得到 门户-年审List
	 */
	public static List<MenHuNianShen> getMenHuNianShenList(List<NianShen> nianshenlist){
		
		List<MenHuNianShen> menHuNianShenList = new ArrayList<MenHuNianShen>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		
		int index =1;
		for (int i = 0; i < nianshenlist.size(); i++) {
			if(index >5){
				break;
			}
			
			 NianShen nianShen =  nianshenlist.get(i);
			
			 String chepaihao = nianShen.getChepaihao();	//车牌号
			 
			 String path =request.getContextPath()+"/jumpNianShen";
			 
			 chepaihao =  "<a href=\""+path+"\">"+ chepaihao +"</a>";
			 
			 String chezhuxingming = nianShen.getChezhuxingming();	//车主姓名
			 
			 String nianshenriqi = "";	//年审日期
			 if(nianShen.getNianshenriqi() != null){
				 nianshenriqi  = sdf.format( nianShen.getNianshenriqi() );
			 }
			 
			 String shoujihao = nianShen.getShoujihao();	//手机号
			
			 MenHuNianShen menHuNianShen = new MenHuNianShen();
			 menHuNianShen.setValueMenHuNianShen(chepaihao, chezhuxingming, nianshenriqi, shoujihao);
			 
			 menHuNianShenList.add(menHuNianShen);
			
			index++;
		}
		
		
		return menHuNianShenList;
	} 
	
	public void setValueMenHuNianShen(String chepaihao, String chezhuxingming,
			String nianshenriqi, String shoujihao) {
		this.chepaihao = chepaihao;
		this.chezhuxingming = chezhuxingming;
		this.nianshenriqi = nianshenriqi;
		this.shoujihao = shoujihao;
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
	public String getChezhuxingming() {
		return chezhuxingming;
	}
	public void setChezhuxingming(String chezhuxingming) {
		this.chezhuxingming = chezhuxingming;
	}
	public String getNianshenriqi() {
		return nianshenriqi;
	}
	public void setNianshenriqi(String nianshenriqi) {
		this.nianshenriqi = nianshenriqi;
	}
	public String getShoujihao() {
		return shoujihao;
	}
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	
	
}
