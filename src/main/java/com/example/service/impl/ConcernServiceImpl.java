package com.example.service.impl;

import com.example.dao.ConcernDao;
import com.example.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConcernServiceImpl implements ConcernService {
    @Autowired
    ConcernDao concernDao;
    public void toFollow(int er_id,int ed_id){
        concernDao.add(er_id,ed_id);
    }
    public void delete(int er_id,int ed_id){
        concernDao.delete(er_id,ed_id);
    }


}
