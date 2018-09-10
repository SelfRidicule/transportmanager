package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.YingShouKuan;
import com.entity.YunDan;
import com.service.CustomerService;
import com.service.YunDanService;

/**
 *  营收款 模版类
 */
public class YingShouKuanModel {
	/**
	 * 构造方法
	 */
	public YingShouKuanModel() {
		super();
	}

	public YingShouKuanModel(String id, String dingdanhao, String chepaihao,
			String huowumingcheng, String kehudanwei) {
		super();
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.huowumingcheng = huowumingcheng;
		this.kehudanwei = kehudanwei;
	}

	/**
	 * 属性
	 */
	private String id ;
	private String dingdanhao;
	private String chepaihao;
	private String huowumingcheng;
	private String kehudanwei;
	private String yingshoukuanzhuangtai;
	private String jiesuanzhuangtai;
	
	private String kaipiaoshenqing;//
	private String kaipiaoshenqingren;//

	private String fenguankaipiaoshenhe;//
	private String fenguankaipiaoshenheren;//
	
	private String zongjinglikaipiaoshenhe;//
	private String zongjinglikaipiaoshenheren;//
	
	private String jiesuanshenqing;//
	private String jiesuanshenqingren;//

	private String zongjinglijiesuanshenhe;//
	private String zongjinglijiesuanshenheren;//
	
	private String dongshizhangjiesuanshenhe;//
	private String dongshizhangjiesuanshenheren;//
	
	/**
	 *  赋值方法
	 */
	public void setYingShouKuanModel(String id, String dingdanhao, String chepaihao,
			String huowumingcheng, String kehudanwei,String yingshoukuanzhuangtai,String jiesuanzhuangtai) {
		this.id = id;
		this.dingdanhao = dingdanhao;
		this.chepaihao = chepaihao;
		this.huowumingcheng = huowumingcheng;
		this.kehudanwei = kehudanwei;
		this.yingshoukuanzhuangtai=yingshoukuanzhuangtai;
		this.jiesuanzhuangtai = jiesuanzhuangtai;
	}
	
