package com.example.cadres.bean.Gb;

public class GbCadreHistoryPositionListBean {
    /**
     * positionId : 224
     * deptId : 210
     * deptName : 国税局
     * baseId : 218
     * cadreName : 张三
     * dutiesRank :
     * position : 不在任（已免职）
     * positionTitle : 204
     * positionTitleName : 副主任
     * leaveTime : 2020-06-10
     * leaveReason :
     * leaveFileNumber :
     * vacantPosition : 是
     * createBy :
     * createTime : 2020-06-10 18:27:42
     * updateBy :
     * updateTime : null
     */

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

    public GbCadreHistoryPositionListBean(int positionId, int deptId, String deptName, int baseId, String cadreName, String dutiesRank, String position, int positionTitle, String positionTitleName, String leaveTime, String leaveReason, String leaveFileNumber, String vacantPosition) {
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
}