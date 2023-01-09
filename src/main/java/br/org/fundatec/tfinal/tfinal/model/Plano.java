package br.org.fundatec.tfinal.tfinal.model;

import javax.persistence.*;

@Entity
public class Plano  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valor;

    @OneToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente assinante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getAssinante() {
        return assinante;
    }

    public void setAssinante(Cliente assinante) {
        this.assinante = assinante;
    }
}
