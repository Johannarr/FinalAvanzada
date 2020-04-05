package rodriguez.johanna.finalavanzada.entidades;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private long id;

    // El @ column me quita el error de que se creen dos usuarios, con esto se evitan que se cree, pero en la vista me tira
    // un error, pero aun asi el programa seguira funcionando correctamente, esta es una solucion temporal
    @Column(name="username", unique=true)
    private String username;
    private String password;
    private boolean active;
    private String correo;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private
    Set<Rol> roles;

    public Usuario(){ }

    public Usuario(String username, String password, boolean active,String correo, Set<Rol> roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.correo = correo;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }



}
