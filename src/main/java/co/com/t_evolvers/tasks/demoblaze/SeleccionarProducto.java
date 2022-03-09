package co.com.t_evolvers.tasks.demoblaze;

import co.com.t_evolvers.interactions.GetText;
import co.com.t_evolvers.interactions.ValidarProducto;
import co.com.t_evolvers.userInterfaces.HomeUI;
import co.com.t_evolvers.userInterfaces.DetalleProductoUI;
import co.com.t_evolvers.utils.ClickAlert;
import co.com.t_evolvers.utils.EsperaForzada;
import co.com.t_evolvers.utils.ListProducts;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarProducto implements Task {

    private final WebDriver driver;
    private final Target objetoMenu;

    public SeleccionarProducto(WebDriver driver, Target objetoMenu) {
        this.driver = driver;
        this.objetoMenu = objetoMenu;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for(int i=0;i<2;i++){
            actor.attemptsTo(
                    WaitUntil.the(HomeUI.BOTON_HOME, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(HomeUI.BOTON_HOME),
                    WaitUntil.the(HomeUI.MENU_PHONE, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(objetoMenu),
                    WaitUntil.the(DetalleProductoUI.PRODUCTO("1"), isVisible()).forNoMoreThan(10).seconds(),
                    ValidarProducto.validar(),
                    WaitUntil.the(DetalleProductoUI.NAME_DETAILSPRODUCT, isVisible()).forNoMoreThan(10).seconds()
            );
            ListProducts.agregarProducto(GetText.getText(actor, DetalleProductoUI.NAME_DETAILSPRODUCT), GetText.getTextPrice(actor, DetalleProductoUI.PRICE_DETAILSPRODUCT));
            actor.attemptsTo(Click.on(HomeUI.BOTON_ADDCART));
            EsperaForzada.segundos(1);
            ClickAlert.clickAlert(driver);
        }
    }

    public static SeleccionarProducto seleccionar(WebDriver driver, Target objetoMenu){
        return Tasks.instrumented(SeleccionarProducto.class, driver, objetoMenu);
    }
}
