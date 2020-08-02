package com.cadres.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cadres.beanDB.DBBmOrgTypeBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBBM_ORG_TYPE_BEAN".
*/
public class DBBmOrgTypeBeanDao extends AbstractDao<DBBmOrgTypeBean, Long> {

    public static final String TABLENAME = "DBBM_ORG_TYPE_BEAN";

    /**
     * Properties of entity DBBmOrgTypeBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property DictLabel = new Property(1, String.class, "dictLabel", false, "DICT_LABEL");
        public final static Property DictValue = new Property(2, String.class, "dictValue", false, "DICT_VALUE");
    }


    public DBBmOrgTypeBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DBBmOrgTypeBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBBM_ORG_TYPE_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"DICT_LABEL\" TEXT," + // 1: dictLabel
                "\"DICT_VALUE\" TEXT);"); // 2: dictValue
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBBM_ORG_TYPE_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBBmOrgTypeBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String dictLabel = entity.getDictLabel();
        if (dictLabel != null) {
            stmt.bindString(2, dictLabel);
        }
 
        String dictValue = entity.getDictValue();
        if (dictValue != null) {
            stmt.bindString(3, dictValue);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBBmOrgTypeBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String dictLabel = entity.getDictLabel();
        if (dictLabel != null) {
            stmt.bindString(2, dictLabel);
        }
 
        String dictValue = entity.getDictValue();
        if (dictValue != null) {
            stmt.bindString(3, dictValue);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DBBmOrgTypeBean readEntity(Cursor cursor, int offset) {
        DBBmOrgTypeBean entity = new DBBmOrgTypeBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // dictLabel
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // dictValue
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBBmOrgTypeBean entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDictLabel(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDictValue(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBBmOrgTypeBean entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBBmOrgTypeBean entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBBmOrgTypeBean entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}