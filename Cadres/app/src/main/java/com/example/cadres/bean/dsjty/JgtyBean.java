package com.example.cadres.bean.dsjty;

import com.example.cadres.utils.GsonUtil;

import java.util.List;

public class JgtyBean {

    List<jgtyBean2> orgdeductionList;


    public List<jgtyBean2> getOrgdeductionList() {
        return orgdeductionList;
    }

    public static class jgtyBean2 {


        /**
         * deptId : 205
         * sexList : [{"name":"男","amount":4},{"name":"女","amount":1}]
         * nationList : [{"name":"汉族","amount":4},{"name":"少数民族","amount":1}]
         * outlookList : [{"name":"中共党员","amount":4},{"name":"非中共党员","amount":1}]
         * ageList : [{"name":"34岁以下","amount":1},{"name":"35岁-39岁","amount":1},{"name":"40岁-44岁","amount":1},{"name":"45岁-49岁","amount":0},{"name":"50岁-54岁","amount":0},{"name":"55岁以上","amount":2}]
         */

        private int deptId;
        private List<RankAgeList> sexList;
        private List<RankAgeList> nationList;
        private List<RankAgeList> outlookList;
        private List<RankAgeList> ageList;
        private List<RankAgeList> educationList;
        private List<RankAgeList> majorList;

        public List<RankAgeList> getEducationList() {
            return educationList;
        }

        public String getEducationListStr() {
            if (educationList == null) return "";
            return GsonUtil.convertVO2String(educationList);
        }

        public List<RankAgeList> getMajorList() {
            return majorList;
        }

        public String getMajorListStr() {
            if (majorList == null) return "";
            return GsonUtil.convertVO2String(majorList);
        }

        public int getDeptId() {
            return deptId;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public List<RankAgeList> getSexList() {
            return sexList;
        }

        public String getSexListStr() {
            if (sexList == null) return "";
            return GsonUtil.convertVO2String(sexList);
        }

        public void setSexList(List<RankAgeList> sexList) {
            this.sexList = sexList;
        }

        public List<RankAgeList> getNationList() {
            return nationList;
        }

        public String getNationListStr() {
            if (nationList == null) return "";
            return GsonUtil.convertVO2String(nationList);
        }

        public void setNationList(List<RankAgeList> nationList) {
            this.nationList = nationList;
        }

        public List<RankAgeList> getOutlookList() {
            return outlookList;
        }

        public String getOutlookListStr() {
            if (outlookList == null) return "";
            return GsonUtil.convertVO2String(outlookList);
        }

        public void setOutlookList(List<RankAgeList> outlookList) {
            this.outlookList = outlookList;
        }

        public List<RankAgeList> getAgeList() {
            return ageList;
        }

        public String getAgeListStr() {
            if (ageList == null) return "";
            return GsonUtil.convertVO2String(ageList);
        }

        public void setAgeList(List<RankAgeList> ageList) {
            this.ageList = ageList;
        }

    }
}
