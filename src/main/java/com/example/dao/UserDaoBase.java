package com.example.dao;

import com.example.entity.Picture;
import com.example.entity.User;

import java.util.List;

public interface UserDaoBase {
    void save(User transientInstance);
    void delete(User persistentInstance);
    void update(User user);
    User findById(Integer id);
    User findByUserName(String username);
    List findByPictureName(String name);
    List findByProperty(String propertyName, Object value);
    List findAll();
    void addPicture(Integer id, Picture picture);
    List showPicture(Integer id);
    void concer(Integer concerner_id,Integer concered_id);
    List showFans(Integer id);
    List getByNameAndPassword(String username,String password);


}
