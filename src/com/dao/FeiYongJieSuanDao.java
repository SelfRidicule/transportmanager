package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.FeiYongJieSuan;

/**
 *  费用结算dao层 
 */
public class FeiYongJieSuanDao  extends Dao<FeiYongJieSuan>{
	/**
	 * 构造方法
	 */
	public FeiYongJieSuanDao() {
		super();
	}

	/**
	 *  查询所有费用结算
	 */
	public List<FeiYongJieSuan> queryFeiYongJieSuanList(){
		StringBuffer sf = new StringBuffer(" from FeiYongJieSuan ") ; 
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}

	/**
	 *  查询所有未办理的费用结算
	 */
	public List<FeiYongJieSuan> queryFeiYongJieSuanWeiBanLi(){
		StringBuffer sf = new StringBuffer(" from FeiYongJieSuan where banlizhuangtai = '未办理' ") ; 
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的费用结算数量
	 */
	public int getFeiYongJieSuanJinDu(){
		StringBuffer sf = new StringBuffer(" from FeiYongJieSuan where banlizhuangtai = '未办理' ") ; 
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list().size();
	}
	
	/**
	 *  查询指定车牌号的费用结算
	 */
	public FeiYongJieSuan queryFeiYongJieSuanChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" from FeiYongJieSuan where chepaihao = :chepaihao ") ; 
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (FeiYongJieSuan) query.uniqueResult();
	}
	
	/**
	 *  删除指定车牌号的费用结算
	 */
	public void deleteFeiYongJieSuanChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" delete from FeiYongJieSuan where chepaihao = :chepaihao ") ; 
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
}
