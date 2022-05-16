package br.com.zup.handora.reviewservicenow.solicitacaodeacesso;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.reviewservicenow.projeto.ProjetoRepository;
import br.com.zup.handora.reviewservicenow.usuario.UsuarioRepository;

@RestController
@RequestMapping(SolicitacaoDeAcessoCRUDController.BASE_URI)
public class SolicitacaoDeAcessoCRUDController {

    public final static String BASE_URI = "/solicitacoes-de-acesso";

    private final SolicitacaoDeAcessoRepository solicitacaoDeAcessoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProjetoRepository projetoRepository;

    public SolicitacaoDeAcessoCRUDController(SolicitacaoDeAcessoRepository solicitacaoDeAcessoRepository,
                                             UsuarioRepository usuarioRepository,
                                             ProjetoRepository projetoRepository) {
        this.solicitacaoDeAcessoRepository = solicitacaoDeAcessoRepository;
        this.usuarioRepository = usuarioRepository;
        this.projetoRepository = projetoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid SolicitacaoDeAcessoCadastrarRequest solicitacaoDeAcessoCadastrarRequest,
                                       UriComponentsBuilder ucb) {
        SolicitacaoDeAcesso solicitacaoDeAcesso = solicitacaoDeAcessoRepository.save(
            solicitacaoDeAcessoCadastrarRequest.toModel(usuarioRepository, projetoRepository)
        );

        URI location = ucb.path(BASE_URI + "/{id}")
                          .buildAndExpand(solicitacaoDeAcesso.getId())
                          .toUri();

        return ResponseEntity.created(location).build();
    }

}
