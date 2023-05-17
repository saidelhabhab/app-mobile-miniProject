package com.example.miniproject_elhabhab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.miniproject_elhabhab.Auth.LoginActivity;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = (CardView) findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply(); */
                startActivity(new Intent(FindDoctorActivity.this, Home.class));
            }
        });
    }
}