package com.example.entity;

import java.util.Set;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String intro;
    private String gender;
    private String province;
    private String city;
    private String regist_time;
    private String type;
    private String mobile;
    private String email;
    private String QQ;
    private String status;

    private Set<Picture> picture;
    private Set<Concern> concerner;
    private Set<Concern> concerned;

    public Set<Concern> getConcerned() {
        return concerned;
    }

    public void setConcerned(Set<Concern> concerned) {
        this.concerned = concerned;
    }

    public Set<Concern> getConcerner() {
        return concerner;
    }

    public void setConcerner(Set<Concern> concerner) {
        this.concerner = concerner;
    }

    public Set getPicture() {
        return picture;
    }

    public void setPicture(Set picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegist_time() {
        return regist_time;
    }

    public void setRegist_time(String regist_time) {
        this.regist_time = regist_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
