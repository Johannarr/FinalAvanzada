package rodriguez.johanna.finalavanzada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rodriguez.johanna.finalavanzada.entidades.Paquete;

@Repository
public interface PaqueteRepositorio extends JpaRepository<Paquete, Long> {

        Paquete findPaqueteById(long id);
}

