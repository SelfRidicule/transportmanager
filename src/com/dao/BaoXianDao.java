package com.dao;

import java.util.List;

import org.hibernate.Query;
import com.entity.BaoXian;

/**
 * 保险dao
 */
public class BaoXianDao extends Dao<BaoXian>{
	/**
	 * 构造方法
	 */
	public BaoXianDao() {
		super();
	}

	/**
	 *  查询保险所有信息
	 */
	public List<BaoXian> queryBaoxianList(){
		StringBuffer sf = new StringBuffer(" from BaoXian  order by toubaojine desc ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询排序后保险所有信息
	 */
	public List<BaoXian> queryBaoxianOrderByList(){
		StringBuffer sf = new StringBuffer(" from BaoXian order by daoqiriqi ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  删除指定车牌号的保险对象
	 */
	public void deleteBaoXianChePaiHao(String chepaihao){
		if(chepaihao==null){
			return ;
		}
		StringBuffer sf = new StringBuffer("delete BaoXian where chepaihao = :chepaihao");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
}
