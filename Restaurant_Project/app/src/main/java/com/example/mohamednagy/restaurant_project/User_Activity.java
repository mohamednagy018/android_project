package com.example.mohamednagy.restaurant_project;

import android.app.ActionBar;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class User_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_layout);
        Bundle bundle = getIntent().getExtras();
        Profile fragobj = new Profile();
        fragobj.setArguments(bundle);

    }
}
