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

/**
 * Controlador Spring que irá receber as requisições para manipular um cliente
 */
@RestController
@RequestMapping("/cliente")
public class ClienteCtrl {
    private final ClienteService service;
    private final EnderecoService enderecoService;

    /**
     * Injeção de dependencias do spring
     * @param service Serviço principal
     * @param enderecoService Serviço de endereço
     */
    public ClienteCtrl(ClienteService service, EnderecoService enderecoService) {
        this.service = service;
        this.enderecoService = enderecoService;
    }

    /**
     * Cria um novo cliente no banco de dados.
     * Necessário ter um endereço com o ID do cliente cadastrado
     * @param clienteDTO Informações do Cliente
     * @return CREATED se persistido com sucesso
     */
    @PostMapping
    public ResponseEntity create(@RequestBody ClienteDTO clienteDTO) {
        Endereco endereco = enderecoService.findById(clienteDTO.getIdEndereco());
        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado o endereco de id " + clienteDTO.getIdEndereco());
        }

        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEndereco(endereco);
        // todo setar plano

        service.create(cliente);
//
//        // Atualiza endereco apontando para cliente
        endereco.setCliente(cliente);
        enderecoService.update(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
