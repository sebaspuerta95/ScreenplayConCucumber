package screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target USERNAME = Target.the("Campo de usuario")
            .locatedBy("//input[@id='user-name']");

    public static final Target PASSWORD = Target.the("Campo de contraseña")
            .locatedBy("//input[@id='password']");

    public static final Target BUTTON_LOGIN = Target.the("Botón de login")
            .locatedBy("//input[@id='login-button']");

    public static final Target LBL_MESSAGE_ERROR = Target.the("Mensaje de error de usuario bloqueado")
            .locatedBy("//h3[@data-test='error']");

}
