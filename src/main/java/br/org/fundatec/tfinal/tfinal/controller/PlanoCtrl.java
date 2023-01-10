package br.org.fundatec.tfinal.tfinal.controller;

import br.org.fundatec.tfinal.tfinal.dto.PlanoDTO;
import br.org.fundatec.tfinal.tfinal.service.PlanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
