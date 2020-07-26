package com.example.cadres.beanDB;

import android.text.TextUtils;

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
    int age;

    @Generated(hash = 1151078051)
    public DBGbCadreFamilyMemberList(Long _id, int memberId, int baseId,
            String cadreName, String appellation, String name, String birthday,
            String politicalOutlook, String workUnit, int age) {
        this._id = _id;
        this.memberId = memberId;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.appellation = appellation;
        this.name = name;
        this.birthday = birthday;
        this.politicalOutlook = politicalOutlook;
        this.workUnit = workUnit;
        this.age = age;
    }



    @Generated(hash = 875364924)
    public DBGbCadreFamilyMemberList() {
    }

   

    public String getBirthdayAge() {
        if(!TextUtils.isEmpty(birthday) && age != 0)
            return birthday + "\n(" + age + ")";
        if(!TextUtils.isEmpty(birthday))
            return birthday;
        if(age != 0)
            return age+"";
        return "";
    }



    public Long get_id() {
        return this._id;
    }



    public void set_id(Long _id) {
        this._id = _id;
    }



    public int getMemberId() {
        return this.memberId;
    }



    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }



    public int getBaseId() {
        return this.baseId;
    }



    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }



    public String getCadreName() {
        return this.cadreName;
    }



    public void setCadreName(String cadreName) {
        this.cadreName = cadreName;
    }



    public String getAppellation() {
        return this.appellation;
    }



    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }



    public String getName() {
        return this.name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getBirthday() {
        return this.birthday;
    }



    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }



    public String getPoliticalOutlook() {
        return this.politicalOutlook;
    }



    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }



    public String getWorkUnit() {
        return this.workUnit;
    }



    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }



    public int getAge() {
        return this.age;
    }



    public void setAge(int age) {
        this.age = age;
    }
}