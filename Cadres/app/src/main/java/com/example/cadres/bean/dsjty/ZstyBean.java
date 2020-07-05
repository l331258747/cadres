package com.example.cadres.bean.dsjty;

import com.example.cadres.utils.GsonUtil;

import java.util.List;

public class ZstyBean {

    List<ZstyBean2> rankDeductionList;

    public List<ZstyBean2> getRankDeductionList() {
        return rankDeductionList;
    }

    public static class ZstyBean2{

        /**
         * deptid : 205
         * rankAgeList : [{"name":"2019","num":0},{"name":"2020","num":1},{"name":"2021","num":1},{"name":"2022","num":0},{"name":"2023","num":0}]
         * overmatch : {"name":"超配数","num":1}
         * parallel : {"name":"职务与职级并行(人)","num":4}
         * vacancy : {"name":"可用空缺职位数(人)","num":5}
         * toVacancy : {"name":"调整到空缺职位","num":7}
         */

        private int deptid;
        private OvermatchBean overmatch;
        private ParallelBean parallel;
        private VacancyBean vacancy;
        private ToVacancyBean toVacancy;
        private List<RankAgeListBean> rankAgeList;

        public int getDeptid() {
            return deptid;
        }

        public void setDeptid(int deptid) {
            this.deptid = deptid;
        }

        public OvermatchBean getOvermatch() {
            return overmatch;
        }

        public int getOvermatchInt() {
            if(overmatch == null) return 0;
            return overmatch.getNum();
        }

        public void setOvermatch(OvermatchBean overmatch) {
            this.overmatch = overmatch;
        }

        public ParallelBean getParallel() {
            return parallel;
        }

        public int getParallelInt() {
            if(parallel == null) return 0;
            return parallel.getNum();
        }

        public void setParallel(ParallelBean parallel) {
            this.parallel = parallel;
        }

        public VacancyBean getVacancy() {
            return vacancy;
        }

        public int getVacancyInt() {
            if(vacancy == null) return 0;
            return vacancy.getNum();
        }

        public void setVacancy(VacancyBean vacancy) {
            this.vacancy = vacancy;
        }

        public ToVacancyBean getToVacancy() {
            return toVacancy;
        }

        public int getToVacancyInt() {
            if(toVacancy == null) return 0;
            return toVacancy.getNum();
        }

        public void setToVacancy(ToVacancyBean toVacancy) {
            this.toVacancy = toVacancy;
        }

        public List<RankAgeListBean> getRankAgeList() {
            return rankAgeList;
        }

        public String getRankAgeListStr() {
            if(rankAgeList == null) return "";
            return GsonUtil.convertVO2String(rankAgeList);
        }

        public void setRankAgeList(List<RankAgeListBean> rankAgeList) {
            this.rankAgeList = rankAgeList;
        }

        public static class OvermatchBean {
            /**
             * name : 超配数
             * num : 1
             */

            private String name;
            private int num;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        public static class ParallelBean {
            /**
             * name : 职务与职级并行(人)
             * num : 4
             */

            private String name;
            private int num;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        public static class VacancyBean {
            /**
             * name : 可用空缺职位数(人)
             * num : 5
             */

            private String name;
            private int num;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        public static class ToVacancyBean {
            /**
             * name : 调整到空缺职位
             * num : 7
             */

            private String name;
            private int num;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        public static class RankAgeListBean {
            /**
             * name : 2019
             * num : 0
             */

            private String name;
            private int num;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }
    }
}
