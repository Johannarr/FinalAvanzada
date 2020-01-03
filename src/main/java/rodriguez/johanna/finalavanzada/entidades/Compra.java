package rodriguez.johanna.finalavanzada.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Compra {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Plan plan;

    private Long usuarioId;
    private Long empleadoId;

    private Date fecha;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Compra() {
    }

    public Compra(Plan plan, Long usuarioId, Long empleadoId, Date fecha, Estado estado) {
        this.plan = plan;
        this.usuarioId = usuarioId;
        this.empleadoId = empleadoId;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
