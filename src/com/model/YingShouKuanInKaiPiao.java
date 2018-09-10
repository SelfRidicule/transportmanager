package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.CheLiang;
import com.entity.YingShouKuan;
import com.entity.YunDan;
import com.myutils.FontFormat;
import com.service.CheLiangService;
import com.service.YingShouKuanService;
import com.service.YunDanService;

/**
 *  营收款 开票
 */
public class YingShouKuanInKaiPiao {
	/**
	 * 构造方法
	 */
	public YingShouKuanInKaiPiao() {
		super();
	}

	public YingShouKuanInKaiPiao(String xuhao, String dingdanhao,
			String chepaihao, String chengyunren, Double kaipiaojine,
			Double shuijin, Double guanlifei, Double shifuyunfei,
			Double daidianfei, String beizhu, Double shishouyunfei) {
		super();
		this.xuhao = xuhao;
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.chengyunren = chengyunren;
		this.kaipiaojine = kaipiaojine;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.daidianfei = daidianfei;
		this.beizhu = beizhu;
		this.shishouyunfei = shishouyunfei;
	}

	/**
	 * 属性
	 */
	private String xuhao;	//序号
	private String dingdanhao;	//订单号
	private String chepaihao;	//车牌号
	private String chengyunren;	//承运人
	private Double kaipiaojine;	//开票金额
	private Double shuijin;	//税金
	private Double guanlifei;	//管理费
	private Double shifuyunfei;	//实付运费
	private Double daidianfei;	//代垫费
	private String beizhu;	//备注
	private Double shishouyunfei;	//实收运费
	
	private Double zuchefei;	//租车费
	private Double yewufei;	//业务费
	
	private Double yingshou;	//营收
	
	/**
	 *  赋值方法
	 */
	public void  setYingShouKuanInKaiPiao(String xuhao, String dingdanhao,
			String chepaihao, String chengyunren, Double kaipiaojine,
			Double shuijin, Double guanlifei, Double shifuyunfei,
			Double daidianfei, String beizhu, Double shishouyunfei) {
		this.xuhao = xuhao;
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.chengyunren = chengyunren;
		this.kaipiaojine = kaipiaojine;
		this.shuijin = shuijin;
		this.guanlifei = guanlifei;
		this.shifuyunfei = shifuyunfei;
		this.daidianfei = daidianfei;
		this.beizhu = beizhu;
		this.shishouyunfei = shishouyunfei;
	}
	
