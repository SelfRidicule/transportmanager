package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.entity.YunDan;

/**
 *  运单dao层
 */
public class YunDanDao extends Dao<YunDan>{
	/**
	 * 构造方法
	 */
	public YunDanDao() {
		super();
	}
	
	/**
	 *  查询所有运单
	 */
	public List<YunDan> queryYunDanList(){
		StringBuffer sf = new StringBuffer("from YunDan  order by id  desc ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		return query.list();
	}
	
	/**
	 *  查询指定操作员所有运单
	 */
	public List<YunDan> queryYunDanCaoZuoYuanList(String caozuoyuan){
		StringBuffer sf = new StringBuffer(" from YunDan where caozuoyuan = :caozuoyuan ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("caozuoyuan", caozuoyuan);
		return query.list();
	}
	
	/**
	 *  查询指定操作员所有运单，并且降序
	 */
	public List<YunDan> queryYunDanCaoZuoYuanOrderByList(String caozuoyuan){
		StringBuffer sf = new StringBuffer(" from YunDan where caozuoyuan = :caozuoyuan order by id  desc ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("caozuoyuan", caozuoyuan);
		return query.list();
	}
	
	
	/**
	 *  查询指定车牌号的运单
	 */
	public List<YunDan> queryYunDanChePaiHao(String chepaihao){
		StringBuffer sf = new StringBuffer(" from YunDan where chepaihao = :chepaihao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		return query.list();
	}
	
	/**
	 *  查询指定车牌号和运单状态
	 */
	public List<YunDan> queryYunDanChePaiHaoAndDaiJieDan(String chepaihao , String yundanzhuangtai){
		StringBuffer sf = new StringBuffer(" from YunDan where chepaihao = :chepaihao and yundanzhuangtai = :yundanzhuangtai ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("chepaihao", chepaihao);
		query.setString("yundanzhuangtai", yundanzhuangtai);
		return query.list();
	}
	
	/**
	 *  查询指定订单号的订单对象
	 */
	public YunDan queryYunDanDingDanHao(String dingdanhao){
		StringBuffer sf = new StringBuffer(" from YunDan where dingdanhao = :dingdanhao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("dingdanhao", dingdanhao);
		return (YunDan) query.uniqueResult();
	}
	
	/**
	 *  查询指定订单号 -数量
	 */
	public int queryYunDanDingDanHaoShuLiang(String dingdanhao){
		StringBuffer sf = new StringBuffer(" from YunDan where dingdanhao = :dingdanhao ");
		Query query = getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("dingdanhao", dingdanhao);
		return query.list().size();
	}
	
	/**
	 *  修改运单指定列的值
	 */
	public void updateYunDanColumnNameValue( String value, String dingdanhao , String columnName ){
		
		StringBuffer sf = new StringBuffer(" update yundan set " +columnName+ " = '"+value+"' where dingdanhao = '"+dingdanhao+"'");
		Query query = getSessionFactory().getCurrentSession().createSQLQuery(sf.toString());
		query.executeUpdate();
		
	}
	
}
