package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.CheLiang;

/**
 *  车辆dao 
 */
public class CheLiangDao extends Dao<CheLiang>{
	/**
	 * 构造方法
	 */
	public CheLiangDao() {
		super();
	}

	/**
	 *  查询所有车辆信息
	 */
	public List<CheLiang> queryCheLiangList(){
		StringBuffer sf = new StringBuffer("from CheLiang");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 * 查询指定车牌号的车辆 
	 */
	public CheLiang queryChePaiHaoCheLiang(String chepaihao){
		 StringBuffer sf = new StringBuffer("from CheLiang where chepaihao = :chepaihao");
		 Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		 query.setString("chepaihao", chepaihao);
		 return (CheLiang) query.uniqueResult();
	}

	/**
	 *  查询指定车型id的集合对象
	 */
	public List<CheLiang> queryCheLiangCheXingId(Integer id){
		StringBuffer sf = new StringBuffer("from CheLiang where chexing = :chexing");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setInteger("chexing", id);
		return query.list();
	}
	
}
