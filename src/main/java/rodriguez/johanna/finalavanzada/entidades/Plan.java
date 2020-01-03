package rodriguez.johanna.finalavanzada.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Plan implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private int costo;


    public Plan(String nombre, int costo) {
        this.nombre=nombre;
        this.costo=costo;
    }

    public Plan() {
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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
