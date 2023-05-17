package com.example.miniproject_elhabhab.Email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniproject_elhabhab.R;



public class Email_Activity extends AppCompatActivity {

    EditText subject,message;
    String email,msg;
    Button buttonSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        // assign variable

        email = "saidelhabhab@gmail.com";
        message = findViewById(R.id.message);
        subject = findViewById(R.id.subject);
        buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(view -> {
            // get new value editText


             String stringSenderEmail  = email;
            String subject1 = subject.getText().toString();
             msg = message.getText().toString();
            if (subject1.equals("") && msg.equals("")){
                Toast.makeText(Email_Activity.this, "All fields are required ", Toast.LENGTH_SHORT).show();
            }
            else{
                buttonSendEmail(subject1,msg,stringSenderEmail);
            }

        });


    }

    public void buttonSendEmail(String subject, String message, String email){



        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,msg);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose email client : "));



    }
}