package com.consultar.entidade;
// Generated 31/03/2017 19:48:10 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * ComplementoRepositorio generated by hbm2java
 */
@Entity
@Table(name="complemento"
    ,catalog="consultar"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Complemento  implements java.io.Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "complemento_id_seq")
    @SequenceGenerator(
            name = "complemento_id_seq",
            sequenceName = "complemento_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa

    @Column(name = "id")

     private Integer idcomplemento;
    @NotNull
    @Column(name = "descricao")
     private String descricao;
    @NotNull
    @Column(name = "status")
     private String status;

    public Complemento(String descricao, String status) {
        this.setDescricao(descricao);
        this.setStatus(status);
    }


    public Integer getIdcomplemento() {
        return idcomplemento;
    }

    public void setIdcomplemento(Integer idcomplemento) {
        this.idcomplemento = idcomplemento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


