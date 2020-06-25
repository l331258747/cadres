package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGbCadreFamilyMemberList {

    @Id(autoincrement = true)
    private Long _id;
    int memberId;
    int baseId;
    String cadreName;
    String appellation;
    String name;
    String birthday;
    String politicalOutlook;
    String workUnit;

    @Generated(hash = 1544980387)
    public DBGbCadreFamilyMemberList(Long _id, int memberId, int baseId,
            String cadreName, String appellation, String name, String birthday,
            String politicalOutlook, String workUnit) {
        this._id = _id;
        this.memberId = memberId;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.appellation = appellation;
        this.name = name;
        this.birthday = birthday;
        this.politicalOutlook = politicalOutlook;
        this.workUnit = workUnit;
    }

    @Generated(hash = 875364924)
    public DBGbCadreFamilyMemberList() {
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public String getAppellation() {
        return appellation;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public void setCadreName(String cadreName) {
        this.cadreName = cadreName;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }
}