package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGwyZHGL {


    /**
     * deptId : 294
     * deptName : 公安局
     * subset : 0
     * display : 0
     * orgType : null
     * financeType : null
     * verificationez : 0
     * verificationsz : 0
     * verificationsiz : 0
     * actualez : 0
     * actualsz : 0
     * actualsiz : 0
     * actualyg : 0
     * actualeg : 0
     * actualsg : 0
     * actualsig : 0
     * actualjsy : 0
     * surpassez : 0
     * surpasssz : 0
     * surpasssiz : 0
     * vacancyez : 0
     * vacancysz : 0
     * vacancysiz : 0
     */

    @Id(autoincrement = true)
    private Long _id;

    private int deptId;
    private String deptName;
    private int subset;
    private int display;
    private String gwyType;
    private int verificationed;
    private int verificationsd;
    private int verificationsid;
    private int verificationyez;
    private int verificationssz;
    private int actualed;
    private int actualsd;
    private int actualsid;
    private int actualyz;
    private int actualez;
    private int actualsz;
    private int actualsiz;
    private int actualyk;
    private int actualek;
    private int surpassed;
    private int surpasssd;
    private int surpasssid;
    private int surpassyez;
    private int surpassssz;
    private int vacancyed;
    private int vacancysd;
    private int vacancysid;
    private int vacancyyez;
    private int vacancyssz;
    private String surpass;
    private String lack;

    @Generated(hash = 689773519)
    public DBGwyZHGL(Long _id, int deptId, String deptName, int subset, int display,
            String gwyType, int verificationed, int verificationsd,
            int verificationsid, int verificationyez, int verificationssz,
            int actualed, int actualsd, int actualsid, int actualyz, int actualez,
            int actualsz, int actualsiz, int actualyk, int actualek, int surpassed,
            int surpasssd, int surpasssid, int surpassyez, int surpassssz,
            int vacancyed, int vacancysd, int vacancysid, int vacancyyez,
            int vacancyssz, String surpass, String lack) {
        this._id = _id;
        this.deptId = deptId;
        this.deptName = deptName;
        this.subset = subset;
        this.display = display;
        this.gwyType = gwyType;
        this.verificationed = verificationed;
        this.verificationsd = verificationsd;
        this.verificationsid = verificationsid;
        this.verificationyez = verificationyez;
        this.verificationssz = verificationssz;
        this.actualed = actualed;
        this.actualsd = actualsd;
        this.actualsid = actualsid;
        this.actualyz = actualyz;
        this.actualez = actualez;
        this.actualsz = actualsz;
        this.actualsiz = actualsiz;
        this.actualyk = actualyk;
        this.actualek = actualek;
        this.surpassed = surpassed;
        this.surpasssd = surpasssd;
        this.surpasssid = surpasssid;
        this.surpassyez = surpassyez;
        this.surpassssz = surpassssz;
        this.vacancyed = vacancyed;
        this.vacancysd = vacancysd;
        this.vacancysid = vacancysid;
        this.vacancyyez = vacancyyez;
        this.vacancyssz = vacancyssz;
        this.surpass = surpass;
        this.lack = lack;
    }
    @Generated(hash = 453172136)
    public DBGwyZHGL() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getDeptId() {
        return this.deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public String getDeptName() {
        return this.deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public int getSubset() {
        return this.subset;
    }
    public void setSubset(int subset) {
        this.subset = subset;
    }
    public int getDisplay() {
        return this.display;
    }
    public void setDisplay(int display) {
        this.display = display;
    }
    public String getGwyType() {
        return this.gwyType;
    }
    public void setGwyType(String gwyType) {
        this.gwyType = gwyType;
    }
    public int getVerificationed() {
        return this.verificationed;
    }
    public void setVerificationed(int verificationed) {
        this.verificationed = verificationed;
    }
    public int getVerificationsd() {
        return this.verificationsd;
    }
    public void setVerificationsd(int verificationsd) {
        this.verificationsd = verificationsd;
    }
    public int getVerificationsid() {
        return this.verificationsid;
    }
    public void setVerificationsid(int verificationsid) {
        this.verificationsid = verificationsid;
    }
    public int getVerificationyez() {
        return this.verificationyez;
    }
    public void setVerificationyez(int verificationyez) {
        this.verificationyez = verificationyez;
    }
    public int getVerificationssz() {
        return this.verificationssz;
    }
    public void setVerificationssz(int verificationssz) {
        this.verificationssz = verificationssz;
    }
    public int getActualed() {
        return this.actualed;
    }
    public void setActualed(int actualed) {
        this.actualed = actualed;
    }
    public int getActualsd() {
        return this.actualsd;
    }
    public void setActualsd(int actualsd) {
        this.actualsd = actualsd;
    }
    public int getActualsid() {
        return this.actualsid;
    }
    public void setActualsid(int actualsid) {
        this.actualsid = actualsid;
    }
    public int getActualyz() {
        return this.actualyz;
    }
    public void setActualyz(int actualyz) {
        this.actualyz = actualyz;
    }
    public int getActualez() {
        return this.actualez;
    }
    public void setActualez(int actualez) {
        this.actualez = actualez;
    }
    public int getActualsz() {
        return this.actualsz;
    }
    public void setActualsz(int actualsz) {
        this.actualsz = actualsz;
    }
    public int getActualsiz() {
        return this.actualsiz;
    }
    public void setActualsiz(int actualsiz) {
        this.actualsiz = actualsiz;
    }
    public int getActualyk() {
        return this.actualyk;
    }
    public void setActualyk(int actualyk) {
        this.actualyk = actualyk;
    }
    public int getActualek() {
        return this.actualek;
    }
    public void setActualek(int actualek) {
        this.actualek = actualek;
    }
    public int getSurpassed() {
        return this.surpassed;
    }
    public void setSurpassed(int surpassed) {
        this.surpassed = surpassed;
    }
    public int getSurpasssd() {
        return this.surpasssd;
    }
    public void setSurpasssd(int surpasssd) {
        this.surpasssd = surpasssd;
    }
    public int getSurpasssid() {
        return this.surpasssid;
    }
    public void setSurpasssid(int surpasssid) {
        this.surpasssid = surpasssid;
    }
    public int getSurpassyez() {
        return this.surpassyez;
    }
    public void setSurpassyez(int surpassyez) {
        this.surpassyez = surpassyez;
    }
    public int getSurpassssz() {
        return this.surpassssz;
    }
    public void setSurpassssz(int surpassssz) {
        this.surpassssz = surpassssz;
    }
    public int getVacancyed() {
        return this.vacancyed;
    }
    public void setVacancyed(int vacancyed) {
        this.vacancyed = vacancyed;
    }
    public int getVacancysd() {
        return this.vacancysd;
    }
    public void setVacancysd(int vacancysd) {
        this.vacancysd = vacancysd;
    }
    public int getVacancysid() {
        return this.vacancysid;
    }
    public void setVacancysid(int vacancysid) {
        this.vacancysid = vacancysid;
    }
    public int getVacancyyez() {
        return this.vacancyyez;
    }
    public void setVacancyyez(int vacancyyez) {
        this.vacancyyez = vacancyyez;
    }
    public int getVacancyssz() {
        return this.vacancyssz;
    }
    public void setVacancyssz(int vacancyssz) {
        this.vacancyssz = vacancyssz;
    }
    public String getSurpass() {
        return this.surpass;
    }
    public void setSurpass(String surpass) {
        this.surpass = surpass;
    }
    public String getLack() {
        return this.lack;
    }
    public void setLack(String lack) {
        this.lack = lack;
    }

}
