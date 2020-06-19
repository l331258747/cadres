package com.example.cadres.bean.login;

public class LoginBean {

    private LoginBean2 zzbUser;

    public LoginBean2 getZzbUser() {
        return zzbUser;
    }

    public class LoginBean2 {
        int userId;
        int deptId;//部门id
        String loginName;
        String password;
        String salt;
        String userName;

        public int getUserId() {
            return userId;
        }


        public int getDeptId() {
            return deptId;
        }


        public String getLoginName() {
            return loginName;
        }


        public String getPassword() {
            return password;
        }


        public String getSalt() {
            return salt;
        }

        public String getUserName() {
            return userName;
        }
    }

}
