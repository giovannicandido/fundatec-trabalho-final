package br.org.fundatec.tfinal.tfinal.service;

import br.org.fundatec.tfinal.tfinal.dto.PlanoDTO;
import br.org.fundatec.tfinal.tfinal.model.Plano;
import br.org.fundatec.tfinal.tfinal.repository.PlanoRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {
    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public PlanoDTO findPlanoByClienteId(Long clienteId) {
//        Plano plano = planoRepository.findByAssinanteId(id);
//        if (plano == null) {
//            return null;
//        }
//        PlanoDTO dto = new PlanoDTO();
//        dto.setValor(plano.getValor());
//        ClienteDTO clienteDTO = new ClienteDTO();
//        clienteDTO.setCpf(plano.getAssinante().getCpf());
//        clienteDTO.setIdEndereco(plano.getAssinante().getEndereco().getId());
//        dto.setCliente(clienteDTO);
        return planoRepository.findPlanoDTOByAssinanteId(clienteId);
    }

    public void create(Plano planoEntity) {
        planoRepository.save(planoEntity);
    }
}
