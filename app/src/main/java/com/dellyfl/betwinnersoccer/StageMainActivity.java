package com.dellyfl.betwinnersoccer;



import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StageMainActivity extends AppCompatActivity implements ListView.OnItemClickListener, UsersFragment.OnFragmentInteractionListener, TableFragment.OnFragmentInteractionListener {
    private List<String> mGeneralTitle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private FragmentManager fragmentManager;
    private int IsAdm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_main);
        fragmentManager = getSupportFragmentManager();

        Intent intent = getIntent();

        IsAdm = (int) intent.getIntExtra("ADM",-1);

        if(IsAdm == 1){
            mGeneralTitle =  new ArrayList<>( Arrays.asList(getResources().getStringArray(R.array.adm_array)));
        }else{
            mGeneralTitle = new ArrayList<>( Arrays.asList(getResources().getStringArray(R.array.usr_array)));
        }
            mGeneralTitle.remove(0);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.LayMain);
        mDrawerList = (ListView) findViewById(R.id.leftDrawe);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item,R.id.text_list, mGeneralTitle));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(this);
        super.setTitle("Partidos");

       /* UsersFragment Usfragment = new UsersFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_stage,Usfragment).commit();*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mGeneralTitle.get(position).equals("Salir")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            FragmentTransaction tranu = fragmentManager.beginTransaction();
            selectItem(position,tranu);
        }

    }

    private void selectItem(int position,FragmentTransaction tranu) {
     //   FragmentTransaction tranu = getSupportFragmentManager().beginTransaction();
        UsersFragment Usfragment = new UsersFragment();
        TableFragment Tabfragment = new TableFragment();

        mDrawerList.setItemChecked(position, true);
        setTitle(mGeneralTitle.get(position));
        mDrawerLayout.closeDrawer(mDrawerList);

        switch (mGeneralTitle.get(position)){
            case "Partidos":
                MenuReGenerate("Partidos");
                break;
            case "Usuarios":
                MenuReGenerate("Usuarios");
                tranu.replace(R.id.frame_stage,Usfragment);
                tranu.commit();
                break;
            case "Tabla":
                MenuReGenerate("Tabla");
                tranu.replace(R.id.frame_stage,Tabfragment);
                tranu.commit();
                break;
            case "Configuracion":
                MenuReGenerate("Configuracion");
                break;
        }
    }

    private void MenuReGenerate(String name) {
        if(IsAdm == 1){
            mGeneralTitle =  new ArrayList<>( Arrays.asList(getResources().getStringArray(R.array.adm_array)));
        }else{
            mGeneralTitle = new ArrayList<>( Arrays.asList(getResources().getStringArray(R.array.usr_array)));
        }
        mGeneralTitle.remove(name);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item,R.id.text_list, mGeneralTitle));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

