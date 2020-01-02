package rodriguez.johanna.finalavanzada.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rodriguez.johanna.finalavanzada.entidades.Empleado;
import rodriguez.johanna.finalavanzada.entidades.Paquete;
import rodriguez.johanna.finalavanzada.repositorios.EmpleadoRepositorio;
import rodriguez.johanna.finalavanzada.repositorios.PaqueteRepositorio;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepositorio paqueteRepo;


    @Transactional
    public void crearPaquete(Paquete paquete){

        paqueteRepo.save(paquete);
    }


    public List<Paquete> listarPaquetes(){

        return paqueteRepo.findAll();
    }


    public Paquete encontrarPaquetePorId(long id){

        return paqueteRepo.findPaqueteById(id);
    }


    public void eliminarPaquete(long id){

        Paquete paqueteToDelete = paqueteRepo.findPaqueteById(id);

        paqueteRepo.delete(paqueteToDelete);
    }
}
