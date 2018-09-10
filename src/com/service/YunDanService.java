package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.dao.YunDanDao;
import com.entity.QuanXian;
import com.entity.YunDan;

/**
 *  运单业务层
 */
public class YunDanService {
	/**
	 * 构造方法
	 */
	public YunDanService() {
		super();
	}

	/**
	 * 属性
	 */
	private YunDanDao yunDanDao;	//运单dao属性

	/**
	 *  查询指定操作员所有运单
	 */
	public List<YunDan> queryYunDanCaoZuoYuanList(String caozuoyuan , HttpSession session){
		
		List<QuanXian> usersquanxianlist  = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist == null){
			return null;
		}
		for (int i = 0; i < usersquanxianlist.size(); i++) {
			QuanXian quanxian = usersquanxianlist.get(i);
			if("运单管理".equals(quanxian.getQuanxianbumen())  &&  "1".equals(quanxian.getChakansuoyou())){
				return yunDanDao.queryYunDanList();
			}
		}
		
		return yunDanDao.queryYunDanCaoZuoYuanList(caozuoyuan);
	}
	
	/**
	 *  查询指定操作员所有运单，并且降序
	 */
	public List<YunDan> queryYunDanCaoZuoYuanOrderByList(String caozuoyuan , HttpSession session){
		
		List<QuanXian> usersquanxianlist  = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist == null){
			return null;
		}
		for (int i = 0; i < usersquanxianlist.size(); i++) {
			QuanXian quanxian = usersquanxianlist.get(i);
			if("运单管理".equals(quanxian.getQuanxianbumen())  &&  "1".equals(quanxian.getChakansuoyou())){
				return yunDanDao.queryYunDanList();
			}
		}
		
		return yunDanDao.queryYunDanCaoZuoYuanOrderByList(caozuoyuan);
	}
	
	/**
	 *  查询指定订单号的订单对象
	 */
	public YunDan queryYunDanDingDanHao(String dingdanhao){
		return yunDanDao.queryYunDanDingDanHao(dingdanhao);
	}
	
	/**
	 *  查询指定订单号 -数量
	 */
	public int queryYunDanDingDanHaoShuLiang(String dingdanhao){
		return yunDanDao.queryYunDanDingDanHaoShuLiang(dingdanhao);
	}
	
	/**
	 *  查询指定车牌号的运单
	 */
	public List<YunDan> queryYunDanChePaiHao(String chepaihao){
		return yunDanDao.queryYunDanChePaiHao(chepaihao);
	}
	
	/**
	 *  查询指定车牌号和运单状态
	 */
	public List<YunDan> queryYunDanChePaiHaoAndDaiJieDan(String chepaihao , String yundanzhuangtai){
		return yunDanDao.queryYunDanChePaiHaoAndDaiJieDan(chepaihao, yundanzhuangtai);
	}
	
	/**
	 *  查询所有运单
	 */
	public List<YunDan> queryYunDanList(){
		return yunDanDao.queryYunDanList();
	}
	
	/**
	 *  查询指定id的运单
	 */
	public YunDan queryYunDanId(Integer id){
		return yunDanDao.findById(id);
	}
	
	/**
	 *  模糊查询运单
	 */
	public List<YunDan> vagueSearchYunDan(String caozuoyuan,String dingdanhao, String yundanzhuangtai, String chepaihao, String qidian, String zhongdian, String huowumingcheng ,String pageSize ,String pageNumber){
//		 得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpSession session = request.getSession();
		 
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YunDan where id is not null ");
//		判断值是否为空
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			hql.append(" and dingdanhao like :dingdanhao");
		}	
		if(yundanzhuangtai==null || "".equals(yundanzhuangtai)){
		}else{
			hql.append(" and yundanzhuangtai like :yundanzhuangtai");
		}	
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}	
		if(qidian==null || "".equals(qidian)){
		}else{
			hql.append(" and qidian like :qidian");
		}
		if(zhongdian==null || "".equals(zhongdian)){
		}else{
			hql.append(" and zhongdian like :zhongdian");
		}
		if(huowumingcheng==null || "".equals(huowumingcheng)){
		}else{
			hql.append(" and huowumingcheng like :huowumingcheng");
		}
		
		boolean flag = true;
		
		List<QuanXian> usersquanxianlist  = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist == null){
			return null;
		}
		for (int i = 0; i < usersquanxianlist.size(); i++) {
			QuanXian quanxian = usersquanxianlist.get(i);
			if("运单管理".equals(quanxian.getQuanxianbumen())  &&  "1".equals(quanxian.getChakansuoyou())){
				flag = false ;
			}
		}
		
		if(flag){
			hql.append(" and caozuoyuan = :caozuoyuan ");
		}
		
		hql.append(" order by id  desc ");
		
