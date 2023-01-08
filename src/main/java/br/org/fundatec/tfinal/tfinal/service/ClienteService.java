package br.org.fundatec.tfinal.tfinal.service;

import br.org.fundatec.tfinal.tfinal.model.Cliente;
import br.org.fundatec.tfinal.tfinal.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements CrudService<Cliente> {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Cliente entity) {
        this.repository.save(entity);
    }

    @Override
    public Cliente findById(Long idEndereco) {
        return repository.getById(idEndereco);
    }
}
