package com.example.cadres.bean.Gb;

public class GbCadreRankListBean {
    /**
     * searchValue : null
     * createBy : 管理员
     * createTime : 2020-06-15 17:33:56
     * updateBy : 管理员
     * updateTime : 2020-06-22 15:13:38
     * remark : null
     * deptCode : null
     * params : {}
     * rankId : 200
     * baseId : 218
     * cadreName : 张三
     * state : 现行
     * dutiesRank : 正科
     * dutiesRankTime : 2020-06-16
     * treatmentRank : 正处
     * treatmentRankTime : 2020-06-10
     */

    private int rankId;
    private int baseId;
    private String cadreName;
    private String state;
    private String dutiesRank;
    private String dutiesRankTime;
    private String treatmentRank;
    private String treatmentRankTime;

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
}