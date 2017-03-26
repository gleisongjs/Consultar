package com.consultar.entidade;

/**
 * Created by Gleisongjs on 18/03/2017.
 */

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "animal")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Animal {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "animal_id_seq")
    @SequenceGenerator(
            name = "animal_id_seq",
            sequenceName = "animal_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "raca")
    private String raca;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    //@JsonManagedReference(value = "animal_pessoa")
    private Pessoa pessoa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}

