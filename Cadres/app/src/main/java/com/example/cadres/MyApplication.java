package com.example.cadres;

import android.app.Application;
import android.content.Context;

import com.example.cadres.utils.AppUtils;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.SPUtils;
import com.example.cadres.utils.greendao.DaoManager;

/**
 * Created by LGQ
 * Time: 2018/7/17
 * Function:
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    private static Context context;

    /**
     * 屏幕尺寸
     */
    public static int displayWidth = 0;
    public static int displayHeight = 0;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        context = getApplicationContext();

        if (displayWidth <= 0) {
            displayWidth = getResources().getDisplayMetrics().widthPixels;
        }

        if (displayHeight <= 0) {
            displayHeight = getResources().getDisplayMetrics().heightPixels;
        }

        SPUtils.init(context);
        AppUtils.init(this);
        LogUtil.setShowLog(true);

        initGreenDao();

    }

    private void initGreenDao() {
        DaoManager mManager = DaoManager.getInstance();
        mManager.init(this);
    }

}
