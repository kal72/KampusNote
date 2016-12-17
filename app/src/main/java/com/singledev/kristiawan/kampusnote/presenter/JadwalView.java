package com.singledev.kristiawan.kampusnote.presenter;

import android.support.annotation.Nullable;

import com.orm.dsl.Ignore;
import com.singledev.kristiawan.kampusnote.model.sqlite.Matakuliah;

import java.util.List;

/**
 * Created by ASUS on 28/09/2016.
 */

public interface JadwalView {

    void onSucces();

    void onFailed(String message);

    void showLoadList(List<Matakuliah> makulList);

    void showMatakuliah(Matakuliah mk);

    void changeFragment(String day);

    public interface onDeleteListener{
        void onDeleteSucces();
    }

}
