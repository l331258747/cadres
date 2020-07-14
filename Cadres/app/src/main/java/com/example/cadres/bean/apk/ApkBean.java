package com.example.cadres.bean.apk;

public class ApkBean {

    /**
     * appVersion : {"searchValue":null,"createBy":"","createTime":"2020-07-01 16:13:59","updateBy":"","updateTime":null,"remark":null,"deptCode":null,"params":{},"id":202,"version":"12121","url":"http://localhost:8099/profile/upload/2020/07/01/52328b44ebaec28fad63cca2900715ab.jpg","content":"121211"}
     */

    private ApkBean2 appVersion;

    public ApkBean2 getAppVersion() {
        return appVersion;
    }

    public static class ApkBean2 {
        /**
         * searchValue : null
         * createBy :
         * createTime : 2020-07-01 16:13:59
         * updateBy :
         * updateTime : null
         * remark : null
         * deptCode : null
         * params : {}
         * id : 202
         * version : 12121
         * url : http://localhost:8099/profile/upload/2020/07/01/52328b44ebaec28fad63cca2900715ab.jpg
         * content : 121211
         */

        private String searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private String deptCode;
        private int id;
        private int version;
        private String url;
        private String content;

        public String getSearchValue() {
            return searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getRemark() {
            return remark;
        }

        public String getDeptCode() {
            return deptCode;
        }

        public int getId() {
            return id;
        }

        public int getVersion() {
            return version;
        }

        public String getUrl() {
            return url;
        }

        public String getContent() {
            return content;
        }
    }
}
