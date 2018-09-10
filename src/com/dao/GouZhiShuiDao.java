package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.GouZhiShui;

/**
 *  购置税 dao层
 */
public class GouZhiShuiDao extends Dao<GouZhiShui>{
	/**
	 * 构造方法
	 */
	public GouZhiShuiDao() {
		super();
	}

	/**
	 *  查询所有购置税
	 */
	public List<GouZhiShui> queryGouZhiShui(){
		StringBuffer sf = new StringBuffer("from GouZhiShui");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询未办理的购置税
	 */
	public List<GouZhiShui> queryGouZhiShuiWeiBanLi(){
		StringBuffer sf = new StringBuffer("from GouZhiShui where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询未办理的购置税的数量
	 */
	public int getGouZhiShuiJinDu(){
		StringBuffer sf = new StringBuffer("from GouZhiShui where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list().size();
	}
	
	/**
	 *  查询对应车牌号的购置税
	 */
	public GouZhiShui queryGouZhiShuiChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer("from GouZhiShui where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (GouZhiShui) query.uniqueResult();
	}
	
	/**
	 *  删除指定车牌号的购置税
	 */
	public void deleteGouZhiShuiChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer("delete from GouZhiShui where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
}
