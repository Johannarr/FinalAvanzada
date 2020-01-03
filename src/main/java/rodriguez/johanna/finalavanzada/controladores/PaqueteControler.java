package rodriguez.johanna.finalavanzada.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import rodriguez.johanna.finalavanzada.entidades.Paquete;
import rodriguez.johanna.finalavanzada.entidades.Plan;
import rodriguez.johanna.finalavanzada.servicios.PaqueteService;
import rodriguez.johanna.finalavanzada.servicios.PlanService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/paquete")
public class PaqueteControler {

    @Autowired
    private PaqueteService paqueteService;

    @Autowired
    private PlanService planService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping("/")
    public String index(Model model, Principal principal, Locale locale){

        model.addAttribute("clientesi18n", messageSource.getMessage("clientesi18n", null, locale));
        model.addAttribute("equiposi18n", messageSource.getMessage("equiposi18n", null, locale));
        model.addAttribute("negocioi18n", messageSource.getMessage("negocioi18n", null, locale));
        model.addAttribute("comprai18n", messageSource.getMessage("comprai18n", null, locale));
        model.addAttribute("planesi18n", messageSource.getMessage("planesi18n", null, locale));
        model.addAttribute("administradori18n", messageSource.getMessage("administradori18n", null, locale));
        model.addAttribute("usuariosi18n", messageSource.getMessage("usuariosi18n", null, locale));
        model.addAttribute("listapaquetei18n", messageSource.getMessage("listapaquetei18n", null, locale));
        model.addAttribute("agregarpaquetei18n", messageSource.getMessage("agregarpaquetei18n", null, locale));
        model.addAttribute("totalpaquetei18n", messageSource.getMessage("totalpaquetei18n", null, locale));
        model.addAttribute("opcionei18n", messageSource.getMessage("opcionei18n", null, locale));
        model.addAttribute("titulo", "E&J CXA");

        model.addAttribute("paquetes", paqueteService.listarPaquetes());

        model.addAttribute("usuario", principal.getName());

        return "/freemarker/paquete";
    }


    @RequestMapping("/creacion")
    public String creacionPaquete(Model model, Locale locale){

        model.addAttribute("agregarpaquetei18n", messageSource.getMessage("agregarpaquetei18n", null, locale));
        model.addAttribute("planesi18n", messageSource.getMessage("planesi18n", null, locale));

        model.addAttribute("titulo", "E&J CXA");

        model.addAttribute("planes", planService.listarPlanes());

        return "/freemarker/crearpaquete";
    }


    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearPaquete( @RequestParam(name = "idPlanes" , required = false) List<Long> idPlanes, @RequestParam(name = "total") int total ){

        List<Plan> listaPlanes = new ArrayList<>();

        Paquete paqueteToCreate = new Paquete(listaPlanes, total);

        paqueteService.crearPaquete(paqueteToCreate);

        return "redirect:/paquete/";
    }


    @RequestMapping("/borrar")
    public String eliminarPaquete(@RequestParam(name = "id") long id){

        paqueteService.eliminarPaquete(id);

        return "redirect:/paquete";
    }
}
