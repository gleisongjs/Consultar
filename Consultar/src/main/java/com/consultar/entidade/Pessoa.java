package com.consultar.entidade;

/**
 * Created by RuWindows on 18/03/2017.
 */
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pessoa")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pessoa{

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pessoa_id_seq")
    @SequenceGenerator(
            name = "pessoa_id_seq",
            sequenceName = "pessoa_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "senha")
    private String senha;

    @OneToMany(mappedBy = "pessoa")
    //@JsonBackReference
    private List<Animal> animals;

    @ManyToMany
    @JoinTable(name = "pessoa_permissoes",
            joinColumns=@JoinColumn(name = "pessoa_id"),
            inverseJoinColumns=@JoinColumn(name = "permissao_id"))
    //@JsonManagedReference(value = "pessoa_permissões")
    private List<Permissao> permissoes;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}

