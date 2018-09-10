package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.FenGuanLingDao;

/**
 *  分管领导 dao层
 */
public class FenGuanLingDaoDao extends Dao<FenGuanLingDao>{
	/**
	 * 构造方法
	 */
	public FenGuanLingDaoDao() {
		super();
	}

	/**
	 *  查询所有分管领导
	 */
	public List<FenGuanLingDao> queryFenGuanLingDaoList(){
		StringBuffer sf = new StringBuffer(" from FenGuanLingDao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的分管领导
	 */
	public List<FenGuanLingDao> queryFenGuanLingDaoWeiBanLi(){
		StringBuffer sf = new StringBuffer(" from FenGuanLingDao where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的分管领导数量
	 */
	public int getFenGuanLingDaoJinDu(){
		StringBuffer sf = new StringBuffer(" from FenGuanLingDao where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list().size();
	}
	
	/**
	 *  查询指定车牌号的分管领导
	 */
	public FenGuanLingDao queryFenGuanLingDaoChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" from FenGuanLingDao where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (FenGuanLingDao) query.uniqueResult();
	}
	
	/**
	 *  删除指定车牌号的分管领导
	 */
	public void deleteFenGuanLingDaoChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" delete from FenGuanLingDao where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
}
