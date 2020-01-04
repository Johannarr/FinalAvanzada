package rodriguez.johanna.finalavanzada.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import rodriguez.johanna.finalavanzada.entidades.Cliente;
import rodriguez.johanna.finalavanzada.servicios.ClienteService;
import rodriguez.johanna.finalavanzada.servicios.CompraService;

import java.security.Principal;
import java.util.Locale;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CompraService compraService;

    //Instancio esta dependencia para la internacionalizacion
    @Autowired
    private MessageSource messageSource;


    // Para conseguir el nombre de usuario mediante spring security debo especificar un objeto de la clase principal aqui
    // para implementar las traducciones de i18n uso Locale
    @RequestMapping("/")
    public String index(Model model, Principal principal, Locale locale){

        model.addAttribute("titulo", "E&J CXA");
        model.addAttribute("clientesi18n", messageSource.getMessage("clientesi18n", null, locale));
        model.addAttribute("planesi18n", messageSource.getMessage("planesi18n", null, locale));
        model.addAttribute("negocioi18n", messageSource.getMessage("negocioi18n", null, locale));
        model.addAttribute("comprai18n", messageSource.getMessage("comprai18n", null, locale));
        model.addAttribute("administradori18n", messageSource.getMessage("administradori18n", null, locale));
        model.addAttribute("usuariosi18n", messageSource.getMessage("usuariosi18n", null, locale));
        model.addAttribute("listaclientei18n", messageSource.getMessage("listaclientei18n", null, locale));
        model.addAttribute("agregarclientei18n", messageSource.getMessage("agregarclientei18n", null, locale));
        model.addAttribute("nombreclientei18n", messageSource.getMessage("nombreclientei18n", null, locale));
        model.addAttribute("apellidoclientei18n", messageSource.getMessage("apellidoclientei18n", null, locale));
        model.addAttribute("cedulaclientei18n", messageSource.getMessage("cedulaclientei18n", null, locale));
        model.addAttribute("direccionclientei18n", messageSource.getMessage("direccionclientei18n", null, locale));
        model.addAttribute("telefonoclientei18n", messageSource.getMessage("telefonoclientei18n", null, locale));
        model.addAttribute("correoclientei18n", messageSource.getMessage("correoclientei18n", null, locale));
        model.addAttribute("opcionei18n", messageSource.getMessage("opcionei18n", null, locale));

        model.addAttribute("clientes", clienteService.listarClientes());

        model.addAttribute("usuario", principal.getName());

        return "/freemarker/cliente";
    }


    @RequestMapping("/creacion")
    public String creacionCliente(Model model, Locale locale){

        model.addAttribute("titulo", "E&J CXA");
        model.addAttribute("agregarclientei18n", messageSource.getMessage("agregarclientei18n", null, locale));
        model.addAttribute("nombreclientei18n", messageSource.getMessage("nombreclientei18n", null, locale));
        model.addAttribute("apellidoclientei18n", messageSource.getMessage("apellidoclientei18n", null, locale));
        model.addAttribute("cedulaclientei18n", messageSource.getMessage("cedulaclientei18n", null, locale));
        model.addAttribute("direccionclientei18n", messageSource.getMessage("direccionclientei18n", null, locale));
        model.addAttribute("telefonoclientei18n", messageSource.getMessage("telefonoclientei18n", null, locale));
        model.addAttribute("correoclientei18n", messageSource.getMessage("correoclientei18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));

        return "/freemarker/crearcliente";
    }


    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearCliente(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "apellido") String apellido, @RequestParam(name = "cedula") String cedula, @RequestParam(name = "direccion") String direccion, @RequestParam(name = "telefono") String telefono, @RequestParam(name="correo") String correo){

        // Agregando los parametros al cliente, no es necesario agregar el parametro id ya que se autogenerara cuando especificamos la entidad
        Cliente cliente = new Cliente(nombre,apellido,cedula,direccion,telefono,correo);

        // Insertando cliente
        clienteService.crearCliente(cliente);

        return "redirect:/cliente/";
    }


    @RequestMapping(value = "/edicion" )
    public String edicionCliente(Model model, Locale locale,  @RequestParam(name = "id") long id ){

        //Obtengo el cliente que voy a editar
        Cliente clienteToEdit = clienteService.encontrarClientePorId(id);

        //Aqui le mando el cliente que editaremos a la vista de editar cliente
        model.addAttribute("cliente",clienteToEdit);
        model.addAttribute("titulo", "E&J CXA");
        model.addAttribute("editarclientei18n", messageSource.getMessage("editarclientei18n", null, locale));
        model.addAttribute("nombreclientei18n", messageSource.getMessage("nombreclientei18n", null, locale));
        model.addAttribute("apellidoclientei18n", messageSource.getMessage("apellidoclientei18n", null, locale));
        model.addAttribute("cedulaclientei18n", messageSource.getMessage("cedulaclientei18n", null, locale));
        model.addAttribute("direccionclientei18n", messageSource.getMessage("direccionclientei18n", null, locale));
        model.addAttribute("telefonoclientei18n", messageSource.getMessage("telefonoclientei18n", null, locale));
        model.addAttribute("correoclientei18n", messageSource.getMessage("correoclientei18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));

        return "/freemarker/editarcliente";
    }

    // obtengo el cliente de la vista con requesparam y le mando el parametro con /?id=cliente.id
    // desde la vista hacia esta funcion mediante la url
    @RequestMapping("/editar")
    public String editarCliente(@RequestParam(name = "id") long id,@RequestParam(name = "nombre") String nombre, @RequestParam(name = "apellido") String apellido, @RequestParam(name = "cedula") String cedula, @RequestParam(name = "direccion") String direccion,  @RequestParam(name = "telefono") String telefono, @RequestParam(name = "correo") String correo){

        // Busco el cliente y lo almaceno encontrado en el objeto clienteToEdit
        Cliente clienteToEdit = clienteService.encontrarClientePorId(id);

        //Agrego los campos editados mediante las propiedades set de la clase
        clienteToEdit.setApellido(apellido);
        clienteToEdit.setCedula(cedula);
        clienteToEdit.setDireccion(direccion);
        clienteToEdit.setNombre(nombre);
        clienteToEdit.setCorreo(correo);
        clienteToEdit.setTelefono(telefono);

        clienteService.crearCliente(clienteToEdit);

        //Ubicando la vista desde resources/templates
        return "redirect:/cliente/";
    }


    @RequestMapping( value = "/mostrar")
    public String mostrarHistorialCompras(Model model, Locale locale, @RequestParam(name = "id") long id){

        Cliente clienteToShow = clienteService.encontrarClientePorId(id);

        model.addAttribute("titulo", "E&J CXA");

        //Aqui mandare las distintas traducciones de i18n al index
        model.addAttribute("clientesi18n", messageSource.getMessage("clientesi18n", null, locale));
        model.addAttribute("equiposi18n", messageSource.getMessage("equiposi18n", null, locale));
        model.addAttribute("negocioi18n", messageSource.getMessage("negocioi18n", null, locale));
        model.addAttribute("comprai18n", messageSource.getMessage("comprai18n", null, locale));
        model.addAttribute("administradori18n", messageSource.getMessage("administradori18n", null, locale));
        model.addAttribute("usuariosi18n", messageSource.getMessage("usuariosi18n", null, locale));
        model.addAttribute("clientealquileri18n", messageSource.getMessage("clientealquileri18n", null, locale));
        model.addAttribute("fechai18n", messageSource.getMessage("fechari18n", null, locale));
        model.addAttribute("fechaevento18n", messageSource.getMessage("fechaeventoi18n", null, locale));
        model.addAttribute("cliente", clienteToShow);
        model.addAttribute("compras", compraService.listarCompras());

        return "/freemarker/mostrarcompras";
    }


    @RequestMapping( value = "/borrar")
    public String eliminarCliente(@RequestParam(name = "id") long id){

        clienteService.eliminarCliente(id);

        return "redirect:/cliente/";
    }
}
