package screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ProductPage extends PageObject {

    public static Target ADD_TO_CART(String productName) {
        return Target.the("Botón para agregar al carrito: " + productName)
                .locatedBy("//div[contains(.,'{0}')]/ancestor::div[contains(@class,'inventory_item')]//button")
                .of(productName);
    }

    public static final Target SORT_DROPDOWN = Target.the("Filtrar opciones")
            .locatedBy("//select[@class='product_sort_container']");

    public static final Target CART_BUTTON = Target.the("Botón de carrito")
            .locatedBy("//a[@href='./cart.html']");

    public static final Target PRODUCT_IMAGES = Target.the("Imagen de los productos")
            .locatedBy(".inventory_item_img img");

    public static final Target PRODUCT_TITLE = Target.the("Título de la sección de productos")
            .locatedBy("//div[text()='Products']");

}
