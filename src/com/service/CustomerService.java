package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.CustomerDao;
import com.entity.Customer;

/**
 *  客户业务层
 */
public class CustomerService {
	/**
	 * 构造方法
	 */
	public CustomerService() {
		super();
	}
	
	/**
	 * 属性
	 */
	private CustomerDao customerDao; //客户dao对象

	
	/**
	 *  查询客户所有信息
	 */
	public List<Customer> queryCustomerList(){
		return customerDao.queryCustomerList();
	}
	
	/**
	 *  查询指定客户单位的 客户
	 */
	public Customer queryCustomerKeHuDanWei(String kehudanwei){
		return  customerDao.queryCustomerKeHuDanWei(kehudanwei);
	}
	
	/**
	 *  模糊查询客户
	 */
	public List<Customer> vagueSearchCustomer(String shortname,String contactperson,String contactaddress ){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from Customer where customerid is not null ");
//		判断值是否为空
		if(shortname==null || "".equals(shortname)){
		}else{
			hql.append(" and shortname like :shortname");
		}		
		if(contactperson==null || "".equals(contactperson)){
		}else{
			hql.append(" and contactperson like :contactperson");
		}
		if(contactaddress == null || "".equals(contactaddress)){
		}else{
			hql.append(" and contactaddress like :contactaddress");
		}
//		创建query对象
		Query query = customerDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
//		判断是否要添加值
		if(shortname==null || "".equals(shortname)){
		}else{
			query.setString("shortname", "%"+shortname+"%");
		}		
		if(contactperson==null || "".equals(contactperson)){
		}else{
			query.setString("contactperson", "%"+contactperson+"%");
		}
		if(contactaddress == null || "".equals(contactaddress)){
		}else{
			query.setString("contactaddress", "%"+contactaddress+"%");
		}		
		
		return query.list();
	}
	
	/**
	 *  查询客户单位
	 */
	public Customer queryKehudanwei(String kehudanwei){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from Customer where kehudanwei = :kehudanwei ");
//		创建query对象
		Query query = customerDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
//		判断是否要添加值
		query.setString("kehudanwei", kehudanwei);
		
		Customer customer =  null;
		try {
			customer = (Customer) query.uniqueResult();
		} catch (Exception e) {
		}
		return customer;
	}
	
	/**
	 *  得到指定id客户
	 */
	public Customer getSingleCustomer(Integer customerid){
		 Customer customer = customerDao.findById(customerid);
		 return customer;
	}
	
	/**
	 *  删除客户
	 */
	public void deleteCustomer(Integer customerid){
		
		Customer customer = new Customer();
		customer.setCustomerid(customerid);
//		删除客户
		customerDao.delete(customer);
	}
	
	/**
	 *  添加客户
	 */
	public void addCustomer(Customer customer){
		customerDao.save(customer);
	}
	
	/**
	 *  修改客户
	 */
	public void updateCustomer(Customer customer){
		customerDao.update(customer);
	}
	
	/**
	 *  get set
	 */
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
}
