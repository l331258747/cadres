package com.example.cadres.bean.common;

/**
 * Created by jinty on 2020/6/23.
 */

public class ListDialogBean {
    int id;
    String name;

    public ListDialogBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
