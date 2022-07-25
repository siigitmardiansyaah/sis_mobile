package com.sinde.sismobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SessionManager sessionManager;
    TextView iduser,menu_lpm;
    String menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iduser = findViewById(R.id.iduser);
        menu_lpm = findViewById(R.id.menu_lpm);

        iduser.setText(sessionManager.getUserDetail().get(SessionManager.ID_USER));

        menu = sessionManager.getMenuDetail().get(SessionManager.MENU_LPM);
        if(menu.equals("0"))
        {
            menu_lpm.setVisibility(View.GONE);
        }else{
            menu_lpm.setVisibility(View.VISIBLE);
            menu_lpm.setText(menu);
        }



        sessionManager = new SessionManager(MainActivity.this);
        if (!sessionManager.isLoggedIn()) {
            moveToLogin();
        }
    }
    @Override
    public void onBackPressed() {
        moveToLogin();
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}