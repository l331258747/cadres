package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGbCadreNowPositionListBean {

    @Id(autoincrement = true)
    private Long _id;
    private int positionId;
    private int deptId;
    private String deptName;
    private int baseId;
    private String cadreName;
    private String positionTime;
    private String position;
    private int positionTitle;
    private String positionTitleName;
    private String positionReason;
    private String positionFileNumber;
    private String dutiesRank;
    private String vacantPosition;

    @Generated(hash = 404758243)
    public DBGbCadreNowPositionListBean(Long _id, int positionId, int deptId,
            String deptName, int baseId, String cadreName, String positionTime,
            String position, int positionTitle, String positionTitleName,
            String positionReason, String positionFileNumber, String dutiesRank,
            String vacantPosition) {
        this._id = _id;
        this.positionId = positionId;
        this.deptId = deptId;
        this.deptName = deptName;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.positionTime = positionTime;
        this.position = position;
        this.positionTitle = positionTitle;
        this.positionTitleName = positionTitleName;
        this.positionReason = positionReason;
        this.positionFileNumber = positionFileNumber;
        this.dutiesRank = dutiesRank;
        this.vacantPosition = vacantPosition;
    }

    @Generated(hash = 859353769)
    public DBGbCadreNowPositionListBean() {
    }

    public int getPositionId() {
        return positionId;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public String getPositionTime() {
        return positionTime;
    }

    public String getPosition() {
        return position;
    }

    public int getPositionTitle() {
        return positionTitle;
    }

    public String getPositionTitleName() {
        return positionTitleName;
    }

    public String getPositionReason() {
        return positionReason;
    }

    public String getPositionFileNumber() {
        return positionFileNumber;
    }

    public String getDutiesRank() {
        return dutiesRank;
    }

    public String getVacantPosition() {
        return vacantPosition;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public void setCadreName(String cadreName) {
        this.cadreName = cadreName;
    }

    public void setPositionTime(String positionTime) {
        this.positionTime = positionTime;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPositionTitle(int positionTitle) {
        this.positionTitle = positionTitle;
    }

    public void setPositionTitleName(String positionTitleName) {
        this.positionTitleName = positionTitleName;
    }

    public void setPositionReason(String positionReason) {
        this.positionReason = positionReason;
    }

    public void setPositionFileNumber(String positionFileNumber) {
        this.positionFileNumber = positionFileNumber;
    }

    public void setDutiesRank(String dutiesRank) {
        this.dutiesRank = dutiesRank;
    }

    public void setVacantPosition(String vacantPosition) {
        this.vacantPosition = vacantPosition;
    }
}