package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.CheLiangGuanXi;

/**
 *  车辆关系dao层
 */
public class CheLiangGuanXiDao extends Dao<CheLiangGuanXi>{
	/**
	 * 构造方法
	 */
	public CheLiangGuanXiDao() {
		super();
	}
	
	/**
	 *  查询所有车辆关系
	 */
	public List<CheLiangGuanXi> queryCheLiangGuanXi(){
		StringBuffer sf = new StringBuffer("from CheLiangGuanXi");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询指定牵引车的车辆关系
	 */
	public CheLiangGuanXi queryCheLiangGuanXiInQianYinChe(String qianyinche){
		StringBuffer sf = new StringBuffer(" from CheLiangGuanXi where qianyinche = :qianyinche ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("qianyinche", qianyinche);
		return (CheLiangGuanXi) query.uniqueResult();
	}
	
	/**
	 *  删除指定车牌号的车辆关系
	 */
	public void deleteChePaiHao(String chepaihao){
		if(chepaihao==null || "".equals(chepaihao)){
			return ;
		}
		StringBuffer sf = new StringBuffer("delete CheLiangGuanXi where qianyinche = :chepaihao");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.executeUpdate();
	}
	
}
