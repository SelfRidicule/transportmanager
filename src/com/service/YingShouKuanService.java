package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.YingShouKuanDao;
import com.entity.YingShouKuan;
import com.entity.YingYunZheng;

/**
 *  营收款 业务层
 */
public class YingShouKuanService {
	/**
	 * 构造方法
	 */
	public YingShouKuanService() {
		super();
	}

	/**
	 * 属性
	 */
	private YingShouKuanDao yingShouKuanDao;	//营收款dao对象

	/**
	 *  查询所有营收款
	 */
	public List<YingShouKuan> queryYingShouKuanList(){
		return yingShouKuanDao.queryYingShouKuanList();
	}
	
	/**
	 * 查询指定 营收款 判断类型
	 */
	public List<YingShouKuan> queryYingShouKuanByConditionList(String Condition ,String value){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YingShouKuan where " +  Condition  +" = :"+Condition + " order by id desc ");
//		创建query对象
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
//		赋值
		query.setString(Condition , value);
//		查询
		return query.list();
	}
	
	/**
	 * 查询指定 Arr营收款 判断类型
	 */
	public List<YingShouKuan> queryYingShouKuanByConditionArrList(String Condition[] ,String value[]){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YingShouKuan where  ");
		
		for (int i = 0; i < Condition.length; i++) {
			if(i == 0){
				hql.append(" "+  Condition[i]  +" = :"+Condition[i] + " ");
			}else{
				hql.append(" and "+  Condition[i]  +" = :"+Condition[i] + " ");	
			}
		}
		
		hql.append(" order by id desc ");
		
//		创建query对象
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
//		赋值
		for (int i = 0; i < Condition.length; i++) {
			query.setString(Condition[i] , value[i]);
		}
		
//		查询
		return query.list();
	}
	
	/**
	 *  查询所有未办理的营收款
	 */
	public List<YingShouKuan> queryYingShouKuanWeiDengJi(){
		return yingShouKuanDao.queryYingShouKuanWeiDengJi();
	}
	
	/**
	 *  查询指定id的营收款
	 */
	public YingShouKuan queryYingShouKuanId(Integer id){
		return yingShouKuanDao.findById(id);
	}
	
	/**
	 *  指定订单号的营收款
	 */
	public YingShouKuan queryYingShouKuanDingDanHao(String dingdanhao){
		return yingShouKuanDao.queryYingShouKuanDingDanHao(dingdanhao);
	}
	
	/**
	 *  模糊查询
	 */
	public List<YingShouKuan> vagueSearchYingShouKuan(String dingdanhao,String yingshoukuanzhuangtai, String jiesuanzhuangtai ,String kehudanwei ,String pageSize ,String pageNumber){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YingShouKuan where id is not null ");
//		判断值是否为空
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			hql.append(" and dingdanhao like :dingdanhao");
		}
		if(yingshoukuanzhuangtai==null || "".equals(yingshoukuanzhuangtai)){
		}else{
			hql.append(" and yingshoukuanzhuangtai = :yingshoukuanzhuangtai");
		}
		if(jiesuanzhuangtai==null || "".equals(jiesuanzhuangtai)){
		}else{
			hql.append(" and jiesuanzhuangtai = :jiesuanzhuangtai");
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			hql.append(" and kehudanwei like :kehudanwei");
		}
		
		hql.append(" order by id desc ");
//		创建query对象
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			query.setString("dingdanhao", "%"+dingdanhao+"%");
		}
		if(yingshoukuanzhuangtai==null || "".equals(yingshoukuanzhuangtai)){
		}else{
			query.setString("yingshoukuanzhuangtai", yingshoukuanzhuangtai);
		}
		if(jiesuanzhuangtai==null || "".equals(jiesuanzhuangtai)){
		}else{
			query.setString("jiesuanzhuangtai", jiesuanzhuangtai);
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			query.setString("kehudanwei", "%"+kehudanwei+"%");
		}
		
		Integer Number = Integer.valueOf(pageNumber) ;
		Integer Size = Integer.valueOf(pageSize) ;
		
		query.setFirstResult( (Number-1) * Size ); //从第0条开始      
		query.setMaxResults(Size); //取出10条     
		
		return query.list();
	}
	
	/**
	 *  模糊查询数量
	 */
	public Long countSearchYingShouKuan(String dingdanhao,String yingshoukuanzhuangtai, String jiesuanzhuangtai ,String kehudanwei ,String pageSize ,String pageNumber){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer(" select count(*) from YingShouKuan where id is not null ");
//		判断值是否为空
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			hql.append(" and dingdanhao like :dingdanhao");
		}
		if(yingshoukuanzhuangtai==null || "".equals(yingshoukuanzhuangtai)){
		}else{
			hql.append(" and yingshoukuanzhuangtai = :yingshoukuanzhuangtai");
		}
		if(jiesuanzhuangtai==null || "".equals(jiesuanzhuangtai)){
		}else{
			hql.append(" and jiesuanzhuangtai = :jiesuanzhuangtai");
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			hql.append(" and kehudanwei like :kehudanwei");
		}
		
