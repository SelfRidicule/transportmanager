package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.CongYeZiGeDao;
import com.entity.CheLiangGuanXi;
import com.entity.CongYeZiGe;

/**
 *  从业资格 业务层
 */
public class CongYeZiGeService {
	/**
	 * 构造方法
	 */
	public CongYeZiGeService() {
		super();
	}

	/**
	 * 属性
	 */
	private CongYeZiGeDao congYeZiGeDao;

	/**
	 *  查找所有 
	 */
	public List<CongYeZiGe> queryCongYeZiGeList(){
		return congYeZiGeDao.queryCongYeZiGeList();
	}
	
	/**
	 *  查找指定id对象
	 */
	public CongYeZiGe queryCongYeZiGeId(Integer id){
		return congYeZiGeDao.findById(id);
	}
	
	/**
	 *  模糊查询
	 */
	public List<CongYeZiGe> vagueSearchCongYeZiGe( String leibiemingcheng ){
		StringBuffer hql = new StringBuffer("from CongYeZiGe where id is not null ");
		
		if(leibiemingcheng==null || "".equals(leibiemingcheng)){
		}else{
			hql.append(" and leibiemingcheng like :leibiemingcheng ");
		}		
		
		Query query = congYeZiGeDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		if(leibiemingcheng==null || "".equals(leibiemingcheng)){
		}else{
			query.setString("leibiemingcheng", "%"+leibiemingcheng+"%");
		}
		
		return query.list();
	}
	
	
	
	/**
	 *  添加
	 */
	public void addCongYeZiGe(CongYeZiGe congyezige){
		congYeZiGeDao.save(congyezige);
	}
	
	/**
	 *  修改
	 */
	public void updateCongYeZiGe(CongYeZiGe congyezige){
		congYeZiGeDao.update(congyezige);
	}
	
	/**
	 *  删除
	 */
	public void deleteCongYeZiGe(CongYeZiGe congyezige){
		congYeZiGeDao.delete(congyezige);
	} 
	
	/**
	 *  删除指定id
	 */
	public void deleteCongYeZiGeId(String id){
		congYeZiGeDao.deleteCongYeZiGeId(id);
	}
	
	
	/**
	 *  get set
	 */
	public CongYeZiGeDao getCongYeZiGeDao() {
		return congYeZiGeDao;
	}

	public void setCongYeZiGeDao(CongYeZiGeDao congYeZiGeDao) {
		this.congYeZiGeDao = congYeZiGeDao;
	}
	
}
