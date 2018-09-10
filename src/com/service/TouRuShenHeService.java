package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.TouRuShenHeDao;
import com.entity.TouRuShenHe;
import com.entity.XinChe;

/**
 *  投入审核 业务层
 */
public class TouRuShenHeService {
	/**
	 * 构造方法
	 */
	public TouRuShenHeService() {
		super();
	}

	/**
	 * 属性
	 */
	private TouRuShenHeDao touRuShenHeDao;	//投入审核dao对象

	/**
	 *  查询未办理的投入审核数量
	 */
	public int getTouRuShenHeJinDu(){
		return touRuShenHeDao.getTouRuShenHeJinDu();
	}
	
	/**
	 *  查询未办理的投入审核
	 */
	public List<TouRuShenHe> queryTouRuShenHeWeiBanLi(){
		return touRuShenHeDao.queryTouRuShenHeWeiBanLi();
	}	
	
	/**
	 *  查询对应车牌号的投入审核
	 */
	public TouRuShenHe queryTouRuShenHeChePaiHao(String chepaihao){
		return touRuShenHeDao.queryTouRuShenHeChePaiHao(chepaihao) ;
	}
	
	/**
	 *  查询所有投入审核
	 */
	public List<TouRuShenHe> queryTouRuShenHeList(){
		return 	touRuShenHeDao.queryTouRuShenHeList();
	}
	
	
	/**
	 *  模糊查询
	 */
	public List<TouRuShenHe> vagueSearchTouRuShenHe(String bianhao, String chepaihao, String banlizhuangtai){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from TouRuShenHe where id is not null ");
//		判断值是否为空
		if(bianhao==null || "".equals(bianhao)){
		}else{
			hql.append(" and bianhao like :bianhao");
		}
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}
		if(banlizhuangtai==null || "".equals(banlizhuangtai)){
		}else{
			hql.append(" and banlizhuangtai like :banlizhuangtai");
		}
		
//		创建query对象
		Query query = touRuShenHeDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(bianhao==null || "".equals(bianhao)){
		}else{
			query.setString("bianhao","%"+bianhao+"%" );
		}
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", chepaihao);
		}
		if(banlizhuangtai==null || "".equals(banlizhuangtai)){
		}else{
			query.setString("banlizhuangtai", banlizhuangtai);
		}
		
		return query.list();
	}
	
	
	/**
	 *  添加投入审核
	 */
	public void addTouRuShenHe(TouRuShenHe tourushenhe){
		touRuShenHeDao.save(tourushenhe);
	}
	
	/**
	 *  删除投入审核
	 */
	public void deleteTouRuShenHe(Integer id){
		TouRuShenHe tourushenhe = new TouRuShenHe();
		tourushenhe.setId(id);
		touRuShenHeDao.delete(tourushenhe);
	}
	
	/**
	 *  修改投入审核
	 */
	public void updateTouRuShenHe(TouRuShenHe tourushenhe){
		touRuShenHeDao.update(tourushenhe);
	}
	
	/**
	 *  删除指定车牌号的投入审核
	 */
	public void deleteTouRuShenHeChePaiHao(String chepaihao){
		touRuShenHeDao.deleteTouRuShenHeChePaiHao(chepaihao);
	}
	
	/**
	 *  get set
	 */
	public TouRuShenHeDao getTouRuShenHeDao() {
		return touRuShenHeDao;
	}

	public void setTouRuShenHeDao(TouRuShenHeDao touRuShenHeDao) {
		this.touRuShenHeDao = touRuShenHeDao;
	}
	
}
