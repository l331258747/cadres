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

        private Object searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private Object updateTime;
        private Object remark;
        private Object deptCode;
        private ParamsBean params;
        private int id;
        private int version;
        private String url;
        private String content;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getDeptCode() {
            return deptCode;
        }

        public void setDeptCode(Object deptCode) {
            this.deptCode = deptCode;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public static class ParamsBean {
        }
    }
}
