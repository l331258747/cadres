package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBYjjcCadre {

    @Id(autoincrement = true)
    private Long _id;
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
    private String inspectFileName;
    @Generated(hash = 725041804)
    public DBYjjcCadre(Long _id, int dismissCadreId, int schemeId,
            String schemeName, int baseId, String cadreName, String gender,
            String birthday, int age, String joinPartyDate, String currentPosition,
            String currentPositionTime, String nativePlace,
            String fullTimeEducation, String currentEducation,
            String appointDismissType, int appointPosition,
            String appointPositionName, int appointDeptId, String appointDeptName,
            String positionTime, String positionReason, String positionFileNumber,
            String dismissPosition, String dismissPositionName,
            String dismissDeptId, String dismissDeptName, String leaveTime,
            String leaveReason, String leaveFileNumber, String currentRank,
            String appointDismissResult, String meetingDescribe, int talkNumber,
            int recommendNumber, int ranking, String vacantPosition,
            int validTicket, int gainVotes, String inspectFileName) {
        this._id = _id;
        this.dismissCadreId = dismissCadreId;
        this.schemeId = schemeId;
        this.schemeName = schemeName;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.joinPartyDate = joinPartyDate;
        this.currentPosition = currentPosition;
        this.currentPositionTime = currentPositionTime;
        this.nativePlace = nativePlace;
        this.fullTimeEducation = fullTimeEducation;
        this.currentEducation = currentEducation;
        this.appointDismissType = appointDismissType;
        this.appointPosition = appointPosition;
        this.appointPositionName = appointPositionName;
        this.appointDeptId = appointDeptId;
        this.appointDeptName = appointDeptName;
        this.positionTime = positionTime;
        this.positionReason = positionReason;
        this.positionFileNumber = positionFileNumber;
        this.dismissPosition = dismissPosition;
        this.dismissPositionName = dismissPositionName;
        this.dismissDeptId = dismissDeptId;
        this.dismissDeptName = dismissDeptName;
        this.leaveTime = leaveTime;
        this.leaveReason = leaveReason;
        this.leaveFileNumber = leaveFileNumber;
        this.currentRank = currentRank;
        this.appointDismissResult = appointDismissResult;
        this.meetingDescribe = meetingDescribe;
        this.talkNumber = talkNumber;
        this.recommendNumber = recommendNumber;
        this.ranking = ranking;
        this.vacantPosition = vacantPosition;
        this.validTicket = validTicket;
        this.gainVotes = gainVotes;
        this.inspectFileName = inspectFileName;
    }
    @Generated(hash = 1984640120)
    public DBYjjcCadre() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getDismissCadreId() {
        return this.dismissCadreId;
    }
    public void setDismissCadreId(int dismissCadreId) {
        this.dismissCadreId = dismissCadreId;
    }
    public int getSchemeId() {
        return this.schemeId;
    }
    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }
    public String getSchemeName() {
        return this.schemeName;
    }
    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
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
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getJoinPartyDate() {
        return this.joinPartyDate;
    }
    public void setJoinPartyDate(String joinPartyDate) {
        this.joinPartyDate = joinPartyDate;
    }
    public String getCurrentPosition() {
        return this.currentPosition;
    }
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }
    public String getCurrentPositionTime() {
        return this.currentPositionTime;
    }
    public void setCurrentPositionTime(String currentPositionTime) {
        this.currentPositionTime = currentPositionTime;
    }
    public String getNativePlace() {
        return this.nativePlace;
    }
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    public String getFullTimeEducation() {
        return this.fullTimeEducation;
    }
    public void setFullTimeEducation(String fullTimeEducation) {
        this.fullTimeEducation = fullTimeEducation;
    }
    public String getCurrentEducation() {
        return this.currentEducation;
    }
    public void setCurrentEducation(String currentEducation) {
        this.currentEducation = currentEducation;
    }
    public String getAppointDismissType() {
        return this.appointDismissType;
    }
    public void setAppointDismissType(String appointDismissType) {
        this.appointDismissType = appointDismissType;
    }
    public int getAppointPosition() {
        return this.appointPosition;
    }
    public void setAppointPosition(int appointPosition) {
        this.appointPosition = appointPosition;
    }
    public String getAppointPositionName() {
        return this.appointPositionName;
    }
    public void setAppointPositionName(String appointPositionName) {
        this.appointPositionName = appointPositionName;
    }
    public int getAppointDeptId() {
        return this.appointDeptId;
    }
    public void setAppointDeptId(int appointDeptId) {
        this.appointDeptId = appointDeptId;
    }
    public String getAppointDeptName() {
        return this.appointDeptName;
    }
    public void setAppointDeptName(String appointDeptName) {
        this.appointDeptName = appointDeptName;
    }
    public String getPositionTime() {
        return this.positionTime;
    }
    public void setPositionTime(String positionTime) {
        this.positionTime = positionTime;
    }
    public String getPositionReason() {
        return this.positionReason;
    }
    public void setPositionReason(String positionReason) {
        this.positionReason = positionReason;
    }
    public String getPositionFileNumber() {
        return this.positionFileNumber;
    }
    public void setPositionFileNumber(String positionFileNumber) {
        this.positionFileNumber = positionFileNumber;
    }
    public String getDismissPosition() {
        return this.dismissPosition;
    }
    public void setDismissPosition(String dismissPosition) {
        this.dismissPosition = dismissPosition;
    }
    public String getDismissPositionName() {
        return this.dismissPositionName;
    }
    public void setDismissPositionName(String dismissPositionName) {
        this.dismissPositionName = dismissPositionName;
    }
    public String getDismissDeptId() {
        return this.dismissDeptId;
    }
    public void setDismissDeptId(String dismissDeptId) {
        this.dismissDeptId = dismissDeptId;
    }
    public String getDismissDeptName() {
        return this.dismissDeptName;
    }
    public void setDismissDeptName(String dismissDeptName) {
        this.dismissDeptName = dismissDeptName;
    }
    public String getLeaveTime() {
        return this.leaveTime;
    }
    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }
    public String getLeaveReason() {
        return this.leaveReason;
    }
    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }
    public String getLeaveFileNumber() {
        return this.leaveFileNumber;
    }
    public void setLeaveFileNumber(String leaveFileNumber) {
        this.leaveFileNumber = leaveFileNumber;
    }
    public String getCurrentRank() {
        return this.currentRank;
    }
    public void setCurrentRank(String currentRank) {
        this.currentRank = currentRank;
    }
    public String getAppointDismissResult() {
        return this.appointDismissResult;
    }
    public void setAppointDismissResult(String appointDismissResult) {
        this.appointDismissResult = appointDismissResult;
    }
    public String getMeetingDescribe() {
        return this.meetingDescribe;
    }
    public void setMeetingDescribe(String meetingDescribe) {
        this.meetingDescribe = meetingDescribe;
    }
    public int getTalkNumber() {
        return this.talkNumber;
    }
    public void setTalkNumber(int talkNumber) {
        this.talkNumber = talkNumber;
    }
    public int getRecommendNumber() {
        return this.recommendNumber;
    }
    public void setRecommendNumber(int recommendNumber) {
        this.recommendNumber = recommendNumber;
    }
    public int getRanking() {
        return this.ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public String getVacantPosition() {
        return this.vacantPosition;
    }
    public void setVacantPosition(String vacantPosition) {
        this.vacantPosition = vacantPosition;
    }
    public int getValidTicket() {
        return this.validTicket;
    }
    public void setValidTicket(int validTicket) {
        this.validTicket = validTicket;
    }
    public int getGainVotes() {
        return this.gainVotes;
    }
    public void setGainVotes(int gainVotes) {
        this.gainVotes = gainVotes;
    }
    public String getInspectFileName() {
        return this.inspectFileName;
    }
    public void setInspectFileName(String inspectFileName) {
        this.inspectFileName = inspectFileName;
    }
}
