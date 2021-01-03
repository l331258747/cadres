package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGwyFGDJ {


    /**
     * deptId : 277
     * deptName : 人民法院
     * subset : 0
     * display : 0
     * orgType : 5
     * financeType : 1
     * gwyType : null
     * jurisdiction : null
     * verificationsg : 0
     * verificationsig : 0
     * actualsg : 0
     * actualsig : 0
     * actualyj : 0
     * actualej : 0
     * actualsj : 0
     * actualsij : 0
     * actualwuj : 0
     * surpasssg : 0
     * surpasssig : 0
     * vacancysg : 0
     * vacancysig : 0
     */

    @Id(autoincrement = true)
    private Long _id;

    private int deptId;
    private String deptName;
    private int subset;
    private int display;
    private String gwyType;
    private int verificationsg;
    private int verificationsig;
    private int actualsg;
    private int actualsig;
    private int actualyj;
    private int actualej;
    private int actualsj;
    private int actualsij;
    private int actualwuj;
    private int surpasssg;
    private int surpasssig;
    private int vacancysg;
    private int vacancysig;
    private String surpass;
    private String lack;

    @Generated(hash = 998066668)
    public DBGwyFGDJ(Long _id, int deptId, String deptName, int subset, int display,
            String gwyType, int verificationsg, int verificationsig, int actualsg,
            int actualsig, int actualyj, int actualej, int actualsj, int actualsij,
            int actualwuj, int surpasssg, int surpasssig, int vacancysg,
            int vacancysig, String surpass, String lack) {
        this._id = _id;
        this.deptId = deptId;
        this.deptName = deptName;
        this.subset = subset;
        this.display = display;
        this.gwyType = gwyType;
        this.verificationsg = verificationsg;
        this.verificationsig = verificationsig;
        this.actualsg = actualsg;
        this.actualsig = actualsig;
        this.actualyj = actualyj;
        this.actualej = actualej;
        this.actualsj = actualsj;
        this.actualsij = actualsij;
        this.actualwuj = actualwuj;
        this.surpasssg = surpasssg;
        this.surpasssig = surpasssig;
        this.vacancysg = vacancysg;
        this.vacancysig = vacancysig;
        this.surpass = surpass;
        this.lack = lack;
    }

    @Generated(hash = 14920966)
    public DBGwyFGDJ() {
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

    public String getGwyType() {
        return gwyType;
    }

    public int getVerificationsg() {
        return verificationsg;
    }

    public int getVerificationsig() {
        return verificationsig;
    }

    public int getActualsg() {
        return actualsg;
    }

    public int getActualsig() {
        return actualsig;
    }

    public int getActualyj() {
        return actualyj;
    }

    public int getActualej() {
        return actualej;
    }

    public int getActualsj() {
        return actualsj;
    }

    public int getActualsij() {
        return actualsij;
    }

    public int getActualwuj() {
        return actualwuj;
    }

    public int getSurpasssg() {
        return surpasssg;
    }

    public int getSurpasssig() {
        return surpasssig;
    }

    public int getVacancysg() {
        return vacancysg;
    }

    public int getVacancysig() {
        return vacancysig;
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

    public void setGwyType(String gwyType) {
        this.gwyType = gwyType;
    }

    public void setVerificationsg(int verificationsg) {
        this.verificationsg = verificationsg;
    }

    public void setVerificationsig(int verificationsig) {
        this.verificationsig = verificationsig;
    }

    public void setActualsg(int actualsg) {
        this.actualsg = actualsg;
    }

    public void setActualsig(int actualsig) {
        this.actualsig = actualsig;
    }

    public void setActualyj(int actualyj) {
        this.actualyj = actualyj;
    }

    public void setActualej(int actualej) {
        this.actualej = actualej;
    }

    public void setActualsj(int actualsj) {
        this.actualsj = actualsj;
    }

    public void setActualsij(int actualsij) {
        this.actualsij = actualsij;
    }

    public void setActualwuj(int actualwuj) {
        this.actualwuj = actualwuj;
    }

    public void setSurpasssg(int surpasssg) {
        this.surpasssg = surpasssg;
    }

    public void setSurpasssig(int surpasssig) {
        this.surpasssig = surpasssig;
    }

    public void setVacancysg(int vacancysg) {
        this.vacancysg = vacancysg;
    }

    public void setVacancysig(int vacancysig) {
        this.vacancysig = vacancysig;
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
