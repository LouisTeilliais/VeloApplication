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

    // Index [0]
    private Double lattitude;
    // Index [1]
    private Double longitude;
    private String status;
    private String address;
    // Nombre de places de vélo possible sur la station
    private Integer bikeStands;
    // Nombre de vélo actuellement sur la station
    private Integer availableBikes;
    // Nombre de places restantes sur la station
    private Integer availableBikeStands;
    private String recordId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(id, station.id)
                && Objects.equals(name, station.name)
                && Objects.equals(lattitude, station.lattitude)
                && Objects.equals(longitude, station.longitude)
                && Objects.equals(status, station.status)
                && Objects.equals(address, station.address)
                && Objects.equals(bikeStands, station.bikeStands)
                && Objects.equals(availableBikes, station.availableBikes)
                && Objects.equals(availableBikeStands, station.availableBikeStands)
                && Objects.equals(recordId, station.recordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lattitude, longitude, status,
                            address, bikeStands, availableBikes, availableBikeStands, recordId);
    }
}
