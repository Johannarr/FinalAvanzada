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

    @Autowired
    private PlanRepositorio planRepo;


    @Transactional
    public void crearPlan(Plan plan){

        planRepo.save(plan);
    }


    public List<Plan> listarPlanes(){

        return planRepo.findAll();
    }


    public Plan encontrarPlanPorId(long id){

        return planRepo.findPlanById(id);
    }


    public void eliminarPlan(long id){

        Plan planToDelete = planRepo.findPlanById(id);

        planRepo.delete(planToDelete);
    }
}
