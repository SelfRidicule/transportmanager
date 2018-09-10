package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.FeiYongShouQuDao;
import com.entity.BaoXianChuDan;
import com.entity.FeiYongShouQu;

/**
 *  费用收取 业务层
 */
public class FeiYongShouQuService {
	/**
	 * 构造方法
	 */
	public FeiYongShouQuService() {
		super();
	}

	/**
	 * property
	 */
	private FeiYongShouQuDao feiYongShouQuDao; //费用收取dao

	
	/**
	 *  query list
	 */
	public List<FeiYongShouQu> queryList(){
		return feiYongShouQuDao.queryBaoxianList();
	}
	
	/**
	 *  query id
	 */
	public FeiYongShouQu queryId( Integer id ){
		return feiYongShouQuDao.findById(id);
	}
	
	/**
	 *  save And update
	 */
	public void saveAndUpdate( FeiYongShouQu feiyongshouqu ){
		 feiYongShouQuDao.saveAndUpdate(feiyongshouqu);
	}
	
	/**
	 *  模糊查询
	 */
	public List<FeiYongShouQu> vagueSearchFeiYongShouQu(String chelianghezuoren){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from FeiYongShouQu where id is not null ");
//		判断值是否为空
		if(chelianghezuoren==null || "".equals(chelianghezuoren)){
		}else{
			hql.append(" and chelianghezuoren like :chelianghezuoren");
		}
		
//		创建query对象
		Query query = feiYongShouQuDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(chelianghezuoren==null || "".equals(chelianghezuoren)){
		}else{
			query.setString("chelianghezuoren","%"+chelianghezuoren+"%" );
		}
		
		return query.list();
	}
	
	/**
	 *  查询指定车辆合作人
	 */
	public List<FeiYongShouQu> queryCheLiangHeZuoRen(String chelianghezuoren){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from FeiYongShouQu where id is not null ");
//		判断值是否为空
		if(chelianghezuoren==null || "".equals(chelianghezuoren)){
		}else{
			hql.append(" and chelianghezuoren = :chelianghezuoren");
		}
		
//		创建query对象
		Query query = feiYongShouQuDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(chelianghezuoren==null || "".equals(chelianghezuoren)){
		}else{
			query.setString("chelianghezuoren", chelianghezuoren );
		}
		
		return query.list();
	}
	
	/**
	 * 删除指定车辆合作人
	 */
	public void deleteCheLiangHeZuoRen(String chelianghezuoren){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("delete from FeiYongShouQu where chelianghezuoren = :chelianghezuoren ");
//		创建query对象
		Query query = feiYongShouQuDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		query.setString("chelianghezuoren", chelianghezuoren );
		
		query.executeUpdate();
	}
	
	/**
	 * add
	 */
	public void addFeiYongShouQu( FeiYongShouQu feiyongshouqu ){
		feiYongShouQuDao.save(feiyongshouqu);
	}
	
	/**
	 * delete
	 */
	public void deleteFeiYongShouQu( FeiYongShouQu feiyongshouqu ){
		feiYongShouQuDao.delete(feiyongshouqu);
	}
	
	/**
	 *  update
	 */
	public void updateFeiYongShouQu( FeiYongShouQu feiyongshouqu ){
		feiYongShouQuDao.update(feiyongshouqu);
	}
	
	/**
	 *  删除指定id
	 */
	public void deleteId(String id){
		feiYongShouQuDao.deleteId(id);
	}
	
	/**
	 *  get set
	 */
	public FeiYongShouQuDao getFeiYongShouQuDao() {
		return feiYongShouQuDao;
	}

	public void setFeiYongShouQuDao(FeiYongShouQuDao feiYongShouQuDao) {
		this.feiYongShouQuDao = feiYongShouQuDao;
	}
	
}
