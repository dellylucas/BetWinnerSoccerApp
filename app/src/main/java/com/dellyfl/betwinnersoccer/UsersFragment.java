package com.dellyfl.betwinnersoccer;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import data.UsersContract;
import data.UsersDbHelpe;


public class UsersFragment extends Fragment implements ListView.OnItemClickListener, IdUserFragment.OnFragmentInteractionListener {
  //  public FragmentManager fragmentManager;
private FragmentManager   fragmentManager;
    public UsersFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_users, container, false);
        UsersDbHelpe sd = new UsersDbHelpe(view.getContext());
        Cursor cu_local = sd.AllUsers();
        ArrayList<String> est= new ArrayList<>();
        if( cu_local.moveToFirst()){
            do{
                est.add(cu_local.getString(cu_local.getColumnIndex(UsersContract.UsersEntry.NAME)));
            } while(cu_local.moveToNext());
        }

        ListView listUser = (ListView) view.findViewById(R.id.ListUsersDef);
        listUser.setAdapter(new ArrayAdapter<String>(view.getContext(),
                R.layout.users_list,R.id.textView_users, est));
        listUser.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        fragmentManager=  getActivity().getSupportFragmentManager();

        FragmentTransaction tranu = fragmentManager.beginTransaction();
        tranu.hide(this);
        IdUserFragment idusfragment = new IdUserFragment();
        tranu.replace(R.id.idusersFragment,idusfragment,"IDUSER");
        tranu.setCustomAnimations(R.anim.anim_der_to_iz,R.anim.anim_exit,R.anim.anim_der_to_iz,R.anim.anim_exit);
        tranu.show(idusfragment).addToBackStack(null).commit();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
