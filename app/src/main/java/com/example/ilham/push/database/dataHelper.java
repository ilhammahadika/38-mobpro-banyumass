package com.example.ilham.push.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ilham on 03/12/2016.
 */

public class DataHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Property.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DataContract.TABLE_NAME + " (" +
                    DataContract._ID + " INTEGER PRIMARY KEY, " +
                    DataContract.COLUMN_NAME_TITLE + " TEXT, " +
                    DataContract.COLUMN_NAME_ADDRESS + "TEXT, " +
                    DataContract.COLUMN_NAME_TELP + "TEXT, " +
                    " )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DataContract.TABLE_NAME;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
