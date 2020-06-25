package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGbCadreResumeListBean {

    @Id(autoincrement = true)
    private Long _id;
    private int resumeId;
    private int baseId;
    private String cadreName;
    private String workType;
    private String workStartTime;
    private String workEndTime;
    private String workDescribe;

    @Generated(hash = 873482974)
    public DBGbCadreResumeListBean(Long _id, int resumeId, int baseId,
            String cadreName, String workType, String workStartTime,
            String workEndTime, String workDescribe) {
        this._id = _id;
        this.resumeId = resumeId;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.workType = workType;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.workDescribe = workDescribe;
    }

    @Generated(hash = 884619115)
    public DBGbCadreResumeListBean() {
    }

    public int getResumeId() {
        return resumeId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public String getWorkType() {
        return workType;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public String getWorkDescribe() {
        return workDescribe;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public void setCadreName(String cadreName) {
        this.cadreName = cadreName;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public void setWorkDescribe(String workDescribe) {
        this.workDescribe = workDescribe;
    }
}