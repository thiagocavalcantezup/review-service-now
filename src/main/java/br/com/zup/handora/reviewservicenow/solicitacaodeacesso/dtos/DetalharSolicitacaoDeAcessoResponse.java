package br.com.zup.handora.reviewservicenow.solicitacaodeacesso.dtos;

import java.time.LocalDateTime;

import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcesso;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.enums.EstadoSolicitacao;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.enums.RespostaPCD;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.enums.TipoSolicitacao;

public class DetalharSolicitacaoDeAcessoResponse {

    private Long id;
    private String nomeSolicitante;
    private String email;
    private String notebook;
    private String nomeAprovador;
    private String pod;
    private String projeto;
    private RespostaPCD respostaPcd;
    private String emNomeDe;
    private TipoSolicitacao tipoSolicitacao;
    private String funcao;
    private LocalDateTime criadoEm;
    private EstadoSolicitacao estadoSolicitacao;

    public DetalharSolicitacaoDeAcessoResponse() {}

    public DetalharSolicitacaoDeAcessoResponse(SolicitacaoDeAcesso sda) {
        this.id = sda.getId();
        this.nomeSolicitante = sda.getNomeSolicitante();
        this.email = sda.getEmail();
        this.notebook = sda.getNotebook();
        this.nomeAprovador = sda.getNomeAprovador();
        this.pod = sda.getPod();
        this.projeto = sda.getProjeto();
        this.respostaPcd = sda.getRespostaPcd();
        this.emNomeDe = sda.getEmNomeDe();
        this.tipoSolicitacao = sda.getTipoSolicitacao();
        this.funcao = sda.getFuncao();
        this.criadoEm = sda.getCriadoEm();
        this.estadoSolicitacao = sda.getEstadoSolicitacao();
    }

    public Long getId() {
        return id;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public String getEmail() {
        return email;
    }

    public String getNotebook() {
        return notebook;
    }

    public String getNomeAprovador() {
        return nomeAprovador;
    }

    public String getPod() {
        return pod;
    }

    public String getProjeto() {
        return projeto;
    }

    public RespostaPCD getRespostaPcd() {
        return respostaPcd;
    }

    public String getEmNomeDe() {
        return emNomeDe;
    }

    public TipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public String getFuncao() {
        return funcao;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public EstadoSolicitacao getEstadoSolicitacao() {
        return estadoSolicitacao;
    }

}
