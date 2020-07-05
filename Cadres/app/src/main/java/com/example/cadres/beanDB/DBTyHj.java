package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBTyHj {

    @Id(autoincrement = true)
    private Long _id;
    private int swbzcount;
    private int inconformityswbz;
    private int szfbzcount;
    private int inconformityszfbz;
    private int srdbzcount;
    private int inconformitysrdbz;
    private int szxzcount;
    private int inconformityszx;
    @Generated(hash = 1382543515)
    public DBTyHj(Long _id, int swbzcount, int inconformityswbz, int szfbzcount,
                  int inconformityszfbz, int srdbzcount, int inconformitysrdbz,
                  int szxzcount, int inconformityszx) {
        this._id = _id;
        this.swbzcount = swbzcount;
        this.inconformityswbz = inconformityswbz;
        this.szfbzcount = szfbzcount;
        this.inconformityszfbz = inconformityszfbz;
        this.srdbzcount = srdbzcount;
        this.inconformitysrdbz = inconformitysrdbz;
        this.szxzcount = szxzcount;
        this.inconformityszx = inconformityszx;
    }
    @Generated(hash = 1729412793)
    public DBTyHj() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getSwbzcount() {
        return this.swbzcount;
    }
    public void setSwbzcount(int swbzcount) {
        this.swbzcount = swbzcount;
    }
    public int getInconformityswbz() {
        return this.inconformityswbz;
    }
    public void setInconformityswbz(int inconformityswbz) {
        this.inconformityswbz = inconformityswbz;
    }
    public int getSzfbzcount() {
        return this.szfbzcount;
    }
    public void setSzfbzcount(int szfbzcount) {
        this.szfbzcount = szfbzcount;
    }
    public int getInconformityszfbz() {
        return this.inconformityszfbz;
    }
    public void setInconformityszfbz(int inconformityszfbz) {
        this.inconformityszfbz = inconformityszfbz;
    }
    public int getSrdbzcount() {
        return this.srdbzcount;
    }
    public void setSrdbzcount(int srdbzcount) {
        this.srdbzcount = srdbzcount;
    }
    public int getInconformitysrdbz() {
        return this.inconformitysrdbz;
    }
    public void setInconformitysrdbz(int inconformitysrdbz) {
        this.inconformitysrdbz = inconformitysrdbz;
    }
    public int getSzxzcount() {
        return this.szxzcount;
    }
    public void setSzxzcount(int szxzcount) {
        this.szxzcount = szxzcount;
    }
    public int getInconformityszx() {
        return this.inconformityszx;
    }
    public void setInconformityszx(int inconformityszx) {
        this.inconformityszx = inconformityszx;
    }

}
