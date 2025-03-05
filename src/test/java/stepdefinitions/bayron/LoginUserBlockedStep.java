package stepdefinitions.bayron;

import constantes.Constantes;
import screenplay.hook.OpenBrowser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.questions.bayron.ValidateMessageError;
import screenplay.tasks.LoginTask;
import screenplay.userinterface.LoginPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserBlockedStep {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserBlockedStep.class);
    private static final String ACTOR_NAME = "Usuario";

    @Dado("que el usuario intentó iniciar sesión con Username {string} y Password {string}")
    public void queElUsuarioIntentoInicioSesion(String username, String password) {
        LOGGER.info("El usuario '{}' intenta iniciar sesión.", username);
        OnStage.theActorCalled(ACTOR_NAME)
                .attemptsTo(OpenBrowser.openURL(Constantes.WEB_URL),
                        LoginTask.withCredentials(username, password),
                        Click.on(LoginPage.BUTTON_LOGIN)
                );
    }

    @Cuando("se verifica el mensaje de error")
    public void esperaAMensajeDeError() {

    }

    @Entonces("se mostrará el mensaje {string}")
    public void mensajeDeError(String message) {
        OnStage.theActorCalled(ACTOR_NAME).should(seeThat(ValidateMessageError.es(), equalTo(message)));
    }

}
