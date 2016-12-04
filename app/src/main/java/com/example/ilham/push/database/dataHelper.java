package com.example.ilham.push.database;

import android.content.Context;
import android.database.Cursor;
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
                    DataContract.COLUMN_NAME_ALAMAT + " TEXT, " +
                    DataContract.COLUMN_NAME_HARGA + " TEXT, " +
                    DataContract.COLUMN_NAME_TELP + " TEXT " +
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


    public Cursor getData(){
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                DataContract._ID,
                DataContract.COLUMN_NAME_TITLE,
                DataContract.COLUMN_NAME_ALAMAT,
                DataContract.COLUMN_NAME_HARGA,
                DataContract.COLUMN_NAME_TELP
        };

/*// Filter results WHERE "title" = 'My Title'
        String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArgs = { "My Title" };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";*/

        Cursor c = db.query(
                DataContract.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        return c;
    }
}
