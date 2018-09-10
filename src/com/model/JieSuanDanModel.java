package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.JieSuanDan;

/**
 * 	结算单 模版类
 */
public class JieSuanDanModel {
	/**
	 * 构造方法
	 */
	public JieSuanDanModel() {
		super();
	}
	
	public JieSuanDanModel(String id, String dingdanhao, String chezhuxingming,
			String huowumingcheng, String lingkuanshijian, String kehudanwei) {
		super();
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.chezhuxingming = chezhuxingming;
		this.huowumingcheng = huowumingcheng;
		this.lingkuanshijian = lingkuanshijian;
		this.kehudanwei = kehudanwei;
	}

	/**
	 * 属性
	 */
	private String id ;
	private String dingdanhao;
	private String chezhuxingming;
	private String huowumingcheng;
	private String lingkuanshijian;
	private String kehudanwei;
	
	/**
	 * 	得到结算单模版类集合
	 */
	public static List<JieSuanDanModel> getJieSuanDanModelList( List<JieSuanDan> jiesuandanlist ){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<JieSuanDanModel> jiesuandanmodellist = new ArrayList<JieSuanDanModel>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i = 0; i < jiesuandanlist.size(); i++) {
			
			JieSuanDan jiesuandan = jiesuandanlist.get(i);
			
			String id = String.valueOf( jiesuandan.getId() );
			String dingdanhao = jiesuandan.getDingdanhao();
			String path =request.getContextPath()+"/"+"jumpJieSuanDanXiangXi?id="+id;
			dingdanhao =  "<a href=\""+path+"\">"+dingdanhao+"</a>";
			
			String chezhuxingming = jiesuandan.getChezhuxingming();
			String huowumingcheng = jiesuandan.getHuowumingcheng();
			
			String lingkuanshijian = "";
			Date date = jiesuandan.getLingkuanshijian();
			if(date != null){
				lingkuanshijian = sdf.format(date);
			}
			
			String kehudanwei = jiesuandan.getKehudanwei();
			
			JieSuanDanModel jiesuandanmodel = new JieSuanDanModel();
			jiesuandanmodel.setJieSuanDanModel( id,  dingdanhao,  chezhuxingming,
					 huowumingcheng,  lingkuanshijian,  kehudanwei);
			
			jiesuandanmodellist.add(jiesuandanmodel);
			
		}
		
		return jiesuandanmodellist;
	}
	
	
	/**
	 * 	赋值方法
	 */
	public void setJieSuanDanModel(String id, String dingdanhao, String chezhuxingming,
			String huowumingcheng, String lingkuanshijian, String kehudanwei) {
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.chezhuxingming = chezhuxingming;
		this.huowumingcheng = huowumingcheng;
		this.lingkuanshijian = lingkuanshijian;
		this.kehudanwei = kehudanwei;
	}
	
	/**
	 * 	get set
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDingdanhao() {
		return dingdanhao;
	}
	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}
	public String getChezhuxingming() {
		return chezhuxingming;
	}
	public void setChezhuxingming(String chezhuxingming) {
		this.chezhuxingming = chezhuxingming;
	}
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	public String getLingkuanshijian() {
		return lingkuanshijian;
	}
	public void setLingkuanshijian(String lingkuanshijian) {
		this.lingkuanshijian = lingkuanshijian;
	}
	public String getKehudanwei() {
		return kehudanwei;
	}
	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}
	
	
}
