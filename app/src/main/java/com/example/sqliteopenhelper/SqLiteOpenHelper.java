package com.example.sqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ContactDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACT = "Contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "Name";
    private static final String KEY_PHONE_NO = "Phone";

    public SqLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // create table id
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_CONTACT +
                "(" + KEY_ID + " INTIGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT, " + KEY_PHONE_NO + " TEXT NOT NULL");

        SQLiteDatabase database = this.getWritableDatabase();

        database.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(sqLiteDatabase);
    }
}
