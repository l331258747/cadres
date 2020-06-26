package com.example.cadres.bean.Gb;

public class GbCadreAwardPunishList {
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

    public GbCadreAwardPunishList(int awardPunishId, int baseId, String cadreName, String awardPunishType, String awardType, String awardLevel, String punishType, String awardPunishName, String ratifyTime, String ratifyDept, String awardPunishReason, String awardPunishExplain) {
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
}