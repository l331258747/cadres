package com.example.cadres.bean.common;

/**
 * Created by jinty on 2020/6/23.
 */

public class ListDialogBean {
    int id;
    String name;
    String sId;

    public ListDialogBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ListDialogBean(String sId, String name) {
        this.sId = sId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getsId() {
        return sId;
    }

    public String getName() {
        return name;
    }
}
