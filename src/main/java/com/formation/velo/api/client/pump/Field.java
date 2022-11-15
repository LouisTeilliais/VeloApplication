package com.formation.velo.api.client.pump;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Field {

    @SerializedName("ville")
    private String city;
    @SerializedName("prix_nom")
    private String carburant;
    @SerializedName("services_service")
    private String servicesService;
    @SerializedName("horaires_automate_24_24")
    private String horairesAutomate24_24;
    @SerializedName("prix_maj")
    private Date updatePrice;
    @SerializedName("adresse")
    private String adress;
    @SerializedName("geom")
    private double[] position;
    @SerializedName("prix_valeur")
    private double prix;
    @SerializedName("postal_code")
    private String cp;
}