package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.FenGuanLingDaoDao;
import com.entity.FenGuanLingDao;
import com.entity.ZeRenRen;

/**
 *  分管领导 业务层
 */
public class FenGuanLingDaoService {
	/**
	 * 构造方法
	 */
	public FenGuanLingDaoService() {
		super();
	}
	
	/**
	 * 属性
	 */
	private FenGuanLingDaoDao fenGuanLingDaoDao;	//分管领导dao对象

	
	/**
	 *  查询所有分管领导
	 */
	public List<FenGuanLingDao> queryFenGuanLingDaoList(){
		return fenGuanLingDaoDao.queryFenGuanLingDaoList();
	}
	
	/**
	 *  查询所有未办理的分管领导
	 */
	public List<FenGuanLingDao> queryFenGuanLingDaoWeiBanLi(){
		return fenGuanLingDaoDao.queryFenGuanLingDaoWeiBanLi();
	}
	
	/**
	 *  查询所有未办理的分管领导数量
	 */
	public int getFenGuanLingDaoJinDu(){
		return fenGuanLingDaoDao.getFenGuanLingDaoJinDu();
	}
	
	/**
	 *  查询指定车牌号的分管领导
	 */
	public FenGuanLingDao queryFenGuanLingDaoChePaiHao(String chepaihao){
		return fenGuanLingDaoDao.queryFenGuanLingDaoChePaiHao(chepaihao);
	}
	
	/**
	 *  模糊查询
	 */
	public List<FenGuanLingDao> vagueSearchFenGuanLingDao(String bianhao, String chepaihao, String banlizhuangtai){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer(" from FenGuanLingDao where id is not null ");
//		判断值是否为空
		if(bianhao!=null && !"".equals(bianhao)){
			hql.append(" and bianhao like :bianhao ");
		}
		if(chepaihao!=null && !"".equals(chepaihao)){
			hql.append(" and chepaihao like :chepaihao ");
		}
		if(banlizhuangtai!=null && !"".equals(banlizhuangtai)){
			hql.append(" and banlizhuangtai like :banlizhuangtai ");
		}
		
//		创建query对象
		Query query = fenGuanLingDaoDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(bianhao!=null && !"".equals(bianhao)){
			query.setString("bianhao","%"+bianhao+"%" );
		}
		if(chepaihao!=null && !"".equals(chepaihao)){
			query.setString("chepaihao", "%"+chepaihao+"%");
		}
		if(banlizhuangtai!=null && !"".equals(banlizhuangtai)){
			query.setString("banlizhuangtai", "%"+banlizhuangtai+"%");
		}
		
		return query.list();
	}
	
	
	/**
	 *  添加分管领导
	 */
	public void addFenGuanLingDao(FenGuanLingDao fenguanlingdao){
		fenGuanLingDaoDao.save(fenguanlingdao);
	}
	
	/**
	 *  修改分管领导
	 */
	public void updateFenGuanLingDao(FenGuanLingDao fenguanlingdao){
		fenGuanLingDaoDao.update(fenguanlingdao);
	}
	
	/**
	 *  删除分管领导
	 */
	public void deleteFenGuanLingDao(Integer id){
		FenGuanLingDao fenguanlingdao = new FenGuanLingDao();
		fenguanlingdao.setId(id);
		fenGuanLingDaoDao.delete(fenguanlingdao);
	}
	
	/**
	 *  删除指定车牌号的分管领导
	 */
	public void deleteFenGuanLingDaoChePaiHao(String chepaihao){
		fenGuanLingDaoDao.deleteFenGuanLingDaoChePaiHao(chepaihao);
	}
	
	/**
	 *  get set
	 */
	public FenGuanLingDaoDao getFenGuanLingDaoDao() {
		return fenGuanLingDaoDao;
	}

	public void setFenGuanLingDaoDao(FenGuanLingDaoDao fenGuanLingDaoDao) {
		this.fenGuanLingDaoDao = fenGuanLingDaoDao;
	}
	
}
