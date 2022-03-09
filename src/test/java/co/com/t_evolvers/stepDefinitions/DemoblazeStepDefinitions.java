package co.com.t_evolvers.stepDefinitions;

import co.com.t_evolvers.questions.ValidacionPrecioTotal;
import co.com.t_evolvers.questions.ValidacionProductos;
import co.com.t_evolvers.tasks.demoblaze.EliminarProducto;
import co.com.t_evolvers.tasks.demoblaze.SeleccionarProducto;
import co.com.t_evolvers.userInterfaces.DetalleCompraUI;
import co.com.t_evolvers.userInterfaces.HomeUI;
import co.com.t_evolvers.utils.ListProducts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.valueOf;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DemoblazeStepDefinitions {

    Actor user = Actor.named("Usuario");

    @Managed
    WebDriver driver;

    public DemoblazeStepDefinitions() {
    }

    @Given("El cliente ingresa a la pagina {string}")
    public void elClienteIngresaALaPagina(String url) {
        user.whoCan(BrowseTheWeb.with(driver));
        user.attemptsTo(Open.url(url));
    }

    @When("El cliente selecciona los productos y los agrega al carrito")
    public void elClienteSeleccionaLosProductosYLosAgregaAlCarrito() {
        user.attemptsTo(
                SeleccionarProducto.seleccionar(driver, HomeUI.MENU_PHONE),
                SeleccionarProducto.seleccionar(driver, HomeUI.MENU_LAPTOPS),
                SeleccionarProducto.seleccionar(driver, HomeUI.MENU_MONITORS)
        );
     }

    @Then("Los productos seleccionados estan en el carrito")
    public void losProductosSeleccionadosEstanEnElCarrito() {
        user.attemptsTo(
                Check.whether(valueOf(DetalleCompraUI.NOMBRE_PRODUCTO("1")), isNotVisible())
                        .andIfSo(Click.on(HomeUI.BOTON_CART)),
                WaitUntil.the(DetalleCompraUI.NOMBRE_PRODUCTO("1"), isVisible()).forNoMoreThan(20).seconds(),
                Ensure.that(ValidacionProductos.validar()).isTrue(),
                Ensure.that(ValidacionPrecioTotal.validar()).isTrue()
        );
        ListProducts.limpiarData();

    }

    @When("El cliente elimina un producto del carrito")
    public void elClienteEliminaUnProductoDelCarrito() {
        user.attemptsTo(
                Click.on(HomeUI.BOTON_CART),
                WaitUntil.the(DetalleCompraUI.NOMBRE_PRODUCTO("1"), isVisible()).forNoMoreThan(20).seconds(),
                EliminarProducto.eliminar()
        );
    }

}
