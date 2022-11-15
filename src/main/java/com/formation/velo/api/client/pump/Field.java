package com.formation.velo.api.client.pump;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

@lombok.Data
public class Field {

    private String city;
    @SerializedName("prix_nom")
    private String prixNom;
    @SerializedName("dep_code")
    private String depCode;
    @SerializedName("services_service")
    private String servicesService;
    @SerializedName("horaires_automate_24_24")
    private String horairesAutomate24_24;
    @SerializedName("prix_mag")
    private Date updatePrice;
    private String adress;
    @SerializedName("geom")
    private double[] position;
    @SerializedName("prix_valeur")
    private double price;
    @SerializedName("reg_name")
    private String regionName;
}