package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DBBmExplainBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBBM_EXPLAIN_BEAN".
*/
public class DBBmExplainBeanDao extends AbstractDao<DBBmExplainBean, Long> {

    public static final String TABLENAME = "DBBM_EXPLAIN_BEAN";

    /**
     * Properties of entity DBBmExplainBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property ExplainId = new Property(1, int.class, "explainId", false, "EXPLAIN_ID");
        public final static Property DeptId = new Property(2, int.class, "deptId", false, "DEPT_ID");
        public final static Property OrgExplain = new Property(3, String.class, "orgExplain", false, "ORG_EXPLAIN");
        public final static Property Year = new Property(4, int.class, "year", false, "YEAR");
    }


    public DBBmExplainBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DBBmExplainBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBBM_EXPLAIN_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"EXPLAIN_ID\" INTEGER NOT NULL ," + // 1: explainId
                "\"DEPT_ID\" INTEGER NOT NULL ," + // 2: deptId
                "\"ORG_EXPLAIN\" TEXT," + // 3: orgExplain
                "\"YEAR\" INTEGER NOT NULL );"); // 4: year
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBBM_EXPLAIN_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBBmExplainBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getExplainId());
        stmt.bindLong(3, entity.getDeptId());
 
        String orgExplain = entity.getOrgExplain();
        if (orgExplain != null) {
            stmt.bindString(4, orgExplain);
        }
        stmt.bindLong(5, entity.getYear());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBBmExplainBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getExplainId());
        stmt.bindLong(3, entity.getDeptId());
 
        String orgExplain = entity.getOrgExplain();
        if (orgExplain != null) {
            stmt.bindString(4, orgExplain);
        }
        stmt.bindLong(5, entity.getYear());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DBBmExplainBean readEntity(Cursor cursor, int offset) {
        DBBmExplainBean entity = new DBBmExplainBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.getInt(offset + 1), // explainId
            cursor.getInt(offset + 2), // deptId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // orgExplain
            cursor.getInt(offset + 4) // year
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBBmExplainBean entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setExplainId(cursor.getInt(offset + 1));
        entity.setDeptId(cursor.getInt(offset + 2));
        entity.setOrgExplain(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setYear(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBBmExplainBean entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBBmExplainBean entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBBmExplainBean entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
