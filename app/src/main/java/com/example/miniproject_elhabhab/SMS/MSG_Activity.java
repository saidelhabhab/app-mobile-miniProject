package com.example.miniproject_elhabhab.SMS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miniproject_elhabhab.R;
import com.example.miniproject_elhabhab.call.Call_Activity;

public class MSG_Activity extends AppCompatActivity {


    // initailize variable

    EditText numberPhone,message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        // assign variable

        numberPhone = findViewById(R.id.numberPhone);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    sendSMS();
             }
        });

    }




    private void sendSMS(){
        // get new value editText
        String phone = numberPhone.getText().toString();
        String msg = message.getText().toString();

        // check condition if string is empty or not
        if (!phone.isEmpty()&& !msg.isEmpty()){


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:"+phone));
            intent.putExtra("sms_body",msg);
            startActivity(intent);
            // display Toast msg
            Toast.makeText(this, "SMS sent successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            // when string is empty then display toast msg
            Toast.makeText(this, "Please enter Phone and Message  ", Toast.LENGTH_SHORT).show();
        }

    }


}