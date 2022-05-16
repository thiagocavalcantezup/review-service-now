package br.com.zup.handora.reviewservicenow.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String pod;

    @Column(nullable = false)
    private String aprovador;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Usuario() {}

    public Usuario(String nome, String pod, String aprovador) {
        this.nome = nome;
        this.pod = pod;
        this.aprovador = aprovador;
    }

    public Long getId() {
        return id;
    }

}
