package com.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.dao.JiaShiYuanDao;
import com.entity.JiaShiYuan;
import com.entity.QuanXian;
import com.entity.Users;

/**
 *  驾驶员业务层
 */
public class JiaShiYuanService {
	/**
	 * 构造方法
	 */
	public JiaShiYuanService() {
		super();
	}
	
	/**
	 * 属性
	 */
	private JiaShiYuanDao jiaShiYuanDao;	//驾驶员dao对象
	
	/**
	 *  驾驶员登录
	 */
	public List<JiaShiYuan> jiaShiYuanDengLu(String dianhua ,String mima){
		boolean flag = false;
		
		StringBuffer sf = new StringBuffer(" from JiaShiYuan where dianhua = :dianhua and mima = :mima ");
		Query query = jiaShiYuanDao.getSessionFactory().getCurrentSession().createQuery(sf.toString());
		
		query.setString("dianhua", dianhua);
		query.setString("mima", mima);
		
		List<JiaShiYuan> jiashiyuanlist = query.list();
		
		return jiashiyuanlist;
	}
	
	/**
	 *  查询指定的操作员
	 */
	public List<JiaShiYuan> queryCaoZuoYuan(String caozuoyuan){
		
		StringBuffer sf = new StringBuffer(" from JiaShiYuan where  id is not null  ");
		
//		得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpSession session = request.getSession();
		
		List<QuanXian> usersquanxianlist  = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist == null){
			return null;
		}
		for (int i = 0; i < usersquanxianlist.size(); i++) {
			QuanXian quanxian = usersquanxianlist.get(i);
			if("驾驶员年审".equals(quanxian.getQuanxianbumen())  &&  "1".equals(quanxian.getChakansuoyou())){
				sf.append(" order by id desc ");
				return jiaShiYuanDao.getSessionFactory().getCurrentSession().createQuery(sf.toString()).list();
			}
		}
		
		sf.append(" and caozuoyuan = :caozuoyuan ");
		sf.append(" order by id desc ");
		
		Query query = jiaShiYuanDao.getSessionFactory().getCurrentSession().createQuery(sf.toString());
		
		query.setString("caozuoyuan", caozuoyuan);
		
		List<JiaShiYuan> jiashiyuanlist = query.list();
		
