package com.example.cadres.bean;

public class UserListBean {


    /**
     * userId : 1
     * deptId : 100
     * loginName : admin
     * password : 23730b4c5014180a84417fdb91eb9553
     * salt : ed0db1
     */

    private int userId;
    private int deptId;
    private String loginName;
    private String password;
    private String salt;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
