package br.com.zup.handora.reviewservicenow.solicitacaodeacesso;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.enums.EstadoSolicitacao;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.enums.RespostaPCD;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.enums.TipoSolicitacao;

@Entity
@Table(name = "solicitacoes_de_acesso")
public class SolicitacaoDeAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeSolicitante;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String notebook;

    @Column(nullable = false)
    private String nomeAprovador;

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

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoSolicitacao estadoSolicitacao = EstadoSolicitacao.ABERTA;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public SolicitacaoDeAcesso() {}

    public SolicitacaoDeAcesso(String nomeSolicitante, String email, String notebook,
                               String nomeAprovador, String pod, String projeto,
                               RespostaPCD respostaPcd, String emNomeDe,
                               TipoSolicitacao tipoSolicitacao, String funcao) {
        this.nomeSolicitante = nomeSolicitante;
        this.email = email;
        this.notebook = notebook;
        this.nomeAprovador = nomeAprovador;
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

    public void encerrar() {
        estadoSolicitacao = EstadoSolicitacao.ENCERRADA;
    }

}
