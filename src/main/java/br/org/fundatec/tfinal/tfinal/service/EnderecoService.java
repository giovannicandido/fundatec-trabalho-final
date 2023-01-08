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
    public void create(Endereco entity) {
        this.enderecoRepository.save(entity);
    }

    @Override
    public Endereco findById(Long idEndereco) {
        return this.enderecoRepository.getById(idEndereco);
    }
}
