package com.example.cadres.utils.http;


import com.example.cadres.bean.BaseResponse;
import com.example.cadres.bean.UserListBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.zcfg.ZcfgBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by LGQ
 * Time: 2018/7/17
 * Function: 请求
 */

public interface HttpService {

    @FormUrlEncoded
    @POST("user/findUserList")
    Observable<BaseResponse<LoginBean>> findUserInfo(@Field("userid") int userid);

    @FormUrlEncoded
    @POST("auth/login")
    Observable<BaseResponse<LoginBean>> login(@Field("username") String username,
                                              @Field("password") String password);


    @POST("zzbNotice/zzbNoticeList")
    Observable<BaseResponse<ZcfgBean>> getZcfgList();

}
