package com.ada.aerolinea.aerolineaAdaV1.model;

import javax.persistence.*;

@Entity


public class Base {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_base;
    private String city;

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
