package com.consultar.entidade;
// Generated 31/03/2017 19:48:10 by Hibernate Tools 4.3.1


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * UsuarioRepositorio generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="consultar"
)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Usuario  implements java.io.Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuario_id_seq")
    @SequenceGenerator(
            name = "usuario_id_seq",
            sequenceName = "usuario_id_seq",
            allocationSize = 1)//de quanto em quanto ele incrementa

    @Column(name = "usuario_id")


    private Integer id;
    @NotNull
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Column(name = "cpf")
    private String cpf;
    @NotNull
    @Column(name = "tipo")
    private Integer tipo;
    @NotNull
    @Column(name = "status")
    private Integer status;

//
//    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<UnidadeDeSaude> unidadeDeSaude;
//    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<FeedNoticias> feedNoticias;
    @ManyToOne
    @JoinColumn(name = "imagem_id")
    private Imagem imagem;


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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    public List<UnidadeDeSaude> getUnidadeDeSaude() {
//        return unidadeDeSaude;
//    }
//
//    public void setUnidadeDeSaude(List<UnidadeDeSaude> unidadeDeSaude) {
//        this.unidadeDeSaude = unidadeDeSaude;
//    }
//
//    public List<FeedNoticias> getFeedNoticias() {
//        return feedNoticias;
//    }
//
//    public void setFeedNoticias(List<FeedNoticias> feedNoticias) {
//        this.feedNoticias = feedNoticias;
//    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

}


