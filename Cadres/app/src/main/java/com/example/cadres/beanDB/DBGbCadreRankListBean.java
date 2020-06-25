package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGbCadreRankListBean {

    @Id(autoincrement = true)
    private Long _id;
    private int rankId;
    private int baseId;
    private String cadreName;
    private String state;
    private String dutiesRank;
    private String dutiesRankTime;
    private String treatmentRank;
    private String treatmentRankTime;

    @Generated(hash = 1508762141)
    public DBGbCadreRankListBean(Long _id, int rankId, int baseId, String cadreName,
            String state, String dutiesRank, String dutiesRankTime,
            String treatmentRank, String treatmentRankTime) {
        this._id = _id;
        this.rankId = rankId;
        this.baseId = baseId;
        this.cadreName = cadreName;
        this.state = state;
        this.dutiesRank = dutiesRank;
        this.dutiesRankTime = dutiesRankTime;
        this.treatmentRank = treatmentRank;
        this.treatmentRankTime = treatmentRankTime;
    }

    @Generated(hash = 718064865)
    public DBGbCadreRankListBean() {
    }

    public int getRankId() {
        return rankId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public String getState() {
        return state;
    }

    public String getDutiesRank() {
        return dutiesRank;
    }

    public String getDutiesRankTime() {
        return dutiesRankTime;
    }

    public String getTreatmentRank() {
        return treatmentRank;
    }

    public String getTreatmentRankTime() {
        return treatmentRankTime;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public void setCadreName(String cadreName) {
        this.cadreName = cadreName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDutiesRank(String dutiesRank) {
        this.dutiesRank = dutiesRank;
    }

    public void setDutiesRankTime(String dutiesRankTime) {
        this.dutiesRankTime = dutiesRankTime;
    }

    public void setTreatmentRank(String treatmentRank) {
        this.treatmentRank = treatmentRank;
    }

    public void setTreatmentRankTime(String treatmentRankTime) {
        this.treatmentRankTime = treatmentRankTime;
    }
}