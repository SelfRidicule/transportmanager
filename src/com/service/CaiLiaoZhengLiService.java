package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.CaiLiaoZhengLiDao;
import com.entity.BaoXianChuDan;
import com.entity.CaiLiaoZhengLi;

/**
 *  材料整理业务层  ( 材料整理、档案建立 )
 */
public class CaiLiaoZhengLiService {
	/**
	 * 构造方法
	 */
	public CaiLiaoZhengLiService() {
		super();
	}

	/**
	 * 属性
	 */
	private CaiLiaoZhengLiDao caiLiaoZhengLiDao;	//材料整理dao对象

	
	/**
	 *  查询所有 材料整理
	 */
	public List<CaiLiaoZhengLi> queryCaiLiaoZhengLiList(){
		return caiLiaoZhengLiDao.queryCaiLiaoZhengLiList();
	}
	
	/**
	 *  查询所有未办理的 材料整理
	 */
	public List<CaiLiaoZhengLi> queryCaiLiaoZhengLiWeiBanLi(){
		return caiLiaoZhengLiDao.queryCaiLiaoZhengLiWeiBanLi();
	}
	
	/**
	 *  查询所有未办理的 材料整理数量
	 */
	public int getCaiLiaoZhengLiJinDu(){
		return caiLiaoZhengLiDao.getCaiLiaoZhengLiJinDu();
	}
	
	/**
	 *  查询指定车牌号的材料整理
	 */
	public CaiLiaoZhengLi queryCaiLiaoZhengLiChePaiHao( String chepaihao ){
		return caiLiaoZhengLiDao.queryCaiLiaoZhengLiChePaiHao(chepaihao);
	}
	
	/**
	 *  查询指定id的材料整理
	 */
	public CaiLiaoZhengLi queryCaiLiaoZhengLiId( Integer id ){
		return caiLiaoZhengLiDao.findById(id);
	}
	
	/**
	 *  模糊查询
	 */
	public List<CaiLiaoZhengLi> vagueSearchCaiLiaoZhengLi(String bianhao, String chepaihao, String banlizhuangtai){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from CaiLiaoZhengLi where id is not null ");
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
		Query query = caiLiaoZhengLiDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
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
	 *  添加材料整理
	 */
	public void addCaiLiaoZhengLi( CaiLiaoZhengLi cailiaozhengli ){
		caiLiaoZhengLiDao.save(cailiaozhengli);
	}
	
	/**
	 *  删除指定id的材料整理
	 */
	public void deleteCaiLiaoZhengLiId( Integer id ){
		CaiLiaoZhengLi cailiaozhengli = new CaiLiaoZhengLi();
		cailiaozhengli.setId(id);
		caiLiaoZhengLiDao.delete(cailiaozhengli);
	}
	
	/**
	 *  修改材料整理
	 */
	public void updateCaiLiaoZhengLi(CaiLiaoZhengLi cailiaozhengli){
		caiLiaoZhengLiDao.update(cailiaozhengli);
	}
	
	/**
	 *  删除指定车牌号的材料整理
	 */
	public void deleteCaiLiaoZhengLiChePaiHao( String chepaihao ){
		caiLiaoZhengLiDao.deleteCaiLiaoZhengLiChePaiHao(chepaihao);
	}
	
	
	/**
	 *   get set
	 */
	public CaiLiaoZhengLiDao getCaiLiaoZhengLiDao() {
		return caiLiaoZhengLiDao;
	}

	public void setCaiLiaoZhengLiDao(CaiLiaoZhengLiDao caiLiaoZhengLiDao) {
		this.caiLiaoZhengLiDao = caiLiaoZhengLiDao;
	}
	
}
