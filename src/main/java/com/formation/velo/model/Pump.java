package com.formation.velo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "pump")
public class Pump implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String ville;
    private String horaires_automate;
    private Date prix_maj;
    private String adresse;
    private Double longitude;
    private Double latitude;
    private String cp;
    private double prix;
    @NotBlank(message = "recordId is mandatory")
    private String recordId;
    private String carburant;

}
