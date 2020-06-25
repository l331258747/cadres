package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGbCadreTrainListBean {

    @Id(autoincrement = true)
    private Long _id;
    private int trainId;
    private int baseId;
    private String cadreName;
    private String startTime;
    private String endTime;
    private String trainingCourse;
    private String trainLevel;
    private String trainType;
    private String trainOrganization;
    private String trainMode;
    private String trainContent;

    @Generated(hash = 1514731557)
    public DBGbCadreTrainListBean(Long _id, int trainId, int baseId,
            String cadreName, String startTime, String endTime,
            String trainingCourse, String trainLevel, String trainType,
            String trainOrganization, String trainMode, String trainContent) {
        this._id = _id;
        this.trainId = trainId;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.trainingCourse = trainingCourse;
        this.trainLevel = trainLevel;
        this.trainType = trainType;
        this.trainOrganization = trainOrganization;
        this.trainMode = trainMode;
        this.trainContent = trainContent;
    }

    @Generated(hash = 1473771246)
    public DBGbCadreTrainListBean() {
    }

    public int getTrainId() {
        return trainId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getTrainingCourse() {
        return trainingCourse;
    }

    public String getTrainLevel() {
        return trainLevel;
    }

    public String getTrainType() {
        return trainType;
    }

    public String getTrainOrganization() {
        return trainOrganization;
    }

    public String getTrainMode() {
        return trainMode;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public void setCadreName(String cadreName) {
        this.cadreName = cadreName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setTrainingCourse(String trainingCourse) {
        this.trainingCourse = trainingCourse;
    }

    public void setTrainLevel(String trainLevel) {
        this.trainLevel = trainLevel;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public void setTrainOrganization(String trainOrganization) {
        this.trainOrganization = trainOrganization;
    }

    public void setTrainMode(String trainMode) {
        this.trainMode = trainMode;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }
}