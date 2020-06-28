package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBYjjcMeeting {

    @Id(autoincrement = true)
    private Long _id;
    private int meetingId;
    private int schemeId;
    private String schemeName;
    private String meetingSummary;
    private String meetingName;
    private String meetingType;
    private String meetingTime;
    private String meetingUser;
    private String meetingDescribe;
    private String materialFileName;
    @Generated(hash = 52710633)
    public DBYjjcMeeting(Long _id, int meetingId, int schemeId, String schemeName,
            String meetingSummary, String meetingName, String meetingType,
            String meetingTime, String meetingUser, String meetingDescribe,
            String materialFileName) {
        this._id = _id;
        this.meetingId = meetingId;
        this.schemeId = schemeId;
        this.schemeName = schemeName;
        this.meetingSummary = meetingSummary;
        this.meetingName = meetingName;
        this.meetingType = meetingType;
        this.meetingTime = meetingTime;
        this.meetingUser = meetingUser;
        this.meetingDescribe = meetingDescribe;
        this.materialFileName = materialFileName;
    }
    @Generated(hash = 2116069522)
    public DBYjjcMeeting() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getMeetingId() {
        return this.meetingId;
    }
    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
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
    public String getMeetingSummary() {
        return this.meetingSummary;
    }
    public void setMeetingSummary(String meetingSummary) {
        this.meetingSummary = meetingSummary;
    }
    public String getMeetingName() {
        return this.meetingName;
    }
    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }
    public String getMeetingType() {
        return this.meetingType;
    }
    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }
    public String getMeetingTime() {
        return this.meetingTime;
    }
    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }
    public String getMeetingUser() {
        return this.meetingUser;
    }
    public void setMeetingUser(String meetingUser) {
        this.meetingUser = meetingUser;
    }
    public String getMeetingDescribe() {
        return this.meetingDescribe;
    }
    public void setMeetingDescribe(String meetingDescribe) {
        this.meetingDescribe = meetingDescribe;
    }
    public String getMaterialFileName() {
        return this.materialFileName;
    }
    public void setMaterialFileName(String materialFileName) {
        this.materialFileName = materialFileName;
    }

}
