package com.example.sqliteopenhelper;

import android.content.ContentValues;
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
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT, " + KEY_PHONE_NO + " TEXT NOT NULL );");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(sqLiteDatabase);
    }

    public void addContact(String name, String phone_no){
        SQLiteDatabase db =  this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_PHONE_NO,phone_no);

        db.insert(TABLE_CONTACT, null,values);

    }
}
