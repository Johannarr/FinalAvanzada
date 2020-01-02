package rodriguez.johanna.finalavanzada.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import com.sendgrid.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rodriguez.johanna.finalavanzada.entidades.Rol;
import rodriguez.johanna.finalavanzada.entidades.Usuario;
import rodriguez.johanna.finalavanzada.servicios.ClienteService;
import rodriguez.johanna.finalavanzada.servicios.PlanService;
import rodriguez.johanna.finalavanzada.servicios.UsuarioService;

import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

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
        model.addAttribute("listausuarioi18n", messageSource.getMessage("listausuarioi18n", null, locale));
        model.addAttribute("agregarusuarioi18n", messageSource.getMessage("agregarusuarioi18n", null, locale));
        model.addAttribute("nombreusuarioi18n", messageSource.getMessage("nombreusuarioi18n", null, locale));
        model.addAttribute("activousuarioi18n", messageSource.getMessage("activousuarioi18n", null, locale));

        model.addAttribute("usuarios", usuarioService.listarUsuarios());

        model.addAttribute("usuario", principal.getName());

        return "/freemarker/usuario";
    }


    @RequestMapping("/creacion")
    public String creacionUsuario(Model model, Locale locale){

        model.addAttribute("titulo", "E&J CXA");
        model.addAttribute("agregarusuarioi18n", messageSource.getMessage("agregarusuarioi18n", null, locale));
        model.addAttribute("nombreusuarioi18n", messageSource.getMessage("nombreusuarioi18n", null, locale));
        model.addAttribute("passwordusuarioi18n", messageSource.getMessage("passwordusuarioi18n", null, locale));
        model.addAttribute("rolusuarioi18n", messageSource.getMessage("rolusuarioi18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));

        //Mandando los roles a la ventana de crear usuario
        model.addAttribute("roles", usuarioService.listarRoles());

        return "/freemarker/crearusuario";
    }


    @RequestMapping( value = "/crear", method = RequestMethod.POST)
    public String crearUsuario(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(name = "idRoles") long idRoles )throws IOException{

        // Mando el id para que me busque el rol creado
        Rol rolCreated = usuarioService.encontrarRolPorId(idRoles);

        Usuario usuarioToCreate = new Usuario();
        usuarioToCreate.setUsername(username);

        // Forma correcta de mandarle el rol al usuario
        usuarioToCreate.setRoles(new HashSet<>(Arrays.asList(rolCreated)));

        // Encritando password
        usuarioToCreate.setPassword(passwordEncoder.encode(password));

        usuarioToCreate.setActive(true);

        // Inserto cliente
        usuarioService.crearUsuario(usuarioToCreate);
        CreatedMail(username);

        return "redirect:/usuario/";
    }

    @RequestMapping("/borrar")
    public String eliminarUsuario(@RequestParam(name = "id") long id){

        usuarioService.eliminarUsuario(id);

        return "redirect:/usuario/";
    }

    public void CreatedMail(@RequestParam(name = "username") String username) throws IOException {

        String correo = username;
        Email from = new Email("ej-multimedia@info.com");
        Email to = new Email(correo); // use your own email address here

        String subject = "Welcome To E&J MULTIMEDIA CXA";
        Content content = new Content("text/html", "Bienvenido a la Multimedia E&J su usuario es: " +username+ ". Que cuenta con una contraseña encriptada." +
                "Click aquí para volver al sistema.");


        Mail mail = new Mail(from, subject, to, content);
        System.out.println(mail);
        SendGrid sg = new SendGrid((System.getenv("SENDGRID_API_KEY")););
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
