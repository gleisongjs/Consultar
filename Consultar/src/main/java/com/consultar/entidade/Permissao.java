package com.consultar.entidade;

/**
 * Created by Gleisongjs on 18/03/2017.
 */
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="permissao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Permissao implements Serializable{

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "permissao_id_seq")
    @SequenceGenerator(
            name = "permissao_id_seq",
            sequenceName = "permissao_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

//    @ManyToMany(mappedBy = "permissoes", fetch = FetchType.LAZY)
//    //@JsonBackReference
//    private List<Acesso> acesso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public List<Acesso> getPessoas() {
//        return acesso;
//    }
//
//    public void setPessoas(List<Acesso> acesso) {
//        this.acesso = acesso;
//    }
}

