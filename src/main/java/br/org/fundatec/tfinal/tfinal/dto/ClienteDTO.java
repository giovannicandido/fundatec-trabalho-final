package br.org.fundatec.tfinal.tfinal.dto;

public class ClienteDTO {
    private String cpf;
    private Long idEndereco;

    public ClienteDTO(String cpf, Long idEndereco) {
        this.cpf = cpf;
        this.idEndereco = idEndereco;
    }

    public ClienteDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
}
