package rodriguez.johanna.finalavanzada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rodriguez.johanna.finalavanzada.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long> {

    Usuario findUsuarioById (long id);
    Usuario findByUsername(String username);
}
