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

    private String city;
    private String reg_name;
    private String services_service;
    private String horaires_automate;
    private Date updateDate;
    private int reg_code;
    private String adress;
    private Double longitude;
    private Double latitude;
    private String postal_code;
    private double price;
    @NotBlank(message = "recordId is mandatory")
    private String recordId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pump pump = (Pump) o;
        return Id == pump.Id && reg_code == pump.reg_code && Double.compare(pump.price, price) == 0 && Objects.equals(city, pump.city) && Objects.equals(reg_name, pump.reg_name) && Objects.equals(services_service, pump.services_service) && Objects.equals(horaires_automate, pump.horaires_automate) && Objects.equals(updateDate, pump.updateDate) && Objects.equals(adress, pump.adress) && Objects.equals(longitude, pump.longitude) && Objects.equals(latitude, pump.latitude) && Objects.equals(postal_code, pump.postal_code) && Objects.equals(recordId, pump.recordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, city, reg_name, services_service, horaires_automate, updateDate, reg_code, adress, longitude, latitude, postal_code, price, recordId);
    }
}
