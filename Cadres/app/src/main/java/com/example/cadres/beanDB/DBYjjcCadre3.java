package com.example.cadres.beanDB;

import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

public class DBYjjcCadre3 {

    private int groupingId;
    private String groupingName;

    private List<DBYjjcCadre> list;

    public int getGroupingId() {
        return groupingId;
    }

    public void setGroupingId(int groupingId) {
        this.groupingId = groupingId;
    }

    public String getGroupingName() {
        return groupingName;
    }

    public void setGroupingName(String groupingName) {
        this.groupingName = groupingName;
    }

    public List<DBYjjcCadre> getList() {
        return list;
    }

    public void setList(List<DBYjjcCadre> list) {
        this.list = list;
    }
}
