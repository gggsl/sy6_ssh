package com.example.service.impl;

import com.example.dao.ConcernDao;
import com.example.dao.PictureDao;
import com.example.entity.Picture;
import com.example.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureDao pictureDao;
    public void add(Picture picture){
        pictureDao.add(picture);
    }
}
