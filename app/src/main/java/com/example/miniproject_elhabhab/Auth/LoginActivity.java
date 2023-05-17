package com.example.miniproject_elhabhab.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniproject_elhabhab.Database.Database;
import com.example.miniproject_elhabhab.Home;
import com.example.miniproject_elhabhab.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class LoginActivity extends AppCompatActivity {

    EditText editemail,editpassword;
    Button btnlogin;
    ImageView googleButton;
    TextView register,forgotPassword;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editemail = findViewById(R.id.editTextemail);
        editpassword = findViewById(R.id.editTextpassword);
        btnlogin = findViewById(R.id.buttonlogin);
        register = findViewById(R.id.register);
        forgotPassword = findViewById(R.id.forgotPassword);
        googleButton = findViewById(R.id.buttonGoogle);


        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);


       ////////////////////////////////////
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        ////////////////////////////////////
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editemail.getText().toString();
                String password = editpassword.getText().toString();
                Database db = new Database(getApplicationContext()); // instituation db

                if(email.length()==0 || password.length()==0){

                    Toast.makeText(getApplicationContext(),"Please fill all detais",Toast.LENGTH_SHORT).show();
                }else{
                  if (db.login(email,password)==1){
                      Toast.makeText(getApplicationContext(),"login Successfully",Toast.LENGTH_SHORT).show();
                      SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                      SharedPreferences.Editor editor = sharedPreferences.edit();
                      editor.putString("email",email);
                      // to save our data with key and value
                      editor.apply();


                        startActivity(new Intent(LoginActivity.this, Home.class));
                  }else {
                      Toast.makeText(getApplicationContext(),"Invalid Email and Password",Toast.LENGTH_SHORT).show();
                  }

                 }
            }
        });

        ////////////////////////////////////
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        ////////////////////////////////////
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }


    ////////////////////////////////////
    void signIn (){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    ////////////////////////////////////
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();

            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(),"something is wrong",Toast.LENGTH_SHORT).show();
            }

        }
    }


    ////////////////////////////////////
    void navigateToSecondActivity(){

        finish();
        Intent Intent = new Intent(LoginActivity.this, Home.class);
        startActivity(Intent);

    }
}