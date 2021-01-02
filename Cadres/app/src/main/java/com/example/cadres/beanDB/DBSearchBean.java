package com.example.cadres.beanDB;

import com.example.cadres.bean.ChartBean;
import com.example.cadres.bean.search.SysDictDataBean;
import com.example.cadres.bean.search.ZzbFunctionaryRankBean;
import com.example.cadres.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBSearchBean {
    @Id(autoincrement = true)
    private Long _id;
    
    private String cadreTypes;
    private String orgTypes;
    private String currenRankTypes;
    private String educationTypes;
    private String schoolTypes;
    private String workExperienceTypes;
    private String politicalOutlookTypes;
    private String userSexTypes;
    private String functionaryRankParentTypes;
    private String functionaryRankTypes;
    private String oftenSearchPostTypes;
    private String oftenSearchPostLabelTypes;
    @Generated(hash = 637132770)
    public DBSearchBean(Long _id, String cadreTypes, String orgTypes,
            String currenRankTypes, String educationTypes, String schoolTypes,
            String workExperienceTypes, String politicalOutlookTypes,
            String userSexTypes, String functionaryRankParentTypes,
            String functionaryRankTypes, String oftenSearchPostTypes,
            String oftenSearchPostLabelTypes) {
        this._id = _id;
        this.cadreTypes = cadreTypes;
        this.orgTypes = orgTypes;
        this.currenRankTypes = currenRankTypes;
        this.educationTypes = educationTypes;
        this.schoolTypes = schoolTypes;
        this.workExperienceTypes = workExperienceTypes;
        this.politicalOutlookTypes = politicalOutlookTypes;
        this.userSexTypes = userSexTypes;
        this.functionaryRankParentTypes = functionaryRankParentTypes;
        this.functionaryRankTypes = functionaryRankTypes;
        this.oftenSearchPostTypes = oftenSearchPostTypes;
        this.oftenSearchPostLabelTypes = oftenSearchPostLabelTypes;
    }
    @Generated(hash = 780196836)
    public DBSearchBean() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getCadreTypes() {
        return this.cadreTypes;
    }
    public void setCadreTypes(String cadreTypes) {
        this.cadreTypes = cadreTypes;
    }
    public String getOrgTypes() {
        return this.orgTypes;
    }
    public void setOrgTypes(String orgTypes) {
        this.orgTypes = orgTypes;
    }
    public String getCurrenRankTypes() {
        return this.currenRankTypes;
    }
    public void setCurrenRankTypes(String currenRankTypes) {
        this.currenRankTypes = currenRankTypes;
    }
    public String getEducationTypes() {
        return this.educationTypes;
    }
    public void setEducationTypes(String educationTypes) {
        this.educationTypes = educationTypes;
    }
    public String getSchoolTypes() {
        return this.schoolTypes;
    }
    public void setSchoolTypes(String schoolTypes) {
        this.schoolTypes = schoolTypes;
    }
    public String getWorkExperienceTypes() {
        return this.workExperienceTypes;
    }
    public void setWorkExperienceTypes(String workExperienceTypes) {
        this.workExperienceTypes = workExperienceTypes;
    }
    public String getPoliticalOutlookTypes() {
        return this.politicalOutlookTypes;
    }
    public void setPoliticalOutlookTypes(String politicalOutlookTypes) {
        this.politicalOutlookTypes = politicalOutlookTypes;
    }
    public String getUserSexTypes() {
        return this.userSexTypes;
    }
    public void setUserSexTypes(String userSexTypes) {
        this.userSexTypes = userSexTypes;
    }
    public String getFunctionaryRankParentTypes() {
        return this.functionaryRankParentTypes;
    }
    public void setFunctionaryRankParentTypes(String functionaryRankParentTypes) {
        this.functionaryRankParentTypes = functionaryRankParentTypes;
    }
    public String getFunctionaryRankTypes() {
        return this.functionaryRankTypes;
    }
    public void setFunctionaryRankTypes(String functionaryRankTypes) {
        this.functionaryRankTypes = functionaryRankTypes;
    }
    public String getOftenSearchPostTypes() {
        return this.oftenSearchPostTypes;
    }
    public void setOftenSearchPostTypes(String oftenSearchPostTypes) {
        this.oftenSearchPostTypes = oftenSearchPostTypes;
    }
    public String getOftenSearchPostLabelTypes() {
        return this.oftenSearchPostLabelTypes;
    }
    public void setOftenSearchPostLabelTypes(String oftenSearchPostLabelTypes) {
        this.oftenSearchPostLabelTypes = oftenSearchPostLabelTypes;
    }

    public List<SysDictDataBean> getCadreTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(cadreTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<SysDictDataBean> getOrgTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(orgTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<SysDictDataBean> getCurrenRankTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(currenRankTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<SysDictDataBean> getEducationTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(educationTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }

    public List<SysDictDataBean> getLxList(){
        List<SysDictDataBean> list = new ArrayList<>();
        SysDictDataBean item0 = new SysDictDataBean();
        item0.setDictLabel("全部");
        item0.setDictValue("全部");
        SysDictDataBean item1 = new SysDictDataBean();
        item1.setDictLabel("领导干部");
        item1.setDictValue("1");
        SysDictDataBean item2 = new SysDictDataBean();
        item2.setDictLabel("职级公务员");
        item2.setDictValue("2");
        SysDictDataBean item3 = new SysDictDataBean();
        item3.setDictLabel("后备干部");
        item3.setDictValue("3");
        SysDictDataBean item4 = new SysDictDataBean();
        item4.setDictLabel("事业干部");
        item4.setDictValue("4");
        list.add(item0);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        return list;
    }


    public List<SysDictDataBean> getSchoolTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(schoolTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<SysDictDataBean> getWorkExperienceTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(workExperienceTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<SysDictDataBean> getPoliticalOutlookTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(politicalOutlookTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<SysDictDataBean> getUserSexTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(userSexTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<ZzbFunctionaryRankBean> getFunctionaryRankParentTypesList(){
        List<ZzbFunctionaryRankBean> list = GsonUtil.convertString2Collection(functionaryRankParentTypes, new TypeToken<List<ZzbFunctionaryRankBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<ZzbFunctionaryRankBean> getFunctionaryRankTypesList(){
        List<ZzbFunctionaryRankBean> list = GsonUtil.convertString2Collection(functionaryRankTypes, new TypeToken<List<ZzbFunctionaryRankBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<SysDictDataBean> getOftenSearchPostTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(oftenSearchPostTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }
    public List<SysDictDataBean> getOftenSearchPostLabelTypesList(){
        List<SysDictDataBean> list = GsonUtil.convertString2Collection(oftenSearchPostLabelTypes, new TypeToken<List<SysDictDataBean>>() {
        });
        if (list == null) return new ArrayList<>();
        return list;
    }

    public List<SysDictDataBean> getCyssGdList(){
        List<SysDictDataBean> list = new ArrayList<>();
        SysDictDataBean item0 = new SysDictDataBean();
        SysDictDataBean item1 = new SysDictDataBean();
        SysDictDataBean item2 = new SysDictDataBean();
        SysDictDataBean item3 = new SysDictDataBean();
        item0.setDictLabel("90后干部");
        item1.setDictLabel("35岁及以下年轻干部");
        item2.setDictLabel("党外干部");
        item3.setDictLabel("未满服务年限公务员");
        list.add(item0);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        return list;
    }

}
