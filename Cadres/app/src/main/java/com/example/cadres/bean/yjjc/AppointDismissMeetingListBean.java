package com.example.cadres.bean.yjjc;

import com.example.cadres.utils.GsonUtil;

import java.util.List;

public class AppointDismissMeetingListBean {
    /**
     * searchValue : null
     * createBy : 管理员
     * createTime : 2020-06-26 21:25:21
     * updateBy :
     * updateTime : null
     * remark :
     * deptCode : null
     * params : {}
     * meetingId : 200
     * schemeId : 200
     * schemeName : 方案1
     * meetingSummary : <div style="text-align: center;"><span style="color: rgb(103, 106, 108); text-align: right;"><b>有关干部调整配备情况汇报</b></span></div><div style="text-align: center;"><span style="color: rgb(103, 106, 108); text-align: right;"><b><br></b></span></div><div style="text-align: left;"><span style="color: rgb(103, 106, 108); text-align: right;">&nbsp; &nbsp; 1、有关干部调整配备情况汇报内容测试，</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span></div><div style="text-align: left;"><span style="color: rgb(103, 106, 108); text-align: right;">&nbsp; &nbsp; 2、</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span><span style="color: rgb(103, 106, 108); text-align: right;">有关干部调整配备情况汇报内容测试</span></div><div style="text-align: left;"><span style="color: rgb(103, 106, 108); text-align: right;"><br></span><span style="color: rgb(103, 106, 108); text-align: right;"><b><br></b></span></div>
     * meetingName : 2020年第一次部务会议标题测试
     * meetingType : 部务会议
     * meetingTime : 2020-06-09
     * meetingUser : 张三、李四、王五
     * meetingDescribe : 2020年第一次部务会议内容测试
     * materialFileName : null
     */

    private int meetingId;
    private int schemeId;
    private String schemeName;
    private String meetingSummary;
    private String meetingName;
    private String meetingType;
    private String meetingTime;
    private String meetingUser;
    private String meetingDescribe;
    private List<String> materialFileName;

    public int getMeetingId() {
        return meetingId;
    }

    public int getSchemeId() {
        return schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public String getMeetingSummary() {
        return meetingSummary;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public String getMeetingUser() {
        return meetingUser;
    }

    public String getMeetingDescribe() {
        return meetingDescribe;
    }

    public String getMaterialFileName() {
        if(materialFileName == null || materialFileName.size() == 0)
            return "";
        return GsonUtil.convertVO2String(materialFileName);
    }
}