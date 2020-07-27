package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBBmOrgTypeBean {

    /**
     * searchValue : null
     * createBy : admin
     * createTime : 2020-05-27 17:45:56
     * updateBy : null
     * updateTime : null
     * remark :
     * deptCode : null
     * params : {}
     * dictCode : 86
     * dictSort : 1
     * dictLabel : 党委
     * dictValue : 1
     * dictType : zzb_org_type
     * cssClass :
     * listClass :
     * isDefault : Y
     * status : 0
     * default : true
     */

    @Id(autoincrement = true)
    private Long _id;
    private String dictLabel;
    private String dictValue;

    @Generated(hash = 344804225)
    public DBBmOrgTypeBean(Long _id, String dictLabel, String dictValue) {
        this._id = _id;
        this.dictLabel = dictLabel;
        this.dictValue = dictValue;
    }

    @Generated(hash = 156688831)
    public DBBmOrgTypeBean() {
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
}