	/**
	 *  得到营收款 开票集合对象
	 */
	public static List<YingShouKuanInKaiPiao> getYingShouKuanInKaiPiaoList(List<YingShouKuan> yingshoukuanlist){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		营收款 业务对象
		YingShouKuanService ysks = (YingShouKuanService) ac.getBean("yingShouKuanService");	
//		运单 业务对象
		YunDanService yds = (YunDanService) ac.getBean("yunDanService");
//		车辆 业务对象
		CheLiangService cls = (CheLiangService) ac.getBean("cheLiangService");
		
		List<YingShouKuanInKaiPiao> yingshoukuaninkaipiaolist = new ArrayList<YingShouKuanInKaiPiao>();
		
		for (int i = 0; i < yingshoukuanlist.size(); i++) {
//			序号
			String xuhao = String.valueOf(i+1);
//			营收款对象
			YingShouKuan yingshoukuan = yingshoukuanlist.get(i);
//			订单号
			String dingdanhao = yingshoukuan.getDingdanhao();
//			运单对象
			YunDan yundan = yds.queryYunDanDingDanHao(dingdanhao);
//			车牌号
			String chepaihao = "";
			if(yundan != null){
				chepaihao = yundan.getChepaihao();
			}
			
//			车辆对象
			CheLiang cheliang = cls.queryChePaiHaoCheLiang(chepaihao);
//			承运人
			String chengyunren = "";
			if(cheliang != null){
				chengyunren = cheliang.getChezhuxingming();
			}
			
//			税金
			Double shuijin =   0.0;
			if("".equals(yingshoukuan.getShuijin()) || yingshoukuan.getShuijin()==null ){
			}else{
				shuijin =  Double.valueOf( yingshoukuan.getShuijin() ) ;
			}
//			管理费    
			Double guanlifei = 0.0 ;
			if("".equals(yingshoukuan.getGuanlifei()) || yingshoukuan.getGuanlifei()==null ){
			}else{
				guanlifei = Double.valueOf( yingshoukuan.getGuanlifei() ) ;
			}
//			实付运费
			Double shifuyunfei = 0.0 ;
			if("".equals(yingshoukuan.getShifuyunfei()) || yingshoukuan.getShifuyunfei()==null ){
			}else{
				shifuyunfei = Double.valueOf( yingshoukuan.getShifuyunfei() ) ;
			}
//			代垫费
			Double daidianfei = 0.0;
			if("".equals(yundan.getDaidianfei()) || yundan.getDaidianfei()==null ){
			}else{
				daidianfei = Double.valueOf( yundan.getDaidianfei() );
			}

//			备注
			String beizhu = yingshoukuan.getBeizhu();	
//			实收运费
			Double shishouyunfei = 0.0;
			if("".equals(yundan.getShishouyunfei()) || yundan.getShishouyunfei()==null ){
			}else{
				shishouyunfei = Double.valueOf( yundan.getShishouyunfei() );
			}
			
			Double zuchefei = 0.0;
			Double yewufei = 0.0;
			try {
				zuchefei = Double.valueOf( yingshoukuan.getZuchefei() );
			} catch (Exception e) {
			}
			try {
				yewufei = Double.valueOf( yingshoukuan.getYewufei() );
			} catch (Exception e) {
			}	
			
			
//			营收
			Double yingshou = 0.0;
			if("".equals(yingshoukuan.getYingshou()) || yingshoukuan.getYingshou()==null ){
			}else{
				yingshou = Double.valueOf( yingshoukuan.getYingshou() );
			}
			
//			开票金额
			Double kaipiaojine = yingshou;
			
//			创建营收款 开票对象
			YingShouKuanInKaiPiao yingshoukuaninkaipiao = new YingShouKuanInKaiPiao();
			yingshoukuaninkaipiao.setYingShouKuanInKaiPiao( xuhao,  dingdanhao,
					 chepaihao,  chengyunren,  kaipiaojine,
					 shuijin,  guanlifei,  shifuyunfei,
					 daidianfei,  beizhu, shishouyunfei);
			
			yingshoukuaninkaipiao.setZuchefei(zuchefei);
			yingshoukuaninkaipiao.setYewufei(yewufei);
			
			yingshoukuaninkaipiao.setYingshou(yingshou);
			
//			向集合添加
			yingshoukuaninkaipiaolist.add(yingshoukuaninkaipiao);
		}
		
		return yingshoukuaninkaipiaolist;
	}

	
	/**
	 *  get set
	 */
	public String getXuhao() {
		return xuhao;
	}

	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}

	public String getDingdanhao() {
		return dingdanhao;
	}

	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}

	public String getChepaihao() {
		return chepaihao;
	}

	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}

	public String getChengyunren() {
		return chengyunren;
	}

	public void setChengyunren(String chengyunren) {
		this.chengyunren = chengyunren;
	}

	public Double getKaipiaojine() {
		return kaipiaojine;
	}

	public void setKaipiaojine(Double kaipiaojine) {
		this.kaipiaojine = kaipiaojine;
	}

	public Double getShuijin() {
		return shuijin;
	}

	public void setShuijin(Double shuijin) {
		this.shuijin = shuijin;
	}

	public Double getGuanlifei() {
		return guanlifei;
	}

	public void setGuanlifei(Double guanlifei) {
		this.guanlifei = guanlifei;
	}

	public Double getShifuyunfei() {
		return shifuyunfei;
	}

	public void setShifuyunfei(Double shifuyunfei) {
		this.shifuyunfei = shifuyunfei;
	}

	public Double getDaidianfei() {
		return daidianfei;
	}

	public void setDaidianfei(Double daidianfei) {
		this.daidianfei = daidianfei;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Double getShishouyunfei() {
		return shishouyunfei;
	}

	public void setShishouyunfei(Double shishouyunfei) {
		this.shishouyunfei = shishouyunfei;
	}

	public Double getZuchefei() {
		return zuchefei;
	}

	public void setZuchefei(Double zuchefei) {
		this.zuchefei = zuchefei;
	}

	public Double getYewufei() {
		return yewufei;
	}

	public void setYewufei(Double yewufei) {
		this.yewufei = yewufei;
	}

	public Double getYingshou() {
		return yingshou;
	}

	public void setYingshou(Double yingshou) {
		this.yingshou = yingshou;
	}
	
	
}
