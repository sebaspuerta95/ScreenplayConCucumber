package screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PersonalInfoPage extends PageObject {

    public static final Target FIRST_NAME_FIELD = Target.the("Campo de nombre")
            .locatedBy("//input[@id='first-name']");

    public static final Target LAST_NAME_FIELD = Target.the("Campo de apellido")
            .locatedBy("//input[@id='last-name']");

    public static final Target POSTAL_CODE_FIELD = Target.the("Campo de código postal")
            .locatedBy("//input[@id='postal-code']");

    public static final Target CONTINUE_BUTTON = Target.the("Botón para continuar con la compra")
            .locatedBy("//input[@value='CONTINUE']");

}
