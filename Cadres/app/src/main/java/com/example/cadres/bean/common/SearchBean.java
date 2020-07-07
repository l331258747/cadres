package com.example.cadres.bean.common;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SearchBean implements Serializable {
    String search;
    List<String> gblxLists;
    List<String> bmlxLists;
    List<String> csnLists;
    List<String> zwjbLists;
    List<String> xlLists;
    List<String> xxlxLists;
    List<String> gzjlLists;
    List<String> xrzjnxLists;
    List<String> xbLists;
    List<String> dpLists;
    List<String> xllxLists;
    String cyss;

    public SearchBean() {
        gblxLists = new ArrayList<>();
        bmlxLists = new ArrayList<>();
        csnLists = new ArrayList<>();
        zwjbLists = new ArrayList<>();
        xlLists = new ArrayList<>();
        xxlxLists = new ArrayList<>();
        gzjlLists = new ArrayList<>();
        xrzjnxLists = new ArrayList<>();
        xbLists = new ArrayList<>();
        dpLists = new ArrayList<>();
        xllxLists = new ArrayList<>();
    }

    public void clean(){
        search = "";
        cyss = "";
        gblxLists = new ArrayList<>();
        bmlxLists = new ArrayList<>();
        csnLists = new ArrayList<>();
        zwjbLists = new ArrayList<>();
        xlLists = new ArrayList<>();
        xxlxLists = new ArrayList<>();
        gzjlLists = new ArrayList<>();
        xrzjnxLists = new ArrayList<>();
        xbLists = new ArrayList<>();
        dpLists = new ArrayList<>();
        xllxLists = new ArrayList<>();
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setCyss(String cyss) {
        this.cyss = cyss;
    }

    public List<String> getGblxLists() {
        for (String str : gblxLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return gblxLists;
    }

    public String getCyss() {
        return cyss;
    }

    public void setGblxLists(List<String> gblxLists) {
        this.gblxLists = gblxLists;
    }

    public List<String> getBmlxLists() {
        for (String str : bmlxLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return bmlxLists;
    }

    public void setBmlxLists(List<String> bmlxLists) {
        this.bmlxLists = bmlxLists;
    }

    public List<String> getCsnLists() {
        if(csnLists.size() == 0)
            return csnLists = new ArrayList<>();
        if(csnLists.get(0).equals("1950") && csnLists.get(1).equals("2000"))
            return csnLists = new ArrayList<>();
        return csnLists;
    }

    public void setCsnLists(List<String> csnLists) {
        this.csnLists = csnLists;
    }

    public List<String> getZwjbLists() {
        for (String str : zwjbLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return zwjbLists;
    }

    public void setZwjbLists(List<String> zwjbLists) {
        this.zwjbLists = zwjbLists;
    }

    public List<String> getXlLists() {
        for (String str : xlLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return xlLists;
    }

    public void setXlLists(List<String> xlLists) {
        this.xlLists = xlLists;
    }

    public List<String> getXllxLists(){
        for (String str : xllxLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return xllxLists;
    }

    public int getXllxType(){
        if(xllxLists == null) return 0;
        if(xllxLists.size() == 1){
            if(TextUtils.equals(xllxLists.get(0),"全日制"))
                return 1;
            if(TextUtils.equals(xllxLists.get(0),"在职教育"))
                return 2;

        }
        return 0;
    }

    public List<String> getXxlxLists() {
        for (String str : xxlxLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return xxlxLists;
    }

    public void setXxlxLists(List<String> xxlxLists) {
        this.xxlxLists = xxlxLists;
    }

    public List<String> getGzjlLists() {
        for (String str : gzjlLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return gzjlLists;
    }

    public void setGzjlLists(List<String> gzjlLists) {
        this.gzjlLists = gzjlLists;
    }

    public List<String> getXrzjnxLists() {
        if(xrzjnxLists.size() == 0)
            return xrzjnxLists = new ArrayList<>();
        if(xrzjnxLists.get(0).equals("0") && xrzjnxLists.get(1).equals("20"))
            return xrzjnxLists = new ArrayList<>();
        return xrzjnxLists;
    }

    public List<String> getXrzjnxLists2() {
        if(xrzjnxLists.size() == 0)
            return new ArrayList<>();
        if(xrzjnxLists.get(0).equals("0") && xrzjnxLists.get(1).equals("20"))
            return new ArrayList<>();
        int min = getCurrentYear() - Integer.parseInt(xrzjnxLists.get(1));
        int max = getCurrentYear() - Integer.parseInt(xrzjnxLists.get(0));
        xrzjnxLists = new ArrayList<>();
        xrzjnxLists.add(min + "");
        xrzjnxLists.add(max + "");
        return xrzjnxLists;
    }

    public int getCurrentYear(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    public void setXrzjnxLists(List<String> xrzjnxLists) {
        this.xrzjnxLists = xrzjnxLists;
    }

    public List<String> getXbLists() {
        for (String str : xbLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return xbLists;
    }

    public void setXbLists(List<String> xbLists) {
        this.xbLists = xbLists;
    }

    public List<String> getDpLists() {
        for (String str : dpLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return dpLists;
    }

    //是否存在非共党员
    public boolean isDpFzgdn(){
        for (String str : dpLists)
            if(str.equals("非中共党员"))
                return true;
            return false;
    }

    public void setDpLists(List<String> dpLists) {
        this.dpLists = dpLists;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (String str : getGblxLists()){
            sb.append(str + "/");
        }
        for (String str : getBmlxLists()){
            sb.append(str + "/");
        }
        if(getCsnLists().size() == 2){
            sb.append(getCsnLists().get(0) + " - " + getCsnLists().get(1) + "/");
        }
        for (String str : getZwjbLists()){
            sb.append(str + "/");
        }
        for (String str : getXlLists()){
            sb.append(str + "/");
        }
        for (String str : getXllxLists()){
            sb.append(str + "/");
        }
        for (String str : getXxlxLists()){
            sb.append(str + "/");
        }
        for (String str : getGzjlLists()){
            sb.append(str + "/");
        }
        if(getXrzjnxLists().size() == 2){
            sb.append(getXrzjnxLists().get(0) + " - " + getXrzjnxLists().get(1) + "/");
        }
        for (String str : getXbLists()){
            sb.append(str + "/");
        }
        for (String str : getDpLists()){
            sb.append(str + "/");
        }
        return sb.toString();
    }
}