	/**
	 *  得到营收款模版类 集合
	 */
	public static List<YingShouKuanModel> getYingShouKuanModelList(List<YingShouKuan> yingshoukuanlist , String yingshoukuanchepaihao , String yingshoukuanhuowumingcheng
																		, YunDanService yunDanService , CustomerService customerService
																	){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		加载applicationContext.xml文件
		
		
//		得到 CustomerService 对象
			
		
		List<YingShouKuanModel> yingshoukuanmodellist = new ArrayList<YingShouKuanModel>();
		
		

		for (int i = 0; i < yingshoukuanlist.size(); i++) {
			
			YingShouKuan yingshoukuan = yingshoukuanlist.get(i);
			
			String id = String.valueOf(yingshoukuan.getId());

			String dingdanhao = yingshoukuan.getDingdanhao();
			YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
			
			String xiangxipath =request.getContextPath()+"/"+"yingShouKuanXiangXi?dingdanhao="+dingdanhao;
			dingdanhao = "<a href=\""+xiangxipath+"\">"+dingdanhao+"</a>";
			
			String chepaihao = "";
			String huowumingcheng = "";
			if(yundan != null){
				chepaihao = yundan.getChepaihao();
				huowumingcheng = yundan.getHuowumingcheng();
			}
					
			String kehudanwei = "";
			kehudanwei = yingshoukuan.getKehudanwei();
			/*try {
				 Customer customer = customerService.queryKehudanwei(FormatValueClass.getFormatValueClass(yingshoukuan.getKehudanwei()));
				 if(customer != null){
					 kehudanwei = customer.getShortname();
				 }
			} catch (Exception e) {
			}*/
			
			
			String yingshoukuanzhuangtai = yingshoukuan.getYingshoukuanzhuangtai();
			String jiesuanzhuangtai = yingshoukuan.getJiesuanzhuangtai();
			
			YingShouKuanModel yingshoukuanmodel = new YingShouKuanModel();
			yingshoukuanmodel.setYingShouKuanModel(id, dingdanhao, chepaihao, huowumingcheng, kehudanwei,yingshoukuanzhuangtai ,jiesuanzhuangtai);
			
			yingshoukuanmodellist.add(yingshoukuanmodel);
		}
		
		if(yingshoukuanchepaihao == null || "".equals(yingshoukuanchepaihao)){
		}else{
			
			for (int i = 0; i < yingshoukuanmodellist.size(); i++) {
				YingShouKuanModel yingshoukuanmodel = yingshoukuanmodellist.get(i);
				
				if(!yingshoukuanchepaihao.equals(yingshoukuanmodel.getChepaihao())){
					yingshoukuanmodellist.remove(i);
					--i;
				}
				
			}
			
		}
		
		if(yingshoukuanhuowumingcheng == null || "".equals(yingshoukuanhuowumingcheng)){
		}else{
			
			for (int i = 0; i < yingshoukuanmodellist.size(); i++) {
				YingShouKuanModel yingshoukuanmodel = yingshoukuanmodellist.get(i);
				
				if(!yingshoukuanhuowumingcheng.equals(yingshoukuanmodel.getHuowumingcheng())){
					yingshoukuanmodellist.remove(i);
					--i;
				}
				
			}
			
		}
		
		return yingshoukuanmodellist;
	}
	
	
	/**
	 *  得到营收款模版类 集合
	 */
	public static List<YingShouKuanModel> getYingShouKuanModeMethodlList(List<YingShouKuan> yingshoukuanlist , String methodName , YunDanService yunDanService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		加载applicationContext.xml文件
		
		
		
		List<YingShouKuanModel> yingshoukuanmodellist = new ArrayList<YingShouKuanModel>();
		
		String yingshoukuanchepaihao = (String) session.getAttribute("yingshoukuanchepaihao");
		String yingshoukuanhuowumingcheng = (String) session.getAttribute("yingshoukuanhuowumingcheng");

		for (int i = 0; i < yingshoukuanlist.size(); i++) {
			
			YingShouKuan yingshoukuan = yingshoukuanlist.get(i);
			
			String id = String.valueOf(yingshoukuan.getId());

			String dingdanhao = yingshoukuan.getDingdanhao();
			YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
			
			String xiangxipath =request.getContextPath()+"/"+methodName +"?dingdanhao="+dingdanhao;
			dingdanhao = "<a href=\""+xiangxipath+"\">"+dingdanhao+"</a>";
			
			String chepaihao = "";
			String huowumingcheng = "";
			if(yundan != null){
				chepaihao = yundan.getChepaihao();
				huowumingcheng = yundan.getHuowumingcheng();
			}
					
			String kehudanwei = yingshoukuan.getKehudanwei();
			String yingshoukuanzhuangtai = yingshoukuan.getYingshoukuanzhuangtai();
			String jiesuanzhuangtai = yingshoukuan.getJiesuanzhuangtai();
			
			YingShouKuanModel yingshoukuanmodel = new YingShouKuanModel();
			yingshoukuanmodel.setYingShouKuanModel(id, dingdanhao, chepaihao, huowumingcheng, kehudanwei,yingshoukuanzhuangtai ,jiesuanzhuangtai);
			
			yingshoukuanmodellist.add(yingshoukuanmodel);
		}
		
		if(yingshoukuanchepaihao == null || "".equals(yingshoukuanchepaihao)){
		}else{
			
			for (int i = 0; i < yingshoukuanmodellist.size(); i++) {
				YingShouKuanModel yingshoukuanmodel = yingshoukuanmodellist.get(i);
				
				if(!yingshoukuanchepaihao.equals(yingshoukuanmodel.getChepaihao())){
					yingshoukuanmodellist.remove(i);
					--i;
				}
				
			}
			
		}
		
		if(yingshoukuanhuowumingcheng == null || "".equals(yingshoukuanhuowumingcheng)){
		}else{
			
			for (int i = 0; i < yingshoukuanmodellist.size(); i++) {
				YingShouKuanModel yingshoukuanmodel = yingshoukuanmodellist.get(i);
				
				if(!yingshoukuanhuowumingcheng.equals(yingshoukuanmodel.getHuowumingcheng())){
					yingshoukuanmodellist.remove(i);
					--i;
				}
				
			}
			
		}
		
		return yingshoukuanmodellist;
	}
	
