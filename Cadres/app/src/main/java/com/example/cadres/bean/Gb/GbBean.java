package com.example.cadres.bean.Gb;

import android.text.TextUtils;

import java.util.List;

public class GbBean {

    List<GbBean2> cadreBaseList;

    public List<GbBean2> getCadreBaseList() {
        return cadreBaseList;
    }

    public static class GbBean2 {

        public GbBean2(int baseId, String name, String photoFileName, String gender, String idCard, String birthday, int age, String nation, String politicalOutlook, String joinPartyDate, String nativePlace, String birthplace, String workTime, int personnelRelationsDeptId, String personnelRelationsDeptName, String enterUnitTime, String currentRank, String currentRankTime, String health, int functionaryRankId, String functionaryRankName, String functionaryRankTime, String cadreType, String currentPosition, String currentPositionTime, String personnelType, String technicalTitle, String expertise, String fullTimeEducation, String fullTimeSchool, int fullTimeDegreeId, String fullTimeDegreeName, String fullTimeSchoolType, String currentEducation, int currentDegreeId, String currentDegreeName, String currentSchool, String currentSchoolType, String workPhone, String phoneNumber, String homeAddress, String responsibilities) {
            this.baseId = baseId;
            this.name = name;
            this.photoFileName = photoFileName;
            this.gender = gender;
            this.idCard = idCard;
            this.birthday = birthday;
            this.age = age;
            this.nation = nation;
            this.politicalOutlook = politicalOutlook;
            this.joinPartyDate = joinPartyDate;
            this.nativePlace = nativePlace;
            this.birthplace = birthplace;
            this.workTime = workTime;
            this.personnelRelationsDeptId = personnelRelationsDeptId;
            this.personnelRelationsDeptName = personnelRelationsDeptName;
            this.enterUnitTime = enterUnitTime;
            this.currentRank = currentRank;
            this.currentRankTime = currentRankTime;
            this.health = health;
            this.functionaryRankId = functionaryRankId;
            this.functionaryRankName = functionaryRankName;
            this.functionaryRankTime = functionaryRankTime;
            this.cadreType = cadreType;
            this.currentPosition = currentPosition;
            this.currentPositionTime = currentPositionTime;
            this.personnelType = personnelType;
            this.technicalTitle = technicalTitle;
            this.expertise = expertise;
            this.fullTimeEducation = fullTimeEducation;
            this.fullTimeSchool = fullTimeSchool;
            this.fullTimeDegreeId = fullTimeDegreeId;
            this.fullTimeDegreeName = fullTimeDegreeName;
            this.fullTimeSchoolType = fullTimeSchoolType;
            this.currentEducation = currentEducation;
            this.currentDegreeId = currentDegreeId;
            this.currentDegreeName = currentDegreeName;
            this.currentSchool = currentSchool;
            this.currentSchoolType = currentSchoolType;
            this.workPhone = workPhone;
            this.phoneNumber = phoneNumber;
            this.homeAddress = homeAddress;
            this.responsibilities = responsibilities;
        }

