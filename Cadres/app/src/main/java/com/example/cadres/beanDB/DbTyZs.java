package com.example.cadres.beanDB;

import com.example.cadres.bean.dsjty.ZstyBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbTyZs {

    @Id(autoincrement = true)
    private Long _id;
    private int deptid;
    private int overmatch;
    private int parallel;
    private int vacancy;
    private int toVacancy;
    private String rankAgeList;
    @Generated(hash = 1918383528)
    public DbTyZs(Long _id, int deptid, int overmatch, int parallel, int vacancy,
                  int toVacancy, String rankAgeList) {
        this._id = _id;
        this.deptid = deptid;
        this.overmatch = overmatch;
        this.parallel = parallel;
        this.vacancy = vacancy;
        this.toVacancy = toVacancy;
        this.rankAgeList = rankAgeList;
    }
    @Generated(hash = 1978947415)
    public DbTyZs() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getDeptid() {
        return this.deptid;
    }
    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }
    public int getOvermatch() {
        return this.overmatch;
    }
    public void setOvermatch(int overmatch) {
        this.overmatch = overmatch;
    }
    public int getParallel() {
        return this.parallel;
    }
    public void setParallel(int parallel) {
        this.parallel = parallel;
    }
    public int getVacancy() {
        return this.vacancy;
    }
    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }
    public int getToVacancy() {
        return this.toVacancy;
    }
    public void setToVacancy(int toVacancy) {
        this.toVacancy = toVacancy;
    }
    public String getRankAgeList() {
        return this.rankAgeList;
    }
    public void setRankAgeList(String rankAgeList) {
        this.rankAgeList = rankAgeList;
    }
}
