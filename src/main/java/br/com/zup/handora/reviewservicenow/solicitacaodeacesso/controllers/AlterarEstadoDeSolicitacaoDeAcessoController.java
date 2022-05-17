package br.com.zup.handora.reviewservicenow.solicitacaodeacesso.controllers;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcesso;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcessoRepository;

@RestController
@RequestMapping(AlterarEstadoDeSolicitacaoDeAcessoController.BASE_URI + "/{id}")
public class AlterarEstadoDeSolicitacaoDeAcessoController {

    public final static String BASE_URI = "/solicitacoes-de-acesso";

    private final SolicitacaoDeAcessoRepository sdaRepository;

    public AlterarEstadoDeSolicitacaoDeAcessoController(SolicitacaoDeAcessoRepository sdaRepository) {
        this.sdaRepository = sdaRepository;
    }

    @Transactional
    @PatchMapping("/encerrar")
    public ResponseEntity<Void> encerrar(@PathVariable Long id) {
        SolicitacaoDeAcesso sda = sdaRepository.findById(id)
                                               .orElseThrow(
                                                   () -> new ResponseStatusException(
                                                       HttpStatus.NOT_FOUND,
                                                       "Não existe uma solicitação de acesso com o id informado."
                                                   )
                                               );

        sda.encerrar();

        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/reabrir")
    public ResponseEntity<Void> reabrir(@PathVariable Long id) {
        SolicitacaoDeAcesso sda = sdaRepository.findById(id)
                                               .orElseThrow(
                                                   () -> new ResponseStatusException(
                                                       HttpStatus.NOT_FOUND,
                                                       "Não existe uma solicitação de acesso com o id informado."
                                                   )
                                               );

        sda.reabrir();

        return ResponseEntity.noContent().build();
    }

}
