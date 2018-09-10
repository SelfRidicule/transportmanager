package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.JinDu;
import com.entity.QuanXian;
import com.entity.XinChe;
import com.service.JinDuService;
import com.service.XinCheService;

/**
 *  新车模版类
 */
public class XinCheModel {
	/**
	 * 构造方法
	 */
	public XinCheModel() {
		super();
	}
	
	public XinCheModel(String id, String bianhao, String chepaihao,
			String zhuceriqi, String caozuoyuan, String jindu,
			String banlizhuangtai) {
		super();
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.zhuceriqi = zhuceriqi;
		this.caozuoyuan = caozuoyuan;
		this.jindu = jindu;
		this.banlizhuangtai = banlizhuangtai;
	}

	/**
	 * 属性
	 */
	private String  id;	//id
	private String bianhao;	//编号
	private String chepaihao;	//车牌号
	private String   zhuceriqi;	//注册日期
	private String caozuoyuan;	//操作员
	private String jindu;	//进度
	private String banlizhuangtai; //办理状态
	
	/**
	 *  得到新车模版集合对象
	 */
	public static List<XinCheModel> getXinCheModelList(List<XinChe> xinchelist, HttpServletRequest request,HttpSession session){
		
//		加载applicationContext.xml文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");	
//		得到进度业务对象
		JinDuService jds =  (JinDuService) ac.getBean("jinDuService");
		
		List<QuanXian> usersquanxianlist = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		boolean flag = false ;
		if(usersquanxianlist != null){
			for (QuanXian quanXian : usersquanxianlist) {
				if("新车管理".equals(quanXian.getQuanxianbumen()) && "1".equals(quanXian.getWeihu()) ){
					flag=true;
					break;
				}
				
			}
		}
		
		
		List<XinCheModel> xinchemodellist = new ArrayList<XinCheModel>();
		
		for (int i = 0; i < xinchelist.size() ; i++) {
			
			XinChe xinche = xinchelist.get(i);
			String id = String.valueOf(xinche.getId());
			String chepaihao = xinche.getChepaihao();
			String zhuceriqi = xinche.getShijian().toString();
			try {
				zhuceriqi = zhuceriqi.substring(0,10);
			} catch (Exception e) {
			}
			
			String caozuoyuan = xinche.getCaozuoyuan();
			
			String path =request.getContextPath()+"/"+"xinCheXiangXi?chepaihao="+chepaihao;
			String bianhao = "<a href=\""+path+"\" target=\"_blank\">"+xinche.getBianhao()+"</a>";
			
			
			JinDu jinduobj = jds.queryJinDuInChePaiHao(chepaihao);
			String jindu =jinduobj.getDangqianjindu();
			
			
			String banlizhuangtai = xinche.getBanlizhuangtai();
			if(flag){
				String banlizhuangtaipath =request.getContextPath()+"/"+"jumpUpdateXinChe?chepaihao="+chepaihao;
				banlizhuangtai =  "<a href=\""+banlizhuangtaipath+"\">"+banlizhuangtai+"</a>";
			}
			
			XinCheModel xinchemodel = new XinCheModel();
			xinchemodel.setXinCheModel(id, bianhao, chepaihao, 
										zhuceriqi, caozuoyuan, jindu, banlizhuangtai);
			xinchemodellist.add(xinchemodel);
		}
		
		String dangqianjindu = (String) session.getAttribute("dangqianjindu");
		
		if(dangqianjindu==null || "".equals(dangqianjindu)){
		}else{
			
			for (int i = 0; i < xinchemodellist.size(); i++) {
				XinCheModel xinchemodel = xinchemodellist.get(i);
				String jindu = xinchemodel.getJindu();
				if(!dangqianjindu.equals(jindu)){
					xinchemodellist.remove(i);
					--i;
				}
			}
			
		}
		
		
		return xinchemodellist;
	}
	
	/**
	 *  得到门户新车模版集合对象
	 */
	public static List<XinCheModel> getMenHuXinCheModelList(List<XinChe> xinchelist, HttpServletRequest request,HttpSession session){
		
//		加载applicationContext.xml文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");	
//		得到进度业务对象
		JinDuService jds =  (JinDuService) ac.getBean("jinDuService");
		
		
		List<XinCheModel> xinchemodellist = new ArrayList<XinCheModel>();
		
		int index = 1;
		
		for (int i = 0; i < xinchelist.size() ; i++) {
			if(index>5){
				break;
			}
			index++;
			
			XinChe xinche = xinchelist.get(i);
			String id = String.valueOf(xinche.getId());
			String chepaihao = xinche.getChepaihao();
			String zhuceriqi = xinche.getShijian().toString();
			try {
				zhuceriqi = zhuceriqi.substring(0,10);
			} catch (Exception e) {
			}
			
			String caozuoyuan = xinche.getCaozuoyuan();
			
			String path =request.getContextPath()+"/jumpXinChe" ;
			String bianhao = "<a href=\""+path+"\">"+xinche.getBianhao()+"</a>";
			
			
			JinDu jinduobj = jds.queryJinDuInChePaiHao(chepaihao);
			String jindu =jinduobj.getDangqianjindu();
			
			
			String banlizhuangtai = xinche.getBanlizhuangtai();
			
			XinCheModel xinchemodel = new XinCheModel();
			xinchemodel.setXinCheModel(id, bianhao, chepaihao, 
										zhuceriqi, caozuoyuan, jindu, banlizhuangtai);
			xinchemodellist.add(xinchemodel);
		}
		
		
		
		return xinchemodellist;
	}
	
	
	/**
	 *  赋值
	 */
	public void setXinCheModel(String id, String bianhao, String chepaihao,
			String zhuceriqi, String caozuoyuan, String jindu,
			String banlizhuangtai) {
		this.id = id;
		this.bianhao = bianhao;
		this.chepaihao = chepaihao;
		this.zhuceriqi = zhuceriqi;
		this.caozuoyuan = caozuoyuan;
		this.jindu = jindu;
		this.banlizhuangtai = banlizhuangtai;
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
	public String getZhuceriqi() {
		return zhuceriqi;
	}
	public void setZhuceriqi(String zhuceriqi) {
		this.zhuceriqi = zhuceriqi;
	}
	public String getCaozuoyuan() {
		return caozuoyuan;
	}
	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}
	public String getJindu() {
		return jindu;
	}
	public void setJindu(String jindu) {
		this.jindu = jindu;
	}
	public String getBanlizhuangtai() {
		return banlizhuangtai;
	}
	public void setBanlizhuangtai(String banlizhuangtai) {
		this.banlizhuangtai = banlizhuangtai;
	}
	
}
