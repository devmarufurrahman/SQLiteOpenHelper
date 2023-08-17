package com.example.sqliteopenhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqLiteOpenHelper dbHelper = new SqLiteOpenHelper(this);
        dbHelper.addContact("Noman","01757474700");
        dbHelper.addContact("Maruf","01757474145");
        dbHelper.addContact("Shakil","01789977895");
    }
}