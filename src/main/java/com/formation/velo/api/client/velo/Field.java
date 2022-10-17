package com.formation.velo.api.client.velo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {

   @SerializedName("available_bike_stands")
   private Integer availableBikeStands;
   @SerializedName("available_bikes")
   private Integer availableBikes;
   @SerializedName("bike_stands")
   private Integer bikeStands;
   private Integer number;
   private String address;
   private String name;
   private String status;
   private double[] position;
}
