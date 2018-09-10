package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.GouZhiShuiDao;
import com.entity.GouZhiShui;
import com.entity.TouRuShenHe;

/**
 *  购置税 业务层
 */
public class GouZhiShuiService {
	/**
	 * 构造方法
	 */
	public GouZhiShuiService() {
		super();
	}

	/**
	 * 属性
	 */
	private GouZhiShuiDao gouZhiShuiDao;	//购置税dao对象

	/**
	 *  查询所有购置税
	 */
	public List<GouZhiShui> queryGouZhiShui(){
		return gouZhiShuiDao.queryGouZhiShui();
	}
	
	/**
	 *  查询未办理的购置税
	 */
	public List<GouZhiShui> queryGouZhiShuiWeiBanLi(){
		return gouZhiShuiDao.queryGouZhiShuiWeiBanLi();
	}
	
	/**
	 *  查询未办理的购置税的数量
	 */
	public int getGouZhiShuiJinDu(){
		return gouZhiShuiDao.getGouZhiShuiJinDu();
	}
	
	/**
	 *  查询对应车牌号的购置税
	 */
	public GouZhiShui queryGouZhiShuiChePaiHao(String chepaihao){
		return gouZhiShuiDao.queryGouZhiShuiChePaiHao(chepaihao);
	}
	
	/**
	 *  模糊查询
	 */
	public List<GouZhiShui> vagueSearchGouZhiShui(String bianhao, String chepaihao, String banlizhuangtai){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from GouZhiShui where id is not null ");
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
		Query query = gouZhiShuiDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
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
	 *  添加购置税
	 */
	public void addGouZhiShui(GouZhiShui gouzhishui){
		gouZhiShuiDao.save(gouzhishui);
	}
	
	/**
	 *  修改购置税
	 */
	public void updateGouZhiShui(GouZhiShui gouzhishui){
		gouZhiShuiDao.update(gouzhishui);
	}
	
	/**
	 *  删除购置税
	 */
	public void deleteGouZhiShui(Integer id){
		GouZhiShui gouzhishui = new GouZhiShui();
		gouzhishui.setId(id);
		gouZhiShuiDao.delete(gouzhishui);
	}
	
	/**
	 *  删除指定车牌号的购置税
	 */
	public void deleteGouZhiShuiChePaiHao(String chepaihao){
		gouZhiShuiDao.deleteGouZhiShuiChePaiHao(chepaihao);
	}
	
	/**
	 *  get set
	 */
	public GouZhiShuiDao getGouZhiShuiDao() {
		return gouZhiShuiDao;
	}

	public void setGouZhiShuiDao(GouZhiShuiDao gouZhiShuiDao) {
		this.gouZhiShuiDao = gouZhiShuiDao;
	}
	
}
