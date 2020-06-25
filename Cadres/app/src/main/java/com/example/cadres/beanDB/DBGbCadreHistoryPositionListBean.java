package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGbCadreHistoryPositionListBean {

    @Id(autoincrement = true)
    private Long _id;
    private int positionId;
    private int deptId;
    private String deptName;
    private int baseId;
    private String cadreName;
    private String dutiesRank;
    private String position;
    private int positionTitle;
    private String positionTitleName;
    private String leaveTime;
    private String leaveReason;
    private String leaveFileNumber;
    private String vacantPosition;

    @Generated(hash = 1716589658)
    public DBGbCadreHistoryPositionListBean(Long _id, int positionId, int deptId,
            String deptName, int baseId, String cadreName, String dutiesRank,
            String position, int positionTitle, String positionTitleName,
            String leaveTime, String leaveReason, String leaveFileNumber,
            String vacantPosition) {
        this._id = _id;
        this.positionId = positionId;
        this.deptId = deptId;
        this.deptName = deptName;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.dutiesRank = dutiesRank;
        this.position = position;
        this.positionTitle = positionTitle;
        this.positionTitleName = positionTitleName;
        this.leaveTime = leaveTime;
        this.leaveReason = leaveReason;
        this.leaveFileNumber = leaveFileNumber;
        this.vacantPosition = vacantPosition;
    }

    @Generated(hash = 596428915)
    public DBGbCadreHistoryPositionListBean() {
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

    public String getDutiesRank() {
        return dutiesRank;
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

    public String getLeaveTime() {
        return leaveTime;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public String getLeaveFileNumber() {
        return leaveFileNumber;
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

    public void setDutiesRank(String dutiesRank) {
        this.dutiesRank = dutiesRank;
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

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public void setLeaveFileNumber(String leaveFileNumber) {
        this.leaveFileNumber = leaveFileNumber;
    }

    public void setVacantPosition(String vacantPosition) {
        this.vacantPosition = vacantPosition;
    }
}