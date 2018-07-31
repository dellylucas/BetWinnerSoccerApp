package com.dellyfl.betwinnersoccer;



import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
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
    private UsersFragment Usfragment;
    private TableFragment Tabfragment;
    private PartFragment Parfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_main);
        fragmentManager = getSupportFragmentManager();
        Usfragment = new UsersFragment();
        Tabfragment = new TableFragment();
        Parfragment = new PartFragment();
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

       getSupportFragmentManager().beginTransaction().add(R.id.frame_stage,Parfragment).commit();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mGeneralTitle.get(position).equals("Salir")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Fragment fr = getSupportFragmentManager().findFragmentByTag("IDUSER");

            FragmentTransaction tranu = fragmentManager.beginTransaction();
            if (fr != null) {
                tranu.remove(fr);
            }
            selectItem(position,tranu);
        }

    }

    private void selectItem(int position,FragmentTransaction tranu) {

        mDrawerList.setItemChecked(position, true);
        setTitle(mGeneralTitle.get(position));
        mDrawerLayout.closeDrawer(mDrawerList);

        switch (mGeneralTitle.get(position)){
            case "Partidos":
                MenuReGenerate("Partidos");
                Parfragment = new PartFragment();
                tranu.replace(R.id.frame_stage,Parfragment, "PART");
                tranu.commit();
                break;
            case "Usuarios":
                MenuReGenerate("Usuarios");
                Usfragment=new UsersFragment();
                tranu.replace(R.id.frame_stage,Usfragment, "USER");
                tranu.commit();
                break;
            case "Tabla":
                MenuReGenerate("Tabla");
                Tabfragment= new TableFragment();
                tranu.replace(R.id.frame_stage,Tabfragment, "TABLE");
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
                Fragment fr = getSupportFragmentManager().findFragmentByTag("IDUSER");
                if (fr != null && fr.isVisible()) {
                    getSupportFragmentManager()
                            .beginTransaction().setTransition(0).remove(fr).disallowAddToBackStack().show(fr).commit();

                    Usfragment = new UsersFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_stage,Usfragment, "USER")
                            .setCustomAnimations(R.anim.anim_iz_to_der,0)
                            .show(Usfragment)
                            .commit();
               }
            }

        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

