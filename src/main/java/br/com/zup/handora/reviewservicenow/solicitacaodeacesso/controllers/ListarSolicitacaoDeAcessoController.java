package br.com.zup.handora.reviewservicenow.solicitacaodeacesso.controllers;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.SolicitacaoDeAcessoRepository;
import br.com.zup.handora.reviewservicenow.solicitacaodeacesso.dtos.DetalharSolicitacaoDeAcessoResponse;

@RestController
@RequestMapping(ListarSolicitacaoDeAcessoController.BASE_URI)
public class ListarSolicitacaoDeAcessoController {

    public final static String BASE_URI = "/solicitacoes-de-acesso";

    private final SolicitacaoDeAcessoRepository sdaRepository;

    public ListarSolicitacaoDeAcessoController(SolicitacaoDeAcessoRepository sdaRepository) {
        this.sdaRepository = sdaRepository;
    }

    @Transactional
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(
            sdaRepository.findAll()
                         .stream()
                         .map(DetalharSolicitacaoDeAcessoResponse::new)
                         .collect(Collectors.toList())
        );
    }

}
