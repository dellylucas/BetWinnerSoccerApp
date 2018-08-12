package com.dellyfl.betwinnersoccer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class IdUserFragment extends Fragment {


    public IdUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_id_user, container, false);
        return view;
    }

    @Override
    public void onDestroyView() {

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setTransition( FragmentTransaction.TRANSIT_EXIT_MASK )
                .show( this )
                .commit();
            super.onDestroyView();
    }


    public interface OnFragmentInteractionListener {
    }
}
