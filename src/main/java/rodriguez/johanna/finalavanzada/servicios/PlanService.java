package rodriguez.johanna.finalavanzada.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rodriguez.johanna.finalavanzada.entidades.Empleado;
import rodriguez.johanna.finalavanzada.entidades.Plan;
import rodriguez.johanna.finalavanzada.repositorios.EmpleadoRepositorio;
import rodriguez.johanna.finalavanzada.repositorios.PlanRepositorio;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlanService {

    final PlanRepositorio planRepository;

    public PlanService(PlanRepositorio planRepository) {
        this.planRepository = planRepository;
    }

    public void crearPlan(Plan plan){
        planRepository.save(plan);
    }

    public long cantidadPlanes(){
        return planRepository.count();
    }

    public List<Plan> planList(){
        return planRepository.findAll();
    }

    public Plan planPorId(Long id){
        return planRepository.findById(id).orElse(null);
    }
}
