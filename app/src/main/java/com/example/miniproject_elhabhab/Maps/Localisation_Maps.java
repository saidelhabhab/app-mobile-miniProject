package com.example.miniproject_elhabhab.Maps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.miniproject_elhabhab.R;
import com.example.miniproject_elhabhab.databinding.ActivityLocalisationMapsBinding;
import com.example.miniproject_elhabhab.Agent.Agent;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class Localisation_Maps extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private ActivityLocalisationMapsBinding binding;
    private List<Agent> agences = new ArrayList<>();

    Button btnCall;
    Button btnmssg;
    Button btnmail;
    SearchView mSearchText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityLocalisationMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSearchText = (SearchView) findViewById(R.id.search_view);
         btnCall = findViewById(R.id.btnCall);
        btnmssg = findViewById(R.id.btnMsssg);
        btnmail = findViewById(R.id.btnmail);




        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //ajouter des agences
        agences.add(new Agent(new LatLng(34.0257476, -6.8439444), "Agence Médina ","Rabat, Médina, Maroc", "+212603676441"));
        agences.add(new Agent(new LatLng(34.0019588, -6.8480016), "Agence de Agdal","Rabat, Agdal, Maroc", "+212603676442"));
        agences.add(new Agent(new LatLng(34.0201884, -6.8294181), "Agence de Hassan","Rabat,Hassan, Maroc", "+212603676443"));
        agences.add(new Agent(new LatLng(34.257419,-6.5905201), "Agence de Médina","Kenitra, Médina, Maroc", "+212603676444"));
        agences.add(new Agent(new LatLng(34.256501,-6.6264835), "Agence de  Ouled Oujih","Kenitra,  Ouled Oujih, Maroc", "+212603676445"));
        agences.add(new Agent(new LatLng(34.254636,-6.680958), "Agence de Mahdia","Kenitra, Mahdia, Maroc", "+212603676446"));
        agences.add(new Agent(new LatLng(34.2531284,-6.5549916), "Agence de Nahdda","Kenitra, Nahdda, Maroc", "+212603676447"));
        agences.add(new Agent(new LatLng(34.0613433,-6.79580799), "Agence de Rahma","Sale,Hay Rahma, Maroc", "+212603676448"));
        agences.add(new Agent(new LatLng(34.0404107,-6.8339705), "Agence de Médina","Sale,Médina, Maroc", "+212603676450"));
        agences.add(new Agent(new LatLng(34.0388003,-6.8051884), "Agence de Salam","Sale, Hay Salam, Maroc", "+212603676451"));
        agences.add(new Agent(new LatLng(35.7772617,-5.8218097), "Agence de M'Sallah","Tanger, M'Sallah, Maroc", "+212603676423"));
        agences.add(new Agent(new LatLng(35.7571337,-5.8714896), "Agence de Mesnana ","Tanger, Mesnana,  Maroc", "+212603676454"));
        agences.add(new Agent(new LatLng(35.7497158,-5.7899398), "Agence de Mghogha","Tanger, Mghogha, Maroc", "+212603676455"));
        agences.add(new Agent(new LatLng(33.8677469,-5.5713942), "Agence de Zitoune","Meknes, Zitoune, Maroc", "+212603676456"));
        agences.add(new Agent(new LatLng(33.9000735,-5.6107307), "Agence de Riad Toulal","Meknes, Riad Toulal, Maroc", "+212603676457"));
        agences.add(new Agent(new LatLng(33.9012699,-5.5561652), "Agence de Hamria","Meknes, Hamria, Maroc", "+212603676458"));
        agences.add(new Agent(new LatLng(33.5701301,-7.6772191), "Agence de Maarif ","Casablanca, Maarif, Maroc", "+212603676478"));
        agences.add(new Agent(new LatLng(33.5902843,-7.6959477), "Agence de AIN DIAB  ", "Casablanca, AIN DIAB, Maroc", "+212603676459"));
        agences.add(new Agent(new LatLng(34.9985067,-5.9126432), "Agence de Souk Sebta", "Kser el kabir, Souk Sebta, Maroc", "+212603676460"));
        agences.add(new Agent(new LatLng(34.9961201,-5.8957904), "Agence de Al Ghoufrane", "Kser el kabir, Al Ghoufrane, Maroc", "+212603676461"));
        agences.add(new Agent(new LatLng(35.018947,-5.9134526), "Agence de oulad ahmed", "Kser el kabir, oulad ahmed, Maroc", "+212603676462"));
        agences.add(new Agent(new LatLng(35.1936899,-6.1570027), "Agence de Centre Ville", "Larache, Centre Ville, Maroc", "+212603676463"));
        agences.add(new Agent(new LatLng(35.1802724,-6.1482547), "Agence de Hay Assalam", "Larache, Hay Assalam, Maroc", "+212603676464"));
        agences.add(new Agent(new LatLng(35.167309,-6.147776), "Agence de AL Maghreb AL Jadid ", "Larache, AL Maghreb AL Jadid,Maroc", "+212603676465"));
        agences.add(new Agent(new LatLng(31.6328409,-8.000688), "Agence de Bab Doukkala", "Marrakech,Bab Doukkala, Maroc", "+212603676401"));
        agences.add(new Agent(new LatLng(31.6743728,-8.0264837), "Agence de Charaf ", "Marrakech, Hay Charaf, Maroc", "+212603676491"));
        agences.add(new Agent(new LatLng(33.5333666,-7.6705995), "Agence de Oulad Bouabid", "casa,Oulad Bouabid , Maroc", "+212603676410"));
        agences.add(new Agent(new LatLng(30.422735,-9.6021366), "Agence de Talborjt ", "Agadir, Talborjt, Maroc", "+212603676499"));
        agences.add(new Agent(new LatLng(30.3998625,-9.5603559), "Agence de Cité Essalam", "Agadir, Cité Essalam, Maroc", "+212603676488"));
        agences.add(new Agent(new LatLng(35.4678573,-6.0312044), "Agence de Widadiya ", "Asilah, Widadiya , Maroc", "+212603676481"));
        agences.add(new Agent(new LatLng(35.4545437,-6.0467345), "Agence de Sakaya", "Asilah, Sakaya, Maroc", "+212603676480"));


        SupportMapFragment mapFragment1 =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment1.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        for (Agent agence : agences) {

            mMap.addMarker(new MarkerOptions()
                    .position(agence.getPosition())
                    .title(agence.getNameResponsable())
                    .snippet(
                            agence.getAddress() + "\n" + agence.getPhone()
                    )
            );
        }

        Agent agence = agences.get(0);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(agence.getPosition(), 12));


        /////////////// Search /////////////////

        mSearchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String search) {


                for (Agent agence : agences) {
                    if (agence.getAddress().equals(search) || agence.getNameResponsable().equals(search) ) {

                        LatLng location = agence.getPosition();
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 20));

                        break;
                    }
                }


                return false;
            }

            @Override
            public boolean onQueryTextChange(String search) {
                List<Agent> filteredAgences = new ArrayList<>();
                for (Agent agence : agences) {
                    if (agence.getAddress().toLowerCase().contains(search.toLowerCase()) || agence.getNameResponsable().toLowerCase().contains(search.toLowerCase())) {
                        LatLng location1 = agence.getPosition();
                        filteredAgences.add(agence);
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 15));
                    }
                }
                return false;
            }
        });
        /////////////// end Search /////////////////

        /////////////// Call /////////////////

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+212603676440"));
                startActivity(intent);
            }

        });
        /////////////// End Call /////////////////

        /////////////// Message /////////////////


        btnmssg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "+212603676440";
                String message = "Bonjour Madame, Monsieur,\n" + "Par la présente, je me permets de vous solliciter !";

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + phoneNumber));
                intent.putExtra("sms_body", message);
                startActivity(intent);

            }

        });
        /////////////// End Message /////////////////


        /////////////// Email /////////////////



        // assign variable

        String email = "saidelhabhab@gmail.com";
        String subject = "Réclamation";
        String message = "Bonjour Madame, Monsieur,\n" +
                "\n" +
                "Par la présente, je me permets de vous solliciter afin d'obtenir votre intervention dans le litige que je rencontre ";


        btnmail.setOnClickListener(view -> {
            // get new value editText


            if (subject.equals("") && message.equals("")) {
                Toast.makeText(Localisation_Maps.this, "All fields are required ", Toast.LENGTH_SHORT).show();
            } else {
                buttonSendEmail(subject, message, email);
            }

        });

        /////////////// End Email /////////////////

    }

    /////////////// End onMapReady /////////////////

    public void buttonSendEmail(String subject, String message, String email){



        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose email client : "));

    }


}


