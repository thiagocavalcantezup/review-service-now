package br.com.zup.handora.reviewservicenow.usuario;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private String email;

    @ElementCollection
    private Map<Long, String> notebooks;

    @Column(nullable = false)
    private String pod;

    @ManyToOne
    private Usuario aprovador;

    @OneToMany(mappedBy = "aprovador")
    private Set<Usuario> aprovados = new HashSet<>();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Usuario() {}

    public Usuario(String nome, String email, Map<Long, String> notebooks, String pod) {
        this.nome = nome;
        this.email = email;
        this.notebooks = notebooks;
        this.pod = pod;
    }

    public void aprovar(Usuario aprovado) {
        aprovado.setAprovador(this);
        this.aprovados.add(aprovado);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Map<Long, String> getNotebooks() {
        return notebooks;
    }

    public String getPod() {
        return pod;
    }

    public Usuario getAprovador() {
        return aprovador;
    }

    public void setAprovador(Usuario aprovador) {
        this.aprovador = aprovador;
    }

}
