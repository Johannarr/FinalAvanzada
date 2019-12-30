package rodriguez.johanna.finalavanzada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rodriguez.johanna.finalavanzada.entidades.Rol;

@Repository
public interface RolRepositorio extends JpaRepository <Rol, Long> {

    Rol findRolById (long id);
}
