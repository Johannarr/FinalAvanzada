package rodriguez.johanna.finalavanzada.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rodriguez.johanna.finalavanzada.servicios.SeguridadService;

import java.security.Principal;

@Controller
public class IndexController {
    @Autowired
    private SeguridadService seguridadService;


    @RequestMapping("/")
    public String index(Model model, Principal principal ){

        //Creando usuario administrador es la primera url de entrada

        seguridadService.crearUsuarioAdmin();

        model.addAttribute("titulo", "MULTIMEDIA CXA");

        //Aqui redirecciono hacia cliente, realiza la creacion pero es invisibl al usuario
        return "redirect:/usuario/";
    }

    //Aqui manejo indico el login de mi aplicacion y trabajo en conjunto con la configuracion de seguridad
    @RequestMapping("/login")
    public String login(){

        return "/freemarker/login";
    }
}
