package com.example.miniproject_elhabhab.loading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.miniproject_elhabhab.Auth.LoginActivity;
import com.example.miniproject_elhabhab.Home;
import com.example.miniproject_elhabhab.R;

public class Loading_Activity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        handler = new Handler ();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(Loading_Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        },4000);

    }
}