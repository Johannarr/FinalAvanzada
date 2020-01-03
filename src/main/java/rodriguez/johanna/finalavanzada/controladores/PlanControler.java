/*
package rodriguez.johanna.finalavanzada.controladores;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rodriguez.johanna.finalavanzada.entidades.Plan;
import rodriguez.johanna.finalavanzada.servicios.PlanService;


import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;


@Controller
@RequestMapping ("/plan")
public class PlanControler {


    @Autowired
    private PlanService planService;

    @Autowired
    private MessageSource messageSource;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @RequestMapping("/")
    public String index(Model model, Principal principal, Locale locale){

        model.addAttribute("titulo", "MULTIMEDIA CXA");
        model.addAttribute("clientesi18n", messageSource.getMessage("clientesi18n", null, locale));
        model.addAttribute("administradori18n", messageSource.getMessage("administradori18n", null, locale));
        model.addAttribute("usuariosi18n", messageSource.getMessage("usuariosi18n", null, locale));
        model.addAttribute("opcionei18n", messageSource.getMessage("opcionei18n", null, locale));
        model.addAttribute("listaplani18n", messageSource.getMessage("listaplani18n", null, locale));
        model.addAttribute("listausuarioi18n", messageSource.getMessage("listausuarioi18n", null, locale));
        model.addAttribute("agregarplani18n", messageSource.getMessage("agregarplani18n", null, locale));
        model.addAttribute("nombreplani18n", messageSource.getMessage("nombreplani18n", null, locale));
        model.addAttribute("costoplani18n", messageSource.getMessage("costoplani18n", null, locale));

        model.addAttribute("planes", planService.listarPlanes());

        model.addAttribute("plan", principal.getName());

        // Mando a vista el nombre del usuario que esta logeado mediante principal consigo esos datos
        model.addAttribute("usuario", principal.getName());

        return "/freemarker/plan";
    }


    @RequestMapping("/creacion")
    public String creacionPlan(Model model, Locale locale){

        model.addAttribute("titulo", "E&J CXA");
        model.addAttribute("agregarplani18n", messageSource.getMessage("agregarusuarioi18n", null, locale));
        model.addAttribute("nombreplani18n", messageSource.getMessage("nombreplani18n", null, locale));
        model.addAttribute("costoplani18n", messageSource.getMessage("costoplani18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));

        return "/freemarker/crearplan";
    }


    @RequestMapping( value = "/crear", method = RequestMethod.POST)
    public String crearPlan(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "costo") int costo)throws IOException {

        Plan planToCreate = new Plan(nombre,costo);
        planService.crearPlan(planToCreate);

        return "redirect:/plan/";
    }

    @RequestMapping("/borrar")
    public String eliminarPlan(@RequestParam(name = "id") long id){

        planService.eliminarPlan(id);

        return "redirect:/plan/";
    }

}
*/
