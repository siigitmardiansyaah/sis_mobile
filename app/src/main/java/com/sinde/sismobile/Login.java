package com.sinde.sismobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sinde.sismobile.api.ApiClient;
import com.sinde.sismobile.api.ApiInterface;
import com.sinde.sismobile.model.LoginData;
import com.sinde.sismobile.model.ResponseData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText nik, password;
    Button btn_login;
    String iduser, pass;
    ApiInterface apiInterface;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nik = findViewById(R.id.username_input);
        password = findViewById(R.id.pass);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iduser = nik.getText().toString();
                pass = password.getText().toString();
                apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<ResponseData> loginCall = apiInterface.loginResponse(iduser, pass);
                loginCall.enqueue(new Callback<ResponseData>() {
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {

                            // Ini untuk menyimpan sesi
                            sessionManager = new SessionManager(Login.this);
                            LoginData loginData = response.body().getLogin();
                            sessionManager.createLoginSession(loginData);
                            if (response.body().getLogin().getKd_div().equals("LPM")) {
                                Call<ResponseData> menuCall = apiInterface.getMenuData(iduser);
                                menuCall.enqueue(new Callback<ResponseData>() {
                                    @Override
                                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                                        if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                                            // Ini untuk menyimpan sesi
                                            sessionManager = new SessionManager(Login.this);
                                            LoginData loginData = response.body().getMenu_lpm();
                                            sessionManager.createMenuSession(loginData);
                                        } else {
                                            Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    @Override
                                    public void onFailure(Call<ResponseData> call, Throwable t) {
//                        Toast.makeText(Login.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                            //Ini untuk pindah
                            Toast.makeText(Login.this, "Selamat Datang " + response.body().getLogin().getIduser(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {
//                        Toast.makeText(Login.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}