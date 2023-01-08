package br.org.fundatec.tfinal.tfinal.controller;

import br.org.fundatec.tfinal.tfinal.model.Endereco;
import br.org.fundatec.tfinal.tfinal.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/endereco")
public class EnderecoCtrl {
    private final EnderecoService service;

    public EnderecoCtrl(EnderecoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Endereco endereco) {
        service.create(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
