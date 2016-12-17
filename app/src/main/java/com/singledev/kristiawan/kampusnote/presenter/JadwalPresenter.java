package com.singledev.kristiawan.kampusnote.presenter;

import com.singledev.kristiawan.kampusnote.model.sqlite.Matakuliah;

/**
 * Created by ASUS on 28/09/2016.
 */

public class JadwalPresenter {

   public interface AddListener{
       void addMakul(String nama, String jamMulai, String jamBerakhir, String ruangan, String hari, String date, String time, boolean active, boolean repeat);
       void updateMakul(int id, String nama, String jamMulai, String jamBerakhir, String ruangan, String hari, String date, String time, boolean active, boolean repeat);
       void deleteMakul(long id);
   }

    public interface GetListener{
        void getJadwal();
        void getJadwal(String day);
        void getJadwal(int id);
    }


    public interface ChangeAdapter{
        void setFragment(String day);
    }
}
