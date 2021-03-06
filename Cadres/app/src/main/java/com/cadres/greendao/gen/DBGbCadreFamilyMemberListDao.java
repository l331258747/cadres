package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DBGbCadreFamilyMemberList;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBGB_CADRE_FAMILY_MEMBER_LIST".
*/
public class DBGbCadreFamilyMemberListDao extends AbstractDao<DBGbCadreFamilyMemberList, Long> {

    public static final String TABLENAME = "DBGB_CADRE_FAMILY_MEMBER_LIST";

    /**
     * Properties of entity DBGbCadreFamilyMemberList.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property MemberId = new Property(1, int.class, "memberId", false, "MEMBER_ID");
        public final static Property BaseId = new Property(2, int.class, "baseId", false, "BASE_ID");
        public final static Property CadreName = new Property(3, String.class, "cadreName", false, "CADRE_NAME");
        public final static Property Appellation = new Property(4, String.class, "appellation", false, "APPELLATION");
        public final static Property Name = new Property(5, String.class, "name", false, "NAME");
        public final static Property Birthday = new Property(6, String.class, "birthday", false, "BIRTHDAY");
        public final static Property PoliticalOutlook = new Property(7, String.class, "politicalOutlook", false, "POLITICAL_OUTLOOK");
        public final static Property WorkUnit = new Property(8, String.class, "workUnit", false, "WORK_UNIT");
        public final static Property Age = new Property(9, int.class, "age", false, "AGE");
    }


    public DBGbCadreFamilyMemberListDao(DaoConfig config) {
        super(config);
    }
    
    public DBGbCadreFamilyMemberListDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBGB_CADRE_FAMILY_MEMBER_LIST\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"MEMBER_ID\" INTEGER NOT NULL ," + // 1: memberId
                "\"BASE_ID\" INTEGER NOT NULL ," + // 2: baseId
                "\"CADRE_NAME\" TEXT," + // 3: cadreName
                "\"APPELLATION\" TEXT," + // 4: appellation
                "\"NAME\" TEXT," + // 5: name
                "\"BIRTHDAY\" TEXT," + // 6: birthday
                "\"POLITICAL_OUTLOOK\" TEXT," + // 7: politicalOutlook
                "\"WORK_UNIT\" TEXT," + // 8: workUnit
                "\"AGE\" INTEGER NOT NULL );"); // 9: age
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBGB_CADRE_FAMILY_MEMBER_LIST\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBGbCadreFamilyMemberList entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getMemberId());
        stmt.bindLong(3, entity.getBaseId());
 
        String cadreName = entity.getCadreName();
        if (cadreName != null) {
            stmt.bindString(4, cadreName);
        }
 
        String appellation = entity.getAppellation();
        if (appellation != null) {
            stmt.bindString(5, appellation);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
 
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(7, birthday);
        }
 
        String politicalOutlook = entity.getPoliticalOutlook();
        if (politicalOutlook != null) {
            stmt.bindString(8, politicalOutlook);
        }
 
        String workUnit = entity.getWorkUnit();
        if (workUnit != null) {
            stmt.bindString(9, workUnit);
        }
        stmt.bindLong(10, entity.getAge());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBGbCadreFamilyMemberList entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getMemberId());
        stmt.bindLong(3, entity.getBaseId());
 
        String cadreName = entity.getCadreName();
        if (cadreName != null) {
            stmt.bindString(4, cadreName);
        }
 
        String appellation = entity.getAppellation();
        if (appellation != null) {
            stmt.bindString(5, appellation);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
 
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(7, birthday);
        }
 
        String politicalOutlook = entity.getPoliticalOutlook();
        if (politicalOutlook != null) {
            stmt.bindString(8, politicalOutlook);
        }
 
        String workUnit = entity.getWorkUnit();
        if (workUnit != null) {
            stmt.bindString(9, workUnit);
        }
        stmt.bindLong(10, entity.getAge());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DBGbCadreFamilyMemberList readEntity(Cursor cursor, int offset) {
        DBGbCadreFamilyMemberList entity = new DBGbCadreFamilyMemberList( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.getInt(offset + 1), // memberId
            cursor.getInt(offset + 2), // baseId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // cadreName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // appellation
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // name
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // birthday
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // politicalOutlook
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // workUnit
            cursor.getInt(offset + 9) // age
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBGbCadreFamilyMemberList entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMemberId(cursor.getInt(offset + 1));
        entity.setBaseId(cursor.getInt(offset + 2));
        entity.setCadreName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAppellation(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setBirthday(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPoliticalOutlook(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setWorkUnit(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAge(cursor.getInt(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBGbCadreFamilyMemberList entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBGbCadreFamilyMemberList entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBGbCadreFamilyMemberList entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
