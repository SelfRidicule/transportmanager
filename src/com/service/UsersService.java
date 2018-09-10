package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.dao.UsersDao;
import com.entity.Users;

/**
 * 用户 业务层 
 */
public class UsersService {
	
	/**
	 * 构造方法
	 */
	public UsersService() {
		super();
	}
	
	/**
	 * 属性
	 */
	private UsersDao usersDao;

	/**
	 *  查询所有的用户
	 */
	public List<Users> queryUsersAll(){
		return usersDao.findAll();
	}
	
	/**
	 * 查询指定权限名称的用户集合
	 */
	public List<Users> queryUsersQuanXianMingCheng(String quanxianmingcheng) {
		return usersDao.queryUsersQuanXianMingCheng(quanxianmingcheng);
	}
	
	public Users  queryId(Integer id){
		return usersDao.findById(id);
	}
	
	
	/**
	 *  模糊查询用户
	 */
	public List<Users> vagueUsers(String deptid,String account,String email,String quanxianmingcheng){ 
		
		
		StringBuffer hql= new StringBuffer("from Users where  usersid is not null ");
		
		if("".equals(deptid) || deptid==null){
		}else{
			hql.append(" and deptid like :deptid");
		}
		
		if("".equals(account) || account==null){
		}else{
			hql.append(" and account like :account");
		}
		
		if("".equals(email) || email==null){
		}else{
			hql.append(" and email like :email");
		}
		
		if("".equals(quanxianmingcheng) || quanxianmingcheng==null){
		}else{
			hql.append(" and quanxianmingcheng like :quanxianmingcheng");
		}
		
		Query query = usersDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		
		if("".equals(deptid) || deptid==null){
		}else{
			query.setString("deptid", "%"+deptid+"%");
		}
		
		if("".equals(account) || account==null){
		}else{
			query.setString("account", "%"+account+"%");
		}
		
		if("".equals(email) || email==null){
		}else{
			query.setString("email", "%"+email+"%");
		}
		
		if("".equals(quanxianmingcheng) || quanxianmingcheng==null){
		}else{
			query.setString("quanxianmingcheng", "%"+quanxianmingcheng+"%");
		}
		
		List<Users> list = query.list();
		
		return list;
	}
	
	/**
	 *  删除指定id的用户
	 */
	public void deleteUsers(Integer id){
		Users users = new Users();
		users.setUsersid(id);
		usersDao.delete(users);
	}
	
	/**
	 *  添加用户 
	 */
	public void addUsers(Users users){
		usersDao.save(users);
	}
	
	/**
	 *  登录用户
	 */
	public Integer loginUsers(String account,String password){
		return usersDao.loginUsers(account, password);
	}
	
	/**
	 *  得到指定id用户
	 */
	public Users getSingleUsers(Integer id){
		return usersDao.getSingleUsers(id);
	}

	/**
	 *  修改用户
	 */
	public void updateUsers(Users users){
		usersDao.updateUsers(users);
	}
	
	/**
	 *   是否存在对应deptid的用户
	 */
	public boolean existUsers(Integer deptid){
		return  usersDao.existUsers(deptid);
	}
	
	
	/**
	 *  得到指定帐号和密码的用户
	 */
	public Users getSingleUsers(String account,String password){
		StringBuffer sf = new StringBuffer("from Users where account=:account and password=:password");
		Query query = usersDao.getSessionFactory().getCurrentSession().createQuery(sf.toString());
		query.setString("account", account);
		query.setString("password",password);
		
		return (Users) query.uniqueResult();
	}
	
	/**
	 *  修改指定权限名称的权限
	 */
	public void updateUsersQuanXianMingCheng(String quanxianmingcheng){
		usersDao.updateUsersQuanXianMingCheng(quanxianmingcheng);
	}
	
	/**
	 *  get set
	 */
	public UsersDao getUsersDao() {
		return usersDao;
	}
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
}
