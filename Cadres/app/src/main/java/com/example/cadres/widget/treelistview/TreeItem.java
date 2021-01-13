package com.example.cadres.widget.treelistview;

import java.util.List;

public class TreeItem {
    public String title;
    public int itemLevel;
    public int itemState;
    public List<TreeItem> child;

    int id;
    int parentId;
    String name;
    String idType;
    boolean isSelect;
    int subset;
    String isNoWomen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getSubset() {
        return subset;
    }

    public void setSubset(int subset) {
        this.subset = subset;
    }

    public String getIsNoWomen() {
        return isNoWomen;
    }

    public void setIsNoWomen(String isNoWomen) {
        this.isNoWomen = isNoWomen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public int getItemState() {
        return itemState;
    }

    public void setItemState(int itemState) {
        this.itemState = itemState;
    }

    public List<TreeItem> getChild() {
        return child;
    }

    public void setChild(List<TreeItem> child) {
        this.child = child;
    }
}