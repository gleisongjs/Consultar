package com.consultar.entidade;
// Generated 31/03/2017 19:48:10 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * ContatoRepositorio generated by hbm2java
 */
@Entity
@Table(name="contato"
    ,catalog="consultar"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Contato  implements java.io.Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contato_id_seq")
    @SequenceGenerator(
            name = "contato_id_seq",
            sequenceName = "contato_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa

    @Column(name = "id")

     private Integer idcontato;
    @NotNull
    @Column(name = "dd")
     private Integer dd;
    @NotNull
    @Column(name = "telefone")
     private Integer telefone;
    @NotNull
    @Column(name = "status")
     private Integer status;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    @JsonManagedReference(value = "setor_id")

     private Setor setor;

    public Contato(Integer dd, Integer telefone, Integer status, Setor setor) {
        this.setDd(dd);
        this.setTelefone(telefone);
        this.setStatus(status);
        this.setSetor(setor);
    }


    public Integer getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(Integer idcontato) {
        this.idcontato = idcontato;
    }

    public Integer getDd() {
        return dd;
    }

    public void setDd(Integer dd) {
        this.dd = dd;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}


