package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBTyZsNqgb {

    @Id(autoincrement = true)
    private Long _id;
    private String year;
    private int principal;
    private int deputy;

    private int sum;
    private int jlh;

    @Generated(hash = 459132438)
    public DBTyZsNqgb(Long _id, String year, int principal, int deputy, int sum,
            int jlh) {
        this._id = _id;
        this.year = year;
        this.principal = principal;
        this.deputy = deputy;
        this.sum = sum;
        this.jlh = jlh;
    }

    @Generated(hash = 1288557859)
    public DBTyZsNqgb() {
    }

    public String getYear() {
        return year;
    }

    public int getPrincipal() {
        return principal;
    }

    public int getDeputy() {
        return deputy;
        }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public void setDeputy(int deputy) {
        this.deputy = deputy;
    }

    public int getSum() {
        return this.sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getJlh() {
        return this.jlh;
    }

    public void setJlh(int jlh) {
        this.jlh = jlh;
    }
    }