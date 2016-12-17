package com.singledev.kristiawan.kampusnote.model.sqlite;

import com.orm.SugarRecord;

import java.sql.Date;

/**
 * Created by ASUS on 26/09/2016.
 */

public class Matakuliah extends SugarRecord {
    private String nama;
    private String jamMulai;
    private String jamBerakhir;
    private String ruangan;
    private String hari;

    private String date;
    private String time;
    private boolean active;
    private boolean repeat;

    public Matakuliah() {
    }

    public Matakuliah(String nama, String jamMulai, String jamBerakhir, String ruangan, String hari, String date, String time, boolean active, boolean repeat) {
        this.nama = nama;
        this.jamMulai = jamMulai;
        this.jamBerakhir = jamBerakhir;
        this.ruangan = ruangan;
        this.hari = hari;
        this.date = date;
        this.time = time;
        this.active = active;
        this.repeat = repeat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamBerakhir() {
        return jamBerakhir;
    }

    public void setJamBerakhir(String jamBerakhir) {
        this.jamBerakhir = jamBerakhir;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
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
