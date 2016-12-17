package com.singledev.kristiawan.kampusnote.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.singledev.kristiawan.kampusnote.R;
import com.singledev.kristiawan.kampusnote.adapter.JadwalAdapter;
import com.singledev.kristiawan.kampusnote.adapter.JadwalAdapter2;
import com.singledev.kristiawan.kampusnote.model.sqlite.Matakuliah;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenterImp;
import com.singledev.kristiawan.kampusnote.presenter.JadwalView;
import com.singledev.kristiawan.kampusnote.presenter.MainView;

import java.util.List;


public class JadwalFragment extends Fragment implements JadwalView{
    JadwalAdapter adapter;
    RecyclerView recyclerView;
    View v;
    MainView mainView;
    RelativeLayout mainMessage;

    public JadwalFragment() {
    }

    public static JadwalFragment newInstance(MainView mainView) {
        JadwalFragment fragment = new JadwalFragment();
        fragment.setView(mainView);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_jadwal, container, false);
        mainMessage = (RelativeLayout)v.findViewById(R.id.main_notif);
        adapter = new JadwalAdapter(getContext(), this);
        recyclerView =(RecyclerView)v.findViewById(R.id.recycler_jadwal);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        JadwalPresenterImp imp = new JadwalPresenterImp(this);
        imp.getJadwal();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void setView(MainView mainView){
        this.mainView = mainView;
    }


    @Override
    public void onSucces() {
        mainMessage.setVisibility(View.GONE);
    }

    @Override
    public void onFailed(String message) {
        mainMessage.setVisibility(View.VISIBLE);
        //Toast.makeText(getContext(), "Data kosong",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoadList(List<Matakuliah> makulList) {
        adapter.add(makulList);
    }

    @Override
    public void showMatakuliah(Matakuliah mk) {

    }

    @Override
    public void changeFragment(String day) {
        FragmentTransaction trans = getFragmentManager()
                .beginTransaction();
        trans.replace(R.id.root_fragment, JadwalFragment2.newInstance(mainView, day));
        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        trans.addToBackStack(null);
        trans.commit();
    }


}
