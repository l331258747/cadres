package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGwyZQ {


    /**
     * deptId : 277
     * deptName : 人民法院
     * subset : 0
     * display : 0
     * orgType : null
     * financeType : null
     * verificationeg : 0
     * verificationsg : 0
     * verificationsig : 0
     * actualeg : 0
     * actualsg : 0
     * actualsig : 0
     * actualyb : 0
     * actualeb : 0
     * actualsb : 0
     * actualsib : 0
     * actualyx : 0
     * actualex : 0
     * surpasseg : 0
     * surpasssg : 0
     * surpasssig : 0
     * vacancyeg : 0
     * vacancysg : 0
     * vacancysig : 0
     */

    @Id(autoincrement = true)
    private Long _id;

    private int deptId;
    private String deptName;
    private int subset;
    private int display;
    private int verificationeg;
    private int verificationsg;
    private int verificationsig;
    private int actualeg;
    private int actualsg;
    private int actualsig;
    private int actualyb;
    private int actualeb;
    private int actualsb;
    private int actualsib;
    private int actualyx;
    private int actualex;
    private int surpasseg;
    private int surpasssg;
    private int surpasssig;
    private int vacancyeg;
    private int vacancysg;
    private int vacancysig;


    @Generated(hash = 1157781641)
    public DBGwyZQ(Long _id, int deptId, String deptName, int subset, int display,
            int verificationeg, int verificationsg, int verificationsig,
            int actualeg, int actualsg, int actualsig, int actualyb, int actualeb,
            int actualsb, int actualsib, int actualyx, int actualex, int surpasseg,
            int surpasssg, int surpasssig, int vacancyeg, int vacancysg,
            int vacancysig) {
        this._id = _id;
        this.deptId = deptId;
        this.deptName = deptName;
        this.subset = subset;
        this.display = display;
        this.verificationeg = verificationeg;
        this.verificationsg = verificationsg;
        this.verificationsig = verificationsig;
        this.actualeg = actualeg;
        this.actualsg = actualsg;
        this.actualsig = actualsig;
        this.actualyb = actualyb;
        this.actualeb = actualeb;
        this.actualsb = actualsb;
        this.actualsib = actualsib;
        this.actualyx = actualyx;
        this.actualex = actualex;
        this.surpasseg = surpasseg;
        this.surpasssg = surpasssg;
        this.surpasssig = surpasssig;
        this.vacancyeg = vacancyeg;
        this.vacancysg = vacancysg;
        this.vacancysig = vacancysig;
    }

    @Generated(hash = 2110225519)
    public DBGwyZQ() {
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

    public int getVerificationeg() {
        return verificationeg;
    }

    public int getVerificationsg() {
        return verificationsg;
    }

    public int getVerificationsig() {
        return verificationsig;
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

    public int getActualyb() {
        return actualyb;
    }

    public int getActualeb() {
        return actualeb;
    }

    public int getActualsb() {
        return actualsb;
    }

    public int getActualsib() {
        return actualsib;
    }

    public int getActualyx() {
        return actualyx;
    }

    public int getActualex() {
        return actualex;
    }

    public int getSurpasseg() {
        return surpasseg;
    }

    public int getSurpasssg() {
        return surpasssg;
    }

    public int getSurpasssig() {
        return surpasssig;
    }

    public int getVacancyeg() {
        return vacancyeg;
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

    public void setVerificationeg(int verificationeg) {
        this.verificationeg = verificationeg;
    }

    public void setVerificationsg(int verificationsg) {
        this.verificationsg = verificationsg;
    }

    public void setVerificationsig(int verificationsig) {
        this.verificationsig = verificationsig;
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

    public void setActualyb(int actualyb) {
        this.actualyb = actualyb;
    }

    public void setActualeb(int actualeb) {
        this.actualeb = actualeb;
    }

    public void setActualsb(int actualsb) {
        this.actualsb = actualsb;
    }

    public void setActualsib(int actualsib) {
        this.actualsib = actualsib;
    }

    public void setActualyx(int actualyx) {
        this.actualyx = actualyx;
    }

    public void setActualex(int actualex) {
        this.actualex = actualex;
    }

    public void setSurpasseg(int surpasseg) {
        this.surpasseg = surpasseg;
    }

    public void setSurpasssg(int surpasssg) {
        this.surpasssg = surpasssg;
    }

    public void setSurpasssig(int surpasssig) {
        this.surpasssig = surpasssig;
    }

    public void setVacancyeg(int vacancyeg) {
        this.vacancyeg = vacancyeg;
    }

    public void setVacancysg(int vacancysg) {
        this.vacancysg = vacancysg;
    }

    public void setVacancysig(int vacancysig) {
        this.vacancysig = vacancysig;
    }
}