	/**
	 *  得到营收款模版类 集合
	 */
	public static List<YingShouKuanModel> getYingShouInKaiPiaoModelList(List<YingShouKuan> yingshoukuanlist , YunDanService yunDanService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		加载applicationContext.xml文件
		
		
		
		List<YingShouKuanModel> yingshoukuanmodellist = new ArrayList<YingShouKuanModel>();
		
		for (int i = 0; i < yingshoukuanlist.size(); i++) {
			
			YingShouKuan yingshoukuan = yingshoukuanlist.get(i);
			
			String id = String.valueOf(yingshoukuan.getId());

			String dingdanhao = yingshoukuan.getDingdanhao();
			YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
			
			String xiangxipath =request.getContextPath()+"/"+"kaiPiaoShenQingXiangXi?dingdanhao="+dingdanhao;
			dingdanhao = "<a href=\""+xiangxipath+"\">"+dingdanhao+"</a>";
			
			String chepaihao = "";
			String huowumingcheng = "";
			if(yundan != null){
				chepaihao = yundan.getChepaihao();
				huowumingcheng = yundan.getHuowumingcheng();
			}
					
			String kehudanwei = yingshoukuan.getKehudanwei();
			String yingshoukuanzhuangtai = yingshoukuan.getYingshoukuanzhuangtai();
			String jiesuanzhuangtai = yingshoukuan.getJiesuanzhuangtai();
			
			String  kaipiaoshenqing = yingshoukuan.getKaipiaoshenqing();
			
			YingShouKuanModel yingshoukuanmodel = new YingShouKuanModel();
			yingshoukuanmodel.setYingShouKuanModel(id, dingdanhao, chepaihao, huowumingcheng, kehudanwei,yingshoukuanzhuangtai ,jiesuanzhuangtai);
			yingshoukuanmodel.setKaipiaoshenqing(kaipiaoshenqing);
			
			yingshoukuanmodellist.add(yingshoukuanmodel);
		}
		
		
		return yingshoukuanmodellist;
	}
	
	/**
	 *  得到营收款模版类 集合
	 */
	public static List<YingShouKuanModel> getMethodNameList(List<YingShouKuan> yingshoukuanlist,String methodName , YunDanService yunDanService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
//		加载applicationContext.xml文件
		
		
		
		List<YingShouKuanModel> yingshoukuanmodellist = new ArrayList<YingShouKuanModel>();
		
		for (int i = 0; i < yingshoukuanlist.size(); i++) {
			
			YingShouKuan yingshoukuan = yingshoukuanlist.get(i);
			
			String id = String.valueOf(yingshoukuan.getId());

			String dingdanhao = yingshoukuan.getDingdanhao();
			YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
			
			String xiangxipath =request.getContextPath()+"/"+methodName+"?dingdanhao="+dingdanhao;
			dingdanhao = "<a href=\""+xiangxipath+"\">"+dingdanhao+"</a>";
			
			String chepaihao = "";
			String huowumingcheng = "";
			if(yundan != null){
				chepaihao = yundan.getChepaihao();
				huowumingcheng = yundan.getHuowumingcheng();
			}
			
			String kehudanwei = yingshoukuan.getKehudanwei();
			String yingshoukuanzhuangtai = yingshoukuan.getYingshoukuanzhuangtai();
			String jiesuanzhuangtai = yingshoukuan.getJiesuanzhuangtai();
			
			String  kaipiaoshenqing = yingshoukuan.getKaipiaoshenqing();
			String  fenguankaipiaoshenhe =  yingshoukuan.getFenguankaipiaoshenhe();
			String zongjinglikaipiaoshenhe = yingshoukuan.getZongjinglikaipiaoshenhe();
			
			String jiesuanshenqing = yingshoukuan.getJiesuanshenqing();
			String zongjinglijiesuanshenhe = yingshoukuan.getZongjinglijiesuanshenhe();
			String dongshizhangjiesuanshenhe = yingshoukuan.getDongshizhangjiesuanshenhe();
			
			YingShouKuanModel yingshoukuanmodel = new YingShouKuanModel();
			yingshoukuanmodel.setYingShouKuanModel(id, dingdanhao, chepaihao, huowumingcheng, kehudanwei,yingshoukuanzhuangtai ,jiesuanzhuangtai);
			
			yingshoukuanmodel.setKaipiaoshenqing(kaipiaoshenqing);
			yingshoukuanmodel.setFenguankaipiaoshenhe(fenguankaipiaoshenhe);
			yingshoukuanmodel.setZongjinglikaipiaoshenhe(zongjinglikaipiaoshenhe);
			
			yingshoukuanmodel.setJiesuanshenqing(jiesuanshenqing);
			yingshoukuanmodel.setZongjinglijiesuanshenhe(zongjinglijiesuanshenhe);
			yingshoukuanmodel.setDongshizhangjiesuanshenhe(dongshizhangjiesuanshenhe);
			
			yingshoukuanmodellist.add(yingshoukuanmodel);
		}
		
		
		return yingshoukuanmodellist;
	}
	
