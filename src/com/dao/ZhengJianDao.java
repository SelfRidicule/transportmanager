package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.ZhengJian;

/**
 * 证件 dao 层
 */
public class ZhengJianDao extends Dao<ZhengJian>{
	/**
	 * 构造方法
	 */
	public ZhengJianDao() {
		super();
	}

	/**
	 * 查询所有证件信息 
	 */
	public List<ZhengJian> queryZhengJianList(){
		StringBuffer sf = new StringBuffer("from ZhengJian");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 * 查询排序时间的证件信息 
	 */
	public List<ZhengJian> queryZhengJianOrderByList(){
		StringBuffer sf = new StringBuffer("from ZhengJian order by daoqiriqi");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  删除指定车牌号的证件
	 */
	public void deleteZhengJianExistChePaiHao(String chepaihao){
		if(chepaihao == null){
			return;
		}
		StringBuffer sf = new StringBuffer("delete ZhengJian where chepaihao = :chepaihao");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
}
