package com.example.cadres.bean;

public class ChartBean {


    public ChartBean() {
    }

    public ChartBean(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    /**
     * name : 男
     * amount : 4
     */




    private String name;
    private int amount;
    private int num;

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getNameAmout(){
        return name + ":" + amount + "人";
    }

    public String getNameNum(){
        return name + ":" + num + "人";
    }
}
