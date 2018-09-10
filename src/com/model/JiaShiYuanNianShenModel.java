package com.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.JiaShiYuan;
import com.entity.YunDan;

/**
 * 驾驶员年审 模板类
 */
public class JiaShiYuanNianShenModel {
	/**
	 * 构造方法
	 */
	public JiaShiYuanNianShenModel() {
		super();
	}

	public JiaShiYuanNianShenModel(String id, String jiashiyuanxingming,
			String nianshenzhuangtai, String chepaihao,
			String congyezigeleibie, String shenfenzhenghao,
			String zhunjiachexing, String jiashizhengnianshenriqi,
			String zhengjianyouxiaoriqi, String congyezigeriqi,
			String congyezigejixujiaoyushijian,
			String congyezigejixujiaoyushijianzhi,
			String congyezigechengxinkaoheshijian) {
		super();
		this.id = id;
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.nianshenzhuangtai = nianshenzhuangtai;
		this.chepaihao = chepaihao;
		this.congyezigeleibie = congyezigeleibie;
		this.shenfenzhenghao = shenfenzhenghao;
		this.zhunjiachexing = zhunjiachexing;
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
		this.congyezigeriqi = congyezigeriqi;
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
	}

	/**
	 * 属性
	 */
	private String id;
	private String jiashiyuanxingming;	//驾驶员姓名
	private String nianshenzhuangtai;	//年审状态
	private String chepaihao;			//车牌号
	private String congyezigeleibie;	//从业资格类别
	private String shenfenzhenghao;		//身份证号
	private String zhunjiachexing;		//准驾车型
	private String jiashizhengnianshenriqi;	//驾驶证年审日期
	private String zhengjianyouxiaoriqi;	//证件有效日期
	private String congyezigeriqi;		//从业资格日期
	private String congyezigejixujiaoyushijian;	//从业资格继续教育时间
	private String congyezigejixujiaoyushijianzhi;	//从业资格继续教育时间止
	private String congyezigechengxinkaoheshijian;	//从业资格诚信考核时间
	
	
	
