package com.example.cadres.utils.http;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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

    //获取 任免决策 列表
    public static void getYjjcList(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getYjjcList(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取 任免决策 票决验证 列表
    public static void getYjjcVoteCheck(int schemeId,int voteUserId,DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getYjjcVoteCheck(schemeId,voteUserId); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }


    //获取 任免决策 票决列表
    public static void getYjjcVoteList(int schemeId,int voteUserId,DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getYjjcVoteList(schemeId,voteUserId); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取 任免决策票决
    public static void sendYjjcVote(Map<String, String> params, DisposableObserver subscriber) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type, application/json"),
                new JSONObject(params).toString());

        Observable observable = HttpMethods.getInstance().getHttpService().sendYjjcVote(requestBody); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取 file
    public static void getFiles(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getFiles(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取结构推演 file
    public static void getJgty(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getJgty(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取职级推演 file
    public static void getZsty(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getZsty(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取换届推演 file
    public static void getHjty(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getHjty(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取换届推演列表 file
    public static void getHjtyList(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getHjtyList(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //获取apk
    public static void getApk(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getApk(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //search 数据
    public static void getSearchData(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getSearchData(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }
}
