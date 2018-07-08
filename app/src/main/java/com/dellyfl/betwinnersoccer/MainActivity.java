package com.dellyfl.betwinnersoccer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.stetho.Stetho;

import data.UsersContract;
import data.UsersDbHelpe;

import static data.UsersContract.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    UsersDbHelpe sd;

    @Override
    protected void onCreate  (Bundle savedInstanceState) {
        Stetho.initializeWithDefaults(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create DB
        sd = new UsersDbHelpe(this);

        Button buttonNewUser = findViewById(R.id.butLog);
        buttonNewUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
String hol = "er";

    }

    public void NewUser(View v){
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }
}
