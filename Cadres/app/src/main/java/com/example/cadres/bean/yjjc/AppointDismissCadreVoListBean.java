package com.example.cadres.bean.yjjc;

import com.example.cadres.utils.GsonUtil;

import java.util.List;

public class AppointDismissCadreVoListBean {


    /**
     * searchValue : null
     * createBy :
     * createTime : 2020-06-29 14:14:45
     * updateBy :
     * updateTime : 2020-07-01 18:00:08
     * remark :
     * deptCode : null
     * params : {}
     * dismissCadreId : 206
     * schemeId : 203
     * schemeName : 关于环保局局长任免决策
     * baseId : 228
     * cadreName : 林泉
     * gender : 男
     * nation : 汉族
     * nativePlace : 湖北
     * currentEducation : 大学本科
     * fullTimeEducation : 大学本科
     * currentMajor : 经济管理学
     * fullTimeMajor : 经济管理学
     * currentDegreeName : 经济学硕士
     * fullTimeDegreeName : 经济学学士
     * technicalTitle : 行政管理
     * birthday : 1980-07
     * age : 40
     * workTime : 1991-04
     * joinPartyDate : 1989-04
     * currentPositionTime : 2015-08
     * currentRankTime : 2015-05
     * talkNumber : 10
     * talkGainNumber : 9
     * recommendNumber : 10
     * recommendGainNumber : 8
     * currentPosition : 环保局局长,农业局职务待定
     * aspiringPosition : 拟任环保局局长职务
     * jwOpinion : 纪委意见同意
     * zzbOpinion : 组织部意见同意
     * validTicket : 5
     * gainVotes : 5
     * cwhOpinion : 通过
     * appointDismissResult : 1
     * appointDismissType : 拟任职
     * appointPosition : 211
     * appointPositionName : 局长
     * appointDeptId : 217
     * appointDeptName : 环保局
     * positionTime : 2020-06-29 00:00:00
     * positionReason :
     * positionFileNumber :
     * dismissPosition : null
     * dismissPositionName : null
     * dismissDeptId : null
     * dismissDeptName : null
     * leaveTime : null
     * leaveReason :
     * leaveFileNumber :
     * currentRank : 乡科级正职
     * meetingDescribe : null
     * inspectFileName : ["14b71ef32bf0ed69c72e11e3fce0faf0.doc"]
     * ranking : 1
     * vacantPosition : 是
     */

    private String remark;
    private String deptCode;
    private int dismissCadreId;
    private int schemeId;
    private String schemeName;
    private int baseId;
    private String cadreName;
    private String gender;
    private String nation;
    private String nativePlace;
    private String currentEducation;
    private String fullTimeEducation;
    private String currentMajor;
    private String fullTimeMajor;
    private String currentDegreeName;
    private String fullTimeDegreeName;
    private String technicalTitle;
    private String birthday;
    private int age;
    private String workTime;
    private String joinPartyDate;
    private String currentPositionTime;
    private String currentRankTime;
    private int talkNumber;
    private int talkGainNumber;
    private int recommendNumber;
    private int recommendGainNumber;
    private String currentPosition;
    private String aspiringPosition;
    private String jwOpinion;
    private String zzbOpinion;
    private int validTicket;
    private int gainVotes;
    private String cwhOpinion;
    private String appointDismissResult;
    private String appointDismissType;
    private int appointPosition;
    private String appointPositionName;
    private int appointDeptId;
    private String appointDeptName;
    private String positionTime;
    private String positionReason;
    private String positionFileNumber;
    private String dismissPosition;
    private String dismissPositionName;
    private String dismissDeptId;
    private String dismissDeptName;
    private String leaveTime;
    private String leaveReason;
    private String leaveFileNumber;
    private String currentRank;
    private String meetingDescribe;
    private int ranking;
    private String vacantPosition;
    private List<String> inspectFileName;

    public String getInspectFileName() {
        if(inspectFileName == null || inspectFileName.size() == 0)
            return "";
        return GsonUtil.convertVO2String(inspectFileName);
    }

    public String getRemark() {
        return remark;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public int getDismissCadreId() {
        return dismissCadreId;
    }

    public int getSchemeId() {
        return schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public String getGender() {
        return gender;
    }

    public String getNation() {
        return nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public String getCurrentEducation() {
        return currentEducation;
    }

    public String getFullTimeEducation() {
        return fullTimeEducation;
    }

    public String getCurrentMajor() {
        return currentMajor;
    }

    public String getFullTimeMajor() {
        return fullTimeMajor;
    }

    public String getCurrentDegreeName() {
        return currentDegreeName;
    }

    public String getFullTimeDegreeName() {
        return fullTimeDegreeName;
    }

    public String getTechnicalTitle() {
        return technicalTitle;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public String getWorkTime() {
        return workTime;
    }

    public String getJoinPartyDate() {
        return joinPartyDate;
    }

    public String getCurrentPositionTime() {
        return currentPositionTime;
    }

    public String getCurrentRankTime() {
        return currentRankTime;
    }

    public int getTalkNumber() {
        return talkNumber;
    }

    public int getTalkGainNumber() {
        return talkGainNumber;
    }

    public int getRecommendNumber() {
        return recommendNumber;
    }

    public int getRecommendGainNumber() {
        return recommendGainNumber;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public String getAspiringPosition() {
        return aspiringPosition;
    }

    public String getJwOpinion() {
        return jwOpinion;
    }

    public String getZzbOpinion() {
        return zzbOpinion;
    }

    public int getValidTicket() {
        return validTicket;
    }

    public int getGainVotes() {
        return gainVotes;
    }

    public String getCwhOpinion() {
        return cwhOpinion;
    }

    public String getAppointDismissResult() {
        return appointDismissResult;
    }

    public String getAppointDismissType() {
        return appointDismissType;
    }

    public int getAppointPosition() {
        return appointPosition;
    }

    public String getAppointPositionName() {
        return appointPositionName;
    }

    public int getAppointDeptId() {
        return appointDeptId;
    }

    public String getAppointDeptName() {
        return appointDeptName;
    }

    public String getPositionTime() {
        return positionTime;
    }

    public String getPositionReason() {
        return positionReason;
    }

    public String getPositionFileNumber() {
        return positionFileNumber;
    }

    public String getDismissPosition() {
        return dismissPosition;
    }

    public String getDismissPositionName() {
        return dismissPositionName;
    }

    public String getDismissDeptId() {
        return dismissDeptId;
    }

    public String getDismissDeptName() {
        return dismissDeptName;
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

    public String getCurrentRank() {
        return currentRank;
    }

    public String getMeetingDescribe() {
        return meetingDescribe;
    }

    public int getRanking() {
        return ranking;
    }

    public String getVacantPosition() {
        return vacantPosition;
    }
}