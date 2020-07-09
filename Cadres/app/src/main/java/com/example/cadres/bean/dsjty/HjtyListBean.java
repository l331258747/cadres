package com.example.cadres.bean.dsjty;

import com.example.cadres.utils.GsonUtil;

import java.util.List;

public class HjtyListBean {

    HjtyListBean2 meetRequirements;

    public HjtyListBean2 getMeetRequirements() {
        return meetRequirements;
    }

    public static class HjtyListBean2{
        List<Integer> scw;
        List<Integer> szf;
        List<Integer> srd;
        List<Integer> szx;

        public List<Integer> getScw() {
            return scw;
        }

        public String getScwStr() {
            if(scw == null) return "";
            return GsonUtil.convertVO2String(scw);
        }

        public List<Integer> getSzf() {
            return szf;
        }

        public String getSzfStr() {
            if(szf == null) return "";
            return GsonUtil.convertVO2String(szf);
        }

        public List<Integer> getSrd() {
            return srd;
        }

        public String getSrdStr() {
            if(srd == null) return "";
            return GsonUtil.convertVO2String(srd);
        }

        public List<Integer> getSzx() {
            return szx;
        }

        public String getSzxStr() {
            if(szx == null) return "";
            return GsonUtil.convertVO2String(szx);
        }

    }
}
