package co.com.t_evolvers.tasks.demoblaze;

import co.com.t_evolvers.interactions.GetText;
import co.com.t_evolvers.userInterfaces.DetalleCompraUI;
import co.com.t_evolvers.utils.ListProducts;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class EliminarProducto implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        for(int i=0;i<2;i++){
            String id = generarProducto(actor);
            if(ListProducts.eliminarData(GetText.getText(actor, DetalleCompraUI.NOMBRE_PRODUCTO(id)))){
                actor.attemptsTo(Click.on(DetalleCompraUI.BOTON_DELETE(id)));
            }else{
                System.out.println("Item "+DetalleCompraUI.NOMBRE_PRODUCTO(id)+" no encontrado");
            }
        }
    }

    public static EliminarProducto eliminar(){
        return Tasks.instrumented(EliminarProducto.class);
    }

    private static String generarProducto(Actor actor){
        int random = (int) (Math.random()*ListProducts.tamanoData());
        while(!DetalleCompraUI.BOTON_DELETE(""+random).resolveFor(actor).isVisible()){
            random = (int) (Math.random()*ListProducts.tamanoData());
            while(random==0){
                random= (int) (Math.random()*ListProducts.tamanoData());
            }
        }
        return ""+random;
    }
}
