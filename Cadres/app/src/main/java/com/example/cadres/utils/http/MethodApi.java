package com.example.cadres.utils.http;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by LGQ
 * Time: 2018/7/18
 * Function:
 */

public class MethodApi {

    public static void findUserInfo(int userId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().findUserInfo(userId); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void login(String username,String password,DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().login(username,password); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

}
