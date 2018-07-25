package com.dellyfl.betwinnersoccer;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import data.UsersContract;
import data.UsersDbHelpe;


public class UsersFragment extends Fragment {

    private ListView ListUser;
    private UsersDbHelpe sd;

    public UsersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        sd = new UsersDbHelpe(view.getContext());
        Cursor cu_local = sd.AllUsers();
        ArrayList<String> est= new ArrayList<>();
        if( cu_local.moveToFirst()){
            do{
                est.add(cu_local.getString(cu_local.getColumnIndex(UsersContract.UsersEntry.NAME)));
            } while(cu_local.moveToNext());
        }

        ListUser = (ListView) view.findViewById(R.id.ListUsersDef);
        ListUser.setAdapter(new ArrayAdapter<String>(view.getContext(),
                R.layout.users_list,R.id.textView_users, est));
        // Set the list's click listener
      //  ListUser.setOnItemClickListener(this);

        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
