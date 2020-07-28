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

    @Generated(hash = 1277321114)
    public DBTyZsNqgb(Long _id, String year, int principal, int deputy) {
        this._id = _id;
        this.year = year;
        this.principal = principal;
        this.deputy = deputy;
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
    }