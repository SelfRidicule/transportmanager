package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.JinDuService;

/**
 *  进度 控制层
 */
public class JinDuController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public JinDuController() {
		super();
	}
	
	private JinDuService jinDuService ;

	/**
	 *  测试进度
	 */
	public void testjindu(){
//		得到请求对象 
		HttpServletResponse response = ServletActionContext.getResponse();
//		设置字符格式
		FontFormat.setFontFormat(response);		
//		加载applicationContext.xml文件
				
		
		
		Long index = jinDuService.queryDangQianJinDuSize("1");
		System.out.println(index);
	}

	/**
	 * get set
	 */
	public JinDuService getJinDuService() {
		return jinDuService;
	}

	public void setJinDuService(JinDuService jinDuService) {
		this.jinDuService = jinDuService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
