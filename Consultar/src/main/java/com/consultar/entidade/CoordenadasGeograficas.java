package com.consultar.entidade;
// Generated 31/03/2017 19:48:10 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * CoordenadasGeograficasRepositorio generated by hbm2java
 */
@Entity
@Table(name="coordenadas_geograficas"
    ,catalog="consultar"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class CoordenadasGeograficas  implements java.io.Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coordenadas_geograficas_id_seq")
    @SequenceGenerator(
            name = "coordenadas_geograficas_id_seq",
            sequenceName = "coordenadas_geograficas_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa


    @Column(name = "id")

     private Integer idcoordenadasGeograficas;
    @NotNull
    @Column(name = "latitude")
     private String latitude;
    @NotNull
    @Column(name = "longitude")
     private String longitude;
    @NotNull
    @Column(name = "status")
     private Integer status;


    public Integer getIdcoordenadasGeograficas() {
        return idcoordenadasGeograficas;
    }

    public void setIdcoordenadasGeograficas(Integer idcoordenadasGeograficas) {
        this.idcoordenadasGeograficas = idcoordenadasGeograficas;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}


