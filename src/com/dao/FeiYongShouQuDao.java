package com.dao;

import java.util.List;

import org.hibernate.Query;
import com.entity.BaoXian;
import com.entity.FeiYongShouQu;

/**
 * 保险dao
 */
public class FeiYongShouQuDao extends Dao<FeiYongShouQu>{
	/**
	 * 构造方法
	 */
	public FeiYongShouQuDao() {
		super();
	}

	/**
	 *  查询保险所有信息
	 */
	public List<FeiYongShouQu> queryBaoxianList(){
		StringBuffer sf = new StringBuffer(" from FeiYongShouQu ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  删除指定id
	 */
	public void deleteId(String id){
		StringBuffer sf = new StringBuffer(" delete from FeiYongShouQu where id = :id ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("id", id);
		query.executeUpdate();
	}
	
}
