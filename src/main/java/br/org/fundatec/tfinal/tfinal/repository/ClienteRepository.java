package br.org.fundatec.tfinal.tfinal.repository;

import br.org.fundatec.tfinal.tfinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