	/**
	 *  得到门户营收款模版类 集合
	 */
	public static List<YingShouKuanModel> getMenHuMethodNameList(List<YingShouKuan> yingshoukuanlist,String methodName , YunDanService yunDanService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		List<YingShouKuanModel> yingshoukuanmodellist = new ArrayList<YingShouKuanModel>();
		
		int index = 1;
		
		for (int i = 0; i < yingshoukuanlist.size(); i++) {
			
			if(index > 5){
				break;
			}
			index++;
			
			YingShouKuan yingshoukuan = yingshoukuanlist.get(i);
			
			String id = String.valueOf(yingshoukuan.getId());

			String dingdanhao = yingshoukuan.getDingdanhao();
			YunDan yundan = yunDanService.queryYunDanDingDanHao(dingdanhao);
			
			String xiangxipath =request.getContextPath()+"/"+methodName+"?dingdanhao="+dingdanhao;
			dingdanhao = "<a href=\""+xiangxipath+"\">"+dingdanhao+"</a>";
			
			String chepaihao = "";
			String huowumingcheng = "";
			if(yundan != null){
				chepaihao = yundan.getChepaihao();
				huowumingcheng = yundan.getHuowumingcheng();
			}
			
			String kehudanwei = yingshoukuan.getKehudanwei();
			String yingshoukuanzhuangtai = yingshoukuan.getYingshoukuanzhuangtai();
			String jiesuanzhuangtai = yingshoukuan.getJiesuanzhuangtai();
			
			String  kaipiaoshenqing = yingshoukuan.getKaipiaoshenqing();
			String  fenguankaipiaoshenhe =  yingshoukuan.getFenguankaipiaoshenhe();
			String zongjinglikaipiaoshenhe = yingshoukuan.getZongjinglikaipiaoshenhe();
			
			String jiesuanshenqing = yingshoukuan.getJiesuanshenqing();
			String zongjinglijiesuanshenhe = yingshoukuan.getZongjinglijiesuanshenhe();
			String dongshizhangjiesuanshenhe = yingshoukuan.getDongshizhangjiesuanshenhe();
			
			YingShouKuanModel yingshoukuanmodel = new YingShouKuanModel();
			yingshoukuanmodel.setYingShouKuanModel(id, dingdanhao, chepaihao, huowumingcheng, kehudanwei,yingshoukuanzhuangtai ,jiesuanzhuangtai);
			
			yingshoukuanmodel.setKaipiaoshenqing(kaipiaoshenqing);
			yingshoukuanmodel.setFenguankaipiaoshenhe(fenguankaipiaoshenhe);
			yingshoukuanmodel.setZongjinglikaipiaoshenhe(zongjinglikaipiaoshenhe);
			
			yingshoukuanmodel.setJiesuanshenqing(jiesuanshenqing);
			yingshoukuanmodel.setZongjinglijiesuanshenhe(zongjinglijiesuanshenhe);
			yingshoukuanmodel.setDongshizhangjiesuanshenhe(dongshizhangjiesuanshenhe);
			
			yingshoukuanmodellist.add(yingshoukuanmodel);
		}
		
		
		return yingshoukuanmodellist;
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
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}

