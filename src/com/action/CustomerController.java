package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.Customer;
import com.model.CustomerSearchModel;
import com.myutils.FontFormat;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CustomerService;

import net.sf.json.JSONArray;

/**
 *  客户控制层
 */
public class CustomerController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public CustomerController() {
		super();
	}
	
//	得到请求对象 
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = request.getSession();

//	集合对象
	private static List<Customer> customerlist;
//	单一对象
	private  Customer singlecustomer;
	
	
	private CustomerService customerService;
	
	/**
	 * 属性
	 */
	private String  customername;	//客户名称
	private String  shortname ;  	//客户简称 
	private String  identifynumber; //识别号
	private String  bankaccount ; 	//开户行
	private String  account  ;		//帐号
	private String  contactperson ; //联系人
	private String  contactnumber ;	//联系电话
	private String  phonenumber ; 	//手机号码
	private String  contactaddress; //联系地址
	private String  comment ;		//客户备注	
	private String  kehudanwei;		//客户单位
	
	/**
	 *  发送-客户
	 */
	public static void sendCustomer(CustomerService customerService){
//		得到请求对象 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	
//		设置字符格式
		FontFormat.setFontFormat(response);		
					
		
		List<Customer> customerlist = customerService.queryCustomerList();
		request.setAttribute("customerlist", customerlist);
		
	}
	
	/**
	 *  跳转-客户
	 */
	public String jumpCustomer(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
//		设置字符格式
		FontFormat.setFontFormat(response);		
					
		
		customerlist = customerService.queryCustomerList();
		request.setAttribute("customerlist", customerlist);
		
		return "success" ;
	}
	
	/**
	 *  模糊查询客户
	 */
	public String vagueSearchCustomer(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("模糊查询客户");
//		设置字符格式
		FontFormat.setFontFormat(response);
		
//		调用模糊查询
		customerlist = customerService.vagueSearchCustomer(shortname, contactperson, contactaddress);
		
		request.setAttribute("customerlist", customerlist);
		
		CustomerSearchModel csm = new CustomerSearchModel(shortname, contactperson, contactaddress);
		
		request.setAttribute("customersearch", csm);
		return "success";
	}
	
	/**
	 *  客户json
	 */
	public void customerJson(){
		System.out.println("客户 json");
//		设置字符格式
		FontFormat.setFontFormat(response);		

//		判断客户集合是否为空
		if(customerlist == null || customerlist.size()<1){
			return ;
		}
			
		try {
			
			List<Customer> customerjsonlist = new ArrayList<Customer>();
			String xm = request.getServletContext().getContextPath();
			for (int i = 0; i < customerlist.size(); i++) {
				Customer customer = customerlist.get(i);
				String  shortname =customer.getShortname();
				String  customerid = String.valueOf(customer.getCustomerid());
				String  path ="<a href='"+xm+"/customerDetail?customerid="+customerid+"'>";
				
				customer.setShortname(path+shortname+"</a>");
				customerjsonlist.add(customer);
			}
			
			JSONArray ja = JSONArray.fromObject(customerjsonlist);
			
			PrintWriter pw = response.getWriter();
			pw.print(ja);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 *  删除客户
	 */
	public String deleteCustomer(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("删除客户");
//		设置字符格式
		FontFormat.setFontFormat(response);
//		得到客户id数组
		String customerid[] = request.getParameterValues("toolbar1");
//		判断是否选中客户id
		if(customerid == null || customerid.length<1){
			return "success";
		}
			
//		通过循环语句删除指定id客户
		for (int i = 0; i < customerid.length; i++) {
			customerService.deleteCustomer(Integer.valueOf(customerid[i]));
		}
//		查询所有客户信息
		customerlist = customerService.queryCustomerList();
		request.setAttribute("customerlist", customerlist);
		
		return "success";
	}
	
	/**
	 * 添加客户
	 */
	public String addCustomer(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("添加客户");
//		设置字符格式
		FontFormat.setFontFormat(response);		
			
		
		Customer customer = new Customer(customername, shortname, identifynumber, bankaccount, account, contactperson, contactnumber, phonenumber, contactaddress, comment);
		customer.setKehudanwei(kehudanwei);
		
		customerService.addCustomer(customer);
		
		 customerlist = customerService.queryCustomerList();
		request.setAttribute("customerlist", customerlist);
		
		return "success";
	}
	
	/**
	 *  修改客户
	 */
	public String updateCustomer(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("修改客户");
//		设置字符格式
		FontFormat.setFontFormat(response);		
		
		String customerid[] = request.getParameterValues("toolbar1");
//		判断得到的客户id是否正常
		if(customerid == null || customerid.length>1 || customerid.length<1){
			return "err";
		}
//		得到CustomerService对象
		
		 singlecustomer = customerService.getSingleCustomer(Integer.valueOf(customerid[0]));
		
		request.setAttribute("singlecustomer", singlecustomer);
		
		session.setAttribute("singlecustomer", singlecustomer);
		
		return "success";
	}
	
	/**
	 *  提交修改客户
	 */
	public String submitUpdateCustomer(){
//		start-------判断是否登录用户
        boolean existUser = UsersController.existLoginUser();
        if(!existUser){
        	return "returnLogin";
        }
//		------------end
        
		System.out.println("提交修改客户");
//		设置字符格式
		FontFormat.setFontFormat(response);				
//		得到CustomerService对象		
		
		singlecustomer = (Customer) session.getAttribute("singlecustomer");
		
		singlecustomer.setCustomer(customername, shortname, identifynumber, bankaccount, account, contactperson, contactnumber, phonenumber, contactaddress, comment);
		singlecustomer.setKehudanwei(kehudanwei);
		
		customerService.updateCustomer(singlecustomer);
		
		customerlist = customerService.queryCustomerList();
		request.setAttribute("customerlist", customerlist);
		
		session.removeAttribute("singlecustomer");
		
		return "success";
	}
	
	/**
	 *  客户详细
	 */
	public String customerDetail(){
		System.out.println("客户详细");
//		设置字符格式
		FontFormat.setFontFormat(response);			
		
		String customerid = request.getParameter("customerid");

					
		
		Customer customerdetail = customerService.getSingleCustomer(Integer.valueOf(customerid));
		
		request.setAttribute("customerdetail", customerdetail);
		
		return "success";
	}
	
	/**
	 *  get set
	 */
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getContactaddress() {
		return contactaddress;
	}
	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getIdentifynumber() {
		return identifynumber;
	}

	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getKehudanwei() {
		return kehudanwei;
	}

	public void setKehudanwei(String kehudanwei) {
		this.kehudanwei = kehudanwei;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
