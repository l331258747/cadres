package com.example.cadres.utils.http;


import com.example.cadres.bean.BaseResponse;
import com.example.cadres.bean.UserListBean;
import com.example.cadres.bean.login.LoginBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by LGQ
 * Time: 2018/7/17
 * Function: 请求
 */

public interface HttpService {

    @Multipart
    @POST("user/findUserList")
    Observable<BaseResponse<LoginBean>> findUserInfo(@Part("userid") int userid);

    @Multipart
    @POST("auth/login")
    Observable<BaseResponse<LoginBean>> login(@Part("username") String username,
                                              @Part("password") String password);



}
