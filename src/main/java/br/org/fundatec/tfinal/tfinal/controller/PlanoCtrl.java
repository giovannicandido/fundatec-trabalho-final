package br.org.fundatec.tfinal.tfinal.controller;

import br.org.fundatec.tfinal.tfinal.dto.PlanoDTO;
import br.org.fundatec.tfinal.tfinal.service.PlanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.org.fundatec.tfinal.tfinal.dto.PlanoPersistDTO;

@RestController
@RequestMapping("/plano")
public class PlanoCtrl {
    private final PlanoService planoService;

    public PlanoCtrl(PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping(path = "/cliente/{id}")
    public ResponseEntity<PlanoDTO> findByClienteId(@PathVariable Long id) {
        PlanoDTO plano = planoService.findPlanoByClienteId(id);
        if (plano == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(plano);
    }
    
    @PostMapping
    public ResponseEntity create(@RequestBody PlanoPersistDTO plano) {
        // todo validar se plano já não existe para o cliente
        Cliente cliente = clienteService.findById(plano.getIdCliente());
        Plano planoEntity = new Plano();
        planoEntity.setValor(plano.getValor());
        planoEntity.setAssinante(cliente);
        planoService.create(planoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/recarga")
    public ResponseEntity recarga(@RequestBody PlanoPersistDTO planoDTO) {
        // todo recarga de plano
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
