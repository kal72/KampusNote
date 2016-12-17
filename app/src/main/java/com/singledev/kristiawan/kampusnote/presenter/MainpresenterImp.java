package com.singledev.kristiawan.kampusnote.presenter;

import android.support.v4.app.Fragment;

/**
 * Created by ASUS on 02/10/2016.
 */

public class MainpresenterImp implements MainPresenter{
    MainView mainView;

    public MainpresenterImp(MainView mainView) {
        this.mainView = mainView;
    }


    @Override
    public void fragmentChanged(int statusfragment) {

    }
}
