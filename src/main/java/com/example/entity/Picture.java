package com.example.entity;

import java.sql.Blob;

public class Picture {
    private Integer id;
    private String name;
    private String fname;
    private Integer user_id;
    private String intro;
    private String tags;
    private String upload_time;
    private Integer click_num;
    private User user;

    public Blob getUserpicture() {
        return userpicture;
    }

    public void setUserpicture(Blob userpicture) {
        this.userpicture = userpicture;
    }

    private Blob userpicture;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public Integer getClick_num() {
        return click_num;
    }

    public void setClick_num(Integer click_num) {
        this.click_num = click_num;
    }

}
