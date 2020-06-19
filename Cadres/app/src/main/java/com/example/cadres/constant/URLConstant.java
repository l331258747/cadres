package com.example.cadres.constant;

import com.example.cadres.utils.AppUtils;

/**
 * Created by LGQ
 * Time: 2018/7/17
 * Function: url常量
 */

public class URLConstant {

    public static final String BASE_URL = getUrl();//本地

    public static String getUrl(){
        if(AppUtils.getVersionCodeInt() % 100 == 0){
            return "http://192.168.100.101:8099";//TODO
        }else{
            return "http://192.168.100.101:8099";

        }
    }
}
