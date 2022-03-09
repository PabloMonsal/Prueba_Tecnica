package co.com.t_evolvers.interactions;

import co.com.t_evolvers.userInterfaces.DetalleProductoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.valueOf;

public class ValidarProducto implements Interaction {

    public ValidarProducto() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String producto = ValidarProducto.generarProducto(actor);
        actor.attemptsTo(
                Check.whether(valueOf(DetalleProductoUI.PRODUCTO(producto)), isNotVisible())
                        .andIfSo(Scroll.to(DetalleProductoUI.PRODUCTO(producto))),
                Click.on(DetalleProductoUI.PRODUCTO(producto))
        );
    }

    public static ValidarProducto validar(){
        return Tasks.instrumented(ValidarProducto.class);
    }

    private static String generarProducto(Actor actor){
        int random = (int) (Math.random()*4);
        while(!DetalleProductoUI.PRODUCTO(""+random).resolveFor(actor).isVisible()){
            random = (int) (Math.random()*4);
            while(random==0){
                random= (int) (Math.random()*4);
            }
        }
        return ""+random;
    }
}
