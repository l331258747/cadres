package com.example.cadres.beanDB;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBUserListBean {


    /**
     * userId : 1
     * deptId : 100
     * loginName : admin
     * password : 23730b4c5014180a84417fdb91eb9553
     * salt : ed0db1
     */

    @Id(autoincrement = true)
    private Long _id;
    private int userId;
    private int deptId;
    private String loginName;
    private String password;
    private String salt;
    @Generated(hash = 1065844702)
    public DBUserListBean(Long _id, int userId, int deptId, String loginName,
            String password, String salt) {
        this._id = _id;
        this.userId = userId;
        this.deptId = deptId;
        this.loginName = loginName;
        this.password = password;
        this.salt = salt;
    }
    @Generated(hash = 16442289)
    public DBUserListBean() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getDeptId() {
        return this.deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public String getLoginName() {
        return this.loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return this.salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

}