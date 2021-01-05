package com.example.cadres.bean.common;

import android.text.TextUtils;

import com.example.cadres.utils.GsonUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SearchDetailBean implements Serializable {
    String search;
    List<String> gblxLists;
    List<String> lxLists;
    List<String> bmlxLists;
    List<String> csnLists;
    List<String> xlLists;
    List<String> xxlxLists;
    List<String> gzjlLists;
    List<String> xrzjnxLists;
    List<String> xrzwccnxLists;
    List<String> rxznxLists;
    List<String> xbLists;
    List<String> dpLists;
    List<String> xrzwccLists;
    List<String> xllxLists;
    List<String> xrzjlxLists;
    List<String> xrzjLists;
    String cyssGd;
    String cyssZwlx;
    String cyssZwbqlx;

    public SearchDetailBean() {
        gblxLists = new ArrayList<>();
        lxLists = new ArrayList<>();
        bmlxLists = new ArrayList<>();
        csnLists = new ArrayList<>();
        xrzjLists = new ArrayList<>();
        xlLists = new ArrayList<>();
        xxlxLists = new ArrayList<>();
        gzjlLists = new ArrayList<>();
        xrzjnxLists = new ArrayList<>();
        xrzwccnxLists = new ArrayList<>();
        rxznxLists = new ArrayList<>();
        xbLists = new ArrayList<>();
        dpLists = new ArrayList<>();
        xrzwccLists = new ArrayList<>();
        xllxLists = new ArrayList<>();
        xrzjlxLists = new ArrayList<>();
    }

    public void clean(){
        search = "";
        cyssGd = "";
        cyssZwlx = "";
        cyssZwbqlx = "";
        gblxLists = new ArrayList<>();
        lxLists = new ArrayList<>();
        bmlxLists = new ArrayList<>();
        csnLists = new ArrayList<>();
        xrzjLists = new ArrayList<>();
        xlLists = new ArrayList<>();
        xxlxLists = new ArrayList<>();
        gzjlLists = new ArrayList<>();
        xrzjnxLists = new ArrayList<>();
        xrzwccnxLists = new ArrayList<>();
        rxznxLists = new ArrayList<>();
        xbLists = new ArrayList<>();
        dpLists = new ArrayList<>();
        xrzwccLists = new ArrayList<>();
        xllxLists = new ArrayList<>();
        xrzjlxLists = new ArrayList<>();
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setCyssGd(String cyssGd) {
        this.cyssGd = cyssGd;
    }

    public List<String> getGllbLists() {
        for (String str : gblxLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return gblxLists;
    }

    public List<String> getLxLists() {
        for (String str : lxLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return lxLists;
    }

    public String getGllbListsStr(){
        String string;
        if(getGllbLists().size() == 0){
            string = "";
        }else{
            StringBuffer str = new StringBuffer();
            for (String item : getGllbLists()){
                str.append(item + ",");
            }
            string = str.substring(0,str.length() - 1);
        }
        return string;
    }

    public String getCyssGd() {
        return cyssGd;
    }

    public void setGblxLists(List<String> gblxLists) {
        this.gblxLists = gblxLists;
    }

    public void setLxLists(List<String> lxLists) {
        this.lxLists = lxLists;
    }

    public List<String> getBmlbLists() {
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

    public List<String> getXrzjLists() {
        for (String str : xrzjLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return xrzjLists;
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

    public List<String> getXrzjlxLists(){
        for (String str : xrzjlxLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return xrzjlxLists;
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

    public String getXxlxListsStr(){
        String string;
        if(getXxlxLists().size() == 0){
            string = "";
        }else{
            StringBuffer str = new StringBuffer();
            for (String item : getXxlxLists()){
                str.append(item + ",");
            }
            string = str.substring(0,str.length() - 1);
        }
        return string;
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

    public String getGzjlListsStr(){
        String string;
        if(getGzjlLists().size() == 0){
            string = "";
        }else{
            StringBuffer str = new StringBuffer();
            for (String item : getGzjlLists()){
                str.append(item + ",");
            }
            string = str.substring(0,str.length() - 1);
        }
        return string;
    }

    public void setGzjlLists(List<String> gzjlLists) {
        this.gzjlLists = gzjlLists;
    }

    public List<String> getRxznxLists() {
        if(rxznxLists.size() == 0)
            return rxznxLists = new ArrayList<>();
        if(rxznxLists.get(0).equals("0") && rxznxLists.get(1).equals("20"))
            return rxznxLists = new ArrayList<>();
        return rxznxLists;
    }

    public List<String> getRxznxLists2() {
        if(rxznxLists.size() == 0)
            return new ArrayList<>();
        if(rxznxLists.get(0).equals("0") && rxznxLists.get(1).equals("20"))
            return new ArrayList<>();
        int min = getCurrentYear() - Integer.parseInt(rxznxLists.get(1));
        int max = getCurrentYear() - Integer.parseInt(rxznxLists.get(0));
        rxznxLists = new ArrayList<>();
        rxznxLists.add(min + "");
        rxznxLists.add(max + "");
        return rxznxLists;
    }

    public List<String> getXrzwccnxLists() {
        if(xrzwccnxLists.size() == 0)
            return xrzwccnxLists = new ArrayList<>();
        if(xrzwccnxLists.get(0).equals("0") && xrzwccnxLists.get(1).equals("20"))
            return xrzwccnxLists = new ArrayList<>();
        return xrzwccnxLists;
    }

    public List<String> getXrzwccnxLists2() {
        if(xrzwccnxLists.size() == 0)
            return new ArrayList<>();
        if(xrzwccnxLists.get(0).equals("0") && xrzwccnxLists.get(1).equals("20"))
            return new ArrayList<>();
        int min = getCurrentYear() - Integer.parseInt(xrzwccnxLists.get(1));
        int max = getCurrentYear() - Integer.parseInt(xrzwccnxLists.get(0));
        xrzwccnxLists = new ArrayList<>();
        xrzwccnxLists.add(min + "");
        xrzwccnxLists.add(max + "");
        return xrzwccnxLists;
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
//    public boolean isDpFzgdn(){
//        for (String str : dpLists)
//            if(str.equals("非中共党员"))
//                return true;
//            return false;
//    }

    public void setDpLists(List<String> dpLists) {
        this.dpLists = dpLists;
    }

    public List<String> getXrzwccLists() {
        for (String str : xrzwccLists)
            if(str.equals("全部"))
                return new ArrayList<>();
        return xrzwccLists;
    }

    public void setXrzwccLists(List<String> xrzwccLists) {
        this.xrzwccLists = xrzwccLists;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if(!TextUtils.isEmpty(getSearch())){
            sb.append("关键字：" + getSearch() + "/");
        }

        for (String str : getLxLists()){
            if(TextUtils.equals("4",str)){
                sb.append("事业干部/");
            }else if(TextUtils.equals("3",str)){
                sb.append("后备干部/");
            }else if(TextUtils.equals("2",str)){
                sb.append("职级公务员/");
            }else{
                sb.append("领导干部/");
            }
        }
        for (String str : getGllbLists()){
            sb.append(str + "/");
        }
        for (String str : getBmlbLists()){
            sb.append(str + "/");
        }
        if(getCsnLists().size() == 2){
            sb.append("出生年：" + getCsnLists().get(0) + " - " + getCsnLists().get(1) + "/");
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
            sb.append("任现职级年限：" + getXrzjnxLists().get(0) + " - " + getXrzjnxLists().get(1) + "/");
        }
        if(getXrzwccnxLists().size() == 2){
            sb.append("任现职务层次年限：" + getXrzwccnxLists().get(0) + " - " + getXrzwccnxLists().get(1) + "/");
        }
        if(getRxznxLists().size() == 2){
            sb.append("任现职年限：" + getRxznxLists().get(0) + " - " + getRxznxLists().get(1) + "/");
        }
        for (String str : getXbLists()){
            sb.append(str + "/");
        }
        for (String str : getDpLists()){
            sb.append(str + "/");
        }
        for (String str : getXrzwccLists()){
            sb.append(str + "/");
        }
        for (String str : getXrzjlxLists()){
            sb.append(str + "/");
        }
        for (String str : getXrzjLists()){
            sb.append(str + "/");
        }
        return sb.toString();
    }

    public String getCyssZwlx() {
        return cyssZwlx;
    }

    public void setCyssZwlx(String cyssZwlx) {
        this.cyssZwlx = cyssZwlx;
    }

    public String getCyssZwbqlx() {
        return cyssZwbqlx;
    }

    public void setCyssZwbqlx(String cyssZwbqlx) {
        this.cyssZwbqlx = cyssZwbqlx;
    }
}