//		创建query对象
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			query.setString("dingdanhao", "%"+dingdanhao+"%");
		}
		if(yingshoukuanzhuangtai==null || "".equals(yingshoukuanzhuangtai)){
		}else{
			query.setString("yingshoukuanzhuangtai", yingshoukuanzhuangtai);
		}
		if(jiesuanzhuangtai==null || "".equals(jiesuanzhuangtai)){
		}else{
			query.setString("jiesuanzhuangtai", jiesuanzhuangtai);
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			query.setString("kehudanwei", "%"+kehudanwei+"%");
		}
		
		
		return (Long) query.uniqueResult();
	}
	
	/**
	 *  模糊查询
	 */
	public List<YingShouKuan> vagueSearchYingShouKuanCondition(String dingdanhao,String yingshoukuanzhuangtai, String jiesuanzhuangtai ,String kehudanwei,String conditionName ,String conditionValue){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YingShouKuan where id is not null ");
		hql.append(" and  " + conditionName + " = :"+conditionName);
//		判断值是否为空
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			hql.append(" and dingdanhao like :dingdanhao");
		}
		if(yingshoukuanzhuangtai==null || "".equals(yingshoukuanzhuangtai)){
		}else{
			hql.append(" and yingshoukuanzhuangtai = :yingshoukuanzhuangtai");
		}
		if(jiesuanzhuangtai==null || "".equals(jiesuanzhuangtai)){
		}else{
			hql.append(" and jiesuanzhuangtai = :jiesuanzhuangtai");
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			hql.append(" and kehudanwei like :kehudanwei");
		}
		
//		创建query对象
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setString(conditionName, conditionValue);
		
//		判断值是否赋值
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			query.setString("dingdanhao", "%"+dingdanhao+"%");
		}
		if(yingshoukuanzhuangtai==null || "".equals(yingshoukuanzhuangtai)){
		}else{
			query.setString("yingshoukuanzhuangtai", yingshoukuanzhuangtai);
		}
		if(jiesuanzhuangtai==null || "".equals(jiesuanzhuangtai)){
		}else{
			query.setString("jiesuanzhuangtai", jiesuanzhuangtai);
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			query.setString("kehudanwei", "%"+kehudanwei+"%");
		}
		
		return query.list();
	}
	
	/**
	 *  模糊查询
	 */
	public List<YingShouKuan> vagueSearchKaiPiaoShenQing(String dingdanhao,String kaipiaoshenqing, String kehudanwei){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YingShouKuan where id is not null ");
//		判断值是否为空
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			hql.append(" and dingdanhao like :dingdanhao");
		}
		if(kaipiaoshenqing==null || "".equals(kaipiaoshenqing)){
		}else{
			hql.append(" and kaipiaoshenqing = :kaipiaoshenqing");
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			hql.append(" and kehudanwei like :kehudanwei");
		}
		
		
//		创建query对象
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			query.setString("dingdanhao", "%"+dingdanhao+"%");
		}
		if(kaipiaoshenqing==null || "".equals(kaipiaoshenqing)){
		}else{
			query.setString("kaipiaoshenqing", kaipiaoshenqing);
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			query.setString("kehudanwei", "%"+kehudanwei+"%");
		}
		
		
		return query.list();
	}
	
	/**
	 *  模糊查询
	 */
	public List<YingShouKuan> vagueSearchJieSuanShenQing(String dingdanhao,String jiesuanshenqing , String kehudanwei){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YingShouKuan where id is not null ");
//		判断值是否为空
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			hql.append(" and dingdanhao like :dingdanhao");
		}
		if(jiesuanshenqing==null || "".equals(jiesuanshenqing)){
		}else{
			hql.append(" and jiesuanshenqing = :jiesuanshenqing");
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			hql.append(" and kehudanwei like :kehudanwei");
		}
		
