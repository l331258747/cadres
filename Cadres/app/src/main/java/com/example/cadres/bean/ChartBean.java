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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
