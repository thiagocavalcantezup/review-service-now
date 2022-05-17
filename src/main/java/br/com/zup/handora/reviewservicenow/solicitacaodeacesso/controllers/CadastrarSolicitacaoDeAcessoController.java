package br.com.zup.handora.reviewservicenow.solicitacaodeacesso.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.reviewservicenow.projeto.ProjetoRepository;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcesso;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcessoRepository;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.dtos.CadastrarSolicitacaoDeAcessoRequest;
import br.com.zup.handora.reviewservicenow.usuario.UsuarioRepository;

@RestController
@RequestMapping(CadastrarSolicitacaoDeAcessoController.BASE_URI)
public class CadastrarSolicitacaoDeAcessoController {

    public final static String BASE_URI = "/solicitacoes-de-acesso";

    private final SolicitacaoDeAcessoRepository sdaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProjetoRepository projetoRepository;

    public CadastrarSolicitacaoDeAcessoController(SolicitacaoDeAcessoRepository sdaRepository,
                                                  UsuarioRepository usuarioRepository,
                                                  ProjetoRepository projetoRepository) {
        this.sdaRepository = sdaRepository;
        this.usuarioRepository = usuarioRepository;
        this.projetoRepository = projetoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastrarSolicitacaoDeAcessoRequest cadastrarSdaRequest,
                                       UriComponentsBuilder ucb) {
        SolicitacaoDeAcesso sda = sdaRepository.save(
            cadastrarSdaRequest.toModel(usuarioRepository, projetoRepository)
        );

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(sda.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
