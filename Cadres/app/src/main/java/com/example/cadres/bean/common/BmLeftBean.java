package com.example.cadres.bean.common;

import java.util.List;

public class BmLeftBean {
    int id;
    int parentId;
    String name;
    String idType;
    boolean isSelect;
    int subset;
    List<BmLeftBean> lists;

    public BmLeftBean(int id, int parentId, String name,String idType,int subset) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.idType = idType;
        this.subset = subset;
    }

    public int getSubset() {
        return subset;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
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
