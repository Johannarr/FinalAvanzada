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
import rodriguez.johanna.finalavanzada.entidades.Cliente;
import rodriguez.johanna.finalavanzada.entidades.Rol;
import rodriguez.johanna.finalavanzada.entidades.Usuario;
import rodriguez.johanna.finalavanzada.servicios.ClienteService;
import rodriguez.johanna.finalavanzada.servicios.UsuarioService;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

@Controller
@RequestMapping("/registrar")
public class RegistroController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private MessageSource messageSource;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @RequestMapping("/cliente")
    public String registro (Model model, Locale locale){
        model.addAttribute("titulo", "E&J CXA");
        model.addAttribute("agregarclientei18n", messageSource.getMessage("agregarclientei18n", null, locale));
        model.addAttribute("nombreusuarioi18n", messageSource.getMessage("nombreusuarioi18n", null, locale));
        model.addAttribute("passwordusuarioi18n", messageSource.getMessage("passwordusuarioi18n", null, locale));
        model.addAttribute("nombreclientei18n", messageSource.getMessage("nombreclientei18n", null, locale));
        model.addAttribute("apellidoclientei18n", messageSource.getMessage("apellidoclientei18n", null, locale));
        model.addAttribute("cedulaclientei18n", messageSource.getMessage("cedulaclientei18n", null, locale));
        model.addAttribute("direccionclientei18n", messageSource.getMessage("direccionclientei18n", null, locale));
        model.addAttribute("telefonoclientei18n", messageSource.getMessage("telefonoclientei18n", null, locale));
        model.addAttribute("correoclientei18n", messageSource.getMessage("correoclientei18n", null, locale));
        model.addAttribute("rolusuarioi18n", messageSource.getMessage("rolusuarioi18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));

        //Mandando los roles a la ventana de crear usuario
        model.addAttribute("roles", usuarioService.listarRoles());

        return "/freemarker/crearcliente";
    }


    @RequestMapping(method = RequestMethod.POST, value = "registrar/crear/cliente")
    public String crearusuario (@RequestParam(name = "username") String username, @RequestParam(name = "password") String password,@RequestParam(name = "nombre")String nombre, @RequestParam(name = "apellido")String apellido, @RequestParam(name = "cedula")String cedula, @RequestParam(name = "telefono")String telefono, @RequestParam(name = "direccion")String direccion,@RequestParam(name = "correo")String correo)throws IOException {
        /*@RequestParam(name = "idRoles") long idRoles*/
        
        Cliente cliente = new Cliente(nombre,apellido,cedula,direccion,telefono,correo);
        // Mando el id para que me busque el rol creado
        Rol rolCreated = usuarioService.encontrarRolPorId(1);

        Usuario usuarioToCreate = new Usuario();
        usuarioToCreate.setUsername(username);

        // Forma correcta de mandarle el rol al usuario
        usuarioToCreate.setRoles(new HashSet<>(Arrays.asList(rolCreated)));

        // Encritando password
        usuarioToCreate.setPassword(passwordEncoder.encode(password));
        usuarioToCreate.setCorreo(correo);
        usuarioToCreate.setActive(true);
        usuarioService.crearUsuario(usuarioToCreate);
        // Inserto usuario
        clienteService.crearCliente(cliente);
        CreatedMail(correo,username,nombre);


        return "redirect:/usuario/";
    }
    public void CreatedMail(@RequestParam(name = "correo") String correo,@RequestParam(name = "username") String username,@RequestParam(name = "nombre")String nombre) throws IOException {

        Email from = new Email("example.marketing@ejmultimedia.com");
        Email to = new Email(correo); // use your own email address here

        String subject = "Welcome To E&J MULTIMEDIA CXA";
        Content content = new Content("text/html",
                "<html> <body> <p><h1>Bienvenido a la Multimedia E&J</h1></p> <p>Señor(ar)" + nombre + " su usuario es:<b> " + username + "</b>.</p>" + " <p>Queremos indicarle que ya su cuenta ha sido habilitada para poder realizar compras.</p>");


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
