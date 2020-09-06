package com.example.cadres.beanDB;

import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DBGbBean {

    @Id(autoincrement = true)
    private Long _id;
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
    private String fullTime;
    private String fullTimeEducation;
    private String fullTimeSchool;
    private int fullTimeDegreeId;
    private String fullTimeDegreeName;
    private String fullTimeSchoolType;
    private String current;
    private String currentEducation;
    private int currentDegreeId;
    private String currentDegreeName;
    private String currentSchool;
    private String currentSchoolType;
    private String workPhone;
    private String phoneNumber;
    private String homeAddress;
    private String responsibilities;
    private String affectedState;
    private String fullTimeMajor;
    private String currentMajor;

    private String fullTimeSchoolMajor;
    private String currentSchoolMajor;

    private String nativePlaceReplenish;
    private String functionaryRegisterTime;
    private String positionType;
    private String establishmentType;
    private String remark;
    private String type;
    private String cadreResume;
    private String cadreAward;
    private String cadrePunish;
    private String cadreTrain;
    private String politicalConstruction;
    private String cadreAssessment;

    private String functionaryRankStartTime;
    private String functionaryRankParentName;
    private String postLabel;
    private String workExperience;

    @Generated(hash = 849418092)
    public DBGbBean(Long _id, int baseId, String name, String photoFileName,
            String gender, String idCard, String birthday, int age, String nation,
            String politicalOutlook, String joinPartyDate, String nativePlace,
            String birthplace, String workTime, int personnelRelationsDeptId,
            String personnelRelationsDeptName, String enterUnitTime,
            String currentRank, String currentRankTime, String health,
            int functionaryRankId, String functionaryRankName,
            String functionaryRankTime, String cadreType, String currentPosition,
            String currentPositionTime, String personnelType, String technicalTitle,
            String expertise, String fullTime, String fullTimeEducation,
            String fullTimeSchool, int fullTimeDegreeId, String fullTimeDegreeName,
            String fullTimeSchoolType, String current, String currentEducation,
            int currentDegreeId, String currentDegreeName, String currentSchool,
            String currentSchoolType, String workPhone, String phoneNumber,
            String homeAddress, String responsibilities, String affectedState,
            String fullTimeMajor, String currentMajor, String fullTimeSchoolMajor,
            String currentSchoolMajor, String nativePlaceReplenish,
            String functionaryRegisterTime, String positionType,
            String establishmentType, String remark, String type,
            String cadreResume, String cadreAward, String cadrePunish,
            String cadreTrain, String politicalConstruction, String cadreAssessment,
            String functionaryRankStartTime, String functionaryRankParentName,
            String postLabel, String workExperience) {
        this._id = _id;
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
        this.fullTime = fullTime;
        this.fullTimeEducation = fullTimeEducation;
        this.fullTimeSchool = fullTimeSchool;
        this.fullTimeDegreeId = fullTimeDegreeId;
        this.fullTimeDegreeName = fullTimeDegreeName;
        this.fullTimeSchoolType = fullTimeSchoolType;
        this.current = current;
        this.currentEducation = currentEducation;
        this.currentDegreeId = currentDegreeId;
        this.currentDegreeName = currentDegreeName;
        this.currentSchool = currentSchool;
        this.currentSchoolType = currentSchoolType;
        this.workPhone = workPhone;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.responsibilities = responsibilities;
        this.affectedState = affectedState;
        this.fullTimeMajor = fullTimeMajor;
        this.currentMajor = currentMajor;
        this.fullTimeSchoolMajor = fullTimeSchoolMajor;
        this.currentSchoolMajor = currentSchoolMajor;
        this.nativePlaceReplenish = nativePlaceReplenish;
        this.functionaryRegisterTime = functionaryRegisterTime;
        this.positionType = positionType;
        this.establishmentType = establishmentType;
        this.remark = remark;
        this.type = type;
        this.cadreResume = cadreResume;
        this.cadreAward = cadreAward;
        this.cadrePunish = cadrePunish;
        this.cadreTrain = cadreTrain;
        this.politicalConstruction = politicalConstruction;
        this.cadreAssessment = cadreAssessment;
        this.functionaryRankStartTime = functionaryRankStartTime;
        this.functionaryRankParentName = functionaryRankParentName;
        this.postLabel = postLabel;
        this.workExperience = workExperience;
    }
    @Generated(hash = 54676971)
    public DBGbBean() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getBaseId() {
        return this.baseId;
    }
    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhotoFileName() {
        return this.photoFileName;
    }
    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getIdCard() {
        return this.idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getNation() {
        return this.nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getPoliticalOutlook() {
        return this.politicalOutlook;
    }
    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }
    public String getJoinPartyDate() {
        return this.joinPartyDate;
    }
    public void setJoinPartyDate(String joinPartyDate) {
        this.joinPartyDate = joinPartyDate;
    }
    public String getNativePlace() {
        return this.nativePlace;
    }
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    public String getBirthplace() {
        return this.birthplace;
    }
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    public String getWorkTime() {
        return this.workTime;
    }
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }
    public int getPersonnelRelationsDeptId() {
        return this.personnelRelationsDeptId;
    }
    public void setPersonnelRelationsDeptId(int personnelRelationsDeptId) {
        this.personnelRelationsDeptId = personnelRelationsDeptId;
    }
    public String getPersonnelRelationsDeptName() {
        return this.personnelRelationsDeptName;
    }
    public void setPersonnelRelationsDeptName(String personnelRelationsDeptName) {
        this.personnelRelationsDeptName = personnelRelationsDeptName;
    }
    public String getEnterUnitTime() {
        return this.enterUnitTime;
    }
    public void setEnterUnitTime(String enterUnitTime) {
        this.enterUnitTime = enterUnitTime;
    }
    public String getCurrentRank() {
        return this.currentRank;
    }
    public void setCurrentRank(String currentRank) {
        this.currentRank = currentRank;
    }
    public String getCurrentRankTime() {
        return this.currentRankTime;
    }
    public void setCurrentRankTime(String currentRankTime) {
        this.currentRankTime = currentRankTime;
    }
    public String getHealth() {
        return this.health;
    }
    public void setHealth(String health) {
        this.health = health;
    }
    public int getFunctionaryRankId() {
        return this.functionaryRankId;
    }
    public void setFunctionaryRankId(int functionaryRankId) {
        this.functionaryRankId = functionaryRankId;
    }
    public String getFunctionaryRankName() {
        return this.functionaryRankName;
    }
    public void setFunctionaryRankName(String functionaryRankName) {
        this.functionaryRankName = functionaryRankName;
    }
    public String getFunctionaryRankTime() {
        return this.functionaryRankTime;
    }
    public void setFunctionaryRankTime(String functionaryRankTime) {
        this.functionaryRankTime = functionaryRankTime;
    }
    public String getCadreType() {
        return this.cadreType;
    }
    public void setCadreType(String cadreType) {
        this.cadreType = cadreType;
    }
    public String getCurrentPosition() {
        return this.currentPosition;
    }
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }
    public String getCurrentPositionTime() {
        return this.currentPositionTime;
    }
    public void setCurrentPositionTime(String currentPositionTime) {
        this.currentPositionTime = currentPositionTime;
    }
    public String getPersonnelType() {
        return this.personnelType;
    }
    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType;
    }
    public String getTechnicalTitle() {
        return this.technicalTitle;
    }
    public void setTechnicalTitle(String technicalTitle) {
        this.technicalTitle = technicalTitle;
    }
    public String getExpertise() {
        return this.expertise;
    }
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
    public String getFullTimeEducation() {
        return this.fullTimeEducation;
    }
    public void setFullTimeEducation(String fullTimeEducation) {
        this.fullTimeEducation = fullTimeEducation;
    }
    public String getFullTimeSchool() {
        return this.fullTimeSchool;
    }
    public void setFullTimeSchool(String fullTimeSchool) {
        this.fullTimeSchool = fullTimeSchool;
    }
    public int getFullTimeDegreeId() {
        return this.fullTimeDegreeId;
    }
    public void setFullTimeDegreeId(int fullTimeDegreeId) {
        this.fullTimeDegreeId = fullTimeDegreeId;
    }
    public String getFullTimeDegreeName() {
        return this.fullTimeDegreeName;
    }
    public void setFullTimeDegreeName(String fullTimeDegreeName) {
        this.fullTimeDegreeName = fullTimeDegreeName;
    }
    public String getFullTimeSchoolType() {
        return this.fullTimeSchoolType;
    }
    public void setFullTimeSchoolType(String fullTimeSchoolType) {
        this.fullTimeSchoolType = fullTimeSchoolType;
    }
    public String getCurrentEducation() {
        return this.currentEducation;
    }
    public void setCurrentEducation(String currentEducation) {
        this.currentEducation = currentEducation;
    }
    public int getCurrentDegreeId() {
        return this.currentDegreeId;
    }
    public void setCurrentDegreeId(int currentDegreeId) {
        this.currentDegreeId = currentDegreeId;
    }
    public String getCurrentDegreeName() {
        return this.currentDegreeName;
    }
    public void setCurrentDegreeName(String currentDegreeName) {
        this.currentDegreeName = currentDegreeName;
    }
    public String getCurrentSchool() {
        return this.currentSchool;
    }
    public void setCurrentSchool(String currentSchool) {
        this.currentSchool = currentSchool;
    }
    public String getCurrentSchoolType() {
        return this.currentSchoolType;
    }
    public void setCurrentSchoolType(String currentSchoolType) {
        this.currentSchoolType = currentSchoolType;
    }
    public String getWorkPhone() {
        return this.workPhone;
    }
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getHomeAddress() {
        return this.homeAddress;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    public String getResponsibilities() {
        return this.responsibilities;
    }
    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }
    public String getAffectedState() {
        return this.affectedState;
    }
    public void setAffectedState(String affectedState) {
        this.affectedState = affectedState;
    }
    public String getFullTimeMajor() {
        return this.fullTimeMajor;
    }
    public void setFullTimeMajor(String fullTimeMajor) {
        this.fullTimeMajor = fullTimeMajor;
    }
    public String getCurrentMajor() {
        return this.currentMajor;
    }
    public void setCurrentMajor(String currentMajor) {
        this.currentMajor = currentMajor;
    }

    public String getBirthdayAge() {
        if(!TextUtils.isEmpty(birthday) && age != 0)
            return birthday + "\n(" + age + ")";
        if(!TextUtils.isEmpty(birthday))
            return birthday;
        if(age != 0)
            return age+"";
        return "";
    }
    public String getFullTimeSchoolMajor() {
        return this.fullTimeSchoolMajor;
    }
    public void setFullTimeSchoolMajor(String fullTimeSchoolMajor) {
        this.fullTimeSchoolMajor = fullTimeSchoolMajor;
    }
    public String getCurrentSchoolMajor() {
        return this.currentSchoolMajor;
    }
    public void setCurrentSchoolMajor(String currentSchoolMajor) {
        this.currentSchoolMajor = currentSchoolMajor;
    }
    public String getNativePlaceReplenish() {
        return this.nativePlaceReplenish;
    }
    public void setNativePlaceReplenish(String nativePlaceReplenish) {
        this.nativePlaceReplenish = nativePlaceReplenish;
    }
    public String getFunctionaryRegisterTime() {
        return this.functionaryRegisterTime;
    }
    public void setFunctionaryRegisterTime(String functionaryRegisterTime) {
        this.functionaryRegisterTime = functionaryRegisterTime;
    }
    public String getPositionType() {
        return this.positionType;
    }
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
    public String getEstablishmentType() {
        return this.establishmentType;
    }
    public void setEstablishmentType(String establishmentType) {
        this.establishmentType = establishmentType;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getType() {
        if(TextUtils.isEmpty(this.type))
            return "1";
        return this.type;
    }

    //类型（1领导干部，2职级公务员，3后备干部）
    public String getTypeStr() {
        StringBuffer sb = new StringBuffer("");
        if(type.indexOf("1") != -1)
            sb.append("领导干部，");
        if(type.indexOf("2") != -1)
            sb.append("职级公务员，");
        if(type.indexOf("3") != -1)
            sb.append("后备干部，");
        if(sb.lastIndexOf("，") != -1){
            String str = sb.substring(0,sb.length()-1);
            return str;
        }else{
            return "领导干部";
        }
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getCadreResume() {
        return this.cadreResume;
    }
    public void setCadreResume(String cadreResume) {
        this.cadreResume = cadreResume;
    }
    public String getCadreAward() {
        return this.cadreAward;
    }
    public void setCadreAward(String cadreAward) {
        this.cadreAward = cadreAward;
    }
    public String getCadrePunish() {
        return this.cadrePunish;
    }
    public void setCadrePunish(String cadrePunish) {
        this.cadrePunish = cadrePunish;
    }
    public String getCadreTrain() {
        return this.cadreTrain;
    }
    public void setCadreTrain(String cadreTrain) {
        this.cadreTrain = cadreTrain;
    }
    public String getPoliticalConstruction() {
        return this.politicalConstruction;
    }
    public void setPoliticalConstruction(String politicalConstruction) {
        this.politicalConstruction = politicalConstruction;
    }
    public String getFullTime() {
        return this.fullTime;
    }
    public void setFullTime(String fullTime) {
        this.fullTime = fullTime;
    }
    public String getCurrent() {
        return this.current;
    }
    public void setCurrent(String current) {
        this.current = current;
    }
    public String getCadreAssessment() {
        return this.cadreAssessment;
    }
    public void setCadreAssessment(String cadreAssessment) {
        this.cadreAssessment = cadreAssessment;
    }
    public String getFunctionaryRankStartTime() {
        return this.functionaryRankStartTime;
    }
    public void setFunctionaryRankStartTime(String functionaryRankStartTime) {
        this.functionaryRankStartTime = functionaryRankStartTime;
    }
    public String getFunctionaryRankParentName() {
        return this.functionaryRankParentName;
    }
    public void setFunctionaryRankParentName(String functionaryRankParentName) {
        this.functionaryRankParentName = functionaryRankParentName;
    }
    public String getPostLabel() {
        return this.postLabel;
    }
    public void setPostLabel(String postLabel) {
        this.postLabel = postLabel;
    }
    public String getWorkExperience() {
        return this.workExperience;
    }
    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }
}
