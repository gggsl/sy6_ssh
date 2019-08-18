package com.example.service.impl;

import java.util.Date;
import java.util.List;

import com.example.dao.UserDao;
import com.example.dao.UserDaoBase;
import com.example.entity.Picture;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    

    public List<User> getBigV(){
       return userDao.getBigV();
    }
    //2、分页获取指定用户的照片
    public List<Picture> getUserPictures(int userId, int pageNo, int pageSize){
        return userDao.getUserPictures(userId,pageNo,pageSize);
    }
    //3、分页获取指定用户指定时间段内发布的照片，当start_time为空时表示开始时间不限，
    //   end_time为空时表示到当前时间
   public List<Picture> getUserPictures(int userId, Date start_time, Date end_time, int pageNo, int pageSize){
       return userDao.getUserPictures(userId, start_time, end_time, pageNo, pageSize);
   }
    //4、获取指定用户关注的用户
   public List<User> getFollows(int userId){
       return userDao.getFollows(userId);
   }
    //5、分页获取指定用户关注的用户的照片
   public List<Picture> getFollowPictures(int userId, int pageNo, int pageSize){
       return userDao.getFollowPictures(userId, pageNo, pageSize);
   }
    //6、分页获取指定用户关注的用户在指定时间段的照片
   public List<Picture> getFollowPictures(int userId, Date start_time, Date end_time, int pageNo, int pageSize){
       return userDao.getFollowPictures(userId, start_time, end_time, pageNo, pageSize);
   }
    //7、分页获取系统中最新上传的照片
    public List<Picture> getRecentPictures(int pageNo, int pageSize){
        return userDao.getRecentPictures(pageNo, pageSize);
    }
    //8、根据用户名模糊查询用户
    public List<User> findUsersByName(String userName){
        return userDao.findUsersByName(userName);
    }
    //9、根据照片名模糊查询照片信息
    public List<Picture> findPictureByName(String pictureName){
        return userDao.findPictureByName(pictureName);
    }
    //10、根据照片的标签信息查询照片
    public List<Picture> findPictureByTag(String tagName){
        return userDao.findPictureByTag(tagName);
    }
}