//		创建query对象
		Query query = yunDanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断是否要添加值
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			query.setString("dingdanhao","%"+ dingdanhao +"%");
		}	
		if(yundanzhuangtai==null || "".equals(yundanzhuangtai)){
		}else{
			query.setString("yundanzhuangtai", yundanzhuangtai);
		}	
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", "%"+ chepaihao +"%");
		}	
		if(qidian==null || "".equals(qidian)){
		}else{
			query.setString("qidian",  "%"+ qidian +"%");
		}
		if(zhongdian==null || "".equals(zhongdian)){
		}else{
			query.setString("zhongdian", "%"+ zhongdian +"%");
		}
		if(huowumingcheng==null || "".equals(huowumingcheng)){
		}else{
			query.setString("huowumingcheng", "%"+ huowumingcheng +"%");
		}
		
		if(flag){
			query.setString("caozuoyuan", caozuoyuan);
		}
		
		Integer Number = Integer.valueOf(pageNumber) ;
		Integer Size = Integer.valueOf(pageSize) ;
		
		query.setFirstResult( (Number-1) * Size ); //从第0条开始      
		query.setMaxResults(Size); //取出10条     
		
		return query.list();
	}
	
	/**
	 *  模糊查询运单数量
	 */
	public Long countSearchYunDan(String caozuoyuan,String dingdanhao, String yundanzhuangtai, String chepaihao, String qidian, String zhongdian, String huowumingcheng ,String pageSize ,String pageNumber){
//		 得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpSession session = request.getSession();
		 
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("select count(*) from YunDan where id is not null ");
//		判断值是否为空
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			hql.append(" and dingdanhao like :dingdanhao");
		}	
		if(yundanzhuangtai==null || "".equals(yundanzhuangtai)){
		}else{
			hql.append(" and yundanzhuangtai like :yundanzhuangtai");
		}	
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			hql.append(" and chepaihao like :chepaihao");
		}	
		if(qidian==null || "".equals(qidian)){
		}else{
			hql.append(" and qidian like :qidian");
		}
		if(zhongdian==null || "".equals(zhongdian)){
		}else{
			hql.append(" and zhongdian like :zhongdian");
		}
		if(huowumingcheng==null || "".equals(huowumingcheng)){
		}else{
			hql.append(" and huowumingcheng like :huowumingcheng");
		}
		
		boolean flag = true;
		
		List<QuanXian> usersquanxianlist  = (List<QuanXian>) session.getAttribute("usersquanxianlist");
		if(usersquanxianlist == null){
			return null;
		}
		for (int i = 0; i < usersquanxianlist.size(); i++) {
			QuanXian quanxian = usersquanxianlist.get(i);
			if("运单管理".equals(quanxian.getQuanxianbumen())  &&  "1".equals(quanxian.getChakansuoyou())){
				flag = false ;
			}
		}
		
		if(flag){
			hql.append(" and caozuoyuan = :caozuoyuan ");
		}
		
		
//		创建query对象
		Query query = yunDanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
//		判断是否要添加值
		if(dingdanhao==null || "".equals(dingdanhao)){
		}else{
			query.setString("dingdanhao","%"+ dingdanhao +"%");
		}	
		if(yundanzhuangtai==null || "".equals(yundanzhuangtai)){
		}else{
			query.setString("yundanzhuangtai", yundanzhuangtai);
		}	
		if(chepaihao==null || "".equals(chepaihao)){
		}else{
			query.setString("chepaihao", "%"+ chepaihao +"%");
		}	
		if(qidian==null || "".equals(qidian)){
		}else{
			query.setString("qidian",  "%"+ qidian +"%");
		}
		if(zhongdian==null || "".equals(zhongdian)){
		}else{
			query.setString("zhongdian", "%"+ zhongdian +"%");
		}
		if(huowumingcheng==null || "".equals(huowumingcheng)){
		}else{
			query.setString("huowumingcheng", "%"+ huowumingcheng +"%");
		}
		
		if(flag){
			query.setString("caozuoyuan", caozuoyuan);
		}
		
		
		return (Long) query.uniqueResult();
	}
	
	/**
	 *  模糊查询运单
	 */
	public List<YunDan> queryChePaiHaoAndYunDanZhuangTai(String chepaihao, String yundanzhuangtai){
//		 得到请求对象 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpSession session = request.getSession();
		 
//		创建客户查询语句
		StringBuffer hql = new StringBuffer("from YunDan where id is not null ");

		hql.append(" and chepaihao = :chepaihao");
		hql.append(" and yundanzhuangtai = :yundanzhuangtai");

//		创建query对象
		Query query = yunDanDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		query.setString("chepaihao",  chepaihao );
		query.setString("yundanzhuangtai", yundanzhuangtai);
		
		return query.list();
	}
	
	/**
	 *  添加运单
	 */
	public void addYunDan(YunDan yundan){
		yunDanDao.save(yundan);
	}
	
	/**
	 *  删除运单
	 */
	public void deleteYunDan(Integer id){
		YunDan yundan = new YunDan();
		yundan.setId(id);
		yunDanDao.delete(yundan);
	}
	
	/**
	 *  修改运单
	 */
	public void updateYunDan(YunDan yundan){
		yunDanDao.update(yundan);
	}
	
	/**
	 *  修改运单指定列的值
	 */
	public void updateYunDanColumnNameValue( String value, String dingdanhao , String columnName ){
		yunDanDao.updateYunDanColumnNameValue(value, dingdanhao, columnName);
	}
	
	/**
	 *  get set
	 */
	public YunDanDao getYunDanDao() {
		return yunDanDao;
	}

	public void setYunDanDao(YunDanDao yunDanDao) {
		this.yunDanDao = yunDanDao;
	}
	
}
