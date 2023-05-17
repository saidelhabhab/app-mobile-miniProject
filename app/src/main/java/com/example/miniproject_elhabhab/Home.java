package com.example.miniproject_elhabhab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.miniproject_elhabhab.Camera.Camera_Activity;
import com.example.miniproject_elhabhab.Email.Email_Activity;
import com.example.miniproject_elhabhab.Maps.Localisation_Maps;
import com.example.miniproject_elhabhab.SMS.MSG_Activity;
import com.example.miniproject_elhabhab.Transaction.ListViewActivity;
import com.example.miniproject_elhabhab.call.Call_Activity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    // variables
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textName,textEmail,emailuser ;

    ImageView Maps,call,MSG,email,agent,camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);




        Maps = findViewById(R.id.maps);
        call = findViewById(R.id.call);
        MSG = findViewById(R.id.MSG);
        email = findViewById(R.id.email);
        agent= findViewById(R.id.agent);
        camera = findViewById(R.id.camera);

        // Hoohs

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        textName=findViewById(R.id.textName);
        textEmail=findViewById(R.id.textEmail);
        toolbar=findViewById(R.id.toolbar);



        //  tool Bar

       setSupportActionBar(toolbar);

        // navigation drawer menu
// hide or show items
        Menu menu =navigationView.getMenu();
        menu.findItem(R.id.nav_lougout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!= null){
            String personeName = acct.getDisplayName();
            String personeEmail = acct.getEmail();
            textName.setText(personeName);
            textEmail.setText(personeEmail);

        }



        agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, ListViewActivity.class));
            }
        });

        Maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Localisation_Maps.class));
            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Call_Activity.class));
            }
        });

        MSG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, MSG_Activity.class));
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Email_Activity.class));
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Camera_Activity.class));
            }
        });
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.nav_home: break;

            case R.id.nav_main:
                Intent intent = new Intent(Home.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_setting:
                Intent intent1 = new Intent(Home.this,FindDoctorActivity.class);
                startActivity(intent1);
                break;

            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_lougout:

                logoutMenu(this);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



    void logoutMenu(Home home){
        AlertDialog.Builder builder = new AlertDialog.Builder(home);
        builder.setTitle("logout");
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}