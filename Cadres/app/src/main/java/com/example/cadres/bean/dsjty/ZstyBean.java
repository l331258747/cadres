package com.example.cadres.bean.dsjty;

import java.util.List;

public class ZstyBean {

    List<ZstyBean2> rankDeductionList;

    public List<ZstyBean2> getRankDeductionList() {
        return rankDeductionList;
    }

    public static class ZstyBean2 {

        /**
         * year : 2020
         * rankAge : 0
         * toVacancy : 0
         * parallel : 0
         * overmatch : 15
         * vacancy : 5
         * digestion : 0
         */

        private String year;
        private int rankAge;
        private int toVacancy;
        private int parallel;
        private int overmatch;
        private int vacancy;
        private int digestion;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public int getRankAge() {
            return rankAge;
        }

        public void setRankAge(int rankAge) {
            this.rankAge = rankAge;
        }

        public int getToVacancy() {
            return toVacancy;
        }

        public void setToVacancy(int toVacancy) {
            this.toVacancy = toVacancy;
        }

        public int getParallel() {
            return parallel;
        }

        public void setParallel(int parallel) {
            this.parallel = parallel;
        }

        public int getOvermatch() {
            return overmatch;
        }

        public void setOvermatch(int overmatch) {
            this.overmatch = overmatch;
        }

        public int getVacancy() {
            return vacancy;
        }

        public void setVacancy(int vacancy) {
            this.vacancy = vacancy;
        }

        public int getDigestion() {
            return digestion;
        }

        public void setDigestion(int digestion) {
            this.digestion = digestion;
        }
    }
}
