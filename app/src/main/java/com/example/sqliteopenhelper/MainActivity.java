package com.example.sqliteopenhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqLiteOpenHelper dbHelper = new SqLiteOpenHelper(this);
//        dbHelper.addContact("Noman","01757474700");
//        dbHelper.addContact("Maruf","01757474145");
//        dbHelper.addContact("Shakil","01789977895");


        // Update query
//            contactModel model = new contactModel();
//            model.id = 1;
//            model.name = "Noman";
//            model.phone_no = "99999999999";
//
//            dbHelper.updateContacts(model);


        // Delete query data
        dbHelper.DeleteContacts(12);
        dbHelper.DeleteContacts(10);
        dbHelper.DeleteContacts(11);


        ArrayList<contactModel> arrContacts = dbHelper.fetchData();
        for (int i = 0; i<arrContacts.size();i++)
            Log.d("Contact info", "Name: " + arrContacts.get(i).name + ", phone: " + arrContacts.get(i).phone_no);
    }
}