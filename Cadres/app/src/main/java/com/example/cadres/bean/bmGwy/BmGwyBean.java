package com.example.cadres.bean.bmGwy;

import java.util.List;

public class BmGwyBean {
    /**
     * meetRequirements (综合执法类)
     * zzbFGZLRankGridList(检察官/法官助理等级)
     * zzbJCGFGZLRankGridList(公安警务技术类)
     * zzbJCGFGRankGridList(检察官/法官等级)
     * zzbgwyorgList （公务员单位类别）
     * zzbGAZQRankGridList (公安执法勤务类)
     */

    List<GwyZHGL> zzbGwyRankGridList;//综合执法类
    List<GwyJWJS> zzbGAJSRankGridList;//公安警务技术类
    List<GwyFGZLDJ> zzbJCGFGZLRankGridList;//检察官/法官助理等级
    List<GwyFGDJ> zzbJCGFGRankGridList;//检察官/法官等级
    List<GwyZQ> zzbGAZQRankGridList;//公安执法勤务类
    List<GwyDWLB> zzbgwyorgList;//公务员单位类别

    public List<GwyZHGL> getZzbGwyRankGridList() {
        return zzbGwyRankGridList;
    }

    public List<GwyJWJS> getZzbGAJSRankGridList() {
        return zzbGAJSRankGridList;
    }

    public List<GwyFGZLDJ> getZzbJCGFGZLRankGridList() {
        return zzbJCGFGZLRankGridList;
    }

    public List<GwyFGDJ> getZzbJCGFGRankGridList() {
        return zzbJCGFGRankGridList;
    }

    public List<GwyZQ> getZzbGAZQRankGridList() {
        return zzbGAZQRankGridList;
    }

    public List<GwyDWLB> getZzbgwyorgList() {
        return zzbgwyorgList;
    }
}
