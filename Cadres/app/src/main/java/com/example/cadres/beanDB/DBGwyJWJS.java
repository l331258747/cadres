package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGwyJWJS {


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
    private int verificationez;
    private int verificationsz;
    private int verificationsiz;
    private int actualez;
    private int actualsz;
    private int actualsiz;
    private int actualyg;
    private int actualeg;
    private int actualsg;
    private int actualsig;
    private int actualjsy;
    private int surpassez;
    private int surpasssz;
    private int surpasssiz;
    private int vacancyez;
    private int vacancysz;
    private int vacancysiz;
    private String surpass;
    private String lack;

    @Generated(hash = 1770138413)
    public DBGwyJWJS(Long _id, int deptId, String deptName, int subset, int display,
            int verificationez, int verificationsz, int verificationsiz,
            int actualez, int actualsz, int actualsiz, int actualyg, int actualeg,
            int actualsg, int actualsig, int actualjsy, int surpassez,
            int surpasssz, int surpasssiz, int vacancyez, int vacancysz,
            int vacancysiz, String surpass, String lack) {
        this._id = _id;
        this.deptId = deptId;
        this.deptName = deptName;
        this.subset = subset;
        this.display = display;
        this.verificationez = verificationez;
        this.verificationsz = verificationsz;
        this.verificationsiz = verificationsiz;
        this.actualez = actualez;
        this.actualsz = actualsz;
        this.actualsiz = actualsiz;
        this.actualyg = actualyg;
        this.actualeg = actualeg;
        this.actualsg = actualsg;
        this.actualsig = actualsig;
        this.actualjsy = actualjsy;
        this.surpassez = surpassez;
        this.surpasssz = surpasssz;
        this.surpasssiz = surpasssiz;
        this.vacancyez = vacancyez;
        this.vacancysz = vacancysz;
        this.vacancysiz = vacancysiz;
        this.surpass = surpass;
        this.lack = lack;
    }

    @Generated(hash = 1353522994)
    public DBGwyJWJS() {
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getSubset() {
        return subset;
    }

    public int getDisplay() {
        return display;
    }

    public int getVerificationez() {
        return verificationez;
    }

    public int getVerificationsz() {
        return verificationsz;
    }

    public int getVerificationsiz() {
        return verificationsiz;
    }

    public int getActualez() {
        return actualez;
    }

    public int getActualsz() {
        return actualsz;
    }

    public int getActualsiz() {
        return actualsiz;
    }

    public int getActualyg() {
        return actualyg;
    }

    public int getActualeg() {
        return actualeg;
    }

    public int getActualsg() {
        return actualsg;
    }

    public int getActualsig() {
        return actualsig;
    }

    public int getActualjsy() {
        return actualjsy;
    }

    public int getSurpassez() {
        return surpassez;
    }

    public int getSurpasssz() {
        return surpasssz;
    }

    public int getSurpasssiz() {
        return surpasssiz;
    }

    public int getVacancyez() {
        return vacancyez;
    }

    public int getVacancysz() {
        return vacancysz;
    }

    public int getVacancysiz() {
        return vacancysiz;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setSubset(int subset) {
        this.subset = subset;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public void setVerificationez(int verificationez) {
        this.verificationez = verificationez;
    }

    public void setVerificationsz(int verificationsz) {
        this.verificationsz = verificationsz;
    }

    public void setVerificationsiz(int verificationsiz) {
        this.verificationsiz = verificationsiz;
    }

    public void setActualez(int actualez) {
        this.actualez = actualez;
    }

    public void setActualsz(int actualsz) {
        this.actualsz = actualsz;
    }

    public void setActualsiz(int actualsiz) {
        this.actualsiz = actualsiz;
    }

    public void setActualyg(int actualyg) {
        this.actualyg = actualyg;
    }

    public void setActualeg(int actualeg) {
        this.actualeg = actualeg;
    }

    public void setActualsg(int actualsg) {
        this.actualsg = actualsg;
    }

    public void setActualsig(int actualsig) {
        this.actualsig = actualsig;
    }

    public void setActualjsy(int actualjsy) {
        this.actualjsy = actualjsy;
    }

    public void setSurpassez(int surpassez) {
        this.surpassez = surpassez;
    }

    public void setSurpasssz(int surpasssz) {
        this.surpasssz = surpasssz;
    }

    public void setSurpasssiz(int surpasssiz) {
        this.surpasssiz = surpasssiz;
    }

    public void setVacancyez(int vacancyez) {
        this.vacancyez = vacancyez;
    }

    public void setVacancysz(int vacancysz) {
        this.vacancysz = vacancysz;
    }

    public void setVacancysiz(int vacancysiz) {
        this.vacancysiz = vacancysiz;
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
