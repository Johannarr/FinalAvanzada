package rodriguez.johanna.finalavanzada.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rodriguez.johanna.finalavanzada.entidades.Rol;
import rodriguez.johanna.finalavanzada.entidades.Usuario;
import rodriguez.johanna.finalavanzada.repositorios.RolRepositorio;
import rodriguez.johanna.finalavanzada.repositorios.UsuarioRepositorio;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    @Autowired
    private RolRepositorio rolRepo;


    @Transactional
    public void crearUsuario(Usuario usuario){

        usuarioRepo.save(usuario);
    }


    public List<Usuario> listarUsuarios(){

        return usuarioRepo.findAll();
    }


    public Usuario encontrarUsuarioPorId(long id){

        return usuarioRepo.findUsuarioById(id);
    }

    public Usuario encontrarUsuarioPorUsername(String username){

        return usuarioRepo.findByUsername(username);
    }

    public void eliminarUsuario(long id){

        Usuario usuarioToDelete = usuarioRepo.findUsuarioById(id);

        usuarioRepo.delete(usuarioToDelete);
    }


    public void crearRol(Rol rol){

        rolRepo.save(rol);
    }


    public List<Rol> listarRoles(){

        return rolRepo.findAll();
    }


    public Rol encontrarRolPorId(long id){

        return rolRepo.findRolById(id);
    }

    public Usuario encontrarUsuarioPorCorreo(String correo){

        return usuarioRepo.findByCorreo(correo);
    }
}
