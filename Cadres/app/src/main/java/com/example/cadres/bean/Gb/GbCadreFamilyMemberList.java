package com.example.cadres.bean.Gb;

public class GbCadreFamilyMemberList {
    int memberId;
    int baseId;
    String cadreName;
    String appellation;
    String name;
    String birthday;
    String politicalOutlook;
    String workUnit;

    public GbCadreFamilyMemberList(int memberId, int baseId, String cadreName, String appellation, String name, String birthday, String politicalOutlook, String workUnit) {
        this.memberId = memberId;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.appellation = appellation;
        this.name = name;
        this.birthday = birthday;
        this.politicalOutlook = politicalOutlook;
        this.workUnit = workUnit;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public String getAppellation() {
        return appellation;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public String getWorkUnit() {
        return workUnit;
    }
}