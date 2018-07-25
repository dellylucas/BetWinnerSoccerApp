package com.dellyfl.betwinnersoccer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import data.Users;
import data.UsersDbHelpe;

public class NewUserActivity extends AppCompatActivity {
    private TextView user_text;
    private TextView telephone_text;
    private TextView email_text;
    private TextView pass_text;
    UsersDbHelpe sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sd = new UsersDbHelpe(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        user_text =(TextView) findViewById(R.id.tbName);
        telephone_text =(TextView) findViewById(R.id.tbTelephone);
        email_text =(TextView) findViewById(R.id.tbEmail);
        pass_text =(TextView) findViewById(R.id.tbPass);

    }

    public void CreateBDUser(View v){
        Boolean adm= false;
         int regis = sd.CountReg();
        if (regis == 0 ){
            adm=true;
        }
        Users newUserA =  new Users(user_text.getText().toString(), telephone_text.getText().toString(),
                adm, pass_text.getText().toString(),email_text.getText().toString());

       long lo = sd.InsertUser(newUserA);
        Toast toas;
        String tex;
        if (lo > 0 ){
            tex ="User "+user_text.getText().toString()+ " Created succesfull";
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {tex="error not created!";
        }
        int durac= Toast.LENGTH_LONG;
        toas = Toast.makeText(this,tex,durac);
        toas = Toast.makeText(this,tex,durac);
        toas.show();

    }
}
