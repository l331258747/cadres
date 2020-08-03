package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DBSearchBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBSEARCH_BEAN".
*/
public class DBSearchBeanDao extends AbstractDao<DBSearchBean, Long> {

    public static final String TABLENAME = "DBSEARCH_BEAN";

    /**
     * Properties of entity DBSearchBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property CadreTypes = new Property(1, String.class, "cadreTypes", false, "CADRE_TYPES");
        public final static Property OrgTypes = new Property(2, String.class, "orgTypes", false, "ORG_TYPES");
        public final static Property CurrenRankTypes = new Property(3, String.class, "currenRankTypes", false, "CURREN_RANK_TYPES");
        public final static Property EducationTypes = new Property(4, String.class, "educationTypes", false, "EDUCATION_TYPES");
        public final static Property SchoolTypes = new Property(5, String.class, "schoolTypes", false, "SCHOOL_TYPES");
        public final static Property WorkExperienceTypes = new Property(6, String.class, "workExperienceTypes", false, "WORK_EXPERIENCE_TYPES");
        public final static Property PoliticalOutlookTypes = new Property(7, String.class, "politicalOutlookTypes", false, "POLITICAL_OUTLOOK_TYPES");
        public final static Property UserSexTypes = new Property(8, String.class, "userSexTypes", false, "USER_SEX_TYPES");
        public final static Property FunctionaryRankParentTypes = new Property(9, String.class, "functionaryRankParentTypes", false, "FUNCTIONARY_RANK_PARENT_TYPES");
        public final static Property FunctionaryRankTypes = new Property(10, String.class, "functionaryRankTypes", false, "FUNCTIONARY_RANK_TYPES");
        public final static Property OftenSearchPostTypes = new Property(11, String.class, "oftenSearchPostTypes", false, "OFTEN_SEARCH_POST_TYPES");
        public final static Property OftenSearchPostLabelTypes = new Property(12, String.class, "oftenSearchPostLabelTypes", false, "OFTEN_SEARCH_POST_LABEL_TYPES");
    }


    public DBSearchBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DBSearchBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBSEARCH_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"CADRE_TYPES\" TEXT," + // 1: cadreTypes
                "\"ORG_TYPES\" TEXT," + // 2: orgTypes
                "\"CURREN_RANK_TYPES\" TEXT," + // 3: currenRankTypes
                "\"EDUCATION_TYPES\" TEXT," + // 4: educationTypes
                "\"SCHOOL_TYPES\" TEXT," + // 5: schoolTypes
                "\"WORK_EXPERIENCE_TYPES\" TEXT," + // 6: workExperienceTypes
                "\"POLITICAL_OUTLOOK_TYPES\" TEXT," + // 7: politicalOutlookTypes
                "\"USER_SEX_TYPES\" TEXT," + // 8: userSexTypes
                "\"FUNCTIONARY_RANK_PARENT_TYPES\" TEXT," + // 9: functionaryRankParentTypes
                "\"FUNCTIONARY_RANK_TYPES\" TEXT," + // 10: functionaryRankTypes
                "\"OFTEN_SEARCH_POST_TYPES\" TEXT," + // 11: oftenSearchPostTypes
                "\"OFTEN_SEARCH_POST_LABEL_TYPES\" TEXT);"); // 12: oftenSearchPostLabelTypes
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBSEARCH_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBSearchBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String cadreTypes = entity.getCadreTypes();
        if (cadreTypes != null) {
            stmt.bindString(2, cadreTypes);
        }
 
        String orgTypes = entity.getOrgTypes();
        if (orgTypes != null) {
            stmt.bindString(3, orgTypes);
        }
 
        String currenRankTypes = entity.getCurrenRankTypes();
        if (currenRankTypes != null) {
            stmt.bindString(4, currenRankTypes);
        }
 
        String educationTypes = entity.getEducationTypes();
        if (educationTypes != null) {
            stmt.bindString(5, educationTypes);
        }
 
        String schoolTypes = entity.getSchoolTypes();
        if (schoolTypes != null) {
            stmt.bindString(6, schoolTypes);
        }
 
        String workExperienceTypes = entity.getWorkExperienceTypes();
        if (workExperienceTypes != null) {
            stmt.bindString(7, workExperienceTypes);
        }
 
        String politicalOutlookTypes = entity.getPoliticalOutlookTypes();
        if (politicalOutlookTypes != null) {
            stmt.bindString(8, politicalOutlookTypes);
        }
 
        String userSexTypes = entity.getUserSexTypes();
        if (userSexTypes != null) {
            stmt.bindString(9, userSexTypes);
        }
 
        String functionaryRankParentTypes = entity.getFunctionaryRankParentTypes();
        if (functionaryRankParentTypes != null) {
            stmt.bindString(10, functionaryRankParentTypes);
        }
 
        String functionaryRankTypes = entity.getFunctionaryRankTypes();
        if (functionaryRankTypes != null) {
            stmt.bindString(11, functionaryRankTypes);
        }
 
        String oftenSearchPostTypes = entity.getOftenSearchPostTypes();
        if (oftenSearchPostTypes != null) {
            stmt.bindString(12, oftenSearchPostTypes);
        }
 
        String oftenSearchPostLabelTypes = entity.getOftenSearchPostLabelTypes();
        if (oftenSearchPostLabelTypes != null) {
            stmt.bindString(13, oftenSearchPostLabelTypes);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBSearchBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String cadreTypes = entity.getCadreTypes();
        if (cadreTypes != null) {
            stmt.bindString(2, cadreTypes);
        }
 
        String orgTypes = entity.getOrgTypes();
        if (orgTypes != null) {
            stmt.bindString(3, orgTypes);
        }
 
        String currenRankTypes = entity.getCurrenRankTypes();
        if (currenRankTypes != null) {
            stmt.bindString(4, currenRankTypes);
        }
 
        String educationTypes = entity.getEducationTypes();
        if (educationTypes != null) {
            stmt.bindString(5, educationTypes);
        }
 
        String schoolTypes = entity.getSchoolTypes();
        if (schoolTypes != null) {
            stmt.bindString(6, schoolTypes);
        }
 
        String workExperienceTypes = entity.getWorkExperienceTypes();
        if (workExperienceTypes != null) {
            stmt.bindString(7, workExperienceTypes);
        }
 
        String politicalOutlookTypes = entity.getPoliticalOutlookTypes();
        if (politicalOutlookTypes != null) {
            stmt.bindString(8, politicalOutlookTypes);
        }
 
        String userSexTypes = entity.getUserSexTypes();
        if (userSexTypes != null) {
            stmt.bindString(9, userSexTypes);
        }
 
        String functionaryRankParentTypes = entity.getFunctionaryRankParentTypes();
        if (functionaryRankParentTypes != null) {
            stmt.bindString(10, functionaryRankParentTypes);
        }
 
        String functionaryRankTypes = entity.getFunctionaryRankTypes();
        if (functionaryRankTypes != null) {
            stmt.bindString(11, functionaryRankTypes);
        }
 
        String oftenSearchPostTypes = entity.getOftenSearchPostTypes();
        if (oftenSearchPostTypes != null) {
            stmt.bindString(12, oftenSearchPostTypes);
        }
 
        String oftenSearchPostLabelTypes = entity.getOftenSearchPostLabelTypes();
        if (oftenSearchPostLabelTypes != null) {
            stmt.bindString(13, oftenSearchPostLabelTypes);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DBSearchBean readEntity(Cursor cursor, int offset) {
        DBSearchBean entity = new DBSearchBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // cadreTypes
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // orgTypes
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // currenRankTypes
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // educationTypes
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // schoolTypes
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // workExperienceTypes
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // politicalOutlookTypes
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // userSexTypes
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // functionaryRankParentTypes
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // functionaryRankTypes
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // oftenSearchPostTypes
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12) // oftenSearchPostLabelTypes
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBSearchBean entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCadreTypes(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setOrgTypes(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCurrenRankTypes(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setEducationTypes(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSchoolTypes(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setWorkExperienceTypes(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPoliticalOutlookTypes(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setUserSexTypes(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setFunctionaryRankParentTypes(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setFunctionaryRankTypes(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setOftenSearchPostTypes(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setOftenSearchPostLabelTypes(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBSearchBean entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBSearchBean entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBSearchBean entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
