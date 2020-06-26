package com.example.cadres.bean.common;

import java.util.List;

public class BmLeftBean {
    int id;
    String name;
    List<BmLeftBean> lists;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BmLeftBean> getLists() {
        return lists;
    }

    public void setLists(List<BmLeftBean> lists) {
        this.lists = lists;
    }
}
