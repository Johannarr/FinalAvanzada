package rodriguez.johanna.finalavanzada.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import rodriguez.johanna.finalavanzada.entidades.Empleado;
import rodriguez.johanna.finalavanzada.entidades.Plan;
import rodriguez.johanna.finalavanzada.entidades.Rol;
import rodriguez.johanna.finalavanzada.entidades.Usuario;
import rodriguez.johanna.finalavanzada.repositorios.RolRepositorio;
import rodriguez.johanna.finalavanzada.repositorios.UsuarioRepositorio;

import javax.transaction.Transactional;
import java.util.*;


@Service
public class SeguridadService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private PlanService planService;

    //Para encriptar la información
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Transactional
    public void defaultCreate(){

      /*  //Creacion de cliente por defecto
        Cliente clientePorDefecto = new Cliente("Johanna","Rodriguez","054-2223334","Calle 10","809-578-9669","yohannar.r@hotmail.com");
        Cliente clientePorDefecto2 = new Cliente("Edgar","Nunez","402-3334445","Calle 9","809-577-8989","edgar@gmail.com");
        clienteService.crearCliente(clientePorDefecto);
        clienteService.crearCliente(clientePorDefecto2);*/

        //Creacion de empleados por defecto
        Empleado empleadoPorDefecto = new Empleado("Pedro","Lopez","2020","Calle 10","809-578-9525","pedro@hotmail.com");
        Empleado empleadoPorDefecto2 = new Empleado("Juana","Nunez","2120","Calle 9","809-577-8565","juana@gmail.com");
        empleadoService.crearEmpleado(empleadoPorDefecto);
        empleadoService.crearEmpleado(empleadoPorDefecto2);

        //Creacion de planes por defecto
        Plan plan1 = new Plan("Pre-Boda",1000);
        Plan plan2 = new Plan("Boda",5000);
        Plan plan3 = new Plan("Cumpleanos",3000);
        Plan plan4 = new Plan("Video del evento",4000);
        planService.crearPlan(plan1);
        planService.crearPlan(plan2);
        planService.crearPlan(plan3);
        planService.crearPlan(plan4);
    }

    @Transactional
    public void crearUsuarioAdmin(){
        //creo los roles

        Rol rolClient = new Rol();
        rolClient.setRole("ROLE_CLIENT");
        rolRepositorio.save(rolClient);

        Rol rolAdmin = new Rol("ROLE_ADMIN");
        rolRepositorio.save(rolAdmin);

        Rol rolEmpleado = new Rol("ROLE_EMPLEADO");
        rolRepositorio.save(rolEmpleado);

        Usuario usuarioAdmin = new Usuario();
        usuarioAdmin.setUsername("admin");
        usuarioAdmin.setActive(true);
        usuarioAdmin.setRoles(new HashSet<>(Arrays.asList(rolAdmin)));
        usuarioAdmin.setCorreo("admin@example.com");

        // creo la passwrod, pero tambien la encripto con el password encoder
        usuarioAdmin.setPassword(passwordEncoder.encode("123456"));

        usuarioRepo.save(usuarioAdmin);
    }

    // se necesita implementar este metodo cuando se implementa user details service
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = usuarioRepo.findByUsername(username);

        // el profe lo usa para recorrer roles
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        // Hay que retornar un objeto de tipo userdetails por lo tanto hacemos esto y le mandamos los datos del usuario
        // UserDetails userDetails = new User(usuario.getUsername(),usuario.getPassword(),roles);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), user.isActive(), true, true, true, grantedAuthorities);
    }
}
