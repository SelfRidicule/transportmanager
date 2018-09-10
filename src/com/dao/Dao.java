package com.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *	通过继承HibernateDaoSupport类 ，获得HibernateTemplate对象来直接操作数据库	
 */
public  class Dao<T>  implements BaseDao<T> {
	
	/**
	 * 构造方法
	 */
	public Dao(){
		entityClass=(Class<T>) ( (ParameterizedType)getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
	}
	
	/**
	 * 属性
	 */
	private SessionFactory sessionFactory;
	private Class<T> entityClass;
	
	public void save(T instance) {
		Session session = sessionFactory.getCurrentSession();
		session.save(instance);
		
		System.out.println("保存方法");
	}

	public void delete(T instance) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(instance);
		
		System.out.println("delete方法");
	}

	public void update(T instance) {
		Session session = sessionFactory.getCurrentSession();
		session.update(instance);
		
		System.out.println("update方法");
	}

	public T findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		T instance = (T) session.get(entityClass, id);
		
		return instance;
	}

	public void saveAndUpdate(T instance) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(instance);
		
	}
	
	public List<T> findAll() {
		return null;
	}
	
	public List<T> findPage(Integer currentPage, Integer pageSize) {
		return null;
	}
	
	/**
	 *  get set
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}


}