	/**
	 *  得到驾驶员年审集合
	 */
	public static List<JiaShiYuanNianShenModel> getJiaShiYuanNianShenModelList( List<JiaShiYuan> jiashiyuannianshenlist , String sendNianshenzhuangtai){
//		得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<JiaShiYuanNianShenModel> list = new ArrayList<JiaShiYuanNianShenModel>();
		
		for (int i = 0; i < jiashiyuannianshenlist.size(); i++) {
			JiaShiYuan jiashiyuan = jiashiyuannianshenlist.get(i);
			
			String id = String.valueOf(jiashiyuan.getId());
			
			String path =request.getContextPath()+"/"+"jiaShiYuanNianShenXiangXi?id="+id;
			String jiashiyuanxingming = "<a href=\""+path+"\">"+jiashiyuan.getJiashiyuanxingming()+"</a>";
			
			String chepaihao = jiashiyuan.getJiashicheliang();
			
			String congyezigeleibie = jiashiyuan.getCongyezigeleibie();	//从业资格类别
			
			String shenfenzhenghao = jiashiyuan.getShenfenzhenghao();	//身份证号
			
			String zhunjiachexing = jiashiyuan.getZhunjiachexing();	//准驾车型
			
			
			String nianshenzhuangtai = "正常";
			 
			 Calendar cal = Calendar.getInstance();
			 
			 Date  currentDate = new Date();
			 
			 cal.setTime(currentDate);
			 cal.add(Calendar.DATE, 30);
			 Date addDate = cal.getTime();
			
			 String jiashizhengnianshenriqi = "";	//驾驶证年审日期
			 Date jiashizhengnianshenriqiDate = jiashiyuan.getJiashizhengnianshenriqi();
			 if(jiashizhengnianshenriqiDate != null){
				 jiashizhengnianshenriqi = sdf.format(jiashizhengnianshenriqiDate);
				 
				 String  temporary = jiashizhengnianshenriqi;
				 
				 if(currentDate.after( jiashizhengnianshenriqiDate )){
					 temporary = "<span style=\"color: red;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( jiashizhengnianshenriqiDate.after(currentDate)  && addDate.after(jiashizhengnianshenriqiDate)){
					 temporary = jiashizhengnianshenriqi;
					 temporary = "<span style=\"color: #A52A2A;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "预警"; 
				 }
				 
				 jiashizhengnianshenriqi = temporary;
			 }
			 
			 String zhengjianyouxiaoriqi = "";	//证件有效日期
			 Date zhengjianyouxiaoriqiDate = jiashiyuan.getZhengjianyouxiaoriqi();
			 if(zhengjianyouxiaoriqiDate != null){
				 zhengjianyouxiaoriqi = sdf.format( zhengjianyouxiaoriqiDate );
				 
				 String  temporary = zhengjianyouxiaoriqi;
				 
				 if(currentDate.after( zhengjianyouxiaoriqiDate )){
					 temporary = "<span style=\"color: red;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( zhengjianyouxiaoriqiDate.after(currentDate)  && addDate.after(zhengjianyouxiaoriqiDate)){
					 temporary = zhengjianyouxiaoriqi;
					 temporary = "<span style=\"color: #A52A2A;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "预警"; 
				 }
				 
				 zhengjianyouxiaoriqi = temporary;
			 }
			
			 String   congyezigeriqi = "";	//从业资格证有效期至
			 Date congyezigeriqiDate = jiashiyuan.getCongyezigeriqi();
			 if(congyezigeriqiDate != null){
				 congyezigeriqi = sdf.format( congyezigeriqiDate );
				 
				 String  temporary = congyezigeriqi;
				 
				 if(currentDate.after( congyezigeriqiDate )){
					 temporary = "<span style=\"color: red;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( congyezigeriqiDate.after(currentDate)  && addDate.after(congyezigeriqiDate)){
					 temporary = congyezigeriqi;
					 temporary = "<span style=\"color: #A52A2A;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "预警"; 
				 }
				 
				 congyezigeriqi = temporary;
			 }
			 
			 String congyezigejixujiaoyushijian = "";	//从业资格继续教育时间
			 Date congyezigejixujiaoyushijianDate = jiashiyuan.getCongyezigejixujiaoyushijian();
			 if( congyezigejixujiaoyushijianDate != null){
				 congyezigejixujiaoyushijian = sdf.format( congyezigejixujiaoyushijianDate );
				 
				 if( currentDate.after( congyezigejixujiaoyushijianDate ) ){
					 congyezigejixujiaoyushijian = "<span style=\"color: #A52A2A;\">"+ congyezigejixujiaoyushijian +"</span>" ;
					 nianshenzhuangtai = "预警";
				 }
			 }
			 
			 String congyezigejixujiaoyushijianzhi = "";	//从业资格继续教育时间止
			 Date congyezigejixujiaoyushijianzhiDate = jiashiyuan.getCongyezigejixujiaoyushijianzhi();
			 if(congyezigejixujiaoyushijianzhiDate != null){
				 congyezigejixujiaoyushijianzhi = sdf.format( congyezigejixujiaoyushijianzhiDate );
				 
				 if( congyezigejixujiaoyushijianzhiDate.after(currentDate)  && addDate.after(congyezigejixujiaoyushijianzhiDate)){
					 congyezigejixujiaoyushijianzhi = "<span style=\"color: Chocolate ;\">"+ congyezigejixujiaoyushijianzhi +"</span>" ;
					 nianshenzhuangtai = "报警"; 
				 }
				 
			 }
			 
			 String congyezigechengxinkaoheshijian = "";	//从业资格诚信考核时间
			 Date congyezigechengxinkaoheshijianDate =  jiashiyuan.getCongyezigechengxinkaoheshijian();
			 if( congyezigechengxinkaoheshijianDate != null){
				 congyezigechengxinkaoheshijian = sdf.format( congyezigechengxinkaoheshijianDate );
				 
				 String  temporary = congyezigechengxinkaoheshijian;
				 
				 if(currentDate.after( congyezigechengxinkaoheshijianDate )){
					 temporary = "<span style=\"color: red;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( congyezigechengxinkaoheshijianDate.after(currentDate)  && addDate.after(congyezigechengxinkaoheshijianDate)){
					 temporary = congyezigechengxinkaoheshijian;
					 temporary = "<span style=\"color: #A52A2A;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "预警"; 
				 }
				 
				 congyezigechengxinkaoheshijian = temporary;
			 }
			 
			 JiaShiYuanNianShenModel model = new JiaShiYuanNianShenModel();
			 model.setJiaShiYuanNianShenModel( id,  jiashiyuanxingming,
						 nianshenzhuangtai,  chepaihao,
						 congyezigeleibie,  shenfenzhenghao,
						 zhunjiachexing,  jiashizhengnianshenriqi,
						 zhengjianyouxiaoriqi,  congyezigeriqi,
						 congyezigejixujiaoyushijian,
						 congyezigejixujiaoyushijianzhi,
						 congyezigechengxinkaoheshijian);
			 
			 list.add(model);
		}
		
		
		if(sendNianshenzhuangtai != null && !"".equals(sendNianshenzhuangtai)){
			for (int i = 0; i < list.size(); i++) {
				if( ! sendNianshenzhuangtai.equals( list.get(i).getNianshenzhuangtai() ) ){
					
					list.remove(i);
					--i;
				}
			}
		}
		
		return list;
	}
	
