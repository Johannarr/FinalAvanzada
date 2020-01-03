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

    // Relacion mucho a mucho
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Plan> planes;


    public Paquete(List<Plan> planes, int total) {

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
