package co.com.t_evolvers.tasks.api;

import co.com.t_evolvers.utils.Jsons;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import java.util.List;
import java.util.Map;

public class CrearUsuario implements Task {

    private final List<Map<String, String>> data;

    public CrearUsuario(List<Map<String, String>> dataTable) {
        this.data = dataTable;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = Jsons.jsonCrearUsuario(data);

        actor.attemptsTo(
                Post.to("/auth").with(req -> req
                        .header("Content-Type", "application/json")
                        .body(body))
        );

        actor.remember("token", SerenityRest.lastResponse().path("token").toString());
    }

    public static CrearUsuario crear(List<Map<String, String>> dataTable){
        return Tasks.instrumented(CrearUsuario.class, dataTable);
    }
}
