package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBBmExplainBean {

    @Id(autoincrement = true)
    private Long _id;

    private int explainId;
    private int deptId;
    private String orgExplain;
    private int year;
    @Generated(hash = 2037629243)
    public DBBmExplainBean(Long _id, int explainId, int deptId, String orgExplain,
            int year) {
        this._id = _id;
        this.explainId = explainId;
        this.deptId = deptId;
        this.orgExplain = orgExplain;
        this.year = year;
    }
    @Generated(hash = 142305598)
    public DBBmExplainBean() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getExplainId() {
        return this.explainId;
    }
    public void setExplainId(int explainId) {
        this.explainId = explainId;
    }
    public int getDeptId() {
        return this.deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public String getOrgExplain() {
        return this.orgExplain;
    }
    public void setOrgExplain(String orgExplain) {
        this.orgExplain = orgExplain;
    }
    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
