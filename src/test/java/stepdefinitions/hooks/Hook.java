package stepdefinitions.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hook {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hook.class);

    @Before
    public void setUp() {
        LOGGER.info("Iniciando sesión");
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario autorizado");
        OnStage.theActorCalled("Usuario no autorizado");
        OnStage.theActorCalled("Usuario con problemas");
    }

}
