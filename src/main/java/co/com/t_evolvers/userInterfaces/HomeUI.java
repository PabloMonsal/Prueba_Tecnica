package co.com.t_evolvers.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {

    public HomeUI() {
    }

    public static final Target MENU_PHONE = Target.the("Boton phone del menu principal").locatedBy("//a[contains(.,'Phones')]");
    public static final Target MENU_LAPTOPS = Target.the("Boton laptops del menu principal").locatedBy("//a[contains(.,'Laptops')]");
    public static final Target MENU_MONITORS = Target.the("Boton laptops del menu principal").locatedBy("//a[contains(.,'Monitors')]");
    public static final Target BOTON_ADDCART = Target.the("Boton agregar al carrito").locatedBy("//a[contains(.,'Add to cart')]");
    public static final Target BOTON_CART = Target.the("Boton carrito").locatedBy("//a[contains(.,'Cart')]");
    public static final Target BOTON_HOME = Target.the("Boton home").locatedBy("//a[contains(.,'Home (current)')]");

}
