package co.com.t_evolvers.tasks.api;

import co.com.t_evolvers.utils.Jsons;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import java.util.List;
import java.util.Map;

public class ActualizarLibro implements Task {

    private final List<Map<String, String>> data;

    public ActualizarLibro(List<Map<String, String>> dataTable) {
        this.data = dataTable;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = Jsons.jsonCrearLibro(data);

        actor.attemptsTo(
                Put.to("/booking/"+ actor.recall("bookId").toString()).with(req -> req
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .header("Cookie", "token="+actor.recall("token").toString())
                        .body(body))
        );
    }

    public static ActualizarLibro actualizar(List<Map<String, String>> dataTable){
        return Tasks.instrumented(ActualizarLibro.class, dataTable);
    }
}
