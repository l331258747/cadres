package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbTyJg {

    @Id(autoincrement = true)
    private Long _id;
    private int deptId;
    private String sexList;
    private String nationList;
    private String outlookList;
    private String ageList;
    @Generated(hash = 87656881)
    public DbTyJg(Long _id, int deptId, String sexList, String nationList,
                  String outlookList, String ageList) {
        this._id = _id;
        this.deptId = deptId;
        this.sexList = sexList;
        this.nationList = nationList;
        this.outlookList = outlookList;
        this.ageList = ageList;
    }
    @Generated(hash = 48086157)
    public DbTyJg() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getDeptId() {
        return this.deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public String getSexList() {
        return this.sexList;
    }
    public void setSexList(String sexList) {
        this.sexList = sexList;
    }
    public String getNationList() {
        return this.nationList;
    }
    public void setNationList(String nationList) {
        this.nationList = nationList;
    }
    public String getOutlookList() {
        return this.outlookList;
    }
    public void setOutlookList(String outlookList) {
        this.outlookList = outlookList;
    }
    public String getAgeList() {
        return this.ageList;
    }
    public void setAgeList(String ageList) {
        this.ageList = ageList;
    }


}
