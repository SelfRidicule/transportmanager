package com.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.dao.KaiPiaoDao;
import com.entity.KaiPiao;
import com.entity.YingShouKuan;

/**
 * 	开票业务层
 */
public class KaiPiaoService {
	/**
	 * 构造方法
	 */
	public KaiPiaoService() {
		super();
	}

	/**
	 * 属性
	 */
	private KaiPiaoDao kaiPiaoDao;	//开票dao对象

	/**
	 *  查询所有开票
	 */
	public List<KaiPiao> queryKaiPiaoList(){
		return kaiPiaoDao.queryKaiPiaoList();
	}
	
	/**
	 *  查询指定id的开票
	 */
	public KaiPiao queryKaiPiaoId(Integer id){
		return kaiPiaoDao.findById(id);
	}
	
	/**
	 *  模糊查询
	 */
	public List<KaiPiao> vagueSearchKaiPiao(String kehudanwei,String chengyunren,String huowumingcheng ,Date chaxunxiaoyulingkuanshijian, Date chaxundayulingkuanshijian){
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from KaiPiao where id is not null ");
//		判断值是否为空
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			hql.append(" and kehudanwei like :kehudanwei");
		}
		if(chengyunren==null || "".equals(chengyunren)){
		}else{
			hql.append(" and chengyunren like :chengyunren");
		}
		if(huowumingcheng==null || "".equals(huowumingcheng)){
		}else{
			hql.append(" and huowumingcheng like :huowumingcheng");
		}
		if(chaxunxiaoyulingkuanshijian==null || "".equals(chaxunxiaoyulingkuanshijian)){
		}else{
			hql.append(" and lingkuanshijian < :chaxunxiaoyulingkuanshijian");
		}
		if(chaxundayulingkuanshijian==null || "".equals(chaxundayulingkuanshijian)){
		}else{
			hql.append(" and lingkuanshijian > :chaxundayulingkuanshijian");
		}
		
//		创建query对象
		Query query = kaiPiaoDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(kehudanwei==null || "".equals(kehudanwei)){
		}else{
			query.setString("kehudanwei", "%"+kehudanwei+"%");
		}
		if(chengyunren==null || "".equals(chengyunren)){
		}else{
			query.setString("chengyunren", "%"+chengyunren+"%");
		}
		if(huowumingcheng==null || "".equals(huowumingcheng)){
		}else{
			query.setString("huowumingcheng", "%"+huowumingcheng+"%");
		}
		if(chaxunxiaoyulingkuanshijian==null || "".equals(chaxunxiaoyulingkuanshijian)){
		}else{
			query.setDate("chaxunxiaoyulingkuanshijian", chaxunxiaoyulingkuanshijian);
		}
		if(chaxundayulingkuanshijian==null || "".equals(chaxundayulingkuanshijian)){
		}else{
			query.setDate("chaxundayulingkuanshijian", chaxundayulingkuanshijian);
		}
		
		return query.list();
	}
	
	/**
	 *  添加开票
	 */
	public void addKaiPiao(KaiPiao kaipiao){
		kaiPiaoDao.save(kaipiao);
	}
	
	/**
	 *  删除开票
	 */
	public void deleteKaiPiao(KaiPiao kaipiao){
		kaiPiaoDao.delete(kaipiao);
	}
	
	/**
	 *  修改开票
	 */
	public void updateKaiPiao(KaiPiao kaipiao){
		kaiPiaoDao.update(kaipiao);
	}
	
	/**
	 *  get set
	 */
	public KaiPiaoDao getKaiPiaoDao() {
		return kaiPiaoDao;
	}

	public void setKaiPiaoDao(KaiPiaoDao kaiPiaoDao) {
		this.kaiPiaoDao = kaiPiaoDao;
	}
	
}
