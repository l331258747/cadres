package com.example.cadres.bean.bm;

import android.text.TextUtils;
import android.view.TextureView;

import java.util.ArrayList;
import java.util.List;

public class BmBean {
    List<BmBean2> zzbOrganization;

    public List<BmBean2> getZzbOrganization() {
        return zzbOrganization;
    }

    public static class BmBean2 {

        public BmBean2(int deptId, int parentId, String deptName, String dzzName, String orgCode, String orgType, String orgTypeName, String financeType, String financeTypeName, String simpleName, int orderNum, String deptType, String deptTypeName, String delFlag, String parentName, String verification, String actual, String overmatch, String mismatch, int approvedPosition, int approvedDeputy, int approvedOther, int actualPosition, int actualDeputy, int actualOther,String orgLevelName) {
            this.deptId = deptId;
            this.parentId = parentId;
            this.deptName = deptName;
            this.dzzName = dzzName;
            this.orgCode = orgCode;
            this.orgType = orgType;
            this.orgTypeName = orgTypeName;
            this.financeType = financeType;
            this.financeTypeName = financeTypeName;
            this.simpleName = simpleName;
            this.orderNum = orderNum;
            this.deptType = deptType;
            this.deptTypeName = deptTypeName;
            this.delFlag = delFlag;
            this.parentName = parentName;
            this.verification = verification;
            this.actual = actual;
            this.overmatch = overmatch;
            this.mismatch = mismatch;
            this.approvedPosition = approvedPosition;
            this.approvedDeputy = approvedDeputy;
            this.approvedOther = approvedOther;
            this.actualPosition = actualPosition;
            this.actualDeputy = actualDeputy;
            this.actualOther = actualOther;
            this.orgLevelName = orgLevelName;
        }

        /**
         * searchValue : null
         * createBy :
         * createTime : 2020-06-03 11:51:24
         * updateBy :
         * updateTime : 2020-06-17 18:58:09
         * remark : null
         * deptCode : null
         * params : {}
         * deptId : 205
         * parentId : 0
         * deptName : 宁乡市
         * dzzName :
         * orgCode : 205
         * orgType : 1
         * orgTypeName : 党委班子
         * financeType : 1
         * financeTypeName : 全额机关
         * simpleName :
         * orderNum : 0
         * deptType : 1
         * deptTypeName : 真实单位/部门
         * delFlag : 0
         * parentName : null
         * verification : 主任1名、副主任2名、
         * actual :
         * overmatch :
         * mismatch : 超配主任1名、超配副主任2名、
         * approvedPosition : 1
         * approvedDeputy : 1
         * approvedOther : 1
         * actualPosition : 0
         * actualDeputy : 0
         * actualOther : 0
         * zzbPosition : [{"searchValue":null,"createBy":"","createTime":"2020-06-17 18:55:14","updateBy":"","updateTime":null,"remark":null,"deptCode":"205","params":{},"positionId":206,"deptId":205,"positionType":"1","positionTypeName":"正职","identity":"1","identityName":"公务员","jobLevel":"1","jobLevelName":"正科","jobName":"主任","numPeople":1,"remarks":"主任"},{"searchValue":null,"createBy":"","createTime":"2020-06-17 18:55:36","updateBy":"","updateTime":null,"remark":null,"deptCode":"205","params":{},"positionId":207,"deptId":205,"positionType":"2","positionTypeName":"副职","identity":"1","identityName":"公务员","jobLevel":"2","jobLevelName":"副科","jobName":"副主任","numPeople":2,"remarks":""}]
         * organizationExplain : [{"searchValue":null,"createBy":"","createTime":"2020-06-17 18:57:42","updateBy":"","updateTime":null,"remark":null,"deptCode":null,"params":{},"explainId":200,"deptId":205,"orgExplain":"111111111111111111111111111111111111111111111111111111111111111111\r\n222222222222222222222222222222222222222222222222222222222333333333333333333333333333333333333333333333333333333333\r\n444444444444444444444444444444444444444444444444444444444\r\n555555555555555555555555555555555555555555555555555555555","year":2017},{"searchValue":null,"createBy":"","createTime":"2020-06-17 18:58:06","updateBy":"","updateTime":null,"remark":null,"deptCode":null,"params":{},"explainId":201,"deptId":205,"orgExplain":"444444444444444444444444444444444444444444444444444444444555555555555555555555555555555555555555555555555555555555\r\n666666666666666666666666666666666666666666666666666666666\r\n777777777777777777777777777777777777777777777777777777777","year":2018}]
         */



