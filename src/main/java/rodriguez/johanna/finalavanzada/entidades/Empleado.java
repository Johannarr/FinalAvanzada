package rodriguez.johanna.finalavanzada.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Empleado implements Serializable {

    @Id
    @GeneratedValue

    private long id;

    private String nombre;
    private String apellido;
    private String codigo;
    private String direccion;
    private String telefono;
    private String correo;

    public Empleado(String nombre, String apellido, String codigo, String direccion, String telefono, String correo) {

        this.nombre=nombre;
        this.apellido=apellido;
        this.codigo=codigo;
        this.direccion=direccion;
        this.telefono=telefono;
        this.correo=correo;
    }

    public Empleado() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

