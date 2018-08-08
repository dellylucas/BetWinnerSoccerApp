package com.dellyfl.betwinnersoccer;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import data.PartAdapter;

public class PartFragment extends Fragment  implements View.OnClickListener {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List itemsE= new ArrayList();

        itemsE.add("Angel Beats");
        View view = inflater.inflate(R.layout.fragment_part, container, false);

        FloatingActionButton bcreapartid =  view.findViewById(R.id.butaddparty);
        bcreapartid.setOnClickListener(this);

        // Obtener el Recycler
        recycler = (RecyclerView) view.findViewById(R.id.recicladorpart);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(view.getContext());
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new PartAdapter(itemsE);
        recycler.setAdapter(adapter);

        return view;

    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
