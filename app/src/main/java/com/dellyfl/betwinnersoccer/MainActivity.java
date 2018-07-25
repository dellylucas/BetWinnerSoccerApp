package com.dellyfl.betwinnersoccer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
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
        v_pass_text = findViewById(R.id.tbPassIn);
        v_user_text = findViewById(R.id.tbUser);
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
        if (hol == 1 || hol == 0 ) {
            Intent intent = new Intent(this, StageMainActivity.class);
            intent.putExtra("ADM", hol);
            startActivity(intent);
            finish();

        } else {
            tex = "ERROR User or password!";
            int durac= Toast.LENGTH_LONG;
            toas = Toast.makeText(this,tex,durac);
            toas = Toast.makeText(this,tex,durac);
            toas.show();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    public void NewUser(View v){
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }
}
