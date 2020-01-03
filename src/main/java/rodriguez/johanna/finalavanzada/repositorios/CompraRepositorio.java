package rodriguez.johanna.finalavanzada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rodriguez.johanna.finalavanzada.entidades.Compra;
import rodriguez.johanna.finalavanzada.entidades.Estado;

import java.util.List;

@Repository
public interface CompraRepositorio extends JpaRepository<Compra, Long> {

    List<Compra> findAllByUsuarioId(Long id);
    List<Compra> findAllByEmpleadoId(Long id);

    List<Compra> findAllByEstado(Estado estado);
}