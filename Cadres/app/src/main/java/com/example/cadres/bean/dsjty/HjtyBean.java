package com.example.cadres.bean.dsjty;

public class HjtyBean {

    HjtyBean2 newTerm;

    public HjtyBean2 getNewTerm() {
        return newTerm;
    }

    public static class HjtyBean2{

        /**
         * swbzcount : 0
         * inconformityswbz : 0
         * szfbzcount : 0
         * inconformityszfbz : 0
         * srdbzcount : 3
         * inconformitysrdbz : 1
         * szxzcount : 0
         * inconformityszx : 0
         */

        private int swbzcount;
        private int inconformityswbz;
        private int szfbzcount;
        private int inconformityszfbz;
        private int srdbzcount;
        private int inconformitysrdbz;
        private int szxzcount;
        private int inconformityszx;

        public int getSwbzcount() {
            return swbzcount;
        }

        public void setSwbzcount(int swbzcount) {
            this.swbzcount = swbzcount;
        }

        public int getInconformityswbz() {
            return inconformityswbz;
        }

        public void setInconformityswbz(int inconformityswbz) {
            this.inconformityswbz = inconformityswbz;
        }

        public int getSzfbzcount() {
            return szfbzcount;
        }

        public void setSzfbzcount(int szfbzcount) {
            this.szfbzcount = szfbzcount;
        }

        public int getInconformityszfbz() {
            return inconformityszfbz;
        }

        public void setInconformityszfbz(int inconformityszfbz) {
            this.inconformityszfbz = inconformityszfbz;
        }

        public int getSrdbzcount() {
            return srdbzcount;
        }

        public void setSrdbzcount(int srdbzcount) {
            this.srdbzcount = srdbzcount;
        }

        public int getInconformitysrdbz() {
            return inconformitysrdbz;
        }

        public void setInconformitysrdbz(int inconformitysrdbz) {
            this.inconformitysrdbz = inconformitysrdbz;
        }

        public int getSzxzcount() {
            return szxzcount;
        }

        public void setSzxzcount(int szxzcount) {
            this.szxzcount = szxzcount;
        }

        public int getInconformityszx() {
            return inconformityszx;
        }

        public void setInconformityszx(int inconformityszx) {
            this.inconformityszx = inconformityszx;
        }
    }
}
