package co.com.t_evolvers.stepDefinitions;

import co.com.t_evolvers.tasks.api.ActualizarLibro;
import co.com.t_evolvers.tasks.api.ConsultarLibro;
import co.com.t_evolvers.tasks.api.CrearLibro;
import co.com.t_evolvers.tasks.api.CrearUsuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import java.util.List;
import java.util.Map;

public class APIStepDefinitions {

    Actor user = Actor.named("Usuario");

    public APIStepDefinitions() {
    }

    @Given("El usuario consume la api {string}")
    public void ElUsuarioConsumeLaApi(String api) {
        user.whoCan(CallAnApi.at(api));
    }

    @When("El usuario crea un libro con la data")
    public void elUsuarioCreaUnLibroConLaData(List<Map<String, String>> dataTable) {
        user.attemptsTo(CrearLibro.crear(dataTable));
    }

    @Then("El status de la API es {int}")
    public void elStatusDeLaAPIEs(int status) {
        user.attemptsTo(Ensure.that(SerenityRest.lastResponse().getStatusCode()).isEqualTo(status));
    }

    @When("El usuario consulta el libro creado")
    public void elUsuarioConsultaElLibro() {
        user.attemptsTo(ConsultarLibro.consultar(user.recall("bookId").toString()));
    }

    @When("El usuario consulta el libro {string}")
    public void elUsuarioConsultaElLibro(String idLibro) {
        user.attemptsTo(ConsultarLibro.consultar(idLibro));
    }

    @Then("El data es la correcta")
    public void elStatusDeLaAPIEs(List<Map<String, String>> dataTable) {
        user.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().path("firstname").toString()).isEqualToIgnoringCase(dataTable.get(0).get("firstname")),
                Ensure.that(SerenityRest.lastResponse().path("lastname").toString()).isEqualToIgnoringCase(dataTable.get(0).get("lastname")),
                Ensure.that(SerenityRest.lastResponse().path("totalprice").toString()).isEqualToIgnoringCase(dataTable.get(0).get("totalprice")),
                Ensure.that(SerenityRest.lastResponse().path("depositpaid").toString()).isEqualToIgnoringCase(dataTable.get(0).get("depositpaid")),
                Ensure.that(SerenityRest.lastResponse().path("bookingdates.checkin").toString()).isEqualToIgnoringCase(dataTable.get(0).get("checkin")),
                Ensure.that(SerenityRest.lastResponse().path("bookingdates.checkout").toString()).isEqualToIgnoringCase(dataTable.get(0).get("checkout")),
                Ensure.that(SerenityRest.lastResponse().path("additionalneeds").toString()).isEqualToIgnoringCase(dataTable.get(0).get("additionalneeds"))

        );
    }

    @When("El usuario actualiza el libro creado")
    public void elUsuarioActualizaElLibro(List<Map<String, String>> dataTable) {
        user.attemptsTo(ActualizarLibro.actualizar(dataTable));
    }

    @Given("El usuario crea un usuario")
    public void ElUsuarioConsumeLaApi(List<Map<String, String>> dataTable) {
        user.whoCan(CallAnApi.at("https://restful-booker.herokuapp.com"));
        user.attemptsTo(CrearUsuario.crear(dataTable));
    }
}
