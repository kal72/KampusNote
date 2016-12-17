package com.singledev.kristiawan.kampusnote;

import android.app.Activity;
import android.content.Context;

import com.singledev.kristiawan.kampusnote.model.sqlite.Matakuliah;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenter;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenterImp;
import com.singledev.kristiawan.kampusnote.presenter.JadwalView;

import org.junit.Test;

import java.util.List;

/**
 * Created by ASUS on 17/11/2016.
 */

public class FormJadwalViewTest implements JadwalView {

    @Test
    public void main(){
        JadwalPresenterImp imp = new JadwalPresenterImp(this);
    }

    @Override
    public void onSucces() {

    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void showLoadList(List<Matakuliah> makulList) {

    }

    @Override
    public void showMatakuliah(Matakuliah mk) {

    }

    @Override
    public void changeFragment(String day) {

    }
}
