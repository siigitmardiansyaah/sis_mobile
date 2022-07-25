package com.sinde.sismobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.sinde.sismobile.model.LoginData;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";

//    //DATA SESSION LOGIN
    public static final String ID_MASTER_USER = "idmasuser";
    public static final String ID_USER = "iduser";
    public static final String NAMA_USER = "nmuser";
    public static final String KODE_DIV = "kd_div";

    //MENU LPM
    public static final String MENU_LPM = "menu_lpm";


    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID_MASTER_USER, user.getIdmasuser());
        editor.putString(ID_USER, user.getIduser());
        editor.putString(NAMA_USER, user.getNmuser());
        editor.putString(KODE_DIV, user.getKd_div());
        editor.commit();
    }

    public void createMenuSession(LoginData user){
        editor.putString(MENU_LPM, user.getMenu_lpm());
        editor.commit();
    }

//
    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(ID_MASTER_USER, sharedPreferences.getString(ID_MASTER_USER,null));
        user.put(ID_USER, sharedPreferences.getString(ID_USER,null));
        user.put(NAMA_USER, sharedPreferences.getString(NAMA_USER,null));
        user.put(KODE_DIV, sharedPreferences.getString(KODE_DIV,null));
        return user;
    }

    public HashMap<String, String> getMenuDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(MENU_LPM, sharedPreferences.getString(MENU_LPM,null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}
