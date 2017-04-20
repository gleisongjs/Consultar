package com.consultar.entidade;
// Generated 31/03/2017 19:48:10 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * LocalizacaoRepositorio generated by hbm2java
 */
@Entity
@Table(name="localizacao"
    ,catalog="consultar"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Localizacao  implements java.io.Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "localizacao_id_seq")
    @SequenceGenerator(
            name = "localizacao_id_seq",
            sequenceName = "localizacao_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa

    @Column(name = "id")

     private Integer idlocalizacao;
    @NotNull
    @Column(name = "status")
     private String status;

    @ManyToOne
    @JoinColumn(name="bairro_id")
    private  Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "rua_id")
     private Rua rua;

    public Localizacao(String status, Bairro bairro, Rua rua) {
        this.setStatus(status);
        this.setBairro(bairro);
        this.setRua(rua);
    }


    public Integer getIdlocalizacao() {
        return idlocalizacao;
    }

    public void setIdlocalizacao(Integer idlocalizacao) {
        this.idlocalizacao = idlocalizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }
}

