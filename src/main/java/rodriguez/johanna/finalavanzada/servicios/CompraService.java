package rodriguez.johanna.finalavanzada.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rodriguez.johanna.finalavanzada.entidades.Compra;
import rodriguez.johanna.finalavanzada.repositorios.CompraRepositorio;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepositorio compraRepo;

    @Transactional
    public void crearCompra(Compra compra){

        compraRepo.save(compra);
    }


    public List<Compra> listarCompras(){
        return compraRepo.findAll();
    }


    public Compra encontrarCompraPorId(long id){

        return compraRepo.findCompraById(id);

    }

    public void eliminarCompra(long id){

        Compra compraToDelete = compraRepo.findCompraById(id);

        compraRepo.delete(compraToDelete);
    }
}
