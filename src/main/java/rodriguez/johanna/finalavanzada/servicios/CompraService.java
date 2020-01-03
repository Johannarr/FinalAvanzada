package rodriguez.johanna.finalavanzada.servicios;

import org.springframework.stereotype.Service;
import rodriguez.johanna.finalavanzada.entidades.Compra;
import rodriguez.johanna.finalavanzada.entidades.Estado;
import rodriguez.johanna.finalavanzada.repositorios.CompraRepositorio;

import java.util.List;

@Service
public class CompraService {
    final CompraRepositorio compraRepository;

    public CompraService(CompraRepositorio compraRepository) {
        this.compraRepository = compraRepository;
    }

    public void crearCompra(Compra compra){
        compraRepository.save(compra);
    }

    public List<Compra> compraList(){
        return compraRepository.findAll();
    }

    public List<Compra> buscarPorEstado(Estado estado){
        return compraRepository.findAllByEstado(estado);
    }

    public List<Compra> buscarPorUsuarioId(Long usuarioId){
        return compraRepository.findAllByUsuarioId(usuarioId);
    }

    public List<Compra> buscarPorEmpleadoId(Long empleadoId){
        return compraRepository.findAllByEmpleadoId(empleadoId);
    }

    public Compra compraPorId(Long id){
        return compraRepository.findById(id).orElse(null);
    }
}
