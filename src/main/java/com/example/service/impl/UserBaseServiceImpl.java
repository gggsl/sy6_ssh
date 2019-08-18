package com.example.service.impl;

import com.example.dao.UserDaoBase;
import com.example.entity.Picture;
import com.example.entity.User;
import com.example.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserBaseServiceImpl implements UserBaseService {
    @Autowired
    private UserDaoBase userDaoBase;
    public void save(User transientInstance){
         userDaoBase.save(transientInstance);
    }
    public void delete(User persistentInstance){
         userDaoBase.delete(persistentInstance);
    }
    public void update(User user){
        userDaoBase.update(user);
    }
    public User findById(Integer id){
        return userDaoBase.findById(id);
    }
    public List findByProperty(String propertyName, Object value){
        return userDaoBase.findByProperty(propertyName, value);
    }
   public List findAll(){
        return userDaoBase.findAll();
   }
    public void addPicture(Integer id, Picture picture){
        userDaoBase.addPicture(id,picture);
    }
   public List showPicture(Integer id){
       return userDaoBase.showPicture(id);
   }
    public void concer(Integer concerner_id,Integer concered_id){
        userDaoBase.concer(concerner_id,concered_id);
    }
   public List showFans(Integer id){
        return userDaoBase.showFans(id);
   }

    public boolean loginCheck(String username, String password) {
        List<User> list = userDaoBase.getByNameAndPassword(username, password);
        if (list.size()==0){
            return false;
        }
        else{
            return true;
        }
    }

    public User searchUser(String username){
        return userDaoBase.findByUserName(username);
    }

    public List searchPicture(String name) {
        return userDaoBase.findByPictureName(name);

    }
}
