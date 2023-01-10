package br.org.fundatec.tfinal.tfinal.controller;

import br.org.fundatec.tfinal.tfinal.model.Endereco;
import br.org.fundatec.tfinal.tfinal.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador Spring para Manipular Endereços
 */
@RestController // Diz ao spring que é um controlador
@RequestMapping(path = "/endereco") // mapeia a url para qual o controlador vai responder
public class EnderecoCtrl {
    private final EnderecoService service;

    public EnderecoCtrl(EnderecoService service) {
        this.service = service;
    }

    /**
     * Cria um novo endereço
     * @param endereco Informações de endereço
     * @return CREATED se criado com sucesso
     */
    @PostMapping
    public ResponseEntity create(@RequestBody Endereco endereco) {
        service.create(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
