package com.consultar.entidade;
// Generated 31/03/2017 19:48:10 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * ProfissionalRepositorio generated by hbm2java
 */
@Entity
@Table(name="profissional"
    ,catalog="consultar"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Profissional  implements java.io.Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profissional_id_seq")
    @SequenceGenerator(
            name = "profissional_id_seq",
            sequenceName = "profissional_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa

    @Column(name = "id")

     private Integer id;
    @NotNull
    @Column(name = "nome")
     private String nome;
    @NotNull
    @Column(name = "especialidade")
     private String especialidade;
    @NotNull
    @Column(name = "horario")
     private String horario;
    @NotNull
    @Column(name = "status")
     private Integer status;
    @NotNull
    @Column(name = "crm")
     private Integer crm;
    @NotNull
    @Column(name = "descricao")
     private String descricao;

    @OneToMany(mappedBy = "profissional")
    private List<PlantaoDia> plantaoDia;
//
//    public Profissional(String nome, String especialidade, String horario, Integer status, Integer crm, String descricao, List<PlantaoDia> plantaoDia) {
//        this.nome = nome;
//        this.especialidade = especialidade;
//        this.horario = horario;
//        this.status = status;
//        this.crm = crm;
//        this.descricao = descricao;
//        this.plantaoDia = plantaoDia;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public List<PlantaoDia> getPlantaoDia() {
        return plantaoDia;
    }

    public void setPlantaoDia(List<PlantaoDia> plantaoDia) {
        this.plantaoDia = plantaoDia;
    }
}


