package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.CheLiangDao;
import com.dao.ZhengJianDao;
import com.entity.CheLiang;

/**
 * 车辆业务层
 */
public class CheLiangService {
	/**
	 * 构造方法
	 */
	public CheLiangService() {
		super();
	}

	/**
	 * 属性
	 */
	private CheLiangDao cheLiangDao;

	/**
	 *  查询所有车辆
	 */
	public List<CheLiang> queryCheLiangList(){
		return cheLiangDao.queryCheLiangList();
	}
	
	/**
	 *  查询指定id的车辆
	 */
	public CheLiang queryIdCheLiang(Integer id){
		return cheLiangDao.findById(id);
	}
	
	/**
	 *  查询指定车牌号的车辆
	 */
	public CheLiang queryChePaiHaoCheLiang(String chepaihao){
		 return cheLiangDao.queryChePaiHaoCheLiang(chepaihao);
	}
	
	/**
	 *  查询指定车型id的集合对象
	 */
	public List<CheLiang> queryCheLiangCheXingId(Integer id){
		return cheLiangDao.queryCheLiangCheXingId(id);
	}
	
	/**
	 *  模糊查询车辆
	 */
	public List<CheLiang> vagueSearchCheLiang(String chepaihao,String chexing,String cheliangleixing, String pingpaixinghao,String zhuangtai,String caozuoyuan ,String pageSize ,String pageNumber){
		StringBuffer hql = new StringBuffer("from CheLiang where id is not null");
		
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}
		if(chexing==null || "".equals(chexing)){
		}else{
			hql.append(" and chexing like :chexing");
		}
		if(cheliangleixing==null || "".equals(cheliangleixing)){
		}else{
			hql.append(" and cheliangleixing like :cheliangleixing");
		}
		if(pingpaixinghao==null || "".equals(pingpaixinghao)){
		}else{
			hql.append(" and pingpaixinghao like :pingpaixinghao");
		}
		if(zhuangtai==null || "".equals(zhuangtai)){
		}else{
			hql.append(" and zhuangtai like :zhuangtai");
		}
		if(caozuoyuan==null || "".equals(caozuoyuan)){
		}else{
			hql.append(" and caozuoyuan like :caozuoyuan");
		}
		
		hql.append(" order by id desc ");
		
		Query query = cheLiangDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", "%"+chepaihao+"%");
		}
		if(chexing==null || "".equals(chexing)){
		}else{
			query.setString("chexing", "%"+chexing+"%");
		}
		if(cheliangleixing==null || "".equals(cheliangleixing)){
		}else{
			query.setString("cheliangleixing", "%"+cheliangleixing+"%");
		}
		if(pingpaixinghao==null || "".equals(pingpaixinghao)){
		}else{
			query.setString("pingpaixinghao", "%"+pingpaixinghao+"%");
		}
		if(zhuangtai==null || "".equals(zhuangtai)){
		}else{
			query.setString("zhuangtai", "%"+zhuangtai+"%");
		}
		if(caozuoyuan==null || "".equals(caozuoyuan)){
		}else{
			query.setString("caozuoyuan", "%"+caozuoyuan+"%");
		}
		
		Integer Number = Integer.valueOf(pageNumber) ;
		Integer Size = Integer.valueOf(pageSize) ;
		
		query.setFirstResult( (Number-1) * Size ); //从第0条开始      
		query.setMaxResults(Size); //取出10条     
		
		return  query.list();
		
	}
	
	/**
	 *  模糊查询新车管理
	 */
	public List<CheLiang> vagueSearchXinCheGuanLi(String chepaihao, String caozuoyuan){
//		创建hql语句
		StringBuffer hql = new StringBuffer("from CheLiang where id is not null");
//		判断是否追加
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}
		if(caozuoyuan==null || "".equals(caozuoyuan)){
		}else{
			hql.append(" and caozuoyuan like :caozuoyuan");
		}
		
		Query query = cheLiangDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断是否赋值
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", chepaihao);
		}
		if(caozuoyuan==null || "".equals(caozuoyuan)){
		}else{
			query.setString("caozuoyuan", caozuoyuan);
		}
		
		return query.list();
	}
	
	/**
	 *  查询指定车主姓名
	 */
	public List<CheLiang> queryCheZhuXingMing(String chezhuxingming){
//		创建hql语句
		StringBuffer hql = new StringBuffer(" from CheLiang where chezhuxingming = :chezhuxingming ");
		
		Query query = cheLiangDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		query.setString("chezhuxingming", chezhuxingming);
		
		return query.list();
	}
	
	/**
	 *  添加车辆
	 */
	public void addCheLiang(CheLiang cheliang){
		cheLiangDao.save(cheliang);
		
	}
	
	/**
	 *  删除车辆
	 */
	public void deleteCheLiang(Integer id){
		CheLiang cheliang = new CheLiang();
		cheliang.setId(id);
		cheLiangDao.delete(cheliang);
	}
	
	/**
	 *  修改车辆
	 */
	public void updateCheLiang(CheLiang cheliang){
		cheLiangDao.update(cheliang);
	}
	
	/**
	 *  修改和保存车辆
	 */
	public void updateAndSaveCheLiang(CheLiang cheliang){
		cheLiangDao.saveAndUpdate(cheliang);
	}
	
	public Long cheLiangSize(String chepaihao,String chexing,String cheliangleixing, String pingpaixinghao,String zhuangtai,String caozuoyuan){
		
		StringBuffer hql = new StringBuffer(" select count(*) from CheLiang  where id is not null ");
		
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}
		if(chexing==null || "".equals(chexing)){
		}else{
			hql.append(" and chexing like :chexing");
		}
		if(cheliangleixing==null || "".equals(cheliangleixing)){
		}else{
			hql.append(" and cheliangleixing like :cheliangleixing");
		}
		if(pingpaixinghao==null || "".equals(pingpaixinghao)){
		}else{
			hql.append(" and pingpaixinghao like :pingpaixinghao");
		}
		if(zhuangtai==null || "".equals(zhuangtai)){
		}else{
			hql.append(" and zhuangtai like :zhuangtai");
		}
		if(caozuoyuan==null || "".equals(caozuoyuan)){
		}else{
			hql.append(" and caozuoyuan like :caozuoyuan");
		}
		
		Query query = cheLiangDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", "%"+chepaihao+"%");
		}
		if(chexing==null || "".equals(chexing)){
		}else{
			query.setString("chexing", "%"+chexing+"%");
		}
		if(cheliangleixing==null || "".equals(cheliangleixing)){
		}else{
			query.setString("cheliangleixing", "%"+cheliangleixing+"%");
		}
		if(pingpaixinghao==null || "".equals(pingpaixinghao)){
		}else{
			query.setString("pingpaixinghao", "%"+pingpaixinghao+"%");
		}
		if(zhuangtai==null || "".equals(zhuangtai)){
		}else{
			query.setString("zhuangtai", "%"+zhuangtai+"%");
		}
		if(caozuoyuan==null || "".equals(caozuoyuan)){
		}else{
			query.setString("caozuoyuan", "%"+caozuoyuan+"%");
		}
		
		return  (Long) query.uniqueResult();
		
	}
	
	
	/**
	 *  get set
	 */
	public CheLiangDao getCheLiangDao() {
		return cheLiangDao;
	}

	public void setCheLiangDao(CheLiangDao cheLiangDao) {
		this.cheLiangDao = cheLiangDao;
	}
	
}
