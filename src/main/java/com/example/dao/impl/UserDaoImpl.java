package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.entity.Picture;
import com.example.entity.User;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;
    //1、大V排行榜，粉丝最多的10个人
    public List<User> getBigV(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Picture.class);
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.groupProperty("concerned_id"));
        projList.add(Projections.alias(Projections.count("concerned_id"), "count"));
        criteria.setProjection(projList);
        criteria.addOrder(Order.desc("count"));
        criteria.setMaxResults(10);
        return criteria.list();

    }
    //2、分页获取指定用户的照片
    public List<Picture> getUserPictures(int userId, int pageNo, int pageSize){
        try{
            String queryString = "select model from picture as model where model.user_id= ?";
            Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
            queryObject.setParameter(0,userId);
            queryObject.setFirstResult(pageNo);
            queryObject.setMaxResults(pageSize);
            return queryObject.list();
        }catch (RuntimeException re){
            throw re;
        }
    }
    //3、分页获取指定用户指定时间段内发布的照片，当start_time为空时表示开始时间不限，
    //   end_time为空时表示到当前时间
    public List<Picture> getUserPictures(int userId, Date start_time, Date end_time, int pageNo, int pageSize){
        try{
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String Time = formatter.format(currentTime);
            if (start_time==null){
                String queryString = "from Picture as model where model.user_id= ?";
                Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
                queryObject.setParameter(0,userId);
                queryObject.setFirstResult(pageNo);
                queryObject.setMaxResults(pageSize);
                return queryObject.list();
            }
            else if (end_time==null){
                String queryString = "from Picture model where model.user_id= ? and upload_time between"+start_time+"and"+Time;
                Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
                queryObject.setParameter(0,userId);
                queryObject.setFirstResult(pageNo);
                queryObject.setMaxResults(pageSize);
                return queryObject.list();
            }
            else {
                String queryString = "from Picture as model where model.user_id= ? and upload_time between"+start_time+"and"+end_time;
                Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
                queryObject.setParameter(0,userId);
                queryObject.setFirstResult(pageNo);
                queryObject.setMaxResults(pageSize);
                return queryObject.list();
            }
        }catch (RuntimeException re){
            throw re;
        }
    }
    //4、获取指定用户关注的用户
    public List<User> getFollows(int userId){
        try {
            String queryString = "select model.user_ed from Concern as model where model.concerner_id= ?";
            Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
            queryObject.setParameter(0,userId);
            return queryObject.list();
        }catch (RuntimeException re){
            throw re;
        }
    }
    //5、分页获取指定用户关注的用户的照片
    public List<Picture> getFollowPictures(int userId, int pageNo, int pageSize){
        try {
            String queryString = "select model.user_ed.picture from Concern as model where model.concerner_id= ?";
            Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
            queryObject.setParameter(0,userId);
            queryObject.setFirstResult(pageNo);
            queryObject.setMaxResults(pageSize);
            return queryObject.list();
        }catch (RuntimeException re){
            throw re;
        }
    }
    //6、分页获取指定用户关注的用户在指定时间段的照片
    public List<Picture> getFollowPictures(int userId, Date start_time, Date end_time, int pageNo, int pageSize){
        try {
            String queryString = "select model.user_ed.picture from Concern as model where model.concerner_id= ?and upload_time between"+start_time+"and"+end_time;
            Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
            queryObject.setParameter(0,userId);
            queryObject.setFirstResult(pageNo);
            queryObject.setMaxResults(pageSize);
            return queryObject.list();
        }catch (RuntimeException re){
            throw re;
        }
    }
    //7、分页获取系统中最新上传的照片
    public List<Picture> getRecentPictures(int pageNo, int pageSize){
        try {
            String queryString = "from Picture order by upload_time";
            Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
            queryObject.setFirstResult(pageNo);
            queryObject.setMaxResults(pageSize);
            return queryObject.list();
        }catch (RuntimeException re){
            throw re;
        }
    }
    //8、根据用户名模糊查询用户
    public List<User> findUsersByName(String userName){
        try {
            String queryString = "from User as model where model.username like ? ";
            Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
            queryObject.setString(0,userName);
            return queryObject.list();
        }catch (RuntimeException re){
            throw re;
        }
    }
    //9、根据照片名模糊查询照片信息
    public List<Picture> findPictureByName(String pictureName){
        try {
            String queryString = "from Picture as model where model.name like ? ";
            Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
            queryObject.setString(0,pictureName);
            return queryObject.list();
        }catch (RuntimeException re){
            throw re;
        }
    }
    //10、根据照片的标签信息查询照片
    public List<Picture> findPictureByTag(String tagName){
        try {
            String queryString = "from Picture as model where model.tags like ?";
            Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
            queryObject.setString(0,"%"+tagName+"%");
            return queryObject.list();
        }catch (RuntimeException re){
            throw re;
        }
    }
}
