package co.com.t_evolvers.tasks.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarLibro implements Task {

    private final String idLibro;

    public ConsultarLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/booking/"+idLibro).with(req -> req
                        .header("Accept", "application/json"))
        );
    }

    public static ConsultarLibro consultar(String idLibro){
        return Tasks.instrumented(ConsultarLibro.class, idLibro);
    }
}
