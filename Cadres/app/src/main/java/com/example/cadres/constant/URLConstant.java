package com.example.cadres.constant;

/**
 * Created by LGQ
 * Time: 2018/7/17
 * Function: url常量
 */

public class URLConstant {

    public static final String BASE_URL = getUrl();//本地

    public static String getUrl(){

        return "http://2r12l01488.iask.in:80";
//            return "http://192.168.100.220:8099";

//        if(AppUtils.getVersionCodeInt() % 100 == 0){
//            return "http://2r12l01488.iask.in:25445";
////            return "http://192.168.100.101:8099";
////            return "http://192.168.100.220:8099";
//        }else{
//            return "http://2r12l01488.iask.in:25445";
////            return "http://192.168.100.101:8099";
////            return "http://192.168.100.220:8099";
//
//        }
    }
}
