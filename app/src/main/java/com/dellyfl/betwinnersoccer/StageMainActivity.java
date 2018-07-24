package com.dellyfl.betwinnersoccer;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StageMainActivity extends AppCompatActivity implements ListView.OnItemClickListener, UsersFragment.OnFragmentInteractionListener, TableFragment.OnFragmentInteractionListener {
    private String[] mGeneralTitle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_main);

        Intent intent = getIntent();

        int IsAdm = (int) intent.getIntExtra("ADM",-1);
        if(IsAdm == 1){
            mGeneralTitle = getResources().getStringArray(R.array.adm_array);
        }else{
            mGeneralTitle = getResources().getStringArray(R.array.usr_array);
        }
        mDrawerLayout = (DrawerLayout) findViewById(R.id.LayMain);
        mDrawerList = (ListView) findViewById(R.id.leftDrawe);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item,R.id.text_list, mGeneralTitle));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(this);
        UsersFragment Usfragment = new UsersFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_stage,Usfragment).commit();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mGeneralTitle[position].equals("Salir")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        UsersFragment Usfragment = new UsersFragment();
        TableFragment Tabfragment = new TableFragment();

        if(position ==0){
            FragmentTransaction tranu = getSupportFragmentManager().beginTransaction();
            tranu.replace(R.id.frame_stage,Usfragment);
            tranu.commit();
        }else if(position ==1){
            FragmentTransaction tranus = getSupportFragmentManager().beginTransaction();
            tranus.replace(R.id.frame_stage,Tabfragment);
            tranus.commit();
        }


        getSupportFragmentManager().beginTransaction().add(R.id.frame_stage,Usfragment);

/*
        Bundle args = new Bundle();
        args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
        Usfragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_stage, Usfragment)
                .commit();*/

        mDrawerList.setItemChecked(position, true);
        setTitle(mGeneralTitle[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

