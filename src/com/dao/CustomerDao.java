package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.Customer;

/**
 *  客户dao层
 */
public class CustomerDao extends Dao<Customer>{
	/**
	 * 构造方法
	 */
	public CustomerDao() {
		super();
	}

	/**
	 *  查询所有客户集合
	 */
	public List<Customer> queryCustomerList(){
		StringBuffer sf = new StringBuffer("from Customer");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询指定客户单位的 客户
	 */
	public Customer queryCustomerKeHuDanWei(String kehudanwei){
		StringBuffer sf = new StringBuffer(" from Customer where kehudanwei = :kehudanwei ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("kehudanwei", kehudanwei);
		return (Customer) query.uniqueResult();
	}
	
}
