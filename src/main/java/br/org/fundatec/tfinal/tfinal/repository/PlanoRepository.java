package br.org.fundatec.tfinal.tfinal.repository;

import br.org.fundatec.tfinal.tfinal.dto.PlanoDTO;
import br.org.fundatec.tfinal.tfinal.model.Cliente;
import br.org.fundatec.tfinal.tfinal.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    Plano findByAssinante(Cliente cliente);
    @Query("select c from Plano c join c.assinante a where a.id = :id")
    Plano findByAssinanteId(@Param("id") Long id);

    @Query("select new br.org.fundatec.tfinal.tfinal.dto.PlanoDTO(p.valor, a.id) " +
            "from Plano p join p.assinante a where a.id = :id")
    PlanoDTO findPlanoDTOByAssinanteId(@Param("id") Long id);
}
