package com.example.miniproject_elhabhab.call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.miniproject_elhabhab.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Call_Activity extends AppCompatActivity {

    EditText numberPhone;
    FloatingActionButton callbtn,callbtn2;

    static int PERMISSION_CODE = 100;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        numberPhone = findViewById(R.id.numberPhone);
        callbtn = findViewById(R.id.callbtn);
        callbtn2 = findViewById(R.id.callbtn2);

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "06031654656";
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
            if(ActivityCompat.checkSelfPermission(Call_Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                requestPermissions(new String[]
                        {
                              Manifest.permission.CALL_PHONE
                         },1);
                }
                else
                {
                    startActivity(intent);
                }

                }
            });

   if (ContextCompat.checkSelfPermission(Call_Activity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Call_Activity.this,new String[]{
                    Manifest.permission.CALL_PHONE},PERMISSION_CODE);
        }




        callbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String numberPh = numberPhone.getText().toString();
                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:"+numberPh));
                startActivity(intent1);
            }
        });




    }
}