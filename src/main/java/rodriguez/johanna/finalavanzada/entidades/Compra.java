package rodriguez.johanna.finalavanzada.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Compra implements Serializable {

        @Id
        @GeneratedValue
        private Long id;

        @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
        private List<Plan> planes;

        @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
        private Cliente cliente;

        @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
        private Empleado empleado;

        private Date fecha;

        private Date fechaEvento;

        private  int total;

        @Enumerated(EnumType.STRING)
        private Estado estado;


        public Compra() {
        }

        public Compra(List<Plan> planes, Cliente cliente, Empleado empleado, Date fecha, Date fechaEvento, int total,  Estado estado) {
            this.planes = planes;
            this.cliente = cliente;
            this.empleado = empleado;
            this.fecha = fecha;
            this.fechaEvento = fechaEvento;
            this.total = total;
            this.estado = estado;
        }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Plan> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plan> planes) {
        this.planes = planes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Estado getEstado() {
            return estado;
        }

        public void setEstado(Estado estado) {
            this.estado = estado;
        }




}
