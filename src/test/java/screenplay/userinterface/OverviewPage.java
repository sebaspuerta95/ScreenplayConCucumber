package screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class OverviewPage extends PageObject {

    public static final Target FINISH_BUTTON = Target.the("Botón para finalizar la compra")
            .locatedBy("//a[text()='FINISH']");

}
