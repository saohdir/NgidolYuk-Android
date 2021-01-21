package com.example.ngidolyuk.Model;

import java.util.List;

public class SchduleModel {
    private String id, nama_show, nama_team, tanggal_show, waktu_show;


    public SchduleModel() {
    }

    public SchduleModel(String id, String nama_show, String nama_team, String tanggal_show, String waktu_show){
        this.id = id;
        this.nama_show = nama_show;
        this.nama_team = nama_team;
        this.tanggal_show = tanggal_show;
        this.waktu_show = waktu_show;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString()
    {
        return ""+id+"\n"+
                ""+nama_show+"\n"+
                ""+nama_team+"\n"+
                ""+tanggal_show+"\n" +
                ""+waktu_show+"\n";
    }
}
