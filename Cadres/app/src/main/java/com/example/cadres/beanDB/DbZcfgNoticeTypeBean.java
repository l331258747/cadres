package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbZcfgNoticeTypeBean {

    @Id(autoincrement = true)
    private Long _id;
    String dictLabel;
    String dictValue;

    @Generated(hash = 326992905)
    public DbZcfgNoticeTypeBean(Long _id, String dictLabel, String dictValue) {
        this._id = _id;
        this.dictLabel = dictLabel;
        this.dictValue = dictValue;
    }

    @Generated(hash = 790672959)
    public DbZcfgNoticeTypeBean() {
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
