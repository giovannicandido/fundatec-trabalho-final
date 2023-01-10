package br.org.fundatec.tfinal.tfinal.dto;

import br.org.fundatec.tfinal.tfinal.model.Cliente;

public class PlanoDTO {
    private Double valor;
    private ClienteDTO cliente;

    public PlanoDTO() {

    }

    public PlanoDTO(Double valor, String clientCPF, Long clienteEnderecoId) {
        this.valor = valor;
        this.cliente = new ClienteDTO(clientCPF, clienteEnderecoId);
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
