package com.example.cadres.utils.http;


import com.example.cadres.bean.BaseResponse;
import com.example.cadres.bean.EmptyModel;
import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.bean.apk.ApkBean;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.bean.dsjty.HjtyBean;
import com.example.cadres.bean.dsjty.HjtyListBean;
import com.example.cadres.bean.dsjty.JgtyBean;
import com.example.cadres.bean.dsjty.ZstyBean;
import com.example.cadres.bean.file.FileBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.bean.yjjc.YjjcVoteCheckBean;
import com.example.cadres.bean.yjjc.YjjcVoteListBean;
import com.example.cadres.bean.yjjc.YjjcVoteListParent;
import com.example.cadres.bean.zcfg.ZcfgBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    @POST("organization/findOrganizationList")
    Observable<BaseResponse<BmBean>> getbmList();

    @GET("cadreBase/findCadreBaseList")
    Observable<BaseResponse<GbBean>> getGbList();

    @GET("appointDismissScheme/findAppointDismissSchemeList")
    Observable<BaseResponse<YjjcBean>> getYjjcList();

    @GET("appointDismissScheme/checkIsVote")
    Observable<BaseResponse<YjjcVoteCheckBean>> getYjjcVoteCheck(@Query("schemeId") int schemeId,
                                                                 @Query("voteUserId") int voteUserId);

    @GET("appointDismissScheme/findAppointDismissVoteList")
    Observable<BaseResponse<YjjcVoteListParent>> getYjjcVoteList(@Query("schemeId") int schemeId,
                                                                 @Query("voteUserId") int voteUserId);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("appointDismissScheme/appointDismissVoteAdd")
    Observable<BaseResponse<EmptyModel>> sendYjjcVote(@Body RequestBody body);

    @GET("fileUrl/findFileUrlList")
    Observable<BaseResponse<FileBean>> getFiles();

    @POST("deduction/orgdeductionList")
    Observable<BaseResponse<JgtyBean>> getJgty();

    @POST("rank/rankDeuctionList")
    Observable<BaseResponse<ZstyBean>> getZsty();

    @POST("newTerm/newTermDedectionList")
    Observable<BaseResponse<HjtyBean>> getHjty();

    @POST("newTerm/meetRequirementsData")
    Observable<BaseResponse<HjtyListBean>> getHjtyList();

    @POST("appstore/selectNewAppVersion")
    Observable<BaseResponse<ApkBean>> getApk();


}