		return jiashiyuanlist;
	}

	/**
	 *  查询所有驾驶员
	 */
	public List<JiaShiYuan> queryJiaShiYuan(){
		return jiaShiYuanDao.queryJiaShiYuan();
	}
	
	/**
	 *  查询指定id的驾驶员
	 */
	public JiaShiYuan queryJiaShiYuanId(Integer id){
		return jiaShiYuanDao.findById(id);
	}
	
	/**
	 *  查询指定驾驶员姓名的驾驶员
	 */
	public JiaShiYuan queryJiaShiYuanName(String jiashiyuanxingming){
		return jiaShiYuanDao.queryJiaShiYuanName(jiashiyuanxingming);
	}
	
	/**
	 *  查询指定车牌号的驾驶员集合对象
	 */
	public List<JiaShiYuan> queryJiaShiYuanChePaiHao(String jiashicheliang){
		return jiaShiYuanDao.queryJiaShiYuanChePaiHao(jiashicheliang);
	}
	
	/**
	 *  模糊查询
	 */
	public List<JiaShiYuan> vagueSearchJiaShiYuan( String jiashicheliang, String jiashiyuanxingming, String jiashiyuanleixing, String zhunjiachexing ,String pageSize ,String pageNumber){
//		创建语句
		StringBuffer hql = new StringBuffer("from JiaShiYuan where id is not null ");
		
//		判断值是否为空
		if(jiashicheliang==null || "".equals(jiashicheliang)){
		}else{
			hql.append(" and jiashicheliang like :jiashicheliang");
		}		
		if(jiashiyuanxingming==null || "".equals(jiashiyuanxingming)){
		}else{
			hql.append(" and jiashiyuanxingming like :jiashiyuanxingming");
		}	
		if(jiashiyuanleixing==null || "".equals(jiashiyuanleixing)){
		}else{
			hql.append(" and jiashiyuanleixing like :jiashiyuanleixing");
		}
		if(zhunjiachexing==null || "".equals(zhunjiachexing)){
		}else{
			hql.append(" and zhunjiachexing like :zhunjiachexing");
		}
		
		hql.append(" order by id desc ");
		Query query = jiaShiYuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		
//		判断是否要添加值
		if(jiashicheliang==null || "".equals(jiashicheliang)){
		}else{
			query.setString("jiashicheliang", "%"+jiashicheliang+"%");
		}		
		if(jiashiyuanxingming==null || "".equals(jiashiyuanxingming)){
		}else{
			query.setString("jiashiyuanxingming", "%"+jiashiyuanxingming+"%");
		}	
		if(jiashiyuanleixing==null || "".equals(jiashiyuanleixing)){
		}else{
			query.setString("jiashiyuanleixing", "%"+jiashiyuanleixing+"%");
		}	
		if(zhunjiachexing==null || "".equals(zhunjiachexing)){
		}else{
			query.setString("zhunjiachexing", "%"+zhunjiachexing+"%");
		}	
		
		Integer Number = Integer.valueOf(pageNumber) ;
		Integer Size = Integer.valueOf(pageSize) ;
		
		query.setFirstResult( (Number-1) * Size ); //从第0条开始      
		query.setMaxResults(Size); //取出10条     
		
		return query.list();
		
	}
	
	/**
	 *  查询指定电话的驾驶员
	 */
	public List<JiaShiYuan> queryJiaShiYuanDianHua(String dianhua){
		return jiaShiYuanDao.queryJiaShiYuanDianHua(dianhua);
	}
	
	/**
	 *  查询指定身份证的驾驶员
	 */
	public List<JiaShiYuan> queryJiaShiYuanShenFenZheng(String shenfenzhenghao ){
		return jiaShiYuanDao.queryJiaShiYuanShenFenZheng(shenfenzhenghao);
	}
	
	/**
	 *  添加驾驶员
	 */
	public void addJiaShiYuan(JiaShiYuan jiashiyuan){
		jiaShiYuanDao.save(jiashiyuan);
	}
	
	/**
	 *  删除指定id的驾驶员
	 */
	public void deleteJiaShiYuan(Integer id){
		JiaShiYuan jiashiyuan = new JiaShiYuan();
		jiashiyuan.setId(id);
		jiaShiYuanDao.delete(jiashiyuan);
	}
	
	/**
	 *  修改驾驶员
	 */
	public void updateJiaShiYuan(JiaShiYuan jiashiyuan){
		jiaShiYuanDao.update(jiashiyuan);
	}
	
	/**
	 *  查询未审核的驾驶员 
	 */
	public List<JiaShiYuan> queryJiaShiYuanWeiShenHe(){
		return jiaShiYuanDao.queryJiaShiYuanWeiShenHe();
	}
	
	/**
	 *  查询审核通过的驾驶员 
	 */
	public List<JiaShiYuan> queryJiaShiYuanShenHeTongGuo(){
		return jiaShiYuanDao.queryJiaShiYuanShenHeTongGuo();
	}

	
	/**
	 * 驾驶员数量
	 */
	public Long jiaShiYuanSize( String jiashicheliang, String jiashiyuanxingming, String jiashiyuanleixing, String zhunjiachexing ){
//		创建语句
		StringBuffer hql = new StringBuffer("select count(*) from JiaShiYuan where id is not null ");
		
//		判断值是否为空
		if(jiashicheliang==null || "".equals(jiashicheliang)){
		}else{
			hql.append(" and jiashicheliang like :jiashicheliang");
		}		
		if(jiashiyuanxingming==null || "".equals(jiashiyuanxingming)){
		}else{
			hql.append(" and jiashiyuanxingming like :jiashiyuanxingming");
		}	
		if(jiashiyuanleixing==null || "".equals(jiashiyuanleixing)){
		}else{
			hql.append(" and jiashiyuanleixing like :jiashiyuanleixing");
		}
		if(zhunjiachexing==null || "".equals(zhunjiachexing)){
		}else{
			hql.append(" and zhunjiachexing like :zhunjiachexing");
		}
		
		Query query = jiaShiYuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		
//		判断是否要添加值
		if(jiashicheliang==null || "".equals(jiashicheliang)){
		}else{
			query.setString("jiashicheliang", "%"+jiashicheliang+"%");
		}		
		if(jiashiyuanxingming==null || "".equals(jiashiyuanxingming)){
		}else{
			query.setString("jiashiyuanxingming", "%"+jiashiyuanxingming+"%");
		}	
		if(jiashiyuanleixing==null || "".equals(jiashiyuanleixing)){
		}else{
			query.setString("jiashiyuanleixing", "%"+jiashiyuanleixing+"%");
		}	
		if(zhunjiachexing==null || "".equals(zhunjiachexing)){
		}else{
			query.setString("zhunjiachexing", "%"+zhunjiachexing+"%");
		}	
		
		return (Long) query.uniqueResult();
		
	}
	
