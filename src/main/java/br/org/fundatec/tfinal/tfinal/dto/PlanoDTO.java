package br.org.fundatec.tfinal.tfinal.dto;

import br.org.fundatec.tfinal.tfinal.model.Cliente;

public class PlanoDTO {
    private Double valor;
    private Long idCliente;

    public PlanoDTO() {

    }

    public PlanoDTO(Double valor, Long idCliente) {
        this.valor = valor;
        this.idCliente = idCliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
