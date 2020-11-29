package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbYjjcCadreGrouping {

    @Id(autoincrement = true)
    private Long _id;
    
    private int groupingId;
    private int schemeId;
    private String groupingName;
    private int groupingRanking;
    @Generated(hash = 1888602792)
    public DbYjjcCadreGrouping(Long _id, int groupingId, int schemeId,
            String groupingName, int groupingRanking) {
        this._id = _id;
        this.groupingId = groupingId;
        this.schemeId = schemeId;
        this.groupingName = groupingName;
        this.groupingRanking = groupingRanking;
    }
    @Generated(hash = 1766416301)
    public DbYjjcCadreGrouping() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getGroupingId() {
        return this.groupingId;
    }
    public void setGroupingId(int groupingId) {
        this.groupingId = groupingId;
    }
    public int getSchemeId() {
        return this.schemeId;
    }
    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }
    public String getGroupingName() {
        return this.groupingName;
    }
    public void setGroupingName(String groupingName) {
        this.groupingName = groupingName;
    }
    public int getGroupingRanking() {
        return this.groupingRanking;
    }
    public void setGroupingRanking(int groupingRanking) {
        this.groupingRanking = groupingRanking;
    }
}
