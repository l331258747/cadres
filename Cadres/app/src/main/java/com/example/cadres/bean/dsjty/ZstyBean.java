package com.example.cadres.bean.dsjty;

import android.text.TextUtils;

import java.util.List;

public class ZstyBean {

    List<ZstyBean2> rankDeductionList;
    List<ZstyBean3> nqgbStatisList;
    List<ZstyBean2> zzbGwyRankdeductionList;

    public List<ZstyBean3> getNqgbStatisList() {
        return nqgbStatisList;
    }

    public List<ZstyBean2> getRankDeductionList() {
        return rankDeductionList;
    }

    public List<ZstyBean2> getZzbGwyRankdeductionList() {
        return zzbGwyRankdeductionList;
    }

    public static class ZstyBean3{
        private String year;
        private String principal;
        private String deputy;
        private String sum;
        private String jlh;

        public int getSum() {
            if(TextUtils.isEmpty(sum)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(sum);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getJlh() {
            if(TextUtils.isEmpty(jlh)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(jlh);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public String getYear() {
            return year;
        }

        public int getPrincipal() {
            if(TextUtils.isEmpty(principal)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(principal);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getDeputy() {
            if(TextUtils.isEmpty(deputy)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(deputy);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }
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
        private String rankAge;
        private String toVacancy;
        private String parallel;
        private String overmatch;
        private String vacancy;
        private String digestion;
        private String parallelOrOther;
        private String skzz;
        private String skfz;
        private String other;
        private int type;

        public String getYear() {
            return year;
        }

        public int getRankAge() {
            if(TextUtils.isEmpty(rankAge)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(rankAge);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getToVacancy() {
            if(TextUtils.isEmpty(toVacancy)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(toVacancy);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getParallel() {
            if(TextUtils.isEmpty(parallel)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(parallel);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getOvermatch() {
            if(TextUtils.isEmpty(overmatch)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(overmatch);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getVacancy() {
            if(TextUtils.isEmpty(vacancy)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(vacancy);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getDigestion() {
            if(TextUtils.isEmpty(digestion)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(digestion);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getParallelOrOther() {
            if(TextUtils.isEmpty(parallelOrOther)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(parallelOrOther);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getSkzz() {
            if(TextUtils.isEmpty(skzz)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(skzz);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getSkfz() {
            if(TextUtils.isEmpty(skfz)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(skfz);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getOther() {
            if(TextUtils.isEmpty(other)) return 0;
            int i = 0;
            try{
                i = Integer.valueOf(other);
            }catch (Exception e){
                i = 0;
            }
            return i;
        }

        public int getType() {
            return type;
        }
    }
}
