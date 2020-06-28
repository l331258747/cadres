package com.example.cadres.bean.common;

import java.util.List;

public class BmLeftBean {
    int id;
    int parentId;
    String name;
    List<BmLeftBean> lists;

    public BmLeftBean(int id, int parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

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
