package rodriguez.johanna.finalavanzada.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rodriguez.johanna.finalavanzada.entidades.*;
import rodriguez.johanna.finalavanzada.servicios.ClienteService;
import rodriguez.johanna.finalavanzada.servicios.CompraService;
import rodriguez.johanna.finalavanzada.servicios.EmpleadoService;
import rodriguez.johanna.finalavanzada.servicios.PlanService;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    //Mandando a compra los clientes y equipos ya creados, por lo tanto instanciare equiposervices y clienteservices
    @Autowired
    private PlanService planService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping("/")
    public String index(Model model, Principal principal, Locale locale) {

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "MULTIMEDIA E&J CXA");

        //Aqui mandare las distintas traducciones de i18n al index
        model.addAttribute("clientesi18n", messageSource.getMessage("clientesi18n", null, locale));
        model.addAttribute("planesi18n", messageSource.getMessage("planesi18n", null, locale));
        model.addAttribute("negocioi18n", messageSource.getMessage("negocioi18n", null, locale));
        model.addAttribute("comprai18n", messageSource.getMessage("comprai18n", null, locale));
        model.addAttribute("administradori18n", messageSource.getMessage("administradori18n", null, locale));
        model.addAttribute("usuariosi18n", messageSource.getMessage("usuariosi18n", null, locale));
        model.addAttribute("fechai18n", messageSource.getMessage("fechai18n", null, locale));
        model.addAttribute("fechaeventoi18n", messageSource.getMessage("fechaeventoi18n", null, locale));
        model.addAttribute("listacomprai18n", messageSource.getMessage("listacomprai18n", null, locale));
        model.addAttribute("agregarcomprai18n", messageSource.getMessage("agregarcomprai18n", null, locale));
        model.addAttribute("clientecomprai18n", messageSource.getMessage("clientecomprai18n", null, locale));
        model.addAttribute("totalcomprai18n", messageSource.getMessage("totalcomprai18n", null, locale));
        model.addAttribute("opcionei18n", messageSource.getMessage("opcionei18n", null, locale));

        model.addAttribute("compras", compraService.listarCompras());


        model.addAttribute("usuario", principal.getName());

        return "/freemarker/compra";
    }


    @RequestMapping("/creacion")
    public String creacionCompra(Model model, Locale locale) {

        model.addAttribute("agregarcomprai18n", messageSource.getMessage("agregarcomprai18n", null, locale));
        model.addAttribute("clientecomprai18n", messageSource.getMessage("clientecomprai18n", null, locale));
        model.addAttribute("empleadocomprai18n", messageSource.getMessage("empleadocomprai18n", null, locale));
        model.addAttribute("plancomprai18n", messageSource.getMessage("plancomprai18n", null, locale));
        model.addAttribute("fechai18n", messageSource.getMessage("fechai18n", null, locale));
        model.addAttribute("fechaeventoi18n", messageSource.getMessage("fechaeventoi18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));
        model.addAttribute("titulo", "E&J CXA");

        // Para poder crear un alquiler debo mandarle a la vista crearalquiler todos los equipos y clientes ya creados
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("planes", planService.listarPlanes());
        model.addAttribute("empleados", empleadoService.listarEmpleados());

        return "/freemarker/crearcompra";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearCompra( @RequestParam(name = "idPlanes" , required = false) List<Long> idPlanes, @RequestParam(name = "idCliente") long idCliente, @RequestParam(name = "idEmpleado") long idEmpleado,  @RequestParam(name = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha, @RequestParam(name = "fechaEvento") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEvento, @RequestParam(name = "total", required = false)  int total, @RequestParam(name = "estado") Estado estado) {

        List<Plan> listaPlanes = new ArrayList<>();

        Cliente cliente = clienteService.encontrarClientePorId(idCliente);

        Empleado empleadoAsignado = empleadoService.encontrarEmpleadoPorId(idEmpleado);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        Calendar calendarEvento = Calendar.getInstance();
        calendarEvento.setTime(fechaEvento);

        for (Long planesId:idPlanes){

            Plan planCompra = planService.encontrarPlanPorId(planesId);

            total+= planCompra.getCosto();
        }

        Compra compraToCreate = new Compra(listaPlanes,cliente,empleadoAsignado,fecha,fechaEvento,total,estado);

        compraService.crearCompra(compraToCreate);

        return "redirect:/compra/";
    }


    @RequestMapping( value = "/mostrar")
    public String mostrarCompras(Model model, Locale locale, @RequestParam(name = "id") long id) {

        Compra compraToShow = compraService.encontrarCompraPorId(id);

        model.addAttribute("titulo", "E&J CXA");
        model.addAttribute("clientesi18n", messageSource.getMessage("clientesi18n", null, locale));
        model.addAttribute("planesi18n", messageSource.getMessage("planesi18n", null, locale));
        model.addAttribute("negocioi18n", messageSource.getMessage("negocioi18n", null, locale));
        model.addAttribute("comprai18n", messageSource.getMessage("comprai18n", null, locale));
        model.addAttribute("administradori18n", messageSource.getMessage("administradori18n", null, locale));
        model.addAttribute("usuariosi18n", messageSource.getMessage("usuariosi18n", null, locale));
        model.addAttribute("nombreplani18n", messageSource.getMessage("nombreplani18n", null, locale));
        model.addAttribute("costoplani18n", messageSource.getMessage("costoplani18n", null, locale));
        model.addAttribute("fechai18n", messageSource.getMessage("fechai18n", null, locale));
        model.addAttribute("fechaeventoi18n", messageSource.getMessage("fechaeventoi18n", null, locale));

        model.addAttribute("compra", compraToShow);

        // envio los equipos que estan almacenado en el alquiler mediante la lista equipos
        model.addAttribute("planes", compraToShow.getPlanes());

        return "/freemarker/mostrarcompras";

    }
}


