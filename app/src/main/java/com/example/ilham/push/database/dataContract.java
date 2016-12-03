package com.example.ilham.push.database;

import android.provider.BaseColumns;

/**
 * Created by ilham on 03/12/2016.
 */

public class DataContract implements BaseColumns {

    public static final String TABLE_NAME = "wishlist";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_ADDRESS = "address";
    public static final String COLUMN_NAME_TELP = "telp";

    public DataContract() {
    }
}
