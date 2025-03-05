package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.LoginPage;

public class LoginTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginTask.class);
    private final String username;
    private final String password;

    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    @Step("{0} inicia sesión con usuario '#username' y contraseña '#password'")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Intentando iniciar sesión con usuario: {} y contraseña: {}", username, password);

        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.BUTTON_LOGIN)
        );
    }

    public static LoginTask withCredentials(String username, String password) {
        return Tasks.instrumented(LoginTask.class, username, password);
    }
}
