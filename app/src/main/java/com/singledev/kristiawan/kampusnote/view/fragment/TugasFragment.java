package com.singledev.kristiawan.kampusnote.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.singledev.kristiawan.kampusnote.R;
import com.singledev.kristiawan.kampusnote.adapter.JadwalAdapter;
import com.singledev.kristiawan.kampusnote.adapter.TugasAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TugasFragment extends Fragment {


    public TugasFragment() {
        // Required empty public constructor
    }

    public static TugasFragment newInstance() {
        TugasFragment fragment = new TugasFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tugas, container, false);
        TugasAdapter adapter = new TugasAdapter();
        RecyclerView recyclerView =(RecyclerView)v.findViewById(R.id.rv_tugas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        return v;
    }

}
