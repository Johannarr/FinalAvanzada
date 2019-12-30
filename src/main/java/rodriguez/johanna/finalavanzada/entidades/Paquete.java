package rodriguez.johanna.finalavanzada.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Paquete implements Serializable {

    @Id
    @GeneratedValue

    private long id;

    private int total;

    // Relacion uno a mucho
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Cliente cliente;

    // Relacion mucho a mucho
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Plan> planes;


    public Paquete(Cliente cliente, List<Plan> planes, int total) {

        this.cliente = cliente;
        this.planes = planes;
        this.total = total;
    }

    public Paquete() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Plan> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plan> palnes) {
        this.planes = palnes;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }






}
