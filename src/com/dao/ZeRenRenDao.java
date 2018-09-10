package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.ZeRenRen;

/**
 *  责任人 dao层
 */
public class ZeRenRenDao extends Dao<ZeRenRen>{
	/**
	 * 构造方法
	 */
	public ZeRenRenDao() {
		super();
	}

	/**
	 *  查询所有责任人
	 */
	public List<ZeRenRen> queryZeRenRenList(){
		StringBuffer sf = new StringBuffer(" from ZeRenRen ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的责任人
	 */
	public List<ZeRenRen> queryZeRenRenWeiBanLi(){
		StringBuffer sf = new StringBuffer(" from ZeRenRen where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询所有未办理的责任人数量
	 */
	public int getZeRenRenJinDu(){
		StringBuffer sf = new StringBuffer(" from ZeRenRen where banlizhuangtai = '未办理' ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list().size();
	}
	
	/**
	 *  查询指定车牌号的责任人
	 */
	public ZeRenRen queryZeRenRenChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" from ZeRenRen where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return (ZeRenRen) query.uniqueResult();
	}
	
	/**
	 *  删除指定车牌号的责任人
	 */
	public void deleteZeRenRenChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" delete from ZeRenRen where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
	
}
