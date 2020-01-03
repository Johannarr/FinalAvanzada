package rodriguez.johanna.finalavanzada.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rodriguez.johanna.finalavanzada.entidades.Plan;
import rodriguez.johanna.finalavanzada.servicios.PlanService;

import java.util.List;

@RestController()
@RequestMapping(path = "/plan")
public class PlanController {
    final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<Plan>> listaPlan() {
        return new ResponseEntity<>(planService.planList(), HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Plan> crearPlan(@RequestBody Plan plan) {
        planService.crearPlan(plan);
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Plan> planPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(planService.planPorId(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/cantidad", method = RequestMethod.GET)
    public long cantidadPlanes() {
        return planService.cantidadPlanes();
    }
}
