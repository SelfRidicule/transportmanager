package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.TouRuShenHe;

/**
 *  投入审核dao层
 */
public class TouRuShenHeDao extends Dao<TouRuShenHe>{
	/**
	 * 构造方法
	 */
	public TouRuShenHeDao() {
		super();
	}

	/**
	 *  查询未办理的投入审核数量
	 */
	public int getTouRuShenHeJinDu(){
		StringBuffer sf = new StringBuffer("from TouRuShenHe where banlizhuangtai = '未办理'");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list().size();
	}
	
	/**
	 *  查询未办理的投入审核
	 */
	public List<TouRuShenHe> queryTouRuShenHeWeiBanLi(){
		StringBuffer sf = new StringBuffer(" from TouRuShenHe where banlizhuangtai = '未办理'  order by id desc ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询对应车牌号的投入审核
	 */
	public TouRuShenHe queryTouRuShenHeChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer("from TouRuShenHe where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (TouRuShenHe) query.uniqueResult();
	}
	
	
	/**
	 *  查询所有投入审核
	 */
	public List<TouRuShenHe> queryTouRuShenHeList(){
		StringBuffer sf = new StringBuffer("from TouRuShenHe");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();	
	}
	
	/**
	 *  删除指定车牌号的投入审核
	 */
	public void deleteTouRuShenHeChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" delete from TouRuShenHe where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
	
}
