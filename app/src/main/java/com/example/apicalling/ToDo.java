package com.example.apicalling;

public class ToDo {
    private String userid;



    private String id;
    private String title;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "ToDo{" +
                "userid='" + userid + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}