package com.example.cadres.bean.login;

import com.example.cadres.utils.SPUtils;

/**
 * Created by LGQ
 * Time: 2018/8/24
 * Function:
 */

public class MySelfInfo {

    private MySelfInfo() {
    }

    private final static class HolderClass {
        private final static MySelfInfo INSTANCE = new MySelfInfo();
    }

    public static MySelfInfo getInstance() {
        return HolderClass.INSTANCE;
    }

    public void setData(LoginBean.LoginBean2 model) {

        SPUtils.getInstance().putInt(SPUtils.SP_USER_ID, model.getUserId());
        SPUtils.getInstance().putInt(SPUtils.SP_DEPT_ID, model.getDeptId());
        SPUtils.getInstance().putString(SPUtils.SP_LOGIN_NAME, model.getLoginName());
        SPUtils.getInstance().putString(SPUtils.SP_PASSWORD, model.getPassword());
        SPUtils.getInstance().putString(SPUtils.SP_SALT, model.getSalt());
        SPUtils.getInstance().putString(SPUtils.SP_USER_NAME, model.getUserName());
    }

    public int getUserId() {
        return SPUtils.getInstance().getInt(SPUtils.SP_USER_ID);
    }

    public int getDeptId() {
        return SPUtils.getInstance().getInt(SPUtils.SP_DEPT_ID);
    }

    public String getLoginName() {
        return SPUtils.getInstance().getString(SPUtils.SP_LOGIN_NAME);
    }

    public String getPassword() {
        return SPUtils.getInstance().getString(SPUtils.SP_PASSWORD);
    }

    public String getSalt() {
        return SPUtils.getInstance().getString(SPUtils.SP_SALT);
    }

    public String getUserName() {
        return SPUtils.getInstance().getString(SPUtils.SP_USER_NAME);
    }

}