//		创建query对象
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			query.setString("dingdanhao", "%"+dingdanhao+"%");
		}
		if(jiesuanshenqing==null || "".equals(jiesuanshenqing)){
		}else{
			query.setString("jiesuanshenqing", jiesuanshenqing);
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			query.setString("kehudanwei", "%"+kehudanwei+"%");
		}
		
		return query.list();
	}
	
	/**
	 *  模糊查询
	 */
	public List<YingShouKuan> vagueSearchByCondition(String conditionName[] ,String conditionValue[]){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YingShouKuan where id is not null ");
		
//		判断值是否为空
		for (int i = 0; i < conditionValue.length; i++) {
			if(conditionValue[i]==null || "".equals(conditionValue[i])){
			}else{
				hql.append(" and  " + conditionName[i] + " like :"+conditionName[i]);
			}
		}
		
//		创建query对象
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		for (int i = 0; i < conditionValue.length; i++) {
			if(conditionValue[i]==null || "".equals(conditionValue[i])){
			}else{
				query.setString(conditionName[i], "%"+conditionValue[i]+"%");
			}
		}
		
		return query.list();
	}
	
	
	/**
	 *  模糊查询
	 */
	public List<YingShouKuan> vagueSearchYingShouKuanAll(String dingdanhao,String yingshoukuanzhuangtai, String jiesuanzhuangtai ,String kehudanwei){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YingShouKuan where id is not null ");
//		判断值是否为空
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			hql.append(" and dingdanhao like :dingdanhao");
		}
		if(yingshoukuanzhuangtai==null || "".equals(yingshoukuanzhuangtai)){
		}else{
			hql.append(" and yingshoukuanzhuangtai = :yingshoukuanzhuangtai");
		}
		if(jiesuanzhuangtai==null || "".equals(jiesuanzhuangtai)){
		}else{
			hql.append(" and jiesuanzhuangtai = :jiesuanzhuangtai");
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			hql.append(" and kehudanwei like :kehudanwei");
		}
		
//		创建query对象
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			query.setString("dingdanhao", "%"+dingdanhao+"%");
		}
		if(yingshoukuanzhuangtai==null || "".equals(yingshoukuanzhuangtai)){
		}else{
			query.setString("yingshoukuanzhuangtai", yingshoukuanzhuangtai);
		}
		if(jiesuanzhuangtai==null || "".equals(jiesuanzhuangtai)){
		}else{
			query.setString("jiesuanzhuangtai", jiesuanzhuangtai);
		}
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			query.setString("kehudanwei", "%"+kehudanwei+"%");
		}
		
		return query.list();
	}
	
	
	/**
	 *  添加营收款
	 */
	public void addYingShouKuan(YingShouKuan yingshoukuan){
		yingShouKuanDao.save(yingshoukuan);
	}
	
	/**
	 *  修改营收款
	 */
	public void updateYingShouKuan(YingShouKuan yingshoukuan){
		yingShouKuanDao.update(yingshoukuan);
	}
	
	/**
	 *  删除指定id的营收款
	 */
	public void deleteYingShouKuanId(Integer id){
		StringBuffer sf = new StringBuffer(" delete from YingShouKuan where id = :id ");
		Query query = yingShouKuanDao.getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setInteger("id", id);
		query.executeUpdate();
	}
	
	/**
	 *  修改营收款指定列的值
	 */
	public void updateYingShouKuanColumnNameValue( String value, String myId , String columnName ){
		yingShouKuanDao.updateYingShouKuanColumnNameValue(value, myId, columnName);
	}
	
	
	/**
	 *  get set
	 */
	public YingShouKuanDao getYingShouKuanDao() {
		return yingShouKuanDao;
	}

	public void setYingShouKuanDao(YingShouKuanDao yingShouKuanDao) {
		this.yingShouKuanDao = yingShouKuanDao;
	}
	
}
