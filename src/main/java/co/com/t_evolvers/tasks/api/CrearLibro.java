package co.com.t_evolvers.tasks.api;

import co.com.t_evolvers.utils.Jsons;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import java.util.List;
import java.util.Map;


public class CrearLibro implements Task{

    private final List<Map<String, String>> data;

    public CrearLibro(List<Map<String, String>> dataTable) {
        this.data = dataTable;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = Jsons.jsonCrearLibro(data);

        actor.attemptsTo(
                Post.to("/booking").with(req -> req
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .body(body))
        );

        if(SerenityRest.lastResponse().statusCode() == 200){
            actor.remember("bookId", SerenityRest.lastResponse().path("bookingid").toString());
        }

    }

    public static CrearLibro crear(List<Map<String, String>> dataTable){
        return Tasks.instrumented(CrearLibro.class, dataTable);
    }
}
