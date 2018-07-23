package com.dellyfl.betwinnersoccer;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StageMainActivity extends AppCompatActivity implements ListView.OnItemClickListener{
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
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mGeneralTitle[position].equals("Salir")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            mDrawerList.setItemChecked(position, true);
            setTitle(mGeneralTitle[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }

    }
/*
    private void selectItem(int position) {
        // Create a new fragment and specify the planet to show based on position
        Fragment fragment = new PlanetFragment();
        Bundle args = new Bundle();
        args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

    }
*/

}

