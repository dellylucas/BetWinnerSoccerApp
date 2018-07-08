package com.dellyfl.betwinnersoccer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        findViewById(R.id.butNew);
    }

    public void CreateBDUser(View v){
        setContentView(R.layout.activity_main);
    }
}
