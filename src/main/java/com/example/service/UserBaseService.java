package com.example.service;

import com.example.entity.Picture;
import com.example.entity.User;

import java.util.List;

public interface UserBaseService {
    void save(User transientInstance);
    void delete(User persistentInstance);
    void update(User user);
    User findById(Integer id);
    List findByProperty(String propertyName, Object value);
    List findAll();
    void addPicture(Integer id, Picture picture);
    List showPicture(Integer id);
    void concer(Integer concerner_id,Integer concered_id);
    List showFans(Integer id);

    boolean loginCheck(String username, String password);

    User searchUser(String username);

    List searchPicture(String name);
}
