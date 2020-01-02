package rodriguez.johanna.finalavanzada.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rodriguez.johanna.finalavanzada.entidades.Empleado;
import rodriguez.johanna.finalavanzada.repositorios.EmpleadoRepositorio;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepositorio empleadoRepo;


    @Transactional
    public void crearEmpleado(Empleado empleado){

        empleadoRepo.save(empleado);
    }


    public List<Empleado> listarEmpleados(){

        return empleadoRepo.findAll();
    }


    public Empleado encontrarEmpleadoPorId(long id){

        return empleadoRepo.findEmpleadoById(id);
    }


    public void eliminarEmpleado(long id){

        Empleado empleadoToDelete = empleadoRepo.findEmpleadoById(id);

        empleadoRepo.delete(empleadoToDelete);
    }
}
