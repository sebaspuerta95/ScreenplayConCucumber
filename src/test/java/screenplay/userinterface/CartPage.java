package screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage extends PageObject {

    public static final Target CHECKOUT_BUTTON = Target.the("Botón de checkout")
            .locatedBy("//a[text()='CHECKOUT']");

    public static Target REMOVE_BUTTON(String productName) {
        return Target.the("Botón para eliminar " + productName + " del carrito")
                .locatedBy("//div[contains(.,'{0}')]/ancestor::div[contains(@class,'cart_item')]//button")
                .of(productName);
    }

}
