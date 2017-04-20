package com.consultar.entidade;
// Generated 31/03/2017 19:48:10 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * VacinasRepositorio generated by hbm2java
 */
@Entity
@Table(name="vacinas"
    ,catalog="consultar"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idvacinas")

public class Vacinas  implements java.io.Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vacinas_id_seq")
    @SequenceGenerator(
            name = "vacinas_id_seq",
            sequenceName = "vacinas_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa

    @Column(name = "id")

     private Integer idvacinas;
    @NotNull
    @Column(name = "nome")
     private String nome;
    @NotNull
    @Column(name = "descricao")
     private String descricao;
    @NotNull
    @Column(name = "valor")
     private Short valor;
    @NotNull
    @Column(name = "status")
     private Integer status;

    public Vacinas() {
    }

    @ManyToMany
    @JoinTable(name = "vacina_unidade_de_saude",
            joinColumns=@JoinColumn(name = "exame_id"),
            inverseJoinColumns=@JoinColumn(name = "unidade_de_saude_id"))
    //@JsonManagedReference(value = "vacina_unidade_de_saude")
    private List<UnidadeDeSaude> unidadeDeSaude;

    public Vacinas(String nome, String descricao, Short valor, Integer status, List<UnidadeDeSaude> unidadeDeSaude) {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setValor(valor);
        this.setStatus(status);
        this.setUnidadeDeSaude(unidadeDeSaude);
    }


    public Integer getIdvacinas() {
        return idvacinas;
    }

    public void setIdvacinas(Integer idvacinas) {
        this.idvacinas = idvacinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Short getValor() {
        return valor;
    }

    public void setValor(Short valor) {
        this.valor = valor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UnidadeDeSaude> getUnidadeDeSaude() {
        return unidadeDeSaude;
    }

    public void setUnidadeDeSaude(List<UnidadeDeSaude> unidadeDeSaude) {
        this.unidadeDeSaude = unidadeDeSaude;
    }
}


