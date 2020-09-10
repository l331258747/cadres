package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGwyDWLB {

    /**
     * searchValue : null
     * createBy : admin
     * createTime : 2020-05-27 15:05:30
     * updateBy : null
     * updateTime : null
     * remark :
     * deptCode : null
     * params : {}
     * dictCode : 360
     * dictSort : 1
     * dictLabel : 市直部门
     * dictValue : 1
     * dictType : zzb_gwy_org
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

    @Generated(hash = 732319910)
    public DBGwyDWLB(Long _id, String dictLabel, String dictValue) {
        this._id = _id;
        this.dictLabel = dictLabel;
        this.dictValue = dictValue;
    }

    @Generated(hash = 1556288737)
    public DBGwyDWLB() {
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
