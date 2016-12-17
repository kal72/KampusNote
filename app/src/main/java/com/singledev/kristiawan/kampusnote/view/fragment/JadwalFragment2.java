package com.singledev.kristiawan.kampusnote.view.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalFragment2 extends Fragment implements JadwalView{
    private JadwalAdapter2 adapter;
    private View v;
    private RecyclerView recyclerView;
    private String day;
    private MainView mainView;
    private RelativeLayout mainMessage;

    public JadwalFragment2() {

    }

    @SuppressLint("ValidFragment")
    public JadwalFragment2(MainView mainView, String day) {
        this.mainView = mainView;
        this.day = day;
    }

    public static JadwalFragment2 newInstance(MainView mainView, String days) {
        JadwalFragment2 fragment = new JadwalFragment2(mainView, days);
        fragment.setView(mainView);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.jadwal_fragment2, container, false);
        mainMessage = (RelativeLayout)v.findViewById(R.id.main_notif);
        adapter = new JadwalAdapter2(getContext(), this);
        recyclerView =(RecyclerView)v.findViewById(R.id.recycler_jadwal2);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        JadwalPresenterImp imp = new JadwalPresenterImp(this);
        imp.getJadwal(day);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        JadwalPresenterImp imp = new JadwalPresenterImp(this);
        imp.getJadwal(day);

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
        System.out.println("======================"+makulList.size());
//        for (Matakuliah mk : makulList){
//            System.out.println("======================"+mk.getHari());
//            adapter.addList(mk);
//        }
        adapter.addList(makulList);
    }

    @Override
    public void showMatakuliah(Matakuliah mk) {

    }

    @Override
    public void changeFragment(String day) {
        FragmentTransaction trans = getFragmentManager()
                .beginTransaction();
        trans.replace(R.id.root_fragment, JadwalFragment.newInstance(mainView));
        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        trans.addToBackStack(null);
        trans.commit();
    }
}
