package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGbCadreDeptListBean {

    @Id(autoincrement = true)
    private Long _id;
    private int deptId;
    private int baseId;
    private String state;
    private String deptName;
    private String deptType;
    private String deptCode;
    private int ranking;

    @Generated(hash = 958480957)
    public DBGbCadreDeptListBean(Long _id, int deptId, int baseId, String state,
            String deptName, String deptType, String deptCode, int ranking) {
        this._id = _id;
        this.deptId = deptId;
        this.baseId = baseId;
        this.state = state;
        this.deptName = deptName;
        this.deptType = deptType;
        this.deptCode = deptCode;
        this.ranking = ranking;
    }

    @Generated(hash = 1217129680)
    public DBGbCadreDeptListBean() {
    }

    public int getDeptId() {
        return deptId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getState() {
        return state;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptType() {
        return deptType;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getDeptCode() {
        return this.deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public int getRanking() {
        return this.ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}