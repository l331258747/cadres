package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBTyHjList {
    @Id(autoincrement = true)
    private Long _id;
    String scw;
    String szf;
    String srd;
    String szx;
    @Generated(hash = 438155319)
    public DBTyHjList(Long _id, String scw, String szf, String srd, String szx) {
        this._id = _id;
        this.scw = scw;
        this.szf = szf;
        this.srd = srd;
        this.szx = szx;
    }
    @Generated(hash = 852433553)
    public DBTyHjList() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getScw() {
        return this.scw;
    }
    public void setScw(String scw) {
        this.scw = scw;
    }
    public String getSzf() {
        return this.szf;
    }
    public void setSzf(String szf) {
        this.szf = szf;
    }
    public String getSrd() {
        return this.srd;
    }
    public void setSrd(String srd) {
        this.srd = srd;
    }
    public String getSzx() {
        return this.szx;
    }
    public void setSzx(String szx) {
        this.szx = szx;
    }

}
