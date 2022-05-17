package br.com.zup.handora.reviewservicenow.solicitacaodeacesso.controllers;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcesso;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcessoRepository;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.dtos.DetalharSolicitacaoDeAcessoResponse;

@RestController
@RequestMapping(DetalharSolicitacaoDeAcessoController.BASE_URI + "/{id}")
public class DetalharSolicitacaoDeAcessoController {

    public final static String BASE_URI = "/solicitacoes-de-acesso";

    private final SolicitacaoDeAcessoRepository sdaRepository;

    public DetalharSolicitacaoDeAcessoController(SolicitacaoDeAcessoRepository sdaRepository) {
        this.sdaRepository = sdaRepository;
    }

    @Transactional
    @GetMapping
    public ResponseEntity<?> detalhar(@PathVariable Long id) {
        SolicitacaoDeAcesso sda = sdaRepository.findById(id)
                                               .orElseThrow(
                                                   () -> new ResponseStatusException(
                                                       HttpStatus.NOT_FOUND,
                                                       "Não existe uma solicitação de acesso com o id informado."
                                                   )
                                               );

        return ResponseEntity.ok(new DetalharSolicitacaoDeAcessoResponse(sda));
    }

}
