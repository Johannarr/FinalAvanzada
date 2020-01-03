package rodriguez.johanna.finalavanzada.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Plan implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String descripcion;
    private float precio;

    @Enumerated(EnumType.STRING)
    private TipoPlan tipoPlan;

    public Plan(String nombre, String descripcion, float precio, TipoPlan tipoPlan) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoPlan = tipoPlan;
    }

    public Plan() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public TipoPlan getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(TipoPlan tipoPlan) {
        this.tipoPlan = tipoPlan;
    }
}
