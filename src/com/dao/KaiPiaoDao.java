package com.dao;
import java.util.List;

import org.hibernate.Query;

import com.entity.KaiPiao;

/**
 *  开票dao层
 */
public class KaiPiaoDao extends Dao<KaiPiao>{
	/**
	 * 构造方法
	 */
	public KaiPiaoDao() {
		super();
	}

	/**
	 *  查询所有开票
	 */
	public List<KaiPiao> queryKaiPiaoList(){
		StringBuffer sf = new StringBuffer(" from KaiPiao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	
}
