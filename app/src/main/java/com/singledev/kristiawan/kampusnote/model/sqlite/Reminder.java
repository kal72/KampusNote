package com.singledev.kristiawan.kampusnote.model.sqlite;

import com.orm.SugarApp;
import com.orm.SugarRecord;

/**
 * Created by ASUS on 28/09/2016.
 */

public class Reminder extends SugarRecord {
    private int id_makul;
    private String date;
    private String time;
    private boolean active;
    private boolean repeat;

    public Reminder() {
    }

    public int getId_makul() {
        return id_makul;
    }

    public void setId_makul(int id_makul) {
        this.id_makul = id_makul;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }
}
