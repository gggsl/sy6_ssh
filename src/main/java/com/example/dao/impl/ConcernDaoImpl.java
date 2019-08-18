package com.example.dao.impl;

import com.example.dao.ConcernDao;
import com.example.model.Concern;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConcernDaoImpl implements ConcernDao {
    @Autowired
    SessionFactory sessionFactory;
    public void add(int er_id,int ed_id){
        Concern concern = new Concern();
        concern.setConcerned_id(ed_id);
        concern.setConcerner_id(er_id);
        sessionFactory.getCurrentSession().save(concern);
    }

    public void delete(int er_id,int ed_id){
        String sql = "From Concern c where c.concerner_id=? and c.concerner_id = ?";
        Concern concern =(Concern)sessionFactory.getCurrentSession().createQuery(sql);
        sessionFactory.getCurrentSession().delete(concern);
    }

}
