package rodriguez.johanna.finalavanzada.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rodriguez.johanna.finalavanzada.servicios.ClienteService;
import rodriguez.johanna.finalavanzada.servicios.CompraService;
import rodriguez.johanna.finalavanzada.servicios.UsuarioService;

import java.security.Principal;
import java.util.Locale;

@Controller
@RequestMapping("/prueba")
public class Prueba {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CompraService compraService;

    //Instancio esta dependencia para la internacionalizacion
    @Autowired
    private MessageSource messageSource;
    @RequestMapping("/")
    public String index(Model model, Principal principal, Locale locale){

       /* model.addAttribute("titulo", "E&J CXA");
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

        model.addAttribute("usuario", principal.getName());*/

        return "/freemarker/factura";
    }
}
