package br.org.fundatec.tfinal.tfinal.controller;

import br.org.fundatec.tfinal.tfinal.dto.ClienteDTO;
import br.org.fundatec.tfinal.tfinal.model.Cliente;
import br.org.fundatec.tfinal.tfinal.model.Endereco;
import br.org.fundatec.tfinal.tfinal.service.ClienteService;
import br.org.fundatec.tfinal.tfinal.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteCtrl {
    private final ClienteService service;
    private final EnderecoService enderecoService;

    public ClienteCtrl(ClienteService service, EnderecoService enderecoService) {
        this.service = service;
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ClienteDTO clienteDTO) {
        Endereco endereco = enderecoService.findById(clienteDTO.getIdEndereco());
        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado o endereco de id " + clienteDTO.getIdEndereco());
        }

        Cliente cliente = new Cliente();
        cliente.setCpf(cliente.getCpf());
        cliente.setEndereco(endereco);
        // todo setar plano

        service.create(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).build();


    }
}