//	驾驶员审核
	
	/**
	 *  模糊查询驾驶员审核
	 */
	public List<JiaShiYuan>  vagueSearchJiaShiYuanShenHe(String jiashiyuanxingming, String jiashicheliang, String zhunjiachexing, String shenhezhuangtai){
//		创建语句
		StringBuffer hql = new StringBuffer("from JiaShiYuan where id is not null ");
		
//		判断值是否为空
		if(jiashiyuanxingming==null || "".equals(jiashiyuanxingming)){
		}else{
			hql.append(" and jiashiyuanxingming like :jiashiyuanxingming");
		}		
		if(jiashicheliang==null || "".equals(jiashicheliang)){
		}else{
			hql.append(" and jiashicheliang like :jiashicheliang");
		}	
		if(zhunjiachexing==null || "".equals(zhunjiachexing)){
		}else{
			hql.append(" and zhunjiachexing like :zhunjiachexing");
		}	
		if(shenhezhuangtai==null || "".equals(shenhezhuangtai)){
		}else{
			hql.append(" and shenhezhuangtai like :shenhezhuangtai");
		}	
		
		Query query = jiaShiYuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断值是否赋值
		if(jiashiyuanxingming==null || "".equals(jiashiyuanxingming)){
		}else{
			query.setString("jiashiyuanxingming", jiashiyuanxingming);
		}		
		if(jiashicheliang==null || "".equals(jiashicheliang)){
		}else{
			query.setString("jiashicheliang", jiashicheliang);
		}	
		if(zhunjiachexing==null || "".equals(zhunjiachexing)){
		}else{
			query.setString("zhunjiachexing", zhunjiachexing);
		}	
		if(shenhezhuangtai==null || "".equals(shenhezhuangtai)){
		}else{
			query.setString("shenhezhuangtai", shenhezhuangtai);
		}	
		
		return query.list();
	}
	

//		驾驶员年审
	
	/**
	 *  模糊查询 驾驶员年审
	 */
	public List<JiaShiYuan> vagueSearchJiaShiYuanNianShen( String jiashiyuanxingming, String shenfenzhenghao, Date xiaoyuriqi, Date dayuriqi){
//		 得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpSession session = request.getSession();
		 
//		得到传递的用户对象
		Users users = (Users) session.getAttribute("users");
//				判断是否为null
		if(users == null){
			return null;
		}
		
		List<QuanXian> usersquanxianlist  = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist == null){
			return null;
		}
		
		
//		创建语句
		StringBuffer hql = new StringBuffer("from JiaShiYuan where id is not null ");
		
//		判断值是否为空
		if(jiashiyuanxingming==null || "".equals(jiashiyuanxingming)){
		}else{
			hql.append(" and jiashiyuanxingming like :jiashiyuanxingming");
		}		
		if(shenfenzhenghao==null || "".equals(shenfenzhenghao)){
		}else{
			hql.append(" and shenfenzhenghao like :shenfenzhenghao");
		}	
		if(xiaoyuriqi==null || "".equals(xiaoyuriqi)){
		}else{
			hql.append(" and jiashizhengnianshenriqi < :xiaoyuriqi");
		}	
		if(dayuriqi==null || "".equals(dayuriqi)){
		}else{
			hql.append(" and jiashizhengnianshenriqi > :dayuriqi");
		}	
		
		boolean flag = true;
		
		for (int i = 0; i < usersquanxianlist.size(); i++) {
			QuanXian quanxian = usersquanxianlist.get(i);
			if("驾驶员年审".equals(quanxian.getQuanxianbumen())  &&  "1".equals(quanxian.getChakansuoyou())){
				flag = false;
			}
		}
		
		if(flag){
			hql.append(" and caozuoyuan = :caozuoyuan ");
		}
		
		hql.append(" order by id desc ");
		
		Query query = jiaShiYuanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断是否要添加值
		if(jiashiyuanxingming==null || "".equals(jiashiyuanxingming)){
		}else{
			query.setString("jiashiyuanxingming", "%"+jiashiyuanxingming+"%");
		}		
		if(shenfenzhenghao==null || "".equals(shenfenzhenghao)){
		}else{
			query.setString("shenfenzhenghao", "%"+shenfenzhenghao+"%");
		}	
		if(xiaoyuriqi==null || "".equals(xiaoyuriqi)){
		}else{
			query.setDate("xiaoyuriqi", xiaoyuriqi);
		}	
		if(dayuriqi==null || "".equals(dayuriqi)){
		}else{
			query.setDate("dayuriqi", dayuriqi);
		}	
		
		if(flag){
			query.setString("caozuoyuan",  users.getUsersid().toString() );
		}
		
		return query.list();
		
	}
	
	/**
	 *  get set
	 */
	public JiaShiYuanDao getJiaShiYuanDao() {
		return jiaShiYuanDao;
	}

	public void setJiaShiYuanDao(JiaShiYuanDao jiaShiYuanDao) {
		this.jiaShiYuanDao = jiaShiYuanDao;
	}
	
}
