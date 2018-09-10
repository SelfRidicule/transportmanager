package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.CheLiangBeiFen;

/**
 *  车辆备份dao
 */
public class CheLiangBeiFenDao extends Dao<CheLiangBeiFen>{
	/**
	 * 构造方法
	 */
	public CheLiangBeiFenDao() {
		super();
	}

	/**
	 *  查询所有
	 */
	public List<CheLiangBeiFen> queryList(){
		StringBuffer sf = new StringBuffer("from CheLiangBeiFen");
		Query query =  getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	public void deleteCaoZuoYuan(String caozuoyuan){
		StringBuffer sf = new StringBuffer(" delete from CheLiangBeiFen where caozuoyuan = :caozuoyuan ");
		Query query =  getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("caozuoyuan", caozuoyuan);
		query.executeUpdate();
	}
	
	public CheLiangBeiFen queryCaoZuoYuan(String caozuoyuan){
		StringBuffer sf = new StringBuffer(" from CheLiangBeiFen where caozuoyuan = :caozuoyuan ");
		Query query =  getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("caozuoyuan", caozuoyuan);
		return (CheLiangBeiFen) query.uniqueResult();
	}
	
}
