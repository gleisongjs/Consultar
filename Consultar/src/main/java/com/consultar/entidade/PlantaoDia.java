package com.consultar.entidade;
// Generated 31/03/2017 19:48:10 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * PlataoDiaRepositorio generated by hbm2java
 */
@Entity
@Table(name="platao_dia"
    ,catalog="consultar"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class PlantaoDia implements java.io.Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "platao_dia_id_seq")
    @SequenceGenerator(
            name = "platao_dia_id_seq",
            sequenceName = "platao_dia_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa

    @Column(name = "id")


     private Integer id;
    @NotNull
    @Column(name = "horario")
     private String horario;
    @NotNull
    @Column(name = "data")
     private Date data;
    @NotNull
    @Column(name = "descricao")
     private String descricao;
    @NotNull
    @Column(name = "status")
     private String status;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    public PlantaoDia(String horario, Date data, String descricao, String status, Profissional profissional) {
        this.horario = horario;
        this.data = data;
        this.descricao = descricao;
        this.status = status;
        this.setProfissional(profissional);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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


    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
}


