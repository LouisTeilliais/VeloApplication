package com.formation.velo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "station")
public class Station implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double lattitude;

    private Double longitude;

    private String Status;

    private String address;

    // Nombre de vélo possible sur la station
    private Integer bike_stands;

    // Nombre de vélo en cours de circulation
    private Integer available_bikes;

    // Nombre de vélo à la station
    private Integer available_bike_stands;

    private String recordid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(id, station.id)
                && Objects.equals(name, station.name)
                && Objects.equals(lattitude, station.lattitude)
                && Objects.equals(longitude, station.longitude)
                && Objects.equals(Status, station.Status)
                && Objects.equals(address, station.address)
                && Objects.equals(bike_stands, station.bike_stands)
                && Objects.equals(available_bikes, station.available_bikes)
                && Objects.equals(available_bike_stands, station.available_bike_stands)
                && Objects.equals(recordid, station.recordid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lattitude, longitude, Status, address, bike_stands, available_bikes, available_bike_stands, recordid);
    }
}
