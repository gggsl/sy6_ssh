package com.example.dao.impl;

import com.example.dao.PictureDao;
import com.example.entity.Picture;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PictureDaoImpl implements PictureDao {
    @Autowired
    SessionFactory sessionFactory;
    public void add(Picture picture){
        sessionFactory.getCurrentSession().save(picture);
    }
}
