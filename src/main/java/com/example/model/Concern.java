package com.example.model;

public class Concern {
    private Integer id;
    private Integer concerner_id;
    private Integer concerned_id;
    private String concern_time;
    private User user_er;
    private User user_ed;

    public User getUser_ed() {
        return user_ed;
    }

    public void setUser_ed(User user_ed) {
        this.user_ed = user_ed;
    }

    public User getUser_er() {
        return user_er;
    }

    public void setUser_er(User user_er) {
        this.user_er = user_er;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConcerner_id() {
        return concerner_id;
    }

    public void setConcerner_id(Integer concerner_id) {
        this.concerner_id = concerner_id;
    }

    public Integer getConcerned_id() {
        return concerned_id;
    }

    public void setConcerned_id(Integer concerned_id) {
        this.concerned_id = concerned_id;
    }

    public String getConcern_time() {
        return concern_time;
    }

    public void setConcern_time(String concern_time) {
        this.concern_time = concern_time;
    }

}