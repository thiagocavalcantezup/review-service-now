package br.com.zup.handora.reviewservicenow.solicitacaodeacesso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solicitacoes_de_acesso")
public class SolicitacaoDeAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String solicitante;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String notebook;

    @Column(nullable = false)
    private String aprovador;

    @Column(nullable = false)
    private String pod;

    @Column(nullable = false)
    private String projeto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RespostaPCD respostaPcd;

    @Column(nullable = false)
    private String emNomeDe;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoSolicitacao tipoSolicitacao;

    @Column(nullable = false)
    private String funcao;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public SolicitacaoDeAcesso() {}

    public SolicitacaoDeAcesso(String solicitante, String email, String notebook, String aprovador,
                               String pod, String projeto, RespostaPCD respostaPcd, String emNomeDe,
                               TipoSolicitacao tipoSolicitacao, String funcao) {
        this.solicitante = solicitante;
        this.email = email;
        this.notebook = notebook;
        this.aprovador = aprovador;
        this.pod = pod;
        this.projeto = projeto;
        this.respostaPcd = respostaPcd;
        this.emNomeDe = emNomeDe;
        this.tipoSolicitacao = tipoSolicitacao;
        this.funcao = funcao;
    }

    public Long getId() {
        return id;
    }

}
