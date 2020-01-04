package rodriguez.johanna.finalavanzada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rodriguez.johanna.finalavanzada.entidades.Cliente;
import rodriguez.johanna.finalavanzada.entidades.Compra;
import rodriguez.johanna.finalavanzada.entidades.Empleado;
import rodriguez.johanna.finalavanzada.entidades.Estado;

import java.util.List;

@Repository
public interface CompraRepositorio extends JpaRepository<Compra, Long> {

    Compra findCompraById (long id);

    List<Compra> findAllByCliente(Cliente cliente);
    List<Compra> findAllByEmpleado(Empleado empleado);

    List<Compra> findAllByEstado(Estado estado);
}
