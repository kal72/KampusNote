package com.singledev.kristiawan.kampusnote.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.singledev.kristiawan.kampusnote.R;
import com.singledev.kristiawan.kampusnote.helper.DateHelper;
import com.singledev.kristiawan.kampusnote.model.sqlite.Matakuliah;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenter;
import com.singledev.kristiawan.kampusnote.presenter.JadwalPresenterImp;
import com.singledev.kristiawan.kampusnote.presenter.JadwalView;
import com.singledev.kristiawan.kampusnote.utils.AlarmReceiver;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import java.util.List;

public class FormJadwalActivity extends AppCompatActivity implements JadwalView, TimePickerDialog.OnTimeSetListener{

    JadwalPresenterImp jadwalPresenterImp;
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

    AlarmReceiver alarmReceiver;

    private static final String KEY_TITLE = "title_key";
    private static final String KEY_TIME = "time_key";
    private static final String KEY_DATE = "date_key";
    private static final String KEY_REPEAT = "repeat_key";
    private static final String KEY_REPEAT_NO = "repeat_no_key";
    private static final String KEY_REPEAT_TYPE = "repeat_type_key";
    private static final String KEY_ACTIVE = "active_key";

    Bundle b;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        b = getIntent().getExtras();
        alarmReceiver = new AlarmReceiver();

        makul = (EditText)findViewById(R.id.input_nama_makul);
        jamMulai = (EditText)findViewById(R.id.jam_mulai);
        jamSelesai = (EditText)findViewById(R.id.jam_selesai);
        ruangan = (EditText)findViewById(R.id.input_nama_ruangan);
        alarmOn = (AppCompatCheckBox)findViewById(R.id.alarm_onn);
        mTime = (TextView) findViewById(R.id.alarm_time);
        mTime.setText(DateHelper.timeNow());
        mRepeat = (SwitchCompat)findViewById(R.id.alarm_repeat);
        txtRepeat = (TextView)findViewById(R.id.ketRepeat);
        txtRepeat.setText(b.getString("day"));
        linearTime = (LinearLayout)findViewById(R.id.linerTime);
        jadwalPresenterImp = new JadwalPresenterImp(this);
        jadwalPresenterImp.setContex(this);
        save = (Button)findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = DateHelper.dateNow();
                jadwalPresenterImp.addMakul(makul.getText().toString(),
                        jamMulai.getText().toString(),
                        jamSelesai.getText().toString(),
                        ruangan.getText().toString(),
                        b.getString("day"),
                        date,
                        mTime.getText().toString(),
                        alarmOn.isChecked(),
                        mRepeat.isChecked());
            }
        });

       linearTime.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Calendar now = Calendar.getInstance();
               TimePickerDialog tpd = TimePickerDialog.newInstance(
                       FormJadwalActivity.this,
                       now.get(Calendar.HOUR_OF_DAY),
                       now.get(Calendar.MINUTE),
                       true
               );

               tpd.show(getFragmentManager(), "Timepickerdialog");
           }
       });

    }

    @Override
    protected void onResume() {
        super.onResume();
        TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().findFragmentByTag("TimepickerDialog");

        if(tpd != null) tpd.setOnTimeSetListener(this);
    }

    @Override
    public void onSucces() {
        Toast.makeText(this,"Adding success!", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
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

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        mTime.setText(DateHelper.timeFormat(hourOfDay+":"+minute));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
