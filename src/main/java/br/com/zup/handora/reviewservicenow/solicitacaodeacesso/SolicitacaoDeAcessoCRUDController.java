package br.com.zup.handora.reviewservicenow.solicitacaodeacesso;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.reviewservicenow.projeto.ProjetoRepository;
import br.com.zup.handora.reviewservicenow.usuario.UsuarioRepository;

@RestController
@RequestMapping(SolicitacaoDeAcessoCRUDController.BASE_URI)
public class SolicitacaoDeAcessoCRUDController {

    public final static String BASE_URI = "/solicitacoes-de-acesso";

    private final SolicitacaoDeAcessoRepository sdaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProjetoRepository projetoRepository;

    public SolicitacaoDeAcessoCRUDController(SolicitacaoDeAcessoRepository sdaRepository,
                                             UsuarioRepository usuarioRepository,
                                             ProjetoRepository projetoRepository) {
        this.sdaRepository = sdaRepository;
        this.usuarioRepository = usuarioRepository;
        this.projetoRepository = projetoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid SolicitacaoDeAcessoCadastrarRequest sdaCadastrarRequest,
                                       UriComponentsBuilder ucb) {
        SolicitacaoDeAcesso sda = sdaRepository.save(
            sdaCadastrarRequest.toModel(usuarioRepository, projetoRepository)
        );

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(sda.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        SolicitacaoDeAcesso sda = sdaRepository.findById(id)
                                               .orElseThrow(
                                                   () -> new ResponseStatusException(
                                                       HttpStatus.NOT_FOUND,
                                                       "Não existe uma solicitação de acesso com o id informado."
                                                   )
                                               );

        sdaRepository.delete(sda);

        return ResponseEntity.noContent().build();
    }

}
