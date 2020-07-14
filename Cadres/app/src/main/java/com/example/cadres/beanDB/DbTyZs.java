package com.example.cadres.beanDB;

import com.example.cadres.bean.dsjty.RankAgeList;
import com.example.cadres.bean.dsjty.ZstyBean;
import com.example.cadres.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbTyZs {

    @Id(autoincrement = true)
    private Long _id;
    private String year;
    private int rankAge;
    private int toVacancy;
    private int parallel;
    private int overmatch;
    private int vacancy;
    private int digestion;
    @Generated(hash = 1231644486)
    public DbTyZs(Long _id, String year, int rankAge, int toVacancy, int parallel,
            int overmatch, int vacancy, int digestion) {
        this._id = _id;
        this.year = year;
        this.rankAge = rankAge;
        this.toVacancy = toVacancy;
        this.parallel = parallel;
        this.overmatch = overmatch;
        this.vacancy = vacancy;
        this.digestion = digestion;
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
    public String getYear() {
        return this.year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public int getRankAge() {
        return this.rankAge;
    }
    public void setRankAge(int rankAge) {
        this.rankAge = rankAge;
    }
    public int getToVacancy() {
        return this.toVacancy;
    }
    public void setToVacancy(int toVacancy) {
        this.toVacancy = toVacancy;
    }
    public int getParallel() {
        return this.parallel;
    }
    public void setParallel(int parallel) {
        this.parallel = parallel;
    }
    public int getOvermatch() {
        return this.overmatch;
    }
    public void setOvermatch(int overmatch) {
        this.overmatch = overmatch;
    }
    public int getVacancy() {
        return this.vacancy;
    }
    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }
    public int getDigestion() {
        return this.digestion;
    }
    public void setDigestion(int digestion) {
        this.digestion = digestion;
    }
    
}