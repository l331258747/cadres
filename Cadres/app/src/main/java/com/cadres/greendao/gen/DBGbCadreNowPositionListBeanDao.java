package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBGB_CADRE_NOW_POSITION_LIST_BEAN".
*/
public class DBGbCadreNowPositionListBeanDao extends AbstractDao<DBGbCadreNowPositionListBean, Long> {

    public static final String TABLENAME = "DBGB_CADRE_NOW_POSITION_LIST_BEAN";

    /**
     * Properties of entity DBGbCadreNowPositionListBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property PositionId = new Property(1, int.class, "positionId", false, "POSITION_ID");
        public final static Property DeptId = new Property(2, int.class, "deptId", false, "DEPT_ID");
        public final static Property DeptName = new Property(3, String.class, "deptName", false, "DEPT_NAME");
        public final static Property BaseId = new Property(4, int.class, "baseId", false, "BASE_ID");
        public final static Property CadreName = new Property(5, String.class, "cadreName", false, "CADRE_NAME");
        public final static Property PositionTime = new Property(6, String.class, "positionTime", false, "POSITION_TIME");
        public final static Property Position = new Property(7, String.class, "position", false, "POSITION");
        public final static Property PositionTitle = new Property(8, int.class, "positionTitle", false, "POSITION_TITLE");
        public final static Property PositionTitleName = new Property(9, String.class, "positionTitleName", false, "POSITION_TITLE_NAME");
        public final static Property PositionReason = new Property(10, String.class, "positionReason", false, "POSITION_REASON");
        public final static Property PositionFileNumber = new Property(11, String.class, "positionFileNumber", false, "POSITION_FILE_NUMBER");
        public final static Property DutiesRank = new Property(12, String.class, "dutiesRank", false, "DUTIES_RANK");
        public final static Property VacantPosition = new Property(13, String.class, "vacantPosition", false, "VACANT_POSITION");
    }


    public DBGbCadreNowPositionListBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DBGbCadreNowPositionListBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBGB_CADRE_NOW_POSITION_LIST_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"POSITION_ID\" INTEGER NOT NULL ," + // 1: positionId
                "\"DEPT_ID\" INTEGER NOT NULL ," + // 2: deptId
                "\"DEPT_NAME\" TEXT," + // 3: deptName
                "\"BASE_ID\" INTEGER NOT NULL ," + // 4: baseId
                "\"CADRE_NAME\" TEXT," + // 5: cadreName
                "\"POSITION_TIME\" TEXT," + // 6: positionTime
                "\"POSITION\" TEXT," + // 7: position
                "\"POSITION_TITLE\" INTEGER NOT NULL ," + // 8: positionTitle
                "\"POSITION_TITLE_NAME\" TEXT," + // 9: positionTitleName
                "\"POSITION_REASON\" TEXT," + // 10: positionReason
                "\"POSITION_FILE_NUMBER\" TEXT," + // 11: positionFileNumber
                "\"DUTIES_RANK\" TEXT," + // 12: dutiesRank
                "\"VACANT_POSITION\" TEXT);"); // 13: vacantPosition
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBGB_CADRE_NOW_POSITION_LIST_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBGbCadreNowPositionListBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getPositionId());
        stmt.bindLong(3, entity.getDeptId());
 
        String deptName = entity.getDeptName();
        if (deptName != null) {
            stmt.bindString(4, deptName);
        }
        stmt.bindLong(5, entity.getBaseId());
 
        String cadreName = entity.getCadreName();
        if (cadreName != null) {
            stmt.bindString(6, cadreName);
        }
 
        String positionTime = entity.getPositionTime();
        if (positionTime != null) {
            stmt.bindString(7, positionTime);
        }
 
        String position = entity.getPosition();
        if (position != null) {
            stmt.bindString(8, position);
        }
        stmt.bindLong(9, entity.getPositionTitle());
 
        String positionTitleName = entity.getPositionTitleName();
        if (positionTitleName != null) {
            stmt.bindString(10, positionTitleName);
        }
 
        String positionReason = entity.getPositionReason();
        if (positionReason != null) {
            stmt.bindString(11, positionReason);
        }
 
        String positionFileNumber = entity.getPositionFileNumber();
        if (positionFileNumber != null) {
            stmt.bindString(12, positionFileNumber);
        }
 
        String dutiesRank = entity.getDutiesRank();
        if (dutiesRank != null) {
            stmt.bindString(13, dutiesRank);
        }
 
        String vacantPosition = entity.getVacantPosition();
        if (vacantPosition != null) {
            stmt.bindString(14, vacantPosition);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBGbCadreNowPositionListBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getPositionId());
        stmt.bindLong(3, entity.getDeptId());
 
        String deptName = entity.getDeptName();
        if (deptName != null) {
            stmt.bindString(4, deptName);
        }
        stmt.bindLong(5, entity.getBaseId());
 
        String cadreName = entity.getCadreName();
        if (cadreName != null) {
            stmt.bindString(6, cadreName);
        }
 
        String positionTime = entity.getPositionTime();
        if (positionTime != null) {
            stmt.bindString(7, positionTime);
        }
 
        String position = entity.getPosition();
        if (position != null) {
            stmt.bindString(8, position);
        }
        stmt.bindLong(9, entity.getPositionTitle());
 
        String positionTitleName = entity.getPositionTitleName();
        if (positionTitleName != null) {
            stmt.bindString(10, positionTitleName);
        }
 
        String positionReason = entity.getPositionReason();
        if (positionReason != null) {
            stmt.bindString(11, positionReason);
        }
 
        String positionFileNumber = entity.getPositionFileNumber();
        if (positionFileNumber != null) {
            stmt.bindString(12, positionFileNumber);
        }
 
        String dutiesRank = entity.getDutiesRank();
        if (dutiesRank != null) {
            stmt.bindString(13, dutiesRank);
        }
 
        String vacantPosition = entity.getVacantPosition();
        if (vacantPosition != null) {
            stmt.bindString(14, vacantPosition);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DBGbCadreNowPositionListBean readEntity(Cursor cursor, int offset) {
        DBGbCadreNowPositionListBean entity = new DBGbCadreNowPositionListBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.getInt(offset + 1), // positionId
            cursor.getInt(offset + 2), // deptId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // deptName
            cursor.getInt(offset + 4), // baseId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // cadreName
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // positionTime
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // position
            cursor.getInt(offset + 8), // positionTitle
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // positionTitleName
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // positionReason
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // positionFileNumber
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // dutiesRank
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13) // vacantPosition
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBGbCadreNowPositionListBean entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPositionId(cursor.getInt(offset + 1));
        entity.setDeptId(cursor.getInt(offset + 2));
        entity.setDeptName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBaseId(cursor.getInt(offset + 4));
        entity.setCadreName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPositionTime(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPosition(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPositionTitle(cursor.getInt(offset + 8));
        entity.setPositionTitleName(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPositionReason(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPositionFileNumber(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setDutiesRank(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setVacantPosition(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBGbCadreNowPositionListBean entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBGbCadreNowPositionListBean entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBGbCadreNowPositionListBean entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