        private String searchValue;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String remark;
        private String deptCode;
        private int deptId;
        private int parentId;
        private String deptName;
        private String dzzName;
        private String orgCode;
        private String orgType;
        private String orgTypeName;
        private String financeType;
        private String financeTypeName;
        private String simpleName;
        private int orderNum;
        private String deptType;
        private String deptTypeName;
        private String orgLevelName;
        private String delFlag;
        private String parentName;
        private String verification;
        private String actual;
        private String overmatch;
        private String mismatch;
        private int approvedPosition;
        private int approvedDeputy;
        private int approvedOther;
        private int actualPosition;
        private int actualDeputy;
        private int actualOther;
        private List<BmExplainBean> organizationExplain;

        public String getOrgLevelName() {
            if(TextUtils.isEmpty(orgLevelName))
                return "";
            return orgLevelName;
        }

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

        public int getDeptId() {
            return deptId;
        }

        public int getParentId() {
            return parentId;
        }

        public String getDeptName() {
            return deptName;
        }
        public String getDeptNameStr() {
            if(TextUtils.isEmpty(deptName))
                return "";
            return deptName;
        }

        public String getDzzName() {
            return dzzName;
        }

        public String getOrgCode() {
            return orgCode;
        }

        public String getOrgType() {
            return orgType;
        }

        public String getOrgTypeName() {
            return orgTypeName;
        }

        public String getOrgTypeNameStr() {
            if(TextUtils.isEmpty(orgTypeName))
                return "";
            return orgTypeName;
        }

        public String getFinanceType() {
            return financeType;
        }

        public String getFinanceTypeName() {
            return financeTypeName;
        }

        public String getFinanceTypeNameStr() {
            if(TextUtils.isEmpty(financeTypeName))
                return "无";
            return financeTypeName;
        }

        public String getSimpleName() {
            return simpleName;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public String getDeptType() {
            return deptType;
        }

        public String getDeptTypeName() {
            return deptTypeName;
        }

        public String getDeptTypeNameStr() {
            if(TextUtils.isEmpty(deptTypeName))
                return "";
            return deptTypeName;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public String getParentName() {
            return parentName;
        }

        public String getVerification() {
            return verification;
        }

        public String getVerificationStr() {
            if(TextUtils.isEmpty(verification))
                return "无";
            return verification;
        }

        public String getActual() {
            return actual;
        }
        public String getActualStr() {
            if(TextUtils.isEmpty(actual))
                return "无";
            return actual;
        }

        public String getOvermatch() {
            return overmatch;
        }
        public String getOvermatchStr() {
            if(TextUtils.isEmpty(overmatch))
                return "无";
            return overmatch;
        }

        public String getMismatch() {
            return mismatch;
        }

        public String getMismatchStr() {
            if(TextUtils.isEmpty(mismatch))
                return "无";
            return mismatch;
        }

        public int getApprovedPosition() {
            return approvedPosition;
        }
        public String getApprovedPositionStr() {
            return approvedPosition + "";
        }

        public int getApprovedDeputy() {
            return approvedDeputy;
        }

        public String getApprovedDeputyStr() {
            return approvedDeputy + "";
        }

        public int getApprovedOther() {
            return approvedOther;
        }
        public String getApprovedOtherStr() {
            return approvedOther + "";
        }

        public int getActualPosition() {
            return actualPosition;
        }
        public String getActualPositionStr() {
            return actualPosition + "";
        }

        public int getActualDeputy() {
            return actualDeputy;
        }
        public String getActualDeputyStr() {
            return actualDeputy + "";
        }

        public int getActualOther() {
            return actualOther;
        }
        public String getActualOtherStr() {
            return actualOther + "";
        }

        public List<BmExplainBean> getOrganizationExplain() {
            if(organizationExplain == null)
                return new ArrayList<>();
            return organizationExplain;
        }
    }
}
