package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGbCadreAwardPunishList {

    @Id(autoincrement = true)
    private Long _id;
    int awardPunishId;
    int baseId;
    String cadreName;
    String awardPunishType;
    String awardType;
    String awardLevel;
    String punishType;
    String awardPunishName;
    String ratifyTime;
    String ratifyDept;
    String awardPunishReason;
    String awardPunishExplain;

    @Generated(hash = 50518642)
    public DBGbCadreAwardPunishList(Long _id, int awardPunishId, int baseId,
            String cadreName, String awardPunishType, String awardType,
            String awardLevel, String punishType, String awardPunishName,
            String ratifyTime, String ratifyDept, String awardPunishReason,
            String awardPunishExplain) {
        this._id = _id;
        this.awardPunishId = awardPunishId;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.awardPunishType = awardPunishType;
        this.awardType = awardType;
        this.awardLevel = awardLevel;
        this.punishType = punishType;
        this.awardPunishName = awardPunishName;
        this.ratifyTime = ratifyTime;
        this.ratifyDept = ratifyDept;
        this.awardPunishReason = awardPunishReason;
        this.awardPunishExplain = awardPunishExplain;
    }

    @Generated(hash = 916331367)
    public DBGbCadreAwardPunishList() {
    }

    public int getAwardPunishId() {
        return awardPunishId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public String getAwardPunishType() {
        return awardPunishType;
    }

    public String getAwardType() {
        return awardType;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public String getPunishType() {
        return punishType;
    }

    public String getAwardPunishName() {
        return awardPunishName;
    }

    public String getRatifyTime() {
        return ratifyTime;
    }

    public String getRatifyDept() {
        return ratifyDept;
    }

    public String getAwardPunishReason() {
        return awardPunishReason;
    }

    public String getAwardPunishExplain() {
        return awardPunishExplain;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setAwardPunishId(int awardPunishId) {
        this.awardPunishId = awardPunishId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public void setCadreName(String cadreName) {
        this.cadreName = cadreName;
    }

    public void setAwardPunishType(String awardPunishType) {
        this.awardPunishType = awardPunishType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public void setPunishType(String punishType) {
        this.punishType = punishType;
    }

    public void setAwardPunishName(String awardPunishName) {
        this.awardPunishName = awardPunishName;
    }

    public void setRatifyTime(String ratifyTime) {
        this.ratifyTime = ratifyTime;
    }

    public void setRatifyDept(String ratifyDept) {
        this.ratifyDept = ratifyDept;
    }

    public void setAwardPunishReason(String awardPunishReason) {
        this.awardPunishReason = awardPunishReason;
    }

    public void setAwardPunishExplain(String awardPunishExplain) {
        this.awardPunishExplain = awardPunishExplain;
    }
}