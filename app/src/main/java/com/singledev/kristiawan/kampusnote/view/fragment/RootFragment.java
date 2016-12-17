package com.singledev.kristiawan.kampusnote.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.singledev.kristiawan.kampusnote.R;
import com.singledev.kristiawan.kampusnote.presenter.MainView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RootFragment extends Fragment {
    MainView mainView;

    public RootFragment() {
        // Required empty public constructor
    }

    public static RootFragment newInstance(MainView mainView) {
        RootFragment fragment = new RootFragment();
        fragment.setView(mainView);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_root, container, false);;
        // Inflate the layout for this fragment

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();
        transaction.replace(R.id.root_fragment, JadwalFragment.newInstance(mainView));
        transaction.commit();
        return v;
    }

    public void setView(MainView mainView){
        this.mainView = mainView;
    }

}
