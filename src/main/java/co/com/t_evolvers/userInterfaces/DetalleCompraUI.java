package co.com.t_evolvers.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DetalleCompraUI {

    public DetalleCompraUI() {
    }

    public static final Target TOTAL_PRODUCTOS = Target.the("Nombre producto").locatedBy("//h3[@class='panel-title']");
    public static final Target MENSAJE_PRODUCTOS = Target.the("Nombre producto").locatedBy("//h2[contains(.,'Products')]");
    public static Target BOTON_DELETE(String id){return Target.the("Boton delete").locatedBy("(//a[contains(.,'Delete')])["+id+"]");}
    public static Target NOMBRE_PRODUCTO(String id){return Target.the("Nombre producto").locatedBy("/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr["+id+"]/td[2]");}

}
