package co.com.t_evolvers.questions;

import co.com.t_evolvers.interactions.GetText;
import co.com.t_evolvers.userInterfaces.DetalleCompraUI;
import co.com.t_evolvers.utils.ListProducts;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

public class ValidacionProductos implements Question<Boolean>{

    private static final Boolean[] result= new Boolean[10];

    @Override
    public Boolean answeredBy(Actor actor) {
        int count = 0;
        actor.attemptsTo(Scroll.to(DetalleCompraUI.MENSAJE_PRODUCTOS));
        for(int i = 0; i< ListProducts.tamanoData(); i++){
            result[count] = ListProducts.obtenerData(GetText.getText(actor, DetalleCompraUI.NOMBRE_PRODUCTO(""+(i+1))));
            count++;
        }
        return recorrerResultado();
    }

    public static ValidacionProductos validar(){
        return new ValidacionProductos();
    }

    private static Boolean recorrerResultado(){
        for(int i=0; i<ListProducts.tamanoData(); i++){
            if(result[i] != null){
                if(!result[i]){
                    return false;
                }
            }
        }
        return true;
    }
}
