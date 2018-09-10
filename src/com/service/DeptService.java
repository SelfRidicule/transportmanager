package com.service;

import java.util.List;

import org.hibernate.Query;

import com.dao.DeptDao;
import com.entity.Dept;

/**
 * 	部门业务类
 */
public class DeptService {

	/**
	 * 构造方法
	 */
	public DeptService() {
		super();
	}
	
	/**
	 * 属性
	 */
	private DeptDao deptDao; //部门dao

	/**
	 *  查询指定部门名称的部门对象
	 */
	public List<Dept> queryDeptName(String deptname){
		return  deptDao.queryDeptName(deptname);
	}
	
	
	/**
	 *  查询所有部门
	 */
	public List<Dept> queryDept(){
		return deptDao.findAll();
	}
	
	/**
	 * 查询指定id部门 
	 */
	public Dept getDeptId(Integer deptid){
		Dept dept = deptDao.findById(deptid);
		return dept;
	}
	
	/**
	 * 模糊查询部门 
	 */
	public List<Dept> vagueSearchDept(String deptname){
//		创建部门hql语句
		StringBuilder hql = new StringBuilder("from Dept where deptid is not null");
//		判断值是否为空
		if("".equals(deptname) || deptname==null){
		}else{
			hql.append(" and deptname like :deptname");
		}
//		创建query对象
		Query query = deptDao.getSessionFactory().getCurrentSession().createQuery(hql.toString());
//		判断是否添加值
		if("".equals(deptname) || deptname==null){
		}else{
			query.setString("deptname", "%"+deptname+"%");
		}
		
		List<Dept> deptlist = query.list();
		
		return deptlist;
	}

	/**
	 *  删除指定id部门
	 */
	public void deleteDept(Integer id){
		Dept dept = new Dept();
		dept.setDeptid(id);
		deptDao.delete(dept);
	}
	
	/**
	 *  添加部门
	 */
	public void addDept(Dept dept){
		deptDao.save(dept);
	}
	
	/**
	 *  修改部门
	 */
	public void updateDept(Dept dept){
		deptDao.update(dept);
	}
	
	/**
	 *  get set
	 */
	public DeptDao getDeptDao() {
		return deptDao;
	}
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
}
