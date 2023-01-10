package br.org.fundatec.tfinal.tfinal.service;

import br.org.fundatec.tfinal.tfinal.model.Endereco;
import br.org.fundatec.tfinal.tfinal.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements CrudService<Endereco> {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco create(Endereco entity) {
        return this.enderecoRepository.save(entity);
    }

    @Override
    public Endereco findById(Long id) {
        return this.enderecoRepository.findById(id).orElse(null);
    }

    @Override
    public Endereco update(Endereco entity) {
        if (entity.getId() == null) {
            throw new RuntimeException("Entidade precisa de um id para atualizar");
        }
        return enderecoRepository.save(entity);
    }
}
