package com.example.cadres.beanDB;

import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBBmBean {
    @Id(autoincrement = true)
    private Long _id;

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
    private String orgLevelName;

    private int surpassPosition;//超配乡科正职数量
    private int surpassDeputy;//超配乡科副职数量
    private int surpassOther;//超配其他数量
    private int lackPosition;//缺配配乡科正职数量
    private int lackDeputy;//缺配乡科副职数量
    private int lackOther;//缺配其他数量
    private String overmatchPosition;//超配乡科正职
    private String overmatchDeputy;//超配乡科副职
    private String overmatchOther;//超配其他
    private String mismatchPosition;//缺配配乡科正职
    private String mismatchDeputy;//缺配乡科副职
    private String mismatchOther;//缺配其他

    private int subset;
    
    @Generated(hash = 149785918)
    public DBBmBean(Long _id, int deptId, int parentId, String deptName,
            String dzzName, String orgCode, String orgType, String orgTypeName,
            String financeType, String financeTypeName, String simpleName,
            int orderNum, String deptType, String deptTypeName, String delFlag,
            String parentName, String verification, String actual, String overmatch,
            String mismatch, int approvedPosition, int approvedDeputy,
            int approvedOther, int actualPosition, int actualDeputy,
            int actualOther, String orgLevelName, int surpassPosition,
            int surpassDeputy, int surpassOther, int lackPosition, int lackDeputy,
            int lackOther, String overmatchPosition, String overmatchDeputy,
            String overmatchOther, String mismatchPosition, String mismatchDeputy,
            String mismatchOther, int subset) {
        this._id = _id;
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
        this.surpassPosition = surpassPosition;
        this.surpassDeputy = surpassDeputy;
        this.surpassOther = surpassOther;
        this.lackPosition = lackPosition;
        this.lackDeputy = lackDeputy;
        this.lackOther = lackOther;
        this.overmatchPosition = overmatchPosition;
        this.overmatchDeputy = overmatchDeputy;
        this.overmatchOther = overmatchOther;
        this.mismatchPosition = mismatchPosition;
        this.mismatchDeputy = mismatchDeputy;
        this.mismatchOther = mismatchOther;
        this.subset = subset;
    }
    @Generated(hash = 730075840)
    public DBBmBean() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getDeptId() {
        return this.deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public int getParentId() {
        return this.parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public String getDeptName() {
        return this.deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getDzzName() {
        return this.dzzName;
    }
    public void setDzzName(String dzzName) {
        this.dzzName = dzzName;
    }
    public String getOrgCode() {
        return this.orgCode;
    }
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    public String getOrgType() {
        return this.orgType;
    }
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
    public String getOrgTypeName() {
        return this.orgTypeName;
    }
    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }
    public String getFinanceType() {
        return this.financeType;
    }
    public void setFinanceType(String financeType) {
        this.financeType = financeType;
    }
    public String getFinanceTypeName() {
        return this.financeTypeName;
    }
    public void setFinanceTypeName(String financeTypeName) {
        this.financeTypeName = financeTypeName;
    }
    public String getSimpleName() {
        return this.simpleName;
    }
    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }
    public int getOrderNum() {
        return this.orderNum;
    }
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    public String getDeptType() {
        return this.deptType;
    }
    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }
    public String getDeptTypeName() {
        return this.deptTypeName;
    }
    public void setDeptTypeName(String deptTypeName) {
        this.deptTypeName = deptTypeName;
    }
    public String getDelFlag() {
        return this.delFlag;
    }
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
    public String getParentName() {
        return this.parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    public String getVerification() {
        return this.verification;
    }
    public void setVerification(String verification) {
        this.verification = verification;
    }
    public String getActual() {
        return this.actual;
    }
    public void setActual(String actual) {
        this.actual = actual;
    }
    public String getOvermatch() {
        return this.overmatch;
    }
    public void setOvermatch(String overmatch) {
        this.overmatch = overmatch;
    }
    public String getMismatch() {
        return this.mismatch;
    }
    public void setMismatch(String mismatch) {
        this.mismatch = mismatch;
    }
    public int getApprovedPosition() {
        return this.approvedPosition;
    }
    public void setApprovedPosition(int approvedPosition) {
        this.approvedPosition = approvedPosition;
    }
    public int getApprovedDeputy() {
        return this.approvedDeputy;
    }
    public void setApprovedDeputy(int approvedDeputy) {
        this.approvedDeputy = approvedDeputy;
    }
    public int getApprovedOther() {
        return this.approvedOther;
    }
    public void setApprovedOther(int approvedOther) {
        this.approvedOther = approvedOther;
    }
    public int getActualPosition() {
        return this.actualPosition;
    }
    public void setActualPosition(int actualPosition) {
        this.actualPosition = actualPosition;
    }
    public int getActualDeputy() {
        return this.actualDeputy;
    }
    public void setActualDeputy(int actualDeputy) {
        this.actualDeputy = actualDeputy;
    }
    public int getActualOther() {
        return this.actualOther;
    }
    public void setActualOther(int actualOther) {
        this.actualOther = actualOther;
    }
    public void setOrgLevelName(String orgLevelName) {
        this.orgLevelName = orgLevelName;
    }

    public String getOrgLevelName() {
        if(TextUtils.isEmpty(orgLevelName))
            return "";
        return orgLevelName;
    }

    public String getFinanceTypeNameStr() {
        if(TextUtils.isEmpty(financeTypeName))
            return "无";
        return financeTypeName;
    }

    public String getOrgTypeNameStr() {
        if(TextUtils.isEmpty(orgTypeName))
            return "";
        return orgTypeName;
    }

    public String getDeptTypeNameStr() {
        if(TextUtils.isEmpty(deptTypeName))
            return "";
        return deptTypeName;
    }

    public String getVerificationStr() {
        if(TextUtils.isEmpty(verification))
            return "无";
        return verification;
    }

    public String getActualStr() {
        if(TextUtils.isEmpty(actual))
            return "无";
        return actual;
    }
    public String getOvermatchStr() {
        if(TextUtils.isEmpty(overmatch))
            return "无";
        return overmatch;
    }

    public String getMismatchStr() {
        if(TextUtils.isEmpty(mismatch))
            return "无";
        return mismatch;
    }

    public String getApprovedPositionStr() {
        return approvedPosition + "";
    }

    public String getApprovedDeputyStr() {
        return approvedDeputy + "";
    }
    public String getApprovedOtherStr() {
        return approvedOther + "";
    }
    public String getActualPositionStr() {
        return actualPosition + "";
    }
    public String getActualDeputyStr() {
        return actualDeputy + "";
    }
    public String getActualOtherStr() {
        return actualOther + "";
    }
    public String getDeptNameStr() {
        if(TextUtils.isEmpty(deptName))
            return "";
        return deptName;
    }
    public int getSurpassPosition() {
        return this.surpassPosition;
    }
    public void setSurpassPosition(int surpassPosition) {
        this.surpassPosition = surpassPosition;
    }
    public int getSurpassDeputy() {
        return this.surpassDeputy;
    }
    public void setSurpassDeputy(int surpassDeputy) {
        this.surpassDeputy = surpassDeputy;
    }
    public int getSurpassOther() {
        return this.surpassOther;
    }
    public void setSurpassOther(int surpassOther) {
        this.surpassOther = surpassOther;
    }
    public int getLackPosition() {
        return this.lackPosition;
    }
    public void setLackPosition(int lackPosition) {
        this.lackPosition = lackPosition;
    }
    public int getLackDeputy() {
        return this.lackDeputy;
    }
    public void setLackDeputy(int lackDeputy) {
        this.lackDeputy = lackDeputy;
    }
    public int getLackOther() {
        return this.lackOther;
    }
    public void setLackOther(int lackOther) {
        this.lackOther = lackOther;
    }
    public String getOvermatchPosition() {
        return this.overmatchPosition;
    }
    public String getOvermatchPositionStr() {
        if(TextUtils.isEmpty(overmatchPosition))
            return "无";
        return overmatchPosition;
    }
    public void setOvermatchPosition(String overmatchPosition) {
        this.overmatchPosition = overmatchPosition;
    }
    public String getOvermatchDeputy() {
        return this.overmatchDeputy;
    }

    public String getOvermatchDeputyStr() {
        if(TextUtils.isEmpty(overmatchDeputy))
            return "无";
        return overmatchDeputy;
    }
    public void setOvermatchDeputy(String overmatchDeputy) {
        this.overmatchDeputy = overmatchDeputy;
    }
    public String getOvermatchOther() {
        return this.overmatchOther;
    }

    public String getOvermatchOtherStr() {
        if(TextUtils.isEmpty(overmatchOther))
            return "无";
        return overmatchOther;
    }

    public void setOvermatchOther(String overmatchOther) {
        this.overmatchOther = overmatchOther;
    }
    public String getMismatchPosition() {
        return this.mismatchPosition;
    }
    public String getMismatchPositionStr() {
        if(TextUtils.isEmpty(mismatchPosition))
            return "无";
        return mismatchPosition;
    }

    public void setMismatchPosition(String mismatchPosition) {
        this.mismatchPosition = mismatchPosition;
    }
    public String getMismatchDeputy() {
        return this.mismatchDeputy;
    }
    public String getMismatchDeputyStr() {
        if(TextUtils.isEmpty(mismatchDeputy))
            return "无";
        return mismatchDeputy;
    }

    public void setMismatchDeputy(String mismatchDeputy) {
        this.mismatchDeputy = mismatchDeputy;
    }
    public String getMismatchOther() {
        return this.mismatchOther;
    }
    public String getMismatchOtherStr() {
        if(TextUtils.isEmpty(mismatchOther))
            return "无";
        return mismatchOther;
    }

    public void setMismatchOther(String mismatchOther) {
        this.mismatchOther = mismatchOther;
    }
    public int getSubset() {
        return this.subset;
    }
    public void setSubset(int subset) {
        this.subset = subset;
    }
}
