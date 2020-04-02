package rodriguez.johanna.finalavanzada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import rodriguez.johanna.finalavanzada.servicios.SeguridadService;

@SpringBootApplication
public class FinalAvanzadaApplication {

    @Autowired
    private SeguridadService seguridadService;
    public static void main(String[] args) {
        SpringApplication.run(FinalAvanzadaApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        //Creando usuario administrador es la primera url de entrada
        seguridadService.crearUsuarioAdmin();
        seguridadService.defaultCreate();
    }

}
