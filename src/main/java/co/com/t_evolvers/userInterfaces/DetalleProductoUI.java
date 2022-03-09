package co.com.t_evolvers.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DetalleProductoUI {

    public DetalleProductoUI() {
    }

    public static final Target NAME_DETAILSPRODUCT = Target.the("Nombre del producto").locatedBy("//h2[@class='name']");
    public static final Target PRICE_DETAILSPRODUCT = Target.the("Precio del producto").locatedBy("//h3[@class='price-container']");
    public static Target PRODUCTO(String prod){return Target.the("Producto numero "+prod).locatedBy("(//a[@class='hrefch'])["+prod+"]");}

}
