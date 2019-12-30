package rodriguez.johanna.finalavanzada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rodriguez.johanna.finalavanzada.entidades.Plan;

@Repository
public interface PlanRepositorio extends JpaRepository <Plan, Long> {

    Plan findPlanById(long id);
}