	/**
	 *  得到门户-驾驶员年审集合
	 */
	public static List<JiaShiYuanNianShenModel> getMenHuJiaShiYuanNianShenModelList( List<JiaShiYuan> jiashiyuannianshenlist){
//		得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<JiaShiYuanNianShenModel> list = new ArrayList<JiaShiYuanNianShenModel>();
		
		
		for (int i = 0; i < jiashiyuannianshenlist.size(); i++) {
			
			JiaShiYuan jiashiyuan = jiashiyuannianshenlist.get(i);
			
			String id = String.valueOf(jiashiyuan.getId());
			
			String path =request.getContextPath()+"/jumpJiaShiYuanNianShen" ;
			String jiashiyuanxingming = "<a href=\""+path+"\">"+jiashiyuan.getJiashiyuanxingming()+"</a>";
			
			String chepaihao = jiashiyuan.getJiashicheliang();
			
			String congyezigeleibie = jiashiyuan.getCongyezigeleibie();	//从业资格类别
			
			String shenfenzhenghao = jiashiyuan.getShenfenzhenghao();	//身份证号
			
			String zhunjiachexing = jiashiyuan.getZhunjiachexing();	//准驾车型
			
			
			String nianshenzhuangtai = "正常";
			 
			 Calendar cal = Calendar.getInstance();
			 
			 Date  currentDate = new Date();
			 
			 cal.setTime(currentDate);
			 cal.add(Calendar.DATE, 30);
			 Date addDate = cal.getTime();
			
			 String jiashizhengnianshenriqi = "";	//驾驶证年审日期
			 Date jiashizhengnianshenriqiDate = jiashiyuan.getJiashizhengnianshenriqi();
			 if(jiashizhengnianshenriqiDate != null){
				 jiashizhengnianshenriqi = sdf.format(jiashizhengnianshenriqiDate);
				 
				 String  temporary = jiashizhengnianshenriqi;
				 
				 if(currentDate.after( jiashizhengnianshenriqiDate )){
					 temporary = "<span style=\"color: red;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( jiashizhengnianshenriqiDate.after(currentDate)  && addDate.after(jiashizhengnianshenriqiDate)){
					 temporary = jiashizhengnianshenriqi;
					 temporary = "<span style=\"color: #A52A2A;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "预警"; 
				 }
				 
				 jiashizhengnianshenriqi = temporary;
			 }
			 
			 String zhengjianyouxiaoriqi = "";	//证件有效日期
			 Date zhengjianyouxiaoriqiDate = jiashiyuan.getZhengjianyouxiaoriqi();
			 if(zhengjianyouxiaoriqiDate != null){
				 zhengjianyouxiaoriqi = sdf.format( zhengjianyouxiaoriqiDate );
				 
				 String  temporary = zhengjianyouxiaoriqi;
				 
				 if(currentDate.after( zhengjianyouxiaoriqiDate )){
					 temporary = "<span style=\"color: red;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( zhengjianyouxiaoriqiDate.after(currentDate)  && addDate.after(zhengjianyouxiaoriqiDate)){
					 temporary = zhengjianyouxiaoriqi;
					 temporary = "<span style=\"color: #A52A2A;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "预警"; 
				 }
				 
				 zhengjianyouxiaoriqi = temporary;
			 }
			
			 String   congyezigeriqi = "";	//从业资格证有效期至
			 Date congyezigeriqiDate = jiashiyuan.getCongyezigeriqi();
			 if(congyezigeriqiDate != null){
				 congyezigeriqi = sdf.format( congyezigeriqiDate );
				 
				 String  temporary = congyezigeriqi;
				 
				 if(currentDate.after( congyezigeriqiDate )){
					 temporary = "<span style=\"color: red;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( congyezigeriqiDate.after(currentDate)  && addDate.after(congyezigeriqiDate)){
					 temporary = congyezigeriqi;
					 temporary = "<span style=\"color: #A52A2A;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "预警"; 
				 }
				 
				 congyezigeriqi = temporary;
			 }
			 
			 String congyezigejixujiaoyushijian = "";	//从业资格继续教育时间
			 Date congyezigejixujiaoyushijianDate = jiashiyuan.getCongyezigejixujiaoyushijian();
			 if( congyezigejixujiaoyushijianDate != null){
				 congyezigejixujiaoyushijian = sdf.format( congyezigejixujiaoyushijianDate );
				 
				 if( currentDate.after( congyezigejixujiaoyushijianDate ) ){
					 congyezigejixujiaoyushijian = "<span style=\"color: #A52A2A;\">"+ congyezigejixujiaoyushijian +"</span>" ;
					 nianshenzhuangtai = "预警";
				 }
			 }
			 
			 String congyezigejixujiaoyushijianzhi = "";	//从业资格继续教育时间止
			 Date congyezigejixujiaoyushijianzhiDate = jiashiyuan.getCongyezigejixujiaoyushijianzhi();
			 if(congyezigejixujiaoyushijianzhiDate != null){
				 congyezigejixujiaoyushijianzhi = sdf.format( congyezigejixujiaoyushijianzhiDate );
				 
				 if( congyezigejixujiaoyushijianzhiDate.after(currentDate)  && addDate.after(congyezigejixujiaoyushijianzhiDate)){
					 congyezigejixujiaoyushijianzhi = "<span style=\"color: Chocolate ;\">"+ congyezigejixujiaoyushijianzhi +"</span>" ;
					 nianshenzhuangtai = "报警"; 
				 }
				 
			 }
			 
			 String congyezigechengxinkaoheshijian = "";	//从业资格诚信考核时间
			 Date congyezigechengxinkaoheshijianDate =  jiashiyuan.getCongyezigechengxinkaoheshijian();
			 if( congyezigechengxinkaoheshijianDate != null){
				 congyezigechengxinkaoheshijian = sdf.format( congyezigechengxinkaoheshijianDate );
				 
				 String  temporary = congyezigechengxinkaoheshijian;
				 
				 if(currentDate.after( congyezigechengxinkaoheshijianDate )){
					 temporary = "<span style=\"color: red;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( congyezigechengxinkaoheshijianDate.after(currentDate)  && addDate.after(congyezigechengxinkaoheshijianDate)){
					 temporary = congyezigechengxinkaoheshijian;
					 temporary = "<span style=\"color: #A52A2A;\">"+ temporary +"</span>" ;
					 nianshenzhuangtai = "预警"; 
				 }
				 
				 congyezigechengxinkaoheshijian = temporary;
			 }
			 
			 JiaShiYuanNianShenModel model = new JiaShiYuanNianShenModel();
			 model.setJiaShiYuanNianShenModel( id,  jiashiyuanxingming,
						 nianshenzhuangtai,  chepaihao,
						 congyezigeleibie,  shenfenzhenghao,
						 zhunjiachexing,  jiashizhengnianshenriqi,
						 zhengjianyouxiaoriqi,  congyezigeriqi,
						 congyezigejixujiaoyushijian,
						 congyezigejixujiaoyushijianzhi,
						 congyezigechengxinkaoheshijian);
			 
			 list.add(model);
		}
		
		
		for (int i = 0; i < list.size(); i++) {
			String nianshenzhuangtai = list.get(i).getNianshenzhuangtai();
			
			if("正常".equals(nianshenzhuangtai)){
				list.remove(i);
				--i;
			}
		}
		
		if(list.size()>5){
			
			for (int i = 5; i < list.size(); i++) {
				list.remove(i);
				--i;
			}
			
		}
		
		
		return list;
	}
	
	
	/**
	 *  导出驾驶员年审集合
	 */
	public static List<JiaShiYuanNianShenModel> exportJiaShiYuanNianShenModelList( List<JiaShiYuan> jiashiyuannianshenlist , String sendNianshenzhuangtai){
//		得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<JiaShiYuanNianShenModel> list = new ArrayList<JiaShiYuanNianShenModel>();
		
		for (int i = 0; i < jiashiyuannianshenlist.size(); i++) {
			JiaShiYuan jiashiyuan = jiashiyuannianshenlist.get(i);
			
			String id = String.valueOf(jiashiyuan.getId());
			
			String jiashiyuanxingming = jiashiyuan.getJiashiyuanxingming();
			
			String chepaihao = jiashiyuan.getJiashicheliang();
			
			String congyezigeleibie = jiashiyuan.getCongyezigeleibie();	//从业资格类别
			
			String shenfenzhenghao = jiashiyuan.getShenfenzhenghao();	//身份证号
			
			String zhunjiachexing = jiashiyuan.getZhunjiachexing();	//准驾车型
			
			
			String nianshenzhuangtai = "";
			 
			 Calendar cal = Calendar.getInstance();
			 
			 Date  currentDate = new Date();
			 
			 cal.setTime(currentDate);
			 cal.add(Calendar.DATE, 30);
			 Date addDate = cal.getTime();
			
			 String jiashizhengnianshenriqi = "";	//驾驶证年审日期
			 Date jiashizhengnianshenriqiDate = jiashiyuan.getJiashizhengnianshenriqi();
			 if(jiashizhengnianshenriqiDate != null){
				 jiashizhengnianshenriqi = sdf.format(jiashizhengnianshenriqiDate);
				 
				 if(currentDate.after( jiashizhengnianshenriqiDate )){
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( jiashizhengnianshenriqiDate.after(currentDate)  && addDate.after(jiashizhengnianshenriqiDate)){
					 nianshenzhuangtai = "预警"; 
				 }
				 
			 }
			 
			 String zhengjianyouxiaoriqi = "";	//证件有效日期
			 Date zhengjianyouxiaoriqiDate = jiashiyuan.getZhengjianyouxiaoriqi();
			 if(zhengjianyouxiaoriqiDate != null){
				 zhengjianyouxiaoriqi = sdf.format( zhengjianyouxiaoriqiDate );
				 
				 if(currentDate.after( zhengjianyouxiaoriqiDate )){
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( zhengjianyouxiaoriqiDate.after(currentDate)  && addDate.after(zhengjianyouxiaoriqiDate)){
					 nianshenzhuangtai = "预警"; 
				 }
				 
			 }
			
			 String   congyezigeriqi = "";	//从业资格证有效期至
			 Date congyezigeriqiDate = jiashiyuan.getCongyezigeriqi();
			 if(congyezigeriqiDate != null){
				 congyezigeriqi = sdf.format( congyezigeriqiDate );
				 
				 if(currentDate.after( congyezigeriqiDate )){
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( congyezigeriqiDate.after(currentDate)  && addDate.after(congyezigeriqiDate)){
					 nianshenzhuangtai = "预警"; 
				 }
				 
			 }
			 
			 String congyezigejixujiaoyushijian = "";	//从业资格继续教育时间
			 Date congyezigejixujiaoyushijianDate = jiashiyuan.getCongyezigejixujiaoyushijian();
			 if( congyezigejixujiaoyushijianDate != null){
				 congyezigejixujiaoyushijian = sdf.format( congyezigejixujiaoyushijianDate );
				 
				 if( currentDate.after( congyezigejixujiaoyushijianDate ) ){
					 nianshenzhuangtai = "预警";
				 }
			 }
			 
			 String congyezigejixujiaoyushijianzhi = "";	//从业资格继续教育时间止
			 Date congyezigejixujiaoyushijianzhiDate = jiashiyuan.getCongyezigejixujiaoyushijianzhi();
			 if(congyezigejixujiaoyushijianzhiDate != null){
				 congyezigejixujiaoyushijianzhi = sdf.format( congyezigejixujiaoyushijianzhiDate );
				 
				 if( congyezigejixujiaoyushijianzhiDate.after(currentDate)  && addDate.after(congyezigejixujiaoyushijianzhiDate)){
					 nianshenzhuangtai = "报警"; 
				 }
				 
			 }
			 
			 String congyezigechengxinkaoheshijian = "";	//从业资格诚信考核时间
			 Date congyezigechengxinkaoheshijianDate =  jiashiyuan.getCongyezigechengxinkaoheshijian();
			 if( congyezigechengxinkaoheshijianDate != null){
				 congyezigechengxinkaoheshijian = sdf.format( congyezigechengxinkaoheshijianDate );
				 
				 if(currentDate.after( congyezigechengxinkaoheshijianDate )){
					 nianshenzhuangtai = "超期";
				 }
				 
				 if( congyezigechengxinkaoheshijianDate.after(currentDate)  && addDate.after(congyezigechengxinkaoheshijianDate)){
					 nianshenzhuangtai = "预警"; 
				 }
				 
			 }
			 
			 JiaShiYuanNianShenModel model = new JiaShiYuanNianShenModel();
			 model.setJiaShiYuanNianShenModel( id,  jiashiyuanxingming,
						 nianshenzhuangtai,  chepaihao,
						 congyezigeleibie,  shenfenzhenghao,
						 zhunjiachexing,  jiashizhengnianshenriqi,
						 zhengjianyouxiaoriqi,  congyezigeriqi,
						 congyezigejixujiaoyushijian,
						 congyezigejixujiaoyushijianzhi,
						 congyezigechengxinkaoheshijian);
			 
			 list.add(model);
		}
		
		
		if(sendNianshenzhuangtai != null && !"".equals(sendNianshenzhuangtai)){
			for (int i = 0; i < list.size(); i++) {
				if( ! sendNianshenzhuangtai.equals( list.get(i).getNianshenzhuangtai() ) ){
					
					list.remove(i);
					--i;
				}
			}
		}
		
		return list;
	}
	
	
	/**
	 * 赋值方法
	 */
	public void setJiaShiYuanNianShenModel(String id, String jiashiyuanxingming,
			String nianshenzhuangtai, String chepaihao,
			String congyezigeleibie, String shenfenzhenghao,
			String zhunjiachexing, String jiashizhengnianshenriqi,
			String zhengjianyouxiaoriqi, String congyezigeriqi,
			String congyezigejixujiaoyushijian,
			String congyezigejixujiaoyushijianzhi,
			String congyezigechengxinkaoheshijian) {
		this.id = id;
		this.jiashiyuanxingming = jiashiyuanxingming;
		this.nianshenzhuangtai = nianshenzhuangtai;
		this.chepaihao = chepaihao;
		this.congyezigeleibie = congyezigeleibie;
		this.shenfenzhenghao = shenfenzhenghao;
		this.zhunjiachexing = zhunjiachexing;
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
		this.congyezigeriqi = congyezigeriqi;
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
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
	public String getJiashiyuanxingming() {
		return jiashiyuanxingming;
	}
	public void setJiashiyuanxingming(String jiashiyuanxingming) {
		this.jiashiyuanxingming = jiashiyuanxingming;
	}
	public String getNianshenzhuangtai() {
		return nianshenzhuangtai;
	}
	public void setNianshenzhuangtai(String nianshenzhuangtai) {
		this.nianshenzhuangtai = nianshenzhuangtai;
	}
	public String getChepaihao() {
		return chepaihao;
	}
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	public String getCongyezigeleibie() {
		return congyezigeleibie;
	}
	public void setCongyezigeleibie(String congyezigeleibie) {
		this.congyezigeleibie = congyezigeleibie;
	}
	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}
	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}
	public String getZhunjiachexing() {
		return zhunjiachexing;
	}
	public void setZhunjiachexing(String zhunjiachexing) {
		this.zhunjiachexing = zhunjiachexing;
	}
	public String getJiashizhengnianshenriqi() {
		return jiashizhengnianshenriqi;
	}
	public void setJiashizhengnianshenriqi(String jiashizhengnianshenriqi) {
		this.jiashizhengnianshenriqi = jiashizhengnianshenriqi;
	}
	public String getZhengjianyouxiaoriqi() {
		return zhengjianyouxiaoriqi;
	}
	public void setZhengjianyouxiaoriqi(String zhengjianyouxiaoriqi) {
		this.zhengjianyouxiaoriqi = zhengjianyouxiaoriqi;
	}
	public String getCongyezigeriqi() {
		return congyezigeriqi;
	}
	public void setCongyezigeriqi(String congyezigeriqi) {
		this.congyezigeriqi = congyezigeriqi;
	}
	public String getCongyezigejixujiaoyushijian() {
		return congyezigejixujiaoyushijian;
	}
	public void setCongyezigejixujiaoyushijian(String congyezigejixujiaoyushijian) {
		this.congyezigejixujiaoyushijian = congyezigejixujiaoyushijian;
	}
	public String getCongyezigejixujiaoyushijianzhi() {
		return congyezigejixujiaoyushijianzhi;
	}
	public void setCongyezigejixujiaoyushijianzhi(
			String congyezigejixujiaoyushijianzhi) {
		this.congyezigejixujiaoyushijianzhi = congyezigejixujiaoyushijianzhi;
	}
	public String getCongyezigechengxinkaoheshijian() {
		return congyezigechengxinkaoheshijian;
	}
	public void setCongyezigechengxinkaoheshijian(
			String congyezigechengxinkaoheshijian) {
		this.congyezigechengxinkaoheshijian = congyezigechengxinkaoheshijian;
	}
	
}
