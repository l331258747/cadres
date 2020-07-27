package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBBmFinanceTypeBean {

    @Id(autoincrement = true)
    private Long _id;
    String dictValue;
    String dictLabel;

    @Generated(hash = 1800034289)
    public DBBmFinanceTypeBean(Long _id, String dictValue, String dictLabel) {
        this._id = _id;
        this.dictValue = dictValue;
        this.dictLabel = dictLabel;
    }

    @Generated(hash = 2120221072)
    public DBBmFinanceTypeBean() {
    }

    public String getDictValue() {
        return dictValue;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }
}
