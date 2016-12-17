package com.singledev.kristiawan.kampusnote.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.singledev.kristiawan.kampusnote.R;
import com.singledev.kristiawan.kampusnote.helper.DateHelper;
import com.singledev.kristiawan.kampusnote.model.sqlite.Matakuliah;
import com.singledev.kristiawan.kampusnote.presenter.AlarmView;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenterImp;
import com.singledev.kristiawan.kampusnote.presenter.JadwalView;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ASUS on 04/10/2016.
 */

public class FormEditJadwalActivity extends AppCompatActivity implements JadwalView, AlarmView, View.OnClickListener, TimePickerDialog.OnTimeSetListener{
    Button save;
    EditText makul;
    EditText jamMulai;
    EditText jamSelesai;
    EditText ruangan;
    AppCompatCheckBox alarmOn;
    TextView mTime;
    SwitchCompat mRepeat;
    TextView txtRepeat;
    LinearLayout linearTime;
    JadwalPresenterImp jadwalPresenterImp;

    public static final String EXTRA_REMINDER_ID = "Reminder_ID";
    private static final long milMinute = 60000L;
    private static final long milHour = 3600000L;
    private static final long milDay = 86400000L;
    private static final long milWeek = 604800000L;
    private static final long milMonth = 2592000000L;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_jadwal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Jadwal");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        makul = (EditText)findViewById(R.id.input_nama_makul);
        jamMulai = (EditText)findViewById(R.id.jam_mulai);
        jamSelesai = (EditText)findViewById(R.id.jam_selesai);
        ruangan = (EditText)findViewById(R.id.input_nama_ruangan);
        alarmOn = (AppCompatCheckBox)findViewById(R.id.alarm_onn);
        mTime = (TextView) findViewById(R.id.alarm_time);
        mRepeat = (SwitchCompat)findViewById(R.id.alarm_repeat);
        txtRepeat = (TextView)findViewById(R.id.ketRepeat);
        linearTime = (LinearLayout)findViewById(R.id.linerTime);
        save = (Button)findViewById(R.id.btnSave);
        save.setOnClickListener(this);

        linearTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        FormEditJadwalActivity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.show(getFragmentManager(), "Timepickerdialog");
            }
        });


        jadwalPresenterImp = new JadwalPresenterImp(this);
        jadwalPresenterImp.getJadwal(getIntent().getIntExtra("id",0));
    }

    @Override
    protected void onResume() {
        super.onResume();
        TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().findFragmentByTag("TimepickerDialog");

        if(tpd != null) tpd.setOnTimeSetListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSucces() {
        jadwalPresenterImp.updateAlarm(this);
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void showLoadList(List<Matakuliah> makulList) {

    }

    @Override
    public void showMatakuliah(Matakuliah mk) {
        makul.setText(mk.getNama());
        jamMulai.setText(mk.getJamMulai());
        jamSelesai.setText(mk.getJamBerakhir());
        ruangan.setText(mk.getRuangan());
        alarmOn.setChecked(mk.isActive());
        mTime.setText(mk.getTime());
        mRepeat.setChecked(mk.isRepeat());
        txtRepeat.setText(mk.getHari());
    }

    @Override
    public void changeFragment(String day) {

    }

    @Override
    public void onSetAlarmFinish() {
        finish();
    }

    @Override
    public void onClick(View view) {
        int id = getIntent().getIntExtra("id",0);
        jadwalPresenterImp.updateMakul(id ,makul.getText().toString(),
                jamMulai.getText().toString(),
                jamSelesai.getText().toString(),
                ruangan.getText().toString(),
                txtRepeat.getText().toString(),
                DateHelper.dateNow(),
                mTime.getText().toString(),
                alarmOn.isChecked(),
                mRepeat.isChecked());
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        mTime.setText(DateHelper.timeFormat(hourOfDay+":"+minute));
    }
}