	public String getYingshoukuanzhuangtai() {
		return yingshoukuanzhuangtai;
	}

	public void setYingshoukuanzhuangtai(String yingshoukuanzhuangtai) {
		this.yingshoukuanzhuangtai = yingshoukuanzhuangtai;
	}

	public String getJiesuanzhuangtai() {
		return jiesuanzhuangtai;
	}

	public void setJiesuanzhuangtai(String jiesuanzhuangtai) {
		this.jiesuanzhuangtai = jiesuanzhuangtai;
	}

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}

	public String getKaipiaoshenqing() {
		return kaipiaoshenqing;
	}

	public void setKaipiaoshenqing(String kaipiaoshenqing) {
		this.kaipiaoshenqing = kaipiaoshenqing;
	}

	public String getKaipiaoshenqingren() {
		return kaipiaoshenqingren;
	}

	public void setKaipiaoshenqingren(String kaipiaoshenqingren) {
		this.kaipiaoshenqingren = kaipiaoshenqingren;
	}

	public String getFenguankaipiaoshenhe() {
		return fenguankaipiaoshenhe;
	}

	public void setFenguankaipiaoshenhe(String fenguankaipiaoshenhe) {
		this.fenguankaipiaoshenhe = fenguankaipiaoshenhe;
	}

	public String getFenguankaipiaoshenheren() {
		return fenguankaipiaoshenheren;
	}

	public void setFenguankaipiaoshenheren(String fenguankaipiaoshenheren) {
		this.fenguankaipiaoshenheren = fenguankaipiaoshenheren;
	}

	public String getZongjinglikaipiaoshenhe() {
		return zongjinglikaipiaoshenhe;
	}

	public void setZongjinglikaipiaoshenhe(String zongjinglikaipiaoshenhe) {
		this.zongjinglikaipiaoshenhe = zongjinglikaipiaoshenhe;
	}

	public String getZongjinglikaipiaoshenheren() {
		return zongjinglikaipiaoshenheren;
	}

	public void setZongjinglikaipiaoshenheren(String zongjinglikaipiaoshenheren) {
		this.zongjinglikaipiaoshenheren = zongjinglikaipiaoshenheren;
	}

	public String getJiesuanshenqing() {
		return jiesuanshenqing;
	}

	public void setJiesuanshenqing(String jiesuanshenqing) {
		this.jiesuanshenqing = jiesuanshenqing;
	}

	public String getJiesuanshenqingren() {
		return jiesuanshenqingren;
	}

	public void setJiesuanshenqingren(String jiesuanshenqingren) {
		this.jiesuanshenqingren = jiesuanshenqingren;
	}

	public String getZongjinglijiesuanshenhe() {
		return zongjinglijiesuanshenhe;
	}

	public void setZongjinglijiesuanshenhe(String zongjinglijiesuanshenhe) {
		this.zongjinglijiesuanshenhe = zongjinglijiesuanshenhe;
	}

	public String getZongjinglijiesuanshenheren() {
		return zongjinglijiesuanshenheren;
	}

	public void setZongjinglijiesuanshenheren(String zongjinglijiesuanshenheren) {
		this.zongjinglijiesuanshenheren = zongjinglijiesuanshenheren;
	}

	public String getDongshizhangjiesuanshenhe() {
		return dongshizhangjiesuanshenhe;
	}

	public void setDongshizhangjiesuanshenhe(String dongshizhangjiesuanshenhe) {
		this.dongshizhangjiesuanshenhe = dongshizhangjiesuanshenhe;
	}

	public String getDongshizhangjiesuanshenheren() {
		return dongshizhangjiesuanshenheren;
	}

	public void setDongshizhangjiesuanshenheren(String dongshizhangjiesuanshenheren) {
		this.dongshizhangjiesuanshenheren = dongshizhangjiesuanshenheren;
	}
	
	
	
}
