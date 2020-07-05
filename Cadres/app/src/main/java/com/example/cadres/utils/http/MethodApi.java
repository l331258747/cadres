package com.example.cadres.utils.http;

import java.util.Map;

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

    //获取政策法规列表
    public static void getZcfgList(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getZcfgList(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取 职务名册/部门 列表
    public static void getbmList(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getbmList(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取 干部 列表
    public static void getGbList(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getGbList(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取 研究决策 列表
    public static void getYjjcList(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getYjjcList(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取 研究票决验证 列表
    public static void getYjjcVoteCheck(int schemeId,int voteUserId,DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getYjjcVoteCheck(schemeId,voteUserId); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }


    //获取 研究票决列表
    public static void getYjjcVoteList(int schemeId,int voteUserId,DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getYjjcVoteList(schemeId,voteUserId); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取 研究票决
    public static void sendYjjcVote(Map<String, String> params, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().sendYjjcVote(params); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取 file
    public static void getFiles(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getFiles(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }
}
