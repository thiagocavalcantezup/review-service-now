package br.com.zup.handora.reviewservicenow.solicitacaodeacesso.controllers;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcesso;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcessoRepository;

@RestController
@RequestMapping(RemoverSolicitacaoDeAcessoController.BASE_URI + "/{id}")
public class RemoverSolicitacaoDeAcessoController {

    public final static String BASE_URI = "/solicitacoes-de-acesso";

    private final SolicitacaoDeAcessoRepository sdaRepository;

    public RemoverSolicitacaoDeAcessoController(SolicitacaoDeAcessoRepository sdaRepository) {
        this.sdaRepository = sdaRepository;
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<?> remover(@PathVariable Long id) {
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
