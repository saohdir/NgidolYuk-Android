package com.example.ngidolyuk;

import androidx.annotation.NonNull;

public class Request {
    private String adminid, tanggal_show, waktu_show, nama_show, nama_team;


    public Request() {
    }

    public Request(String AdminId, String TanggalShow, String WaktuShow, String SetList, String NamaTeam){

        this.tanggal_show = TanggalShow;
        this.waktu_show = WaktuShow;
        this.nama_show = SetList;
        this.nama_team = NamaTeam;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getTanggal_show() {
        return tanggal_show;
    }

    public void setTanggal_show(String tanggal_show) {
        this.tanggal_show = tanggal_show;
    }

    public String getWaktu_show() {
        return waktu_show;
    }

    public void setWaktu_show(String waktu_show) {
        this.waktu_show = waktu_show;
    }

    public String getNama_show() {
        return nama_show;
    }

    public void setNama_show(String nama_show) {
        this.nama_show = nama_show;
    }

    public String getNama_team() {
        return nama_team;
    }

    public void setNama_team(String nama_team) {
        this.nama_team = nama_team;
    }
}