package rodriguez.johanna.finalavanzada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rodriguez.johanna.finalavanzada.entidades.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository <Cliente, Long> {

    Cliente findClienteById(long id);
}
