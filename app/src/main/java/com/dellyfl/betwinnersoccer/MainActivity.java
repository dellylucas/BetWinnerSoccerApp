package com.dellyfl.betwinnersoccer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import data.UsersDbHelpe;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    UsersDbHelpe sd;
    private TextView v_user_text;
    private TextView v_pass_text;

    @Override
    protected void onCreate  (Bundle savedInstanceState) {
        Stetho.initializeWithDefaults(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v_user_text =(TextView) findViewById(R.id.tbUser);
        v_pass_text =(TextView) findViewById(R.id.tbPassIn);
        //create DB
        sd = new UsersDbHelpe(this);

        Button buttonNewUser = findViewById(R.id.butLog);
        buttonNewUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int hol = sd.LogIn(v_user_text.getText().toString(),v_pass_text.getText().toString());
        Toast toas;
        String tex;
        if (hol == 1 ) {

            tex = "User valid OK!!";

        } else {
            tex = "ERROR not ACCESS!";
            Intent intent = new Intent(this, StageMainActivity.class);
            startActivity(intent);

        }

        int durac= Toast.LENGTH_LONG;
        toas = Toast.makeText(this,tex,durac);
        toas = Toast.makeText(this,tex,durac);
        toas.show();
    }

    public void NewUser(View v){
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }
}
