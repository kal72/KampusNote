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
import com.singledev.kristiawan.kampusnote.adapter.CatatanAdapter;
import com.singledev.kristiawan.kampusnote.adapter.JadwalAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatatanFragment extends Fragment {


    public CatatanFragment() {
        // Required empty public constructor
    }

    public static CatatanFragment newInstance() {
        CatatanFragment fragment = new CatatanFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_catatan, container, false);
        CatatanAdapter adapter = new CatatanAdapter();
        RecyclerView recyclerView =(RecyclerView)v.findViewById(R.id.rv_catatan);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        return v;
    }

}
