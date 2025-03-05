package screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ConfirmationPage extends PageObject {

    public static final Target CONFIRMATION_MESSAGE = Target.the("Mensaje de confirmación de compra")
            .locatedBy("//h2[@class='complete-header']");

}
