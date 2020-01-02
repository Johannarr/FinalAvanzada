package rodriguez.johanna.finalavanzada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rodriguez.johanna.finalavanzada.entidades.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository <Empleado, Long> {

    Empleado findEmpleadoById (long id);
}
