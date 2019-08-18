package com.example.dao.impl;

import java.util.List;

import com.example.dao.UserDaoBase;
import com.example.entity.Concern;
import com.example.entity.Picture;
import com.example.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * A data access object (DAO) providing persistence and search support for User entities. Transaction control of the save(), update() and delete() operations can directly support Spring container-managed transactions or they can be augmented to handle user-managed Spring transactions. Each of these methods provides additional information for how to configure it for the desired type of transaction control.
 * 
 * @see User
 * @author MyEclipse Persistence Tools
 */
@Repository
public class UserDaoBaseImpl implements UserDaoBase {
	private static final Logger log = LoggerFactory.getLogger(UserDaoBaseImpl.class);
	@Autowired
	SessionFactory sessionFactory;
    //增加
	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
   //删除
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	//修改
	public void update(User user){
		log.debug("updating User instance");
		try {
			sessionFactory.getCurrentSession().update(user);
			log.debug("update successful");
		}catch (RuntimeException re){
			log.error("update failed",re);
			throw re;
		}
	}
	//列出指定id的用户
	public User findById(Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) sessionFactory.getCurrentSession().get("com.example.entity.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	//列出指定属性值的用户
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from User as model where model." + propertyName + "= ?";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	//列出指定用户名和密码的用户
	public List getByNameAndPassword(String username,String password){
		String sql = "from User u where u.username= ? and u.password = ?";
		Query query =sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter(0,username);
		query.setParameter(1,password);
		return query.list();
	}
	//列出所有用户
	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	//为用户添加图片
	public void addPicture(Integer id, Picture picture){
		try{
			User user = findById(id);
			picture.setUser(user);
			sessionFactory.getCurrentSession().save(picture);
		}catch (RuntimeException re){
			throw re;
		}
	}
	//列出用户的图片
	public List showPicture(Integer id) {
		try {
			String queryString = "from Picture as model where model.id= ?";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0,id);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//关注某个用户
	public void concer(Integer concerner_id,Integer concered_id){
		try{
			Concern concern = new Concern();
			concern.setConcerned_id(concered_id);
			concern.setConcerner_id(concerner_id);
			sessionFactory.getCurrentSession().save(concern);
		}catch (RuntimeException re){
			throw re;
		}
	}
	//列出用户的粉丝
	public List showFans(Integer id) {
		try {
			String queryString = "from Concern as model where model.concerned_id= ?";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0,id);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	//通过用户名查找
	public User findByUserName(String username) {
		String sql = "From User u where u.username = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter(0,username);
		List<User> list = query.list();
		User user = list.get(0);
		return user;
	}
	//通过照片名查找
	public List findByPictureName(String name) {
		String sql = "From Picture p where p.name = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter(0, name);
		return query.list();
	}
}