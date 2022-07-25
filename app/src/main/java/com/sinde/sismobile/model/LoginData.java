package com.sinde.sismobile.model;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("iduser")
    private String iduser;

    @SerializedName("nmuser")
    private String nmuser;

    @SerializedName("kd_div")
    private String kd_div;

    @SerializedName("idmasuser")
    private String idmasuser;

    @SerializedName("menu_lpm")
    private String menu_lpm;

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getNmuser() {
        return nmuser;
    }

    public void setNmuser(String nmuser) {
        this.nmuser = nmuser;
    }

    public String getKd_div() {
        return kd_div;
    }

    public void setKd_div(String kd_div) {
        this.kd_div = kd_div;
    }

    public String getIdmasuser() {
        return idmasuser;
    }

    public void setIdmasuser(String idmasuser) {
        this.idmasuser = idmasuser;
    }

    public String getMenu_lpm() {
        return menu_lpm;
    }

    public void setMenu_lpm(String menu_lpm) {
        this.menu_lpm = menu_lpm;
    }
}
