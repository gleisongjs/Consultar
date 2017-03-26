package com.consultar.entidade;

/**
 * Created by Gleisongjs on 18/03/2017.
 */
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="permissao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Permissao {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "permissao_id_seq")
    @SequenceGenerator(
            name = "permissao_id_seq",
            sequenceName = "permissao_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @ManyToMany(mappedBy = "permissoes", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Pessoa> pessoas;

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

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}

