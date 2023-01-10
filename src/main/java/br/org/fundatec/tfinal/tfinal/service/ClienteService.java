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
    public Cliente create(Cliente entity) {
        return this.repository.save(entity);
    }

    @Override
    public Cliente findById(Long idEndereco) {
        return repository.getById(idEndereco);
    }

    @Override
    public Cliente update(Cliente entity) {
        if (entity.getId() == null) {
            throw new RuntimeException("Entidade precisa de um id para atualizar");
        }
        return repository.save(entity);
    }
}
