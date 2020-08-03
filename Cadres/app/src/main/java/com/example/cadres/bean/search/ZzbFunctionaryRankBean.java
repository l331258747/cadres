package com.example.cadres.bean.search;

public class ZzbFunctionaryRankBean {
    String functionaryRankName;
    int functionaryRankId;
    int parentId;
    String parentName;
    int orderNum;

    public String getFunctionaryRankName() {
        return functionaryRankName;
    }

    public void setFunctionaryRankName(String functionaryRankName) {
        this.functionaryRankName = functionaryRankName;
    }

    public int getFunctionaryRankId() {
        return functionaryRankId;
    }

    public void setFunctionaryRankId(int functionaryRankId) {
        this.functionaryRankId = functionaryRankId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
