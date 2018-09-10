package com.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.dao.BaoXianDao;
import com.entity.BaoXian;
import com.entity.Customer;

/**
 * 保险业务层
 */
public class BaoXianService {
	/**
	 * 构造方法
	 */
	public BaoXianService() {
		super();
	}

	/**
	 * 属性
	 */
	private BaoXianDao baoXianDao;

	/**
	 *  查询保险所有信息
	 */
	public List<BaoXian> queryBaoxianList(){
		return baoXianDao.queryBaoxianList();
	}
	
	/**
	 *  查询排序后保险所有信息
	 */
	public List<BaoXian> queryBaoxianOrderByList(){
		return baoXianDao.queryBaoxianOrderByList();
	}
	
	/**
	 *  查询指定id
	 */
	public BaoXian queryId(Integer id){
		return baoXianDao.findById(id);
	}
	
	/**
	 * 合计投保金额
	 */
	public String sumTouBaoJinE(String chepaihao){
		StringBuffer sf = new StringBuffer(" select sum(toubaojine) from BaoXian where chepaihao = :chepaihao ");
		Query query = baoXianDao.getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		
		return (String) query.uniqueResult();
	}
	
	/**
	 *  查询指定车牌号和保险类型的对象
	 */
	public BaoXian queryBaoDanHao(String chepaihao,String baoxianleixing){
		StringBuffer sf = new StringBuffer("from BaoXian where chepaihao = :chepaihao and baoxianleixing = :baoxianleixing");
		Query query = baoXianDao.getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.setString("baoxianleixing", baoxianleixing);
		return (BaoXian) query.uniqueResult();
	}
	
	/**
	 *  模糊查询保险
	 */
	public List<BaoXian> vagueSearchBaoXian(String chepaihao, String baodanhao, Date  chaxunxiaoyudaoqiriqi, Date  chaxundayudaoqiriqi,String baoxianleixing){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from BaoXian where id is not null ");
//		判断值是否为空
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}		
		if(baodanhao==null || "".equals(baodanhao)){
		}else{
			hql.append(" and baodanhao like :baodanhao");
		}
		if(chaxunxiaoyudaoqiriqi == null || "".equals(chaxunxiaoyudaoqiriqi)){
		}else{
			hql.append(" and daoqiriqi <= :chaxunxiaoyudaoqiriqi");
		}
		if(chaxundayudaoqiriqi == null || "".equals(chaxundayudaoqiriqi)){
		}else{
			hql.append(" and daoqiriqi >= :chaxundayudaoqiriqi");
		}
		if(baoxianleixing == null || "".equals(baoxianleixing)){
		}else{
			hql.append(" and baoxianleixing like :baoxianleixing");
		}
		
		hql.append(" order by toubaojine desc ");
		
//		创建query对象
		Query query = baoXianDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
//		判断是否要添加值
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", "%"+chepaihao+"%");
		}		
		if(baodanhao==null || "".equals(baodanhao)){
		}else{
			query.setString("baodanhao", "%"+baodanhao+"%");
		}
		if(chaxunxiaoyudaoqiriqi == null || "".equals(chaxunxiaoyudaoqiriqi)){
		}else{
			query.setDate("chaxunxiaoyudaoqiriqi", chaxunxiaoyudaoqiriqi);
		}
		if(chaxundayudaoqiriqi == null || "".equals(chaxundayudaoqiriqi)){
		}else{
			query.setDate("chaxundayudaoqiriqi", chaxundayudaoqiriqi);
		}
		if(baoxianleixing == null || "".equals(baoxianleixing)){
		}else{
			query.setString("baoxianleixing", baoxianleixing);
		}
		
		return query.list();
	}
	
	/**
	 *  升序
	 */
	public List<BaoXian> baoXianShengXu(String chepaihao, String baodanhao, Date  chaxunxiaoyudaoqiriqi, Date  chaxundayudaoqiriqi,String baoxianleixing){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from BaoXian where id is not null ");
//		判断值是否为空
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}		
		if(baodanhao==null || "".equals(baodanhao)){
		}else{
			hql.append(" and baodanhao like :baodanhao");
		}
		if(chaxunxiaoyudaoqiriqi == null || "".equals(chaxunxiaoyudaoqiriqi)){
		}else{
			hql.append(" and daoqiriqi <= :chaxunxiaoyudaoqiriqi");
		}
		if(chaxundayudaoqiriqi == null || "".equals(chaxundayudaoqiriqi)){
		}else{
			hql.append(" and daoqiriqi >= :chaxundayudaoqiriqi");
		}
		if(baoxianleixing == null || "".equals(baoxianleixing)){
		}else{
			hql.append(" and baoxianleixing like :baoxianleixing");
		}
		
		hql.append(" order by toubaojine asc ");
		
//		创建query对象
		Query query = baoXianDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
//		判断是否要添加值
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", "%"+chepaihao+"%");
		}		
		if(baodanhao==null || "".equals(baodanhao)){
		}else{
			query.setString("baodanhao", "%"+baodanhao+"%");
		}
		if(chaxunxiaoyudaoqiriqi == null || "".equals(chaxunxiaoyudaoqiriqi)){
		}else{
			query.setDate("chaxunxiaoyudaoqiriqi", chaxunxiaoyudaoqiriqi);
		}
		if(chaxundayudaoqiriqi == null || "".equals(chaxundayudaoqiriqi)){
		}else{
			query.setDate("chaxundayudaoqiriqi", chaxundayudaoqiriqi);
		}
		if(baoxianleixing == null || "".equals(baoxianleixing)){
		}else{
			query.setString("baoxianleixing", baoxianleixing);
		}
		
		return query.list();
	}
	
	
	/**
	 *  得到指定id保险对象
	 */
	public BaoXian getSingleBaoXian(Integer id){
		return baoXianDao.findById(id);
	}
	
	/**
	 *  删除指定id保险
	 */
	public void deleteBaoXianId(Integer id){
		BaoXian baoxian = new BaoXian();
		baoxian.setId(id);
		baoXianDao.delete(baoxian);
	}
	
	/**
	 *  删除指定车牌号的保险
	 */
	public void deleteBaoXianChePaiHao(String chepaihao){
		baoXianDao.deleteBaoXianChePaiHao(chepaihao);
	}
	
	/**
	 *  添加保险
	 */
	public void addBaoXian(BaoXian baoxian){
		baoXianDao.save(baoxian);
	}
	
	/**
	 *  修改保险
	 */
	public void updateBaoXian(BaoXian baoxian){
		baoXianDao.update(baoxian);
	}
	
	/**
	 *  保存和修改
	 */
	public void saveAndUpdateBaoXian(BaoXian baoxian){
		baoXianDao.saveAndUpdate(baoxian);
	}
	
	/**
	 *  get set
	 */
	public BaoXianDao getBaoXianDao() {
		return baoXianDao;
	}

	public void setBaoXianDao(BaoXianDao baoXianDao) {
		this.baoXianDao = baoXianDao;
	}
	
}