        /**
         * baseId : 218
         * name : 张三
         * photoFileName : 4f276e46b91a10dc8bf5b263da072d85.png
         * gender : 男
         * idCard : 111111111111111
         * birthday : 1979-01-01
         * age : 41
         * nation : 汉族
         * politicalOutlook : 中共党员
         * joinPartyDate : 1994-02-02
         * nativePlace : 中国湖南
         * birthplace : 出生地
         * workTime : 2020-06-02
         * personnelRelationsDeptId : 207
         * personnelRelationsDeptName : 乡镇1
         * enterUnitTime : 2020-06-04
         * currentRank : 正科
         * currentRankTime : 2020-06-16
         * health : 健康
         * functionaryRankId : 201
         * functionaryRankName : 一级巡视员
         * functionaryRankTime : 2020-06-03
         * cadreType : 市管干部
         * currentPosition : 乡镇1副书记,国税局副主任,乡镇1书记
         * currentPositionTime : 2020-06-10
         * personnelType : 参照公务员
         * technicalTitle : 专业技术职务
         * expertise : 熟悉专业及专长
         * fullTimeEducation : 小学
         * fullTimeSchool : 全日制毕业院校及专业
         * fullTimeDegreeId : 205
         * fullTimeDegreeName : 哲学博士
         * fullTimeSchoolType : 985
         * currentEducation : 中学
         * currentDegreeId : 206
         * currentDegreeName : 经济学博士
         * currentSchool : 在职教育毕业院校及专业
         * currentSchoolType : 双一流
         * workPhone : 0736-11111111
         * phoneNumber : 18911111111
         * homeAddress : 家庭住址
         * responsibilities : 当前分管工作
         * cadreResumeList : [{"searchValue":null,"createBy":"","createTime":"2020-06-12 10:18:50","updateBy":"","updateTime":null,"remark":null,"deptCode":null,"params":{},"resumeId":203,"baseId":218,"cadreName":"张三","workType":"","workStartTime":"2020-06-02","workEndTime":"2020-06-02","workDescribe":"sdfsdf"}]
         * cadreNowPositionList : [{"positionId":228,"deptId":207,"deptName":"乡镇1","baseId":218,"cadreName":"张三","positionTime":"2020-06-10","position":"在任","positionTitle":201,"positionTitleName":"副书记","positionReason":"挂职","positionFileNumber":"","dutiesRank":"1","vacantPosition":"是","createBy":"管理员","createTime":"2020-06-19 17:04:22","updateBy":"管理员","updateTime":"2020-06-22 15:14:19"},{"positionId":218,"deptId":210,"deptName":"国税局","baseId":218,"cadreName":"张三","positionTime":"2020-06-10","position":"在任","positionTitle":204,"positionTitleName":"副主任","positionReason":"兼职","positionFileNumber":"","dutiesRank":"2","vacantPosition":"是","createBy":"","createTime":"2020-06-10 15:33:57","updateBy":"管理员","updateTime":"2020-06-22 15:14:20"},{"positionId":217,"deptId":207,"deptName":"乡镇1","baseId":218,"cadreName":"张三","positionTime":"2020-06-10","position":"在任","positionTitle":200,"positionTitleName":"书记","positionReason":"公选","positionFileNumber":"","dutiesRank":"1","vacantPosition":"是","createBy":"","createTime":"2020-06-10 15:31:13","updateBy":"管理员","updateTime":"2020-06-22 15:14:23"}]
         * cadreHistoryPositionList : [{"positionId":224,"deptId":210,"deptName":"国税局","baseId":218,"cadreName":"张三","dutiesRank":"","position":"不在任（已免职）","positionTitle":204,"positionTitleName":"副主任","leaveTime":"2020-06-10","leaveReason":"","leaveFileNumber":"","vacantPosition":"是","createBy":"","createTime":"2020-06-10 18:27:42","updateBy":"","updateTime":null}]
         * cadreRankList : [{"searchValue":null,"createBy":"管理员","createTime":"2020-06-15 17:33:56","updateBy":"管理员","updateTime":"2020-06-22 15:13:38","remark":null,"deptCode":null,"params":{},"rankId":200,"baseId":218,"cadreName":"张三","state":"现行","dutiesRank":"正科","dutiesRankTime":"2020-06-16","treatmentRank":"正处","treatmentRankTime":"2020-06-10"},{"searchValue":null,"createBy":"管理员","createTime":"2020-06-15 17:40:50","updateBy":"","updateTime":null,"remark":null,"deptCode":null,"params":{},"rankId":201,"baseId":218,"cadreName":"张三","state":"历史","dutiesRank":"副科","dutiesRankTime":"2020-06-10","treatmentRank":"","treatmentRankTime":null}]
         * cadreFamilyMemberList : []
         * cadreAwardPunishList : []
         * cadreTrainList : [{"searchValue":null,"createBy":"管理员","createTime":"2020-06-15 17:47:01","updateBy":"","updateTime":null,"remark":null,"deptCode":null,"params":{},"trainId":200,"baseId":218,"cadreName":"张三","startTime":"2020-06-02","endTime":"2020-06-18","trainingCourse":"333","trainLevel":"调训","trainType":"初任培训","trainOrganization":"省委党校","trainMode":"夜校学习","trainContent":"232332"}]
         * cadreDeptList : [{"searchValue":null,"createBy":"","createTime":"2020-06-10 15:31:13","updateBy":"","updateTime":null,"remark":null,"deptCode":"205,206,207","params":{},"deptId":207,"baseId":218,"state":"0","deptName":"乡镇1","deptType":"党委班子"},{"searchValue":null,"createBy":"","createTime":"2020-06-10 15:33:57","updateBy":"","updateTime":null,"remark":null,"deptCode":"205,209,210","params":{},"deptId":210,"baseId":218,"state":"0","deptName":"国税局","deptType":"人大班子"}]
         * createBy : 管理员
         * createTime : 2020-06-10 14:43:57
         * updateBy : 管理员
         * updateTime : 2020-06-22 15:14:23
         * remark : 备注
         */

