package com.example.miniproject_elhabhab.Agent;

import com.google.android.gms.maps.model.LatLng;

public class Agent {

    private LatLng position;
    private String nameResponsable;
    private String address;
    private String phone;


    public Agent( LatLng position, String nameResponsable, String address, String phone) {
        this.position = position;
        this.nameResponsable = nameResponsable;
        this.address = address;
        this.phone = phone;

    }
    public LatLng getPosition() {
        return position;
    }

    public String getNameResponsable() {
        return nameResponsable;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }


}
