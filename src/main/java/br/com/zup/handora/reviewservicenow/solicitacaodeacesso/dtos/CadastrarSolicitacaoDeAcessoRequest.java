package br.com.zup.handora.reviewservicenow.solicitacaodeacesso.dtos;

import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.handora.reviewservicenow.projeto.Projeto;
import br.com.zup.handora.reviewservicenow.projeto.ProjetoRepository;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcesso;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.enums.RespostaPCD;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.enums.TipoSolicitacao;
import br.com.zup.handora.reviewservicenow.usuario.Usuario;
import br.com.zup.handora.reviewservicenow.usuario.UsuarioRepository;

public class CadastrarSolicitacaoDeAcessoRequest {

    @NotNull
    @Positive
    private Long solicitanteId;

    @Positive
    private Long notebookId;

    @NotNull
    @Positive
    private Long projetoId;

    @NotNull
    private RespostaPCD respostaPCD;

    @NotNull
    @Positive
    private Long emNomeDeId;

    @NotNull
    private TipoSolicitacao tipoSolicitacao;

    private String funcao;

    public CadastrarSolicitacaoDeAcessoRequest() {}

    public CadastrarSolicitacaoDeAcessoRequest(@NotNull @Positive Long solicitanteId,
                                               @Positive Long notebookId,
                                               @NotNull @Positive Long projetoId,
                                               @NotNull RespostaPCD respostaPCD,
                                               @NotNull @Positive Long emNomeDeId,
                                               @NotNull TipoSolicitacao tipoSolicitacao,
                                               String funcao) {
        this.solicitanteId = solicitanteId;
        this.notebookId = notebookId;
        this.projetoId = projetoId;
        this.respostaPCD = respostaPCD;
        this.emNomeDeId = emNomeDeId;
        this.tipoSolicitacao = tipoSolicitacao;
        this.funcao = funcao;
    }

    public SolicitacaoDeAcesso toModel(UsuarioRepository usuarioRepository,
                                       ProjetoRepository projetoRepository) {
        Usuario solicitante = usuarioRepository.findById(solicitanteId)
                                               .orElseThrow(
                                                   () -> new ResponseStatusException(
                                                       HttpStatus.NOT_FOUND,
                                                       "Solicitante n??o encontrado."
                                                   )
                                               );

        String modeloNotebook = Optional.ofNullable(solicitante.getNotebooks().get(notebookId))
                                        .orElseThrow(
                                            () -> new ResponseStatusException(
                                                HttpStatus.UNPROCESSABLE_ENTITY,
                                                "O solicitante n??o possui um notebook do modelo fornecido."
                                            )
                                        );
        String notebook = notebookId + " - " + modeloNotebook;

        Projeto projeto = projetoRepository.findById(projetoId)
                                           .orElseThrow(
                                               () -> new ResponseStatusException(
                                                   HttpStatus.NOT_FOUND, "Projeto n??o encontrado."
                                               )
                                           );

        Usuario emNomeDe = usuarioRepository.findById(emNomeDeId)
                                            .orElseThrow(
                                                () -> new ResponseStatusException(
                                                    HttpStatus.NOT_FOUND,
                                                    "Usu??rio no nome do qual ser?? feita a solicita????o n??o encontrado."
                                                )
                                            );

        return new SolicitacaoDeAcesso(
            solicitante.getNome(), solicitante.getEmail(), notebook,
            solicitante.getAprovador().getNome(), solicitante.getPod(), projeto.getNome(),
            respostaPCD, emNomeDe.getNome(), tipoSolicitacao, funcao
        );
    }

    public Long getSolicitanteId() {
        return solicitanteId;
    }

    public Long getNotebookId() {
        return notebookId;
    }

    public Long getProjetoId() {
        return projetoId;
    }

    public RespostaPCD getRespostaPCD() {
        return respostaPCD;
    }

    public Long getEmNomeDeId() {
        return emNomeDeId;
    }

    public TipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public String getFuncao() {
        return funcao;
    }

}
