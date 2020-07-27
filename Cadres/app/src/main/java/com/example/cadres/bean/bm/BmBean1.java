package com.example.cadres.bean.bm;

import java.util.List;

public class BmBean1 {
    List<BmBean2> zzbOrganization;
    List<BmOrgTypeBean> orgType;
    List<BmFinanceTypeBean> financeType;

    public List<BmBean2> getZzbOrganization() {
        return zzbOrganization;
    }

    public List<BmOrgTypeBean> getOrgType() {
        return orgType;
    }

    public List<BmFinanceTypeBean> getFinanceType() {
        return financeType;
    }
}