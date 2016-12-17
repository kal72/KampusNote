package com.singledev.kristiawan.kampusnote.presenter;

import android.content.Context;

import com.singledev.kristiawan.kampusnote.model.sqlite.Matakuliah;
import com.singledev.kristiawan.kampusnote.utils.AlarmReceiver;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ASUS on 28/09/2016.
 */

public class JadwalPresenterImp implements JadwalPresenter.AddListener, JadwalPresenter.GetListener, JadwalPresenter.ChangeAdapter, AlarmPresenter {
    private Context context;
    private JadwalView jadwalView;
    private int ID;

    public JadwalPresenterImp(JadwalView jadwalView) {
        this.jadwalView = jadwalView;
    }

    public void setContex(Context context) {
        this.context = context;
    }

    @Override
    public void addMakul(String nama, String jamMulai, String jamBerakhir, String ruangan, String hari, String date, String time, boolean active, boolean repeat) {
        if (nama.isEmpty() || jamMulai.isEmpty() || jamBerakhir.isEmpty() || ruangan.isEmpty() || hari.isEmpty() || date.isEmpty() || time.isEmpty()){
            jadwalView.onFailed("Input can not be empty!");
        }else {
            Matakuliah matakuliah = new Matakuliah(nama, jamMulai, jamBerakhir, ruangan, hari, date, time, active, repeat);
            matakuliah.save();
            ID = matakuliah.getId().intValue();

            Calendar mCalendar = Calendar.getInstance();
            mCalendar.set(Calendar.MONTH, 11);
            mCalendar.set(Calendar.YEAR, 2016);
            mCalendar.set(Calendar.DAY_OF_MONTH, 17);
            mCalendar.set(Calendar.HOUR_OF_DAY, 15);
            mCalendar.set(Calendar.MINUTE, 50);
            mCalendar.set(Calendar.SECOND, 0);

            new AlarmReceiver().setAlarm(context, mCalendar, ID);
            jadwalView.onSucces();
        }

        //System.out.println("++++++++++++++++++++++++++++++++++++ ID ---- "+ID);
    }

    @Override
    public void updateMakul(int id, String nama, String jamMulai, String jamBerakhir, String ruangan, String hari, String date, String time, boolean active, boolean repeat) {

        if (nama.isEmpty() || jamMulai.isEmpty() || jamBerakhir.isEmpty() || ruangan.isEmpty() || hari.isEmpty() || date.isEmpty() || time.isEmpty()){
            jadwalView.onFailed("Input can not be empty!");
        }else{
            Matakuliah mk = Matakuliah.findById(Matakuliah.class, id);
            mk.setNama(nama);
            mk.setJamMulai(jamMulai);
            mk.setJamBerakhir(jamBerakhir);
            mk.setRuangan(ruangan);
            mk.setHari(hari);
            mk.setDate(date);
            mk.setTime(time);
            mk.setActive(active);
            mk.setRepeat(repeat);
            mk.save();

            jadwalView.onSucces();
        }

    }

    @Override
    public void deleteMakul(long id) {
        String day;
        Matakuliah mk = Matakuliah.findById(Matakuliah.class, id);
        day = mk.getHari();
        mk.delete();

        getJadwal(day);
    }

    @Override
    public void getJadwal() {
        List<Matakuliah> matakuliahList = Matakuliah.listAll(Matakuliah.class);
        jadwalView.showLoadList(matakuliahList);
    }

    @Override
    public void getJadwal(String day) {
        System.out.println("+++++++++++++++++++++++++ "+day);
        List<Matakuliah> matakuliahList = Matakuliah.findWithQuery(Matakuliah.class, "Select * from Matakuliah where hari = ?", day);
        if (matakuliahList.isEmpty())
        {
            jadwalView.onFailed("");
        }else {
            jadwalView.onSucces();
            jadwalView.showLoadList(matakuliahList);
        }

    }

    @Override
    public void getJadwal(int id) {
        Matakuliah mk = Matakuliah.findById(Matakuliah.class, id);
        jadwalView.showMatakuliah(mk);
    }


    @Override
    public void setFragment(String day) {
        jadwalView.changeFragment(day);
    }

    @Override
    public void updateAlarm(AlarmView alarmView) {
        alarmView.onSetAlarmFinish();
    }

    @Override
    public void setAlarm(AlarmView alarmView) {
        alarmView.onSetAlarmFinish();
    }
}
