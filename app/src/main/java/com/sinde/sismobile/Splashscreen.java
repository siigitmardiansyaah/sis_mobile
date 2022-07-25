package com.sinde.sismobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(Splashscreen.this, Login.class));
                    finish();
                }catch (Exception e) {

                }
            }
        }; thread.start();
    }
}