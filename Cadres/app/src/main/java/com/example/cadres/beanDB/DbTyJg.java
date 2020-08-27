package com.example.cadres.beanDB;

import android.text.TextUtils;

import com.example.cadres.bean.ChartBean;
import com.example.cadres.utils.GsonUtil;
import com.example.cadres.utils.LogUtil;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DbTyJg {

    @Id(autoincrement = true)
    private Long _id;
    private int deptId;
    private String sexList;
    private String nationList;
    private String outlookList;
    private String ageList;
    private String educationList;
    private String majorList;
    private boolean isGwy;

    @Generated(hash = 739774376)
    public DbTyJg(Long _id, int deptId, String sexList, String nationList, String outlookList, String ageList,
            String educationList, String majorList, boolean isGwy) {
        this._id = _id;
        this.deptId = deptId;
        this.sexList = sexList;
        this.nationList = nationList;
        this.outlookList = outlookList;
        this.ageList = ageList;
        this.educationList = educationList;
        this.majorList = majorList;
        this.isGwy = isGwy;
    }

    @Generated(hash = 48086157)
    public DbTyJg() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public int getDeptId() {
        return this.deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getSexList() {
        return this.sexList;
    }

    public void setSexList(String sexList) {
        this.sexList = sexList;
    }

    public String getNationList() {
        return this.nationList;
    }

    public void setNationList(String nationList) {
        this.nationList = nationList;
    }

    public String getOutlookList() {
        return this.outlookList;
    }

    public void setOutlookList(String outlookList) {
        this.outlookList = outlookList;
    }

    public String getAgeList() {
        return this.ageList;
    }

    public void setAgeList(String ageList) {
        this.ageList = ageList;
    }


    private List<ChartBean> getChartBeanSex() {
        List<ChartBean> list = GsonUtil.convertString2Collection(sexList, new TypeToken<List<ChartBean>>() {
        });
        if (list == null) return new ArrayList<>();
        if(list.size() == 1){
            if(TextUtils.equals(list.get(0).getName(),"男")){
                list.add( new ChartBean("女",0));
            }else{
                int count = list.get(0).getAmount();
                list = new ArrayList<>();
                list.add(new ChartBean("男",0));
                list.add(new ChartBean("女",count));
            }
        }
        return list;
    }

    private int getSexCount() {
        if (getChartBeanSex().size() != 2)
            return 0;
        int count = getChartBeanSex().get(0).getAmount() + getChartBeanSex().get(1).getAmount();
        LogUtil.e("sex count: " + count);
        return count;
    }

    public String getSexNan() {
        if (getChartBeanSex().size() != 2) return "0%";
        if(getChartBeanSex().get(0).getAmount() == 0) return "0%";
        float num = Float.valueOf(getChartBeanSex().get(0).getAmount()) / getSexCount() * 100;
        return (int) num + "%";
    }

    public String getSexNv() {
        if (getChartBeanSex().size() != 2) return "0%";
        if(getChartBeanSex().get(1).getAmount() == 0) return "0%";
        float num = Float.valueOf(getChartBeanSex().get(1).getAmount()) / getSexCount() * 100;
        return (int) num + "%";
    }

    // 这里把0的数据去除，是因为画图的时候，MyPieChartRenderer2里面会计算0 label的距离，导致偏差
    public List<ChartBean> getChartBeanNation() {
        List<ChartBean> list = GsonUtil.convertString2Collection(nationList, new TypeToken<List<ChartBean>>() {
        });
        if (list == null) return new ArrayList<>();
        List<ChartBean> list2 = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getAmount() > 0)
                list2.add(list.get(i));
        }
        return list2;
    }

    public List<ChartBean> getChartBeanOutlookList() {
        List<ChartBean> list = GsonUtil.convertString2Collection(outlookList, new TypeToken<List<ChartBean>>() {
        });
        if (list == null) return new ArrayList<>();

        List<ChartBean> list2 = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getAmount() > 0)
                list2.add(list.get(i));
        }
        return list2;
    }

    public List<ChartBean> getChartBeanAgeList() {
        List<ChartBean> list = GsonUtil.convertString2Collection(ageList, new TypeToken<List<ChartBean>>() {
        });
        if (list == null) return new ArrayList<>();
        List<ChartBean> list2 = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getAmount() > 0)
                list2.add(list.get(i));
        }
        return list2;
    }

    public String getEducationList() {
        return this.educationList;
    }

    public void setEducationList(String educationList) {
        this.educationList = educationList;
    }

    public String getMajorList() {
        return this.majorList;
    }

    public void setMajorList(String majorList) {
        this.majorList = majorList;
    }

    public List<ChartBean> getChartBeanEducationList() {
        List<ChartBean> list = GsonUtil.convertString2Collection(educationList, new TypeToken<List<ChartBean>>() {
        });
        if (list == null) return new ArrayList<>();
        List<ChartBean> list2 = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getNum() > 0)
                list2.add(list.get(i));
        }
        return list2;
    }

    public List<ChartBean> getChartBeanMajorList() {
        List<ChartBean> list = GsonUtil.convertString2Collection(majorList, new TypeToken<List<ChartBean>>() {
        });
        if (list == null) return new ArrayList<>();
        List<ChartBean> list2 = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getNum() > 0)
                list2.add(list.get(i));
        }
        return list2;
    }

    public boolean getIsGwy() {
        return this.isGwy;
    }

    public void setIsGwy(boolean isGwy) {
        this.isGwy = isGwy;
    }
}
