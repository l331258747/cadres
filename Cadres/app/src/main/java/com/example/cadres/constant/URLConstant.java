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
            return "正式环境";//TODO
        }else{
            return "测试环境";

        }
    }
}
