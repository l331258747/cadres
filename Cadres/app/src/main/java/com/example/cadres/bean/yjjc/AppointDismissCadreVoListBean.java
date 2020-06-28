package com.example.cadres.bean.yjjc;

import com.example.cadres.utils.GsonUtil;

import java.util.List;

public class AppointDismissCadreVoListBean {
    /**
     * searchValue : null
     * createBy :
     * createTime : 2020-06-26 21:19:47
     * updateBy :
     * updateTime : null
     * remark :
     * deptCode : null
     * params : {}
     * dismissCadreId : 200
     * schemeId : 200
     * schemeName : 方案1
     * baseId : 218
     * cadreName : 张三
     * gender : 男
     * birthday : 1979-01-01
     * age : 41
     * joinPartyDate : 1994-02-02
     * currentPosition : 乡镇1副书记,国税局副主任,乡镇1书记
     * currentPositionTime : 2020-06-10
     * nativePlace : 中国湖南
     * fullTimeEducation : 小学
     * currentEducation : 中学
     * appointDismissType : 拟任职
     * appointPosition : 200
     * appointPositionName : 书记
     * appointDeptId : 207
     * appointDeptName : 乡镇1
     * positionTime : 2020-06-09 00:00:00
     * positionReason : 公选
     * positionFileNumber : 1111
     * dismissPosition : null
     * dismissPositionName : null
     * dismissDeptId : null
     * dismissDeptName : null
     * leaveTime : null
     * leaveReason :
     * leaveFileNumber :
     * currentRank : 正处
     * appointDismissResult : 待审核
     * meetingDescribe : 任免说明测试
     * inspectFileName : ["b06526ab47b62b1c6acb730532faa434.jpg","68da4d311d70c45ec97b02b0e5b1f8be.jpg"]
     * talkNumber : 10
     * recommendNumber : 9
     * ranking : 1
     * vacantPosition : 是
     * validTicket : 0
     * gainVotes : 0
     */

    private int dismissCadreId;
    private int schemeId;
    private String schemeName;
    private int baseId;
    private String cadreName;
    private String gender;
    private String birthday;
    private int age;
    private String joinPartyDate;
    private String currentPosition;
    private String currentPositionTime;
    private String nativePlace;
    private String fullTimeEducation;
    private String currentEducation;
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
    private String appointDismissResult;
    private String meetingDescribe;
    private int talkNumber;
    private int recommendNumber;
    private int ranking;
    private String vacantPosition;
    private int validTicket;
    private int gainVotes;
    private List<String> inspectFileName;

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

    public String getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public String getJoinPartyDate() {
        return joinPartyDate;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public String getCurrentPositionTime() {
        return currentPositionTime;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public String getFullTimeEducation() {
        return fullTimeEducation;
    }

    public String getCurrentEducation() {
        return currentEducation;
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

    public String getAppointDismissResult() {
        return appointDismissResult;
    }

    public String getMeetingDescribe() {
        return meetingDescribe;
    }

    public int getTalkNumber() {
        return talkNumber;
    }

    public int getRecommendNumber() {
        return recommendNumber;
    }

    public int getRanking() {
        return ranking;
    }

    public String getVacantPosition() {
        return vacantPosition;
    }

    public int getValidTicket() {
        return validTicket;
    }

    public int getGainVotes() {
        return gainVotes;
    }

    public String getInspectFileName() {
        if(inspectFileName == null || inspectFileName.size() == 0)
            return "";
        return GsonUtil.convertVO2String(inspectFileName);
    }
}