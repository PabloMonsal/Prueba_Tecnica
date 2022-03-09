package co.com.t_evolvers.questions;

import co.com.t_evolvers.interactions.GetText;
import co.com.t_evolvers.userInterfaces.DetalleCompraUI;
import co.com.t_evolvers.utils.ListProducts;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

public class ValidacionPrecioTotal implements Question<Boolean> {

    public ValidacionPrecioTotal() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String precioTotal = ListProducts.precioTotal();
        actor.attemptsTo(Scroll.to(DetalleCompraUI.TOTAL_PRODUCTOS));
        return GetText.getText(actor, DetalleCompraUI.TOTAL_PRODUCTOS).equals(precioTotal);
    }

    public static ValidacionPrecioTotal validar(){
        return new ValidacionPrecioTotal();
    }
}
