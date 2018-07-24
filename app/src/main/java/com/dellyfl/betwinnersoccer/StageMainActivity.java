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

public class StageMainActivity extends AppCompatActivity implements ListView.OnItemClickListener, UsersFragment.OnFragmentInteractionListener, TableFragment.OnFragmentInteractionListener {
    private String[] mGeneralTitle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_main);
        fragmentManager = getSupportFragmentManager();

        Intent intent = getIntent();

        int IsAdm = (int) intent.getIntExtra("ADM",-1);
        if(IsAdm == 1){
            mGeneralTitle = getResources().getStringArray(R.array.adm_array);
        }else{
            mGeneralTitle = getResources().getStringArray(R.array.usr_array);
        }
        mGeneralTitle[0]=null;
        mDrawerLayout = (DrawerLayout) findViewById(R.id.LayMain);
        mDrawerList = (ListView) findViewById(R.id.leftDrawe);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item,R.id.text_list, mGeneralTitle));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(this);
        setTitle("Partidos");
       /* UsersFragment Usfragment = new UsersFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_stage,Usfragment).commit();*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mGeneralTitle[position].equals("Salir")){
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

        if(mGeneralTitle[position].equals("Usuarios")){
            tranu.replace(R.id.frame_stage,Usfragment);
            tranu.commit();
        }else if(mGeneralTitle[position].equals("Tabla")){
            tranu.replace(R.id.frame_stage,Tabfragment);
            tranu.commit();
        }

        mDrawerList.setItemChecked(position, true);
        setTitle(mGeneralTitle[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
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

