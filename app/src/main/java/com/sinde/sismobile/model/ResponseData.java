package com.sinde.sismobile.model;

import com.google.gson.annotations.SerializedName;

public class ResponseData {
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private boolean status;
    @SerializedName("login")
    private LoginData login;

    @SerializedName("menu_lpm")
    private LoginData menu_lpm;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LoginData getLogin() {
        return login;
    }

    public void setLogin(LoginData login) {
        this.login = login;
    }

    public LoginData getMenu_lpm() {
        return menu_lpm;
    }

    public void setMenu_lpm(LoginData menu_lpm) {
        this.menu_lpm = menu_lpm;
    }
}