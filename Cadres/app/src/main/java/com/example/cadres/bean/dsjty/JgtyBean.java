package com.example.cadres.bean.dsjty;

import com.example.cadres.utils.GsonUtil;

import java.util.List;

public class JgtyBean {

    List<jgtyBean2> orgdeductionList;


    public List<jgtyBean2> getOrgdeductionList() {
        return orgdeductionList;
    }

    public static class jgtyBean2{


        /**
         * deptId : 205
         * sexList : [{"name":"男","amount":4},{"name":"女","amount":1}]
         * nationList : [{"name":"汉族","amount":4},{"name":"少数民族","amount":1}]
         * outlookList : [{"name":"中共党员","amount":4},{"name":"非中共党员","amount":1}]
         * ageList : [{"name":"34岁以下","amount":1},{"name":"35岁-39岁","amount":1},{"name":"40岁-44岁","amount":1},{"name":"45岁-49岁","amount":0},{"name":"50岁-54岁","amount":0},{"name":"55岁以上","amount":2}]
         */

        private int deptId;
        private List<SexListBean> sexList;
        private List<NationListBean> nationList;
        private List<OutlookListBean> outlookList;
        private List<AgeListBean> ageList;

        public int getDeptId() {
            return deptId;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public List<SexListBean> getSexList() {
            return sexList;
        }

        public String getSexListStr() {
            if(sexList == null) return "";
            return GsonUtil.convertVO2String(sexList);
        }

        public void setSexList(List<SexListBean> sexList) {
            this.sexList = sexList;
        }

        public List<NationListBean> getNationList() {
            return nationList;
        }

        public String getNationListStr() {
            if(nationList == null) return "";
            return GsonUtil.convertVO2String(nationList);
        }

        public void setNationList(List<NationListBean> nationList) {
            this.nationList = nationList;
        }

        public List<OutlookListBean> getOutlookList() {
            return outlookList;
        }

        public String getOutlookListStr() {
            if(outlookList == null) return "";
            return GsonUtil.convertVO2String(outlookList);
        }

        public void setOutlookList(List<OutlookListBean> outlookList) {
            this.outlookList = outlookList;
        }

        public List<AgeListBean> getAgeList() {
            return ageList;
        }

        public String getAgeListStr() {
            if(ageList == null) return "";
            return GsonUtil.convertVO2String(ageList);
        }

        public void setAgeList(List<AgeListBean> ageList) {
            this.ageList = ageList;
        }

        public static class SexListBean {
            /**
             * name : 男
             * amount : 4
             */

            private String name;
            private int amount;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }
        }

        public static class NationListBean {
            /**
             * name : 汉族
             * amount : 4
             */

            private String name;
            private int amount;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }
        }

        public static class OutlookListBean {
            /**
             * name : 中共党员
             * amount : 4
             */

            private String name;
            private int amount;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }
        }

        public static class AgeListBean {
            /**
             * name : 34岁以下
             * amount : 1
             */

            private String name;
            private int amount;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }
        }
    }

}