        private int baseId;
        private String name;
        private String photoFileName;
        private String gender;
        private String idCard;
        private String birthday;
        private int age;
        private String nation;
        private String politicalOutlook;
        private String joinPartyDate;
        private String nativePlace;
        private String birthplace;
        private String workTime;
        private int personnelRelationsDeptId;
        private String personnelRelationsDeptName;
        private String enterUnitTime;
        private String currentRank;
        private String currentRankTime;
        private String health;
        private int functionaryRankId;
        private String functionaryRankName;
        private String functionaryRankTime;
        private String cadreType;
        private String currentPosition;
        private String currentPositionTime;
        private String personnelType;
        private String technicalTitle;
        private String expertise;
        private String fullTimeEducation;
        private String fullTimeSchool;
        private int fullTimeDegreeId;
        private String fullTimeDegreeName;
        private String fullTimeSchoolType;
        private String currentEducation;
        private int currentDegreeId;
        private String currentDegreeName;
        private String currentSchool;
        private String currentSchoolType;
        private String workPhone;
        private String phoneNumber;
        private String homeAddress;
        private String responsibilities;
        private List<GbCadreResumeListBean> cadreResumeList;//干部简历
        private List<GbCadreNowPositionListBean> cadreNowPositionList;//干部现任职信息
        private List<GbCadreHistoryPositionListBean> cadreHistoryPositionList;//干部曾任职信息
        private List<GbCadreRankListBean> cadreRankList;//干部职级信息
        private List<GbCadreFamilyMemberList> cadreFamilyMemberList;//干部家庭成员信息
        private List<GbCadreAwardPunishList> cadreAwardPunishList;//干部奖惩记录信息
        private List<GbCadreTrainListBean> cadreTrainList;//干部培训情况
        private List<GbCadreDeptListBean> cadreDeptList;//干部所属部门信息

        public int getBaseId() {
            return baseId;
        }

        public String getName() {
            return name;
        }

        public String getPhotoFileName() {
            return photoFileName;
        }

        public String getGender() {
            return gender;
        }

        public String getIdCard() {
            return idCard;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getBirthdayAge() {
            if(!TextUtils.isEmpty(birthday) && age != 0)
                return birthday + "(" + age + ")";
            if(!TextUtils.isEmpty(birthday))
                return birthday;
            if(age != 0)
                return age+"";
            return "";
        }

        public int getAge() {
            return age;
        }

        public String getNation() {
            return nation;
        }

        public String getPoliticalOutlook() {
            return politicalOutlook;
        }

        public String getJoinPartyDate() {
            return joinPartyDate;
        }

        public String getNativePlace() {
            return nativePlace;
        }

        public String getBirthplace() {
            return birthplace;
        }

        public String getWorkTime() {
            return workTime;
        }

        public int getPersonnelRelationsDeptId() {
            return personnelRelationsDeptId;
        }

        public String getPersonnelRelationsDeptName() {
            return personnelRelationsDeptName;
        }

        public String getEnterUnitTime() {
            return enterUnitTime;
        }

        public String getCurrentRank() {
            return currentRank;
        }

        public String getCurrentRankTime() {
            return currentRankTime;
        }

        public String getHealth() {
            return health;
        }

        public int getFunctionaryRankId() {
            return functionaryRankId;
        }

        public String getFunctionaryRankName() {
            return functionaryRankName;
        }

        public String getFunctionaryRankTime() {
            return functionaryRankTime;
        }

        public String getCadreType() {
            return cadreType;
        }

        public String getCurrentPosition() {
            return currentPosition;
        }

        public String getCurrentPositionTime() {
            return currentPositionTime;
        }

        public String getPersonnelType() {
            return personnelType;
        }

        public String getTechnicalTitle() {
            return technicalTitle;
        }

        public String getExpertise() {
            return expertise;
        }

        public String getFullTimeEducation() {
            return fullTimeEducation;
        }

        public String getFullTimeSchool() {
            return fullTimeSchool;
        }

        public int getFullTimeDegreeId() {
            return fullTimeDegreeId;
        }

        public String getFullTimeDegreeName() {
            return fullTimeDegreeName;
        }

        public String getFullTimeSchoolType() {
            return fullTimeSchoolType;
        }

        public String getCurrentEducation() {
            return currentEducation;
        }

        public int getCurrentDegreeId() {
            return currentDegreeId;
        }

        public String getCurrentDegreeName() {
            return currentDegreeName;
        }

        public String getCurrentSchool() {
            return currentSchool;
        }

        public String getCurrentSchoolType() {
            return currentSchoolType;
        }

        public String getWorkPhone() {
            return workPhone;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getHomeAddress() {
            return homeAddress;
        }

        public String getResponsibilities() {
            return responsibilities;
        }

        public List<GbCadreResumeListBean> getCadreResumeList() {
            return cadreResumeList;
        }

        public List<GbCadreNowPositionListBean> getCadreNowPositionList() {
            return cadreNowPositionList;
        }

        public List<GbCadreHistoryPositionListBean> getCadreHistoryPositionList() {
            return cadreHistoryPositionList;
        }

        public List<GbCadreRankListBean> getCadreRankList() {
            return cadreRankList;
        }

        public List<GbCadreFamilyMemberList> getCadreFamilyMemberList() {
            return cadreFamilyMemberList;
        }

        public List<GbCadreAwardPunishList> getCadreAwardPunishList() {
            return cadreAwardPunishList;
        }

        public List<GbCadreTrainListBean> getCadreTrainList() {
            return cadreTrainList;
        }

        public List<GbCadreDeptListBean> getCadreDeptList() {
            return cadreDeptList;
        }
    }
}