package rodriguez.johanna.finalavanzada.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rodriguez.johanna.finalavanzada.entidades.Compra;
import rodriguez.johanna.finalavanzada.entidades.Estado;
import rodriguez.johanna.finalavanzada.servicios.CompraService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/compra", method = RequestMethod.GET)
public class CompraController {

    final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<Compra>> listaCompras() {
        return new ResponseEntity<>(compraService.compraList(), HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Compra> crearCompra(@RequestBody Compra compra) {
        compraService.crearCompra(compra);
        return new ResponseEntity<>(compra, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Compra> compraPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(compraService.compraPorId(id), HttpStatus.OK);
    }


    @GetMapping(path = "/estado")
    public ResponseEntity<List<Compra>> listaCompraPorEstado(@RequestParam("estado") String estado) {

        Estado estado1;
        try {

            estado1 = Estado.valueOf(estado);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(compraService.buscarPorEstado(estado1), HttpStatus.OK);

    }

    @GetMapping(path = "/usuario")
    public ResponseEntity<List<Compra>> listaCompraPorUsuario(@RequestParam("id") Long id) {

        return new ResponseEntity<>(compraService.buscarPorUsuarioId(id), HttpStatus.OK);
    }
    @GetMapping(path = "/empleado")
    public ResponseEntity<List<Compra>> listaCompraPorEmpleado(@RequestParam("id") Long id) {

        return new ResponseEntity<>(compraService.buscarPorEmpleadoId(id), HttpStatus.OK);

    }

}
