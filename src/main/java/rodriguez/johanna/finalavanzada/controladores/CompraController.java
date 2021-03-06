package rodriguez.johanna.finalavanzada.controladores;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rodriguez.johanna.finalavanzada.entidades.*;
import rodriguez.johanna.finalavanzada.servicios.*;

import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private UsuarioService usuarioService;

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

        return "/freemarker/compraprueba";
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
    @RequestMapping("/prueba")
    public String pruebaCompra(Model model,Principal principal, Locale locale) {

        model.addAttribute("agregarcomprai18n", messageSource.getMessage("agregarcomprai18n", null, locale));
        model.addAttribute("clientecomprai18n", messageSource.getMessage("clientecomprai18n", null, locale));
        model.addAttribute("empleadocomprai18n", messageSource.getMessage("empleadocomprai18n", null, locale));
        model.addAttribute("plancomprai18n", messageSource.getMessage("plancomprai18n", null, locale));
        model.addAttribute("fechai18n", messageSource.getMessage("fechai18n", null, locale));
        model.addAttribute("fechaeventoi18n", messageSource.getMessage("fechaeventoi18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));
        model.addAttribute("titulo", "E&J CXA");
        model.addAttribute("usuarios", usuarioService.listarUsuarios());

        model.addAttribute("usuario", principal.getName());
        // Para poder crear un alquiler debo mandarle a la vista crearalquiler todos los equipos y clientes ya creados
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("planes", planService.listarPlanes());
        model.addAttribute("empleados", empleadoService.listarEmpleados());

        return "/freemarker/compraprueba";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearCompra(@AuthenticationPrincipal UserDetails userdetails, @RequestParam(name = "idPlanes", required = false) List<Long> idPlanes, @RequestParam(name = "idEmpleado") Long idEmpleado,
                              @RequestParam(name = "fechaEvento") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEvento, @RequestParam(name = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha, @RequestParam(name = "total", required = false) int total) throws IOException {
//       @RequestParam(name = "estado") Estado estado
        System.out.println("Probando si entra");
        System.out.println(idPlanes);
        System.out.println(idEmpleado);
        System.out.println(fechaEvento);
        System.out.println("Fecha actual: " + fecha);
        System.out.println(total);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Usuario usuario = usuarioService.encontrarUsuarioPorUsername(userDetail.getUsername());
        System.out.println("usuario id: " + usuario.getId() + " " + usuario.getUsername());
        List<Plan> listaPlanes = new ArrayList<>();

     //   Cliente cliente = clienteService.encontrarClientePorId(idCliente);

       Empleado empleadoAsignado = empleadoService.encontrarEmpleadoPorId(idEmpleado);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        Calendar calendarEvento = Calendar.getInstance();
        calendarEvento.setTime(fechaEvento);

        Estado estado = Estado.ENPROCESO;
        for (Long planesId:idPlanes){

            Plan planCompra = planService.encontrarPlanPorId(planesId);

            total+= planCompra.getCosto();
        }

        Compra compraToCreate = new Compra(listaPlanes,usuario,empleadoAsignado,fecha,fechaEvento,total,estado);
        String correo = usuario.getCorreo().toString();
        String empleado = empleadoAsignado.getNombre();
        compraService.crearCompra(compraToCreate);
        CreatedMail(correo,listaPlanes,total,empleado,fechaEvento,estado);
        return "redirect:/compra/prueba";
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
    public void CreatedMail(String correo,List<Plan> planes, int total, String empleado, Date fechaEvento, Estado estado) throws IOException {

        Email from = new Email("departmentoforders@ejmultimedia.com");
        Email to = new Email(correo); // use your own email address here

        String subject = "Orden Realizada";
        Content content = new Content("text/html", "<p><h2>Su compra ha sido realizada de manera exitosa.</h2></p> <p>El detalle de su orden: " + planes + "</p>"+ " <p>Su total es de: "+ total + "</p>"+ "<p>Fotografo: <b>" + empleado + "</b> es elegido para su evento, día: " + fechaEvento +"</p>"+ "<p>Les informamo el estado actual de su orden es: " + estado +"</p>");


        Mail mail = new Mail(from, subject, to, content);
        System.out.println(mail);
        SendGrid sg = new SendGrid (Cambiar Aqui);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sg.api(request);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }
}


