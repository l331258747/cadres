package com.example.cadres.bean.zcfg;

import android.text.TextUtils;

import java.util.List;

public class ZcfgBean {

    List<ZcfgBean2> zzbNotice;
    List<ZcfgNoticeTypeBean> noticeType;

    public List<ZcfgNoticeTypeBean> getNoticeType() {
        return noticeType;
    }

    public List<ZcfgBean2> getZzbNotice() {
        return zzbNotice;
    }


}
